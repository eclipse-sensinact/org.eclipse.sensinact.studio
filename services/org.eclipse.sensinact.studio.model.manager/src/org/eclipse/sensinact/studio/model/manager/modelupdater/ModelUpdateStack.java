/**
 * 
 */
package org.eclipse.sensinact.studio.model.manager.modelupdater;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */
public class ModelUpdateStack extends AbstractList<ModelUpdate<?>> {

	List<ModelUpdate<?>> stack;
	
	public ModelUpdateStack() {
		super();
		this.stack = Collections.synchronizedList(new ArrayList<ModelUpdate<?>>());
	}
	
	@Override
	public ModelUpdate<?> get(int index) {
		return this.stack.get(index);
	}
	
	public boolean add(ModelUpdate<?> mu){
		if(mu == null)
			return false;
        if(mu.complete()){
        	mu.apply();
        	return true;
        }
		synchronized (stack){			
	        Iterator<ModelUpdate<?>> i = stack.iterator(); 
	        while (i.hasNext()){
	    	    ModelUpdate<?> model = i.next();
	            if(model.addNext(mu)){
	        	    if(model.complete()){
	        		    model.apply();
	        		    i.remove();
	        	   }
	        	   return true;
	            } if(mu.addNext(model)){
 	        	   i.remove();
 	               if(mu.complete()){
 	        	       mu.apply();
 	        	       return true;
 	               }
 	        	   break;
	            }
	        }
		}
	    return stack.add(mu);
	}

	@Override
	public int size() {
		return this.stack.size();
	}
}
