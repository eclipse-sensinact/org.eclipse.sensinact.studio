/**
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.language.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.sensinact.studio.language.services.SensinactGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSensinactParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_BOOLEAN", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'act'", "'set'", "'resource'", "'='", "'['", "'/'", "']'", "'on'", "','", "'end if'", "'if'", "'do'", "'else if'", "'else do'", "'.'", "'subscribe'", "'('", "')'", "'define'", "'after'", "'before'", "'coincide'", "'min'", "'max'", "'avg'", "'sum'", "'count'", "'sec'", "'or'", "'and'", "'!='", "'=='", "'>'", "'>='", "'<'", "'<='", "'+'", "'-'", "'*'", "'%'", "'.get()'", "'not'"
    };
    public static final int T__50=50;
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalSensinactParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSensinactParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSensinactParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSensinact.g"; }


    	private SensinactGrammarAccess grammarAccess;

    	public void setGrammarAccess(SensinactGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleSensinact"
    // InternalSensinact.g:53:1: entryRuleSensinact : ruleSensinact EOF ;
    public final void entryRuleSensinact() throws RecognitionException {
        try {
            // InternalSensinact.g:54:1: ( ruleSensinact EOF )
            // InternalSensinact.g:55:1: ruleSensinact EOF
            {
             before(grammarAccess.getSensinactRule()); 
            pushFollow(FOLLOW_1);
            ruleSensinact();

            state._fsp--;

             after(grammarAccess.getSensinactRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSensinact"


    // $ANTLR start "ruleSensinact"
    // InternalSensinact.g:62:1: ruleSensinact : ( ( rule__Sensinact__Group__0 ) ) ;
    public final void ruleSensinact() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:66:2: ( ( ( rule__Sensinact__Group__0 ) ) )
            // InternalSensinact.g:67:2: ( ( rule__Sensinact__Group__0 ) )
            {
            // InternalSensinact.g:67:2: ( ( rule__Sensinact__Group__0 ) )
            // InternalSensinact.g:68:3: ( rule__Sensinact__Group__0 )
            {
             before(grammarAccess.getSensinactAccess().getGroup()); 
            // InternalSensinact.g:69:3: ( rule__Sensinact__Group__0 )
            // InternalSensinact.g:69:4: rule__Sensinact__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Sensinact__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSensinactAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSensinact"


    // $ANTLR start "entryRuleDSL_SENSINACT"
    // InternalSensinact.g:78:1: entryRuleDSL_SENSINACT : ruleDSL_SENSINACT EOF ;
    public final void entryRuleDSL_SENSINACT() throws RecognitionException {
        try {
            // InternalSensinact.g:79:1: ( ruleDSL_SENSINACT EOF )
            // InternalSensinact.g:80:1: ruleDSL_SENSINACT EOF
            {
             before(grammarAccess.getDSL_SENSINACTRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_SENSINACT();

            state._fsp--;

             after(grammarAccess.getDSL_SENSINACTRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_SENSINACT"


    // $ANTLR start "ruleDSL_SENSINACT"
    // InternalSensinact.g:87:1: ruleDSL_SENSINACT : ( ( rule__DSL_SENSINACT__Group__0 ) ) ;
    public final void ruleDSL_SENSINACT() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:91:2: ( ( ( rule__DSL_SENSINACT__Group__0 ) ) )
            // InternalSensinact.g:92:2: ( ( rule__DSL_SENSINACT__Group__0 ) )
            {
            // InternalSensinact.g:92:2: ( ( rule__DSL_SENSINACT__Group__0 ) )
            // InternalSensinact.g:93:3: ( rule__DSL_SENSINACT__Group__0 )
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getGroup()); 
            // InternalSensinact.g:94:3: ( rule__DSL_SENSINACT__Group__0 )
            // InternalSensinact.g:94:4: rule__DSL_SENSINACT__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_SENSINACT__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_SENSINACTAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_SENSINACT"


    // $ANTLR start "entryRuleDSL_Resource"
    // InternalSensinact.g:103:1: entryRuleDSL_Resource : ruleDSL_Resource EOF ;
    public final void entryRuleDSL_Resource() throws RecognitionException {
        try {
            // InternalSensinact.g:104:1: ( ruleDSL_Resource EOF )
            // InternalSensinact.g:105:1: ruleDSL_Resource EOF
            {
             before(grammarAccess.getDSL_ResourceRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_Resource();

            state._fsp--;

             after(grammarAccess.getDSL_ResourceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_Resource"


    // $ANTLR start "ruleDSL_Resource"
    // InternalSensinact.g:112:1: ruleDSL_Resource : ( ( rule__DSL_Resource__Group__0 ) ) ;
    public final void ruleDSL_Resource() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:116:2: ( ( ( rule__DSL_Resource__Group__0 ) ) )
            // InternalSensinact.g:117:2: ( ( rule__DSL_Resource__Group__0 ) )
            {
            // InternalSensinact.g:117:2: ( ( rule__DSL_Resource__Group__0 ) )
            // InternalSensinact.g:118:3: ( rule__DSL_Resource__Group__0 )
            {
             before(grammarAccess.getDSL_ResourceAccess().getGroup()); 
            // InternalSensinact.g:119:3: ( rule__DSL_Resource__Group__0 )
            // InternalSensinact.g:119:4: rule__DSL_Resource__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_Resource"


    // $ANTLR start "entryRuleDSL_On"
    // InternalSensinact.g:128:1: entryRuleDSL_On : ruleDSL_On EOF ;
    public final void entryRuleDSL_On() throws RecognitionException {
        try {
            // InternalSensinact.g:129:1: ( ruleDSL_On EOF )
            // InternalSensinact.g:130:1: ruleDSL_On EOF
            {
             before(grammarAccess.getDSL_OnRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_On();

            state._fsp--;

             after(grammarAccess.getDSL_OnRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_On"


    // $ANTLR start "ruleDSL_On"
    // InternalSensinact.g:137:1: ruleDSL_On : ( ( rule__DSL_On__Group__0 ) ) ;
    public final void ruleDSL_On() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:141:2: ( ( ( rule__DSL_On__Group__0 ) ) )
            // InternalSensinact.g:142:2: ( ( rule__DSL_On__Group__0 ) )
            {
            // InternalSensinact.g:142:2: ( ( rule__DSL_On__Group__0 ) )
            // InternalSensinact.g:143:3: ( rule__DSL_On__Group__0 )
            {
             before(grammarAccess.getDSL_OnAccess().getGroup()); 
            // InternalSensinact.g:144:3: ( rule__DSL_On__Group__0 )
            // InternalSensinact.g:144:4: rule__DSL_On__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_On__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_OnAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_On"


    // $ANTLR start "entryRuleDSL_ECA_STATEMENT"
    // InternalSensinact.g:153:1: entryRuleDSL_ECA_STATEMENT : ruleDSL_ECA_STATEMENT EOF ;
    public final void entryRuleDSL_ECA_STATEMENT() throws RecognitionException {
        try {
            // InternalSensinact.g:154:1: ( ruleDSL_ECA_STATEMENT EOF )
            // InternalSensinact.g:155:1: ruleDSL_ECA_STATEMENT EOF
            {
             before(grammarAccess.getDSL_ECA_STATEMENTRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_ECA_STATEMENT();

            state._fsp--;

             after(grammarAccess.getDSL_ECA_STATEMENTRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_ECA_STATEMENT"


    // $ANTLR start "ruleDSL_ECA_STATEMENT"
    // InternalSensinact.g:162:1: ruleDSL_ECA_STATEMENT : ( ( rule__DSL_ECA_STATEMENT__Group__0 ) ) ;
    public final void ruleDSL_ECA_STATEMENT() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:166:2: ( ( ( rule__DSL_ECA_STATEMENT__Group__0 ) ) )
            // InternalSensinact.g:167:2: ( ( rule__DSL_ECA_STATEMENT__Group__0 ) )
            {
            // InternalSensinact.g:167:2: ( ( rule__DSL_ECA_STATEMENT__Group__0 ) )
            // InternalSensinact.g:168:3: ( rule__DSL_ECA_STATEMENT__Group__0 )
            {
             before(grammarAccess.getDSL_ECA_STATEMENTAccess().getGroup()); 
            // InternalSensinact.g:169:3: ( rule__DSL_ECA_STATEMENT__Group__0 )
            // InternalSensinact.g:169:4: rule__DSL_ECA_STATEMENT__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ECA_STATEMENT__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ECA_STATEMENTAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_ECA_STATEMENT"


    // $ANTLR start "entryRuleDSL_IfDo"
    // InternalSensinact.g:178:1: entryRuleDSL_IfDo : ruleDSL_IfDo EOF ;
    public final void entryRuleDSL_IfDo() throws RecognitionException {
        try {
            // InternalSensinact.g:179:1: ( ruleDSL_IfDo EOF )
            // InternalSensinact.g:180:1: ruleDSL_IfDo EOF
            {
             before(grammarAccess.getDSL_IfDoRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_IfDo();

            state._fsp--;

             after(grammarAccess.getDSL_IfDoRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_IfDo"


    // $ANTLR start "ruleDSL_IfDo"
    // InternalSensinact.g:187:1: ruleDSL_IfDo : ( ( rule__DSL_IfDo__Group__0 ) ) ;
    public final void ruleDSL_IfDo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:191:2: ( ( ( rule__DSL_IfDo__Group__0 ) ) )
            // InternalSensinact.g:192:2: ( ( rule__DSL_IfDo__Group__0 ) )
            {
            // InternalSensinact.g:192:2: ( ( rule__DSL_IfDo__Group__0 ) )
            // InternalSensinact.g:193:3: ( rule__DSL_IfDo__Group__0 )
            {
             before(grammarAccess.getDSL_IfDoAccess().getGroup()); 
            // InternalSensinact.g:194:3: ( rule__DSL_IfDo__Group__0 )
            // InternalSensinact.g:194:4: rule__DSL_IfDo__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_IfDo__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_IfDoAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_IfDo"


    // $ANTLR start "entryRuleDSL_ElseIfDo"
    // InternalSensinact.g:203:1: entryRuleDSL_ElseIfDo : ruleDSL_ElseIfDo EOF ;
    public final void entryRuleDSL_ElseIfDo() throws RecognitionException {
        try {
            // InternalSensinact.g:204:1: ( ruleDSL_ElseIfDo EOF )
            // InternalSensinact.g:205:1: ruleDSL_ElseIfDo EOF
            {
             before(grammarAccess.getDSL_ElseIfDoRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_ElseIfDo();

            state._fsp--;

             after(grammarAccess.getDSL_ElseIfDoRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_ElseIfDo"


    // $ANTLR start "ruleDSL_ElseIfDo"
    // InternalSensinact.g:212:1: ruleDSL_ElseIfDo : ( ( rule__DSL_ElseIfDo__Group__0 ) ) ;
    public final void ruleDSL_ElseIfDo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:216:2: ( ( ( rule__DSL_ElseIfDo__Group__0 ) ) )
            // InternalSensinact.g:217:2: ( ( rule__DSL_ElseIfDo__Group__0 ) )
            {
            // InternalSensinact.g:217:2: ( ( rule__DSL_ElseIfDo__Group__0 ) )
            // InternalSensinact.g:218:3: ( rule__DSL_ElseIfDo__Group__0 )
            {
             before(grammarAccess.getDSL_ElseIfDoAccess().getGroup()); 
            // InternalSensinact.g:219:3: ( rule__DSL_ElseIfDo__Group__0 )
            // InternalSensinact.g:219:4: rule__DSL_ElseIfDo__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ElseIfDo__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ElseIfDoAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_ElseIfDo"


    // $ANTLR start "entryRuleDSL_ElseDo"
    // InternalSensinact.g:228:1: entryRuleDSL_ElseDo : ruleDSL_ElseDo EOF ;
    public final void entryRuleDSL_ElseDo() throws RecognitionException {
        try {
            // InternalSensinact.g:229:1: ( ruleDSL_ElseDo EOF )
            // InternalSensinact.g:230:1: ruleDSL_ElseDo EOF
            {
             before(grammarAccess.getDSL_ElseDoRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_ElseDo();

            state._fsp--;

             after(grammarAccess.getDSL_ElseDoRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_ElseDo"


    // $ANTLR start "ruleDSL_ElseDo"
    // InternalSensinact.g:237:1: ruleDSL_ElseDo : ( ( rule__DSL_ElseDo__Group__0 ) ) ;
    public final void ruleDSL_ElseDo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:241:2: ( ( ( rule__DSL_ElseDo__Group__0 ) ) )
            // InternalSensinact.g:242:2: ( ( rule__DSL_ElseDo__Group__0 ) )
            {
            // InternalSensinact.g:242:2: ( ( rule__DSL_ElseDo__Group__0 ) )
            // InternalSensinact.g:243:3: ( rule__DSL_ElseDo__Group__0 )
            {
             before(grammarAccess.getDSL_ElseDoAccess().getGroup()); 
            // InternalSensinact.g:244:3: ( rule__DSL_ElseDo__Group__0 )
            // InternalSensinact.g:244:4: rule__DSL_ElseDo__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ElseDo__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ElseDoAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_ElseDo"


    // $ANTLR start "entryRuleNUMBER"
    // InternalSensinact.g:253:1: entryRuleNUMBER : ruleNUMBER EOF ;
    public final void entryRuleNUMBER() throws RecognitionException {
        try {
            // InternalSensinact.g:254:1: ( ruleNUMBER EOF )
            // InternalSensinact.g:255:1: ruleNUMBER EOF
            {
             before(grammarAccess.getNUMBERRule()); 
            pushFollow(FOLLOW_1);
            ruleNUMBER();

            state._fsp--;

             after(grammarAccess.getNUMBERRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNUMBER"


    // $ANTLR start "ruleNUMBER"
    // InternalSensinact.g:262:1: ruleNUMBER : ( ( rule__NUMBER__Alternatives ) ) ;
    public final void ruleNUMBER() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:266:2: ( ( ( rule__NUMBER__Alternatives ) ) )
            // InternalSensinact.g:267:2: ( ( rule__NUMBER__Alternatives ) )
            {
            // InternalSensinact.g:267:2: ( ( rule__NUMBER__Alternatives ) )
            // InternalSensinact.g:268:3: ( rule__NUMBER__Alternatives )
            {
             before(grammarAccess.getNUMBERAccess().getAlternatives()); 
            // InternalSensinact.g:269:3: ( rule__NUMBER__Alternatives )
            // InternalSensinact.g:269:4: rule__NUMBER__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NUMBER__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNUMBERAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNUMBER"


    // $ANTLR start "entryRuleEXTENDED_ID"
    // InternalSensinact.g:278:1: entryRuleEXTENDED_ID : ruleEXTENDED_ID EOF ;
    public final void entryRuleEXTENDED_ID() throws RecognitionException {
        try {
            // InternalSensinact.g:279:1: ( ruleEXTENDED_ID EOF )
            // InternalSensinact.g:280:1: ruleEXTENDED_ID EOF
            {
             before(grammarAccess.getEXTENDED_IDRule()); 
            pushFollow(FOLLOW_1);
            ruleEXTENDED_ID();

            state._fsp--;

             after(grammarAccess.getEXTENDED_IDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEXTENDED_ID"


    // $ANTLR start "ruleEXTENDED_ID"
    // InternalSensinact.g:287:1: ruleEXTENDED_ID : ( ( rule__EXTENDED_ID__Group__0 ) ) ;
    public final void ruleEXTENDED_ID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:291:2: ( ( ( rule__EXTENDED_ID__Group__0 ) ) )
            // InternalSensinact.g:292:2: ( ( rule__EXTENDED_ID__Group__0 ) )
            {
            // InternalSensinact.g:292:2: ( ( rule__EXTENDED_ID__Group__0 ) )
            // InternalSensinact.g:293:3: ( rule__EXTENDED_ID__Group__0 )
            {
             before(grammarAccess.getEXTENDED_IDAccess().getGroup()); 
            // InternalSensinact.g:294:3: ( rule__EXTENDED_ID__Group__0 )
            // InternalSensinact.g:294:4: rule__EXTENDED_ID__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EXTENDED_ID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEXTENDED_IDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEXTENDED_ID"


    // $ANTLR start "entryRuleDSL_REF_CONDITION"
    // InternalSensinact.g:303:1: entryRuleDSL_REF_CONDITION : ruleDSL_REF_CONDITION EOF ;
    public final void entryRuleDSL_REF_CONDITION() throws RecognitionException {
        try {
            // InternalSensinact.g:304:1: ( ruleDSL_REF_CONDITION EOF )
            // InternalSensinact.g:305:1: ruleDSL_REF_CONDITION EOF
            {
             before(grammarAccess.getDSL_REF_CONDITIONRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_REF_CONDITIONRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_REF_CONDITION"


    // $ANTLR start "ruleDSL_REF_CONDITION"
    // InternalSensinact.g:312:1: ruleDSL_REF_CONDITION : ( ( rule__DSL_REF_CONDITION__Group__0 ) ) ;
    public final void ruleDSL_REF_CONDITION() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:316:2: ( ( ( rule__DSL_REF_CONDITION__Group__0 ) ) )
            // InternalSensinact.g:317:2: ( ( rule__DSL_REF_CONDITION__Group__0 ) )
            {
            // InternalSensinact.g:317:2: ( ( rule__DSL_REF_CONDITION__Group__0 ) )
            // InternalSensinact.g:318:3: ( rule__DSL_REF_CONDITION__Group__0 )
            {
             before(grammarAccess.getDSL_REF_CONDITIONAccess().getGroup()); 
            // InternalSensinact.g:319:3: ( rule__DSL_REF_CONDITION__Group__0 )
            // InternalSensinact.g:319:4: rule__DSL_REF_CONDITION__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_REF_CONDITION__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_REF_CONDITIONAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_REF_CONDITION"


    // $ANTLR start "entryRuleDSL_CEP_STATEMENT"
    // InternalSensinact.g:328:1: entryRuleDSL_CEP_STATEMENT : ruleDSL_CEP_STATEMENT EOF ;
    public final void entryRuleDSL_CEP_STATEMENT() throws RecognitionException {
        try {
            // InternalSensinact.g:329:1: ( ruleDSL_CEP_STATEMENT EOF )
            // InternalSensinact.g:330:1: ruleDSL_CEP_STATEMENT EOF
            {
             before(grammarAccess.getDSL_CEP_STATEMENTRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_STATEMENT();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_STATEMENTRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_STATEMENT"


    // $ANTLR start "ruleDSL_CEP_STATEMENT"
    // InternalSensinact.g:337:1: ruleDSL_CEP_STATEMENT : ( ( rule__DSL_CEP_STATEMENT__Group__0 ) ) ;
    public final void ruleDSL_CEP_STATEMENT() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:341:2: ( ( ( rule__DSL_CEP_STATEMENT__Group__0 ) ) )
            // InternalSensinact.g:342:2: ( ( rule__DSL_CEP_STATEMENT__Group__0 ) )
            {
            // InternalSensinact.g:342:2: ( ( rule__DSL_CEP_STATEMENT__Group__0 ) )
            // InternalSensinact.g:343:3: ( rule__DSL_CEP_STATEMENT__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_STATEMENTAccess().getGroup()); 
            // InternalSensinact.g:344:3: ( rule__DSL_CEP_STATEMENT__Group__0 )
            // InternalSensinact.g:344:4: rule__DSL_CEP_STATEMENT__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_STATEMENT__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_STATEMENTAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_STATEMENT"


    // $ANTLR start "entryRuleDSL_CEP_AFTER"
    // InternalSensinact.g:353:1: entryRuleDSL_CEP_AFTER : ruleDSL_CEP_AFTER EOF ;
    public final void entryRuleDSL_CEP_AFTER() throws RecognitionException {
        try {
            // InternalSensinact.g:354:1: ( ruleDSL_CEP_AFTER EOF )
            // InternalSensinact.g:355:1: ruleDSL_CEP_AFTER EOF
            {
             before(grammarAccess.getDSL_CEP_AFTERRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_AFTER();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_AFTERRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_AFTER"


    // $ANTLR start "ruleDSL_CEP_AFTER"
    // InternalSensinact.g:362:1: ruleDSL_CEP_AFTER : ( ( rule__DSL_CEP_AFTER__Group__0 ) ) ;
    public final void ruleDSL_CEP_AFTER() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:366:2: ( ( ( rule__DSL_CEP_AFTER__Group__0 ) ) )
            // InternalSensinact.g:367:2: ( ( rule__DSL_CEP_AFTER__Group__0 ) )
            {
            // InternalSensinact.g:367:2: ( ( rule__DSL_CEP_AFTER__Group__0 ) )
            // InternalSensinact.g:368:3: ( rule__DSL_CEP_AFTER__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getGroup()); 
            // InternalSensinact.g:369:3: ( rule__DSL_CEP_AFTER__Group__0 )
            // InternalSensinact.g:369:4: rule__DSL_CEP_AFTER__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_AFTERAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_AFTER"


    // $ANTLR start "entryRuleDSL_CEP_BEFORE"
    // InternalSensinact.g:378:1: entryRuleDSL_CEP_BEFORE : ruleDSL_CEP_BEFORE EOF ;
    public final void entryRuleDSL_CEP_BEFORE() throws RecognitionException {
        try {
            // InternalSensinact.g:379:1: ( ruleDSL_CEP_BEFORE EOF )
            // InternalSensinact.g:380:1: ruleDSL_CEP_BEFORE EOF
            {
             before(grammarAccess.getDSL_CEP_BEFORERule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_BEFORE();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_BEFORERule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_BEFORE"


    // $ANTLR start "ruleDSL_CEP_BEFORE"
    // InternalSensinact.g:387:1: ruleDSL_CEP_BEFORE : ( ( rule__DSL_CEP_BEFORE__Group__0 ) ) ;
    public final void ruleDSL_CEP_BEFORE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:391:2: ( ( ( rule__DSL_CEP_BEFORE__Group__0 ) ) )
            // InternalSensinact.g:392:2: ( ( rule__DSL_CEP_BEFORE__Group__0 ) )
            {
            // InternalSensinact.g:392:2: ( ( rule__DSL_CEP_BEFORE__Group__0 ) )
            // InternalSensinact.g:393:3: ( rule__DSL_CEP_BEFORE__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getGroup()); 
            // InternalSensinact.g:394:3: ( rule__DSL_CEP_BEFORE__Group__0 )
            // InternalSensinact.g:394:4: rule__DSL_CEP_BEFORE__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_BEFORE"


    // $ANTLR start "entryRuleDSL_CEP_COINCIDE"
    // InternalSensinact.g:403:1: entryRuleDSL_CEP_COINCIDE : ruleDSL_CEP_COINCIDE EOF ;
    public final void entryRuleDSL_CEP_COINCIDE() throws RecognitionException {
        try {
            // InternalSensinact.g:404:1: ( ruleDSL_CEP_COINCIDE EOF )
            // InternalSensinact.g:405:1: ruleDSL_CEP_COINCIDE EOF
            {
             before(grammarAccess.getDSL_CEP_COINCIDERule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_COINCIDE();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_COINCIDERule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_COINCIDE"


    // $ANTLR start "ruleDSL_CEP_COINCIDE"
    // InternalSensinact.g:412:1: ruleDSL_CEP_COINCIDE : ( ( rule__DSL_CEP_COINCIDE__Group__0 ) ) ;
    public final void ruleDSL_CEP_COINCIDE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:416:2: ( ( ( rule__DSL_CEP_COINCIDE__Group__0 ) ) )
            // InternalSensinact.g:417:2: ( ( rule__DSL_CEP_COINCIDE__Group__0 ) )
            {
            // InternalSensinact.g:417:2: ( ( rule__DSL_CEP_COINCIDE__Group__0 ) )
            // InternalSensinact.g:418:3: ( rule__DSL_CEP_COINCIDE__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getGroup()); 
            // InternalSensinact.g:419:3: ( rule__DSL_CEP_COINCIDE__Group__0 )
            // InternalSensinact.g:419:4: rule__DSL_CEP_COINCIDE__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_COINCIDE"


    // $ANTLR start "entryRuleDSL_CEP_MIN"
    // InternalSensinact.g:428:1: entryRuleDSL_CEP_MIN : ruleDSL_CEP_MIN EOF ;
    public final void entryRuleDSL_CEP_MIN() throws RecognitionException {
        try {
            // InternalSensinact.g:429:1: ( ruleDSL_CEP_MIN EOF )
            // InternalSensinact.g:430:1: ruleDSL_CEP_MIN EOF
            {
             before(grammarAccess.getDSL_CEP_MINRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_MIN();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_MINRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_MIN"


    // $ANTLR start "ruleDSL_CEP_MIN"
    // InternalSensinact.g:437:1: ruleDSL_CEP_MIN : ( ( rule__DSL_CEP_MIN__Group__0 ) ) ;
    public final void ruleDSL_CEP_MIN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:441:2: ( ( ( rule__DSL_CEP_MIN__Group__0 ) ) )
            // InternalSensinact.g:442:2: ( ( rule__DSL_CEP_MIN__Group__0 ) )
            {
            // InternalSensinact.g:442:2: ( ( rule__DSL_CEP_MIN__Group__0 ) )
            // InternalSensinact.g:443:3: ( rule__DSL_CEP_MIN__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_MINAccess().getGroup()); 
            // InternalSensinact.g:444:3: ( rule__DSL_CEP_MIN__Group__0 )
            // InternalSensinact.g:444:4: rule__DSL_CEP_MIN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MIN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_MINAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_MIN"


    // $ANTLR start "entryRuleDSL_CEP_MAX"
    // InternalSensinact.g:453:1: entryRuleDSL_CEP_MAX : ruleDSL_CEP_MAX EOF ;
    public final void entryRuleDSL_CEP_MAX() throws RecognitionException {
        try {
            // InternalSensinact.g:454:1: ( ruleDSL_CEP_MAX EOF )
            // InternalSensinact.g:455:1: ruleDSL_CEP_MAX EOF
            {
             before(grammarAccess.getDSL_CEP_MAXRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_MAX();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_MAXRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_MAX"


    // $ANTLR start "ruleDSL_CEP_MAX"
    // InternalSensinact.g:462:1: ruleDSL_CEP_MAX : ( ( rule__DSL_CEP_MAX__Group__0 ) ) ;
    public final void ruleDSL_CEP_MAX() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:466:2: ( ( ( rule__DSL_CEP_MAX__Group__0 ) ) )
            // InternalSensinact.g:467:2: ( ( rule__DSL_CEP_MAX__Group__0 ) )
            {
            // InternalSensinact.g:467:2: ( ( rule__DSL_CEP_MAX__Group__0 ) )
            // InternalSensinact.g:468:3: ( rule__DSL_CEP_MAX__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_MAXAccess().getGroup()); 
            // InternalSensinact.g:469:3: ( rule__DSL_CEP_MAX__Group__0 )
            // InternalSensinact.g:469:4: rule__DSL_CEP_MAX__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MAX__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_MAXAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_MAX"


    // $ANTLR start "entryRuleDSL_CEP_AVG"
    // InternalSensinact.g:478:1: entryRuleDSL_CEP_AVG : ruleDSL_CEP_AVG EOF ;
    public final void entryRuleDSL_CEP_AVG() throws RecognitionException {
        try {
            // InternalSensinact.g:479:1: ( ruleDSL_CEP_AVG EOF )
            // InternalSensinact.g:480:1: ruleDSL_CEP_AVG EOF
            {
             before(grammarAccess.getDSL_CEP_AVGRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_AVG();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_AVGRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_AVG"


    // $ANTLR start "ruleDSL_CEP_AVG"
    // InternalSensinact.g:487:1: ruleDSL_CEP_AVG : ( ( rule__DSL_CEP_AVG__Group__0 ) ) ;
    public final void ruleDSL_CEP_AVG() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:491:2: ( ( ( rule__DSL_CEP_AVG__Group__0 ) ) )
            // InternalSensinact.g:492:2: ( ( rule__DSL_CEP_AVG__Group__0 ) )
            {
            // InternalSensinact.g:492:2: ( ( rule__DSL_CEP_AVG__Group__0 ) )
            // InternalSensinact.g:493:3: ( rule__DSL_CEP_AVG__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_AVGAccess().getGroup()); 
            // InternalSensinact.g:494:3: ( rule__DSL_CEP_AVG__Group__0 )
            // InternalSensinact.g:494:4: rule__DSL_CEP_AVG__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AVG__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_AVGAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_AVG"


    // $ANTLR start "entryRuleDSL_CEP_SUM"
    // InternalSensinact.g:503:1: entryRuleDSL_CEP_SUM : ruleDSL_CEP_SUM EOF ;
    public final void entryRuleDSL_CEP_SUM() throws RecognitionException {
        try {
            // InternalSensinact.g:504:1: ( ruleDSL_CEP_SUM EOF )
            // InternalSensinact.g:505:1: ruleDSL_CEP_SUM EOF
            {
             before(grammarAccess.getDSL_CEP_SUMRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_SUM();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_SUMRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_SUM"


    // $ANTLR start "ruleDSL_CEP_SUM"
    // InternalSensinact.g:512:1: ruleDSL_CEP_SUM : ( ( rule__DSL_CEP_SUM__Group__0 ) ) ;
    public final void ruleDSL_CEP_SUM() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:516:2: ( ( ( rule__DSL_CEP_SUM__Group__0 ) ) )
            // InternalSensinact.g:517:2: ( ( rule__DSL_CEP_SUM__Group__0 ) )
            {
            // InternalSensinact.g:517:2: ( ( rule__DSL_CEP_SUM__Group__0 ) )
            // InternalSensinact.g:518:3: ( rule__DSL_CEP_SUM__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_SUMAccess().getGroup()); 
            // InternalSensinact.g:519:3: ( rule__DSL_CEP_SUM__Group__0 )
            // InternalSensinact.g:519:4: rule__DSL_CEP_SUM__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_SUM__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_SUMAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_SUM"


    // $ANTLR start "entryRuleDSL_CEP_COUNT"
    // InternalSensinact.g:528:1: entryRuleDSL_CEP_COUNT : ruleDSL_CEP_COUNT EOF ;
    public final void entryRuleDSL_CEP_COUNT() throws RecognitionException {
        try {
            // InternalSensinact.g:529:1: ( ruleDSL_CEP_COUNT EOF )
            // InternalSensinact.g:530:1: ruleDSL_CEP_COUNT EOF
            {
             before(grammarAccess.getDSL_CEP_COUNTRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_COUNT();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_COUNTRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_COUNT"


    // $ANTLR start "ruleDSL_CEP_COUNT"
    // InternalSensinact.g:537:1: ruleDSL_CEP_COUNT : ( ( rule__DSL_CEP_COUNT__Group__0 ) ) ;
    public final void ruleDSL_CEP_COUNT() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:541:2: ( ( ( rule__DSL_CEP_COUNT__Group__0 ) ) )
            // InternalSensinact.g:542:2: ( ( rule__DSL_CEP_COUNT__Group__0 ) )
            {
            // InternalSensinact.g:542:2: ( ( rule__DSL_CEP_COUNT__Group__0 ) )
            // InternalSensinact.g:543:3: ( rule__DSL_CEP_COUNT__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_COUNTAccess().getGroup()); 
            // InternalSensinact.g:544:3: ( rule__DSL_CEP_COUNT__Group__0 )
            // InternalSensinact.g:544:4: rule__DSL_CEP_COUNT__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COUNT__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_COUNTAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_COUNT"


    // $ANTLR start "entryRuleDSL_CEP_DURATION"
    // InternalSensinact.g:553:1: entryRuleDSL_CEP_DURATION : ruleDSL_CEP_DURATION EOF ;
    public final void entryRuleDSL_CEP_DURATION() throws RecognitionException {
        try {
            // InternalSensinact.g:554:1: ( ruleDSL_CEP_DURATION EOF )
            // InternalSensinact.g:555:1: ruleDSL_CEP_DURATION EOF
            {
             before(grammarAccess.getDSL_CEP_DURATIONRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_DURATIONRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_DURATION"


    // $ANTLR start "ruleDSL_CEP_DURATION"
    // InternalSensinact.g:562:1: ruleDSL_CEP_DURATION : ( ( ( rule__DSL_CEP_DURATION__UnitsAssignment ) ) ( ( rule__DSL_CEP_DURATION__UnitsAssignment )* ) ) ;
    public final void ruleDSL_CEP_DURATION() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:566:2: ( ( ( ( rule__DSL_CEP_DURATION__UnitsAssignment ) ) ( ( rule__DSL_CEP_DURATION__UnitsAssignment )* ) ) )
            // InternalSensinact.g:567:2: ( ( ( rule__DSL_CEP_DURATION__UnitsAssignment ) ) ( ( rule__DSL_CEP_DURATION__UnitsAssignment )* ) )
            {
            // InternalSensinact.g:567:2: ( ( ( rule__DSL_CEP_DURATION__UnitsAssignment ) ) ( ( rule__DSL_CEP_DURATION__UnitsAssignment )* ) )
            // InternalSensinact.g:568:3: ( ( rule__DSL_CEP_DURATION__UnitsAssignment ) ) ( ( rule__DSL_CEP_DURATION__UnitsAssignment )* )
            {
            // InternalSensinact.g:568:3: ( ( rule__DSL_CEP_DURATION__UnitsAssignment ) )
            // InternalSensinact.g:569:4: ( rule__DSL_CEP_DURATION__UnitsAssignment )
            {
             before(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsAssignment()); 
            // InternalSensinact.g:570:4: ( rule__DSL_CEP_DURATION__UnitsAssignment )
            // InternalSensinact.g:570:5: rule__DSL_CEP_DURATION__UnitsAssignment
            {
            pushFollow(FOLLOW_3);
            rule__DSL_CEP_DURATION__UnitsAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsAssignment()); 

            }

            // InternalSensinact.g:573:3: ( ( rule__DSL_CEP_DURATION__UnitsAssignment )* )
            // InternalSensinact.g:574:4: ( rule__DSL_CEP_DURATION__UnitsAssignment )*
            {
             before(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsAssignment()); 
            // InternalSensinact.g:575:4: ( rule__DSL_CEP_DURATION__UnitsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_INT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSensinact.g:575:5: rule__DSL_CEP_DURATION__UnitsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__DSL_CEP_DURATION__UnitsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_DURATION"


    // $ANTLR start "entryRuleDSL_CEP_DURATION_MIN"
    // InternalSensinact.g:585:1: entryRuleDSL_CEP_DURATION_MIN : ruleDSL_CEP_DURATION_MIN EOF ;
    public final void entryRuleDSL_CEP_DURATION_MIN() throws RecognitionException {
        try {
            // InternalSensinact.g:586:1: ( ruleDSL_CEP_DURATION_MIN EOF )
            // InternalSensinact.g:587:1: ruleDSL_CEP_DURATION_MIN EOF
            {
             before(grammarAccess.getDSL_CEP_DURATION_MINRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_DURATION_MIN();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_DURATION_MINRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_DURATION_MIN"


    // $ANTLR start "ruleDSL_CEP_DURATION_MIN"
    // InternalSensinact.g:594:1: ruleDSL_CEP_DURATION_MIN : ( ( rule__DSL_CEP_DURATION_MIN__Group__0 ) ) ;
    public final void ruleDSL_CEP_DURATION_MIN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:598:2: ( ( ( rule__DSL_CEP_DURATION_MIN__Group__0 ) ) )
            // InternalSensinact.g:599:2: ( ( rule__DSL_CEP_DURATION_MIN__Group__0 ) )
            {
            // InternalSensinact.g:599:2: ( ( rule__DSL_CEP_DURATION_MIN__Group__0 ) )
            // InternalSensinact.g:600:3: ( rule__DSL_CEP_DURATION_MIN__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_DURATION_MINAccess().getGroup()); 
            // InternalSensinact.g:601:3: ( rule__DSL_CEP_DURATION_MIN__Group__0 )
            // InternalSensinact.g:601:4: rule__DSL_CEP_DURATION_MIN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_DURATION_MIN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_DURATION_MINAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_DURATION_MIN"


    // $ANTLR start "entryRuleDSL_CEP_DURATION_SEC"
    // InternalSensinact.g:610:1: entryRuleDSL_CEP_DURATION_SEC : ruleDSL_CEP_DURATION_SEC EOF ;
    public final void entryRuleDSL_CEP_DURATION_SEC() throws RecognitionException {
        try {
            // InternalSensinact.g:611:1: ( ruleDSL_CEP_DURATION_SEC EOF )
            // InternalSensinact.g:612:1: ruleDSL_CEP_DURATION_SEC EOF
            {
             before(grammarAccess.getDSL_CEP_DURATION_SECRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_CEP_DURATION_SEC();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_DURATION_SECRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_CEP_DURATION_SEC"


    // $ANTLR start "ruleDSL_CEP_DURATION_SEC"
    // InternalSensinact.g:619:1: ruleDSL_CEP_DURATION_SEC : ( ( rule__DSL_CEP_DURATION_SEC__Group__0 ) ) ;
    public final void ruleDSL_CEP_DURATION_SEC() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:623:2: ( ( ( rule__DSL_CEP_DURATION_SEC__Group__0 ) ) )
            // InternalSensinact.g:624:2: ( ( rule__DSL_CEP_DURATION_SEC__Group__0 ) )
            {
            // InternalSensinact.g:624:2: ( ( rule__DSL_CEP_DURATION_SEC__Group__0 ) )
            // InternalSensinact.g:625:3: ( rule__DSL_CEP_DURATION_SEC__Group__0 )
            {
             before(grammarAccess.getDSL_CEP_DURATION_SECAccess().getGroup()); 
            // InternalSensinact.g:626:3: ( rule__DSL_CEP_DURATION_SEC__Group__0 )
            // InternalSensinact.g:626:4: rule__DSL_CEP_DURATION_SEC__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_DURATION_SEC__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_DURATION_SECAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_CEP_DURATION_SEC"


    // $ANTLR start "entryRuleDSL_ListActions"
    // InternalSensinact.g:635:1: entryRuleDSL_ListActions : ruleDSL_ListActions EOF ;
    public final void entryRuleDSL_ListActions() throws RecognitionException {
        try {
            // InternalSensinact.g:636:1: ( ruleDSL_ListActions EOF )
            // InternalSensinact.g:637:1: ruleDSL_ListActions EOF
            {
             before(grammarAccess.getDSL_ListActionsRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_ListActions();

            state._fsp--;

             after(grammarAccess.getDSL_ListActionsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_ListActions"


    // $ANTLR start "ruleDSL_ListActions"
    // InternalSensinact.g:644:1: ruleDSL_ListActions : ( ( rule__DSL_ListActions__Group__0 ) ) ;
    public final void ruleDSL_ListActions() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:648:2: ( ( ( rule__DSL_ListActions__Group__0 ) ) )
            // InternalSensinact.g:649:2: ( ( rule__DSL_ListActions__Group__0 ) )
            {
            // InternalSensinact.g:649:2: ( ( rule__DSL_ListActions__Group__0 ) )
            // InternalSensinact.g:650:3: ( rule__DSL_ListActions__Group__0 )
            {
             before(grammarAccess.getDSL_ListActionsAccess().getGroup()); 
            // InternalSensinact.g:651:3: ( rule__DSL_ListActions__Group__0 )
            // InternalSensinact.g:651:4: rule__DSL_ListActions__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListActions__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ListActionsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_ListActions"


    // $ANTLR start "entryRuleDSL_ResourceAction"
    // InternalSensinact.g:660:1: entryRuleDSL_ResourceAction : ruleDSL_ResourceAction EOF ;
    public final void entryRuleDSL_ResourceAction() throws RecognitionException {
        try {
            // InternalSensinact.g:661:1: ( ruleDSL_ResourceAction EOF )
            // InternalSensinact.g:662:1: ruleDSL_ResourceAction EOF
            {
             before(grammarAccess.getDSL_ResourceActionRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_ResourceAction();

            state._fsp--;

             after(grammarAccess.getDSL_ResourceActionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_ResourceAction"


    // $ANTLR start "ruleDSL_ResourceAction"
    // InternalSensinact.g:669:1: ruleDSL_ResourceAction : ( ( rule__DSL_ResourceAction__Group__0 ) ) ;
    public final void ruleDSL_ResourceAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:673:2: ( ( ( rule__DSL_ResourceAction__Group__0 ) ) )
            // InternalSensinact.g:674:2: ( ( rule__DSL_ResourceAction__Group__0 ) )
            {
            // InternalSensinact.g:674:2: ( ( rule__DSL_ResourceAction__Group__0 ) )
            // InternalSensinact.g:675:3: ( rule__DSL_ResourceAction__Group__0 )
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getGroup()); 
            // InternalSensinact.g:676:3: ( rule__DSL_ResourceAction__Group__0 )
            // InternalSensinact.g:676:4: rule__DSL_ResourceAction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceActionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_ResourceAction"


    // $ANTLR start "entryRuleDSL_ListParam"
    // InternalSensinact.g:685:1: entryRuleDSL_ListParam : ruleDSL_ListParam EOF ;
    public final void entryRuleDSL_ListParam() throws RecognitionException {
        try {
            // InternalSensinact.g:686:1: ( ruleDSL_ListParam EOF )
            // InternalSensinact.g:687:1: ruleDSL_ListParam EOF
            {
             before(grammarAccess.getDSL_ListParamRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_ListParam();

            state._fsp--;

             after(grammarAccess.getDSL_ListParamRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_ListParam"


    // $ANTLR start "ruleDSL_ListParam"
    // InternalSensinact.g:694:1: ruleDSL_ListParam : ( ( rule__DSL_ListParam__Group__0 ) ) ;
    public final void ruleDSL_ListParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:698:2: ( ( ( rule__DSL_ListParam__Group__0 ) ) )
            // InternalSensinact.g:699:2: ( ( rule__DSL_ListParam__Group__0 ) )
            {
            // InternalSensinact.g:699:2: ( ( rule__DSL_ListParam__Group__0 ) )
            // InternalSensinact.g:700:3: ( rule__DSL_ListParam__Group__0 )
            {
             before(grammarAccess.getDSL_ListParamAccess().getGroup()); 
            // InternalSensinact.g:701:3: ( rule__DSL_ListParam__Group__0 )
            // InternalSensinact.g:701:4: rule__DSL_ListParam__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListParam__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ListParamAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_ListParam"


    // $ANTLR start "entryRuleDSL_Expression_Or"
    // InternalSensinact.g:710:1: entryRuleDSL_Expression_Or : ruleDSL_Expression_Or EOF ;
    public final void entryRuleDSL_Expression_Or() throws RecognitionException {
        try {
            // InternalSensinact.g:711:1: ( ruleDSL_Expression_Or EOF )
            // InternalSensinact.g:712:1: ruleDSL_Expression_Or EOF
            {
             before(grammarAccess.getDSL_Expression_OrRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_Expression_Or();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_OrRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_Expression_Or"


    // $ANTLR start "ruleDSL_Expression_Or"
    // InternalSensinact.g:719:1: ruleDSL_Expression_Or : ( ( rule__DSL_Expression_Or__Group__0 ) ) ;
    public final void ruleDSL_Expression_Or() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:723:2: ( ( ( rule__DSL_Expression_Or__Group__0 ) ) )
            // InternalSensinact.g:724:2: ( ( rule__DSL_Expression_Or__Group__0 ) )
            {
            // InternalSensinact.g:724:2: ( ( rule__DSL_Expression_Or__Group__0 ) )
            // InternalSensinact.g:725:3: ( rule__DSL_Expression_Or__Group__0 )
            {
             before(grammarAccess.getDSL_Expression_OrAccess().getGroup()); 
            // InternalSensinact.g:726:3: ( rule__DSL_Expression_Or__Group__0 )
            // InternalSensinact.g:726:4: rule__DSL_Expression_Or__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Or__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_OrAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_Expression_Or"


    // $ANTLR start "entryRuleDSL_Expression_And"
    // InternalSensinact.g:735:1: entryRuleDSL_Expression_And : ruleDSL_Expression_And EOF ;
    public final void entryRuleDSL_Expression_And() throws RecognitionException {
        try {
            // InternalSensinact.g:736:1: ( ruleDSL_Expression_And EOF )
            // InternalSensinact.g:737:1: ruleDSL_Expression_And EOF
            {
             before(grammarAccess.getDSL_Expression_AndRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_Expression_And();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_AndRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_Expression_And"


    // $ANTLR start "ruleDSL_Expression_And"
    // InternalSensinact.g:744:1: ruleDSL_Expression_And : ( ( rule__DSL_Expression_And__Group__0 ) ) ;
    public final void ruleDSL_Expression_And() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:748:2: ( ( ( rule__DSL_Expression_And__Group__0 ) ) )
            // InternalSensinact.g:749:2: ( ( rule__DSL_Expression_And__Group__0 ) )
            {
            // InternalSensinact.g:749:2: ( ( rule__DSL_Expression_And__Group__0 ) )
            // InternalSensinact.g:750:3: ( rule__DSL_Expression_And__Group__0 )
            {
             before(grammarAccess.getDSL_Expression_AndAccess().getGroup()); 
            // InternalSensinact.g:751:3: ( rule__DSL_Expression_And__Group__0 )
            // InternalSensinact.g:751:4: rule__DSL_Expression_And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_And__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_AndAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_Expression_And"


    // $ANTLR start "entryRuleDSL_Expression_DiffEqual"
    // InternalSensinact.g:760:1: entryRuleDSL_Expression_DiffEqual : ruleDSL_Expression_DiffEqual EOF ;
    public final void entryRuleDSL_Expression_DiffEqual() throws RecognitionException {
        try {
            // InternalSensinact.g:761:1: ( ruleDSL_Expression_DiffEqual EOF )
            // InternalSensinact.g:762:1: ruleDSL_Expression_DiffEqual EOF
            {
             before(grammarAccess.getDSL_Expression_DiffEqualRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_Expression_DiffEqual();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_DiffEqualRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_Expression_DiffEqual"


    // $ANTLR start "ruleDSL_Expression_DiffEqual"
    // InternalSensinact.g:769:1: ruleDSL_Expression_DiffEqual : ( ( rule__DSL_Expression_DiffEqual__Group__0 ) ) ;
    public final void ruleDSL_Expression_DiffEqual() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:773:2: ( ( ( rule__DSL_Expression_DiffEqual__Group__0 ) ) )
            // InternalSensinact.g:774:2: ( ( rule__DSL_Expression_DiffEqual__Group__0 ) )
            {
            // InternalSensinact.g:774:2: ( ( rule__DSL_Expression_DiffEqual__Group__0 ) )
            // InternalSensinact.g:775:3: ( rule__DSL_Expression_DiffEqual__Group__0 )
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getGroup()); 
            // InternalSensinact.g:776:3: ( rule__DSL_Expression_DiffEqual__Group__0 )
            // InternalSensinact.g:776:4: rule__DSL_Expression_DiffEqual__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_Expression_DiffEqual"


    // $ANTLR start "entryRuleDSL_Expression_Compare"
    // InternalSensinact.g:785:1: entryRuleDSL_Expression_Compare : ruleDSL_Expression_Compare EOF ;
    public final void entryRuleDSL_Expression_Compare() throws RecognitionException {
        try {
            // InternalSensinact.g:786:1: ( ruleDSL_Expression_Compare EOF )
            // InternalSensinact.g:787:1: ruleDSL_Expression_Compare EOF
            {
             before(grammarAccess.getDSL_Expression_CompareRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_Expression_Compare();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_CompareRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_Expression_Compare"


    // $ANTLR start "ruleDSL_Expression_Compare"
    // InternalSensinact.g:794:1: ruleDSL_Expression_Compare : ( ( rule__DSL_Expression_Compare__Group__0 ) ) ;
    public final void ruleDSL_Expression_Compare() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:798:2: ( ( ( rule__DSL_Expression_Compare__Group__0 ) ) )
            // InternalSensinact.g:799:2: ( ( rule__DSL_Expression_Compare__Group__0 ) )
            {
            // InternalSensinact.g:799:2: ( ( rule__DSL_Expression_Compare__Group__0 ) )
            // InternalSensinact.g:800:3: ( rule__DSL_Expression_Compare__Group__0 )
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getGroup()); 
            // InternalSensinact.g:801:3: ( rule__DSL_Expression_Compare__Group__0 )
            // InternalSensinact.g:801:4: rule__DSL_Expression_Compare__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_CompareAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_Expression_Compare"


    // $ANTLR start "entryRuleDSL_Expression_PlusMinus"
    // InternalSensinact.g:810:1: entryRuleDSL_Expression_PlusMinus : ruleDSL_Expression_PlusMinus EOF ;
    public final void entryRuleDSL_Expression_PlusMinus() throws RecognitionException {
        try {
            // InternalSensinact.g:811:1: ( ruleDSL_Expression_PlusMinus EOF )
            // InternalSensinact.g:812:1: ruleDSL_Expression_PlusMinus EOF
            {
             before(grammarAccess.getDSL_Expression_PlusMinusRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_Expression_PlusMinus();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_PlusMinusRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_Expression_PlusMinus"


    // $ANTLR start "ruleDSL_Expression_PlusMinus"
    // InternalSensinact.g:819:1: ruleDSL_Expression_PlusMinus : ( ( rule__DSL_Expression_PlusMinus__Group__0 ) ) ;
    public final void ruleDSL_Expression_PlusMinus() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:823:2: ( ( ( rule__DSL_Expression_PlusMinus__Group__0 ) ) )
            // InternalSensinact.g:824:2: ( ( rule__DSL_Expression_PlusMinus__Group__0 ) )
            {
            // InternalSensinact.g:824:2: ( ( rule__DSL_Expression_PlusMinus__Group__0 ) )
            // InternalSensinact.g:825:3: ( rule__DSL_Expression_PlusMinus__Group__0 )
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getGroup()); 
            // InternalSensinact.g:826:3: ( rule__DSL_Expression_PlusMinus__Group__0 )
            // InternalSensinact.g:826:4: rule__DSL_Expression_PlusMinus__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_Expression_PlusMinus"


    // $ANTLR start "entryRuleDSL_Expression_MultiplicationDivision"
    // InternalSensinact.g:835:1: entryRuleDSL_Expression_MultiplicationDivision : ruleDSL_Expression_MultiplicationDivision EOF ;
    public final void entryRuleDSL_Expression_MultiplicationDivision() throws RecognitionException {
        try {
            // InternalSensinact.g:836:1: ( ruleDSL_Expression_MultiplicationDivision EOF )
            // InternalSensinact.g:837:1: ruleDSL_Expression_MultiplicationDivision EOF
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_Expression_MultiplicationDivision();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_Expression_MultiplicationDivision"


    // $ANTLR start "ruleDSL_Expression_MultiplicationDivision"
    // InternalSensinact.g:844:1: ruleDSL_Expression_MultiplicationDivision : ( ( rule__DSL_Expression_MultiplicationDivision__Group__0 ) ) ;
    public final void ruleDSL_Expression_MultiplicationDivision() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:848:2: ( ( ( rule__DSL_Expression_MultiplicationDivision__Group__0 ) ) )
            // InternalSensinact.g:849:2: ( ( rule__DSL_Expression_MultiplicationDivision__Group__0 ) )
            {
            // InternalSensinact.g:849:2: ( ( rule__DSL_Expression_MultiplicationDivision__Group__0 ) )
            // InternalSensinact.g:850:3: ( rule__DSL_Expression_MultiplicationDivision__Group__0 )
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getGroup()); 
            // InternalSensinact.g:851:3: ( rule__DSL_Expression_MultiplicationDivision__Group__0 )
            // InternalSensinact.g:851:4: rule__DSL_Expression_MultiplicationDivision__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_Expression_MultiplicationDivision"


    // $ANTLR start "entryRuleDSL_Expression_Unary"
    // InternalSensinact.g:860:1: entryRuleDSL_Expression_Unary : ruleDSL_Expression_Unary EOF ;
    public final void entryRuleDSL_Expression_Unary() throws RecognitionException {
        try {
            // InternalSensinact.g:861:1: ( ruleDSL_Expression_Unary EOF )
            // InternalSensinact.g:862:1: ruleDSL_Expression_Unary EOF
            {
             before(grammarAccess.getDSL_Expression_UnaryRule()); 
            pushFollow(FOLLOW_1);
            ruleDSL_Expression_Unary();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_UnaryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDSL_Expression_Unary"


    // $ANTLR start "ruleDSL_Expression_Unary"
    // InternalSensinact.g:869:1: ruleDSL_Expression_Unary : ( ( rule__DSL_Expression_Unary__Alternatives ) ) ;
    public final void ruleDSL_Expression_Unary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:873:2: ( ( ( rule__DSL_Expression_Unary__Alternatives ) ) )
            // InternalSensinact.g:874:2: ( ( rule__DSL_Expression_Unary__Alternatives ) )
            {
            // InternalSensinact.g:874:2: ( ( rule__DSL_Expression_Unary__Alternatives ) )
            // InternalSensinact.g:875:3: ( rule__DSL_Expression_Unary__Alternatives )
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getAlternatives()); 
            // InternalSensinact.g:876:3: ( rule__DSL_Expression_Unary__Alternatives )
            // InternalSensinact.g:876:4: rule__DSL_Expression_Unary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDSL_Expression_Unary"


    // $ANTLR start "rule__NUMBER__Alternatives"
    // InternalSensinact.g:884:1: rule__NUMBER__Alternatives : ( ( RULE_INT ) | ( ( rule__NUMBER__Group_1__0 ) ) );
    public final void rule__NUMBER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:888:1: ( ( RULE_INT ) | ( ( rule__NUMBER__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==EOF||LA2_1==17||LA2_1==20||LA2_1==23||LA2_1==29||LA2_1==34||(LA2_1>=39 && LA2_1<=51)) ) {
                    alt2=1;
                }
                else if ( (LA2_1==26) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalSensinact.g:889:2: ( RULE_INT )
                    {
                    // InternalSensinact.g:889:2: ( RULE_INT )
                    // InternalSensinact.g:890:3: RULE_INT
                    {
                     before(grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:895:2: ( ( rule__NUMBER__Group_1__0 ) )
                    {
                    // InternalSensinact.g:895:2: ( ( rule__NUMBER__Group_1__0 ) )
                    // InternalSensinact.g:896:3: ( rule__NUMBER__Group_1__0 )
                    {
                     before(grammarAccess.getNUMBERAccess().getGroup_1()); 
                    // InternalSensinact.g:897:3: ( rule__NUMBER__Group_1__0 )
                    // InternalSensinact.g:897:4: rule__NUMBER__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NUMBER__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNUMBERAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NUMBER__Alternatives"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0"
    // InternalSensinact.g:905:1: rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0 : ( ( ruleDSL_CEP_AFTER ) | ( ruleDSL_CEP_BEFORE ) | ( ruleDSL_CEP_COINCIDE ) | ( ruleDSL_CEP_MIN ) | ( ruleDSL_CEP_MAX ) | ( ruleDSL_CEP_AVG ) | ( ruleDSL_CEP_SUM ) | ( ruleDSL_CEP_COUNT ) );
    public final void rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:909:1: ( ( ruleDSL_CEP_AFTER ) | ( ruleDSL_CEP_BEFORE ) | ( ruleDSL_CEP_COINCIDE ) | ( ruleDSL_CEP_MIN ) | ( ruleDSL_CEP_MAX ) | ( ruleDSL_CEP_AVG ) | ( ruleDSL_CEP_SUM ) | ( ruleDSL_CEP_COUNT ) )
            int alt3=8;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt3=1;
                }
                break;
            case 32:
                {
                alt3=2;
                }
                break;
            case 33:
                {
                alt3=3;
                }
                break;
            case 34:
                {
                alt3=4;
                }
                break;
            case 35:
                {
                alt3=5;
                }
                break;
            case 36:
                {
                alt3=6;
                }
                break;
            case 37:
                {
                alt3=7;
                }
                break;
            case 38:
                {
                alt3=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalSensinact.g:910:2: ( ruleDSL_CEP_AFTER )
                    {
                    // InternalSensinact.g:910:2: ( ruleDSL_CEP_AFTER )
                    // InternalSensinact.g:911:3: ruleDSL_CEP_AFTER
                    {
                     before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_AFTERParserRuleCall_3_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_AFTER();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_AFTERParserRuleCall_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:916:2: ( ruleDSL_CEP_BEFORE )
                    {
                    // InternalSensinact.g:916:2: ( ruleDSL_CEP_BEFORE )
                    // InternalSensinact.g:917:3: ruleDSL_CEP_BEFORE
                    {
                     before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_BEFOREParserRuleCall_3_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_BEFORE();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_BEFOREParserRuleCall_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSensinact.g:922:2: ( ruleDSL_CEP_COINCIDE )
                    {
                    // InternalSensinact.g:922:2: ( ruleDSL_CEP_COINCIDE )
                    // InternalSensinact.g:923:3: ruleDSL_CEP_COINCIDE
                    {
                     before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_COINCIDEParserRuleCall_3_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_COINCIDE();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_COINCIDEParserRuleCall_3_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSensinact.g:928:2: ( ruleDSL_CEP_MIN )
                    {
                    // InternalSensinact.g:928:2: ( ruleDSL_CEP_MIN )
                    // InternalSensinact.g:929:3: ruleDSL_CEP_MIN
                    {
                     before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_MINParserRuleCall_3_0_3()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_MIN();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_MINParserRuleCall_3_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSensinact.g:934:2: ( ruleDSL_CEP_MAX )
                    {
                    // InternalSensinact.g:934:2: ( ruleDSL_CEP_MAX )
                    // InternalSensinact.g:935:3: ruleDSL_CEP_MAX
                    {
                     before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_MAXParserRuleCall_3_0_4()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_MAX();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_MAXParserRuleCall_3_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSensinact.g:940:2: ( ruleDSL_CEP_AVG )
                    {
                    // InternalSensinact.g:940:2: ( ruleDSL_CEP_AVG )
                    // InternalSensinact.g:941:3: ruleDSL_CEP_AVG
                    {
                     before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_AVGParserRuleCall_3_0_5()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_AVG();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_AVGParserRuleCall_3_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSensinact.g:946:2: ( ruleDSL_CEP_SUM )
                    {
                    // InternalSensinact.g:946:2: ( ruleDSL_CEP_SUM )
                    // InternalSensinact.g:947:3: ruleDSL_CEP_SUM
                    {
                     before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_SUMParserRuleCall_3_0_6()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_SUM();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_SUMParserRuleCall_3_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSensinact.g:952:2: ( ruleDSL_CEP_COUNT )
                    {
                    // InternalSensinact.g:952:2: ( ruleDSL_CEP_COUNT )
                    // InternalSensinact.g:953:3: ruleDSL_CEP_COUNT
                    {
                     before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_COUNTParserRuleCall_3_0_7()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_COUNT();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_COUNTParserRuleCall_3_0_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0"


    // $ANTLR start "rule__DSL_CEP_DURATION__UnitsAlternatives_0"
    // InternalSensinact.g:962:1: rule__DSL_CEP_DURATION__UnitsAlternatives_0 : ( ( ruleDSL_CEP_DURATION_MIN ) | ( ruleDSL_CEP_DURATION_SEC ) );
    public final void rule__DSL_CEP_DURATION__UnitsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:966:1: ( ( ruleDSL_CEP_DURATION_MIN ) | ( ruleDSL_CEP_DURATION_SEC ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==RULE_INT) ) {
                        int LA4_5 = input.LA(4);

                        if ( (LA4_5==39) ) {
                            alt4=2;
                        }
                        else if ( (LA4_5==34) ) {
                            alt4=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case 39:
                    {
                    alt4=2;
                    }
                    break;
                case 34:
                    {
                    alt4=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalSensinact.g:967:2: ( ruleDSL_CEP_DURATION_MIN )
                    {
                    // InternalSensinact.g:967:2: ( ruleDSL_CEP_DURATION_MIN )
                    // InternalSensinact.g:968:3: ruleDSL_CEP_DURATION_MIN
                    {
                     before(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsDSL_CEP_DURATION_MINParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_DURATION_MIN();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsDSL_CEP_DURATION_MINParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:973:2: ( ruleDSL_CEP_DURATION_SEC )
                    {
                    // InternalSensinact.g:973:2: ( ruleDSL_CEP_DURATION_SEC )
                    // InternalSensinact.g:974:3: ruleDSL_CEP_DURATION_SEC
                    {
                     before(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsDSL_CEP_DURATION_SECParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleDSL_CEP_DURATION_SEC();

                    state._fsp--;

                     after(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsDSL_CEP_DURATION_SECParserRuleCall_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION__UnitsAlternatives_0"


    // $ANTLR start "rule__DSL_ResourceAction__ActiontypeAlternatives_3_0"
    // InternalSensinact.g:983:1: rule__DSL_ResourceAction__ActiontypeAlternatives_3_0 : ( ( 'act' ) | ( 'set' ) );
    public final void rule__DSL_ResourceAction__ActiontypeAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:987:1: ( ( 'act' ) | ( 'set' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            else if ( (LA5_0==13) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalSensinact.g:988:2: ( 'act' )
                    {
                    // InternalSensinact.g:988:2: ( 'act' )
                    // InternalSensinact.g:989:3: 'act'
                    {
                     before(grammarAccess.getDSL_ResourceActionAccess().getActiontypeActKeyword_3_0_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getDSL_ResourceActionAccess().getActiontypeActKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:994:2: ( 'set' )
                    {
                    // InternalSensinact.g:994:2: ( 'set' )
                    // InternalSensinact.g:995:3: 'set'
                    {
                     before(grammarAccess.getDSL_ResourceActionAccess().getActiontypeSetKeyword_3_0_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getDSL_ResourceActionAccess().getActiontypeSetKeyword_3_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__ActiontypeAlternatives_3_0"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Alternatives_1"
    // InternalSensinact.g:1004:1: rule__DSL_Expression_DiffEqual__Alternatives_1 : ( ( ( rule__DSL_Expression_DiffEqual__Group_1_0__0 ) ) | ( ( rule__DSL_Expression_DiffEqual__Group_1_1__0 ) ) );
    public final void rule__DSL_Expression_DiffEqual__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1008:1: ( ( ( rule__DSL_Expression_DiffEqual__Group_1_0__0 ) ) | ( ( rule__DSL_Expression_DiffEqual__Group_1_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==42) ) {
                alt6=1;
            }
            else if ( (LA6_0==43) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSensinact.g:1009:2: ( ( rule__DSL_Expression_DiffEqual__Group_1_0__0 ) )
                    {
                    // InternalSensinact.g:1009:2: ( ( rule__DSL_Expression_DiffEqual__Group_1_0__0 ) )
                    // InternalSensinact.g:1010:3: ( rule__DSL_Expression_DiffEqual__Group_1_0__0 )
                    {
                     before(grammarAccess.getDSL_Expression_DiffEqualAccess().getGroup_1_0()); 
                    // InternalSensinact.g:1011:3: ( rule__DSL_Expression_DiffEqual__Group_1_0__0 )
                    // InternalSensinact.g:1011:4: rule__DSL_Expression_DiffEqual__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_DiffEqual__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_DiffEqualAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:1015:2: ( ( rule__DSL_Expression_DiffEqual__Group_1_1__0 ) )
                    {
                    // InternalSensinact.g:1015:2: ( ( rule__DSL_Expression_DiffEqual__Group_1_1__0 ) )
                    // InternalSensinact.g:1016:3: ( rule__DSL_Expression_DiffEqual__Group_1_1__0 )
                    {
                     before(grammarAccess.getDSL_Expression_DiffEqualAccess().getGroup_1_1()); 
                    // InternalSensinact.g:1017:3: ( rule__DSL_Expression_DiffEqual__Group_1_1__0 )
                    // InternalSensinact.g:1017:4: rule__DSL_Expression_DiffEqual__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_DiffEqual__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_DiffEqualAccess().getGroup_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Alternatives_1"


    // $ANTLR start "rule__DSL_Expression_Compare__Alternatives_1"
    // InternalSensinact.g:1025:1: rule__DSL_Expression_Compare__Alternatives_1 : ( ( ( rule__DSL_Expression_Compare__Group_1_0__0 ) ) | ( ( rule__DSL_Expression_Compare__Group_1_1__0 ) ) | ( ( rule__DSL_Expression_Compare__Group_1_2__0 ) ) | ( ( rule__DSL_Expression_Compare__Group_1_3__0 ) ) );
    public final void rule__DSL_Expression_Compare__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1029:1: ( ( ( rule__DSL_Expression_Compare__Group_1_0__0 ) ) | ( ( rule__DSL_Expression_Compare__Group_1_1__0 ) ) | ( ( rule__DSL_Expression_Compare__Group_1_2__0 ) ) | ( ( rule__DSL_Expression_Compare__Group_1_3__0 ) ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt7=1;
                }
                break;
            case 45:
                {
                alt7=2;
                }
                break;
            case 46:
                {
                alt7=3;
                }
                break;
            case 47:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalSensinact.g:1030:2: ( ( rule__DSL_Expression_Compare__Group_1_0__0 ) )
                    {
                    // InternalSensinact.g:1030:2: ( ( rule__DSL_Expression_Compare__Group_1_0__0 ) )
                    // InternalSensinact.g:1031:3: ( rule__DSL_Expression_Compare__Group_1_0__0 )
                    {
                     before(grammarAccess.getDSL_Expression_CompareAccess().getGroup_1_0()); 
                    // InternalSensinact.g:1032:3: ( rule__DSL_Expression_Compare__Group_1_0__0 )
                    // InternalSensinact.g:1032:4: rule__DSL_Expression_Compare__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Compare__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_CompareAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:1036:2: ( ( rule__DSL_Expression_Compare__Group_1_1__0 ) )
                    {
                    // InternalSensinact.g:1036:2: ( ( rule__DSL_Expression_Compare__Group_1_1__0 ) )
                    // InternalSensinact.g:1037:3: ( rule__DSL_Expression_Compare__Group_1_1__0 )
                    {
                     before(grammarAccess.getDSL_Expression_CompareAccess().getGroup_1_1()); 
                    // InternalSensinact.g:1038:3: ( rule__DSL_Expression_Compare__Group_1_1__0 )
                    // InternalSensinact.g:1038:4: rule__DSL_Expression_Compare__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Compare__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_CompareAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSensinact.g:1042:2: ( ( rule__DSL_Expression_Compare__Group_1_2__0 ) )
                    {
                    // InternalSensinact.g:1042:2: ( ( rule__DSL_Expression_Compare__Group_1_2__0 ) )
                    // InternalSensinact.g:1043:3: ( rule__DSL_Expression_Compare__Group_1_2__0 )
                    {
                     before(grammarAccess.getDSL_Expression_CompareAccess().getGroup_1_2()); 
                    // InternalSensinact.g:1044:3: ( rule__DSL_Expression_Compare__Group_1_2__0 )
                    // InternalSensinact.g:1044:4: rule__DSL_Expression_Compare__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Compare__Group_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_CompareAccess().getGroup_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSensinact.g:1048:2: ( ( rule__DSL_Expression_Compare__Group_1_3__0 ) )
                    {
                    // InternalSensinact.g:1048:2: ( ( rule__DSL_Expression_Compare__Group_1_3__0 ) )
                    // InternalSensinact.g:1049:3: ( rule__DSL_Expression_Compare__Group_1_3__0 )
                    {
                     before(grammarAccess.getDSL_Expression_CompareAccess().getGroup_1_3()); 
                    // InternalSensinact.g:1050:3: ( rule__DSL_Expression_Compare__Group_1_3__0 )
                    // InternalSensinact.g:1050:4: rule__DSL_Expression_Compare__Group_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Compare__Group_1_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_CompareAccess().getGroup_1_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Alternatives_1"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Alternatives_1"
    // InternalSensinact.g:1058:1: rule__DSL_Expression_PlusMinus__Alternatives_1 : ( ( ( rule__DSL_Expression_PlusMinus__Group_1_0__0 ) ) | ( ( rule__DSL_Expression_PlusMinus__Group_1_1__0 ) ) );
    public final void rule__DSL_Expression_PlusMinus__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1062:1: ( ( ( rule__DSL_Expression_PlusMinus__Group_1_0__0 ) ) | ( ( rule__DSL_Expression_PlusMinus__Group_1_1__0 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==48) ) {
                alt8=1;
            }
            else if ( (LA8_0==49) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalSensinact.g:1063:2: ( ( rule__DSL_Expression_PlusMinus__Group_1_0__0 ) )
                    {
                    // InternalSensinact.g:1063:2: ( ( rule__DSL_Expression_PlusMinus__Group_1_0__0 ) )
                    // InternalSensinact.g:1064:3: ( rule__DSL_Expression_PlusMinus__Group_1_0__0 )
                    {
                     before(grammarAccess.getDSL_Expression_PlusMinusAccess().getGroup_1_0()); 
                    // InternalSensinact.g:1065:3: ( rule__DSL_Expression_PlusMinus__Group_1_0__0 )
                    // InternalSensinact.g:1065:4: rule__DSL_Expression_PlusMinus__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_PlusMinus__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_PlusMinusAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:1069:2: ( ( rule__DSL_Expression_PlusMinus__Group_1_1__0 ) )
                    {
                    // InternalSensinact.g:1069:2: ( ( rule__DSL_Expression_PlusMinus__Group_1_1__0 ) )
                    // InternalSensinact.g:1070:3: ( rule__DSL_Expression_PlusMinus__Group_1_1__0 )
                    {
                     before(grammarAccess.getDSL_Expression_PlusMinusAccess().getGroup_1_1()); 
                    // InternalSensinact.g:1071:3: ( rule__DSL_Expression_PlusMinus__Group_1_1__0 )
                    // InternalSensinact.g:1071:4: rule__DSL_Expression_PlusMinus__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_PlusMinus__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_PlusMinusAccess().getGroup_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Alternatives_1"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Alternatives_1"
    // InternalSensinact.g:1079:1: rule__DSL_Expression_MultiplicationDivision__Alternatives_1 : ( ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_0__0 ) ) | ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_1__0 ) ) | ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_2__0 ) ) );
    public final void rule__DSL_Expression_MultiplicationDivision__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1083:1: ( ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_0__0 ) ) | ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_1__0 ) ) | ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_2__0 ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt9=1;
                }
                break;
            case 17:
                {
                alt9=2;
                }
                break;
            case 51:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalSensinact.g:1084:2: ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_0__0 ) )
                    {
                    // InternalSensinact.g:1084:2: ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_0__0 ) )
                    // InternalSensinact.g:1085:3: ( rule__DSL_Expression_MultiplicationDivision__Group_1_0__0 )
                    {
                     before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getGroup_1_0()); 
                    // InternalSensinact.g:1086:3: ( rule__DSL_Expression_MultiplicationDivision__Group_1_0__0 )
                    // InternalSensinact.g:1086:4: rule__DSL_Expression_MultiplicationDivision__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_MultiplicationDivision__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:1090:2: ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_1__0 ) )
                    {
                    // InternalSensinact.g:1090:2: ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_1__0 ) )
                    // InternalSensinact.g:1091:3: ( rule__DSL_Expression_MultiplicationDivision__Group_1_1__0 )
                    {
                     before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getGroup_1_1()); 
                    // InternalSensinact.g:1092:3: ( rule__DSL_Expression_MultiplicationDivision__Group_1_1__0 )
                    // InternalSensinact.g:1092:4: rule__DSL_Expression_MultiplicationDivision__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_MultiplicationDivision__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSensinact.g:1096:2: ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_2__0 ) )
                    {
                    // InternalSensinact.g:1096:2: ( ( rule__DSL_Expression_MultiplicationDivision__Group_1_2__0 ) )
                    // InternalSensinact.g:1097:3: ( rule__DSL_Expression_MultiplicationDivision__Group_1_2__0 )
                    {
                     before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getGroup_1_2()); 
                    // InternalSensinact.g:1098:3: ( rule__DSL_Expression_MultiplicationDivision__Group_1_2__0 )
                    // InternalSensinact.g:1098:4: rule__DSL_Expression_MultiplicationDivision__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_MultiplicationDivision__Group_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getGroup_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Alternatives_1"


    // $ANTLR start "rule__DSL_Expression_Unary__Alternatives"
    // InternalSensinact.g:1106:1: rule__DSL_Expression_Unary__Alternatives : ( ( ( rule__DSL_Expression_Unary__Group_0__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_1__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_2__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_3__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_4__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_5__0 ) ) );
    public final void rule__DSL_Expression_Unary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1110:1: ( ( ( rule__DSL_Expression_Unary__Group_0__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_1__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_2__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_3__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_4__0 ) ) | ( ( rule__DSL_Expression_Unary__Group_5__0 ) ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt10=1;
                }
                break;
            case RULE_STRING:
                {
                alt10=2;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt10=3;
                }
                break;
            case RULE_ID:
                {
                alt10=4;
                }
                break;
            case 28:
                {
                alt10=5;
                }
                break;
            case 53:
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalSensinact.g:1111:2: ( ( rule__DSL_Expression_Unary__Group_0__0 ) )
                    {
                    // InternalSensinact.g:1111:2: ( ( rule__DSL_Expression_Unary__Group_0__0 ) )
                    // InternalSensinact.g:1112:3: ( rule__DSL_Expression_Unary__Group_0__0 )
                    {
                     before(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_0()); 
                    // InternalSensinact.g:1113:3: ( rule__DSL_Expression_Unary__Group_0__0 )
                    // InternalSensinact.g:1113:4: rule__DSL_Expression_Unary__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Unary__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:1117:2: ( ( rule__DSL_Expression_Unary__Group_1__0 ) )
                    {
                    // InternalSensinact.g:1117:2: ( ( rule__DSL_Expression_Unary__Group_1__0 ) )
                    // InternalSensinact.g:1118:3: ( rule__DSL_Expression_Unary__Group_1__0 )
                    {
                     before(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_1()); 
                    // InternalSensinact.g:1119:3: ( rule__DSL_Expression_Unary__Group_1__0 )
                    // InternalSensinact.g:1119:4: rule__DSL_Expression_Unary__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Unary__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSensinact.g:1123:2: ( ( rule__DSL_Expression_Unary__Group_2__0 ) )
                    {
                    // InternalSensinact.g:1123:2: ( ( rule__DSL_Expression_Unary__Group_2__0 ) )
                    // InternalSensinact.g:1124:3: ( rule__DSL_Expression_Unary__Group_2__0 )
                    {
                     before(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_2()); 
                    // InternalSensinact.g:1125:3: ( rule__DSL_Expression_Unary__Group_2__0 )
                    // InternalSensinact.g:1125:4: rule__DSL_Expression_Unary__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Unary__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSensinact.g:1129:2: ( ( rule__DSL_Expression_Unary__Group_3__0 ) )
                    {
                    // InternalSensinact.g:1129:2: ( ( rule__DSL_Expression_Unary__Group_3__0 ) )
                    // InternalSensinact.g:1130:3: ( rule__DSL_Expression_Unary__Group_3__0 )
                    {
                     before(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_3()); 
                    // InternalSensinact.g:1131:3: ( rule__DSL_Expression_Unary__Group_3__0 )
                    // InternalSensinact.g:1131:4: rule__DSL_Expression_Unary__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Unary__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSensinact.g:1135:2: ( ( rule__DSL_Expression_Unary__Group_4__0 ) )
                    {
                    // InternalSensinact.g:1135:2: ( ( rule__DSL_Expression_Unary__Group_4__0 ) )
                    // InternalSensinact.g:1136:3: ( rule__DSL_Expression_Unary__Group_4__0 )
                    {
                     before(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_4()); 
                    // InternalSensinact.g:1137:3: ( rule__DSL_Expression_Unary__Group_4__0 )
                    // InternalSensinact.g:1137:4: rule__DSL_Expression_Unary__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Unary__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSensinact.g:1141:2: ( ( rule__DSL_Expression_Unary__Group_5__0 ) )
                    {
                    // InternalSensinact.g:1141:2: ( ( rule__DSL_Expression_Unary__Group_5__0 ) )
                    // InternalSensinact.g:1142:3: ( rule__DSL_Expression_Unary__Group_5__0 )
                    {
                     before(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_5()); 
                    // InternalSensinact.g:1143:3: ( rule__DSL_Expression_Unary__Group_5__0 )
                    // InternalSensinact.g:1143:4: rule__DSL_Expression_Unary__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_Expression_Unary__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDSL_Expression_UnaryAccess().getGroup_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Alternatives"


    // $ANTLR start "rule__Sensinact__Group__0"
    // InternalSensinact.g:1151:1: rule__Sensinact__Group__0 : rule__Sensinact__Group__0__Impl rule__Sensinact__Group__1 ;
    public final void rule__Sensinact__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1155:1: ( rule__Sensinact__Group__0__Impl rule__Sensinact__Group__1 )
            // InternalSensinact.g:1156:2: rule__Sensinact__Group__0__Impl rule__Sensinact__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Sensinact__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensinact__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensinact__Group__0"


    // $ANTLR start "rule__Sensinact__Group__0__Impl"
    // InternalSensinact.g:1163:1: rule__Sensinact__Group__0__Impl : ( () ) ;
    public final void rule__Sensinact__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1167:1: ( ( () ) )
            // InternalSensinact.g:1168:1: ( () )
            {
            // InternalSensinact.g:1168:1: ( () )
            // InternalSensinact.g:1169:2: ()
            {
             before(grammarAccess.getSensinactAccess().getSensinactAction_0()); 
            // InternalSensinact.g:1170:2: ()
            // InternalSensinact.g:1170:3: 
            {
            }

             after(grammarAccess.getSensinactAccess().getSensinactAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensinact__Group__0__Impl"


    // $ANTLR start "rule__Sensinact__Group__1"
    // InternalSensinact.g:1178:1: rule__Sensinact__Group__1 : rule__Sensinact__Group__1__Impl ;
    public final void rule__Sensinact__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1182:1: ( rule__Sensinact__Group__1__Impl )
            // InternalSensinact.g:1183:2: rule__Sensinact__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sensinact__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensinact__Group__1"


    // $ANTLR start "rule__Sensinact__Group__1__Impl"
    // InternalSensinact.g:1189:1: rule__Sensinact__Group__1__Impl : ( ( rule__Sensinact__EcaAssignment_1 ) ) ;
    public final void rule__Sensinact__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1193:1: ( ( ( rule__Sensinact__EcaAssignment_1 ) ) )
            // InternalSensinact.g:1194:1: ( ( rule__Sensinact__EcaAssignment_1 ) )
            {
            // InternalSensinact.g:1194:1: ( ( rule__Sensinact__EcaAssignment_1 ) )
            // InternalSensinact.g:1195:2: ( rule__Sensinact__EcaAssignment_1 )
            {
             before(grammarAccess.getSensinactAccess().getEcaAssignment_1()); 
            // InternalSensinact.g:1196:2: ( rule__Sensinact__EcaAssignment_1 )
            // InternalSensinact.g:1196:3: rule__Sensinact__EcaAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Sensinact__EcaAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSensinactAccess().getEcaAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensinact__Group__1__Impl"


    // $ANTLR start "rule__DSL_SENSINACT__Group__0"
    // InternalSensinact.g:1205:1: rule__DSL_SENSINACT__Group__0 : rule__DSL_SENSINACT__Group__0__Impl rule__DSL_SENSINACT__Group__1 ;
    public final void rule__DSL_SENSINACT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1209:1: ( rule__DSL_SENSINACT__Group__0__Impl rule__DSL_SENSINACT__Group__1 )
            // InternalSensinact.g:1210:2: rule__DSL_SENSINACT__Group__0__Impl rule__DSL_SENSINACT__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__DSL_SENSINACT__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_SENSINACT__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__Group__0"


    // $ANTLR start "rule__DSL_SENSINACT__Group__0__Impl"
    // InternalSensinact.g:1217:1: rule__DSL_SENSINACT__Group__0__Impl : ( ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 ) ) ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 )* ) ) ;
    public final void rule__DSL_SENSINACT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1221:1: ( ( ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 ) ) ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 )* ) ) )
            // InternalSensinact.g:1222:1: ( ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 ) ) ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 )* ) )
            {
            // InternalSensinact.g:1222:1: ( ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 ) ) ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 )* ) )
            // InternalSensinact.g:1223:2: ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 ) ) ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 )* )
            {
            // InternalSensinact.g:1223:2: ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 ) )
            // InternalSensinact.g:1224:3: ( rule__DSL_SENSINACT__ResourcesAssignment_0 )
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getResourcesAssignment_0()); 
            // InternalSensinact.g:1225:3: ( rule__DSL_SENSINACT__ResourcesAssignment_0 )
            // InternalSensinact.g:1225:4: rule__DSL_SENSINACT__ResourcesAssignment_0
            {
            pushFollow(FOLLOW_6);
            rule__DSL_SENSINACT__ResourcesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_SENSINACTAccess().getResourcesAssignment_0()); 

            }

            // InternalSensinact.g:1228:2: ( ( rule__DSL_SENSINACT__ResourcesAssignment_0 )* )
            // InternalSensinact.g:1229:3: ( rule__DSL_SENSINACT__ResourcesAssignment_0 )*
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getResourcesAssignment_0()); 
            // InternalSensinact.g:1230:3: ( rule__DSL_SENSINACT__ResourcesAssignment_0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==14) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSensinact.g:1230:4: rule__DSL_SENSINACT__ResourcesAssignment_0
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__DSL_SENSINACT__ResourcesAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getDSL_SENSINACTAccess().getResourcesAssignment_0()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__Group__0__Impl"


    // $ANTLR start "rule__DSL_SENSINACT__Group__1"
    // InternalSensinact.g:1239:1: rule__DSL_SENSINACT__Group__1 : rule__DSL_SENSINACT__Group__1__Impl rule__DSL_SENSINACT__Group__2 ;
    public final void rule__DSL_SENSINACT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1243:1: ( rule__DSL_SENSINACT__Group__1__Impl rule__DSL_SENSINACT__Group__2 )
            // InternalSensinact.g:1244:2: rule__DSL_SENSINACT__Group__1__Impl rule__DSL_SENSINACT__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__DSL_SENSINACT__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_SENSINACT__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__Group__1"


    // $ANTLR start "rule__DSL_SENSINACT__Group__1__Impl"
    // InternalSensinact.g:1251:1: rule__DSL_SENSINACT__Group__1__Impl : ( ( rule__DSL_SENSINACT__CepAssignment_1 )* ) ;
    public final void rule__DSL_SENSINACT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1255:1: ( ( ( rule__DSL_SENSINACT__CepAssignment_1 )* ) )
            // InternalSensinact.g:1256:1: ( ( rule__DSL_SENSINACT__CepAssignment_1 )* )
            {
            // InternalSensinact.g:1256:1: ( ( rule__DSL_SENSINACT__CepAssignment_1 )* )
            // InternalSensinact.g:1257:2: ( rule__DSL_SENSINACT__CepAssignment_1 )*
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getCepAssignment_1()); 
            // InternalSensinact.g:1258:2: ( rule__DSL_SENSINACT__CepAssignment_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==30) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalSensinact.g:1258:3: rule__DSL_SENSINACT__CepAssignment_1
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__DSL_SENSINACT__CepAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getDSL_SENSINACTAccess().getCepAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__Group__1__Impl"


    // $ANTLR start "rule__DSL_SENSINACT__Group__2"
    // InternalSensinact.g:1266:1: rule__DSL_SENSINACT__Group__2 : rule__DSL_SENSINACT__Group__2__Impl rule__DSL_SENSINACT__Group__3 ;
    public final void rule__DSL_SENSINACT__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1270:1: ( rule__DSL_SENSINACT__Group__2__Impl rule__DSL_SENSINACT__Group__3 )
            // InternalSensinact.g:1271:2: rule__DSL_SENSINACT__Group__2__Impl rule__DSL_SENSINACT__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__DSL_SENSINACT__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_SENSINACT__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__Group__2"


    // $ANTLR start "rule__DSL_SENSINACT__Group__2__Impl"
    // InternalSensinact.g:1278:1: rule__DSL_SENSINACT__Group__2__Impl : ( ( rule__DSL_SENSINACT__OnAssignment_2 ) ) ;
    public final void rule__DSL_SENSINACT__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1282:1: ( ( ( rule__DSL_SENSINACT__OnAssignment_2 ) ) )
            // InternalSensinact.g:1283:1: ( ( rule__DSL_SENSINACT__OnAssignment_2 ) )
            {
            // InternalSensinact.g:1283:1: ( ( rule__DSL_SENSINACT__OnAssignment_2 ) )
            // InternalSensinact.g:1284:2: ( rule__DSL_SENSINACT__OnAssignment_2 )
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getOnAssignment_2()); 
            // InternalSensinact.g:1285:2: ( rule__DSL_SENSINACT__OnAssignment_2 )
            // InternalSensinact.g:1285:3: rule__DSL_SENSINACT__OnAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_SENSINACT__OnAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_SENSINACTAccess().getOnAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__Group__2__Impl"


    // $ANTLR start "rule__DSL_SENSINACT__Group__3"
    // InternalSensinact.g:1293:1: rule__DSL_SENSINACT__Group__3 : rule__DSL_SENSINACT__Group__3__Impl ;
    public final void rule__DSL_SENSINACT__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1297:1: ( rule__DSL_SENSINACT__Group__3__Impl )
            // InternalSensinact.g:1298:2: rule__DSL_SENSINACT__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_SENSINACT__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__Group__3"


    // $ANTLR start "rule__DSL_SENSINACT__Group__3__Impl"
    // InternalSensinact.g:1304:1: rule__DSL_SENSINACT__Group__3__Impl : ( ( rule__DSL_SENSINACT__EcaAssignment_3 ) ) ;
    public final void rule__DSL_SENSINACT__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1308:1: ( ( ( rule__DSL_SENSINACT__EcaAssignment_3 ) ) )
            // InternalSensinact.g:1309:1: ( ( rule__DSL_SENSINACT__EcaAssignment_3 ) )
            {
            // InternalSensinact.g:1309:1: ( ( rule__DSL_SENSINACT__EcaAssignment_3 ) )
            // InternalSensinact.g:1310:2: ( rule__DSL_SENSINACT__EcaAssignment_3 )
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getEcaAssignment_3()); 
            // InternalSensinact.g:1311:2: ( rule__DSL_SENSINACT__EcaAssignment_3 )
            // InternalSensinact.g:1311:3: rule__DSL_SENSINACT__EcaAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DSL_SENSINACT__EcaAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDSL_SENSINACTAccess().getEcaAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__Group__3__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__0"
    // InternalSensinact.g:1320:1: rule__DSL_Resource__Group__0 : rule__DSL_Resource__Group__0__Impl rule__DSL_Resource__Group__1 ;
    public final void rule__DSL_Resource__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1324:1: ( rule__DSL_Resource__Group__0__Impl rule__DSL_Resource__Group__1 )
            // InternalSensinact.g:1325:2: rule__DSL_Resource__Group__0__Impl rule__DSL_Resource__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__DSL_Resource__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__0"


    // $ANTLR start "rule__DSL_Resource__Group__0__Impl"
    // InternalSensinact.g:1332:1: rule__DSL_Resource__Group__0__Impl : ( 'resource' ) ;
    public final void rule__DSL_Resource__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1336:1: ( ( 'resource' ) )
            // InternalSensinact.g:1337:1: ( 'resource' )
            {
            // InternalSensinact.g:1337:1: ( 'resource' )
            // InternalSensinact.g:1338:2: 'resource'
            {
             before(grammarAccess.getDSL_ResourceAccess().getResourceKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceAccess().getResourceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__0__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__1"
    // InternalSensinact.g:1347:1: rule__DSL_Resource__Group__1 : rule__DSL_Resource__Group__1__Impl rule__DSL_Resource__Group__2 ;
    public final void rule__DSL_Resource__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1351:1: ( rule__DSL_Resource__Group__1__Impl rule__DSL_Resource__Group__2 )
            // InternalSensinact.g:1352:2: rule__DSL_Resource__Group__1__Impl rule__DSL_Resource__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__DSL_Resource__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__1"


    // $ANTLR start "rule__DSL_Resource__Group__1__Impl"
    // InternalSensinact.g:1359:1: rule__DSL_Resource__Group__1__Impl : ( ( rule__DSL_Resource__NameAssignment_1 ) ) ;
    public final void rule__DSL_Resource__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1363:1: ( ( ( rule__DSL_Resource__NameAssignment_1 ) ) )
            // InternalSensinact.g:1364:1: ( ( rule__DSL_Resource__NameAssignment_1 ) )
            {
            // InternalSensinact.g:1364:1: ( ( rule__DSL_Resource__NameAssignment_1 ) )
            // InternalSensinact.g:1365:2: ( rule__DSL_Resource__NameAssignment_1 )
            {
             before(grammarAccess.getDSL_ResourceAccess().getNameAssignment_1()); 
            // InternalSensinact.g:1366:2: ( rule__DSL_Resource__NameAssignment_1 )
            // InternalSensinact.g:1366:3: rule__DSL_Resource__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Resource__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__1__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__2"
    // InternalSensinact.g:1374:1: rule__DSL_Resource__Group__2 : rule__DSL_Resource__Group__2__Impl rule__DSL_Resource__Group__3 ;
    public final void rule__DSL_Resource__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1378:1: ( rule__DSL_Resource__Group__2__Impl rule__DSL_Resource__Group__3 )
            // InternalSensinact.g:1379:2: rule__DSL_Resource__Group__2__Impl rule__DSL_Resource__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__DSL_Resource__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__2"


    // $ANTLR start "rule__DSL_Resource__Group__2__Impl"
    // InternalSensinact.g:1386:1: rule__DSL_Resource__Group__2__Impl : ( '=' ) ;
    public final void rule__DSL_Resource__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1390:1: ( ( '=' ) )
            // InternalSensinact.g:1391:1: ( '=' )
            {
            // InternalSensinact.g:1391:1: ( '=' )
            // InternalSensinact.g:1392:2: '='
            {
             before(grammarAccess.getDSL_ResourceAccess().getEqualsSignKeyword_2()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__2__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__3"
    // InternalSensinact.g:1401:1: rule__DSL_Resource__Group__3 : rule__DSL_Resource__Group__3__Impl rule__DSL_Resource__Group__4 ;
    public final void rule__DSL_Resource__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1405:1: ( rule__DSL_Resource__Group__3__Impl rule__DSL_Resource__Group__4 )
            // InternalSensinact.g:1406:2: rule__DSL_Resource__Group__3__Impl rule__DSL_Resource__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__DSL_Resource__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__3"


    // $ANTLR start "rule__DSL_Resource__Group__3__Impl"
    // InternalSensinact.g:1413:1: rule__DSL_Resource__Group__3__Impl : ( '[' ) ;
    public final void rule__DSL_Resource__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1417:1: ( ( '[' ) )
            // InternalSensinact.g:1418:1: ( '[' )
            {
            // InternalSensinact.g:1418:1: ( '[' )
            // InternalSensinact.g:1419:2: '['
            {
             before(grammarAccess.getDSL_ResourceAccess().getLeftSquareBracketKeyword_3()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__3__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__4"
    // InternalSensinact.g:1428:1: rule__DSL_Resource__Group__4 : rule__DSL_Resource__Group__4__Impl rule__DSL_Resource__Group__5 ;
    public final void rule__DSL_Resource__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1432:1: ( rule__DSL_Resource__Group__4__Impl rule__DSL_Resource__Group__5 )
            // InternalSensinact.g:1433:2: rule__DSL_Resource__Group__4__Impl rule__DSL_Resource__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__DSL_Resource__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__4"


    // $ANTLR start "rule__DSL_Resource__Group__4__Impl"
    // InternalSensinact.g:1440:1: rule__DSL_Resource__Group__4__Impl : ( ( rule__DSL_Resource__GatewayIDAssignment_4 ) ) ;
    public final void rule__DSL_Resource__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1444:1: ( ( ( rule__DSL_Resource__GatewayIDAssignment_4 ) ) )
            // InternalSensinact.g:1445:1: ( ( rule__DSL_Resource__GatewayIDAssignment_4 ) )
            {
            // InternalSensinact.g:1445:1: ( ( rule__DSL_Resource__GatewayIDAssignment_4 ) )
            // InternalSensinact.g:1446:2: ( rule__DSL_Resource__GatewayIDAssignment_4 )
            {
             before(grammarAccess.getDSL_ResourceAccess().getGatewayIDAssignment_4()); 
            // InternalSensinact.g:1447:2: ( rule__DSL_Resource__GatewayIDAssignment_4 )
            // InternalSensinact.g:1447:3: rule__DSL_Resource__GatewayIDAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Resource__GatewayIDAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceAccess().getGatewayIDAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__4__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__5"
    // InternalSensinact.g:1455:1: rule__DSL_Resource__Group__5 : rule__DSL_Resource__Group__5__Impl rule__DSL_Resource__Group__6 ;
    public final void rule__DSL_Resource__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1459:1: ( rule__DSL_Resource__Group__5__Impl rule__DSL_Resource__Group__6 )
            // InternalSensinact.g:1460:2: rule__DSL_Resource__Group__5__Impl rule__DSL_Resource__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__DSL_Resource__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__5"


    // $ANTLR start "rule__DSL_Resource__Group__5__Impl"
    // InternalSensinact.g:1467:1: rule__DSL_Resource__Group__5__Impl : ( '/' ) ;
    public final void rule__DSL_Resource__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1471:1: ( ( '/' ) )
            // InternalSensinact.g:1472:1: ( '/' )
            {
            // InternalSensinact.g:1472:1: ( '/' )
            // InternalSensinact.g:1473:2: '/'
            {
             before(grammarAccess.getDSL_ResourceAccess().getSolidusKeyword_5()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceAccess().getSolidusKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__5__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__6"
    // InternalSensinact.g:1482:1: rule__DSL_Resource__Group__6 : rule__DSL_Resource__Group__6__Impl rule__DSL_Resource__Group__7 ;
    public final void rule__DSL_Resource__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1486:1: ( rule__DSL_Resource__Group__6__Impl rule__DSL_Resource__Group__7 )
            // InternalSensinact.g:1487:2: rule__DSL_Resource__Group__6__Impl rule__DSL_Resource__Group__7
            {
            pushFollow(FOLLOW_12);
            rule__DSL_Resource__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__6"


    // $ANTLR start "rule__DSL_Resource__Group__6__Impl"
    // InternalSensinact.g:1494:1: rule__DSL_Resource__Group__6__Impl : ( ( rule__DSL_Resource__DeviceIDAssignment_6 ) ) ;
    public final void rule__DSL_Resource__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1498:1: ( ( ( rule__DSL_Resource__DeviceIDAssignment_6 ) ) )
            // InternalSensinact.g:1499:1: ( ( rule__DSL_Resource__DeviceIDAssignment_6 ) )
            {
            // InternalSensinact.g:1499:1: ( ( rule__DSL_Resource__DeviceIDAssignment_6 ) )
            // InternalSensinact.g:1500:2: ( rule__DSL_Resource__DeviceIDAssignment_6 )
            {
             before(grammarAccess.getDSL_ResourceAccess().getDeviceIDAssignment_6()); 
            // InternalSensinact.g:1501:2: ( rule__DSL_Resource__DeviceIDAssignment_6 )
            // InternalSensinact.g:1501:3: rule__DSL_Resource__DeviceIDAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Resource__DeviceIDAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceAccess().getDeviceIDAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__6__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__7"
    // InternalSensinact.g:1509:1: rule__DSL_Resource__Group__7 : rule__DSL_Resource__Group__7__Impl rule__DSL_Resource__Group__8 ;
    public final void rule__DSL_Resource__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1513:1: ( rule__DSL_Resource__Group__7__Impl rule__DSL_Resource__Group__8 )
            // InternalSensinact.g:1514:2: rule__DSL_Resource__Group__7__Impl rule__DSL_Resource__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__DSL_Resource__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__7"


    // $ANTLR start "rule__DSL_Resource__Group__7__Impl"
    // InternalSensinact.g:1521:1: rule__DSL_Resource__Group__7__Impl : ( '/' ) ;
    public final void rule__DSL_Resource__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1525:1: ( ( '/' ) )
            // InternalSensinact.g:1526:1: ( '/' )
            {
            // InternalSensinact.g:1526:1: ( '/' )
            // InternalSensinact.g:1527:2: '/'
            {
             before(grammarAccess.getDSL_ResourceAccess().getSolidusKeyword_7()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceAccess().getSolidusKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__7__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__8"
    // InternalSensinact.g:1536:1: rule__DSL_Resource__Group__8 : rule__DSL_Resource__Group__8__Impl rule__DSL_Resource__Group__9 ;
    public final void rule__DSL_Resource__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1540:1: ( rule__DSL_Resource__Group__8__Impl rule__DSL_Resource__Group__9 )
            // InternalSensinact.g:1541:2: rule__DSL_Resource__Group__8__Impl rule__DSL_Resource__Group__9
            {
            pushFollow(FOLLOW_12);
            rule__DSL_Resource__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__8"


    // $ANTLR start "rule__DSL_Resource__Group__8__Impl"
    // InternalSensinact.g:1548:1: rule__DSL_Resource__Group__8__Impl : ( ( rule__DSL_Resource__ServiceIDAssignment_8 ) ) ;
    public final void rule__DSL_Resource__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1552:1: ( ( ( rule__DSL_Resource__ServiceIDAssignment_8 ) ) )
            // InternalSensinact.g:1553:1: ( ( rule__DSL_Resource__ServiceIDAssignment_8 ) )
            {
            // InternalSensinact.g:1553:1: ( ( rule__DSL_Resource__ServiceIDAssignment_8 ) )
            // InternalSensinact.g:1554:2: ( rule__DSL_Resource__ServiceIDAssignment_8 )
            {
             before(grammarAccess.getDSL_ResourceAccess().getServiceIDAssignment_8()); 
            // InternalSensinact.g:1555:2: ( rule__DSL_Resource__ServiceIDAssignment_8 )
            // InternalSensinact.g:1555:3: rule__DSL_Resource__ServiceIDAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Resource__ServiceIDAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceAccess().getServiceIDAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__8__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__9"
    // InternalSensinact.g:1563:1: rule__DSL_Resource__Group__9 : rule__DSL_Resource__Group__9__Impl rule__DSL_Resource__Group__10 ;
    public final void rule__DSL_Resource__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1567:1: ( rule__DSL_Resource__Group__9__Impl rule__DSL_Resource__Group__10 )
            // InternalSensinact.g:1568:2: rule__DSL_Resource__Group__9__Impl rule__DSL_Resource__Group__10
            {
            pushFollow(FOLLOW_9);
            rule__DSL_Resource__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__9"


    // $ANTLR start "rule__DSL_Resource__Group__9__Impl"
    // InternalSensinact.g:1575:1: rule__DSL_Resource__Group__9__Impl : ( '/' ) ;
    public final void rule__DSL_Resource__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1579:1: ( ( '/' ) )
            // InternalSensinact.g:1580:1: ( '/' )
            {
            // InternalSensinact.g:1580:1: ( '/' )
            // InternalSensinact.g:1581:2: '/'
            {
             before(grammarAccess.getDSL_ResourceAccess().getSolidusKeyword_9()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceAccess().getSolidusKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__9__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__10"
    // InternalSensinact.g:1590:1: rule__DSL_Resource__Group__10 : rule__DSL_Resource__Group__10__Impl rule__DSL_Resource__Group__11 ;
    public final void rule__DSL_Resource__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1594:1: ( rule__DSL_Resource__Group__10__Impl rule__DSL_Resource__Group__11 )
            // InternalSensinact.g:1595:2: rule__DSL_Resource__Group__10__Impl rule__DSL_Resource__Group__11
            {
            pushFollow(FOLLOW_13);
            rule__DSL_Resource__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__10"


    // $ANTLR start "rule__DSL_Resource__Group__10__Impl"
    // InternalSensinact.g:1602:1: rule__DSL_Resource__Group__10__Impl : ( ( rule__DSL_Resource__ResourceIDAssignment_10 ) ) ;
    public final void rule__DSL_Resource__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1606:1: ( ( ( rule__DSL_Resource__ResourceIDAssignment_10 ) ) )
            // InternalSensinact.g:1607:1: ( ( rule__DSL_Resource__ResourceIDAssignment_10 ) )
            {
            // InternalSensinact.g:1607:1: ( ( rule__DSL_Resource__ResourceIDAssignment_10 ) )
            // InternalSensinact.g:1608:2: ( rule__DSL_Resource__ResourceIDAssignment_10 )
            {
             before(grammarAccess.getDSL_ResourceAccess().getResourceIDAssignment_10()); 
            // InternalSensinact.g:1609:2: ( rule__DSL_Resource__ResourceIDAssignment_10 )
            // InternalSensinact.g:1609:3: rule__DSL_Resource__ResourceIDAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Resource__ResourceIDAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceAccess().getResourceIDAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__10__Impl"


    // $ANTLR start "rule__DSL_Resource__Group__11"
    // InternalSensinact.g:1617:1: rule__DSL_Resource__Group__11 : rule__DSL_Resource__Group__11__Impl ;
    public final void rule__DSL_Resource__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1621:1: ( rule__DSL_Resource__Group__11__Impl )
            // InternalSensinact.g:1622:2: rule__DSL_Resource__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Resource__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__11"


    // $ANTLR start "rule__DSL_Resource__Group__11__Impl"
    // InternalSensinact.g:1628:1: rule__DSL_Resource__Group__11__Impl : ( ']' ) ;
    public final void rule__DSL_Resource__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1632:1: ( ( ']' ) )
            // InternalSensinact.g:1633:1: ( ']' )
            {
            // InternalSensinact.g:1633:1: ( ']' )
            // InternalSensinact.g:1634:2: ']'
            {
             before(grammarAccess.getDSL_ResourceAccess().getRightSquareBracketKeyword_11()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceAccess().getRightSquareBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__Group__11__Impl"


    // $ANTLR start "rule__DSL_On__Group__0"
    // InternalSensinact.g:1644:1: rule__DSL_On__Group__0 : rule__DSL_On__Group__0__Impl rule__DSL_On__Group__1 ;
    public final void rule__DSL_On__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1648:1: ( rule__DSL_On__Group__0__Impl rule__DSL_On__Group__1 )
            // InternalSensinact.g:1649:2: rule__DSL_On__Group__0__Impl rule__DSL_On__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__DSL_On__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_On__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group__0"


    // $ANTLR start "rule__DSL_On__Group__0__Impl"
    // InternalSensinact.g:1656:1: rule__DSL_On__Group__0__Impl : ( 'on' ) ;
    public final void rule__DSL_On__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1660:1: ( ( 'on' ) )
            // InternalSensinact.g:1661:1: ( 'on' )
            {
            // InternalSensinact.g:1661:1: ( 'on' )
            // InternalSensinact.g:1662:2: 'on'
            {
             before(grammarAccess.getDSL_OnAccess().getOnKeyword_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getDSL_OnAccess().getOnKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group__0__Impl"


    // $ANTLR start "rule__DSL_On__Group__1"
    // InternalSensinact.g:1671:1: rule__DSL_On__Group__1 : rule__DSL_On__Group__1__Impl rule__DSL_On__Group__2 ;
    public final void rule__DSL_On__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1675:1: ( rule__DSL_On__Group__1__Impl rule__DSL_On__Group__2 )
            // InternalSensinact.g:1676:2: rule__DSL_On__Group__1__Impl rule__DSL_On__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__DSL_On__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_On__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group__1"


    // $ANTLR start "rule__DSL_On__Group__1__Impl"
    // InternalSensinact.g:1683:1: rule__DSL_On__Group__1__Impl : ( ( rule__DSL_On__TriggersAssignment_1 ) ) ;
    public final void rule__DSL_On__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1687:1: ( ( ( rule__DSL_On__TriggersAssignment_1 ) ) )
            // InternalSensinact.g:1688:1: ( ( rule__DSL_On__TriggersAssignment_1 ) )
            {
            // InternalSensinact.g:1688:1: ( ( rule__DSL_On__TriggersAssignment_1 ) )
            // InternalSensinact.g:1689:2: ( rule__DSL_On__TriggersAssignment_1 )
            {
             before(grammarAccess.getDSL_OnAccess().getTriggersAssignment_1()); 
            // InternalSensinact.g:1690:2: ( rule__DSL_On__TriggersAssignment_1 )
            // InternalSensinact.g:1690:3: rule__DSL_On__TriggersAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_On__TriggersAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_OnAccess().getTriggersAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group__1__Impl"


    // $ANTLR start "rule__DSL_On__Group__2"
    // InternalSensinact.g:1698:1: rule__DSL_On__Group__2 : rule__DSL_On__Group__2__Impl ;
    public final void rule__DSL_On__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1702:1: ( rule__DSL_On__Group__2__Impl )
            // InternalSensinact.g:1703:2: rule__DSL_On__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_On__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group__2"


    // $ANTLR start "rule__DSL_On__Group__2__Impl"
    // InternalSensinact.g:1709:1: rule__DSL_On__Group__2__Impl : ( ( rule__DSL_On__Group_2__0 )* ) ;
    public final void rule__DSL_On__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1713:1: ( ( ( rule__DSL_On__Group_2__0 )* ) )
            // InternalSensinact.g:1714:1: ( ( rule__DSL_On__Group_2__0 )* )
            {
            // InternalSensinact.g:1714:1: ( ( rule__DSL_On__Group_2__0 )* )
            // InternalSensinact.g:1715:2: ( rule__DSL_On__Group_2__0 )*
            {
             before(grammarAccess.getDSL_OnAccess().getGroup_2()); 
            // InternalSensinact.g:1716:2: ( rule__DSL_On__Group_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSensinact.g:1716:3: rule__DSL_On__Group_2__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__DSL_On__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getDSL_OnAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group__2__Impl"


    // $ANTLR start "rule__DSL_On__Group_2__0"
    // InternalSensinact.g:1725:1: rule__DSL_On__Group_2__0 : rule__DSL_On__Group_2__0__Impl rule__DSL_On__Group_2__1 ;
    public final void rule__DSL_On__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1729:1: ( rule__DSL_On__Group_2__0__Impl rule__DSL_On__Group_2__1 )
            // InternalSensinact.g:1730:2: rule__DSL_On__Group_2__0__Impl rule__DSL_On__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__DSL_On__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_On__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group_2__0"


    // $ANTLR start "rule__DSL_On__Group_2__0__Impl"
    // InternalSensinact.g:1737:1: rule__DSL_On__Group_2__0__Impl : ( ',' ) ;
    public final void rule__DSL_On__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1741:1: ( ( ',' ) )
            // InternalSensinact.g:1742:1: ( ',' )
            {
            // InternalSensinact.g:1742:1: ( ',' )
            // InternalSensinact.g:1743:2: ','
            {
             before(grammarAccess.getDSL_OnAccess().getCommaKeyword_2_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_OnAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group_2__0__Impl"


    // $ANTLR start "rule__DSL_On__Group_2__1"
    // InternalSensinact.g:1752:1: rule__DSL_On__Group_2__1 : rule__DSL_On__Group_2__1__Impl ;
    public final void rule__DSL_On__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1756:1: ( rule__DSL_On__Group_2__1__Impl )
            // InternalSensinact.g:1757:2: rule__DSL_On__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_On__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group_2__1"


    // $ANTLR start "rule__DSL_On__Group_2__1__Impl"
    // InternalSensinact.g:1763:1: rule__DSL_On__Group_2__1__Impl : ( ( rule__DSL_On__TriggersAssignment_2_1 ) ) ;
    public final void rule__DSL_On__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1767:1: ( ( ( rule__DSL_On__TriggersAssignment_2_1 ) ) )
            // InternalSensinact.g:1768:1: ( ( rule__DSL_On__TriggersAssignment_2_1 ) )
            {
            // InternalSensinact.g:1768:1: ( ( rule__DSL_On__TriggersAssignment_2_1 ) )
            // InternalSensinact.g:1769:2: ( rule__DSL_On__TriggersAssignment_2_1 )
            {
             before(grammarAccess.getDSL_OnAccess().getTriggersAssignment_2_1()); 
            // InternalSensinact.g:1770:2: ( rule__DSL_On__TriggersAssignment_2_1 )
            // InternalSensinact.g:1770:3: rule__DSL_On__TriggersAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_On__TriggersAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_OnAccess().getTriggersAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__Group_2__1__Impl"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__Group__0"
    // InternalSensinact.g:1779:1: rule__DSL_ECA_STATEMENT__Group__0 : rule__DSL_ECA_STATEMENT__Group__0__Impl rule__DSL_ECA_STATEMENT__Group__1 ;
    public final void rule__DSL_ECA_STATEMENT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1783:1: ( rule__DSL_ECA_STATEMENT__Group__0__Impl rule__DSL_ECA_STATEMENT__Group__1 )
            // InternalSensinact.g:1784:2: rule__DSL_ECA_STATEMENT__Group__0__Impl rule__DSL_ECA_STATEMENT__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__DSL_ECA_STATEMENT__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ECA_STATEMENT__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__Group__0"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__Group__0__Impl"
    // InternalSensinact.g:1791:1: rule__DSL_ECA_STATEMENT__Group__0__Impl : ( ( rule__DSL_ECA_STATEMENT__IfdoAssignment_0 ) ) ;
    public final void rule__DSL_ECA_STATEMENT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1795:1: ( ( ( rule__DSL_ECA_STATEMENT__IfdoAssignment_0 ) ) )
            // InternalSensinact.g:1796:1: ( ( rule__DSL_ECA_STATEMENT__IfdoAssignment_0 ) )
            {
            // InternalSensinact.g:1796:1: ( ( rule__DSL_ECA_STATEMENT__IfdoAssignment_0 ) )
            // InternalSensinact.g:1797:2: ( rule__DSL_ECA_STATEMENT__IfdoAssignment_0 )
            {
             before(grammarAccess.getDSL_ECA_STATEMENTAccess().getIfdoAssignment_0()); 
            // InternalSensinact.g:1798:2: ( rule__DSL_ECA_STATEMENT__IfdoAssignment_0 )
            // InternalSensinact.g:1798:3: rule__DSL_ECA_STATEMENT__IfdoAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ECA_STATEMENT__IfdoAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ECA_STATEMENTAccess().getIfdoAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__Group__0__Impl"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__Group__1"
    // InternalSensinact.g:1806:1: rule__DSL_ECA_STATEMENT__Group__1 : rule__DSL_ECA_STATEMENT__Group__1__Impl rule__DSL_ECA_STATEMENT__Group__2 ;
    public final void rule__DSL_ECA_STATEMENT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1810:1: ( rule__DSL_ECA_STATEMENT__Group__1__Impl rule__DSL_ECA_STATEMENT__Group__2 )
            // InternalSensinact.g:1811:2: rule__DSL_ECA_STATEMENT__Group__1__Impl rule__DSL_ECA_STATEMENT__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__DSL_ECA_STATEMENT__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ECA_STATEMENT__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__Group__1"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__Group__1__Impl"
    // InternalSensinact.g:1818:1: rule__DSL_ECA_STATEMENT__Group__1__Impl : ( ( rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1 )* ) ;
    public final void rule__DSL_ECA_STATEMENT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1822:1: ( ( ( rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1 )* ) )
            // InternalSensinact.g:1823:1: ( ( rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1 )* )
            {
            // InternalSensinact.g:1823:1: ( ( rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1 )* )
            // InternalSensinact.g:1824:2: ( rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1 )*
            {
             before(grammarAccess.getDSL_ECA_STATEMENTAccess().getElseIfdoAssignment_1()); 
            // InternalSensinact.g:1825:2: ( rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSensinact.g:1825:3: rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getDSL_ECA_STATEMENTAccess().getElseIfdoAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__Group__1__Impl"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__Group__2"
    // InternalSensinact.g:1833:1: rule__DSL_ECA_STATEMENT__Group__2 : rule__DSL_ECA_STATEMENT__Group__2__Impl rule__DSL_ECA_STATEMENT__Group__3 ;
    public final void rule__DSL_ECA_STATEMENT__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1837:1: ( rule__DSL_ECA_STATEMENT__Group__2__Impl rule__DSL_ECA_STATEMENT__Group__3 )
            // InternalSensinact.g:1838:2: rule__DSL_ECA_STATEMENT__Group__2__Impl rule__DSL_ECA_STATEMENT__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__DSL_ECA_STATEMENT__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ECA_STATEMENT__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__Group__2"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__Group__2__Impl"
    // InternalSensinact.g:1845:1: rule__DSL_ECA_STATEMENT__Group__2__Impl : ( ( rule__DSL_ECA_STATEMENT__ElsedoAssignment_2 )? ) ;
    public final void rule__DSL_ECA_STATEMENT__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1849:1: ( ( ( rule__DSL_ECA_STATEMENT__ElsedoAssignment_2 )? ) )
            // InternalSensinact.g:1850:1: ( ( rule__DSL_ECA_STATEMENT__ElsedoAssignment_2 )? )
            {
            // InternalSensinact.g:1850:1: ( ( rule__DSL_ECA_STATEMENT__ElsedoAssignment_2 )? )
            // InternalSensinact.g:1851:2: ( rule__DSL_ECA_STATEMENT__ElsedoAssignment_2 )?
            {
             before(grammarAccess.getDSL_ECA_STATEMENTAccess().getElsedoAssignment_2()); 
            // InternalSensinact.g:1852:2: ( rule__DSL_ECA_STATEMENT__ElsedoAssignment_2 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSensinact.g:1852:3: rule__DSL_ECA_STATEMENT__ElsedoAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_ECA_STATEMENT__ElsedoAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDSL_ECA_STATEMENTAccess().getElsedoAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__Group__2__Impl"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__Group__3"
    // InternalSensinact.g:1860:1: rule__DSL_ECA_STATEMENT__Group__3 : rule__DSL_ECA_STATEMENT__Group__3__Impl ;
    public final void rule__DSL_ECA_STATEMENT__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1864:1: ( rule__DSL_ECA_STATEMENT__Group__3__Impl )
            // InternalSensinact.g:1865:2: rule__DSL_ECA_STATEMENT__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ECA_STATEMENT__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__Group__3"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__Group__3__Impl"
    // InternalSensinact.g:1871:1: rule__DSL_ECA_STATEMENT__Group__3__Impl : ( 'end if' ) ;
    public final void rule__DSL_ECA_STATEMENT__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1875:1: ( ( 'end if' ) )
            // InternalSensinact.g:1876:1: ( 'end if' )
            {
            // InternalSensinact.g:1876:1: ( 'end if' )
            // InternalSensinact.g:1877:2: 'end if'
            {
             before(grammarAccess.getDSL_ECA_STATEMENTAccess().getEndIfKeyword_3()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getDSL_ECA_STATEMENTAccess().getEndIfKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__Group__3__Impl"


    // $ANTLR start "rule__DSL_IfDo__Group__0"
    // InternalSensinact.g:1887:1: rule__DSL_IfDo__Group__0 : rule__DSL_IfDo__Group__0__Impl rule__DSL_IfDo__Group__1 ;
    public final void rule__DSL_IfDo__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1891:1: ( rule__DSL_IfDo__Group__0__Impl rule__DSL_IfDo__Group__1 )
            // InternalSensinact.g:1892:2: rule__DSL_IfDo__Group__0__Impl rule__DSL_IfDo__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_IfDo__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_IfDo__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__Group__0"


    // $ANTLR start "rule__DSL_IfDo__Group__0__Impl"
    // InternalSensinact.g:1899:1: rule__DSL_IfDo__Group__0__Impl : ( 'if' ) ;
    public final void rule__DSL_IfDo__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1903:1: ( ( 'if' ) )
            // InternalSensinact.g:1904:1: ( 'if' )
            {
            // InternalSensinact.g:1904:1: ( 'if' )
            // InternalSensinact.g:1905:2: 'if'
            {
             before(grammarAccess.getDSL_IfDoAccess().getIfKeyword_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getDSL_IfDoAccess().getIfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__Group__0__Impl"


    // $ANTLR start "rule__DSL_IfDo__Group__1"
    // InternalSensinact.g:1914:1: rule__DSL_IfDo__Group__1 : rule__DSL_IfDo__Group__1__Impl rule__DSL_IfDo__Group__2 ;
    public final void rule__DSL_IfDo__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1918:1: ( rule__DSL_IfDo__Group__1__Impl rule__DSL_IfDo__Group__2 )
            // InternalSensinact.g:1919:2: rule__DSL_IfDo__Group__1__Impl rule__DSL_IfDo__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__DSL_IfDo__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_IfDo__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__Group__1"


    // $ANTLR start "rule__DSL_IfDo__Group__1__Impl"
    // InternalSensinact.g:1926:1: rule__DSL_IfDo__Group__1__Impl : ( ( rule__DSL_IfDo__ConditionAssignment_1 ) ) ;
    public final void rule__DSL_IfDo__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1930:1: ( ( ( rule__DSL_IfDo__ConditionAssignment_1 ) ) )
            // InternalSensinact.g:1931:1: ( ( rule__DSL_IfDo__ConditionAssignment_1 ) )
            {
            // InternalSensinact.g:1931:1: ( ( rule__DSL_IfDo__ConditionAssignment_1 ) )
            // InternalSensinact.g:1932:2: ( rule__DSL_IfDo__ConditionAssignment_1 )
            {
             before(grammarAccess.getDSL_IfDoAccess().getConditionAssignment_1()); 
            // InternalSensinact.g:1933:2: ( rule__DSL_IfDo__ConditionAssignment_1 )
            // InternalSensinact.g:1933:3: rule__DSL_IfDo__ConditionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_IfDo__ConditionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_IfDoAccess().getConditionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__Group__1__Impl"


    // $ANTLR start "rule__DSL_IfDo__Group__2"
    // InternalSensinact.g:1941:1: rule__DSL_IfDo__Group__2 : rule__DSL_IfDo__Group__2__Impl rule__DSL_IfDo__Group__3 ;
    public final void rule__DSL_IfDo__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1945:1: ( rule__DSL_IfDo__Group__2__Impl rule__DSL_IfDo__Group__3 )
            // InternalSensinact.g:1946:2: rule__DSL_IfDo__Group__2__Impl rule__DSL_IfDo__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__DSL_IfDo__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_IfDo__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__Group__2"


    // $ANTLR start "rule__DSL_IfDo__Group__2__Impl"
    // InternalSensinact.g:1953:1: rule__DSL_IfDo__Group__2__Impl : ( 'do' ) ;
    public final void rule__DSL_IfDo__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1957:1: ( ( 'do' ) )
            // InternalSensinact.g:1958:1: ( 'do' )
            {
            // InternalSensinact.g:1958:1: ( 'do' )
            // InternalSensinact.g:1959:2: 'do'
            {
             before(grammarAccess.getDSL_IfDoAccess().getDoKeyword_2()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getDSL_IfDoAccess().getDoKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__Group__2__Impl"


    // $ANTLR start "rule__DSL_IfDo__Group__3"
    // InternalSensinact.g:1968:1: rule__DSL_IfDo__Group__3 : rule__DSL_IfDo__Group__3__Impl ;
    public final void rule__DSL_IfDo__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1972:1: ( rule__DSL_IfDo__Group__3__Impl )
            // InternalSensinact.g:1973:2: rule__DSL_IfDo__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_IfDo__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__Group__3"


    // $ANTLR start "rule__DSL_IfDo__Group__3__Impl"
    // InternalSensinact.g:1979:1: rule__DSL_IfDo__Group__3__Impl : ( ( rule__DSL_IfDo__ActionsAssignment_3 ) ) ;
    public final void rule__DSL_IfDo__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1983:1: ( ( ( rule__DSL_IfDo__ActionsAssignment_3 ) ) )
            // InternalSensinact.g:1984:1: ( ( rule__DSL_IfDo__ActionsAssignment_3 ) )
            {
            // InternalSensinact.g:1984:1: ( ( rule__DSL_IfDo__ActionsAssignment_3 ) )
            // InternalSensinact.g:1985:2: ( rule__DSL_IfDo__ActionsAssignment_3 )
            {
             before(grammarAccess.getDSL_IfDoAccess().getActionsAssignment_3()); 
            // InternalSensinact.g:1986:2: ( rule__DSL_IfDo__ActionsAssignment_3 )
            // InternalSensinact.g:1986:3: rule__DSL_IfDo__ActionsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DSL_IfDo__ActionsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDSL_IfDoAccess().getActionsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__Group__3__Impl"


    // $ANTLR start "rule__DSL_ElseIfDo__Group__0"
    // InternalSensinact.g:1995:1: rule__DSL_ElseIfDo__Group__0 : rule__DSL_ElseIfDo__Group__0__Impl rule__DSL_ElseIfDo__Group__1 ;
    public final void rule__DSL_ElseIfDo__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:1999:1: ( rule__DSL_ElseIfDo__Group__0__Impl rule__DSL_ElseIfDo__Group__1 )
            // InternalSensinact.g:2000:2: rule__DSL_ElseIfDo__Group__0__Impl rule__DSL_ElseIfDo__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_ElseIfDo__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ElseIfDo__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__Group__0"


    // $ANTLR start "rule__DSL_ElseIfDo__Group__0__Impl"
    // InternalSensinact.g:2007:1: rule__DSL_ElseIfDo__Group__0__Impl : ( 'else if' ) ;
    public final void rule__DSL_ElseIfDo__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2011:1: ( ( 'else if' ) )
            // InternalSensinact.g:2012:1: ( 'else if' )
            {
            // InternalSensinact.g:2012:1: ( 'else if' )
            // InternalSensinact.g:2013:2: 'else if'
            {
             before(grammarAccess.getDSL_ElseIfDoAccess().getElseIfKeyword_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getDSL_ElseIfDoAccess().getElseIfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__Group__0__Impl"


    // $ANTLR start "rule__DSL_ElseIfDo__Group__1"
    // InternalSensinact.g:2022:1: rule__DSL_ElseIfDo__Group__1 : rule__DSL_ElseIfDo__Group__1__Impl rule__DSL_ElseIfDo__Group__2 ;
    public final void rule__DSL_ElseIfDo__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2026:1: ( rule__DSL_ElseIfDo__Group__1__Impl rule__DSL_ElseIfDo__Group__2 )
            // InternalSensinact.g:2027:2: rule__DSL_ElseIfDo__Group__1__Impl rule__DSL_ElseIfDo__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__DSL_ElseIfDo__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ElseIfDo__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__Group__1"


    // $ANTLR start "rule__DSL_ElseIfDo__Group__1__Impl"
    // InternalSensinact.g:2034:1: rule__DSL_ElseIfDo__Group__1__Impl : ( ( rule__DSL_ElseIfDo__ConditionAssignment_1 ) ) ;
    public final void rule__DSL_ElseIfDo__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2038:1: ( ( ( rule__DSL_ElseIfDo__ConditionAssignment_1 ) ) )
            // InternalSensinact.g:2039:1: ( ( rule__DSL_ElseIfDo__ConditionAssignment_1 ) )
            {
            // InternalSensinact.g:2039:1: ( ( rule__DSL_ElseIfDo__ConditionAssignment_1 ) )
            // InternalSensinact.g:2040:2: ( rule__DSL_ElseIfDo__ConditionAssignment_1 )
            {
             before(grammarAccess.getDSL_ElseIfDoAccess().getConditionAssignment_1()); 
            // InternalSensinact.g:2041:2: ( rule__DSL_ElseIfDo__ConditionAssignment_1 )
            // InternalSensinact.g:2041:3: rule__DSL_ElseIfDo__ConditionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ElseIfDo__ConditionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ElseIfDoAccess().getConditionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__Group__1__Impl"


    // $ANTLR start "rule__DSL_ElseIfDo__Group__2"
    // InternalSensinact.g:2049:1: rule__DSL_ElseIfDo__Group__2 : rule__DSL_ElseIfDo__Group__2__Impl rule__DSL_ElseIfDo__Group__3 ;
    public final void rule__DSL_ElseIfDo__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2053:1: ( rule__DSL_ElseIfDo__Group__2__Impl rule__DSL_ElseIfDo__Group__3 )
            // InternalSensinact.g:2054:2: rule__DSL_ElseIfDo__Group__2__Impl rule__DSL_ElseIfDo__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__DSL_ElseIfDo__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ElseIfDo__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__Group__2"


    // $ANTLR start "rule__DSL_ElseIfDo__Group__2__Impl"
    // InternalSensinact.g:2061:1: rule__DSL_ElseIfDo__Group__2__Impl : ( 'do' ) ;
    public final void rule__DSL_ElseIfDo__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2065:1: ( ( 'do' ) )
            // InternalSensinact.g:2066:1: ( 'do' )
            {
            // InternalSensinact.g:2066:1: ( 'do' )
            // InternalSensinact.g:2067:2: 'do'
            {
             before(grammarAccess.getDSL_ElseIfDoAccess().getDoKeyword_2()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getDSL_ElseIfDoAccess().getDoKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__Group__2__Impl"


    // $ANTLR start "rule__DSL_ElseIfDo__Group__3"
    // InternalSensinact.g:2076:1: rule__DSL_ElseIfDo__Group__3 : rule__DSL_ElseIfDo__Group__3__Impl ;
    public final void rule__DSL_ElseIfDo__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2080:1: ( rule__DSL_ElseIfDo__Group__3__Impl )
            // InternalSensinact.g:2081:2: rule__DSL_ElseIfDo__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ElseIfDo__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__Group__3"


    // $ANTLR start "rule__DSL_ElseIfDo__Group__3__Impl"
    // InternalSensinact.g:2087:1: rule__DSL_ElseIfDo__Group__3__Impl : ( ( rule__DSL_ElseIfDo__ActionsAssignment_3 ) ) ;
    public final void rule__DSL_ElseIfDo__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2091:1: ( ( ( rule__DSL_ElseIfDo__ActionsAssignment_3 ) ) )
            // InternalSensinact.g:2092:1: ( ( rule__DSL_ElseIfDo__ActionsAssignment_3 ) )
            {
            // InternalSensinact.g:2092:1: ( ( rule__DSL_ElseIfDo__ActionsAssignment_3 ) )
            // InternalSensinact.g:2093:2: ( rule__DSL_ElseIfDo__ActionsAssignment_3 )
            {
             before(grammarAccess.getDSL_ElseIfDoAccess().getActionsAssignment_3()); 
            // InternalSensinact.g:2094:2: ( rule__DSL_ElseIfDo__ActionsAssignment_3 )
            // InternalSensinact.g:2094:3: rule__DSL_ElseIfDo__ActionsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ElseIfDo__ActionsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ElseIfDoAccess().getActionsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__Group__3__Impl"


    // $ANTLR start "rule__DSL_ElseDo__Group__0"
    // InternalSensinact.g:2103:1: rule__DSL_ElseDo__Group__0 : rule__DSL_ElseDo__Group__0__Impl rule__DSL_ElseDo__Group__1 ;
    public final void rule__DSL_ElseDo__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2107:1: ( rule__DSL_ElseDo__Group__0__Impl rule__DSL_ElseDo__Group__1 )
            // InternalSensinact.g:2108:2: rule__DSL_ElseDo__Group__0__Impl rule__DSL_ElseDo__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__DSL_ElseDo__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ElseDo__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseDo__Group__0"


    // $ANTLR start "rule__DSL_ElseDo__Group__0__Impl"
    // InternalSensinact.g:2115:1: rule__DSL_ElseDo__Group__0__Impl : ( 'else do' ) ;
    public final void rule__DSL_ElseDo__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2119:1: ( ( 'else do' ) )
            // InternalSensinact.g:2120:1: ( 'else do' )
            {
            // InternalSensinact.g:2120:1: ( 'else do' )
            // InternalSensinact.g:2121:2: 'else do'
            {
             before(grammarAccess.getDSL_ElseDoAccess().getElseDoKeyword_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getDSL_ElseDoAccess().getElseDoKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseDo__Group__0__Impl"


    // $ANTLR start "rule__DSL_ElseDo__Group__1"
    // InternalSensinact.g:2130:1: rule__DSL_ElseDo__Group__1 : rule__DSL_ElseDo__Group__1__Impl ;
    public final void rule__DSL_ElseDo__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2134:1: ( rule__DSL_ElseDo__Group__1__Impl )
            // InternalSensinact.g:2135:2: rule__DSL_ElseDo__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ElseDo__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseDo__Group__1"


    // $ANTLR start "rule__DSL_ElseDo__Group__1__Impl"
    // InternalSensinact.g:2141:1: rule__DSL_ElseDo__Group__1__Impl : ( ( rule__DSL_ElseDo__ActionsAssignment_1 ) ) ;
    public final void rule__DSL_ElseDo__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2145:1: ( ( ( rule__DSL_ElseDo__ActionsAssignment_1 ) ) )
            // InternalSensinact.g:2146:1: ( ( rule__DSL_ElseDo__ActionsAssignment_1 ) )
            {
            // InternalSensinact.g:2146:1: ( ( rule__DSL_ElseDo__ActionsAssignment_1 ) )
            // InternalSensinact.g:2147:2: ( rule__DSL_ElseDo__ActionsAssignment_1 )
            {
             before(grammarAccess.getDSL_ElseDoAccess().getActionsAssignment_1()); 
            // InternalSensinact.g:2148:2: ( rule__DSL_ElseDo__ActionsAssignment_1 )
            // InternalSensinact.g:2148:3: rule__DSL_ElseDo__ActionsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ElseDo__ActionsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ElseDoAccess().getActionsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseDo__Group__1__Impl"


    // $ANTLR start "rule__NUMBER__Group_1__0"
    // InternalSensinact.g:2157:1: rule__NUMBER__Group_1__0 : rule__NUMBER__Group_1__0__Impl rule__NUMBER__Group_1__1 ;
    public final void rule__NUMBER__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2161:1: ( rule__NUMBER__Group_1__0__Impl rule__NUMBER__Group_1__1 )
            // InternalSensinact.g:2162:2: rule__NUMBER__Group_1__0__Impl rule__NUMBER__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__NUMBER__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NUMBER__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NUMBER__Group_1__0"


    // $ANTLR start "rule__NUMBER__Group_1__0__Impl"
    // InternalSensinact.g:2169:1: rule__NUMBER__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__NUMBER__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2173:1: ( ( RULE_INT ) )
            // InternalSensinact.g:2174:1: ( RULE_INT )
            {
            // InternalSensinact.g:2174:1: ( RULE_INT )
            // InternalSensinact.g:2175:2: RULE_INT
            {
             before(grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NUMBER__Group_1__0__Impl"


    // $ANTLR start "rule__NUMBER__Group_1__1"
    // InternalSensinact.g:2184:1: rule__NUMBER__Group_1__1 : rule__NUMBER__Group_1__1__Impl rule__NUMBER__Group_1__2 ;
    public final void rule__NUMBER__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2188:1: ( rule__NUMBER__Group_1__1__Impl rule__NUMBER__Group_1__2 )
            // InternalSensinact.g:2189:2: rule__NUMBER__Group_1__1__Impl rule__NUMBER__Group_1__2
            {
            pushFollow(FOLLOW_21);
            rule__NUMBER__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NUMBER__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NUMBER__Group_1__1"


    // $ANTLR start "rule__NUMBER__Group_1__1__Impl"
    // InternalSensinact.g:2196:1: rule__NUMBER__Group_1__1__Impl : ( '.' ) ;
    public final void rule__NUMBER__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2200:1: ( ( '.' ) )
            // InternalSensinact.g:2201:1: ( '.' )
            {
            // InternalSensinact.g:2201:1: ( '.' )
            // InternalSensinact.g:2202:2: '.'
            {
             before(grammarAccess.getNUMBERAccess().getFullStopKeyword_1_1()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getNUMBERAccess().getFullStopKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NUMBER__Group_1__1__Impl"


    // $ANTLR start "rule__NUMBER__Group_1__2"
    // InternalSensinact.g:2211:1: rule__NUMBER__Group_1__2 : rule__NUMBER__Group_1__2__Impl ;
    public final void rule__NUMBER__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2215:1: ( rule__NUMBER__Group_1__2__Impl )
            // InternalSensinact.g:2216:2: rule__NUMBER__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NUMBER__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NUMBER__Group_1__2"


    // $ANTLR start "rule__NUMBER__Group_1__2__Impl"
    // InternalSensinact.g:2222:1: rule__NUMBER__Group_1__2__Impl : ( RULE_INT ) ;
    public final void rule__NUMBER__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2226:1: ( ( RULE_INT ) )
            // InternalSensinact.g:2227:1: ( RULE_INT )
            {
            // InternalSensinact.g:2227:1: ( RULE_INT )
            // InternalSensinact.g:2228:2: RULE_INT
            {
             before(grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_1_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NUMBER__Group_1__2__Impl"


    // $ANTLR start "rule__EXTENDED_ID__Group__0"
    // InternalSensinact.g:2238:1: rule__EXTENDED_ID__Group__0 : rule__EXTENDED_ID__Group__0__Impl rule__EXTENDED_ID__Group__1 ;
    public final void rule__EXTENDED_ID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2242:1: ( rule__EXTENDED_ID__Group__0__Impl rule__EXTENDED_ID__Group__1 )
            // InternalSensinact.g:2243:2: rule__EXTENDED_ID__Group__0__Impl rule__EXTENDED_ID__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__EXTENDED_ID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EXTENDED_ID__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EXTENDED_ID__Group__0"


    // $ANTLR start "rule__EXTENDED_ID__Group__0__Impl"
    // InternalSensinact.g:2250:1: rule__EXTENDED_ID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__EXTENDED_ID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2254:1: ( ( RULE_ID ) )
            // InternalSensinact.g:2255:1: ( RULE_ID )
            {
            // InternalSensinact.g:2255:1: ( RULE_ID )
            // InternalSensinact.g:2256:2: RULE_ID
            {
             before(grammarAccess.getEXTENDED_IDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEXTENDED_IDAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EXTENDED_ID__Group__0__Impl"


    // $ANTLR start "rule__EXTENDED_ID__Group__1"
    // InternalSensinact.g:2265:1: rule__EXTENDED_ID__Group__1 : rule__EXTENDED_ID__Group__1__Impl ;
    public final void rule__EXTENDED_ID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2269:1: ( rule__EXTENDED_ID__Group__1__Impl )
            // InternalSensinact.g:2270:2: rule__EXTENDED_ID__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EXTENDED_ID__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EXTENDED_ID__Group__1"


    // $ANTLR start "rule__EXTENDED_ID__Group__1__Impl"
    // InternalSensinact.g:2276:1: rule__EXTENDED_ID__Group__1__Impl : ( ( rule__EXTENDED_ID__Group_1__0 )* ) ;
    public final void rule__EXTENDED_ID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2280:1: ( ( ( rule__EXTENDED_ID__Group_1__0 )* ) )
            // InternalSensinact.g:2281:1: ( ( rule__EXTENDED_ID__Group_1__0 )* )
            {
            // InternalSensinact.g:2281:1: ( ( rule__EXTENDED_ID__Group_1__0 )* )
            // InternalSensinact.g:2282:2: ( rule__EXTENDED_ID__Group_1__0 )*
            {
             before(grammarAccess.getEXTENDED_IDAccess().getGroup_1()); 
            // InternalSensinact.g:2283:2: ( rule__EXTENDED_ID__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalSensinact.g:2283:3: rule__EXTENDED_ID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__EXTENDED_ID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getEXTENDED_IDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EXTENDED_ID__Group__1__Impl"


    // $ANTLR start "rule__EXTENDED_ID__Group_1__0"
    // InternalSensinact.g:2292:1: rule__EXTENDED_ID__Group_1__0 : rule__EXTENDED_ID__Group_1__0__Impl rule__EXTENDED_ID__Group_1__1 ;
    public final void rule__EXTENDED_ID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2296:1: ( rule__EXTENDED_ID__Group_1__0__Impl rule__EXTENDED_ID__Group_1__1 )
            // InternalSensinact.g:2297:2: rule__EXTENDED_ID__Group_1__0__Impl rule__EXTENDED_ID__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__EXTENDED_ID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EXTENDED_ID__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EXTENDED_ID__Group_1__0"


    // $ANTLR start "rule__EXTENDED_ID__Group_1__0__Impl"
    // InternalSensinact.g:2304:1: rule__EXTENDED_ID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__EXTENDED_ID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2308:1: ( ( '.' ) )
            // InternalSensinact.g:2309:1: ( '.' )
            {
            // InternalSensinact.g:2309:1: ( '.' )
            // InternalSensinact.g:2310:2: '.'
            {
             before(grammarAccess.getEXTENDED_IDAccess().getFullStopKeyword_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getEXTENDED_IDAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EXTENDED_ID__Group_1__0__Impl"


    // $ANTLR start "rule__EXTENDED_ID__Group_1__1"
    // InternalSensinact.g:2319:1: rule__EXTENDED_ID__Group_1__1 : rule__EXTENDED_ID__Group_1__1__Impl ;
    public final void rule__EXTENDED_ID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2323:1: ( rule__EXTENDED_ID__Group_1__1__Impl )
            // InternalSensinact.g:2324:2: rule__EXTENDED_ID__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EXTENDED_ID__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EXTENDED_ID__Group_1__1"


    // $ANTLR start "rule__EXTENDED_ID__Group_1__1__Impl"
    // InternalSensinact.g:2330:1: rule__EXTENDED_ID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__EXTENDED_ID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2334:1: ( ( RULE_ID ) )
            // InternalSensinact.g:2335:1: ( RULE_ID )
            {
            // InternalSensinact.g:2335:1: ( RULE_ID )
            // InternalSensinact.g:2336:2: RULE_ID
            {
             before(grammarAccess.getEXTENDED_IDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEXTENDED_IDAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EXTENDED_ID__Group_1__1__Impl"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__0"
    // InternalSensinact.g:2346:1: rule__DSL_REF_CONDITION__Group__0 : rule__DSL_REF_CONDITION__Group__0__Impl rule__DSL_REF_CONDITION__Group__1 ;
    public final void rule__DSL_REF_CONDITION__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2350:1: ( rule__DSL_REF_CONDITION__Group__0__Impl rule__DSL_REF_CONDITION__Group__1 )
            // InternalSensinact.g:2351:2: rule__DSL_REF_CONDITION__Group__0__Impl rule__DSL_REF_CONDITION__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__DSL_REF_CONDITION__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_REF_CONDITION__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__0"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__0__Impl"
    // InternalSensinact.g:2358:1: rule__DSL_REF_CONDITION__Group__0__Impl : ( ( rule__DSL_REF_CONDITION__RefAssignment_0 ) ) ;
    public final void rule__DSL_REF_CONDITION__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2362:1: ( ( ( rule__DSL_REF_CONDITION__RefAssignment_0 ) ) )
            // InternalSensinact.g:2363:1: ( ( rule__DSL_REF_CONDITION__RefAssignment_0 ) )
            {
            // InternalSensinact.g:2363:1: ( ( rule__DSL_REF_CONDITION__RefAssignment_0 ) )
            // InternalSensinact.g:2364:2: ( rule__DSL_REF_CONDITION__RefAssignment_0 )
            {
             before(grammarAccess.getDSL_REF_CONDITIONAccess().getRefAssignment_0()); 
            // InternalSensinact.g:2365:2: ( rule__DSL_REF_CONDITION__RefAssignment_0 )
            // InternalSensinact.g:2365:3: rule__DSL_REF_CONDITION__RefAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_REF_CONDITION__RefAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_REF_CONDITIONAccess().getRefAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__0__Impl"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__1"
    // InternalSensinact.g:2373:1: rule__DSL_REF_CONDITION__Group__1 : rule__DSL_REF_CONDITION__Group__1__Impl rule__DSL_REF_CONDITION__Group__2 ;
    public final void rule__DSL_REF_CONDITION__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2377:1: ( rule__DSL_REF_CONDITION__Group__1__Impl rule__DSL_REF_CONDITION__Group__2 )
            // InternalSensinact.g:2378:2: rule__DSL_REF_CONDITION__Group__1__Impl rule__DSL_REF_CONDITION__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__DSL_REF_CONDITION__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_REF_CONDITION__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__1"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__1__Impl"
    // InternalSensinact.g:2385:1: rule__DSL_REF_CONDITION__Group__1__Impl : ( '.' ) ;
    public final void rule__DSL_REF_CONDITION__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2389:1: ( ( '.' ) )
            // InternalSensinact.g:2390:1: ( '.' )
            {
            // InternalSensinact.g:2390:1: ( '.' )
            // InternalSensinact.g:2391:2: '.'
            {
             before(grammarAccess.getDSL_REF_CONDITIONAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getDSL_REF_CONDITIONAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__1__Impl"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__2"
    // InternalSensinact.g:2400:1: rule__DSL_REF_CONDITION__Group__2 : rule__DSL_REF_CONDITION__Group__2__Impl rule__DSL_REF_CONDITION__Group__3 ;
    public final void rule__DSL_REF_CONDITION__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2404:1: ( rule__DSL_REF_CONDITION__Group__2__Impl rule__DSL_REF_CONDITION__Group__3 )
            // InternalSensinact.g:2405:2: rule__DSL_REF_CONDITION__Group__2__Impl rule__DSL_REF_CONDITION__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__DSL_REF_CONDITION__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_REF_CONDITION__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__2"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__2__Impl"
    // InternalSensinact.g:2412:1: rule__DSL_REF_CONDITION__Group__2__Impl : ( 'subscribe' ) ;
    public final void rule__DSL_REF_CONDITION__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2416:1: ( ( 'subscribe' ) )
            // InternalSensinact.g:2417:1: ( 'subscribe' )
            {
            // InternalSensinact.g:2417:1: ( 'subscribe' )
            // InternalSensinact.g:2418:2: 'subscribe'
            {
             before(grammarAccess.getDSL_REF_CONDITIONAccess().getSubscribeKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getDSL_REF_CONDITIONAccess().getSubscribeKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__2__Impl"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__3"
    // InternalSensinact.g:2427:1: rule__DSL_REF_CONDITION__Group__3 : rule__DSL_REF_CONDITION__Group__3__Impl rule__DSL_REF_CONDITION__Group__4 ;
    public final void rule__DSL_REF_CONDITION__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2431:1: ( rule__DSL_REF_CONDITION__Group__3__Impl rule__DSL_REF_CONDITION__Group__4 )
            // InternalSensinact.g:2432:2: rule__DSL_REF_CONDITION__Group__3__Impl rule__DSL_REF_CONDITION__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__DSL_REF_CONDITION__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_REF_CONDITION__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__3"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__3__Impl"
    // InternalSensinact.g:2439:1: rule__DSL_REF_CONDITION__Group__3__Impl : ( '(' ) ;
    public final void rule__DSL_REF_CONDITION__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2443:1: ( ( '(' ) )
            // InternalSensinact.g:2444:1: ( '(' )
            {
            // InternalSensinact.g:2444:1: ( '(' )
            // InternalSensinact.g:2445:2: '('
            {
             before(grammarAccess.getDSL_REF_CONDITIONAccess().getLeftParenthesisKeyword_3()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_REF_CONDITIONAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__3__Impl"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__4"
    // InternalSensinact.g:2454:1: rule__DSL_REF_CONDITION__Group__4 : rule__DSL_REF_CONDITION__Group__4__Impl ;
    public final void rule__DSL_REF_CONDITION__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2458:1: ( rule__DSL_REF_CONDITION__Group__4__Impl )
            // InternalSensinact.g:2459:2: rule__DSL_REF_CONDITION__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_REF_CONDITION__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__4"


    // $ANTLR start "rule__DSL_REF_CONDITION__Group__4__Impl"
    // InternalSensinact.g:2465:1: rule__DSL_REF_CONDITION__Group__4__Impl : ( ')' ) ;
    public final void rule__DSL_REF_CONDITION__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2469:1: ( ( ')' ) )
            // InternalSensinact.g:2470:1: ( ')' )
            {
            // InternalSensinact.g:2470:1: ( ')' )
            // InternalSensinact.g:2471:2: ')'
            {
             before(grammarAccess.getDSL_REF_CONDITIONAccess().getRightParenthesisKeyword_4()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_REF_CONDITIONAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__Group__4__Impl"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__Group__0"
    // InternalSensinact.g:2481:1: rule__DSL_CEP_STATEMENT__Group__0 : rule__DSL_CEP_STATEMENT__Group__0__Impl rule__DSL_CEP_STATEMENT__Group__1 ;
    public final void rule__DSL_CEP_STATEMENT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2485:1: ( rule__DSL_CEP_STATEMENT__Group__0__Impl rule__DSL_CEP_STATEMENT__Group__1 )
            // InternalSensinact.g:2486:2: rule__DSL_CEP_STATEMENT__Group__0__Impl rule__DSL_CEP_STATEMENT__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_STATEMENT__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_STATEMENT__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__Group__0"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__Group__0__Impl"
    // InternalSensinact.g:2493:1: rule__DSL_CEP_STATEMENT__Group__0__Impl : ( 'define' ) ;
    public final void rule__DSL_CEP_STATEMENT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2497:1: ( ( 'define' ) )
            // InternalSensinact.g:2498:1: ( 'define' )
            {
            // InternalSensinact.g:2498:1: ( 'define' )
            // InternalSensinact.g:2499:2: 'define'
            {
             before(grammarAccess.getDSL_CEP_STATEMENTAccess().getDefineKeyword_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_STATEMENTAccess().getDefineKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__Group__1"
    // InternalSensinact.g:2508:1: rule__DSL_CEP_STATEMENT__Group__1 : rule__DSL_CEP_STATEMENT__Group__1__Impl rule__DSL_CEP_STATEMENT__Group__2 ;
    public final void rule__DSL_CEP_STATEMENT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2512:1: ( rule__DSL_CEP_STATEMENT__Group__1__Impl rule__DSL_CEP_STATEMENT__Group__2 )
            // InternalSensinact.g:2513:2: rule__DSL_CEP_STATEMENT__Group__1__Impl rule__DSL_CEP_STATEMENT__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__DSL_CEP_STATEMENT__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_STATEMENT__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__Group__1"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__Group__1__Impl"
    // InternalSensinact.g:2520:1: rule__DSL_CEP_STATEMENT__Group__1__Impl : ( ( rule__DSL_CEP_STATEMENT__NameAssignment_1 ) ) ;
    public final void rule__DSL_CEP_STATEMENT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2524:1: ( ( ( rule__DSL_CEP_STATEMENT__NameAssignment_1 ) ) )
            // InternalSensinact.g:2525:1: ( ( rule__DSL_CEP_STATEMENT__NameAssignment_1 ) )
            {
            // InternalSensinact.g:2525:1: ( ( rule__DSL_CEP_STATEMENT__NameAssignment_1 ) )
            // InternalSensinact.g:2526:2: ( rule__DSL_CEP_STATEMENT__NameAssignment_1 )
            {
             before(grammarAccess.getDSL_CEP_STATEMENTAccess().getNameAssignment_1()); 
            // InternalSensinact.g:2527:2: ( rule__DSL_CEP_STATEMENT__NameAssignment_1 )
            // InternalSensinact.g:2527:3: rule__DSL_CEP_STATEMENT__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_STATEMENT__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_STATEMENTAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__Group__2"
    // InternalSensinact.g:2535:1: rule__DSL_CEP_STATEMENT__Group__2 : rule__DSL_CEP_STATEMENT__Group__2__Impl rule__DSL_CEP_STATEMENT__Group__3 ;
    public final void rule__DSL_CEP_STATEMENT__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2539:1: ( rule__DSL_CEP_STATEMENT__Group__2__Impl rule__DSL_CEP_STATEMENT__Group__3 )
            // InternalSensinact.g:2540:2: rule__DSL_CEP_STATEMENT__Group__2__Impl rule__DSL_CEP_STATEMENT__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__DSL_CEP_STATEMENT__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_STATEMENT__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__Group__2"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__Group__2__Impl"
    // InternalSensinact.g:2547:1: rule__DSL_CEP_STATEMENT__Group__2__Impl : ( '=' ) ;
    public final void rule__DSL_CEP_STATEMENT__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2551:1: ( ( '=' ) )
            // InternalSensinact.g:2552:1: ( '=' )
            {
            // InternalSensinact.g:2552:1: ( '=' )
            // InternalSensinact.g:2553:2: '='
            {
             before(grammarAccess.getDSL_CEP_STATEMENTAccess().getEqualsSignKeyword_2()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_STATEMENTAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__Group__2__Impl"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__Group__3"
    // InternalSensinact.g:2562:1: rule__DSL_CEP_STATEMENT__Group__3 : rule__DSL_CEP_STATEMENT__Group__3__Impl ;
    public final void rule__DSL_CEP_STATEMENT__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2566:1: ( rule__DSL_CEP_STATEMENT__Group__3__Impl )
            // InternalSensinact.g:2567:2: rule__DSL_CEP_STATEMENT__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_STATEMENT__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__Group__3"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__Group__3__Impl"
    // InternalSensinact.g:2573:1: rule__DSL_CEP_STATEMENT__Group__3__Impl : ( ( rule__DSL_CEP_STATEMENT__OperationAssignment_3 ) ) ;
    public final void rule__DSL_CEP_STATEMENT__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2577:1: ( ( ( rule__DSL_CEP_STATEMENT__OperationAssignment_3 ) ) )
            // InternalSensinact.g:2578:1: ( ( rule__DSL_CEP_STATEMENT__OperationAssignment_3 ) )
            {
            // InternalSensinact.g:2578:1: ( ( rule__DSL_CEP_STATEMENT__OperationAssignment_3 ) )
            // InternalSensinact.g:2579:2: ( rule__DSL_CEP_STATEMENT__OperationAssignment_3 )
            {
             before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationAssignment_3()); 
            // InternalSensinact.g:2580:2: ( rule__DSL_CEP_STATEMENT__OperationAssignment_3 )
            // InternalSensinact.g:2580:3: rule__DSL_CEP_STATEMENT__OperationAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_STATEMENT__OperationAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__Group__3__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__0"
    // InternalSensinact.g:2589:1: rule__DSL_CEP_AFTER__Group__0 : rule__DSL_CEP_AFTER__Group__0__Impl rule__DSL_CEP_AFTER__Group__1 ;
    public final void rule__DSL_CEP_AFTER__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2593:1: ( rule__DSL_CEP_AFTER__Group__0__Impl rule__DSL_CEP_AFTER__Group__1 )
            // InternalSensinact.g:2594:2: rule__DSL_CEP_AFTER__Group__0__Impl rule__DSL_CEP_AFTER__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__DSL_CEP_AFTER__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__0"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__0__Impl"
    // InternalSensinact.g:2601:1: rule__DSL_CEP_AFTER__Group__0__Impl : ( 'after' ) ;
    public final void rule__DSL_CEP_AFTER__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2605:1: ( ( 'after' ) )
            // InternalSensinact.g:2606:1: ( 'after' )
            {
            // InternalSensinact.g:2606:1: ( 'after' )
            // InternalSensinact.g:2607:2: 'after'
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getAfterKeyword_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AFTERAccess().getAfterKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__1"
    // InternalSensinact.g:2616:1: rule__DSL_CEP_AFTER__Group__1 : rule__DSL_CEP_AFTER__Group__1__Impl rule__DSL_CEP_AFTER__Group__2 ;
    public final void rule__DSL_CEP_AFTER__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2620:1: ( rule__DSL_CEP_AFTER__Group__1__Impl rule__DSL_CEP_AFTER__Group__2 )
            // InternalSensinact.g:2621:2: rule__DSL_CEP_AFTER__Group__1__Impl rule__DSL_CEP_AFTER__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_AFTER__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__1"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__1__Impl"
    // InternalSensinact.g:2628:1: rule__DSL_CEP_AFTER__Group__1__Impl : ( '(' ) ;
    public final void rule__DSL_CEP_AFTER__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2632:1: ( ( '(' ) )
            // InternalSensinact.g:2633:1: ( '(' )
            {
            // InternalSensinact.g:2633:1: ( '(' )
            // InternalSensinact.g:2634:2: '('
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getLeftParenthesisKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AFTERAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__2"
    // InternalSensinact.g:2643:1: rule__DSL_CEP_AFTER__Group__2 : rule__DSL_CEP_AFTER__Group__2__Impl rule__DSL_CEP_AFTER__Group__3 ;
    public final void rule__DSL_CEP_AFTER__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2647:1: ( rule__DSL_CEP_AFTER__Group__2__Impl rule__DSL_CEP_AFTER__Group__3 )
            // InternalSensinact.g:2648:2: rule__DSL_CEP_AFTER__Group__2__Impl rule__DSL_CEP_AFTER__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_AFTER__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__2"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__2__Impl"
    // InternalSensinact.g:2655:1: rule__DSL_CEP_AFTER__Group__2__Impl : ( ( rule__DSL_CEP_AFTER__Ref1Assignment_2 ) ) ;
    public final void rule__DSL_CEP_AFTER__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2659:1: ( ( ( rule__DSL_CEP_AFTER__Ref1Assignment_2 ) ) )
            // InternalSensinact.g:2660:1: ( ( rule__DSL_CEP_AFTER__Ref1Assignment_2 ) )
            {
            // InternalSensinact.g:2660:1: ( ( rule__DSL_CEP_AFTER__Ref1Assignment_2 ) )
            // InternalSensinact.g:2661:2: ( rule__DSL_CEP_AFTER__Ref1Assignment_2 )
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getRef1Assignment_2()); 
            // InternalSensinact.g:2662:2: ( rule__DSL_CEP_AFTER__Ref1Assignment_2 )
            // InternalSensinact.g:2662:3: rule__DSL_CEP_AFTER__Ref1Assignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Ref1Assignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_AFTERAccess().getRef1Assignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__2__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__3"
    // InternalSensinact.g:2670:1: rule__DSL_CEP_AFTER__Group__3 : rule__DSL_CEP_AFTER__Group__3__Impl rule__DSL_CEP_AFTER__Group__4 ;
    public final void rule__DSL_CEP_AFTER__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2674:1: ( rule__DSL_CEP_AFTER__Group__3__Impl rule__DSL_CEP_AFTER__Group__4 )
            // InternalSensinact.g:2675:2: rule__DSL_CEP_AFTER__Group__3__Impl rule__DSL_CEP_AFTER__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_AFTER__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__3"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__3__Impl"
    // InternalSensinact.g:2682:1: rule__DSL_CEP_AFTER__Group__3__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_AFTER__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2686:1: ( ( ',' ) )
            // InternalSensinact.g:2687:1: ( ',' )
            {
            // InternalSensinact.g:2687:1: ( ',' )
            // InternalSensinact.g:2688:2: ','
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getCommaKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AFTERAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__3__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__4"
    // InternalSensinact.g:2697:1: rule__DSL_CEP_AFTER__Group__4 : rule__DSL_CEP_AFTER__Group__4__Impl rule__DSL_CEP_AFTER__Group__5 ;
    public final void rule__DSL_CEP_AFTER__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2701:1: ( rule__DSL_CEP_AFTER__Group__4__Impl rule__DSL_CEP_AFTER__Group__5 )
            // InternalSensinact.g:2702:2: rule__DSL_CEP_AFTER__Group__4__Impl rule__DSL_CEP_AFTER__Group__5
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_AFTER__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__4"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__4__Impl"
    // InternalSensinact.g:2709:1: rule__DSL_CEP_AFTER__Group__4__Impl : ( ( rule__DSL_CEP_AFTER__Ref2Assignment_4 ) ) ;
    public final void rule__DSL_CEP_AFTER__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2713:1: ( ( ( rule__DSL_CEP_AFTER__Ref2Assignment_4 ) ) )
            // InternalSensinact.g:2714:1: ( ( rule__DSL_CEP_AFTER__Ref2Assignment_4 ) )
            {
            // InternalSensinact.g:2714:1: ( ( rule__DSL_CEP_AFTER__Ref2Assignment_4 ) )
            // InternalSensinact.g:2715:2: ( rule__DSL_CEP_AFTER__Ref2Assignment_4 )
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getRef2Assignment_4()); 
            // InternalSensinact.g:2716:2: ( rule__DSL_CEP_AFTER__Ref2Assignment_4 )
            // InternalSensinact.g:2716:3: rule__DSL_CEP_AFTER__Ref2Assignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Ref2Assignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_AFTERAccess().getRef2Assignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__4__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__5"
    // InternalSensinact.g:2724:1: rule__DSL_CEP_AFTER__Group__5 : rule__DSL_CEP_AFTER__Group__5__Impl rule__DSL_CEP_AFTER__Group__6 ;
    public final void rule__DSL_CEP_AFTER__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2728:1: ( rule__DSL_CEP_AFTER__Group__5__Impl rule__DSL_CEP_AFTER__Group__6 )
            // InternalSensinact.g:2729:2: rule__DSL_CEP_AFTER__Group__5__Impl rule__DSL_CEP_AFTER__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_AFTER__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__5"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__5__Impl"
    // InternalSensinact.g:2736:1: rule__DSL_CEP_AFTER__Group__5__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_AFTER__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2740:1: ( ( ',' ) )
            // InternalSensinact.g:2741:1: ( ',' )
            {
            // InternalSensinact.g:2741:1: ( ',' )
            // InternalSensinact.g:2742:2: ','
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getCommaKeyword_5()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AFTERAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__5__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__6"
    // InternalSensinact.g:2751:1: rule__DSL_CEP_AFTER__Group__6 : rule__DSL_CEP_AFTER__Group__6__Impl rule__DSL_CEP_AFTER__Group__7 ;
    public final void rule__DSL_CEP_AFTER__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2755:1: ( rule__DSL_CEP_AFTER__Group__6__Impl rule__DSL_CEP_AFTER__Group__7 )
            // InternalSensinact.g:2756:2: rule__DSL_CEP_AFTER__Group__6__Impl rule__DSL_CEP_AFTER__Group__7
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_AFTER__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__6"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__6__Impl"
    // InternalSensinact.g:2763:1: rule__DSL_CEP_AFTER__Group__6__Impl : ( ( rule__DSL_CEP_AFTER__Group_6__0 )? ) ;
    public final void rule__DSL_CEP_AFTER__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2767:1: ( ( ( rule__DSL_CEP_AFTER__Group_6__0 )? ) )
            // InternalSensinact.g:2768:1: ( ( rule__DSL_CEP_AFTER__Group_6__0 )? )
            {
            // InternalSensinact.g:2768:1: ( ( rule__DSL_CEP_AFTER__Group_6__0 )? )
            // InternalSensinact.g:2769:2: ( rule__DSL_CEP_AFTER__Group_6__0 )?
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getGroup_6()); 
            // InternalSensinact.g:2770:2: ( rule__DSL_CEP_AFTER__Group_6__0 )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalSensinact.g:2770:3: rule__DSL_CEP_AFTER__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_CEP_AFTER__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDSL_CEP_AFTERAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__6__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__7"
    // InternalSensinact.g:2778:1: rule__DSL_CEP_AFTER__Group__7 : rule__DSL_CEP_AFTER__Group__7__Impl rule__DSL_CEP_AFTER__Group__8 ;
    public final void rule__DSL_CEP_AFTER__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2782:1: ( rule__DSL_CEP_AFTER__Group__7__Impl rule__DSL_CEP_AFTER__Group__8 )
            // InternalSensinact.g:2783:2: rule__DSL_CEP_AFTER__Group__7__Impl rule__DSL_CEP_AFTER__Group__8
            {
            pushFollow(FOLLOW_25);
            rule__DSL_CEP_AFTER__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__7"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__7__Impl"
    // InternalSensinact.g:2790:1: rule__DSL_CEP_AFTER__Group__7__Impl : ( ( rule__DSL_CEP_AFTER__EndAssignment_7 ) ) ;
    public final void rule__DSL_CEP_AFTER__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2794:1: ( ( ( rule__DSL_CEP_AFTER__EndAssignment_7 ) ) )
            // InternalSensinact.g:2795:1: ( ( rule__DSL_CEP_AFTER__EndAssignment_7 ) )
            {
            // InternalSensinact.g:2795:1: ( ( rule__DSL_CEP_AFTER__EndAssignment_7 ) )
            // InternalSensinact.g:2796:2: ( rule__DSL_CEP_AFTER__EndAssignment_7 )
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getEndAssignment_7()); 
            // InternalSensinact.g:2797:2: ( rule__DSL_CEP_AFTER__EndAssignment_7 )
            // InternalSensinact.g:2797:3: rule__DSL_CEP_AFTER__EndAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__EndAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_AFTERAccess().getEndAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__7__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__8"
    // InternalSensinact.g:2805:1: rule__DSL_CEP_AFTER__Group__8 : rule__DSL_CEP_AFTER__Group__8__Impl ;
    public final void rule__DSL_CEP_AFTER__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2809:1: ( rule__DSL_CEP_AFTER__Group__8__Impl )
            // InternalSensinact.g:2810:2: rule__DSL_CEP_AFTER__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__8"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group__8__Impl"
    // InternalSensinact.g:2816:1: rule__DSL_CEP_AFTER__Group__8__Impl : ( ')' ) ;
    public final void rule__DSL_CEP_AFTER__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2820:1: ( ( ')' ) )
            // InternalSensinact.g:2821:1: ( ')' )
            {
            // InternalSensinact.g:2821:1: ( ')' )
            // InternalSensinact.g:2822:2: ')'
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getRightParenthesisKeyword_8()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AFTERAccess().getRightParenthesisKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group__8__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group_6__0"
    // InternalSensinact.g:2832:1: rule__DSL_CEP_AFTER__Group_6__0 : rule__DSL_CEP_AFTER__Group_6__0__Impl rule__DSL_CEP_AFTER__Group_6__1 ;
    public final void rule__DSL_CEP_AFTER__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2836:1: ( rule__DSL_CEP_AFTER__Group_6__0__Impl rule__DSL_CEP_AFTER__Group_6__1 )
            // InternalSensinact.g:2837:2: rule__DSL_CEP_AFTER__Group_6__0__Impl rule__DSL_CEP_AFTER__Group_6__1
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_AFTER__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group_6__0"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group_6__0__Impl"
    // InternalSensinact.g:2844:1: rule__DSL_CEP_AFTER__Group_6__0__Impl : ( ( rule__DSL_CEP_AFTER__StartAssignment_6_0 ) ) ;
    public final void rule__DSL_CEP_AFTER__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2848:1: ( ( ( rule__DSL_CEP_AFTER__StartAssignment_6_0 ) ) )
            // InternalSensinact.g:2849:1: ( ( rule__DSL_CEP_AFTER__StartAssignment_6_0 ) )
            {
            // InternalSensinact.g:2849:1: ( ( rule__DSL_CEP_AFTER__StartAssignment_6_0 ) )
            // InternalSensinact.g:2850:2: ( rule__DSL_CEP_AFTER__StartAssignment_6_0 )
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getStartAssignment_6_0()); 
            // InternalSensinact.g:2851:2: ( rule__DSL_CEP_AFTER__StartAssignment_6_0 )
            // InternalSensinact.g:2851:3: rule__DSL_CEP_AFTER__StartAssignment_6_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__StartAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_AFTERAccess().getStartAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group_6__0__Impl"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group_6__1"
    // InternalSensinact.g:2859:1: rule__DSL_CEP_AFTER__Group_6__1 : rule__DSL_CEP_AFTER__Group_6__1__Impl ;
    public final void rule__DSL_CEP_AFTER__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2863:1: ( rule__DSL_CEP_AFTER__Group_6__1__Impl )
            // InternalSensinact.g:2864:2: rule__DSL_CEP_AFTER__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AFTER__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group_6__1"


    // $ANTLR start "rule__DSL_CEP_AFTER__Group_6__1__Impl"
    // InternalSensinact.g:2870:1: rule__DSL_CEP_AFTER__Group_6__1__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_AFTER__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2874:1: ( ( ',' ) )
            // InternalSensinact.g:2875:1: ( ',' )
            {
            // InternalSensinact.g:2875:1: ( ',' )
            // InternalSensinact.g:2876:2: ','
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getCommaKeyword_6_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AFTERAccess().getCommaKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Group_6__1__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__0"
    // InternalSensinact.g:2886:1: rule__DSL_CEP_BEFORE__Group__0 : rule__DSL_CEP_BEFORE__Group__0__Impl rule__DSL_CEP_BEFORE__Group__1 ;
    public final void rule__DSL_CEP_BEFORE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2890:1: ( rule__DSL_CEP_BEFORE__Group__0__Impl rule__DSL_CEP_BEFORE__Group__1 )
            // InternalSensinact.g:2891:2: rule__DSL_CEP_BEFORE__Group__0__Impl rule__DSL_CEP_BEFORE__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__DSL_CEP_BEFORE__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__0"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__0__Impl"
    // InternalSensinact.g:2898:1: rule__DSL_CEP_BEFORE__Group__0__Impl : ( 'before' ) ;
    public final void rule__DSL_CEP_BEFORE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2902:1: ( ( 'before' ) )
            // InternalSensinact.g:2903:1: ( 'before' )
            {
            // InternalSensinact.g:2903:1: ( 'before' )
            // InternalSensinact.g:2904:2: 'before'
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getBeforeKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_BEFOREAccess().getBeforeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__1"
    // InternalSensinact.g:2913:1: rule__DSL_CEP_BEFORE__Group__1 : rule__DSL_CEP_BEFORE__Group__1__Impl rule__DSL_CEP_BEFORE__Group__2 ;
    public final void rule__DSL_CEP_BEFORE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2917:1: ( rule__DSL_CEP_BEFORE__Group__1__Impl rule__DSL_CEP_BEFORE__Group__2 )
            // InternalSensinact.g:2918:2: rule__DSL_CEP_BEFORE__Group__1__Impl rule__DSL_CEP_BEFORE__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_BEFORE__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__1"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__1__Impl"
    // InternalSensinact.g:2925:1: rule__DSL_CEP_BEFORE__Group__1__Impl : ( '(' ) ;
    public final void rule__DSL_CEP_BEFORE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2929:1: ( ( '(' ) )
            // InternalSensinact.g:2930:1: ( '(' )
            {
            // InternalSensinact.g:2930:1: ( '(' )
            // InternalSensinact.g:2931:2: '('
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getLeftParenthesisKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_BEFOREAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__2"
    // InternalSensinact.g:2940:1: rule__DSL_CEP_BEFORE__Group__2 : rule__DSL_CEP_BEFORE__Group__2__Impl rule__DSL_CEP_BEFORE__Group__3 ;
    public final void rule__DSL_CEP_BEFORE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2944:1: ( rule__DSL_CEP_BEFORE__Group__2__Impl rule__DSL_CEP_BEFORE__Group__3 )
            // InternalSensinact.g:2945:2: rule__DSL_CEP_BEFORE__Group__2__Impl rule__DSL_CEP_BEFORE__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_BEFORE__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__2"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__2__Impl"
    // InternalSensinact.g:2952:1: rule__DSL_CEP_BEFORE__Group__2__Impl : ( ( rule__DSL_CEP_BEFORE__Ref1Assignment_2 ) ) ;
    public final void rule__DSL_CEP_BEFORE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2956:1: ( ( ( rule__DSL_CEP_BEFORE__Ref1Assignment_2 ) ) )
            // InternalSensinact.g:2957:1: ( ( rule__DSL_CEP_BEFORE__Ref1Assignment_2 ) )
            {
            // InternalSensinact.g:2957:1: ( ( rule__DSL_CEP_BEFORE__Ref1Assignment_2 ) )
            // InternalSensinact.g:2958:2: ( rule__DSL_CEP_BEFORE__Ref1Assignment_2 )
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getRef1Assignment_2()); 
            // InternalSensinact.g:2959:2: ( rule__DSL_CEP_BEFORE__Ref1Assignment_2 )
            // InternalSensinact.g:2959:3: rule__DSL_CEP_BEFORE__Ref1Assignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Ref1Assignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getRef1Assignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__2__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__3"
    // InternalSensinact.g:2967:1: rule__DSL_CEP_BEFORE__Group__3 : rule__DSL_CEP_BEFORE__Group__3__Impl rule__DSL_CEP_BEFORE__Group__4 ;
    public final void rule__DSL_CEP_BEFORE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2971:1: ( rule__DSL_CEP_BEFORE__Group__3__Impl rule__DSL_CEP_BEFORE__Group__4 )
            // InternalSensinact.g:2972:2: rule__DSL_CEP_BEFORE__Group__3__Impl rule__DSL_CEP_BEFORE__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_BEFORE__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__3"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__3__Impl"
    // InternalSensinact.g:2979:1: rule__DSL_CEP_BEFORE__Group__3__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_BEFORE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2983:1: ( ( ',' ) )
            // InternalSensinact.g:2984:1: ( ',' )
            {
            // InternalSensinact.g:2984:1: ( ',' )
            // InternalSensinact.g:2985:2: ','
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getCommaKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_BEFOREAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__3__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__4"
    // InternalSensinact.g:2994:1: rule__DSL_CEP_BEFORE__Group__4 : rule__DSL_CEP_BEFORE__Group__4__Impl rule__DSL_CEP_BEFORE__Group__5 ;
    public final void rule__DSL_CEP_BEFORE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:2998:1: ( rule__DSL_CEP_BEFORE__Group__4__Impl rule__DSL_CEP_BEFORE__Group__5 )
            // InternalSensinact.g:2999:2: rule__DSL_CEP_BEFORE__Group__4__Impl rule__DSL_CEP_BEFORE__Group__5
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_BEFORE__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__4"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__4__Impl"
    // InternalSensinact.g:3006:1: rule__DSL_CEP_BEFORE__Group__4__Impl : ( ( rule__DSL_CEP_BEFORE__Ref2Assignment_4 ) ) ;
    public final void rule__DSL_CEP_BEFORE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3010:1: ( ( ( rule__DSL_CEP_BEFORE__Ref2Assignment_4 ) ) )
            // InternalSensinact.g:3011:1: ( ( rule__DSL_CEP_BEFORE__Ref2Assignment_4 ) )
            {
            // InternalSensinact.g:3011:1: ( ( rule__DSL_CEP_BEFORE__Ref2Assignment_4 ) )
            // InternalSensinact.g:3012:2: ( rule__DSL_CEP_BEFORE__Ref2Assignment_4 )
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getRef2Assignment_4()); 
            // InternalSensinact.g:3013:2: ( rule__DSL_CEP_BEFORE__Ref2Assignment_4 )
            // InternalSensinact.g:3013:3: rule__DSL_CEP_BEFORE__Ref2Assignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Ref2Assignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getRef2Assignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__4__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__5"
    // InternalSensinact.g:3021:1: rule__DSL_CEP_BEFORE__Group__5 : rule__DSL_CEP_BEFORE__Group__5__Impl rule__DSL_CEP_BEFORE__Group__6 ;
    public final void rule__DSL_CEP_BEFORE__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3025:1: ( rule__DSL_CEP_BEFORE__Group__5__Impl rule__DSL_CEP_BEFORE__Group__6 )
            // InternalSensinact.g:3026:2: rule__DSL_CEP_BEFORE__Group__5__Impl rule__DSL_CEP_BEFORE__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_BEFORE__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__5"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__5__Impl"
    // InternalSensinact.g:3033:1: rule__DSL_CEP_BEFORE__Group__5__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_BEFORE__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3037:1: ( ( ',' ) )
            // InternalSensinact.g:3038:1: ( ',' )
            {
            // InternalSensinact.g:3038:1: ( ',' )
            // InternalSensinact.g:3039:2: ','
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getCommaKeyword_5()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_BEFOREAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__5__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__6"
    // InternalSensinact.g:3048:1: rule__DSL_CEP_BEFORE__Group__6 : rule__DSL_CEP_BEFORE__Group__6__Impl rule__DSL_CEP_BEFORE__Group__7 ;
    public final void rule__DSL_CEP_BEFORE__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3052:1: ( rule__DSL_CEP_BEFORE__Group__6__Impl rule__DSL_CEP_BEFORE__Group__7 )
            // InternalSensinact.g:3053:2: rule__DSL_CEP_BEFORE__Group__6__Impl rule__DSL_CEP_BEFORE__Group__7
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_BEFORE__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__6"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__6__Impl"
    // InternalSensinact.g:3060:1: rule__DSL_CEP_BEFORE__Group__6__Impl : ( ( rule__DSL_CEP_BEFORE__Group_6__0 )? ) ;
    public final void rule__DSL_CEP_BEFORE__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3064:1: ( ( ( rule__DSL_CEP_BEFORE__Group_6__0 )? ) )
            // InternalSensinact.g:3065:1: ( ( rule__DSL_CEP_BEFORE__Group_6__0 )? )
            {
            // InternalSensinact.g:3065:1: ( ( rule__DSL_CEP_BEFORE__Group_6__0 )? )
            // InternalSensinact.g:3066:2: ( rule__DSL_CEP_BEFORE__Group_6__0 )?
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getGroup_6()); 
            // InternalSensinact.g:3067:2: ( rule__DSL_CEP_BEFORE__Group_6__0 )?
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalSensinact.g:3067:3: rule__DSL_CEP_BEFORE__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_CEP_BEFORE__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__6__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__7"
    // InternalSensinact.g:3075:1: rule__DSL_CEP_BEFORE__Group__7 : rule__DSL_CEP_BEFORE__Group__7__Impl rule__DSL_CEP_BEFORE__Group__8 ;
    public final void rule__DSL_CEP_BEFORE__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3079:1: ( rule__DSL_CEP_BEFORE__Group__7__Impl rule__DSL_CEP_BEFORE__Group__8 )
            // InternalSensinact.g:3080:2: rule__DSL_CEP_BEFORE__Group__7__Impl rule__DSL_CEP_BEFORE__Group__8
            {
            pushFollow(FOLLOW_25);
            rule__DSL_CEP_BEFORE__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__7"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__7__Impl"
    // InternalSensinact.g:3087:1: rule__DSL_CEP_BEFORE__Group__7__Impl : ( ( rule__DSL_CEP_BEFORE__EndAssignment_7 ) ) ;
    public final void rule__DSL_CEP_BEFORE__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3091:1: ( ( ( rule__DSL_CEP_BEFORE__EndAssignment_7 ) ) )
            // InternalSensinact.g:3092:1: ( ( rule__DSL_CEP_BEFORE__EndAssignment_7 ) )
            {
            // InternalSensinact.g:3092:1: ( ( rule__DSL_CEP_BEFORE__EndAssignment_7 ) )
            // InternalSensinact.g:3093:2: ( rule__DSL_CEP_BEFORE__EndAssignment_7 )
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getEndAssignment_7()); 
            // InternalSensinact.g:3094:2: ( rule__DSL_CEP_BEFORE__EndAssignment_7 )
            // InternalSensinact.g:3094:3: rule__DSL_CEP_BEFORE__EndAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__EndAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getEndAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__7__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__8"
    // InternalSensinact.g:3102:1: rule__DSL_CEP_BEFORE__Group__8 : rule__DSL_CEP_BEFORE__Group__8__Impl ;
    public final void rule__DSL_CEP_BEFORE__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3106:1: ( rule__DSL_CEP_BEFORE__Group__8__Impl )
            // InternalSensinact.g:3107:2: rule__DSL_CEP_BEFORE__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__8"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group__8__Impl"
    // InternalSensinact.g:3113:1: rule__DSL_CEP_BEFORE__Group__8__Impl : ( ')' ) ;
    public final void rule__DSL_CEP_BEFORE__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3117:1: ( ( ')' ) )
            // InternalSensinact.g:3118:1: ( ')' )
            {
            // InternalSensinact.g:3118:1: ( ')' )
            // InternalSensinact.g:3119:2: ')'
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getRightParenthesisKeyword_8()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_BEFOREAccess().getRightParenthesisKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group__8__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group_6__0"
    // InternalSensinact.g:3129:1: rule__DSL_CEP_BEFORE__Group_6__0 : rule__DSL_CEP_BEFORE__Group_6__0__Impl rule__DSL_CEP_BEFORE__Group_6__1 ;
    public final void rule__DSL_CEP_BEFORE__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3133:1: ( rule__DSL_CEP_BEFORE__Group_6__0__Impl rule__DSL_CEP_BEFORE__Group_6__1 )
            // InternalSensinact.g:3134:2: rule__DSL_CEP_BEFORE__Group_6__0__Impl rule__DSL_CEP_BEFORE__Group_6__1
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_BEFORE__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group_6__0"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group_6__0__Impl"
    // InternalSensinact.g:3141:1: rule__DSL_CEP_BEFORE__Group_6__0__Impl : ( ( rule__DSL_CEP_BEFORE__StartAssignment_6_0 ) ) ;
    public final void rule__DSL_CEP_BEFORE__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3145:1: ( ( ( rule__DSL_CEP_BEFORE__StartAssignment_6_0 ) ) )
            // InternalSensinact.g:3146:1: ( ( rule__DSL_CEP_BEFORE__StartAssignment_6_0 ) )
            {
            // InternalSensinact.g:3146:1: ( ( rule__DSL_CEP_BEFORE__StartAssignment_6_0 ) )
            // InternalSensinact.g:3147:2: ( rule__DSL_CEP_BEFORE__StartAssignment_6_0 )
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getStartAssignment_6_0()); 
            // InternalSensinact.g:3148:2: ( rule__DSL_CEP_BEFORE__StartAssignment_6_0 )
            // InternalSensinact.g:3148:3: rule__DSL_CEP_BEFORE__StartAssignment_6_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__StartAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getStartAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group_6__0__Impl"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group_6__1"
    // InternalSensinact.g:3156:1: rule__DSL_CEP_BEFORE__Group_6__1 : rule__DSL_CEP_BEFORE__Group_6__1__Impl ;
    public final void rule__DSL_CEP_BEFORE__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3160:1: ( rule__DSL_CEP_BEFORE__Group_6__1__Impl )
            // InternalSensinact.g:3161:2: rule__DSL_CEP_BEFORE__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_BEFORE__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group_6__1"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Group_6__1__Impl"
    // InternalSensinact.g:3167:1: rule__DSL_CEP_BEFORE__Group_6__1__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_BEFORE__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3171:1: ( ( ',' ) )
            // InternalSensinact.g:3172:1: ( ',' )
            {
            // InternalSensinact.g:3172:1: ( ',' )
            // InternalSensinact.g:3173:2: ','
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getCommaKeyword_6_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_BEFOREAccess().getCommaKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Group_6__1__Impl"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__0"
    // InternalSensinact.g:3183:1: rule__DSL_CEP_COINCIDE__Group__0 : rule__DSL_CEP_COINCIDE__Group__0__Impl rule__DSL_CEP_COINCIDE__Group__1 ;
    public final void rule__DSL_CEP_COINCIDE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3187:1: ( rule__DSL_CEP_COINCIDE__Group__0__Impl rule__DSL_CEP_COINCIDE__Group__1 )
            // InternalSensinact.g:3188:2: rule__DSL_CEP_COINCIDE__Group__0__Impl rule__DSL_CEP_COINCIDE__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__DSL_CEP_COINCIDE__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__0"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__0__Impl"
    // InternalSensinact.g:3195:1: rule__DSL_CEP_COINCIDE__Group__0__Impl : ( 'coincide' ) ;
    public final void rule__DSL_CEP_COINCIDE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3199:1: ( ( 'coincide' ) )
            // InternalSensinact.g:3200:1: ( 'coincide' )
            {
            // InternalSensinact.g:3200:1: ( 'coincide' )
            // InternalSensinact.g:3201:2: 'coincide'
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getCoincideKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getCoincideKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__1"
    // InternalSensinact.g:3210:1: rule__DSL_CEP_COINCIDE__Group__1 : rule__DSL_CEP_COINCIDE__Group__1__Impl rule__DSL_CEP_COINCIDE__Group__2 ;
    public final void rule__DSL_CEP_COINCIDE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3214:1: ( rule__DSL_CEP_COINCIDE__Group__1__Impl rule__DSL_CEP_COINCIDE__Group__2 )
            // InternalSensinact.g:3215:2: rule__DSL_CEP_COINCIDE__Group__1__Impl rule__DSL_CEP_COINCIDE__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_COINCIDE__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__1"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__1__Impl"
    // InternalSensinact.g:3222:1: rule__DSL_CEP_COINCIDE__Group__1__Impl : ( '(' ) ;
    public final void rule__DSL_CEP_COINCIDE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3226:1: ( ( '(' ) )
            // InternalSensinact.g:3227:1: ( '(' )
            {
            // InternalSensinact.g:3227:1: ( '(' )
            // InternalSensinact.g:3228:2: '('
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getLeftParenthesisKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__2"
    // InternalSensinact.g:3237:1: rule__DSL_CEP_COINCIDE__Group__2 : rule__DSL_CEP_COINCIDE__Group__2__Impl rule__DSL_CEP_COINCIDE__Group__3 ;
    public final void rule__DSL_CEP_COINCIDE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3241:1: ( rule__DSL_CEP_COINCIDE__Group__2__Impl rule__DSL_CEP_COINCIDE__Group__3 )
            // InternalSensinact.g:3242:2: rule__DSL_CEP_COINCIDE__Group__2__Impl rule__DSL_CEP_COINCIDE__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_COINCIDE__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__2"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__2__Impl"
    // InternalSensinact.g:3249:1: rule__DSL_CEP_COINCIDE__Group__2__Impl : ( ( rule__DSL_CEP_COINCIDE__Ref1Assignment_2 ) ) ;
    public final void rule__DSL_CEP_COINCIDE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3253:1: ( ( ( rule__DSL_CEP_COINCIDE__Ref1Assignment_2 ) ) )
            // InternalSensinact.g:3254:1: ( ( rule__DSL_CEP_COINCIDE__Ref1Assignment_2 ) )
            {
            // InternalSensinact.g:3254:1: ( ( rule__DSL_CEP_COINCIDE__Ref1Assignment_2 ) )
            // InternalSensinact.g:3255:2: ( rule__DSL_CEP_COINCIDE__Ref1Assignment_2 )
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef1Assignment_2()); 
            // InternalSensinact.g:3256:2: ( rule__DSL_CEP_COINCIDE__Ref1Assignment_2 )
            // InternalSensinact.g:3256:3: rule__DSL_CEP_COINCIDE__Ref1Assignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Ref1Assignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef1Assignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__2__Impl"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__3"
    // InternalSensinact.g:3264:1: rule__DSL_CEP_COINCIDE__Group__3 : rule__DSL_CEP_COINCIDE__Group__3__Impl rule__DSL_CEP_COINCIDE__Group__4 ;
    public final void rule__DSL_CEP_COINCIDE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3268:1: ( rule__DSL_CEP_COINCIDE__Group__3__Impl rule__DSL_CEP_COINCIDE__Group__4 )
            // InternalSensinact.g:3269:2: rule__DSL_CEP_COINCIDE__Group__3__Impl rule__DSL_CEP_COINCIDE__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_COINCIDE__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__3"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__3__Impl"
    // InternalSensinact.g:3276:1: rule__DSL_CEP_COINCIDE__Group__3__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_COINCIDE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3280:1: ( ( ',' ) )
            // InternalSensinact.g:3281:1: ( ',' )
            {
            // InternalSensinact.g:3281:1: ( ',' )
            // InternalSensinact.g:3282:2: ','
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getCommaKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__3__Impl"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__4"
    // InternalSensinact.g:3291:1: rule__DSL_CEP_COINCIDE__Group__4 : rule__DSL_CEP_COINCIDE__Group__4__Impl rule__DSL_CEP_COINCIDE__Group__5 ;
    public final void rule__DSL_CEP_COINCIDE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3295:1: ( rule__DSL_CEP_COINCIDE__Group__4__Impl rule__DSL_CEP_COINCIDE__Group__5 )
            // InternalSensinact.g:3296:2: rule__DSL_CEP_COINCIDE__Group__4__Impl rule__DSL_CEP_COINCIDE__Group__5
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_COINCIDE__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__4"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__4__Impl"
    // InternalSensinact.g:3303:1: rule__DSL_CEP_COINCIDE__Group__4__Impl : ( ( rule__DSL_CEP_COINCIDE__Ref2Assignment_4 ) ) ;
    public final void rule__DSL_CEP_COINCIDE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3307:1: ( ( ( rule__DSL_CEP_COINCIDE__Ref2Assignment_4 ) ) )
            // InternalSensinact.g:3308:1: ( ( rule__DSL_CEP_COINCIDE__Ref2Assignment_4 ) )
            {
            // InternalSensinact.g:3308:1: ( ( rule__DSL_CEP_COINCIDE__Ref2Assignment_4 ) )
            // InternalSensinact.g:3309:2: ( rule__DSL_CEP_COINCIDE__Ref2Assignment_4 )
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef2Assignment_4()); 
            // InternalSensinact.g:3310:2: ( rule__DSL_CEP_COINCIDE__Ref2Assignment_4 )
            // InternalSensinact.g:3310:3: rule__DSL_CEP_COINCIDE__Ref2Assignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Ref2Assignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef2Assignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__4__Impl"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__5"
    // InternalSensinact.g:3318:1: rule__DSL_CEP_COINCIDE__Group__5 : rule__DSL_CEP_COINCIDE__Group__5__Impl rule__DSL_CEP_COINCIDE__Group__6 ;
    public final void rule__DSL_CEP_COINCIDE__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3322:1: ( rule__DSL_CEP_COINCIDE__Group__5__Impl rule__DSL_CEP_COINCIDE__Group__6 )
            // InternalSensinact.g:3323:2: rule__DSL_CEP_COINCIDE__Group__5__Impl rule__DSL_CEP_COINCIDE__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_COINCIDE__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__5"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__5__Impl"
    // InternalSensinact.g:3330:1: rule__DSL_CEP_COINCIDE__Group__5__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_COINCIDE__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3334:1: ( ( ',' ) )
            // InternalSensinact.g:3335:1: ( ',' )
            {
            // InternalSensinact.g:3335:1: ( ',' )
            // InternalSensinact.g:3336:2: ','
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getCommaKeyword_5()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__5__Impl"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__6"
    // InternalSensinact.g:3345:1: rule__DSL_CEP_COINCIDE__Group__6 : rule__DSL_CEP_COINCIDE__Group__6__Impl rule__DSL_CEP_COINCIDE__Group__7 ;
    public final void rule__DSL_CEP_COINCIDE__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3349:1: ( rule__DSL_CEP_COINCIDE__Group__6__Impl rule__DSL_CEP_COINCIDE__Group__7 )
            // InternalSensinact.g:3350:2: rule__DSL_CEP_COINCIDE__Group__6__Impl rule__DSL_CEP_COINCIDE__Group__7
            {
            pushFollow(FOLLOW_25);
            rule__DSL_CEP_COINCIDE__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__6"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__6__Impl"
    // InternalSensinact.g:3357:1: rule__DSL_CEP_COINCIDE__Group__6__Impl : ( ( rule__DSL_CEP_COINCIDE__WindowAssignment_6 ) ) ;
    public final void rule__DSL_CEP_COINCIDE__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3361:1: ( ( ( rule__DSL_CEP_COINCIDE__WindowAssignment_6 ) ) )
            // InternalSensinact.g:3362:1: ( ( rule__DSL_CEP_COINCIDE__WindowAssignment_6 ) )
            {
            // InternalSensinact.g:3362:1: ( ( rule__DSL_CEP_COINCIDE__WindowAssignment_6 ) )
            // InternalSensinact.g:3363:2: ( rule__DSL_CEP_COINCIDE__WindowAssignment_6 )
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getWindowAssignment_6()); 
            // InternalSensinact.g:3364:2: ( rule__DSL_CEP_COINCIDE__WindowAssignment_6 )
            // InternalSensinact.g:3364:3: rule__DSL_CEP_COINCIDE__WindowAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__WindowAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getWindowAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__6__Impl"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__7"
    // InternalSensinact.g:3372:1: rule__DSL_CEP_COINCIDE__Group__7 : rule__DSL_CEP_COINCIDE__Group__7__Impl ;
    public final void rule__DSL_CEP_COINCIDE__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3376:1: ( rule__DSL_CEP_COINCIDE__Group__7__Impl )
            // InternalSensinact.g:3377:2: rule__DSL_CEP_COINCIDE__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COINCIDE__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__7"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Group__7__Impl"
    // InternalSensinact.g:3383:1: rule__DSL_CEP_COINCIDE__Group__7__Impl : ( ')' ) ;
    public final void rule__DSL_CEP_COINCIDE__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3387:1: ( ( ')' ) )
            // InternalSensinact.g:3388:1: ( ')' )
            {
            // InternalSensinact.g:3388:1: ( ')' )
            // InternalSensinact.g:3389:2: ')'
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getRightParenthesisKeyword_7()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Group__7__Impl"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__0"
    // InternalSensinact.g:3399:1: rule__DSL_CEP_MIN__Group__0 : rule__DSL_CEP_MIN__Group__0__Impl rule__DSL_CEP_MIN__Group__1 ;
    public final void rule__DSL_CEP_MIN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3403:1: ( rule__DSL_CEP_MIN__Group__0__Impl rule__DSL_CEP_MIN__Group__1 )
            // InternalSensinact.g:3404:2: rule__DSL_CEP_MIN__Group__0__Impl rule__DSL_CEP_MIN__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__DSL_CEP_MIN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MIN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__0"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__0__Impl"
    // InternalSensinact.g:3411:1: rule__DSL_CEP_MIN__Group__0__Impl : ( 'min' ) ;
    public final void rule__DSL_CEP_MIN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3415:1: ( ( 'min' ) )
            // InternalSensinact.g:3416:1: ( 'min' )
            {
            // InternalSensinact.g:3416:1: ( 'min' )
            // InternalSensinact.g:3417:2: 'min'
            {
             before(grammarAccess.getDSL_CEP_MINAccess().getMinKeyword_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_MINAccess().getMinKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__1"
    // InternalSensinact.g:3426:1: rule__DSL_CEP_MIN__Group__1 : rule__DSL_CEP_MIN__Group__1__Impl rule__DSL_CEP_MIN__Group__2 ;
    public final void rule__DSL_CEP_MIN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3430:1: ( rule__DSL_CEP_MIN__Group__1__Impl rule__DSL_CEP_MIN__Group__2 )
            // InternalSensinact.g:3431:2: rule__DSL_CEP_MIN__Group__1__Impl rule__DSL_CEP_MIN__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_MIN__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MIN__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__1"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__1__Impl"
    // InternalSensinact.g:3438:1: rule__DSL_CEP_MIN__Group__1__Impl : ( '(' ) ;
    public final void rule__DSL_CEP_MIN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3442:1: ( ( '(' ) )
            // InternalSensinact.g:3443:1: ( '(' )
            {
            // InternalSensinact.g:3443:1: ( '(' )
            // InternalSensinact.g:3444:2: '('
            {
             before(grammarAccess.getDSL_CEP_MINAccess().getLeftParenthesisKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_MINAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__2"
    // InternalSensinact.g:3453:1: rule__DSL_CEP_MIN__Group__2 : rule__DSL_CEP_MIN__Group__2__Impl rule__DSL_CEP_MIN__Group__3 ;
    public final void rule__DSL_CEP_MIN__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3457:1: ( rule__DSL_CEP_MIN__Group__2__Impl rule__DSL_CEP_MIN__Group__3 )
            // InternalSensinact.g:3458:2: rule__DSL_CEP_MIN__Group__2__Impl rule__DSL_CEP_MIN__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_MIN__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MIN__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__2"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__2__Impl"
    // InternalSensinact.g:3465:1: rule__DSL_CEP_MIN__Group__2__Impl : ( ( rule__DSL_CEP_MIN__RefAssignment_2 ) ) ;
    public final void rule__DSL_CEP_MIN__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3469:1: ( ( ( rule__DSL_CEP_MIN__RefAssignment_2 ) ) )
            // InternalSensinact.g:3470:1: ( ( rule__DSL_CEP_MIN__RefAssignment_2 ) )
            {
            // InternalSensinact.g:3470:1: ( ( rule__DSL_CEP_MIN__RefAssignment_2 ) )
            // InternalSensinact.g:3471:2: ( rule__DSL_CEP_MIN__RefAssignment_2 )
            {
             before(grammarAccess.getDSL_CEP_MINAccess().getRefAssignment_2()); 
            // InternalSensinact.g:3472:2: ( rule__DSL_CEP_MIN__RefAssignment_2 )
            // InternalSensinact.g:3472:3: rule__DSL_CEP_MIN__RefAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MIN__RefAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_MINAccess().getRefAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__2__Impl"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__3"
    // InternalSensinact.g:3480:1: rule__DSL_CEP_MIN__Group__3 : rule__DSL_CEP_MIN__Group__3__Impl rule__DSL_CEP_MIN__Group__4 ;
    public final void rule__DSL_CEP_MIN__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3484:1: ( rule__DSL_CEP_MIN__Group__3__Impl rule__DSL_CEP_MIN__Group__4 )
            // InternalSensinact.g:3485:2: rule__DSL_CEP_MIN__Group__3__Impl rule__DSL_CEP_MIN__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_MIN__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MIN__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__3"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__3__Impl"
    // InternalSensinact.g:3492:1: rule__DSL_CEP_MIN__Group__3__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_MIN__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3496:1: ( ( ',' ) )
            // InternalSensinact.g:3497:1: ( ',' )
            {
            // InternalSensinact.g:3497:1: ( ',' )
            // InternalSensinact.g:3498:2: ','
            {
             before(grammarAccess.getDSL_CEP_MINAccess().getCommaKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_MINAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__3__Impl"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__4"
    // InternalSensinact.g:3507:1: rule__DSL_CEP_MIN__Group__4 : rule__DSL_CEP_MIN__Group__4__Impl rule__DSL_CEP_MIN__Group__5 ;
    public final void rule__DSL_CEP_MIN__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3511:1: ( rule__DSL_CEP_MIN__Group__4__Impl rule__DSL_CEP_MIN__Group__5 )
            // InternalSensinact.g:3512:2: rule__DSL_CEP_MIN__Group__4__Impl rule__DSL_CEP_MIN__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__DSL_CEP_MIN__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MIN__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__4"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__4__Impl"
    // InternalSensinact.g:3519:1: rule__DSL_CEP_MIN__Group__4__Impl : ( ( rule__DSL_CEP_MIN__WindowAssignment_4 ) ) ;
    public final void rule__DSL_CEP_MIN__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3523:1: ( ( ( rule__DSL_CEP_MIN__WindowAssignment_4 ) ) )
            // InternalSensinact.g:3524:1: ( ( rule__DSL_CEP_MIN__WindowAssignment_4 ) )
            {
            // InternalSensinact.g:3524:1: ( ( rule__DSL_CEP_MIN__WindowAssignment_4 ) )
            // InternalSensinact.g:3525:2: ( rule__DSL_CEP_MIN__WindowAssignment_4 )
            {
             before(grammarAccess.getDSL_CEP_MINAccess().getWindowAssignment_4()); 
            // InternalSensinact.g:3526:2: ( rule__DSL_CEP_MIN__WindowAssignment_4 )
            // InternalSensinact.g:3526:3: rule__DSL_CEP_MIN__WindowAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MIN__WindowAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_MINAccess().getWindowAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__4__Impl"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__5"
    // InternalSensinact.g:3534:1: rule__DSL_CEP_MIN__Group__5 : rule__DSL_CEP_MIN__Group__5__Impl ;
    public final void rule__DSL_CEP_MIN__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3538:1: ( rule__DSL_CEP_MIN__Group__5__Impl )
            // InternalSensinact.g:3539:2: rule__DSL_CEP_MIN__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MIN__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__5"


    // $ANTLR start "rule__DSL_CEP_MIN__Group__5__Impl"
    // InternalSensinact.g:3545:1: rule__DSL_CEP_MIN__Group__5__Impl : ( ')' ) ;
    public final void rule__DSL_CEP_MIN__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3549:1: ( ( ')' ) )
            // InternalSensinact.g:3550:1: ( ')' )
            {
            // InternalSensinact.g:3550:1: ( ')' )
            // InternalSensinact.g:3551:2: ')'
            {
             before(grammarAccess.getDSL_CEP_MINAccess().getRightParenthesisKeyword_5()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_MINAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__Group__5__Impl"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__0"
    // InternalSensinact.g:3561:1: rule__DSL_CEP_MAX__Group__0 : rule__DSL_CEP_MAX__Group__0__Impl rule__DSL_CEP_MAX__Group__1 ;
    public final void rule__DSL_CEP_MAX__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3565:1: ( rule__DSL_CEP_MAX__Group__0__Impl rule__DSL_CEP_MAX__Group__1 )
            // InternalSensinact.g:3566:2: rule__DSL_CEP_MAX__Group__0__Impl rule__DSL_CEP_MAX__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__DSL_CEP_MAX__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MAX__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__0"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__0__Impl"
    // InternalSensinact.g:3573:1: rule__DSL_CEP_MAX__Group__0__Impl : ( 'max' ) ;
    public final void rule__DSL_CEP_MAX__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3577:1: ( ( 'max' ) )
            // InternalSensinact.g:3578:1: ( 'max' )
            {
            // InternalSensinact.g:3578:1: ( 'max' )
            // InternalSensinact.g:3579:2: 'max'
            {
             before(grammarAccess.getDSL_CEP_MAXAccess().getMaxKeyword_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_MAXAccess().getMaxKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__1"
    // InternalSensinact.g:3588:1: rule__DSL_CEP_MAX__Group__1 : rule__DSL_CEP_MAX__Group__1__Impl rule__DSL_CEP_MAX__Group__2 ;
    public final void rule__DSL_CEP_MAX__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3592:1: ( rule__DSL_CEP_MAX__Group__1__Impl rule__DSL_CEP_MAX__Group__2 )
            // InternalSensinact.g:3593:2: rule__DSL_CEP_MAX__Group__1__Impl rule__DSL_CEP_MAX__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_MAX__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MAX__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__1"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__1__Impl"
    // InternalSensinact.g:3600:1: rule__DSL_CEP_MAX__Group__1__Impl : ( '(' ) ;
    public final void rule__DSL_CEP_MAX__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3604:1: ( ( '(' ) )
            // InternalSensinact.g:3605:1: ( '(' )
            {
            // InternalSensinact.g:3605:1: ( '(' )
            // InternalSensinact.g:3606:2: '('
            {
             before(grammarAccess.getDSL_CEP_MAXAccess().getLeftParenthesisKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_MAXAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__2"
    // InternalSensinact.g:3615:1: rule__DSL_CEP_MAX__Group__2 : rule__DSL_CEP_MAX__Group__2__Impl rule__DSL_CEP_MAX__Group__3 ;
    public final void rule__DSL_CEP_MAX__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3619:1: ( rule__DSL_CEP_MAX__Group__2__Impl rule__DSL_CEP_MAX__Group__3 )
            // InternalSensinact.g:3620:2: rule__DSL_CEP_MAX__Group__2__Impl rule__DSL_CEP_MAX__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_MAX__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MAX__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__2"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__2__Impl"
    // InternalSensinact.g:3627:1: rule__DSL_CEP_MAX__Group__2__Impl : ( ( rule__DSL_CEP_MAX__RefAssignment_2 ) ) ;
    public final void rule__DSL_CEP_MAX__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3631:1: ( ( ( rule__DSL_CEP_MAX__RefAssignment_2 ) ) )
            // InternalSensinact.g:3632:1: ( ( rule__DSL_CEP_MAX__RefAssignment_2 ) )
            {
            // InternalSensinact.g:3632:1: ( ( rule__DSL_CEP_MAX__RefAssignment_2 ) )
            // InternalSensinact.g:3633:2: ( rule__DSL_CEP_MAX__RefAssignment_2 )
            {
             before(grammarAccess.getDSL_CEP_MAXAccess().getRefAssignment_2()); 
            // InternalSensinact.g:3634:2: ( rule__DSL_CEP_MAX__RefAssignment_2 )
            // InternalSensinact.g:3634:3: rule__DSL_CEP_MAX__RefAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MAX__RefAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_MAXAccess().getRefAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__2__Impl"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__3"
    // InternalSensinact.g:3642:1: rule__DSL_CEP_MAX__Group__3 : rule__DSL_CEP_MAX__Group__3__Impl rule__DSL_CEP_MAX__Group__4 ;
    public final void rule__DSL_CEP_MAX__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3646:1: ( rule__DSL_CEP_MAX__Group__3__Impl rule__DSL_CEP_MAX__Group__4 )
            // InternalSensinact.g:3647:2: rule__DSL_CEP_MAX__Group__3__Impl rule__DSL_CEP_MAX__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_MAX__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MAX__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__3"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__3__Impl"
    // InternalSensinact.g:3654:1: rule__DSL_CEP_MAX__Group__3__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_MAX__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3658:1: ( ( ',' ) )
            // InternalSensinact.g:3659:1: ( ',' )
            {
            // InternalSensinact.g:3659:1: ( ',' )
            // InternalSensinact.g:3660:2: ','
            {
             before(grammarAccess.getDSL_CEP_MAXAccess().getCommaKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_MAXAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__3__Impl"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__4"
    // InternalSensinact.g:3669:1: rule__DSL_CEP_MAX__Group__4 : rule__DSL_CEP_MAX__Group__4__Impl rule__DSL_CEP_MAX__Group__5 ;
    public final void rule__DSL_CEP_MAX__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3673:1: ( rule__DSL_CEP_MAX__Group__4__Impl rule__DSL_CEP_MAX__Group__5 )
            // InternalSensinact.g:3674:2: rule__DSL_CEP_MAX__Group__4__Impl rule__DSL_CEP_MAX__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__DSL_CEP_MAX__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MAX__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__4"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__4__Impl"
    // InternalSensinact.g:3681:1: rule__DSL_CEP_MAX__Group__4__Impl : ( ( rule__DSL_CEP_MAX__WindowAssignment_4 ) ) ;
    public final void rule__DSL_CEP_MAX__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3685:1: ( ( ( rule__DSL_CEP_MAX__WindowAssignment_4 ) ) )
            // InternalSensinact.g:3686:1: ( ( rule__DSL_CEP_MAX__WindowAssignment_4 ) )
            {
            // InternalSensinact.g:3686:1: ( ( rule__DSL_CEP_MAX__WindowAssignment_4 ) )
            // InternalSensinact.g:3687:2: ( rule__DSL_CEP_MAX__WindowAssignment_4 )
            {
             before(grammarAccess.getDSL_CEP_MAXAccess().getWindowAssignment_4()); 
            // InternalSensinact.g:3688:2: ( rule__DSL_CEP_MAX__WindowAssignment_4 )
            // InternalSensinact.g:3688:3: rule__DSL_CEP_MAX__WindowAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MAX__WindowAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_MAXAccess().getWindowAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__4__Impl"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__5"
    // InternalSensinact.g:3696:1: rule__DSL_CEP_MAX__Group__5 : rule__DSL_CEP_MAX__Group__5__Impl ;
    public final void rule__DSL_CEP_MAX__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3700:1: ( rule__DSL_CEP_MAX__Group__5__Impl )
            // InternalSensinact.g:3701:2: rule__DSL_CEP_MAX__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_MAX__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__5"


    // $ANTLR start "rule__DSL_CEP_MAX__Group__5__Impl"
    // InternalSensinact.g:3707:1: rule__DSL_CEP_MAX__Group__5__Impl : ( ')' ) ;
    public final void rule__DSL_CEP_MAX__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3711:1: ( ( ')' ) )
            // InternalSensinact.g:3712:1: ( ')' )
            {
            // InternalSensinact.g:3712:1: ( ')' )
            // InternalSensinact.g:3713:2: ')'
            {
             before(grammarAccess.getDSL_CEP_MAXAccess().getRightParenthesisKeyword_5()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_MAXAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__Group__5__Impl"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__0"
    // InternalSensinact.g:3723:1: rule__DSL_CEP_AVG__Group__0 : rule__DSL_CEP_AVG__Group__0__Impl rule__DSL_CEP_AVG__Group__1 ;
    public final void rule__DSL_CEP_AVG__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3727:1: ( rule__DSL_CEP_AVG__Group__0__Impl rule__DSL_CEP_AVG__Group__1 )
            // InternalSensinact.g:3728:2: rule__DSL_CEP_AVG__Group__0__Impl rule__DSL_CEP_AVG__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__DSL_CEP_AVG__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AVG__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__0"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__0__Impl"
    // InternalSensinact.g:3735:1: rule__DSL_CEP_AVG__Group__0__Impl : ( 'avg' ) ;
    public final void rule__DSL_CEP_AVG__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3739:1: ( ( 'avg' ) )
            // InternalSensinact.g:3740:1: ( 'avg' )
            {
            // InternalSensinact.g:3740:1: ( 'avg' )
            // InternalSensinact.g:3741:2: 'avg'
            {
             before(grammarAccess.getDSL_CEP_AVGAccess().getAvgKeyword_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AVGAccess().getAvgKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__1"
    // InternalSensinact.g:3750:1: rule__DSL_CEP_AVG__Group__1 : rule__DSL_CEP_AVG__Group__1__Impl rule__DSL_CEP_AVG__Group__2 ;
    public final void rule__DSL_CEP_AVG__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3754:1: ( rule__DSL_CEP_AVG__Group__1__Impl rule__DSL_CEP_AVG__Group__2 )
            // InternalSensinact.g:3755:2: rule__DSL_CEP_AVG__Group__1__Impl rule__DSL_CEP_AVG__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_AVG__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AVG__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__1"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__1__Impl"
    // InternalSensinact.g:3762:1: rule__DSL_CEP_AVG__Group__1__Impl : ( '(' ) ;
    public final void rule__DSL_CEP_AVG__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3766:1: ( ( '(' ) )
            // InternalSensinact.g:3767:1: ( '(' )
            {
            // InternalSensinact.g:3767:1: ( '(' )
            // InternalSensinact.g:3768:2: '('
            {
             before(grammarAccess.getDSL_CEP_AVGAccess().getLeftParenthesisKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AVGAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__2"
    // InternalSensinact.g:3777:1: rule__DSL_CEP_AVG__Group__2 : rule__DSL_CEP_AVG__Group__2__Impl rule__DSL_CEP_AVG__Group__3 ;
    public final void rule__DSL_CEP_AVG__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3781:1: ( rule__DSL_CEP_AVG__Group__2__Impl rule__DSL_CEP_AVG__Group__3 )
            // InternalSensinact.g:3782:2: rule__DSL_CEP_AVG__Group__2__Impl rule__DSL_CEP_AVG__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_AVG__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AVG__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__2"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__2__Impl"
    // InternalSensinact.g:3789:1: rule__DSL_CEP_AVG__Group__2__Impl : ( ( rule__DSL_CEP_AVG__RefAssignment_2 ) ) ;
    public final void rule__DSL_CEP_AVG__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3793:1: ( ( ( rule__DSL_CEP_AVG__RefAssignment_2 ) ) )
            // InternalSensinact.g:3794:1: ( ( rule__DSL_CEP_AVG__RefAssignment_2 ) )
            {
            // InternalSensinact.g:3794:1: ( ( rule__DSL_CEP_AVG__RefAssignment_2 ) )
            // InternalSensinact.g:3795:2: ( rule__DSL_CEP_AVG__RefAssignment_2 )
            {
             before(grammarAccess.getDSL_CEP_AVGAccess().getRefAssignment_2()); 
            // InternalSensinact.g:3796:2: ( rule__DSL_CEP_AVG__RefAssignment_2 )
            // InternalSensinact.g:3796:3: rule__DSL_CEP_AVG__RefAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AVG__RefAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_AVGAccess().getRefAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__2__Impl"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__3"
    // InternalSensinact.g:3804:1: rule__DSL_CEP_AVG__Group__3 : rule__DSL_CEP_AVG__Group__3__Impl rule__DSL_CEP_AVG__Group__4 ;
    public final void rule__DSL_CEP_AVG__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3808:1: ( rule__DSL_CEP_AVG__Group__3__Impl rule__DSL_CEP_AVG__Group__4 )
            // InternalSensinact.g:3809:2: rule__DSL_CEP_AVG__Group__3__Impl rule__DSL_CEP_AVG__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_AVG__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AVG__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__3"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__3__Impl"
    // InternalSensinact.g:3816:1: rule__DSL_CEP_AVG__Group__3__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_AVG__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3820:1: ( ( ',' ) )
            // InternalSensinact.g:3821:1: ( ',' )
            {
            // InternalSensinact.g:3821:1: ( ',' )
            // InternalSensinact.g:3822:2: ','
            {
             before(grammarAccess.getDSL_CEP_AVGAccess().getCommaKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AVGAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__3__Impl"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__4"
    // InternalSensinact.g:3831:1: rule__DSL_CEP_AVG__Group__4 : rule__DSL_CEP_AVG__Group__4__Impl rule__DSL_CEP_AVG__Group__5 ;
    public final void rule__DSL_CEP_AVG__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3835:1: ( rule__DSL_CEP_AVG__Group__4__Impl rule__DSL_CEP_AVG__Group__5 )
            // InternalSensinact.g:3836:2: rule__DSL_CEP_AVG__Group__4__Impl rule__DSL_CEP_AVG__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__DSL_CEP_AVG__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AVG__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__4"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__4__Impl"
    // InternalSensinact.g:3843:1: rule__DSL_CEP_AVG__Group__4__Impl : ( ( rule__DSL_CEP_AVG__WindowAssignment_4 ) ) ;
    public final void rule__DSL_CEP_AVG__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3847:1: ( ( ( rule__DSL_CEP_AVG__WindowAssignment_4 ) ) )
            // InternalSensinact.g:3848:1: ( ( rule__DSL_CEP_AVG__WindowAssignment_4 ) )
            {
            // InternalSensinact.g:3848:1: ( ( rule__DSL_CEP_AVG__WindowAssignment_4 ) )
            // InternalSensinact.g:3849:2: ( rule__DSL_CEP_AVG__WindowAssignment_4 )
            {
             before(grammarAccess.getDSL_CEP_AVGAccess().getWindowAssignment_4()); 
            // InternalSensinact.g:3850:2: ( rule__DSL_CEP_AVG__WindowAssignment_4 )
            // InternalSensinact.g:3850:3: rule__DSL_CEP_AVG__WindowAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AVG__WindowAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_AVGAccess().getWindowAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__4__Impl"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__5"
    // InternalSensinact.g:3858:1: rule__DSL_CEP_AVG__Group__5 : rule__DSL_CEP_AVG__Group__5__Impl ;
    public final void rule__DSL_CEP_AVG__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3862:1: ( rule__DSL_CEP_AVG__Group__5__Impl )
            // InternalSensinact.g:3863:2: rule__DSL_CEP_AVG__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_AVG__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__5"


    // $ANTLR start "rule__DSL_CEP_AVG__Group__5__Impl"
    // InternalSensinact.g:3869:1: rule__DSL_CEP_AVG__Group__5__Impl : ( ')' ) ;
    public final void rule__DSL_CEP_AVG__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3873:1: ( ( ')' ) )
            // InternalSensinact.g:3874:1: ( ')' )
            {
            // InternalSensinact.g:3874:1: ( ')' )
            // InternalSensinact.g:3875:2: ')'
            {
             before(grammarAccess.getDSL_CEP_AVGAccess().getRightParenthesisKeyword_5()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_AVGAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__Group__5__Impl"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__0"
    // InternalSensinact.g:3885:1: rule__DSL_CEP_SUM__Group__0 : rule__DSL_CEP_SUM__Group__0__Impl rule__DSL_CEP_SUM__Group__1 ;
    public final void rule__DSL_CEP_SUM__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3889:1: ( rule__DSL_CEP_SUM__Group__0__Impl rule__DSL_CEP_SUM__Group__1 )
            // InternalSensinact.g:3890:2: rule__DSL_CEP_SUM__Group__0__Impl rule__DSL_CEP_SUM__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__DSL_CEP_SUM__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_SUM__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__0"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__0__Impl"
    // InternalSensinact.g:3897:1: rule__DSL_CEP_SUM__Group__0__Impl : ( 'sum' ) ;
    public final void rule__DSL_CEP_SUM__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3901:1: ( ( 'sum' ) )
            // InternalSensinact.g:3902:1: ( 'sum' )
            {
            // InternalSensinact.g:3902:1: ( 'sum' )
            // InternalSensinact.g:3903:2: 'sum'
            {
             before(grammarAccess.getDSL_CEP_SUMAccess().getSumKeyword_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_SUMAccess().getSumKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__1"
    // InternalSensinact.g:3912:1: rule__DSL_CEP_SUM__Group__1 : rule__DSL_CEP_SUM__Group__1__Impl rule__DSL_CEP_SUM__Group__2 ;
    public final void rule__DSL_CEP_SUM__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3916:1: ( rule__DSL_CEP_SUM__Group__1__Impl rule__DSL_CEP_SUM__Group__2 )
            // InternalSensinact.g:3917:2: rule__DSL_CEP_SUM__Group__1__Impl rule__DSL_CEP_SUM__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_SUM__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_SUM__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__1"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__1__Impl"
    // InternalSensinact.g:3924:1: rule__DSL_CEP_SUM__Group__1__Impl : ( '(' ) ;
    public final void rule__DSL_CEP_SUM__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3928:1: ( ( '(' ) )
            // InternalSensinact.g:3929:1: ( '(' )
            {
            // InternalSensinact.g:3929:1: ( '(' )
            // InternalSensinact.g:3930:2: '('
            {
             before(grammarAccess.getDSL_CEP_SUMAccess().getLeftParenthesisKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_SUMAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__2"
    // InternalSensinact.g:3939:1: rule__DSL_CEP_SUM__Group__2 : rule__DSL_CEP_SUM__Group__2__Impl rule__DSL_CEP_SUM__Group__3 ;
    public final void rule__DSL_CEP_SUM__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3943:1: ( rule__DSL_CEP_SUM__Group__2__Impl rule__DSL_CEP_SUM__Group__3 )
            // InternalSensinact.g:3944:2: rule__DSL_CEP_SUM__Group__2__Impl rule__DSL_CEP_SUM__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_SUM__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_SUM__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__2"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__2__Impl"
    // InternalSensinact.g:3951:1: rule__DSL_CEP_SUM__Group__2__Impl : ( ( rule__DSL_CEP_SUM__RefAssignment_2 ) ) ;
    public final void rule__DSL_CEP_SUM__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3955:1: ( ( ( rule__DSL_CEP_SUM__RefAssignment_2 ) ) )
            // InternalSensinact.g:3956:1: ( ( rule__DSL_CEP_SUM__RefAssignment_2 ) )
            {
            // InternalSensinact.g:3956:1: ( ( rule__DSL_CEP_SUM__RefAssignment_2 ) )
            // InternalSensinact.g:3957:2: ( rule__DSL_CEP_SUM__RefAssignment_2 )
            {
             before(grammarAccess.getDSL_CEP_SUMAccess().getRefAssignment_2()); 
            // InternalSensinact.g:3958:2: ( rule__DSL_CEP_SUM__RefAssignment_2 )
            // InternalSensinact.g:3958:3: rule__DSL_CEP_SUM__RefAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_SUM__RefAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_SUMAccess().getRefAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__2__Impl"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__3"
    // InternalSensinact.g:3966:1: rule__DSL_CEP_SUM__Group__3 : rule__DSL_CEP_SUM__Group__3__Impl rule__DSL_CEP_SUM__Group__4 ;
    public final void rule__DSL_CEP_SUM__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3970:1: ( rule__DSL_CEP_SUM__Group__3__Impl rule__DSL_CEP_SUM__Group__4 )
            // InternalSensinact.g:3971:2: rule__DSL_CEP_SUM__Group__3__Impl rule__DSL_CEP_SUM__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_SUM__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_SUM__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__3"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__3__Impl"
    // InternalSensinact.g:3978:1: rule__DSL_CEP_SUM__Group__3__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_SUM__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3982:1: ( ( ',' ) )
            // InternalSensinact.g:3983:1: ( ',' )
            {
            // InternalSensinact.g:3983:1: ( ',' )
            // InternalSensinact.g:3984:2: ','
            {
             before(grammarAccess.getDSL_CEP_SUMAccess().getCommaKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_SUMAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__3__Impl"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__4"
    // InternalSensinact.g:3993:1: rule__DSL_CEP_SUM__Group__4 : rule__DSL_CEP_SUM__Group__4__Impl rule__DSL_CEP_SUM__Group__5 ;
    public final void rule__DSL_CEP_SUM__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:3997:1: ( rule__DSL_CEP_SUM__Group__4__Impl rule__DSL_CEP_SUM__Group__5 )
            // InternalSensinact.g:3998:2: rule__DSL_CEP_SUM__Group__4__Impl rule__DSL_CEP_SUM__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__DSL_CEP_SUM__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_SUM__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__4"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__4__Impl"
    // InternalSensinact.g:4005:1: rule__DSL_CEP_SUM__Group__4__Impl : ( ( rule__DSL_CEP_SUM__WindowAssignment_4 ) ) ;
    public final void rule__DSL_CEP_SUM__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4009:1: ( ( ( rule__DSL_CEP_SUM__WindowAssignment_4 ) ) )
            // InternalSensinact.g:4010:1: ( ( rule__DSL_CEP_SUM__WindowAssignment_4 ) )
            {
            // InternalSensinact.g:4010:1: ( ( rule__DSL_CEP_SUM__WindowAssignment_4 ) )
            // InternalSensinact.g:4011:2: ( rule__DSL_CEP_SUM__WindowAssignment_4 )
            {
             before(grammarAccess.getDSL_CEP_SUMAccess().getWindowAssignment_4()); 
            // InternalSensinact.g:4012:2: ( rule__DSL_CEP_SUM__WindowAssignment_4 )
            // InternalSensinact.g:4012:3: rule__DSL_CEP_SUM__WindowAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_SUM__WindowAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_SUMAccess().getWindowAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__4__Impl"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__5"
    // InternalSensinact.g:4020:1: rule__DSL_CEP_SUM__Group__5 : rule__DSL_CEP_SUM__Group__5__Impl ;
    public final void rule__DSL_CEP_SUM__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4024:1: ( rule__DSL_CEP_SUM__Group__5__Impl )
            // InternalSensinact.g:4025:2: rule__DSL_CEP_SUM__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_SUM__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__5"


    // $ANTLR start "rule__DSL_CEP_SUM__Group__5__Impl"
    // InternalSensinact.g:4031:1: rule__DSL_CEP_SUM__Group__5__Impl : ( ')' ) ;
    public final void rule__DSL_CEP_SUM__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4035:1: ( ( ')' ) )
            // InternalSensinact.g:4036:1: ( ')' )
            {
            // InternalSensinact.g:4036:1: ( ')' )
            // InternalSensinact.g:4037:2: ')'
            {
             before(grammarAccess.getDSL_CEP_SUMAccess().getRightParenthesisKeyword_5()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_SUMAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__Group__5__Impl"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__0"
    // InternalSensinact.g:4047:1: rule__DSL_CEP_COUNT__Group__0 : rule__DSL_CEP_COUNT__Group__0__Impl rule__DSL_CEP_COUNT__Group__1 ;
    public final void rule__DSL_CEP_COUNT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4051:1: ( rule__DSL_CEP_COUNT__Group__0__Impl rule__DSL_CEP_COUNT__Group__1 )
            // InternalSensinact.g:4052:2: rule__DSL_CEP_COUNT__Group__0__Impl rule__DSL_CEP_COUNT__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__DSL_CEP_COUNT__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COUNT__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__0"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__0__Impl"
    // InternalSensinact.g:4059:1: rule__DSL_CEP_COUNT__Group__0__Impl : ( 'count' ) ;
    public final void rule__DSL_CEP_COUNT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4063:1: ( ( 'count' ) )
            // InternalSensinact.g:4064:1: ( 'count' )
            {
            // InternalSensinact.g:4064:1: ( 'count' )
            // InternalSensinact.g:4065:2: 'count'
            {
             before(grammarAccess.getDSL_CEP_COUNTAccess().getCountKeyword_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_COUNTAccess().getCountKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__1"
    // InternalSensinact.g:4074:1: rule__DSL_CEP_COUNT__Group__1 : rule__DSL_CEP_COUNT__Group__1__Impl rule__DSL_CEP_COUNT__Group__2 ;
    public final void rule__DSL_CEP_COUNT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4078:1: ( rule__DSL_CEP_COUNT__Group__1__Impl rule__DSL_CEP_COUNT__Group__2 )
            // InternalSensinact.g:4079:2: rule__DSL_CEP_COUNT__Group__1__Impl rule__DSL_CEP_COUNT__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__DSL_CEP_COUNT__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COUNT__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__1"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__1__Impl"
    // InternalSensinact.g:4086:1: rule__DSL_CEP_COUNT__Group__1__Impl : ( '(' ) ;
    public final void rule__DSL_CEP_COUNT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4090:1: ( ( '(' ) )
            // InternalSensinact.g:4091:1: ( '(' )
            {
            // InternalSensinact.g:4091:1: ( '(' )
            // InternalSensinact.g:4092:2: '('
            {
             before(grammarAccess.getDSL_CEP_COUNTAccess().getLeftParenthesisKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_COUNTAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__2"
    // InternalSensinact.g:4101:1: rule__DSL_CEP_COUNT__Group__2 : rule__DSL_CEP_COUNT__Group__2__Impl rule__DSL_CEP_COUNT__Group__3 ;
    public final void rule__DSL_CEP_COUNT__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4105:1: ( rule__DSL_CEP_COUNT__Group__2__Impl rule__DSL_CEP_COUNT__Group__3 )
            // InternalSensinact.g:4106:2: rule__DSL_CEP_COUNT__Group__2__Impl rule__DSL_CEP_COUNT__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__DSL_CEP_COUNT__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COUNT__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__2"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__2__Impl"
    // InternalSensinact.g:4113:1: rule__DSL_CEP_COUNT__Group__2__Impl : ( ( rule__DSL_CEP_COUNT__RefAssignment_2 ) ) ;
    public final void rule__DSL_CEP_COUNT__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4117:1: ( ( ( rule__DSL_CEP_COUNT__RefAssignment_2 ) ) )
            // InternalSensinact.g:4118:1: ( ( rule__DSL_CEP_COUNT__RefAssignment_2 ) )
            {
            // InternalSensinact.g:4118:1: ( ( rule__DSL_CEP_COUNT__RefAssignment_2 ) )
            // InternalSensinact.g:4119:2: ( rule__DSL_CEP_COUNT__RefAssignment_2 )
            {
             before(grammarAccess.getDSL_CEP_COUNTAccess().getRefAssignment_2()); 
            // InternalSensinact.g:4120:2: ( rule__DSL_CEP_COUNT__RefAssignment_2 )
            // InternalSensinact.g:4120:3: rule__DSL_CEP_COUNT__RefAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COUNT__RefAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_COUNTAccess().getRefAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__2__Impl"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__3"
    // InternalSensinact.g:4128:1: rule__DSL_CEP_COUNT__Group__3 : rule__DSL_CEP_COUNT__Group__3__Impl rule__DSL_CEP_COUNT__Group__4 ;
    public final void rule__DSL_CEP_COUNT__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4132:1: ( rule__DSL_CEP_COUNT__Group__3__Impl rule__DSL_CEP_COUNT__Group__4 )
            // InternalSensinact.g:4133:2: rule__DSL_CEP_COUNT__Group__3__Impl rule__DSL_CEP_COUNT__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__DSL_CEP_COUNT__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COUNT__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__3"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__3__Impl"
    // InternalSensinact.g:4140:1: rule__DSL_CEP_COUNT__Group__3__Impl : ( ',' ) ;
    public final void rule__DSL_CEP_COUNT__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4144:1: ( ( ',' ) )
            // InternalSensinact.g:4145:1: ( ',' )
            {
            // InternalSensinact.g:4145:1: ( ',' )
            // InternalSensinact.g:4146:2: ','
            {
             before(grammarAccess.getDSL_CEP_COUNTAccess().getCommaKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_COUNTAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__3__Impl"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__4"
    // InternalSensinact.g:4155:1: rule__DSL_CEP_COUNT__Group__4 : rule__DSL_CEP_COUNT__Group__4__Impl rule__DSL_CEP_COUNT__Group__5 ;
    public final void rule__DSL_CEP_COUNT__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4159:1: ( rule__DSL_CEP_COUNT__Group__4__Impl rule__DSL_CEP_COUNT__Group__5 )
            // InternalSensinact.g:4160:2: rule__DSL_CEP_COUNT__Group__4__Impl rule__DSL_CEP_COUNT__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__DSL_CEP_COUNT__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COUNT__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__4"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__4__Impl"
    // InternalSensinact.g:4167:1: rule__DSL_CEP_COUNT__Group__4__Impl : ( ( rule__DSL_CEP_COUNT__WindowAssignment_4 ) ) ;
    public final void rule__DSL_CEP_COUNT__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4171:1: ( ( ( rule__DSL_CEP_COUNT__WindowAssignment_4 ) ) )
            // InternalSensinact.g:4172:1: ( ( rule__DSL_CEP_COUNT__WindowAssignment_4 ) )
            {
            // InternalSensinact.g:4172:1: ( ( rule__DSL_CEP_COUNT__WindowAssignment_4 ) )
            // InternalSensinact.g:4173:2: ( rule__DSL_CEP_COUNT__WindowAssignment_4 )
            {
             before(grammarAccess.getDSL_CEP_COUNTAccess().getWindowAssignment_4()); 
            // InternalSensinact.g:4174:2: ( rule__DSL_CEP_COUNT__WindowAssignment_4 )
            // InternalSensinact.g:4174:3: rule__DSL_CEP_COUNT__WindowAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COUNT__WindowAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_COUNTAccess().getWindowAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__4__Impl"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__5"
    // InternalSensinact.g:4182:1: rule__DSL_CEP_COUNT__Group__5 : rule__DSL_CEP_COUNT__Group__5__Impl ;
    public final void rule__DSL_CEP_COUNT__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4186:1: ( rule__DSL_CEP_COUNT__Group__5__Impl )
            // InternalSensinact.g:4187:2: rule__DSL_CEP_COUNT__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_COUNT__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__5"


    // $ANTLR start "rule__DSL_CEP_COUNT__Group__5__Impl"
    // InternalSensinact.g:4193:1: rule__DSL_CEP_COUNT__Group__5__Impl : ( ')' ) ;
    public final void rule__DSL_CEP_COUNT__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4197:1: ( ( ')' ) )
            // InternalSensinact.g:4198:1: ( ')' )
            {
            // InternalSensinact.g:4198:1: ( ')' )
            // InternalSensinact.g:4199:2: ')'
            {
             before(grammarAccess.getDSL_CEP_COUNTAccess().getRightParenthesisKeyword_5()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_COUNTAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__Group__5__Impl"


    // $ANTLR start "rule__DSL_CEP_DURATION_MIN__Group__0"
    // InternalSensinact.g:4209:1: rule__DSL_CEP_DURATION_MIN__Group__0 : rule__DSL_CEP_DURATION_MIN__Group__0__Impl rule__DSL_CEP_DURATION_MIN__Group__1 ;
    public final void rule__DSL_CEP_DURATION_MIN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4213:1: ( rule__DSL_CEP_DURATION_MIN__Group__0__Impl rule__DSL_CEP_DURATION_MIN__Group__1 )
            // InternalSensinact.g:4214:2: rule__DSL_CEP_DURATION_MIN__Group__0__Impl rule__DSL_CEP_DURATION_MIN__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__DSL_CEP_DURATION_MIN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_DURATION_MIN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_MIN__Group__0"


    // $ANTLR start "rule__DSL_CEP_DURATION_MIN__Group__0__Impl"
    // InternalSensinact.g:4221:1: rule__DSL_CEP_DURATION_MIN__Group__0__Impl : ( ( rule__DSL_CEP_DURATION_MIN__MinAssignment_0 ) ) ;
    public final void rule__DSL_CEP_DURATION_MIN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4225:1: ( ( ( rule__DSL_CEP_DURATION_MIN__MinAssignment_0 ) ) )
            // InternalSensinact.g:4226:1: ( ( rule__DSL_CEP_DURATION_MIN__MinAssignment_0 ) )
            {
            // InternalSensinact.g:4226:1: ( ( rule__DSL_CEP_DURATION_MIN__MinAssignment_0 ) )
            // InternalSensinact.g:4227:2: ( rule__DSL_CEP_DURATION_MIN__MinAssignment_0 )
            {
             before(grammarAccess.getDSL_CEP_DURATION_MINAccess().getMinAssignment_0()); 
            // InternalSensinact.g:4228:2: ( rule__DSL_CEP_DURATION_MIN__MinAssignment_0 )
            // InternalSensinact.g:4228:3: rule__DSL_CEP_DURATION_MIN__MinAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_DURATION_MIN__MinAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_DURATION_MINAccess().getMinAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_MIN__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_DURATION_MIN__Group__1"
    // InternalSensinact.g:4236:1: rule__DSL_CEP_DURATION_MIN__Group__1 : rule__DSL_CEP_DURATION_MIN__Group__1__Impl ;
    public final void rule__DSL_CEP_DURATION_MIN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4240:1: ( rule__DSL_CEP_DURATION_MIN__Group__1__Impl )
            // InternalSensinact.g:4241:2: rule__DSL_CEP_DURATION_MIN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_DURATION_MIN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_MIN__Group__1"


    // $ANTLR start "rule__DSL_CEP_DURATION_MIN__Group__1__Impl"
    // InternalSensinact.g:4247:1: rule__DSL_CEP_DURATION_MIN__Group__1__Impl : ( 'min' ) ;
    public final void rule__DSL_CEP_DURATION_MIN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4251:1: ( ( 'min' ) )
            // InternalSensinact.g:4252:1: ( 'min' )
            {
            // InternalSensinact.g:4252:1: ( 'min' )
            // InternalSensinact.g:4253:2: 'min'
            {
             before(grammarAccess.getDSL_CEP_DURATION_MINAccess().getMinKeyword_1()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_DURATION_MINAccess().getMinKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_MIN__Group__1__Impl"


    // $ANTLR start "rule__DSL_CEP_DURATION_SEC__Group__0"
    // InternalSensinact.g:4263:1: rule__DSL_CEP_DURATION_SEC__Group__0 : rule__DSL_CEP_DURATION_SEC__Group__0__Impl rule__DSL_CEP_DURATION_SEC__Group__1 ;
    public final void rule__DSL_CEP_DURATION_SEC__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4267:1: ( rule__DSL_CEP_DURATION_SEC__Group__0__Impl rule__DSL_CEP_DURATION_SEC__Group__1 )
            // InternalSensinact.g:4268:2: rule__DSL_CEP_DURATION_SEC__Group__0__Impl rule__DSL_CEP_DURATION_SEC__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__DSL_CEP_DURATION_SEC__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_CEP_DURATION_SEC__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_SEC__Group__0"


    // $ANTLR start "rule__DSL_CEP_DURATION_SEC__Group__0__Impl"
    // InternalSensinact.g:4275:1: rule__DSL_CEP_DURATION_SEC__Group__0__Impl : ( ( rule__DSL_CEP_DURATION_SEC__SecAssignment_0 ) ) ;
    public final void rule__DSL_CEP_DURATION_SEC__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4279:1: ( ( ( rule__DSL_CEP_DURATION_SEC__SecAssignment_0 ) ) )
            // InternalSensinact.g:4280:1: ( ( rule__DSL_CEP_DURATION_SEC__SecAssignment_0 ) )
            {
            // InternalSensinact.g:4280:1: ( ( rule__DSL_CEP_DURATION_SEC__SecAssignment_0 ) )
            // InternalSensinact.g:4281:2: ( rule__DSL_CEP_DURATION_SEC__SecAssignment_0 )
            {
             before(grammarAccess.getDSL_CEP_DURATION_SECAccess().getSecAssignment_0()); 
            // InternalSensinact.g:4282:2: ( rule__DSL_CEP_DURATION_SEC__SecAssignment_0 )
            // InternalSensinact.g:4282:3: rule__DSL_CEP_DURATION_SEC__SecAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_DURATION_SEC__SecAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_DURATION_SECAccess().getSecAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_SEC__Group__0__Impl"


    // $ANTLR start "rule__DSL_CEP_DURATION_SEC__Group__1"
    // InternalSensinact.g:4290:1: rule__DSL_CEP_DURATION_SEC__Group__1 : rule__DSL_CEP_DURATION_SEC__Group__1__Impl ;
    public final void rule__DSL_CEP_DURATION_SEC__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4294:1: ( rule__DSL_CEP_DURATION_SEC__Group__1__Impl )
            // InternalSensinact.g:4295:2: rule__DSL_CEP_DURATION_SEC__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_DURATION_SEC__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_SEC__Group__1"


    // $ANTLR start "rule__DSL_CEP_DURATION_SEC__Group__1__Impl"
    // InternalSensinact.g:4301:1: rule__DSL_CEP_DURATION_SEC__Group__1__Impl : ( 'sec' ) ;
    public final void rule__DSL_CEP_DURATION_SEC__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4305:1: ( ( 'sec' ) )
            // InternalSensinact.g:4306:1: ( 'sec' )
            {
            // InternalSensinact.g:4306:1: ( 'sec' )
            // InternalSensinact.g:4307:2: 'sec'
            {
             before(grammarAccess.getDSL_CEP_DURATION_SECAccess().getSecKeyword_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_DURATION_SECAccess().getSecKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_SEC__Group__1__Impl"


    // $ANTLR start "rule__DSL_ListActions__Group__0"
    // InternalSensinact.g:4317:1: rule__DSL_ListActions__Group__0 : rule__DSL_ListActions__Group__0__Impl rule__DSL_ListActions__Group__1 ;
    public final void rule__DSL_ListActions__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4321:1: ( rule__DSL_ListActions__Group__0__Impl rule__DSL_ListActions__Group__1 )
            // InternalSensinact.g:4322:2: rule__DSL_ListActions__Group__0__Impl rule__DSL_ListActions__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__DSL_ListActions__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ListActions__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__Group__0"


    // $ANTLR start "rule__DSL_ListActions__Group__0__Impl"
    // InternalSensinact.g:4329:1: rule__DSL_ListActions__Group__0__Impl : ( ( rule__DSL_ListActions__ActionListAssignment_0 ) ) ;
    public final void rule__DSL_ListActions__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4333:1: ( ( ( rule__DSL_ListActions__ActionListAssignment_0 ) ) )
            // InternalSensinact.g:4334:1: ( ( rule__DSL_ListActions__ActionListAssignment_0 ) )
            {
            // InternalSensinact.g:4334:1: ( ( rule__DSL_ListActions__ActionListAssignment_0 ) )
            // InternalSensinact.g:4335:2: ( rule__DSL_ListActions__ActionListAssignment_0 )
            {
             before(grammarAccess.getDSL_ListActionsAccess().getActionListAssignment_0()); 
            // InternalSensinact.g:4336:2: ( rule__DSL_ListActions__ActionListAssignment_0 )
            // InternalSensinact.g:4336:3: rule__DSL_ListActions__ActionListAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListActions__ActionListAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ListActionsAccess().getActionListAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__Group__0__Impl"


    // $ANTLR start "rule__DSL_ListActions__Group__1"
    // InternalSensinact.g:4344:1: rule__DSL_ListActions__Group__1 : rule__DSL_ListActions__Group__1__Impl ;
    public final void rule__DSL_ListActions__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4348:1: ( rule__DSL_ListActions__Group__1__Impl )
            // InternalSensinact.g:4349:2: rule__DSL_ListActions__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListActions__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__Group__1"


    // $ANTLR start "rule__DSL_ListActions__Group__1__Impl"
    // InternalSensinact.g:4355:1: rule__DSL_ListActions__Group__1__Impl : ( ( rule__DSL_ListActions__Group_1__0 )* ) ;
    public final void rule__DSL_ListActions__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4359:1: ( ( ( rule__DSL_ListActions__Group_1__0 )* ) )
            // InternalSensinact.g:4360:1: ( ( rule__DSL_ListActions__Group_1__0 )* )
            {
            // InternalSensinact.g:4360:1: ( ( rule__DSL_ListActions__Group_1__0 )* )
            // InternalSensinact.g:4361:2: ( rule__DSL_ListActions__Group_1__0 )*
            {
             before(grammarAccess.getDSL_ListActionsAccess().getGroup_1()); 
            // InternalSensinact.g:4362:2: ( rule__DSL_ListActions__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==20) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSensinact.g:4362:3: rule__DSL_ListActions__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__DSL_ListActions__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getDSL_ListActionsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__Group__1__Impl"


    // $ANTLR start "rule__DSL_ListActions__Group_1__0"
    // InternalSensinact.g:4371:1: rule__DSL_ListActions__Group_1__0 : rule__DSL_ListActions__Group_1__0__Impl rule__DSL_ListActions__Group_1__1 ;
    public final void rule__DSL_ListActions__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4375:1: ( rule__DSL_ListActions__Group_1__0__Impl rule__DSL_ListActions__Group_1__1 )
            // InternalSensinact.g:4376:2: rule__DSL_ListActions__Group_1__0__Impl rule__DSL_ListActions__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__DSL_ListActions__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ListActions__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__Group_1__0"


    // $ANTLR start "rule__DSL_ListActions__Group_1__0__Impl"
    // InternalSensinact.g:4383:1: rule__DSL_ListActions__Group_1__0__Impl : ( ',' ) ;
    public final void rule__DSL_ListActions__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4387:1: ( ( ',' ) )
            // InternalSensinact.g:4388:1: ( ',' )
            {
            // InternalSensinact.g:4388:1: ( ',' )
            // InternalSensinact.g:4389:2: ','
            {
             before(grammarAccess.getDSL_ListActionsAccess().getCommaKeyword_1_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_ListActionsAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__Group_1__0__Impl"


    // $ANTLR start "rule__DSL_ListActions__Group_1__1"
    // InternalSensinact.g:4398:1: rule__DSL_ListActions__Group_1__1 : rule__DSL_ListActions__Group_1__1__Impl ;
    public final void rule__DSL_ListActions__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4402:1: ( rule__DSL_ListActions__Group_1__1__Impl )
            // InternalSensinact.g:4403:2: rule__DSL_ListActions__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListActions__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__Group_1__1"


    // $ANTLR start "rule__DSL_ListActions__Group_1__1__Impl"
    // InternalSensinact.g:4409:1: rule__DSL_ListActions__Group_1__1__Impl : ( ( rule__DSL_ListActions__ActionListAssignment_1_1 ) ) ;
    public final void rule__DSL_ListActions__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4413:1: ( ( ( rule__DSL_ListActions__ActionListAssignment_1_1 ) ) )
            // InternalSensinact.g:4414:1: ( ( rule__DSL_ListActions__ActionListAssignment_1_1 ) )
            {
            // InternalSensinact.g:4414:1: ( ( rule__DSL_ListActions__ActionListAssignment_1_1 ) )
            // InternalSensinact.g:4415:2: ( rule__DSL_ListActions__ActionListAssignment_1_1 )
            {
             before(grammarAccess.getDSL_ListActionsAccess().getActionListAssignment_1_1()); 
            // InternalSensinact.g:4416:2: ( rule__DSL_ListActions__ActionListAssignment_1_1 )
            // InternalSensinact.g:4416:3: rule__DSL_ListActions__ActionListAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListActions__ActionListAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ListActionsAccess().getActionListAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__Group_1__1__Impl"


    // $ANTLR start "rule__DSL_ResourceAction__Group__0"
    // InternalSensinact.g:4425:1: rule__DSL_ResourceAction__Group__0 : rule__DSL_ResourceAction__Group__0__Impl rule__DSL_ResourceAction__Group__1 ;
    public final void rule__DSL_ResourceAction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4429:1: ( rule__DSL_ResourceAction__Group__0__Impl rule__DSL_ResourceAction__Group__1 )
            // InternalSensinact.g:4430:2: rule__DSL_ResourceAction__Group__0__Impl rule__DSL_ResourceAction__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__DSL_ResourceAction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__0"


    // $ANTLR start "rule__DSL_ResourceAction__Group__0__Impl"
    // InternalSensinact.g:4437:1: rule__DSL_ResourceAction__Group__0__Impl : ( ( rule__DSL_ResourceAction__Group_0__0 )? ) ;
    public final void rule__DSL_ResourceAction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4441:1: ( ( ( rule__DSL_ResourceAction__Group_0__0 )? ) )
            // InternalSensinact.g:4442:1: ( ( rule__DSL_ResourceAction__Group_0__0 )? )
            {
            // InternalSensinact.g:4442:1: ( ( rule__DSL_ResourceAction__Group_0__0 )? )
            // InternalSensinact.g:4443:2: ( rule__DSL_ResourceAction__Group_0__0 )?
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getGroup_0()); 
            // InternalSensinact.g:4444:2: ( rule__DSL_ResourceAction__Group_0__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==15) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // InternalSensinact.g:4444:3: rule__DSL_ResourceAction__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_ResourceAction__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDSL_ResourceActionAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__0__Impl"


    // $ANTLR start "rule__DSL_ResourceAction__Group__1"
    // InternalSensinact.g:4452:1: rule__DSL_ResourceAction__Group__1 : rule__DSL_ResourceAction__Group__1__Impl rule__DSL_ResourceAction__Group__2 ;
    public final void rule__DSL_ResourceAction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4456:1: ( rule__DSL_ResourceAction__Group__1__Impl rule__DSL_ResourceAction__Group__2 )
            // InternalSensinact.g:4457:2: rule__DSL_ResourceAction__Group__1__Impl rule__DSL_ResourceAction__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__DSL_ResourceAction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__1"


    // $ANTLR start "rule__DSL_ResourceAction__Group__1__Impl"
    // InternalSensinact.g:4464:1: rule__DSL_ResourceAction__Group__1__Impl : ( ( rule__DSL_ResourceAction__RefAssignment_1 ) ) ;
    public final void rule__DSL_ResourceAction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4468:1: ( ( ( rule__DSL_ResourceAction__RefAssignment_1 ) ) )
            // InternalSensinact.g:4469:1: ( ( rule__DSL_ResourceAction__RefAssignment_1 ) )
            {
            // InternalSensinact.g:4469:1: ( ( rule__DSL_ResourceAction__RefAssignment_1 ) )
            // InternalSensinact.g:4470:2: ( rule__DSL_ResourceAction__RefAssignment_1 )
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getRefAssignment_1()); 
            // InternalSensinact.g:4471:2: ( rule__DSL_ResourceAction__RefAssignment_1 )
            // InternalSensinact.g:4471:3: rule__DSL_ResourceAction__RefAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__RefAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceActionAccess().getRefAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__1__Impl"


    // $ANTLR start "rule__DSL_ResourceAction__Group__2"
    // InternalSensinact.g:4479:1: rule__DSL_ResourceAction__Group__2 : rule__DSL_ResourceAction__Group__2__Impl rule__DSL_ResourceAction__Group__3 ;
    public final void rule__DSL_ResourceAction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4483:1: ( rule__DSL_ResourceAction__Group__2__Impl rule__DSL_ResourceAction__Group__3 )
            // InternalSensinact.g:4484:2: rule__DSL_ResourceAction__Group__2__Impl rule__DSL_ResourceAction__Group__3
            {
            pushFollow(FOLLOW_29);
            rule__DSL_ResourceAction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__2"


    // $ANTLR start "rule__DSL_ResourceAction__Group__2__Impl"
    // InternalSensinact.g:4491:1: rule__DSL_ResourceAction__Group__2__Impl : ( '.' ) ;
    public final void rule__DSL_ResourceAction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4495:1: ( ( '.' ) )
            // InternalSensinact.g:4496:1: ( '.' )
            {
            // InternalSensinact.g:4496:1: ( '.' )
            // InternalSensinact.g:4497:2: '.'
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getFullStopKeyword_2()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceActionAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__2__Impl"


    // $ANTLR start "rule__DSL_ResourceAction__Group__3"
    // InternalSensinact.g:4506:1: rule__DSL_ResourceAction__Group__3 : rule__DSL_ResourceAction__Group__3__Impl rule__DSL_ResourceAction__Group__4 ;
    public final void rule__DSL_ResourceAction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4510:1: ( rule__DSL_ResourceAction__Group__3__Impl rule__DSL_ResourceAction__Group__4 )
            // InternalSensinact.g:4511:2: rule__DSL_ResourceAction__Group__3__Impl rule__DSL_ResourceAction__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__DSL_ResourceAction__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__3"


    // $ANTLR start "rule__DSL_ResourceAction__Group__3__Impl"
    // InternalSensinact.g:4518:1: rule__DSL_ResourceAction__Group__3__Impl : ( ( rule__DSL_ResourceAction__ActiontypeAssignment_3 ) ) ;
    public final void rule__DSL_ResourceAction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4522:1: ( ( ( rule__DSL_ResourceAction__ActiontypeAssignment_3 ) ) )
            // InternalSensinact.g:4523:1: ( ( rule__DSL_ResourceAction__ActiontypeAssignment_3 ) )
            {
            // InternalSensinact.g:4523:1: ( ( rule__DSL_ResourceAction__ActiontypeAssignment_3 ) )
            // InternalSensinact.g:4524:2: ( rule__DSL_ResourceAction__ActiontypeAssignment_3 )
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getActiontypeAssignment_3()); 
            // InternalSensinact.g:4525:2: ( rule__DSL_ResourceAction__ActiontypeAssignment_3 )
            // InternalSensinact.g:4525:3: rule__DSL_ResourceAction__ActiontypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__ActiontypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceActionAccess().getActiontypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__3__Impl"


    // $ANTLR start "rule__DSL_ResourceAction__Group__4"
    // InternalSensinact.g:4533:1: rule__DSL_ResourceAction__Group__4 : rule__DSL_ResourceAction__Group__4__Impl rule__DSL_ResourceAction__Group__5 ;
    public final void rule__DSL_ResourceAction__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4537:1: ( rule__DSL_ResourceAction__Group__4__Impl rule__DSL_ResourceAction__Group__5 )
            // InternalSensinact.g:4538:2: rule__DSL_ResourceAction__Group__4__Impl rule__DSL_ResourceAction__Group__5
            {
            pushFollow(FOLLOW_30);
            rule__DSL_ResourceAction__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__4"


    // $ANTLR start "rule__DSL_ResourceAction__Group__4__Impl"
    // InternalSensinact.g:4545:1: rule__DSL_ResourceAction__Group__4__Impl : ( '(' ) ;
    public final void rule__DSL_ResourceAction__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4549:1: ( ( '(' ) )
            // InternalSensinact.g:4550:1: ( '(' )
            {
            // InternalSensinact.g:4550:1: ( '(' )
            // InternalSensinact.g:4551:2: '('
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getLeftParenthesisKeyword_4()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceActionAccess().getLeftParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__4__Impl"


    // $ANTLR start "rule__DSL_ResourceAction__Group__5"
    // InternalSensinact.g:4560:1: rule__DSL_ResourceAction__Group__5 : rule__DSL_ResourceAction__Group__5__Impl rule__DSL_ResourceAction__Group__6 ;
    public final void rule__DSL_ResourceAction__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4564:1: ( rule__DSL_ResourceAction__Group__5__Impl rule__DSL_ResourceAction__Group__6 )
            // InternalSensinact.g:4565:2: rule__DSL_ResourceAction__Group__5__Impl rule__DSL_ResourceAction__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__DSL_ResourceAction__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__5"


    // $ANTLR start "rule__DSL_ResourceAction__Group__5__Impl"
    // InternalSensinact.g:4572:1: rule__DSL_ResourceAction__Group__5__Impl : ( ( rule__DSL_ResourceAction__ListParamAssignment_5 )? ) ;
    public final void rule__DSL_ResourceAction__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4576:1: ( ( ( rule__DSL_ResourceAction__ListParamAssignment_5 )? ) )
            // InternalSensinact.g:4577:1: ( ( rule__DSL_ResourceAction__ListParamAssignment_5 )? )
            {
            // InternalSensinact.g:4577:1: ( ( rule__DSL_ResourceAction__ListParamAssignment_5 )? )
            // InternalSensinact.g:4578:2: ( rule__DSL_ResourceAction__ListParamAssignment_5 )?
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getListParamAssignment_5()); 
            // InternalSensinact.g:4579:2: ( rule__DSL_ResourceAction__ListParamAssignment_5 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_INT && LA21_0<=RULE_BOOLEAN)||LA21_0==28||LA21_0==53) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalSensinact.g:4579:3: rule__DSL_ResourceAction__ListParamAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__DSL_ResourceAction__ListParamAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDSL_ResourceActionAccess().getListParamAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__5__Impl"


    // $ANTLR start "rule__DSL_ResourceAction__Group__6"
    // InternalSensinact.g:4587:1: rule__DSL_ResourceAction__Group__6 : rule__DSL_ResourceAction__Group__6__Impl ;
    public final void rule__DSL_ResourceAction__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4591:1: ( rule__DSL_ResourceAction__Group__6__Impl )
            // InternalSensinact.g:4592:2: rule__DSL_ResourceAction__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__6"


    // $ANTLR start "rule__DSL_ResourceAction__Group__6__Impl"
    // InternalSensinact.g:4598:1: rule__DSL_ResourceAction__Group__6__Impl : ( ')' ) ;
    public final void rule__DSL_ResourceAction__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4602:1: ( ( ')' ) )
            // InternalSensinact.g:4603:1: ( ')' )
            {
            // InternalSensinact.g:4603:1: ( ')' )
            // InternalSensinact.g:4604:2: ')'
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getRightParenthesisKeyword_6()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceActionAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group__6__Impl"


    // $ANTLR start "rule__DSL_ResourceAction__Group_0__0"
    // InternalSensinact.g:4614:1: rule__DSL_ResourceAction__Group_0__0 : rule__DSL_ResourceAction__Group_0__0__Impl rule__DSL_ResourceAction__Group_0__1 ;
    public final void rule__DSL_ResourceAction__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4618:1: ( rule__DSL_ResourceAction__Group_0__0__Impl rule__DSL_ResourceAction__Group_0__1 )
            // InternalSensinact.g:4619:2: rule__DSL_ResourceAction__Group_0__0__Impl rule__DSL_ResourceAction__Group_0__1
            {
            pushFollow(FOLLOW_10);
            rule__DSL_ResourceAction__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group_0__0"


    // $ANTLR start "rule__DSL_ResourceAction__Group_0__0__Impl"
    // InternalSensinact.g:4626:1: rule__DSL_ResourceAction__Group_0__0__Impl : ( ( rule__DSL_ResourceAction__VariableAssignment_0_0 ) ) ;
    public final void rule__DSL_ResourceAction__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4630:1: ( ( ( rule__DSL_ResourceAction__VariableAssignment_0_0 ) ) )
            // InternalSensinact.g:4631:1: ( ( rule__DSL_ResourceAction__VariableAssignment_0_0 ) )
            {
            // InternalSensinact.g:4631:1: ( ( rule__DSL_ResourceAction__VariableAssignment_0_0 ) )
            // InternalSensinact.g:4632:2: ( rule__DSL_ResourceAction__VariableAssignment_0_0 )
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getVariableAssignment_0_0()); 
            // InternalSensinact.g:4633:2: ( rule__DSL_ResourceAction__VariableAssignment_0_0 )
            // InternalSensinact.g:4633:3: rule__DSL_ResourceAction__VariableAssignment_0_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__VariableAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceActionAccess().getVariableAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group_0__0__Impl"


    // $ANTLR start "rule__DSL_ResourceAction__Group_0__1"
    // InternalSensinact.g:4641:1: rule__DSL_ResourceAction__Group_0__1 : rule__DSL_ResourceAction__Group_0__1__Impl ;
    public final void rule__DSL_ResourceAction__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4645:1: ( rule__DSL_ResourceAction__Group_0__1__Impl )
            // InternalSensinact.g:4646:2: rule__DSL_ResourceAction__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group_0__1"


    // $ANTLR start "rule__DSL_ResourceAction__Group_0__1__Impl"
    // InternalSensinact.g:4652:1: rule__DSL_ResourceAction__Group_0__1__Impl : ( '=' ) ;
    public final void rule__DSL_ResourceAction__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4656:1: ( ( '=' ) )
            // InternalSensinact.g:4657:1: ( '=' )
            {
            // InternalSensinact.g:4657:1: ( '=' )
            // InternalSensinact.g:4658:2: '='
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getEqualsSignKeyword_0_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceActionAccess().getEqualsSignKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__Group_0__1__Impl"


    // $ANTLR start "rule__DSL_ListParam__Group__0"
    // InternalSensinact.g:4668:1: rule__DSL_ListParam__Group__0 : rule__DSL_ListParam__Group__0__Impl rule__DSL_ListParam__Group__1 ;
    public final void rule__DSL_ListParam__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4672:1: ( rule__DSL_ListParam__Group__0__Impl rule__DSL_ListParam__Group__1 )
            // InternalSensinact.g:4673:2: rule__DSL_ListParam__Group__0__Impl rule__DSL_ListParam__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__DSL_ListParam__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ListParam__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__Group__0"


    // $ANTLR start "rule__DSL_ListParam__Group__0__Impl"
    // InternalSensinact.g:4680:1: rule__DSL_ListParam__Group__0__Impl : ( ( rule__DSL_ListParam__ParamAssignment_0 ) ) ;
    public final void rule__DSL_ListParam__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4684:1: ( ( ( rule__DSL_ListParam__ParamAssignment_0 ) ) )
            // InternalSensinact.g:4685:1: ( ( rule__DSL_ListParam__ParamAssignment_0 ) )
            {
            // InternalSensinact.g:4685:1: ( ( rule__DSL_ListParam__ParamAssignment_0 ) )
            // InternalSensinact.g:4686:2: ( rule__DSL_ListParam__ParamAssignment_0 )
            {
             before(grammarAccess.getDSL_ListParamAccess().getParamAssignment_0()); 
            // InternalSensinact.g:4687:2: ( rule__DSL_ListParam__ParamAssignment_0 )
            // InternalSensinact.g:4687:3: rule__DSL_ListParam__ParamAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListParam__ParamAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ListParamAccess().getParamAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__Group__0__Impl"


    // $ANTLR start "rule__DSL_ListParam__Group__1"
    // InternalSensinact.g:4695:1: rule__DSL_ListParam__Group__1 : rule__DSL_ListParam__Group__1__Impl ;
    public final void rule__DSL_ListParam__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4699:1: ( rule__DSL_ListParam__Group__1__Impl )
            // InternalSensinact.g:4700:2: rule__DSL_ListParam__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListParam__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__Group__1"


    // $ANTLR start "rule__DSL_ListParam__Group__1__Impl"
    // InternalSensinact.g:4706:1: rule__DSL_ListParam__Group__1__Impl : ( ( rule__DSL_ListParam__Group_1__0 )* ) ;
    public final void rule__DSL_ListParam__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4710:1: ( ( ( rule__DSL_ListParam__Group_1__0 )* ) )
            // InternalSensinact.g:4711:1: ( ( rule__DSL_ListParam__Group_1__0 )* )
            {
            // InternalSensinact.g:4711:1: ( ( rule__DSL_ListParam__Group_1__0 )* )
            // InternalSensinact.g:4712:2: ( rule__DSL_ListParam__Group_1__0 )*
            {
             before(grammarAccess.getDSL_ListParamAccess().getGroup_1()); 
            // InternalSensinact.g:4713:2: ( rule__DSL_ListParam__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==20) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalSensinact.g:4713:3: rule__DSL_ListParam__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__DSL_ListParam__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getDSL_ListParamAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__Group__1__Impl"


    // $ANTLR start "rule__DSL_ListParam__Group_1__0"
    // InternalSensinact.g:4722:1: rule__DSL_ListParam__Group_1__0 : rule__DSL_ListParam__Group_1__0__Impl rule__DSL_ListParam__Group_1__1 ;
    public final void rule__DSL_ListParam__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4726:1: ( rule__DSL_ListParam__Group_1__0__Impl rule__DSL_ListParam__Group_1__1 )
            // InternalSensinact.g:4727:2: rule__DSL_ListParam__Group_1__0__Impl rule__DSL_ListParam__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_ListParam__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_ListParam__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__Group_1__0"


    // $ANTLR start "rule__DSL_ListParam__Group_1__0__Impl"
    // InternalSensinact.g:4734:1: rule__DSL_ListParam__Group_1__0__Impl : ( ',' ) ;
    public final void rule__DSL_ListParam__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4738:1: ( ( ',' ) )
            // InternalSensinact.g:4739:1: ( ',' )
            {
            // InternalSensinact.g:4739:1: ( ',' )
            // InternalSensinact.g:4740:2: ','
            {
             before(grammarAccess.getDSL_ListParamAccess().getCommaKeyword_1_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDSL_ListParamAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__Group_1__0__Impl"


    // $ANTLR start "rule__DSL_ListParam__Group_1__1"
    // InternalSensinact.g:4749:1: rule__DSL_ListParam__Group_1__1 : rule__DSL_ListParam__Group_1__1__Impl ;
    public final void rule__DSL_ListParam__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4753:1: ( rule__DSL_ListParam__Group_1__1__Impl )
            // InternalSensinact.g:4754:2: rule__DSL_ListParam__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListParam__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__Group_1__1"


    // $ANTLR start "rule__DSL_ListParam__Group_1__1__Impl"
    // InternalSensinact.g:4760:1: rule__DSL_ListParam__Group_1__1__Impl : ( ( rule__DSL_ListParam__ParamAssignment_1_1 ) ) ;
    public final void rule__DSL_ListParam__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4764:1: ( ( ( rule__DSL_ListParam__ParamAssignment_1_1 ) ) )
            // InternalSensinact.g:4765:1: ( ( rule__DSL_ListParam__ParamAssignment_1_1 ) )
            {
            // InternalSensinact.g:4765:1: ( ( rule__DSL_ListParam__ParamAssignment_1_1 ) )
            // InternalSensinact.g:4766:2: ( rule__DSL_ListParam__ParamAssignment_1_1 )
            {
             before(grammarAccess.getDSL_ListParamAccess().getParamAssignment_1_1()); 
            // InternalSensinact.g:4767:2: ( rule__DSL_ListParam__ParamAssignment_1_1 )
            // InternalSensinact.g:4767:3: rule__DSL_ListParam__ParamAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ListParam__ParamAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ListParamAccess().getParamAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__Group_1__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Or__Group__0"
    // InternalSensinact.g:4776:1: rule__DSL_Expression_Or__Group__0 : rule__DSL_Expression_Or__Group__0__Impl rule__DSL_Expression_Or__Group__1 ;
    public final void rule__DSL_Expression_Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4780:1: ( rule__DSL_Expression_Or__Group__0__Impl rule__DSL_Expression_Or__Group__1 )
            // InternalSensinact.g:4781:2: rule__DSL_Expression_Or__Group__0__Impl rule__DSL_Expression_Or__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__DSL_Expression_Or__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Or__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group__0"


    // $ANTLR start "rule__DSL_Expression_Or__Group__0__Impl"
    // InternalSensinact.g:4788:1: rule__DSL_Expression_Or__Group__0__Impl : ( ruleDSL_Expression_And ) ;
    public final void rule__DSL_Expression_Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4792:1: ( ( ruleDSL_Expression_And ) )
            // InternalSensinact.g:4793:1: ( ruleDSL_Expression_And )
            {
            // InternalSensinact.g:4793:1: ( ruleDSL_Expression_And )
            // InternalSensinact.g:4794:2: ruleDSL_Expression_And
            {
             before(grammarAccess.getDSL_Expression_OrAccess().getDSL_Expression_AndParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_And();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_OrAccess().getDSL_Expression_AndParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Or__Group__1"
    // InternalSensinact.g:4803:1: rule__DSL_Expression_Or__Group__1 : rule__DSL_Expression_Or__Group__1__Impl ;
    public final void rule__DSL_Expression_Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4807:1: ( rule__DSL_Expression_Or__Group__1__Impl )
            // InternalSensinact.g:4808:2: rule__DSL_Expression_Or__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Or__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group__1"


    // $ANTLR start "rule__DSL_Expression_Or__Group__1__Impl"
    // InternalSensinact.g:4814:1: rule__DSL_Expression_Or__Group__1__Impl : ( ( rule__DSL_Expression_Or__Group_1__0 )* ) ;
    public final void rule__DSL_Expression_Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4818:1: ( ( ( rule__DSL_Expression_Or__Group_1__0 )* ) )
            // InternalSensinact.g:4819:1: ( ( rule__DSL_Expression_Or__Group_1__0 )* )
            {
            // InternalSensinact.g:4819:1: ( ( rule__DSL_Expression_Or__Group_1__0 )* )
            // InternalSensinact.g:4820:2: ( rule__DSL_Expression_Or__Group_1__0 )*
            {
             before(grammarAccess.getDSL_Expression_OrAccess().getGroup_1()); 
            // InternalSensinact.g:4821:2: ( rule__DSL_Expression_Or__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==40) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalSensinact.g:4821:3: rule__DSL_Expression_Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__DSL_Expression_Or__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getDSL_Expression_OrAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Or__Group_1__0"
    // InternalSensinact.g:4830:1: rule__DSL_Expression_Or__Group_1__0 : rule__DSL_Expression_Or__Group_1__0__Impl rule__DSL_Expression_Or__Group_1__1 ;
    public final void rule__DSL_Expression_Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4834:1: ( rule__DSL_Expression_Or__Group_1__0__Impl rule__DSL_Expression_Or__Group_1__1 )
            // InternalSensinact.g:4835:2: rule__DSL_Expression_Or__Group_1__0__Impl rule__DSL_Expression_Or__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Or__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Or__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group_1__0"


    // $ANTLR start "rule__DSL_Expression_Or__Group_1__0__Impl"
    // InternalSensinact.g:4842:1: rule__DSL_Expression_Or__Group_1__0__Impl : ( 'or' ) ;
    public final void rule__DSL_Expression_Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4846:1: ( ( 'or' ) )
            // InternalSensinact.g:4847:1: ( 'or' )
            {
            // InternalSensinact.g:4847:1: ( 'or' )
            // InternalSensinact.g:4848:2: 'or'
            {
             before(grammarAccess.getDSL_Expression_OrAccess().getOrKeyword_1_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_OrAccess().getOrKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group_1__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Or__Group_1__1"
    // InternalSensinact.g:4857:1: rule__DSL_Expression_Or__Group_1__1 : rule__DSL_Expression_Or__Group_1__1__Impl rule__DSL_Expression_Or__Group_1__2 ;
    public final void rule__DSL_Expression_Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4861:1: ( rule__DSL_Expression_Or__Group_1__1__Impl rule__DSL_Expression_Or__Group_1__2 )
            // InternalSensinact.g:4862:2: rule__DSL_Expression_Or__Group_1__1__Impl rule__DSL_Expression_Or__Group_1__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Or__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Or__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group_1__1"


    // $ANTLR start "rule__DSL_Expression_Or__Group_1__1__Impl"
    // InternalSensinact.g:4869:1: rule__DSL_Expression_Or__Group_1__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4873:1: ( ( () ) )
            // InternalSensinact.g:4874:1: ( () )
            {
            // InternalSensinact.g:4874:1: ( () )
            // InternalSensinact.g:4875:2: ()
            {
             before(grammarAccess.getDSL_Expression_OrAccess().getDSL_Expression_OrLeftAction_1_1()); 
            // InternalSensinact.g:4876:2: ()
            // InternalSensinact.g:4876:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_OrAccess().getDSL_Expression_OrLeftAction_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group_1__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Or__Group_1__2"
    // InternalSensinact.g:4884:1: rule__DSL_Expression_Or__Group_1__2 : rule__DSL_Expression_Or__Group_1__2__Impl ;
    public final void rule__DSL_Expression_Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4888:1: ( rule__DSL_Expression_Or__Group_1__2__Impl )
            // InternalSensinact.g:4889:2: rule__DSL_Expression_Or__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Or__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group_1__2"


    // $ANTLR start "rule__DSL_Expression_Or__Group_1__2__Impl"
    // InternalSensinact.g:4895:1: rule__DSL_Expression_Or__Group_1__2__Impl : ( ( rule__DSL_Expression_Or__RightAssignment_1_2 ) ) ;
    public final void rule__DSL_Expression_Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4899:1: ( ( ( rule__DSL_Expression_Or__RightAssignment_1_2 ) ) )
            // InternalSensinact.g:4900:1: ( ( rule__DSL_Expression_Or__RightAssignment_1_2 ) )
            {
            // InternalSensinact.g:4900:1: ( ( rule__DSL_Expression_Or__RightAssignment_1_2 ) )
            // InternalSensinact.g:4901:2: ( rule__DSL_Expression_Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getDSL_Expression_OrAccess().getRightAssignment_1_2()); 
            // InternalSensinact.g:4902:2: ( rule__DSL_Expression_Or__RightAssignment_1_2 )
            // InternalSensinact.g:4902:3: rule__DSL_Expression_Or__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Or__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_OrAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__Group_1__2__Impl"


    // $ANTLR start "rule__DSL_Expression_And__Group__0"
    // InternalSensinact.g:4911:1: rule__DSL_Expression_And__Group__0 : rule__DSL_Expression_And__Group__0__Impl rule__DSL_Expression_And__Group__1 ;
    public final void rule__DSL_Expression_And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4915:1: ( rule__DSL_Expression_And__Group__0__Impl rule__DSL_Expression_And__Group__1 )
            // InternalSensinact.g:4916:2: rule__DSL_Expression_And__Group__0__Impl rule__DSL_Expression_And__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__DSL_Expression_And__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_And__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group__0"


    // $ANTLR start "rule__DSL_Expression_And__Group__0__Impl"
    // InternalSensinact.g:4923:1: rule__DSL_Expression_And__Group__0__Impl : ( ruleDSL_Expression_DiffEqual ) ;
    public final void rule__DSL_Expression_And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4927:1: ( ( ruleDSL_Expression_DiffEqual ) )
            // InternalSensinact.g:4928:1: ( ruleDSL_Expression_DiffEqual )
            {
            // InternalSensinact.g:4928:1: ( ruleDSL_Expression_DiffEqual )
            // InternalSensinact.g:4929:2: ruleDSL_Expression_DiffEqual
            {
             before(grammarAccess.getDSL_Expression_AndAccess().getDSL_Expression_DiffEqualParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_DiffEqual();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_AndAccess().getDSL_Expression_DiffEqualParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group__0__Impl"


    // $ANTLR start "rule__DSL_Expression_And__Group__1"
    // InternalSensinact.g:4938:1: rule__DSL_Expression_And__Group__1 : rule__DSL_Expression_And__Group__1__Impl ;
    public final void rule__DSL_Expression_And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4942:1: ( rule__DSL_Expression_And__Group__1__Impl )
            // InternalSensinact.g:4943:2: rule__DSL_Expression_And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_And__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group__1"


    // $ANTLR start "rule__DSL_Expression_And__Group__1__Impl"
    // InternalSensinact.g:4949:1: rule__DSL_Expression_And__Group__1__Impl : ( ( rule__DSL_Expression_And__Group_1__0 )* ) ;
    public final void rule__DSL_Expression_And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4953:1: ( ( ( rule__DSL_Expression_And__Group_1__0 )* ) )
            // InternalSensinact.g:4954:1: ( ( rule__DSL_Expression_And__Group_1__0 )* )
            {
            // InternalSensinact.g:4954:1: ( ( rule__DSL_Expression_And__Group_1__0 )* )
            // InternalSensinact.g:4955:2: ( rule__DSL_Expression_And__Group_1__0 )*
            {
             before(grammarAccess.getDSL_Expression_AndAccess().getGroup_1()); 
            // InternalSensinact.g:4956:2: ( rule__DSL_Expression_And__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==41) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalSensinact.g:4956:3: rule__DSL_Expression_And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__DSL_Expression_And__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getDSL_Expression_AndAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group__1__Impl"


    // $ANTLR start "rule__DSL_Expression_And__Group_1__0"
    // InternalSensinact.g:4965:1: rule__DSL_Expression_And__Group_1__0 : rule__DSL_Expression_And__Group_1__0__Impl rule__DSL_Expression_And__Group_1__1 ;
    public final void rule__DSL_Expression_And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4969:1: ( rule__DSL_Expression_And__Group_1__0__Impl rule__DSL_Expression_And__Group_1__1 )
            // InternalSensinact.g:4970:2: rule__DSL_Expression_And__Group_1__0__Impl rule__DSL_Expression_And__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_And__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_And__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group_1__0"


    // $ANTLR start "rule__DSL_Expression_And__Group_1__0__Impl"
    // InternalSensinact.g:4977:1: rule__DSL_Expression_And__Group_1__0__Impl : ( 'and' ) ;
    public final void rule__DSL_Expression_And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4981:1: ( ( 'and' ) )
            // InternalSensinact.g:4982:1: ( 'and' )
            {
            // InternalSensinact.g:4982:1: ( 'and' )
            // InternalSensinact.g:4983:2: 'and'
            {
             before(grammarAccess.getDSL_Expression_AndAccess().getAndKeyword_1_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_AndAccess().getAndKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group_1__0__Impl"


    // $ANTLR start "rule__DSL_Expression_And__Group_1__1"
    // InternalSensinact.g:4992:1: rule__DSL_Expression_And__Group_1__1 : rule__DSL_Expression_And__Group_1__1__Impl rule__DSL_Expression_And__Group_1__2 ;
    public final void rule__DSL_Expression_And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:4996:1: ( rule__DSL_Expression_And__Group_1__1__Impl rule__DSL_Expression_And__Group_1__2 )
            // InternalSensinact.g:4997:2: rule__DSL_Expression_And__Group_1__1__Impl rule__DSL_Expression_And__Group_1__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_And__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_And__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group_1__1"


    // $ANTLR start "rule__DSL_Expression_And__Group_1__1__Impl"
    // InternalSensinact.g:5004:1: rule__DSL_Expression_And__Group_1__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5008:1: ( ( () ) )
            // InternalSensinact.g:5009:1: ( () )
            {
            // InternalSensinact.g:5009:1: ( () )
            // InternalSensinact.g:5010:2: ()
            {
             before(grammarAccess.getDSL_Expression_AndAccess().getDSL_Expression_AndLeftAction_1_1()); 
            // InternalSensinact.g:5011:2: ()
            // InternalSensinact.g:5011:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_AndAccess().getDSL_Expression_AndLeftAction_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group_1__1__Impl"


    // $ANTLR start "rule__DSL_Expression_And__Group_1__2"
    // InternalSensinact.g:5019:1: rule__DSL_Expression_And__Group_1__2 : rule__DSL_Expression_And__Group_1__2__Impl ;
    public final void rule__DSL_Expression_And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5023:1: ( rule__DSL_Expression_And__Group_1__2__Impl )
            // InternalSensinact.g:5024:2: rule__DSL_Expression_And__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_And__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group_1__2"


    // $ANTLR start "rule__DSL_Expression_And__Group_1__2__Impl"
    // InternalSensinact.g:5030:1: rule__DSL_Expression_And__Group_1__2__Impl : ( ( rule__DSL_Expression_And__RightAssignment_1_2 ) ) ;
    public final void rule__DSL_Expression_And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5034:1: ( ( ( rule__DSL_Expression_And__RightAssignment_1_2 ) ) )
            // InternalSensinact.g:5035:1: ( ( rule__DSL_Expression_And__RightAssignment_1_2 ) )
            {
            // InternalSensinact.g:5035:1: ( ( rule__DSL_Expression_And__RightAssignment_1_2 ) )
            // InternalSensinact.g:5036:2: ( rule__DSL_Expression_And__RightAssignment_1_2 )
            {
             before(grammarAccess.getDSL_Expression_AndAccess().getRightAssignment_1_2()); 
            // InternalSensinact.g:5037:2: ( rule__DSL_Expression_And__RightAssignment_1_2 )
            // InternalSensinact.g:5037:3: rule__DSL_Expression_And__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_And__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_AndAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__Group_1__2__Impl"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group__0"
    // InternalSensinact.g:5046:1: rule__DSL_Expression_DiffEqual__Group__0 : rule__DSL_Expression_DiffEqual__Group__0__Impl rule__DSL_Expression_DiffEqual__Group__1 ;
    public final void rule__DSL_Expression_DiffEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5050:1: ( rule__DSL_Expression_DiffEqual__Group__0__Impl rule__DSL_Expression_DiffEqual__Group__1 )
            // InternalSensinact.g:5051:2: rule__DSL_Expression_DiffEqual__Group__0__Impl rule__DSL_Expression_DiffEqual__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__DSL_Expression_DiffEqual__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group__0"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group__0__Impl"
    // InternalSensinact.g:5058:1: rule__DSL_Expression_DiffEqual__Group__0__Impl : ( ruleDSL_Expression_Compare ) ;
    public final void rule__DSL_Expression_DiffEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5062:1: ( ( ruleDSL_Expression_Compare ) )
            // InternalSensinact.g:5063:1: ( ruleDSL_Expression_Compare )
            {
            // InternalSensinact.g:5063:1: ( ruleDSL_Expression_Compare )
            // InternalSensinact.g:5064:2: ruleDSL_Expression_Compare
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getDSL_Expression_CompareParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Compare();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getDSL_Expression_CompareParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group__0__Impl"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group__1"
    // InternalSensinact.g:5073:1: rule__DSL_Expression_DiffEqual__Group__1 : rule__DSL_Expression_DiffEqual__Group__1__Impl ;
    public final void rule__DSL_Expression_DiffEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5077:1: ( rule__DSL_Expression_DiffEqual__Group__1__Impl )
            // InternalSensinact.g:5078:2: rule__DSL_Expression_DiffEqual__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group__1"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group__1__Impl"
    // InternalSensinact.g:5084:1: rule__DSL_Expression_DiffEqual__Group__1__Impl : ( ( rule__DSL_Expression_DiffEqual__Alternatives_1 )* ) ;
    public final void rule__DSL_Expression_DiffEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5088:1: ( ( ( rule__DSL_Expression_DiffEqual__Alternatives_1 )* ) )
            // InternalSensinact.g:5089:1: ( ( rule__DSL_Expression_DiffEqual__Alternatives_1 )* )
            {
            // InternalSensinact.g:5089:1: ( ( rule__DSL_Expression_DiffEqual__Alternatives_1 )* )
            // InternalSensinact.g:5090:2: ( rule__DSL_Expression_DiffEqual__Alternatives_1 )*
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getAlternatives_1()); 
            // InternalSensinact.g:5091:2: ( rule__DSL_Expression_DiffEqual__Alternatives_1 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=42 && LA25_0<=43)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSensinact.g:5091:3: rule__DSL_Expression_DiffEqual__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__DSL_Expression_DiffEqual__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group__1__Impl"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_0__0"
    // InternalSensinact.g:5100:1: rule__DSL_Expression_DiffEqual__Group_1_0__0 : rule__DSL_Expression_DiffEqual__Group_1_0__0__Impl rule__DSL_Expression_DiffEqual__Group_1_0__1 ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5104:1: ( rule__DSL_Expression_DiffEqual__Group_1_0__0__Impl rule__DSL_Expression_DiffEqual__Group_1_0__1 )
            // InternalSensinact.g:5105:2: rule__DSL_Expression_DiffEqual__Group_1_0__0__Impl rule__DSL_Expression_DiffEqual__Group_1_0__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_DiffEqual__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_0__0"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_0__0__Impl"
    // InternalSensinact.g:5112:1: rule__DSL_Expression_DiffEqual__Group_1_0__0__Impl : ( '!=' ) ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5116:1: ( ( '!=' ) )
            // InternalSensinact.g:5117:1: ( '!=' )
            {
            // InternalSensinact.g:5117:1: ( '!=' )
            // InternalSensinact.g:5118:2: '!='
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getExclamationMarkEqualsSignKeyword_1_0_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getExclamationMarkEqualsSignKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_0__0__Impl"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_0__1"
    // InternalSensinact.g:5127:1: rule__DSL_Expression_DiffEqual__Group_1_0__1 : rule__DSL_Expression_DiffEqual__Group_1_0__1__Impl rule__DSL_Expression_DiffEqual__Group_1_0__2 ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5131:1: ( rule__DSL_Expression_DiffEqual__Group_1_0__1__Impl rule__DSL_Expression_DiffEqual__Group_1_0__2 )
            // InternalSensinact.g:5132:2: rule__DSL_Expression_DiffEqual__Group_1_0__1__Impl rule__DSL_Expression_DiffEqual__Group_1_0__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_DiffEqual__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_0__1"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_0__1__Impl"
    // InternalSensinact.g:5139:1: rule__DSL_Expression_DiffEqual__Group_1_0__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5143:1: ( ( () ) )
            // InternalSensinact.g:5144:1: ( () )
            {
            // InternalSensinact.g:5144:1: ( () )
            // InternalSensinact.g:5145:2: ()
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getDSL_Expression_DiffLeftAction_1_0_1()); 
            // InternalSensinact.g:5146:2: ()
            // InternalSensinact.g:5146:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getDSL_Expression_DiffLeftAction_1_0_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_0__1__Impl"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_0__2"
    // InternalSensinact.g:5154:1: rule__DSL_Expression_DiffEqual__Group_1_0__2 : rule__DSL_Expression_DiffEqual__Group_1_0__2__Impl ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5158:1: ( rule__DSL_Expression_DiffEqual__Group_1_0__2__Impl )
            // InternalSensinact.g:5159:2: rule__DSL_Expression_DiffEqual__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_0__2"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_0__2__Impl"
    // InternalSensinact.g:5165:1: rule__DSL_Expression_DiffEqual__Group_1_0__2__Impl : ( ( rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2 ) ) ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5169:1: ( ( ( rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2 ) ) )
            // InternalSensinact.g:5170:1: ( ( rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2 ) )
            {
            // InternalSensinact.g:5170:1: ( ( rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2 ) )
            // InternalSensinact.g:5171:2: ( rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2 )
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightAssignment_1_0_2()); 
            // InternalSensinact.g:5172:2: ( rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2 )
            // InternalSensinact.g:5172:3: rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_0__2__Impl"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_1__0"
    // InternalSensinact.g:5181:1: rule__DSL_Expression_DiffEqual__Group_1_1__0 : rule__DSL_Expression_DiffEqual__Group_1_1__0__Impl rule__DSL_Expression_DiffEqual__Group_1_1__1 ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5185:1: ( rule__DSL_Expression_DiffEqual__Group_1_1__0__Impl rule__DSL_Expression_DiffEqual__Group_1_1__1 )
            // InternalSensinact.g:5186:2: rule__DSL_Expression_DiffEqual__Group_1_1__0__Impl rule__DSL_Expression_DiffEqual__Group_1_1__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_DiffEqual__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_1__0"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_1__0__Impl"
    // InternalSensinact.g:5193:1: rule__DSL_Expression_DiffEqual__Group_1_1__0__Impl : ( '==' ) ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5197:1: ( ( '==' ) )
            // InternalSensinact.g:5198:1: ( '==' )
            {
            // InternalSensinact.g:5198:1: ( '==' )
            // InternalSensinact.g:5199:2: '=='
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getEqualsSignEqualsSignKeyword_1_1_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getEqualsSignEqualsSignKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_1__0__Impl"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_1__1"
    // InternalSensinact.g:5208:1: rule__DSL_Expression_DiffEqual__Group_1_1__1 : rule__DSL_Expression_DiffEqual__Group_1_1__1__Impl rule__DSL_Expression_DiffEqual__Group_1_1__2 ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5212:1: ( rule__DSL_Expression_DiffEqual__Group_1_1__1__Impl rule__DSL_Expression_DiffEqual__Group_1_1__2 )
            // InternalSensinact.g:5213:2: rule__DSL_Expression_DiffEqual__Group_1_1__1__Impl rule__DSL_Expression_DiffEqual__Group_1_1__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_DiffEqual__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_1__1"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_1__1__Impl"
    // InternalSensinact.g:5220:1: rule__DSL_Expression_DiffEqual__Group_1_1__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5224:1: ( ( () ) )
            // InternalSensinact.g:5225:1: ( () )
            {
            // InternalSensinact.g:5225:1: ( () )
            // InternalSensinact.g:5226:2: ()
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getDSL_Expression_EqualLeftAction_1_1_1()); 
            // InternalSensinact.g:5227:2: ()
            // InternalSensinact.g:5227:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getDSL_Expression_EqualLeftAction_1_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_1__1__Impl"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_1__2"
    // InternalSensinact.g:5235:1: rule__DSL_Expression_DiffEqual__Group_1_1__2 : rule__DSL_Expression_DiffEqual__Group_1_1__2__Impl ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5239:1: ( rule__DSL_Expression_DiffEqual__Group_1_1__2__Impl )
            // InternalSensinact.g:5240:2: rule__DSL_Expression_DiffEqual__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__Group_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_1__2"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__Group_1_1__2__Impl"
    // InternalSensinact.g:5246:1: rule__DSL_Expression_DiffEqual__Group_1_1__2__Impl : ( ( rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2 ) ) ;
    public final void rule__DSL_Expression_DiffEqual__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5250:1: ( ( ( rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2 ) ) )
            // InternalSensinact.g:5251:1: ( ( rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2 ) )
            {
            // InternalSensinact.g:5251:1: ( ( rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2 ) )
            // InternalSensinact.g:5252:2: ( rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2 )
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightAssignment_1_1_2()); 
            // InternalSensinact.g:5253:2: ( rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2 )
            // InternalSensinact.g:5253:3: rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__Group_1_1__2__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group__0"
    // InternalSensinact.g:5262:1: rule__DSL_Expression_Compare__Group__0 : rule__DSL_Expression_Compare__Group__0__Impl rule__DSL_Expression_Compare__Group__1 ;
    public final void rule__DSL_Expression_Compare__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5266:1: ( rule__DSL_Expression_Compare__Group__0__Impl rule__DSL_Expression_Compare__Group__1 )
            // InternalSensinact.g:5267:2: rule__DSL_Expression_Compare__Group__0__Impl rule__DSL_Expression_Compare__Group__1
            {
            pushFollow(FOLLOW_37);
            rule__DSL_Expression_Compare__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group__0"


    // $ANTLR start "rule__DSL_Expression_Compare__Group__0__Impl"
    // InternalSensinact.g:5274:1: rule__DSL_Expression_Compare__Group__0__Impl : ( ruleDSL_Expression_PlusMinus ) ;
    public final void rule__DSL_Expression_Compare__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5278:1: ( ( ruleDSL_Expression_PlusMinus ) )
            // InternalSensinact.g:5279:1: ( ruleDSL_Expression_PlusMinus )
            {
            // InternalSensinact.g:5279:1: ( ruleDSL_Expression_PlusMinus )
            // InternalSensinact.g:5280:2: ruleDSL_Expression_PlusMinus
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_PlusMinusParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_PlusMinus();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_PlusMinusParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group__1"
    // InternalSensinact.g:5289:1: rule__DSL_Expression_Compare__Group__1 : rule__DSL_Expression_Compare__Group__1__Impl ;
    public final void rule__DSL_Expression_Compare__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5293:1: ( rule__DSL_Expression_Compare__Group__1__Impl )
            // InternalSensinact.g:5294:2: rule__DSL_Expression_Compare__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group__1"


    // $ANTLR start "rule__DSL_Expression_Compare__Group__1__Impl"
    // InternalSensinact.g:5300:1: rule__DSL_Expression_Compare__Group__1__Impl : ( ( rule__DSL_Expression_Compare__Alternatives_1 )* ) ;
    public final void rule__DSL_Expression_Compare__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5304:1: ( ( ( rule__DSL_Expression_Compare__Alternatives_1 )* ) )
            // InternalSensinact.g:5305:1: ( ( rule__DSL_Expression_Compare__Alternatives_1 )* )
            {
            // InternalSensinact.g:5305:1: ( ( rule__DSL_Expression_Compare__Alternatives_1 )* )
            // InternalSensinact.g:5306:2: ( rule__DSL_Expression_Compare__Alternatives_1 )*
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getAlternatives_1()); 
            // InternalSensinact.g:5307:2: ( rule__DSL_Expression_Compare__Alternatives_1 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=44 && LA26_0<=47)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalSensinact.g:5307:3: rule__DSL_Expression_Compare__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__DSL_Expression_Compare__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getDSL_Expression_CompareAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_0__0"
    // InternalSensinact.g:5316:1: rule__DSL_Expression_Compare__Group_1_0__0 : rule__DSL_Expression_Compare__Group_1_0__0__Impl rule__DSL_Expression_Compare__Group_1_0__1 ;
    public final void rule__DSL_Expression_Compare__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5320:1: ( rule__DSL_Expression_Compare__Group_1_0__0__Impl rule__DSL_Expression_Compare__Group_1_0__1 )
            // InternalSensinact.g:5321:2: rule__DSL_Expression_Compare__Group_1_0__0__Impl rule__DSL_Expression_Compare__Group_1_0__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Compare__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_0__0"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_0__0__Impl"
    // InternalSensinact.g:5328:1: rule__DSL_Expression_Compare__Group_1_0__0__Impl : ( '>' ) ;
    public final void rule__DSL_Expression_Compare__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5332:1: ( ( '>' ) )
            // InternalSensinact.g:5333:1: ( '>' )
            {
            // InternalSensinact.g:5333:1: ( '>' )
            // InternalSensinact.g:5334:2: '>'
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getGreaterThanSignKeyword_1_0_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_CompareAccess().getGreaterThanSignKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_0__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_0__1"
    // InternalSensinact.g:5343:1: rule__DSL_Expression_Compare__Group_1_0__1 : rule__DSL_Expression_Compare__Group_1_0__1__Impl rule__DSL_Expression_Compare__Group_1_0__2 ;
    public final void rule__DSL_Expression_Compare__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5347:1: ( rule__DSL_Expression_Compare__Group_1_0__1__Impl rule__DSL_Expression_Compare__Group_1_0__2 )
            // InternalSensinact.g:5348:2: rule__DSL_Expression_Compare__Group_1_0__1__Impl rule__DSL_Expression_Compare__Group_1_0__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Compare__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_0__1"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_0__1__Impl"
    // InternalSensinact.g:5355:1: rule__DSL_Expression_Compare__Group_1_0__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_Compare__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5359:1: ( ( () ) )
            // InternalSensinact.g:5360:1: ( () )
            {
            // InternalSensinact.g:5360:1: ( () )
            // InternalSensinact.g:5361:2: ()
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_LargerLeftAction_1_0_1()); 
            // InternalSensinact.g:5362:2: ()
            // InternalSensinact.g:5362:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_LargerLeftAction_1_0_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_0__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_0__2"
    // InternalSensinact.g:5370:1: rule__DSL_Expression_Compare__Group_1_0__2 : rule__DSL_Expression_Compare__Group_1_0__2__Impl ;
    public final void rule__DSL_Expression_Compare__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5374:1: ( rule__DSL_Expression_Compare__Group_1_0__2__Impl )
            // InternalSensinact.g:5375:2: rule__DSL_Expression_Compare__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_0__2"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_0__2__Impl"
    // InternalSensinact.g:5381:1: rule__DSL_Expression_Compare__Group_1_0__2__Impl : ( ( rule__DSL_Expression_Compare__RightAssignment_1_0_2 ) ) ;
    public final void rule__DSL_Expression_Compare__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5385:1: ( ( ( rule__DSL_Expression_Compare__RightAssignment_1_0_2 ) ) )
            // InternalSensinact.g:5386:1: ( ( rule__DSL_Expression_Compare__RightAssignment_1_0_2 ) )
            {
            // InternalSensinact.g:5386:1: ( ( rule__DSL_Expression_Compare__RightAssignment_1_0_2 ) )
            // InternalSensinact.g:5387:2: ( rule__DSL_Expression_Compare__RightAssignment_1_0_2 )
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getRightAssignment_1_0_2()); 
            // InternalSensinact.g:5388:2: ( rule__DSL_Expression_Compare__RightAssignment_1_0_2 )
            // InternalSensinact.g:5388:3: rule__DSL_Expression_Compare__RightAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__RightAssignment_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_CompareAccess().getRightAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_0__2__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_1__0"
    // InternalSensinact.g:5397:1: rule__DSL_Expression_Compare__Group_1_1__0 : rule__DSL_Expression_Compare__Group_1_1__0__Impl rule__DSL_Expression_Compare__Group_1_1__1 ;
    public final void rule__DSL_Expression_Compare__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5401:1: ( rule__DSL_Expression_Compare__Group_1_1__0__Impl rule__DSL_Expression_Compare__Group_1_1__1 )
            // InternalSensinact.g:5402:2: rule__DSL_Expression_Compare__Group_1_1__0__Impl rule__DSL_Expression_Compare__Group_1_1__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Compare__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_1__0"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_1__0__Impl"
    // InternalSensinact.g:5409:1: rule__DSL_Expression_Compare__Group_1_1__0__Impl : ( '>=' ) ;
    public final void rule__DSL_Expression_Compare__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5413:1: ( ( '>=' ) )
            // InternalSensinact.g:5414:1: ( '>=' )
            {
            // InternalSensinact.g:5414:1: ( '>=' )
            // InternalSensinact.g:5415:2: '>='
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getGreaterThanSignEqualsSignKeyword_1_1_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_CompareAccess().getGreaterThanSignEqualsSignKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_1__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_1__1"
    // InternalSensinact.g:5424:1: rule__DSL_Expression_Compare__Group_1_1__1 : rule__DSL_Expression_Compare__Group_1_1__1__Impl rule__DSL_Expression_Compare__Group_1_1__2 ;
    public final void rule__DSL_Expression_Compare__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5428:1: ( rule__DSL_Expression_Compare__Group_1_1__1__Impl rule__DSL_Expression_Compare__Group_1_1__2 )
            // InternalSensinact.g:5429:2: rule__DSL_Expression_Compare__Group_1_1__1__Impl rule__DSL_Expression_Compare__Group_1_1__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Compare__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_1__1"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_1__1__Impl"
    // InternalSensinact.g:5436:1: rule__DSL_Expression_Compare__Group_1_1__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_Compare__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5440:1: ( ( () ) )
            // InternalSensinact.g:5441:1: ( () )
            {
            // InternalSensinact.g:5441:1: ( () )
            // InternalSensinact.g:5442:2: ()
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_Larger_EqualLeftAction_1_1_1()); 
            // InternalSensinact.g:5443:2: ()
            // InternalSensinact.g:5443:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_Larger_EqualLeftAction_1_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_1__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_1__2"
    // InternalSensinact.g:5451:1: rule__DSL_Expression_Compare__Group_1_1__2 : rule__DSL_Expression_Compare__Group_1_1__2__Impl ;
    public final void rule__DSL_Expression_Compare__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5455:1: ( rule__DSL_Expression_Compare__Group_1_1__2__Impl )
            // InternalSensinact.g:5456:2: rule__DSL_Expression_Compare__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_1__2"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_1__2__Impl"
    // InternalSensinact.g:5462:1: rule__DSL_Expression_Compare__Group_1_1__2__Impl : ( ( rule__DSL_Expression_Compare__RightAssignment_1_1_2 ) ) ;
    public final void rule__DSL_Expression_Compare__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5466:1: ( ( ( rule__DSL_Expression_Compare__RightAssignment_1_1_2 ) ) )
            // InternalSensinact.g:5467:1: ( ( rule__DSL_Expression_Compare__RightAssignment_1_1_2 ) )
            {
            // InternalSensinact.g:5467:1: ( ( rule__DSL_Expression_Compare__RightAssignment_1_1_2 ) )
            // InternalSensinact.g:5468:2: ( rule__DSL_Expression_Compare__RightAssignment_1_1_2 )
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getRightAssignment_1_1_2()); 
            // InternalSensinact.g:5469:2: ( rule__DSL_Expression_Compare__RightAssignment_1_1_2 )
            // InternalSensinact.g:5469:3: rule__DSL_Expression_Compare__RightAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__RightAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_CompareAccess().getRightAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_1__2__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_2__0"
    // InternalSensinact.g:5478:1: rule__DSL_Expression_Compare__Group_1_2__0 : rule__DSL_Expression_Compare__Group_1_2__0__Impl rule__DSL_Expression_Compare__Group_1_2__1 ;
    public final void rule__DSL_Expression_Compare__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5482:1: ( rule__DSL_Expression_Compare__Group_1_2__0__Impl rule__DSL_Expression_Compare__Group_1_2__1 )
            // InternalSensinact.g:5483:2: rule__DSL_Expression_Compare__Group_1_2__0__Impl rule__DSL_Expression_Compare__Group_1_2__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Compare__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_2__0"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_2__0__Impl"
    // InternalSensinact.g:5490:1: rule__DSL_Expression_Compare__Group_1_2__0__Impl : ( '<' ) ;
    public final void rule__DSL_Expression_Compare__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5494:1: ( ( '<' ) )
            // InternalSensinact.g:5495:1: ( '<' )
            {
            // InternalSensinact.g:5495:1: ( '<' )
            // InternalSensinact.g:5496:2: '<'
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getLessThanSignKeyword_1_2_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_CompareAccess().getLessThanSignKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_2__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_2__1"
    // InternalSensinact.g:5505:1: rule__DSL_Expression_Compare__Group_1_2__1 : rule__DSL_Expression_Compare__Group_1_2__1__Impl rule__DSL_Expression_Compare__Group_1_2__2 ;
    public final void rule__DSL_Expression_Compare__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5509:1: ( rule__DSL_Expression_Compare__Group_1_2__1__Impl rule__DSL_Expression_Compare__Group_1_2__2 )
            // InternalSensinact.g:5510:2: rule__DSL_Expression_Compare__Group_1_2__1__Impl rule__DSL_Expression_Compare__Group_1_2__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Compare__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_2__1"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_2__1__Impl"
    // InternalSensinact.g:5517:1: rule__DSL_Expression_Compare__Group_1_2__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_Compare__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5521:1: ( ( () ) )
            // InternalSensinact.g:5522:1: ( () )
            {
            // InternalSensinact.g:5522:1: ( () )
            // InternalSensinact.g:5523:2: ()
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_SmallerLeftAction_1_2_1()); 
            // InternalSensinact.g:5524:2: ()
            // InternalSensinact.g:5524:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_SmallerLeftAction_1_2_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_2__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_2__2"
    // InternalSensinact.g:5532:1: rule__DSL_Expression_Compare__Group_1_2__2 : rule__DSL_Expression_Compare__Group_1_2__2__Impl ;
    public final void rule__DSL_Expression_Compare__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5536:1: ( rule__DSL_Expression_Compare__Group_1_2__2__Impl )
            // InternalSensinact.g:5537:2: rule__DSL_Expression_Compare__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_2__2"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_2__2__Impl"
    // InternalSensinact.g:5543:1: rule__DSL_Expression_Compare__Group_1_2__2__Impl : ( ( rule__DSL_Expression_Compare__RightAssignment_1_2_2 ) ) ;
    public final void rule__DSL_Expression_Compare__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5547:1: ( ( ( rule__DSL_Expression_Compare__RightAssignment_1_2_2 ) ) )
            // InternalSensinact.g:5548:1: ( ( rule__DSL_Expression_Compare__RightAssignment_1_2_2 ) )
            {
            // InternalSensinact.g:5548:1: ( ( rule__DSL_Expression_Compare__RightAssignment_1_2_2 ) )
            // InternalSensinact.g:5549:2: ( rule__DSL_Expression_Compare__RightAssignment_1_2_2 )
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getRightAssignment_1_2_2()); 
            // InternalSensinact.g:5550:2: ( rule__DSL_Expression_Compare__RightAssignment_1_2_2 )
            // InternalSensinact.g:5550:3: rule__DSL_Expression_Compare__RightAssignment_1_2_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__RightAssignment_1_2_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_CompareAccess().getRightAssignment_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_2__2__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_3__0"
    // InternalSensinact.g:5559:1: rule__DSL_Expression_Compare__Group_1_3__0 : rule__DSL_Expression_Compare__Group_1_3__0__Impl rule__DSL_Expression_Compare__Group_1_3__1 ;
    public final void rule__DSL_Expression_Compare__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5563:1: ( rule__DSL_Expression_Compare__Group_1_3__0__Impl rule__DSL_Expression_Compare__Group_1_3__1 )
            // InternalSensinact.g:5564:2: rule__DSL_Expression_Compare__Group_1_3__0__Impl rule__DSL_Expression_Compare__Group_1_3__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Compare__Group_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_3__0"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_3__0__Impl"
    // InternalSensinact.g:5571:1: rule__DSL_Expression_Compare__Group_1_3__0__Impl : ( '<=' ) ;
    public final void rule__DSL_Expression_Compare__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5575:1: ( ( '<=' ) )
            // InternalSensinact.g:5576:1: ( '<=' )
            {
            // InternalSensinact.g:5576:1: ( '<=' )
            // InternalSensinact.g:5577:2: '<='
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getLessThanSignEqualsSignKeyword_1_3_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_CompareAccess().getLessThanSignEqualsSignKeyword_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_3__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_3__1"
    // InternalSensinact.g:5586:1: rule__DSL_Expression_Compare__Group_1_3__1 : rule__DSL_Expression_Compare__Group_1_3__1__Impl rule__DSL_Expression_Compare__Group_1_3__2 ;
    public final void rule__DSL_Expression_Compare__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5590:1: ( rule__DSL_Expression_Compare__Group_1_3__1__Impl rule__DSL_Expression_Compare__Group_1_3__2 )
            // InternalSensinact.g:5591:2: rule__DSL_Expression_Compare__Group_1_3__1__Impl rule__DSL_Expression_Compare__Group_1_3__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Compare__Group_1_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_3__1"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_3__1__Impl"
    // InternalSensinact.g:5598:1: rule__DSL_Expression_Compare__Group_1_3__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_Compare__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5602:1: ( ( () ) )
            // InternalSensinact.g:5603:1: ( () )
            {
            // InternalSensinact.g:5603:1: ( () )
            // InternalSensinact.g:5604:2: ()
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_Smaller_EqualLeftAction_1_3_1()); 
            // InternalSensinact.g:5605:2: ()
            // InternalSensinact.g:5605:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_Smaller_EqualLeftAction_1_3_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_3__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_3__2"
    // InternalSensinact.g:5613:1: rule__DSL_Expression_Compare__Group_1_3__2 : rule__DSL_Expression_Compare__Group_1_3__2__Impl ;
    public final void rule__DSL_Expression_Compare__Group_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5617:1: ( rule__DSL_Expression_Compare__Group_1_3__2__Impl )
            // InternalSensinact.g:5618:2: rule__DSL_Expression_Compare__Group_1_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__Group_1_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_3__2"


    // $ANTLR start "rule__DSL_Expression_Compare__Group_1_3__2__Impl"
    // InternalSensinact.g:5624:1: rule__DSL_Expression_Compare__Group_1_3__2__Impl : ( ( rule__DSL_Expression_Compare__RightAssignment_1_3_2 ) ) ;
    public final void rule__DSL_Expression_Compare__Group_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5628:1: ( ( ( rule__DSL_Expression_Compare__RightAssignment_1_3_2 ) ) )
            // InternalSensinact.g:5629:1: ( ( rule__DSL_Expression_Compare__RightAssignment_1_3_2 ) )
            {
            // InternalSensinact.g:5629:1: ( ( rule__DSL_Expression_Compare__RightAssignment_1_3_2 ) )
            // InternalSensinact.g:5630:2: ( rule__DSL_Expression_Compare__RightAssignment_1_3_2 )
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getRightAssignment_1_3_2()); 
            // InternalSensinact.g:5631:2: ( rule__DSL_Expression_Compare__RightAssignment_1_3_2 )
            // InternalSensinact.g:5631:3: rule__DSL_Expression_Compare__RightAssignment_1_3_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Compare__RightAssignment_1_3_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_CompareAccess().getRightAssignment_1_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__Group_1_3__2__Impl"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group__0"
    // InternalSensinact.g:5640:1: rule__DSL_Expression_PlusMinus__Group__0 : rule__DSL_Expression_PlusMinus__Group__0__Impl rule__DSL_Expression_PlusMinus__Group__1 ;
    public final void rule__DSL_Expression_PlusMinus__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5644:1: ( rule__DSL_Expression_PlusMinus__Group__0__Impl rule__DSL_Expression_PlusMinus__Group__1 )
            // InternalSensinact.g:5645:2: rule__DSL_Expression_PlusMinus__Group__0__Impl rule__DSL_Expression_PlusMinus__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__DSL_Expression_PlusMinus__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group__0"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group__0__Impl"
    // InternalSensinact.g:5652:1: rule__DSL_Expression_PlusMinus__Group__0__Impl : ( ruleDSL_Expression_MultiplicationDivision ) ;
    public final void rule__DSL_Expression_PlusMinus__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5656:1: ( ( ruleDSL_Expression_MultiplicationDivision ) )
            // InternalSensinact.g:5657:1: ( ruleDSL_Expression_MultiplicationDivision )
            {
            // InternalSensinact.g:5657:1: ( ruleDSL_Expression_MultiplicationDivision )
            // InternalSensinact.g:5658:2: ruleDSL_Expression_MultiplicationDivision
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getDSL_Expression_MultiplicationDivisionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_MultiplicationDivision();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getDSL_Expression_MultiplicationDivisionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group__0__Impl"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group__1"
    // InternalSensinact.g:5667:1: rule__DSL_Expression_PlusMinus__Group__1 : rule__DSL_Expression_PlusMinus__Group__1__Impl ;
    public final void rule__DSL_Expression_PlusMinus__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5671:1: ( rule__DSL_Expression_PlusMinus__Group__1__Impl )
            // InternalSensinact.g:5672:2: rule__DSL_Expression_PlusMinus__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group__1"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group__1__Impl"
    // InternalSensinact.g:5678:1: rule__DSL_Expression_PlusMinus__Group__1__Impl : ( ( rule__DSL_Expression_PlusMinus__Alternatives_1 )* ) ;
    public final void rule__DSL_Expression_PlusMinus__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5682:1: ( ( ( rule__DSL_Expression_PlusMinus__Alternatives_1 )* ) )
            // InternalSensinact.g:5683:1: ( ( rule__DSL_Expression_PlusMinus__Alternatives_1 )* )
            {
            // InternalSensinact.g:5683:1: ( ( rule__DSL_Expression_PlusMinus__Alternatives_1 )* )
            // InternalSensinact.g:5684:2: ( rule__DSL_Expression_PlusMinus__Alternatives_1 )*
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getAlternatives_1()); 
            // InternalSensinact.g:5685:2: ( rule__DSL_Expression_PlusMinus__Alternatives_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=48 && LA27_0<=49)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalSensinact.g:5685:3: rule__DSL_Expression_PlusMinus__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_40);
            	    rule__DSL_Expression_PlusMinus__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group__1__Impl"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_0__0"
    // InternalSensinact.g:5694:1: rule__DSL_Expression_PlusMinus__Group_1_0__0 : rule__DSL_Expression_PlusMinus__Group_1_0__0__Impl rule__DSL_Expression_PlusMinus__Group_1_0__1 ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5698:1: ( rule__DSL_Expression_PlusMinus__Group_1_0__0__Impl rule__DSL_Expression_PlusMinus__Group_1_0__1 )
            // InternalSensinact.g:5699:2: rule__DSL_Expression_PlusMinus__Group_1_0__0__Impl rule__DSL_Expression_PlusMinus__Group_1_0__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_PlusMinus__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_0__0"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_0__0__Impl"
    // InternalSensinact.g:5706:1: rule__DSL_Expression_PlusMinus__Group_1_0__0__Impl : ( '+' ) ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5710:1: ( ( '+' ) )
            // InternalSensinact.g:5711:1: ( '+' )
            {
            // InternalSensinact.g:5711:1: ( '+' )
            // InternalSensinact.g:5712:2: '+'
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getPlusSignKeyword_1_0_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getPlusSignKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_0__0__Impl"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_0__1"
    // InternalSensinact.g:5721:1: rule__DSL_Expression_PlusMinus__Group_1_0__1 : rule__DSL_Expression_PlusMinus__Group_1_0__1__Impl rule__DSL_Expression_PlusMinus__Group_1_0__2 ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5725:1: ( rule__DSL_Expression_PlusMinus__Group_1_0__1__Impl rule__DSL_Expression_PlusMinus__Group_1_0__2 )
            // InternalSensinact.g:5726:2: rule__DSL_Expression_PlusMinus__Group_1_0__1__Impl rule__DSL_Expression_PlusMinus__Group_1_0__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_PlusMinus__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_0__1"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_0__1__Impl"
    // InternalSensinact.g:5733:1: rule__DSL_Expression_PlusMinus__Group_1_0__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5737:1: ( ( () ) )
            // InternalSensinact.g:5738:1: ( () )
            {
            // InternalSensinact.g:5738:1: ( () )
            // InternalSensinact.g:5739:2: ()
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getDSL_Expression_PlusLeftAction_1_0_1()); 
            // InternalSensinact.g:5740:2: ()
            // InternalSensinact.g:5740:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getDSL_Expression_PlusLeftAction_1_0_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_0__1__Impl"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_0__2"
    // InternalSensinact.g:5748:1: rule__DSL_Expression_PlusMinus__Group_1_0__2 : rule__DSL_Expression_PlusMinus__Group_1_0__2__Impl ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5752:1: ( rule__DSL_Expression_PlusMinus__Group_1_0__2__Impl )
            // InternalSensinact.g:5753:2: rule__DSL_Expression_PlusMinus__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_0__2"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_0__2__Impl"
    // InternalSensinact.g:5759:1: rule__DSL_Expression_PlusMinus__Group_1_0__2__Impl : ( ( rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2 ) ) ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5763:1: ( ( ( rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2 ) ) )
            // InternalSensinact.g:5764:1: ( ( rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2 ) )
            {
            // InternalSensinact.g:5764:1: ( ( rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2 ) )
            // InternalSensinact.g:5765:2: ( rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2 )
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightAssignment_1_0_2()); 
            // InternalSensinact.g:5766:2: ( rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2 )
            // InternalSensinact.g:5766:3: rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_0__2__Impl"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_1__0"
    // InternalSensinact.g:5775:1: rule__DSL_Expression_PlusMinus__Group_1_1__0 : rule__DSL_Expression_PlusMinus__Group_1_1__0__Impl rule__DSL_Expression_PlusMinus__Group_1_1__1 ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5779:1: ( rule__DSL_Expression_PlusMinus__Group_1_1__0__Impl rule__DSL_Expression_PlusMinus__Group_1_1__1 )
            // InternalSensinact.g:5780:2: rule__DSL_Expression_PlusMinus__Group_1_1__0__Impl rule__DSL_Expression_PlusMinus__Group_1_1__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_PlusMinus__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_1__0"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_1__0__Impl"
    // InternalSensinact.g:5787:1: rule__DSL_Expression_PlusMinus__Group_1_1__0__Impl : ( '-' ) ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5791:1: ( ( '-' ) )
            // InternalSensinact.g:5792:1: ( '-' )
            {
            // InternalSensinact.g:5792:1: ( '-' )
            // InternalSensinact.g:5793:2: '-'
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getHyphenMinusKeyword_1_1_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getHyphenMinusKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_1__0__Impl"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_1__1"
    // InternalSensinact.g:5802:1: rule__DSL_Expression_PlusMinus__Group_1_1__1 : rule__DSL_Expression_PlusMinus__Group_1_1__1__Impl rule__DSL_Expression_PlusMinus__Group_1_1__2 ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5806:1: ( rule__DSL_Expression_PlusMinus__Group_1_1__1__Impl rule__DSL_Expression_PlusMinus__Group_1_1__2 )
            // InternalSensinact.g:5807:2: rule__DSL_Expression_PlusMinus__Group_1_1__1__Impl rule__DSL_Expression_PlusMinus__Group_1_1__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_PlusMinus__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_1__1"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_1__1__Impl"
    // InternalSensinact.g:5814:1: rule__DSL_Expression_PlusMinus__Group_1_1__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5818:1: ( ( () ) )
            // InternalSensinact.g:5819:1: ( () )
            {
            // InternalSensinact.g:5819:1: ( () )
            // InternalSensinact.g:5820:2: ()
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getDSL_Expression_MinusLeftAction_1_1_1()); 
            // InternalSensinact.g:5821:2: ()
            // InternalSensinact.g:5821:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getDSL_Expression_MinusLeftAction_1_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_1__1__Impl"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_1__2"
    // InternalSensinact.g:5829:1: rule__DSL_Expression_PlusMinus__Group_1_1__2 : rule__DSL_Expression_PlusMinus__Group_1_1__2__Impl ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5833:1: ( rule__DSL_Expression_PlusMinus__Group_1_1__2__Impl )
            // InternalSensinact.g:5834:2: rule__DSL_Expression_PlusMinus__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__Group_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_1__2"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__Group_1_1__2__Impl"
    // InternalSensinact.g:5840:1: rule__DSL_Expression_PlusMinus__Group_1_1__2__Impl : ( ( rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2 ) ) ;
    public final void rule__DSL_Expression_PlusMinus__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5844:1: ( ( ( rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2 ) ) )
            // InternalSensinact.g:5845:1: ( ( rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2 ) )
            {
            // InternalSensinact.g:5845:1: ( ( rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2 ) )
            // InternalSensinact.g:5846:2: ( rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2 )
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightAssignment_1_1_2()); 
            // InternalSensinact.g:5847:2: ( rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2 )
            // InternalSensinact.g:5847:3: rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__Group_1_1__2__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group__0"
    // InternalSensinact.g:5856:1: rule__DSL_Expression_MultiplicationDivision__Group__0 : rule__DSL_Expression_MultiplicationDivision__Group__0__Impl rule__DSL_Expression_MultiplicationDivision__Group__1 ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5860:1: ( rule__DSL_Expression_MultiplicationDivision__Group__0__Impl rule__DSL_Expression_MultiplicationDivision__Group__1 )
            // InternalSensinact.g:5861:2: rule__DSL_Expression_MultiplicationDivision__Group__0__Impl rule__DSL_Expression_MultiplicationDivision__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__DSL_Expression_MultiplicationDivision__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group__0"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group__0__Impl"
    // InternalSensinact.g:5868:1: rule__DSL_Expression_MultiplicationDivision__Group__0__Impl : ( ruleDSL_Expression_Unary ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5872:1: ( ( ruleDSL_Expression_Unary ) )
            // InternalSensinact.g:5873:1: ( ruleDSL_Expression_Unary )
            {
            // InternalSensinact.g:5873:1: ( ruleDSL_Expression_Unary )
            // InternalSensinact.g:5874:2: ruleDSL_Expression_Unary
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_UnaryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Unary();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_UnaryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group__0__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group__1"
    // InternalSensinact.g:5883:1: rule__DSL_Expression_MultiplicationDivision__Group__1 : rule__DSL_Expression_MultiplicationDivision__Group__1__Impl ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5887:1: ( rule__DSL_Expression_MultiplicationDivision__Group__1__Impl )
            // InternalSensinact.g:5888:2: rule__DSL_Expression_MultiplicationDivision__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group__1"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group__1__Impl"
    // InternalSensinact.g:5894:1: rule__DSL_Expression_MultiplicationDivision__Group__1__Impl : ( ( rule__DSL_Expression_MultiplicationDivision__Alternatives_1 )* ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5898:1: ( ( ( rule__DSL_Expression_MultiplicationDivision__Alternatives_1 )* ) )
            // InternalSensinact.g:5899:1: ( ( rule__DSL_Expression_MultiplicationDivision__Alternatives_1 )* )
            {
            // InternalSensinact.g:5899:1: ( ( rule__DSL_Expression_MultiplicationDivision__Alternatives_1 )* )
            // InternalSensinact.g:5900:2: ( rule__DSL_Expression_MultiplicationDivision__Alternatives_1 )*
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getAlternatives_1()); 
            // InternalSensinact.g:5901:2: ( rule__DSL_Expression_MultiplicationDivision__Alternatives_1 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==17||(LA28_0>=50 && LA28_0<=51)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalSensinact.g:5901:3: rule__DSL_Expression_MultiplicationDivision__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_42);
            	    rule__DSL_Expression_MultiplicationDivision__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group__1__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_0__0"
    // InternalSensinact.g:5910:1: rule__DSL_Expression_MultiplicationDivision__Group_1_0__0 : rule__DSL_Expression_MultiplicationDivision__Group_1_0__0__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_0__1 ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5914:1: ( rule__DSL_Expression_MultiplicationDivision__Group_1_0__0__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_0__1 )
            // InternalSensinact.g:5915:2: rule__DSL_Expression_MultiplicationDivision__Group_1_0__0__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_0__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_MultiplicationDivision__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_0__0"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_0__0__Impl"
    // InternalSensinact.g:5922:1: rule__DSL_Expression_MultiplicationDivision__Group_1_0__0__Impl : ( '*' ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5926:1: ( ( '*' ) )
            // InternalSensinact.g:5927:1: ( '*' )
            {
            // InternalSensinact.g:5927:1: ( '*' )
            // InternalSensinact.g:5928:2: '*'
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getAsteriskKeyword_1_0_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getAsteriskKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_0__0__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_0__1"
    // InternalSensinact.g:5937:1: rule__DSL_Expression_MultiplicationDivision__Group_1_0__1 : rule__DSL_Expression_MultiplicationDivision__Group_1_0__1__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_0__2 ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5941:1: ( rule__DSL_Expression_MultiplicationDivision__Group_1_0__1__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_0__2 )
            // InternalSensinact.g:5942:2: rule__DSL_Expression_MultiplicationDivision__Group_1_0__1__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_0__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_MultiplicationDivision__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_0__1"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_0__1__Impl"
    // InternalSensinact.g:5949:1: rule__DSL_Expression_MultiplicationDivision__Group_1_0__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5953:1: ( ( () ) )
            // InternalSensinact.g:5954:1: ( () )
            {
            // InternalSensinact.g:5954:1: ( () )
            // InternalSensinact.g:5955:2: ()
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_MultiplicationLeftAction_1_0_1()); 
            // InternalSensinact.g:5956:2: ()
            // InternalSensinact.g:5956:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_MultiplicationLeftAction_1_0_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_0__1__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_0__2"
    // InternalSensinact.g:5964:1: rule__DSL_Expression_MultiplicationDivision__Group_1_0__2 : rule__DSL_Expression_MultiplicationDivision__Group_1_0__2__Impl ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5968:1: ( rule__DSL_Expression_MultiplicationDivision__Group_1_0__2__Impl )
            // InternalSensinact.g:5969:2: rule__DSL_Expression_MultiplicationDivision__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_0__2"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_0__2__Impl"
    // InternalSensinact.g:5975:1: rule__DSL_Expression_MultiplicationDivision__Group_1_0__2__Impl : ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2 ) ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5979:1: ( ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2 ) ) )
            // InternalSensinact.g:5980:1: ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2 ) )
            {
            // InternalSensinact.g:5980:1: ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2 ) )
            // InternalSensinact.g:5981:2: ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2 )
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightAssignment_1_0_2()); 
            // InternalSensinact.g:5982:2: ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2 )
            // InternalSensinact.g:5982:3: rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_0__2__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_1__0"
    // InternalSensinact.g:5991:1: rule__DSL_Expression_MultiplicationDivision__Group_1_1__0 : rule__DSL_Expression_MultiplicationDivision__Group_1_1__0__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_1__1 ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:5995:1: ( rule__DSL_Expression_MultiplicationDivision__Group_1_1__0__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_1__1 )
            // InternalSensinact.g:5996:2: rule__DSL_Expression_MultiplicationDivision__Group_1_1__0__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_1__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_MultiplicationDivision__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_1__0"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_1__0__Impl"
    // InternalSensinact.g:6003:1: rule__DSL_Expression_MultiplicationDivision__Group_1_1__0__Impl : ( '/' ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6007:1: ( ( '/' ) )
            // InternalSensinact.g:6008:1: ( '/' )
            {
            // InternalSensinact.g:6008:1: ( '/' )
            // InternalSensinact.g:6009:2: '/'
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getSolidusKeyword_1_1_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getSolidusKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_1__0__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_1__1"
    // InternalSensinact.g:6018:1: rule__DSL_Expression_MultiplicationDivision__Group_1_1__1 : rule__DSL_Expression_MultiplicationDivision__Group_1_1__1__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_1__2 ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6022:1: ( rule__DSL_Expression_MultiplicationDivision__Group_1_1__1__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_1__2 )
            // InternalSensinact.g:6023:2: rule__DSL_Expression_MultiplicationDivision__Group_1_1__1__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_1__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_MultiplicationDivision__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_1__1"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_1__1__Impl"
    // InternalSensinact.g:6030:1: rule__DSL_Expression_MultiplicationDivision__Group_1_1__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6034:1: ( ( () ) )
            // InternalSensinact.g:6035:1: ( () )
            {
            // InternalSensinact.g:6035:1: ( () )
            // InternalSensinact.g:6036:2: ()
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_DivisionLeftAction_1_1_1()); 
            // InternalSensinact.g:6037:2: ()
            // InternalSensinact.g:6037:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_DivisionLeftAction_1_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_1__1__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_1__2"
    // InternalSensinact.g:6045:1: rule__DSL_Expression_MultiplicationDivision__Group_1_1__2 : rule__DSL_Expression_MultiplicationDivision__Group_1_1__2__Impl ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6049:1: ( rule__DSL_Expression_MultiplicationDivision__Group_1_1__2__Impl )
            // InternalSensinact.g:6050:2: rule__DSL_Expression_MultiplicationDivision__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_1__2"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_1__2__Impl"
    // InternalSensinact.g:6056:1: rule__DSL_Expression_MultiplicationDivision__Group_1_1__2__Impl : ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2 ) ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6060:1: ( ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2 ) ) )
            // InternalSensinact.g:6061:1: ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2 ) )
            {
            // InternalSensinact.g:6061:1: ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2 ) )
            // InternalSensinact.g:6062:2: ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2 )
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightAssignment_1_1_2()); 
            // InternalSensinact.g:6063:2: ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2 )
            // InternalSensinact.g:6063:3: rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_1__2__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_2__0"
    // InternalSensinact.g:6072:1: rule__DSL_Expression_MultiplicationDivision__Group_1_2__0 : rule__DSL_Expression_MultiplicationDivision__Group_1_2__0__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_2__1 ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6076:1: ( rule__DSL_Expression_MultiplicationDivision__Group_1_2__0__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_2__1 )
            // InternalSensinact.g:6077:2: rule__DSL_Expression_MultiplicationDivision__Group_1_2__0__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_2__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_MultiplicationDivision__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_2__0"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_2__0__Impl"
    // InternalSensinact.g:6084:1: rule__DSL_Expression_MultiplicationDivision__Group_1_2__0__Impl : ( '%' ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6088:1: ( ( '%' ) )
            // InternalSensinact.g:6089:1: ( '%' )
            {
            // InternalSensinact.g:6089:1: ( '%' )
            // InternalSensinact.g:6090:2: '%'
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getPercentSignKeyword_1_2_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getPercentSignKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_2__0__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_2__1"
    // InternalSensinact.g:6099:1: rule__DSL_Expression_MultiplicationDivision__Group_1_2__1 : rule__DSL_Expression_MultiplicationDivision__Group_1_2__1__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_2__2 ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6103:1: ( rule__DSL_Expression_MultiplicationDivision__Group_1_2__1__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_2__2 )
            // InternalSensinact.g:6104:2: rule__DSL_Expression_MultiplicationDivision__Group_1_2__1__Impl rule__DSL_Expression_MultiplicationDivision__Group_1_2__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_MultiplicationDivision__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_2__1"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_2__1__Impl"
    // InternalSensinact.g:6111:1: rule__DSL_Expression_MultiplicationDivision__Group_1_2__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6115:1: ( ( () ) )
            // InternalSensinact.g:6116:1: ( () )
            {
            // InternalSensinact.g:6116:1: ( () )
            // InternalSensinact.g:6117:2: ()
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_ModuloLeftAction_1_2_1()); 
            // InternalSensinact.g:6118:2: ()
            // InternalSensinact.g:6118:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_ModuloLeftAction_1_2_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_2__1__Impl"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_2__2"
    // InternalSensinact.g:6126:1: rule__DSL_Expression_MultiplicationDivision__Group_1_2__2 : rule__DSL_Expression_MultiplicationDivision__Group_1_2__2__Impl ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6130:1: ( rule__DSL_Expression_MultiplicationDivision__Group_1_2__2__Impl )
            // InternalSensinact.g:6131:2: rule__DSL_Expression_MultiplicationDivision__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__Group_1_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_2__2"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__Group_1_2__2__Impl"
    // InternalSensinact.g:6137:1: rule__DSL_Expression_MultiplicationDivision__Group_1_2__2__Impl : ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2 ) ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6141:1: ( ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2 ) ) )
            // InternalSensinact.g:6142:1: ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2 ) )
            {
            // InternalSensinact.g:6142:1: ( ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2 ) )
            // InternalSensinact.g:6143:2: ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2 )
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightAssignment_1_2_2()); 
            // InternalSensinact.g:6144:2: ( rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2 )
            // InternalSensinact.g:6144:3: rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightAssignment_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__Group_1_2__2__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_0__0"
    // InternalSensinact.g:6153:1: rule__DSL_Expression_Unary__Group_0__0 : rule__DSL_Expression_Unary__Group_0__0__Impl rule__DSL_Expression_Unary__Group_0__1 ;
    public final void rule__DSL_Expression_Unary__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6157:1: ( rule__DSL_Expression_Unary__Group_0__0__Impl rule__DSL_Expression_Unary__Group_0__1 )
            // InternalSensinact.g:6158:2: rule__DSL_Expression_Unary__Group_0__0__Impl rule__DSL_Expression_Unary__Group_0__1
            {
            pushFollow(FOLLOW_21);
            rule__DSL_Expression_Unary__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_0__0"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_0__0__Impl"
    // InternalSensinact.g:6165:1: rule__DSL_Expression_Unary__Group_0__0__Impl : ( () ) ;
    public final void rule__DSL_Expression_Unary__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6169:1: ( ( () ) )
            // InternalSensinact.g:6170:1: ( () )
            {
            // InternalSensinact.g:6170:1: ( () )
            // InternalSensinact.g:6171:2: ()
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_NumberAction_0_0()); 
            // InternalSensinact.g:6172:2: ()
            // InternalSensinact.g:6172:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_NumberAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_0__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_0__1"
    // InternalSensinact.g:6180:1: rule__DSL_Expression_Unary__Group_0__1 : rule__DSL_Expression_Unary__Group_0__1__Impl ;
    public final void rule__DSL_Expression_Unary__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6184:1: ( rule__DSL_Expression_Unary__Group_0__1__Impl )
            // InternalSensinact.g:6185:2: rule__DSL_Expression_Unary__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_0__1"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_0__1__Impl"
    // InternalSensinact.g:6191:1: rule__DSL_Expression_Unary__Group_0__1__Impl : ( ( rule__DSL_Expression_Unary__ValueAssignment_0_1 ) ) ;
    public final void rule__DSL_Expression_Unary__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6195:1: ( ( ( rule__DSL_Expression_Unary__ValueAssignment_0_1 ) ) )
            // InternalSensinact.g:6196:1: ( ( rule__DSL_Expression_Unary__ValueAssignment_0_1 ) )
            {
            // InternalSensinact.g:6196:1: ( ( rule__DSL_Expression_Unary__ValueAssignment_0_1 ) )
            // InternalSensinact.g:6197:2: ( rule__DSL_Expression_Unary__ValueAssignment_0_1 )
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getValueAssignment_0_1()); 
            // InternalSensinact.g:6198:2: ( rule__DSL_Expression_Unary__ValueAssignment_0_1 )
            // InternalSensinact.g:6198:3: rule__DSL_Expression_Unary__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__ValueAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getValueAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_0__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_1__0"
    // InternalSensinact.g:6207:1: rule__DSL_Expression_Unary__Group_1__0 : rule__DSL_Expression_Unary__Group_1__0__Impl rule__DSL_Expression_Unary__Group_1__1 ;
    public final void rule__DSL_Expression_Unary__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6211:1: ( rule__DSL_Expression_Unary__Group_1__0__Impl rule__DSL_Expression_Unary__Group_1__1 )
            // InternalSensinact.g:6212:2: rule__DSL_Expression_Unary__Group_1__0__Impl rule__DSL_Expression_Unary__Group_1__1
            {
            pushFollow(FOLLOW_43);
            rule__DSL_Expression_Unary__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_1__0"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_1__0__Impl"
    // InternalSensinact.g:6219:1: rule__DSL_Expression_Unary__Group_1__0__Impl : ( () ) ;
    public final void rule__DSL_Expression_Unary__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6223:1: ( ( () ) )
            // InternalSensinact.g:6224:1: ( () )
            {
            // InternalSensinact.g:6224:1: ( () )
            // InternalSensinact.g:6225:2: ()
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_StringAction_1_0()); 
            // InternalSensinact.g:6226:2: ()
            // InternalSensinact.g:6226:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_StringAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_1__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_1__1"
    // InternalSensinact.g:6234:1: rule__DSL_Expression_Unary__Group_1__1 : rule__DSL_Expression_Unary__Group_1__1__Impl ;
    public final void rule__DSL_Expression_Unary__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6238:1: ( rule__DSL_Expression_Unary__Group_1__1__Impl )
            // InternalSensinact.g:6239:2: rule__DSL_Expression_Unary__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_1__1"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_1__1__Impl"
    // InternalSensinact.g:6245:1: rule__DSL_Expression_Unary__Group_1__1__Impl : ( ( rule__DSL_Expression_Unary__ValueAssignment_1_1 ) ) ;
    public final void rule__DSL_Expression_Unary__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6249:1: ( ( ( rule__DSL_Expression_Unary__ValueAssignment_1_1 ) ) )
            // InternalSensinact.g:6250:1: ( ( rule__DSL_Expression_Unary__ValueAssignment_1_1 ) )
            {
            // InternalSensinact.g:6250:1: ( ( rule__DSL_Expression_Unary__ValueAssignment_1_1 ) )
            // InternalSensinact.g:6251:2: ( rule__DSL_Expression_Unary__ValueAssignment_1_1 )
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getValueAssignment_1_1()); 
            // InternalSensinact.g:6252:2: ( rule__DSL_Expression_Unary__ValueAssignment_1_1 )
            // InternalSensinact.g:6252:3: rule__DSL_Expression_Unary__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__ValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getValueAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_1__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_2__0"
    // InternalSensinact.g:6261:1: rule__DSL_Expression_Unary__Group_2__0 : rule__DSL_Expression_Unary__Group_2__0__Impl rule__DSL_Expression_Unary__Group_2__1 ;
    public final void rule__DSL_Expression_Unary__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6265:1: ( rule__DSL_Expression_Unary__Group_2__0__Impl rule__DSL_Expression_Unary__Group_2__1 )
            // InternalSensinact.g:6266:2: rule__DSL_Expression_Unary__Group_2__0__Impl rule__DSL_Expression_Unary__Group_2__1
            {
            pushFollow(FOLLOW_44);
            rule__DSL_Expression_Unary__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_2__0"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_2__0__Impl"
    // InternalSensinact.g:6273:1: rule__DSL_Expression_Unary__Group_2__0__Impl : ( () ) ;
    public final void rule__DSL_Expression_Unary__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6277:1: ( ( () ) )
            // InternalSensinact.g:6278:1: ( () )
            {
            // InternalSensinact.g:6278:1: ( () )
            // InternalSensinact.g:6279:2: ()
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_BooleanAction_2_0()); 
            // InternalSensinact.g:6280:2: ()
            // InternalSensinact.g:6280:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_BooleanAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_2__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_2__1"
    // InternalSensinact.g:6288:1: rule__DSL_Expression_Unary__Group_2__1 : rule__DSL_Expression_Unary__Group_2__1__Impl ;
    public final void rule__DSL_Expression_Unary__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6292:1: ( rule__DSL_Expression_Unary__Group_2__1__Impl )
            // InternalSensinact.g:6293:2: rule__DSL_Expression_Unary__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_2__1"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_2__1__Impl"
    // InternalSensinact.g:6299:1: rule__DSL_Expression_Unary__Group_2__1__Impl : ( ( rule__DSL_Expression_Unary__ValueAssignment_2_1 ) ) ;
    public final void rule__DSL_Expression_Unary__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6303:1: ( ( ( rule__DSL_Expression_Unary__ValueAssignment_2_1 ) ) )
            // InternalSensinact.g:6304:1: ( ( rule__DSL_Expression_Unary__ValueAssignment_2_1 ) )
            {
            // InternalSensinact.g:6304:1: ( ( rule__DSL_Expression_Unary__ValueAssignment_2_1 ) )
            // InternalSensinact.g:6305:2: ( rule__DSL_Expression_Unary__ValueAssignment_2_1 )
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getValueAssignment_2_1()); 
            // InternalSensinact.g:6306:2: ( rule__DSL_Expression_Unary__ValueAssignment_2_1 )
            // InternalSensinact.g:6306:3: rule__DSL_Expression_Unary__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_2__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_3__0"
    // InternalSensinact.g:6315:1: rule__DSL_Expression_Unary__Group_3__0 : rule__DSL_Expression_Unary__Group_3__0__Impl rule__DSL_Expression_Unary__Group_3__1 ;
    public final void rule__DSL_Expression_Unary__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6319:1: ( rule__DSL_Expression_Unary__Group_3__0__Impl rule__DSL_Expression_Unary__Group_3__1 )
            // InternalSensinact.g:6320:2: rule__DSL_Expression_Unary__Group_3__0__Impl rule__DSL_Expression_Unary__Group_3__1
            {
            pushFollow(FOLLOW_9);
            rule__DSL_Expression_Unary__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_3__0"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_3__0__Impl"
    // InternalSensinact.g:6327:1: rule__DSL_Expression_Unary__Group_3__0__Impl : ( () ) ;
    public final void rule__DSL_Expression_Unary__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6331:1: ( ( () ) )
            // InternalSensinact.g:6332:1: ( () )
            {
            // InternalSensinact.g:6332:1: ( () )
            // InternalSensinact.g:6333:2: ()
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_RefAction_3_0()); 
            // InternalSensinact.g:6334:2: ()
            // InternalSensinact.g:6334:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_RefAction_3_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_3__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_3__1"
    // InternalSensinact.g:6342:1: rule__DSL_Expression_Unary__Group_3__1 : rule__DSL_Expression_Unary__Group_3__1__Impl rule__DSL_Expression_Unary__Group_3__2 ;
    public final void rule__DSL_Expression_Unary__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6346:1: ( rule__DSL_Expression_Unary__Group_3__1__Impl rule__DSL_Expression_Unary__Group_3__2 )
            // InternalSensinact.g:6347:2: rule__DSL_Expression_Unary__Group_3__1__Impl rule__DSL_Expression_Unary__Group_3__2
            {
            pushFollow(FOLLOW_45);
            rule__DSL_Expression_Unary__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_3__1"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_3__1__Impl"
    // InternalSensinact.g:6354:1: rule__DSL_Expression_Unary__Group_3__1__Impl : ( ( rule__DSL_Expression_Unary__ValueAssignment_3_1 ) ) ;
    public final void rule__DSL_Expression_Unary__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6358:1: ( ( ( rule__DSL_Expression_Unary__ValueAssignment_3_1 ) ) )
            // InternalSensinact.g:6359:1: ( ( rule__DSL_Expression_Unary__ValueAssignment_3_1 ) )
            {
            // InternalSensinact.g:6359:1: ( ( rule__DSL_Expression_Unary__ValueAssignment_3_1 ) )
            // InternalSensinact.g:6360:2: ( rule__DSL_Expression_Unary__ValueAssignment_3_1 )
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getValueAssignment_3_1()); 
            // InternalSensinact.g:6361:2: ( rule__DSL_Expression_Unary__ValueAssignment_3_1 )
            // InternalSensinact.g:6361:3: rule__DSL_Expression_Unary__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__ValueAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getValueAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_3__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_3__2"
    // InternalSensinact.g:6369:1: rule__DSL_Expression_Unary__Group_3__2 : rule__DSL_Expression_Unary__Group_3__2__Impl ;
    public final void rule__DSL_Expression_Unary__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6373:1: ( rule__DSL_Expression_Unary__Group_3__2__Impl )
            // InternalSensinact.g:6374:2: rule__DSL_Expression_Unary__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_3__2"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_3__2__Impl"
    // InternalSensinact.g:6380:1: rule__DSL_Expression_Unary__Group_3__2__Impl : ( '.get()' ) ;
    public final void rule__DSL_Expression_Unary__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6384:1: ( ( '.get()' ) )
            // InternalSensinact.g:6385:1: ( '.get()' )
            {
            // InternalSensinact.g:6385:1: ( '.get()' )
            // InternalSensinact.g:6386:2: '.get()'
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getGetKeyword_3_2()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_UnaryAccess().getGetKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_3__2__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_4__0"
    // InternalSensinact.g:6396:1: rule__DSL_Expression_Unary__Group_4__0 : rule__DSL_Expression_Unary__Group_4__0__Impl rule__DSL_Expression_Unary__Group_4__1 ;
    public final void rule__DSL_Expression_Unary__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6400:1: ( rule__DSL_Expression_Unary__Group_4__0__Impl rule__DSL_Expression_Unary__Group_4__1 )
            // InternalSensinact.g:6401:2: rule__DSL_Expression_Unary__Group_4__0__Impl rule__DSL_Expression_Unary__Group_4__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Unary__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_4__0"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_4__0__Impl"
    // InternalSensinact.g:6408:1: rule__DSL_Expression_Unary__Group_4__0__Impl : ( '(' ) ;
    public final void rule__DSL_Expression_Unary__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6412:1: ( ( '(' ) )
            // InternalSensinact.g:6413:1: ( '(' )
            {
            // InternalSensinact.g:6413:1: ( '(' )
            // InternalSensinact.g:6414:2: '('
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getLeftParenthesisKeyword_4_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_UnaryAccess().getLeftParenthesisKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_4__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_4__1"
    // InternalSensinact.g:6423:1: rule__DSL_Expression_Unary__Group_4__1 : rule__DSL_Expression_Unary__Group_4__1__Impl rule__DSL_Expression_Unary__Group_4__2 ;
    public final void rule__DSL_Expression_Unary__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6427:1: ( rule__DSL_Expression_Unary__Group_4__1__Impl rule__DSL_Expression_Unary__Group_4__2 )
            // InternalSensinact.g:6428:2: rule__DSL_Expression_Unary__Group_4__1__Impl rule__DSL_Expression_Unary__Group_4__2
            {
            pushFollow(FOLLOW_25);
            rule__DSL_Expression_Unary__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_4__1"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_4__1__Impl"
    // InternalSensinact.g:6435:1: rule__DSL_Expression_Unary__Group_4__1__Impl : ( ruleDSL_Expression_Or ) ;
    public final void rule__DSL_Expression_Unary__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6439:1: ( ( ruleDSL_Expression_Or ) )
            // InternalSensinact.g:6440:1: ( ruleDSL_Expression_Or )
            {
            // InternalSensinact.g:6440:1: ( ruleDSL_Expression_Or )
            // InternalSensinact.g:6441:2: ruleDSL_Expression_Or
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Expression_OrParserRuleCall_4_1()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Or();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Expression_OrParserRuleCall_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_4__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_4__2"
    // InternalSensinact.g:6450:1: rule__DSL_Expression_Unary__Group_4__2 : rule__DSL_Expression_Unary__Group_4__2__Impl ;
    public final void rule__DSL_Expression_Unary__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6454:1: ( rule__DSL_Expression_Unary__Group_4__2__Impl )
            // InternalSensinact.g:6455:2: rule__DSL_Expression_Unary__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_4__2"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_4__2__Impl"
    // InternalSensinact.g:6461:1: rule__DSL_Expression_Unary__Group_4__2__Impl : ( ')' ) ;
    public final void rule__DSL_Expression_Unary__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6465:1: ( ( ')' ) )
            // InternalSensinact.g:6466:1: ( ')' )
            {
            // InternalSensinact.g:6466:1: ( ')' )
            // InternalSensinact.g:6467:2: ')'
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getRightParenthesisKeyword_4_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_UnaryAccess().getRightParenthesisKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_4__2__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_5__0"
    // InternalSensinact.g:6477:1: rule__DSL_Expression_Unary__Group_5__0 : rule__DSL_Expression_Unary__Group_5__0__Impl rule__DSL_Expression_Unary__Group_5__1 ;
    public final void rule__DSL_Expression_Unary__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6481:1: ( rule__DSL_Expression_Unary__Group_5__0__Impl rule__DSL_Expression_Unary__Group_5__1 )
            // InternalSensinact.g:6482:2: rule__DSL_Expression_Unary__Group_5__0__Impl rule__DSL_Expression_Unary__Group_5__1
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Unary__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_5__0"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_5__0__Impl"
    // InternalSensinact.g:6489:1: rule__DSL_Expression_Unary__Group_5__0__Impl : ( 'not' ) ;
    public final void rule__DSL_Expression_Unary__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6493:1: ( ( 'not' ) )
            // InternalSensinact.g:6494:1: ( 'not' )
            {
            // InternalSensinact.g:6494:1: ( 'not' )
            // InternalSensinact.g:6495:2: 'not'
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getNotKeyword_5_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_UnaryAccess().getNotKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_5__0__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_5__1"
    // InternalSensinact.g:6504:1: rule__DSL_Expression_Unary__Group_5__1 : rule__DSL_Expression_Unary__Group_5__1__Impl rule__DSL_Expression_Unary__Group_5__2 ;
    public final void rule__DSL_Expression_Unary__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6508:1: ( rule__DSL_Expression_Unary__Group_5__1__Impl rule__DSL_Expression_Unary__Group_5__2 )
            // InternalSensinact.g:6509:2: rule__DSL_Expression_Unary__Group_5__1__Impl rule__DSL_Expression_Unary__Group_5__2
            {
            pushFollow(FOLLOW_18);
            rule__DSL_Expression_Unary__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_5__1"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_5__1__Impl"
    // InternalSensinact.g:6516:1: rule__DSL_Expression_Unary__Group_5__1__Impl : ( () ) ;
    public final void rule__DSL_Expression_Unary__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6520:1: ( ( () ) )
            // InternalSensinact.g:6521:1: ( () )
            {
            // InternalSensinact.g:6521:1: ( () )
            // InternalSensinact.g:6522:2: ()
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Expression_NegateAction_5_1()); 
            // InternalSensinact.g:6523:2: ()
            // InternalSensinact.g:6523:3: 
            {
            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Expression_NegateAction_5_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_5__1__Impl"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_5__2"
    // InternalSensinact.g:6531:1: rule__DSL_Expression_Unary__Group_5__2 : rule__DSL_Expression_Unary__Group_5__2__Impl ;
    public final void rule__DSL_Expression_Unary__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6535:1: ( rule__DSL_Expression_Unary__Group_5__2__Impl )
            // InternalSensinact.g:6536:2: rule__DSL_Expression_Unary__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_5__2"


    // $ANTLR start "rule__DSL_Expression_Unary__Group_5__2__Impl"
    // InternalSensinact.g:6542:1: rule__DSL_Expression_Unary__Group_5__2__Impl : ( ( rule__DSL_Expression_Unary__ExpAssignment_5_2 ) ) ;
    public final void rule__DSL_Expression_Unary__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6546:1: ( ( ( rule__DSL_Expression_Unary__ExpAssignment_5_2 ) ) )
            // InternalSensinact.g:6547:1: ( ( rule__DSL_Expression_Unary__ExpAssignment_5_2 ) )
            {
            // InternalSensinact.g:6547:1: ( ( rule__DSL_Expression_Unary__ExpAssignment_5_2 ) )
            // InternalSensinact.g:6548:2: ( rule__DSL_Expression_Unary__ExpAssignment_5_2 )
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getExpAssignment_5_2()); 
            // InternalSensinact.g:6549:2: ( rule__DSL_Expression_Unary__ExpAssignment_5_2 )
            // InternalSensinact.g:6549:3: rule__DSL_Expression_Unary__ExpAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__DSL_Expression_Unary__ExpAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getExpAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__Group_5__2__Impl"


    // $ANTLR start "rule__Sensinact__EcaAssignment_1"
    // InternalSensinact.g:6558:1: rule__Sensinact__EcaAssignment_1 : ( ruleDSL_SENSINACT ) ;
    public final void rule__Sensinact__EcaAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6562:1: ( ( ruleDSL_SENSINACT ) )
            // InternalSensinact.g:6563:2: ( ruleDSL_SENSINACT )
            {
            // InternalSensinact.g:6563:2: ( ruleDSL_SENSINACT )
            // InternalSensinact.g:6564:3: ruleDSL_SENSINACT
            {
             before(grammarAccess.getSensinactAccess().getEcaDSL_SENSINACTParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_SENSINACT();

            state._fsp--;

             after(grammarAccess.getSensinactAccess().getEcaDSL_SENSINACTParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensinact__EcaAssignment_1"


    // $ANTLR start "rule__DSL_SENSINACT__ResourcesAssignment_0"
    // InternalSensinact.g:6573:1: rule__DSL_SENSINACT__ResourcesAssignment_0 : ( ruleDSL_Resource ) ;
    public final void rule__DSL_SENSINACT__ResourcesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6577:1: ( ( ruleDSL_Resource ) )
            // InternalSensinact.g:6578:2: ( ruleDSL_Resource )
            {
            // InternalSensinact.g:6578:2: ( ruleDSL_Resource )
            // InternalSensinact.g:6579:3: ruleDSL_Resource
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getResourcesDSL_ResourceParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Resource();

            state._fsp--;

             after(grammarAccess.getDSL_SENSINACTAccess().getResourcesDSL_ResourceParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__ResourcesAssignment_0"


    // $ANTLR start "rule__DSL_SENSINACT__CepAssignment_1"
    // InternalSensinact.g:6588:1: rule__DSL_SENSINACT__CepAssignment_1 : ( ruleDSL_CEP_STATEMENT ) ;
    public final void rule__DSL_SENSINACT__CepAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6592:1: ( ( ruleDSL_CEP_STATEMENT ) )
            // InternalSensinact.g:6593:2: ( ruleDSL_CEP_STATEMENT )
            {
            // InternalSensinact.g:6593:2: ( ruleDSL_CEP_STATEMENT )
            // InternalSensinact.g:6594:3: ruleDSL_CEP_STATEMENT
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getCepDSL_CEP_STATEMENTParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_STATEMENT();

            state._fsp--;

             after(grammarAccess.getDSL_SENSINACTAccess().getCepDSL_CEP_STATEMENTParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__CepAssignment_1"


    // $ANTLR start "rule__DSL_SENSINACT__OnAssignment_2"
    // InternalSensinact.g:6603:1: rule__DSL_SENSINACT__OnAssignment_2 : ( ruleDSL_On ) ;
    public final void rule__DSL_SENSINACT__OnAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6607:1: ( ( ruleDSL_On ) )
            // InternalSensinact.g:6608:2: ( ruleDSL_On )
            {
            // InternalSensinact.g:6608:2: ( ruleDSL_On )
            // InternalSensinact.g:6609:3: ruleDSL_On
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getOnDSL_OnParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_On();

            state._fsp--;

             after(grammarAccess.getDSL_SENSINACTAccess().getOnDSL_OnParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__OnAssignment_2"


    // $ANTLR start "rule__DSL_SENSINACT__EcaAssignment_3"
    // InternalSensinact.g:6618:1: rule__DSL_SENSINACT__EcaAssignment_3 : ( ruleDSL_ECA_STATEMENT ) ;
    public final void rule__DSL_SENSINACT__EcaAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6622:1: ( ( ruleDSL_ECA_STATEMENT ) )
            // InternalSensinact.g:6623:2: ( ruleDSL_ECA_STATEMENT )
            {
            // InternalSensinact.g:6623:2: ( ruleDSL_ECA_STATEMENT )
            // InternalSensinact.g:6624:3: ruleDSL_ECA_STATEMENT
            {
             before(grammarAccess.getDSL_SENSINACTAccess().getEcaDSL_ECA_STATEMENTParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_ECA_STATEMENT();

            state._fsp--;

             after(grammarAccess.getDSL_SENSINACTAccess().getEcaDSL_ECA_STATEMENTParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_SENSINACT__EcaAssignment_3"


    // $ANTLR start "rule__DSL_Resource__NameAssignment_1"
    // InternalSensinact.g:6633:1: rule__DSL_Resource__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DSL_Resource__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6637:1: ( ( RULE_ID ) )
            // InternalSensinact.g:6638:2: ( RULE_ID )
            {
            // InternalSensinact.g:6638:2: ( RULE_ID )
            // InternalSensinact.g:6639:3: RULE_ID
            {
             before(grammarAccess.getDSL_ResourceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__NameAssignment_1"


    // $ANTLR start "rule__DSL_Resource__GatewayIDAssignment_4"
    // InternalSensinact.g:6648:1: rule__DSL_Resource__GatewayIDAssignment_4 : ( ruleEXTENDED_ID ) ;
    public final void rule__DSL_Resource__GatewayIDAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6652:1: ( ( ruleEXTENDED_ID ) )
            // InternalSensinact.g:6653:2: ( ruleEXTENDED_ID )
            {
            // InternalSensinact.g:6653:2: ( ruleEXTENDED_ID )
            // InternalSensinact.g:6654:3: ruleEXTENDED_ID
            {
             before(grammarAccess.getDSL_ResourceAccess().getGatewayIDEXTENDED_IDParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEXTENDED_ID();

            state._fsp--;

             after(grammarAccess.getDSL_ResourceAccess().getGatewayIDEXTENDED_IDParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__GatewayIDAssignment_4"


    // $ANTLR start "rule__DSL_Resource__DeviceIDAssignment_6"
    // InternalSensinact.g:6663:1: rule__DSL_Resource__DeviceIDAssignment_6 : ( ruleEXTENDED_ID ) ;
    public final void rule__DSL_Resource__DeviceIDAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6667:1: ( ( ruleEXTENDED_ID ) )
            // InternalSensinact.g:6668:2: ( ruleEXTENDED_ID )
            {
            // InternalSensinact.g:6668:2: ( ruleEXTENDED_ID )
            // InternalSensinact.g:6669:3: ruleEXTENDED_ID
            {
             before(grammarAccess.getDSL_ResourceAccess().getDeviceIDEXTENDED_IDParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleEXTENDED_ID();

            state._fsp--;

             after(grammarAccess.getDSL_ResourceAccess().getDeviceIDEXTENDED_IDParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__DeviceIDAssignment_6"


    // $ANTLR start "rule__DSL_Resource__ServiceIDAssignment_8"
    // InternalSensinact.g:6678:1: rule__DSL_Resource__ServiceIDAssignment_8 : ( ruleEXTENDED_ID ) ;
    public final void rule__DSL_Resource__ServiceIDAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6682:1: ( ( ruleEXTENDED_ID ) )
            // InternalSensinact.g:6683:2: ( ruleEXTENDED_ID )
            {
            // InternalSensinact.g:6683:2: ( ruleEXTENDED_ID )
            // InternalSensinact.g:6684:3: ruleEXTENDED_ID
            {
             before(grammarAccess.getDSL_ResourceAccess().getServiceIDEXTENDED_IDParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleEXTENDED_ID();

            state._fsp--;

             after(grammarAccess.getDSL_ResourceAccess().getServiceIDEXTENDED_IDParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__ServiceIDAssignment_8"


    // $ANTLR start "rule__DSL_Resource__ResourceIDAssignment_10"
    // InternalSensinact.g:6693:1: rule__DSL_Resource__ResourceIDAssignment_10 : ( ruleEXTENDED_ID ) ;
    public final void rule__DSL_Resource__ResourceIDAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6697:1: ( ( ruleEXTENDED_ID ) )
            // InternalSensinact.g:6698:2: ( ruleEXTENDED_ID )
            {
            // InternalSensinact.g:6698:2: ( ruleEXTENDED_ID )
            // InternalSensinact.g:6699:3: ruleEXTENDED_ID
            {
             before(grammarAccess.getDSL_ResourceAccess().getResourceIDEXTENDED_IDParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleEXTENDED_ID();

            state._fsp--;

             after(grammarAccess.getDSL_ResourceAccess().getResourceIDEXTENDED_IDParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Resource__ResourceIDAssignment_10"


    // $ANTLR start "rule__DSL_On__TriggersAssignment_1"
    // InternalSensinact.g:6708:1: rule__DSL_On__TriggersAssignment_1 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_On__TriggersAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6712:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:6713:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:6713:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:6714:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_OnAccess().getTriggersDSL_REF_CONDITIONParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_OnAccess().getTriggersDSL_REF_CONDITIONParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__TriggersAssignment_1"


    // $ANTLR start "rule__DSL_On__TriggersAssignment_2_1"
    // InternalSensinact.g:6723:1: rule__DSL_On__TriggersAssignment_2_1 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_On__TriggersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6727:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:6728:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:6728:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:6729:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_OnAccess().getTriggersDSL_REF_CONDITIONParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_OnAccess().getTriggersDSL_REF_CONDITIONParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_On__TriggersAssignment_2_1"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__IfdoAssignment_0"
    // InternalSensinact.g:6738:1: rule__DSL_ECA_STATEMENT__IfdoAssignment_0 : ( ruleDSL_IfDo ) ;
    public final void rule__DSL_ECA_STATEMENT__IfdoAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6742:1: ( ( ruleDSL_IfDo ) )
            // InternalSensinact.g:6743:2: ( ruleDSL_IfDo )
            {
            // InternalSensinact.g:6743:2: ( ruleDSL_IfDo )
            // InternalSensinact.g:6744:3: ruleDSL_IfDo
            {
             before(grammarAccess.getDSL_ECA_STATEMENTAccess().getIfdoDSL_IfDoParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_IfDo();

            state._fsp--;

             after(grammarAccess.getDSL_ECA_STATEMENTAccess().getIfdoDSL_IfDoParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__IfdoAssignment_0"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1"
    // InternalSensinact.g:6753:1: rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1 : ( ruleDSL_ElseIfDo ) ;
    public final void rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6757:1: ( ( ruleDSL_ElseIfDo ) )
            // InternalSensinact.g:6758:2: ( ruleDSL_ElseIfDo )
            {
            // InternalSensinact.g:6758:2: ( ruleDSL_ElseIfDo )
            // InternalSensinact.g:6759:3: ruleDSL_ElseIfDo
            {
             before(grammarAccess.getDSL_ECA_STATEMENTAccess().getElseIfdoDSL_ElseIfDoParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_ElseIfDo();

            state._fsp--;

             after(grammarAccess.getDSL_ECA_STATEMENTAccess().getElseIfdoDSL_ElseIfDoParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__ElseIfdoAssignment_1"


    // $ANTLR start "rule__DSL_ECA_STATEMENT__ElsedoAssignment_2"
    // InternalSensinact.g:6768:1: rule__DSL_ECA_STATEMENT__ElsedoAssignment_2 : ( ruleDSL_ElseDo ) ;
    public final void rule__DSL_ECA_STATEMENT__ElsedoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6772:1: ( ( ruleDSL_ElseDo ) )
            // InternalSensinact.g:6773:2: ( ruleDSL_ElseDo )
            {
            // InternalSensinact.g:6773:2: ( ruleDSL_ElseDo )
            // InternalSensinact.g:6774:3: ruleDSL_ElseDo
            {
             before(grammarAccess.getDSL_ECA_STATEMENTAccess().getElsedoDSL_ElseDoParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_ElseDo();

            state._fsp--;

             after(grammarAccess.getDSL_ECA_STATEMENTAccess().getElsedoDSL_ElseDoParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ECA_STATEMENT__ElsedoAssignment_2"


    // $ANTLR start "rule__DSL_IfDo__ConditionAssignment_1"
    // InternalSensinact.g:6783:1: rule__DSL_IfDo__ConditionAssignment_1 : ( ruleDSL_Expression_Or ) ;
    public final void rule__DSL_IfDo__ConditionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6787:1: ( ( ruleDSL_Expression_Or ) )
            // InternalSensinact.g:6788:2: ( ruleDSL_Expression_Or )
            {
            // InternalSensinact.g:6788:2: ( ruleDSL_Expression_Or )
            // InternalSensinact.g:6789:3: ruleDSL_Expression_Or
            {
             before(grammarAccess.getDSL_IfDoAccess().getConditionDSL_Expression_OrParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Or();

            state._fsp--;

             after(grammarAccess.getDSL_IfDoAccess().getConditionDSL_Expression_OrParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__ConditionAssignment_1"


    // $ANTLR start "rule__DSL_IfDo__ActionsAssignment_3"
    // InternalSensinact.g:6798:1: rule__DSL_IfDo__ActionsAssignment_3 : ( ruleDSL_ListActions ) ;
    public final void rule__DSL_IfDo__ActionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6802:1: ( ( ruleDSL_ListActions ) )
            // InternalSensinact.g:6803:2: ( ruleDSL_ListActions )
            {
            // InternalSensinact.g:6803:2: ( ruleDSL_ListActions )
            // InternalSensinact.g:6804:3: ruleDSL_ListActions
            {
             before(grammarAccess.getDSL_IfDoAccess().getActionsDSL_ListActionsParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_ListActions();

            state._fsp--;

             after(grammarAccess.getDSL_IfDoAccess().getActionsDSL_ListActionsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_IfDo__ActionsAssignment_3"


    // $ANTLR start "rule__DSL_ElseIfDo__ConditionAssignment_1"
    // InternalSensinact.g:6813:1: rule__DSL_ElseIfDo__ConditionAssignment_1 : ( ruleDSL_Expression_Or ) ;
    public final void rule__DSL_ElseIfDo__ConditionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6817:1: ( ( ruleDSL_Expression_Or ) )
            // InternalSensinact.g:6818:2: ( ruleDSL_Expression_Or )
            {
            // InternalSensinact.g:6818:2: ( ruleDSL_Expression_Or )
            // InternalSensinact.g:6819:3: ruleDSL_Expression_Or
            {
             before(grammarAccess.getDSL_ElseIfDoAccess().getConditionDSL_Expression_OrParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Or();

            state._fsp--;

             after(grammarAccess.getDSL_ElseIfDoAccess().getConditionDSL_Expression_OrParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__ConditionAssignment_1"


    // $ANTLR start "rule__DSL_ElseIfDo__ActionsAssignment_3"
    // InternalSensinact.g:6828:1: rule__DSL_ElseIfDo__ActionsAssignment_3 : ( ruleDSL_ListActions ) ;
    public final void rule__DSL_ElseIfDo__ActionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6832:1: ( ( ruleDSL_ListActions ) )
            // InternalSensinact.g:6833:2: ( ruleDSL_ListActions )
            {
            // InternalSensinact.g:6833:2: ( ruleDSL_ListActions )
            // InternalSensinact.g:6834:3: ruleDSL_ListActions
            {
             before(grammarAccess.getDSL_ElseIfDoAccess().getActionsDSL_ListActionsParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_ListActions();

            state._fsp--;

             after(grammarAccess.getDSL_ElseIfDoAccess().getActionsDSL_ListActionsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseIfDo__ActionsAssignment_3"


    // $ANTLR start "rule__DSL_ElseDo__ActionsAssignment_1"
    // InternalSensinact.g:6843:1: rule__DSL_ElseDo__ActionsAssignment_1 : ( ruleDSL_ListActions ) ;
    public final void rule__DSL_ElseDo__ActionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6847:1: ( ( ruleDSL_ListActions ) )
            // InternalSensinact.g:6848:2: ( ruleDSL_ListActions )
            {
            // InternalSensinact.g:6848:2: ( ruleDSL_ListActions )
            // InternalSensinact.g:6849:3: ruleDSL_ListActions
            {
             before(grammarAccess.getDSL_ElseDoAccess().getActionsDSL_ListActionsParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_ListActions();

            state._fsp--;

             after(grammarAccess.getDSL_ElseDoAccess().getActionsDSL_ListActionsParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ElseDo__ActionsAssignment_1"


    // $ANTLR start "rule__DSL_REF_CONDITION__RefAssignment_0"
    // InternalSensinact.g:6858:1: rule__DSL_REF_CONDITION__RefAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__DSL_REF_CONDITION__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6862:1: ( ( ( RULE_ID ) ) )
            // InternalSensinact.g:6863:2: ( ( RULE_ID ) )
            {
            // InternalSensinact.g:6863:2: ( ( RULE_ID ) )
            // InternalSensinact.g:6864:3: ( RULE_ID )
            {
             before(grammarAccess.getDSL_REF_CONDITIONAccess().getRefDSL_REFCrossReference_0_0()); 
            // InternalSensinact.g:6865:3: ( RULE_ID )
            // InternalSensinact.g:6866:4: RULE_ID
            {
             before(grammarAccess.getDSL_REF_CONDITIONAccess().getRefDSL_REFIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDSL_REF_CONDITIONAccess().getRefDSL_REFIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getDSL_REF_CONDITIONAccess().getRefDSL_REFCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_REF_CONDITION__RefAssignment_0"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__NameAssignment_1"
    // InternalSensinact.g:6877:1: rule__DSL_CEP_STATEMENT__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DSL_CEP_STATEMENT__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6881:1: ( ( RULE_ID ) )
            // InternalSensinact.g:6882:2: ( RULE_ID )
            {
            // InternalSensinact.g:6882:2: ( RULE_ID )
            // InternalSensinact.g:6883:3: RULE_ID
            {
             before(grammarAccess.getDSL_CEP_STATEMENTAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDSL_CEP_STATEMENTAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__NameAssignment_1"


    // $ANTLR start "rule__DSL_CEP_STATEMENT__OperationAssignment_3"
    // InternalSensinact.g:6892:1: rule__DSL_CEP_STATEMENT__OperationAssignment_3 : ( ( rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0 ) ) ;
    public final void rule__DSL_CEP_STATEMENT__OperationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6896:1: ( ( ( rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0 ) ) )
            // InternalSensinact.g:6897:2: ( ( rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0 ) )
            {
            // InternalSensinact.g:6897:2: ( ( rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0 ) )
            // InternalSensinact.g:6898:3: ( rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0 )
            {
             before(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationAlternatives_3_0()); 
            // InternalSensinact.g:6899:3: ( rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0 )
            // InternalSensinact.g:6899:4: rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_STATEMENT__OperationAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_STATEMENT__OperationAssignment_3"


    // $ANTLR start "rule__DSL_CEP_AFTER__Ref1Assignment_2"
    // InternalSensinact.g:6907:1: rule__DSL_CEP_AFTER__Ref1Assignment_2 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_AFTER__Ref1Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6911:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:6912:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:6912:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:6913:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getRef1DSL_REF_CONDITIONParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_AFTERAccess().getRef1DSL_REF_CONDITIONParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Ref1Assignment_2"


    // $ANTLR start "rule__DSL_CEP_AFTER__Ref2Assignment_4"
    // InternalSensinact.g:6922:1: rule__DSL_CEP_AFTER__Ref2Assignment_4 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_AFTER__Ref2Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6926:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:6927:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:6927:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:6928:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getRef2DSL_REF_CONDITIONParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_AFTERAccess().getRef2DSL_REF_CONDITIONParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__Ref2Assignment_4"


    // $ANTLR start "rule__DSL_CEP_AFTER__StartAssignment_6_0"
    // InternalSensinact.g:6937:1: rule__DSL_CEP_AFTER__StartAssignment_6_0 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_AFTER__StartAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6941:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:6942:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:6942:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:6943:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getStartDSL_CEP_DURATIONParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_AFTERAccess().getStartDSL_CEP_DURATIONParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__StartAssignment_6_0"


    // $ANTLR start "rule__DSL_CEP_AFTER__EndAssignment_7"
    // InternalSensinact.g:6952:1: rule__DSL_CEP_AFTER__EndAssignment_7 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_AFTER__EndAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6956:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:6957:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:6957:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:6958:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_AFTERAccess().getEndDSL_CEP_DURATIONParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_AFTERAccess().getEndDSL_CEP_DURATIONParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AFTER__EndAssignment_7"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Ref1Assignment_2"
    // InternalSensinact.g:6967:1: rule__DSL_CEP_BEFORE__Ref1Assignment_2 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_BEFORE__Ref1Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6971:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:6972:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:6972:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:6973:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getRef1DSL_REF_CONDITIONParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getRef1DSL_REF_CONDITIONParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Ref1Assignment_2"


    // $ANTLR start "rule__DSL_CEP_BEFORE__Ref2Assignment_4"
    // InternalSensinact.g:6982:1: rule__DSL_CEP_BEFORE__Ref2Assignment_4 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_BEFORE__Ref2Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:6986:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:6987:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:6987:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:6988:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getRef2DSL_REF_CONDITIONParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getRef2DSL_REF_CONDITIONParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__Ref2Assignment_4"


    // $ANTLR start "rule__DSL_CEP_BEFORE__StartAssignment_6_0"
    // InternalSensinact.g:6997:1: rule__DSL_CEP_BEFORE__StartAssignment_6_0 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_BEFORE__StartAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7001:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:7002:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:7002:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:7003:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getStartDSL_CEP_DURATIONParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getStartDSL_CEP_DURATIONParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__StartAssignment_6_0"


    // $ANTLR start "rule__DSL_CEP_BEFORE__EndAssignment_7"
    // InternalSensinact.g:7012:1: rule__DSL_CEP_BEFORE__EndAssignment_7 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_BEFORE__EndAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7016:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:7017:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:7017:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:7018:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_BEFOREAccess().getEndDSL_CEP_DURATIONParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_BEFOREAccess().getEndDSL_CEP_DURATIONParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_BEFORE__EndAssignment_7"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Ref1Assignment_2"
    // InternalSensinact.g:7027:1: rule__DSL_CEP_COINCIDE__Ref1Assignment_2 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_COINCIDE__Ref1Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7031:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:7032:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:7032:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:7033:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef1DSL_REF_CONDITIONParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef1DSL_REF_CONDITIONParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Ref1Assignment_2"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__Ref2Assignment_4"
    // InternalSensinact.g:7042:1: rule__DSL_CEP_COINCIDE__Ref2Assignment_4 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_COINCIDE__Ref2Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7046:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:7047:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:7047:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:7048:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef2DSL_REF_CONDITIONParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef2DSL_REF_CONDITIONParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__Ref2Assignment_4"


    // $ANTLR start "rule__DSL_CEP_COINCIDE__WindowAssignment_6"
    // InternalSensinact.g:7057:1: rule__DSL_CEP_COINCIDE__WindowAssignment_6 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_COINCIDE__WindowAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7061:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:7062:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:7062:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:7063:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_COINCIDEAccess().getWindowDSL_CEP_DURATIONParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_COINCIDEAccess().getWindowDSL_CEP_DURATIONParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COINCIDE__WindowAssignment_6"


    // $ANTLR start "rule__DSL_CEP_MIN__RefAssignment_2"
    // InternalSensinact.g:7072:1: rule__DSL_CEP_MIN__RefAssignment_2 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_MIN__RefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7076:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:7077:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:7077:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:7078:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_MINAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_MINAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__RefAssignment_2"


    // $ANTLR start "rule__DSL_CEP_MIN__WindowAssignment_4"
    // InternalSensinact.g:7087:1: rule__DSL_CEP_MIN__WindowAssignment_4 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_MIN__WindowAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7091:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:7092:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:7092:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:7093:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_MINAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_MINAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MIN__WindowAssignment_4"


    // $ANTLR start "rule__DSL_CEP_MAX__RefAssignment_2"
    // InternalSensinact.g:7102:1: rule__DSL_CEP_MAX__RefAssignment_2 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_MAX__RefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7106:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:7107:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:7107:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:7108:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_MAXAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_MAXAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__RefAssignment_2"


    // $ANTLR start "rule__DSL_CEP_MAX__WindowAssignment_4"
    // InternalSensinact.g:7117:1: rule__DSL_CEP_MAX__WindowAssignment_4 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_MAX__WindowAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7121:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:7122:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:7122:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:7123:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_MAXAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_MAXAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_MAX__WindowAssignment_4"


    // $ANTLR start "rule__DSL_CEP_AVG__RefAssignment_2"
    // InternalSensinact.g:7132:1: rule__DSL_CEP_AVG__RefAssignment_2 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_AVG__RefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7136:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:7137:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:7137:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:7138:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_AVGAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_AVGAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__RefAssignment_2"


    // $ANTLR start "rule__DSL_CEP_AVG__WindowAssignment_4"
    // InternalSensinact.g:7147:1: rule__DSL_CEP_AVG__WindowAssignment_4 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_AVG__WindowAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7151:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:7152:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:7152:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:7153:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_AVGAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_AVGAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_AVG__WindowAssignment_4"


    // $ANTLR start "rule__DSL_CEP_SUM__RefAssignment_2"
    // InternalSensinact.g:7162:1: rule__DSL_CEP_SUM__RefAssignment_2 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_SUM__RefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7166:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:7167:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:7167:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:7168:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_SUMAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_SUMAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__RefAssignment_2"


    // $ANTLR start "rule__DSL_CEP_SUM__WindowAssignment_4"
    // InternalSensinact.g:7177:1: rule__DSL_CEP_SUM__WindowAssignment_4 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_SUM__WindowAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7181:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:7182:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:7182:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:7183:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_SUMAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_SUMAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_SUM__WindowAssignment_4"


    // $ANTLR start "rule__DSL_CEP_COUNT__RefAssignment_2"
    // InternalSensinact.g:7192:1: rule__DSL_CEP_COUNT__RefAssignment_2 : ( ruleDSL_REF_CONDITION ) ;
    public final void rule__DSL_CEP_COUNT__RefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7196:1: ( ( ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:7197:2: ( ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:7197:2: ( ruleDSL_REF_CONDITION )
            // InternalSensinact.g:7198:3: ruleDSL_REF_CONDITION
            {
             before(grammarAccess.getDSL_CEP_COUNTAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_REF_CONDITION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_COUNTAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__RefAssignment_2"


    // $ANTLR start "rule__DSL_CEP_COUNT__WindowAssignment_4"
    // InternalSensinact.g:7207:1: rule__DSL_CEP_COUNT__WindowAssignment_4 : ( ruleDSL_CEP_DURATION ) ;
    public final void rule__DSL_CEP_COUNT__WindowAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7211:1: ( ( ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:7212:2: ( ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:7212:2: ( ruleDSL_CEP_DURATION )
            // InternalSensinact.g:7213:3: ruleDSL_CEP_DURATION
            {
             before(grammarAccess.getDSL_CEP_COUNTAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_CEP_DURATION();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_COUNTAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_COUNT__WindowAssignment_4"


    // $ANTLR start "rule__DSL_CEP_DURATION__UnitsAssignment"
    // InternalSensinact.g:7222:1: rule__DSL_CEP_DURATION__UnitsAssignment : ( ( rule__DSL_CEP_DURATION__UnitsAlternatives_0 ) ) ;
    public final void rule__DSL_CEP_DURATION__UnitsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7226:1: ( ( ( rule__DSL_CEP_DURATION__UnitsAlternatives_0 ) ) )
            // InternalSensinact.g:7227:2: ( ( rule__DSL_CEP_DURATION__UnitsAlternatives_0 ) )
            {
            // InternalSensinact.g:7227:2: ( ( rule__DSL_CEP_DURATION__UnitsAlternatives_0 ) )
            // InternalSensinact.g:7228:3: ( rule__DSL_CEP_DURATION__UnitsAlternatives_0 )
            {
             before(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsAlternatives_0()); 
            // InternalSensinact.g:7229:3: ( rule__DSL_CEP_DURATION__UnitsAlternatives_0 )
            // InternalSensinact.g:7229:4: rule__DSL_CEP_DURATION__UnitsAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_CEP_DURATION__UnitsAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION__UnitsAssignment"


    // $ANTLR start "rule__DSL_CEP_DURATION_MIN__MinAssignment_0"
    // InternalSensinact.g:7237:1: rule__DSL_CEP_DURATION_MIN__MinAssignment_0 : ( ruleNUMBER ) ;
    public final void rule__DSL_CEP_DURATION_MIN__MinAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7241:1: ( ( ruleNUMBER ) )
            // InternalSensinact.g:7242:2: ( ruleNUMBER )
            {
            // InternalSensinact.g:7242:2: ( ruleNUMBER )
            // InternalSensinact.g:7243:3: ruleNUMBER
            {
             before(grammarAccess.getDSL_CEP_DURATION_MINAccess().getMinNUMBERParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNUMBER();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_DURATION_MINAccess().getMinNUMBERParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_MIN__MinAssignment_0"


    // $ANTLR start "rule__DSL_CEP_DURATION_SEC__SecAssignment_0"
    // InternalSensinact.g:7252:1: rule__DSL_CEP_DURATION_SEC__SecAssignment_0 : ( ruleNUMBER ) ;
    public final void rule__DSL_CEP_DURATION_SEC__SecAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7256:1: ( ( ruleNUMBER ) )
            // InternalSensinact.g:7257:2: ( ruleNUMBER )
            {
            // InternalSensinact.g:7257:2: ( ruleNUMBER )
            // InternalSensinact.g:7258:3: ruleNUMBER
            {
             before(grammarAccess.getDSL_CEP_DURATION_SECAccess().getSecNUMBERParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNUMBER();

            state._fsp--;

             after(grammarAccess.getDSL_CEP_DURATION_SECAccess().getSecNUMBERParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_CEP_DURATION_SEC__SecAssignment_0"


    // $ANTLR start "rule__DSL_ListActions__ActionListAssignment_0"
    // InternalSensinact.g:7267:1: rule__DSL_ListActions__ActionListAssignment_0 : ( ruleDSL_ResourceAction ) ;
    public final void rule__DSL_ListActions__ActionListAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7271:1: ( ( ruleDSL_ResourceAction ) )
            // InternalSensinact.g:7272:2: ( ruleDSL_ResourceAction )
            {
            // InternalSensinact.g:7272:2: ( ruleDSL_ResourceAction )
            // InternalSensinact.g:7273:3: ruleDSL_ResourceAction
            {
             before(grammarAccess.getDSL_ListActionsAccess().getActionListDSL_ResourceActionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_ResourceAction();

            state._fsp--;

             after(grammarAccess.getDSL_ListActionsAccess().getActionListDSL_ResourceActionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__ActionListAssignment_0"


    // $ANTLR start "rule__DSL_ListActions__ActionListAssignment_1_1"
    // InternalSensinact.g:7282:1: rule__DSL_ListActions__ActionListAssignment_1_1 : ( ruleDSL_ResourceAction ) ;
    public final void rule__DSL_ListActions__ActionListAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7286:1: ( ( ruleDSL_ResourceAction ) )
            // InternalSensinact.g:7287:2: ( ruleDSL_ResourceAction )
            {
            // InternalSensinact.g:7287:2: ( ruleDSL_ResourceAction )
            // InternalSensinact.g:7288:3: ruleDSL_ResourceAction
            {
             before(grammarAccess.getDSL_ListActionsAccess().getActionListDSL_ResourceActionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_ResourceAction();

            state._fsp--;

             after(grammarAccess.getDSL_ListActionsAccess().getActionListDSL_ResourceActionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListActions__ActionListAssignment_1_1"


    // $ANTLR start "rule__DSL_ResourceAction__VariableAssignment_0_0"
    // InternalSensinact.g:7297:1: rule__DSL_ResourceAction__VariableAssignment_0_0 : ( RULE_ID ) ;
    public final void rule__DSL_ResourceAction__VariableAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7301:1: ( ( RULE_ID ) )
            // InternalSensinact.g:7302:2: ( RULE_ID )
            {
            // InternalSensinact.g:7302:2: ( RULE_ID )
            // InternalSensinact.g:7303:3: RULE_ID
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getVariableIDTerminalRuleCall_0_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceActionAccess().getVariableIDTerminalRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__VariableAssignment_0_0"


    // $ANTLR start "rule__DSL_ResourceAction__RefAssignment_1"
    // InternalSensinact.g:7312:1: rule__DSL_ResourceAction__RefAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DSL_ResourceAction__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7316:1: ( ( ( RULE_ID ) ) )
            // InternalSensinact.g:7317:2: ( ( RULE_ID ) )
            {
            // InternalSensinact.g:7317:2: ( ( RULE_ID ) )
            // InternalSensinact.g:7318:3: ( RULE_ID )
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getRefDSL_REFCrossReference_1_0()); 
            // InternalSensinact.g:7319:3: ( RULE_ID )
            // InternalSensinact.g:7320:4: RULE_ID
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getRefDSL_REFIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDSL_ResourceActionAccess().getRefDSL_REFIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getDSL_ResourceActionAccess().getRefDSL_REFCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__RefAssignment_1"


    // $ANTLR start "rule__DSL_ResourceAction__ActiontypeAssignment_3"
    // InternalSensinact.g:7331:1: rule__DSL_ResourceAction__ActiontypeAssignment_3 : ( ( rule__DSL_ResourceAction__ActiontypeAlternatives_3_0 ) ) ;
    public final void rule__DSL_ResourceAction__ActiontypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7335:1: ( ( ( rule__DSL_ResourceAction__ActiontypeAlternatives_3_0 ) ) )
            // InternalSensinact.g:7336:2: ( ( rule__DSL_ResourceAction__ActiontypeAlternatives_3_0 ) )
            {
            // InternalSensinact.g:7336:2: ( ( rule__DSL_ResourceAction__ActiontypeAlternatives_3_0 ) )
            // InternalSensinact.g:7337:3: ( rule__DSL_ResourceAction__ActiontypeAlternatives_3_0 )
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getActiontypeAlternatives_3_0()); 
            // InternalSensinact.g:7338:3: ( rule__DSL_ResourceAction__ActiontypeAlternatives_3_0 )
            // InternalSensinact.g:7338:4: rule__DSL_ResourceAction__ActiontypeAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__DSL_ResourceAction__ActiontypeAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getDSL_ResourceActionAccess().getActiontypeAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__ActiontypeAssignment_3"


    // $ANTLR start "rule__DSL_ResourceAction__ListParamAssignment_5"
    // InternalSensinact.g:7346:1: rule__DSL_ResourceAction__ListParamAssignment_5 : ( ruleDSL_ListParam ) ;
    public final void rule__DSL_ResourceAction__ListParamAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7350:1: ( ( ruleDSL_ListParam ) )
            // InternalSensinact.g:7351:2: ( ruleDSL_ListParam )
            {
            // InternalSensinact.g:7351:2: ( ruleDSL_ListParam )
            // InternalSensinact.g:7352:3: ruleDSL_ListParam
            {
             before(grammarAccess.getDSL_ResourceActionAccess().getListParamDSL_ListParamParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_ListParam();

            state._fsp--;

             after(grammarAccess.getDSL_ResourceActionAccess().getListParamDSL_ListParamParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ResourceAction__ListParamAssignment_5"


    // $ANTLR start "rule__DSL_ListParam__ParamAssignment_0"
    // InternalSensinact.g:7361:1: rule__DSL_ListParam__ParamAssignment_0 : ( ruleDSL_Expression_Or ) ;
    public final void rule__DSL_ListParam__ParamAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7365:1: ( ( ruleDSL_Expression_Or ) )
            // InternalSensinact.g:7366:2: ( ruleDSL_Expression_Or )
            {
            // InternalSensinact.g:7366:2: ( ruleDSL_Expression_Or )
            // InternalSensinact.g:7367:3: ruleDSL_Expression_Or
            {
             before(grammarAccess.getDSL_ListParamAccess().getParamDSL_Expression_OrParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Or();

            state._fsp--;

             after(grammarAccess.getDSL_ListParamAccess().getParamDSL_Expression_OrParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__ParamAssignment_0"


    // $ANTLR start "rule__DSL_ListParam__ParamAssignment_1_1"
    // InternalSensinact.g:7376:1: rule__DSL_ListParam__ParamAssignment_1_1 : ( ruleDSL_Expression_Or ) ;
    public final void rule__DSL_ListParam__ParamAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7380:1: ( ( ruleDSL_Expression_Or ) )
            // InternalSensinact.g:7381:2: ( ruleDSL_Expression_Or )
            {
            // InternalSensinact.g:7381:2: ( ruleDSL_Expression_Or )
            // InternalSensinact.g:7382:3: ruleDSL_Expression_Or
            {
             before(grammarAccess.getDSL_ListParamAccess().getParamDSL_Expression_OrParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Or();

            state._fsp--;

             after(grammarAccess.getDSL_ListParamAccess().getParamDSL_Expression_OrParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_ListParam__ParamAssignment_1_1"


    // $ANTLR start "rule__DSL_Expression_Or__RightAssignment_1_2"
    // InternalSensinact.g:7391:1: rule__DSL_Expression_Or__RightAssignment_1_2 : ( ruleDSL_Expression_And ) ;
    public final void rule__DSL_Expression_Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7395:1: ( ( ruleDSL_Expression_And ) )
            // InternalSensinact.g:7396:2: ( ruleDSL_Expression_And )
            {
            // InternalSensinact.g:7396:2: ( ruleDSL_Expression_And )
            // InternalSensinact.g:7397:3: ruleDSL_Expression_And
            {
             before(grammarAccess.getDSL_Expression_OrAccess().getRightDSL_Expression_AndParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_And();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_OrAccess().getRightDSL_Expression_AndParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Or__RightAssignment_1_2"


    // $ANTLR start "rule__DSL_Expression_And__RightAssignment_1_2"
    // InternalSensinact.g:7406:1: rule__DSL_Expression_And__RightAssignment_1_2 : ( ruleDSL_Expression_DiffEqual ) ;
    public final void rule__DSL_Expression_And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7410:1: ( ( ruleDSL_Expression_DiffEqual ) )
            // InternalSensinact.g:7411:2: ( ruleDSL_Expression_DiffEqual )
            {
            // InternalSensinact.g:7411:2: ( ruleDSL_Expression_DiffEqual )
            // InternalSensinact.g:7412:3: ruleDSL_Expression_DiffEqual
            {
             before(grammarAccess.getDSL_Expression_AndAccess().getRightDSL_Expression_DiffEqualParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_DiffEqual();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_AndAccess().getRightDSL_Expression_DiffEqualParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_And__RightAssignment_1_2"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2"
    // InternalSensinact.g:7421:1: rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2 : ( ruleDSL_Expression_Compare ) ;
    public final void rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7425:1: ( ( ruleDSL_Expression_Compare ) )
            // InternalSensinact.g:7426:2: ( ruleDSL_Expression_Compare )
            {
            // InternalSensinact.g:7426:2: ( ruleDSL_Expression_Compare )
            // InternalSensinact.g:7427:3: ruleDSL_Expression_Compare
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightDSL_Expression_CompareParserRuleCall_1_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Compare();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightDSL_Expression_CompareParserRuleCall_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__RightAssignment_1_0_2"


    // $ANTLR start "rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2"
    // InternalSensinact.g:7436:1: rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2 : ( ruleDSL_Expression_Compare ) ;
    public final void rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7440:1: ( ( ruleDSL_Expression_Compare ) )
            // InternalSensinact.g:7441:2: ( ruleDSL_Expression_Compare )
            {
            // InternalSensinact.g:7441:2: ( ruleDSL_Expression_Compare )
            // InternalSensinact.g:7442:3: ruleDSL_Expression_Compare
            {
             before(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightDSL_Expression_CompareParserRuleCall_1_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Compare();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightDSL_Expression_CompareParserRuleCall_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_DiffEqual__RightAssignment_1_1_2"


    // $ANTLR start "rule__DSL_Expression_Compare__RightAssignment_1_0_2"
    // InternalSensinact.g:7451:1: rule__DSL_Expression_Compare__RightAssignment_1_0_2 : ( ruleDSL_Expression_PlusMinus ) ;
    public final void rule__DSL_Expression_Compare__RightAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7455:1: ( ( ruleDSL_Expression_PlusMinus ) )
            // InternalSensinact.g:7456:2: ( ruleDSL_Expression_PlusMinus )
            {
            // InternalSensinact.g:7456:2: ( ruleDSL_Expression_PlusMinus )
            // InternalSensinact.g:7457:3: ruleDSL_Expression_PlusMinus
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_PlusMinus();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__RightAssignment_1_0_2"


    // $ANTLR start "rule__DSL_Expression_Compare__RightAssignment_1_1_2"
    // InternalSensinact.g:7466:1: rule__DSL_Expression_Compare__RightAssignment_1_1_2 : ( ruleDSL_Expression_PlusMinus ) ;
    public final void rule__DSL_Expression_Compare__RightAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7470:1: ( ( ruleDSL_Expression_PlusMinus ) )
            // InternalSensinact.g:7471:2: ( ruleDSL_Expression_PlusMinus )
            {
            // InternalSensinact.g:7471:2: ( ruleDSL_Expression_PlusMinus )
            // InternalSensinact.g:7472:3: ruleDSL_Expression_PlusMinus
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_PlusMinus();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__RightAssignment_1_1_2"


    // $ANTLR start "rule__DSL_Expression_Compare__RightAssignment_1_2_2"
    // InternalSensinact.g:7481:1: rule__DSL_Expression_Compare__RightAssignment_1_2_2 : ( ruleDSL_Expression_PlusMinus ) ;
    public final void rule__DSL_Expression_Compare__RightAssignment_1_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7485:1: ( ( ruleDSL_Expression_PlusMinus ) )
            // InternalSensinact.g:7486:2: ( ruleDSL_Expression_PlusMinus )
            {
            // InternalSensinact.g:7486:2: ( ruleDSL_Expression_PlusMinus )
            // InternalSensinact.g:7487:3: ruleDSL_Expression_PlusMinus
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_PlusMinus();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__RightAssignment_1_2_2"


    // $ANTLR start "rule__DSL_Expression_Compare__RightAssignment_1_3_2"
    // InternalSensinact.g:7496:1: rule__DSL_Expression_Compare__RightAssignment_1_3_2 : ( ruleDSL_Expression_PlusMinus ) ;
    public final void rule__DSL_Expression_Compare__RightAssignment_1_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7500:1: ( ( ruleDSL_Expression_PlusMinus ) )
            // InternalSensinact.g:7501:2: ( ruleDSL_Expression_PlusMinus )
            {
            // InternalSensinact.g:7501:2: ( ruleDSL_Expression_PlusMinus )
            // InternalSensinact.g:7502:3: ruleDSL_Expression_PlusMinus
            {
             before(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_PlusMinus();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Compare__RightAssignment_1_3_2"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2"
    // InternalSensinact.g:7511:1: rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2 : ( ruleDSL_Expression_MultiplicationDivision ) ;
    public final void rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7515:1: ( ( ruleDSL_Expression_MultiplicationDivision ) )
            // InternalSensinact.g:7516:2: ( ruleDSL_Expression_MultiplicationDivision )
            {
            // InternalSensinact.g:7516:2: ( ruleDSL_Expression_MultiplicationDivision )
            // InternalSensinact.g:7517:3: ruleDSL_Expression_MultiplicationDivision
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightDSL_Expression_MultiplicationDivisionParserRuleCall_1_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_MultiplicationDivision();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightDSL_Expression_MultiplicationDivisionParserRuleCall_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__RightAssignment_1_0_2"


    // $ANTLR start "rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2"
    // InternalSensinact.g:7526:1: rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2 : ( ruleDSL_Expression_MultiplicationDivision ) ;
    public final void rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7530:1: ( ( ruleDSL_Expression_MultiplicationDivision ) )
            // InternalSensinact.g:7531:2: ( ruleDSL_Expression_MultiplicationDivision )
            {
            // InternalSensinact.g:7531:2: ( ruleDSL_Expression_MultiplicationDivision )
            // InternalSensinact.g:7532:3: ruleDSL_Expression_MultiplicationDivision
            {
             before(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightDSL_Expression_MultiplicationDivisionParserRuleCall_1_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_MultiplicationDivision();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightDSL_Expression_MultiplicationDivisionParserRuleCall_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_PlusMinus__RightAssignment_1_1_2"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2"
    // InternalSensinact.g:7541:1: rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2 : ( ruleDSL_Expression_Unary ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7545:1: ( ( ruleDSL_Expression_Unary ) )
            // InternalSensinact.g:7546:2: ( ruleDSL_Expression_Unary )
            {
            // InternalSensinact.g:7546:2: ( ruleDSL_Expression_Unary )
            // InternalSensinact.g:7547:3: ruleDSL_Expression_Unary
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightDSL_Expression_UnaryParserRuleCall_1_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Unary();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightDSL_Expression_UnaryParserRuleCall_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_0_2"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2"
    // InternalSensinact.g:7556:1: rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2 : ( ruleDSL_Expression_Unary ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7560:1: ( ( ruleDSL_Expression_Unary ) )
            // InternalSensinact.g:7561:2: ( ruleDSL_Expression_Unary )
            {
            // InternalSensinact.g:7561:2: ( ruleDSL_Expression_Unary )
            // InternalSensinact.g:7562:3: ruleDSL_Expression_Unary
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightDSL_Expression_UnaryParserRuleCall_1_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Unary();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightDSL_Expression_UnaryParserRuleCall_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_1_2"


    // $ANTLR start "rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2"
    // InternalSensinact.g:7571:1: rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2 : ( ruleDSL_Expression_Unary ) ;
    public final void rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7575:1: ( ( ruleDSL_Expression_Unary ) )
            // InternalSensinact.g:7576:2: ( ruleDSL_Expression_Unary )
            {
            // InternalSensinact.g:7576:2: ( ruleDSL_Expression_Unary )
            // InternalSensinact.g:7577:3: ruleDSL_Expression_Unary
            {
             before(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightDSL_Expression_UnaryParserRuleCall_1_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Unary();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightDSL_Expression_UnaryParserRuleCall_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_MultiplicationDivision__RightAssignment_1_2_2"


    // $ANTLR start "rule__DSL_Expression_Unary__ValueAssignment_0_1"
    // InternalSensinact.g:7586:1: rule__DSL_Expression_Unary__ValueAssignment_0_1 : ( ruleNUMBER ) ;
    public final void rule__DSL_Expression_Unary__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7590:1: ( ( ruleNUMBER ) )
            // InternalSensinact.g:7591:2: ( ruleNUMBER )
            {
            // InternalSensinact.g:7591:2: ( ruleNUMBER )
            // InternalSensinact.g:7592:3: ruleNUMBER
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getValueNUMBERParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleNUMBER();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_UnaryAccess().getValueNUMBERParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__ValueAssignment_0_1"


    // $ANTLR start "rule__DSL_Expression_Unary__ValueAssignment_1_1"
    // InternalSensinact.g:7601:1: rule__DSL_Expression_Unary__ValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__DSL_Expression_Unary__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7605:1: ( ( RULE_STRING ) )
            // InternalSensinact.g:7606:2: ( RULE_STRING )
            {
            // InternalSensinact.g:7606:2: ( RULE_STRING )
            // InternalSensinact.g:7607:3: RULE_STRING
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_UnaryAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__ValueAssignment_1_1"


    // $ANTLR start "rule__DSL_Expression_Unary__ValueAssignment_2_1"
    // InternalSensinact.g:7616:1: rule__DSL_Expression_Unary__ValueAssignment_2_1 : ( RULE_BOOLEAN ) ;
    public final void rule__DSL_Expression_Unary__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7620:1: ( ( RULE_BOOLEAN ) )
            // InternalSensinact.g:7621:2: ( RULE_BOOLEAN )
            {
            // InternalSensinact.g:7621:2: ( RULE_BOOLEAN )
            // InternalSensinact.g:7622:3: RULE_BOOLEAN
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getValueBOOLEANTerminalRuleCall_2_1_0()); 
            match(input,RULE_BOOLEAN,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_UnaryAccess().getValueBOOLEANTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__ValueAssignment_2_1"


    // $ANTLR start "rule__DSL_Expression_Unary__ValueAssignment_3_1"
    // InternalSensinact.g:7631:1: rule__DSL_Expression_Unary__ValueAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__DSL_Expression_Unary__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7635:1: ( ( ( RULE_ID ) ) )
            // InternalSensinact.g:7636:2: ( ( RULE_ID ) )
            {
            // InternalSensinact.g:7636:2: ( ( RULE_ID ) )
            // InternalSensinact.g:7637:3: ( RULE_ID )
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getValueDSL_REFCrossReference_3_1_0()); 
            // InternalSensinact.g:7638:3: ( RULE_ID )
            // InternalSensinact.g:7639:4: RULE_ID
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getValueDSL_REFIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDSL_Expression_UnaryAccess().getValueDSL_REFIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getDSL_Expression_UnaryAccess().getValueDSL_REFCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__ValueAssignment_3_1"


    // $ANTLR start "rule__DSL_Expression_Unary__ExpAssignment_5_2"
    // InternalSensinact.g:7650:1: rule__DSL_Expression_Unary__ExpAssignment_5_2 : ( ruleDSL_Expression_Unary ) ;
    public final void rule__DSL_Expression_Unary__ExpAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSensinact.g:7654:1: ( ( ruleDSL_Expression_Unary ) )
            // InternalSensinact.g:7655:2: ( ruleDSL_Expression_Unary )
            {
            // InternalSensinact.g:7655:2: ( ruleDSL_Expression_Unary )
            // InternalSensinact.g:7656:3: ruleDSL_Expression_Unary
            {
             before(grammarAccess.getDSL_Expression_UnaryAccess().getExpDSL_Expression_UnaryParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDSL_Expression_Unary();

            state._fsp--;

             after(grammarAccess.getDSL_Expression_UnaryAccess().getExpDSL_Expression_UnaryParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DSL_Expression_Unary__ExpAssignment_5_2"

    // Delegated rules


    protected DFA17 dfa17 = new DFA17(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\4\1\32\3\4\1\32\2\uffff\1\42\3\4\1\42";
    static final String dfa_3s = "\1\4\1\47\1\35\1\4\1\35\1\47\2\uffff\1\47\1\4\2\35\1\47";
    static final String dfa_4s = "\6\uffff\1\1\1\2\5\uffff";
    static final String dfa_5s = "\15\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\3\7\uffff\1\4\4\uffff\1\2",
            "\1\5\17\uffff\1\6\10\uffff\1\7",
            "\1\10",
            "\1\5\17\uffff\1\6\10\uffff\1\7",
            "\1\11\7\uffff\1\12\4\uffff\1\13",
            "",
            "",
            "\1\4\4\uffff\1\2",
            "\1\14",
            "\1\5\17\uffff\1\6\10\uffff\1\7",
            "\1\5\17\uffff\1\6\10\uffff\1\7",
            "\1\12\4\uffff\1\13"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "2770:2: ( rule__DSL_CEP_AFTER__Group_6__0 )?";
        }
    }
    static final String dfa_7s = "\1\4\1\32\3\4\1\42\1\32\2\uffff\3\4\1\42";
    static final String dfa_8s = "\1\4\1\47\1\4\2\35\2\47\2\uffff\1\35\1\4\1\35\1\47";
    static final String dfa_9s = "\7\uffff\1\1\1\2\4\uffff";
    static final String[] dfa_10s = {
            "\1\1",
            "\1\2\7\uffff\1\3\4\uffff\1\4",
            "\1\5",
            "\1\6\17\uffff\1\7\10\uffff\1\10",
            "\1\6\17\uffff\1\7\10\uffff\1\10",
            "\1\3\4\uffff\1\4",
            "\1\12\7\uffff\1\11\4\uffff\1\13",
            "",
            "",
            "\1\6\17\uffff\1\7\10\uffff\1\10",
            "\1\14",
            "\1\6\17\uffff\1\7\10\uffff\1\10",
            "\1\11\4\uffff\1\13"
    };
    static final char[] dfa_7 = DFA.unpackEncodedStringToUnsignedChars(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final short[][] dfa_10 = unpackEncodedStringArray(dfa_10s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_7;
            this.max = dfa_8;
            this.accept = dfa_9;
            this.special = dfa_5;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "3067:2: ( rule__DSL_CEP_BEFORE__Group_6__0 )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000040080000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000003200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00200000100000F0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000007F80000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00200000300000F0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000F00000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000F00000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x000C000000020000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x000C000000020002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0010000000000000L});

}