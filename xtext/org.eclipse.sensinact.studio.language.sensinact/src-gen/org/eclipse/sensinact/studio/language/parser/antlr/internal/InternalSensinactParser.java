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
package org.eclipse.sensinact.studio.language.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.sensinact.studio.language.services.SensinactGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSensinactParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_BOOLEAN", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'resource'", "'='", "'['", "'/'", "']'", "'on'", "','", "'end if'", "'if'", "'do'", "'else if'", "'else do'", "'.'", "'subscribe'", "'('", "')'", "'define'", "'after'", "'before'", "'coincide'", "'min'", "'max'", "'avg'", "'sum'", "'count'", "'sec'", "'act'", "'set'", "'or'", "'and'", "'!='", "'=='", "'>'", "'>='", "'<'", "'<='", "'+'", "'-'", "'*'", "'%'", "'.get()'", "'not'"
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
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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

        public InternalSensinactParser(TokenStream input, SensinactGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Sensinact";
       	}

       	@Override
       	protected SensinactGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSensinact"
    // InternalSensinact.g:64:1: entryRuleSensinact returns [EObject current=null] : iv_ruleSensinact= ruleSensinact EOF ;
    public final EObject entryRuleSensinact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSensinact = null;


        try {
            // InternalSensinact.g:64:50: (iv_ruleSensinact= ruleSensinact EOF )
            // InternalSensinact.g:65:2: iv_ruleSensinact= ruleSensinact EOF
            {
             newCompositeNode(grammarAccess.getSensinactRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSensinact=ruleSensinact();

            state._fsp--;

             current =iv_ruleSensinact; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSensinact"


    // $ANTLR start "ruleSensinact"
    // InternalSensinact.g:71:1: ruleSensinact returns [EObject current=null] : ( () ( (lv_eca_1_0= ruleDSL_SENSINACT ) ) ) ;
    public final EObject ruleSensinact() throws RecognitionException {
        EObject current = null;

        EObject lv_eca_1_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:77:2: ( ( () ( (lv_eca_1_0= ruleDSL_SENSINACT ) ) ) )
            // InternalSensinact.g:78:2: ( () ( (lv_eca_1_0= ruleDSL_SENSINACT ) ) )
            {
            // InternalSensinact.g:78:2: ( () ( (lv_eca_1_0= ruleDSL_SENSINACT ) ) )
            // InternalSensinact.g:79:3: () ( (lv_eca_1_0= ruleDSL_SENSINACT ) )
            {
            // InternalSensinact.g:79:3: ()
            // InternalSensinact.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSensinactAccess().getSensinactAction_0(),
            					current);
            			

            }

            // InternalSensinact.g:86:3: ( (lv_eca_1_0= ruleDSL_SENSINACT ) )
            // InternalSensinact.g:87:4: (lv_eca_1_0= ruleDSL_SENSINACT )
            {
            // InternalSensinact.g:87:4: (lv_eca_1_0= ruleDSL_SENSINACT )
            // InternalSensinact.g:88:5: lv_eca_1_0= ruleDSL_SENSINACT
            {

            					newCompositeNode(grammarAccess.getSensinactAccess().getEcaDSL_SENSINACTParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_eca_1_0=ruleDSL_SENSINACT();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSensinactRule());
            					}
            					set(
            						current,
            						"eca",
            						lv_eca_1_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_SENSINACT");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSensinact"


    // $ANTLR start "entryRuleDSL_SENSINACT"
    // InternalSensinact.g:109:1: entryRuleDSL_SENSINACT returns [EObject current=null] : iv_ruleDSL_SENSINACT= ruleDSL_SENSINACT EOF ;
    public final EObject entryRuleDSL_SENSINACT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_SENSINACT = null;


        try {
            // InternalSensinact.g:109:54: (iv_ruleDSL_SENSINACT= ruleDSL_SENSINACT EOF )
            // InternalSensinact.g:110:2: iv_ruleDSL_SENSINACT= ruleDSL_SENSINACT EOF
            {
             newCompositeNode(grammarAccess.getDSL_SENSINACTRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_SENSINACT=ruleDSL_SENSINACT();

            state._fsp--;

             current =iv_ruleDSL_SENSINACT; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_SENSINACT"


    // $ANTLR start "ruleDSL_SENSINACT"
    // InternalSensinact.g:116:1: ruleDSL_SENSINACT returns [EObject current=null] : ( ( (lv_resources_0_0= ruleDSL_Resource ) )+ ( (lv_cep_1_0= ruleDSL_CEP_STATEMENT ) )* ( (lv_on_2_0= ruleDSL_On ) ) ( (lv_eca_3_0= ruleDSL_ECA_STATEMENT ) ) ) ;
    public final EObject ruleDSL_SENSINACT() throws RecognitionException {
        EObject current = null;

        EObject lv_resources_0_0 = null;

        EObject lv_cep_1_0 = null;

        EObject lv_on_2_0 = null;

        EObject lv_eca_3_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:122:2: ( ( ( (lv_resources_0_0= ruleDSL_Resource ) )+ ( (lv_cep_1_0= ruleDSL_CEP_STATEMENT ) )* ( (lv_on_2_0= ruleDSL_On ) ) ( (lv_eca_3_0= ruleDSL_ECA_STATEMENT ) ) ) )
            // InternalSensinact.g:123:2: ( ( (lv_resources_0_0= ruleDSL_Resource ) )+ ( (lv_cep_1_0= ruleDSL_CEP_STATEMENT ) )* ( (lv_on_2_0= ruleDSL_On ) ) ( (lv_eca_3_0= ruleDSL_ECA_STATEMENT ) ) )
            {
            // InternalSensinact.g:123:2: ( ( (lv_resources_0_0= ruleDSL_Resource ) )+ ( (lv_cep_1_0= ruleDSL_CEP_STATEMENT ) )* ( (lv_on_2_0= ruleDSL_On ) ) ( (lv_eca_3_0= ruleDSL_ECA_STATEMENT ) ) )
            // InternalSensinact.g:124:3: ( (lv_resources_0_0= ruleDSL_Resource ) )+ ( (lv_cep_1_0= ruleDSL_CEP_STATEMENT ) )* ( (lv_on_2_0= ruleDSL_On ) ) ( (lv_eca_3_0= ruleDSL_ECA_STATEMENT ) )
            {
            // InternalSensinact.g:124:3: ( (lv_resources_0_0= ruleDSL_Resource ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSensinact.g:125:4: (lv_resources_0_0= ruleDSL_Resource )
            	    {
            	    // InternalSensinact.g:125:4: (lv_resources_0_0= ruleDSL_Resource )
            	    // InternalSensinact.g:126:5: lv_resources_0_0= ruleDSL_Resource
            	    {

            	    					newCompositeNode(grammarAccess.getDSL_SENSINACTAccess().getResourcesDSL_ResourceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_resources_0_0=ruleDSL_Resource();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSL_SENSINACTRule());
            	    					}
            	    					add(
            	    						current,
            	    						"resources",
            	    						lv_resources_0_0,
            	    						"org.eclipse.sensinact.studio.language.Sensinact.DSL_Resource");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // InternalSensinact.g:143:3: ( (lv_cep_1_0= ruleDSL_CEP_STATEMENT ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==28) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSensinact.g:144:4: (lv_cep_1_0= ruleDSL_CEP_STATEMENT )
            	    {
            	    // InternalSensinact.g:144:4: (lv_cep_1_0= ruleDSL_CEP_STATEMENT )
            	    // InternalSensinact.g:145:5: lv_cep_1_0= ruleDSL_CEP_STATEMENT
            	    {

            	    					newCompositeNode(grammarAccess.getDSL_SENSINACTAccess().getCepDSL_CEP_STATEMENTParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_cep_1_0=ruleDSL_CEP_STATEMENT();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSL_SENSINACTRule());
            	    					}
            	    					add(
            	    						current,
            	    						"cep",
            	    						lv_cep_1_0,
            	    						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_STATEMENT");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalSensinact.g:162:3: ( (lv_on_2_0= ruleDSL_On ) )
            // InternalSensinact.g:163:4: (lv_on_2_0= ruleDSL_On )
            {
            // InternalSensinact.g:163:4: (lv_on_2_0= ruleDSL_On )
            // InternalSensinact.g:164:5: lv_on_2_0= ruleDSL_On
            {

            					newCompositeNode(grammarAccess.getDSL_SENSINACTAccess().getOnDSL_OnParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_on_2_0=ruleDSL_On();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_SENSINACTRule());
            					}
            					set(
            						current,
            						"on",
            						lv_on_2_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_On");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSensinact.g:181:3: ( (lv_eca_3_0= ruleDSL_ECA_STATEMENT ) )
            // InternalSensinact.g:182:4: (lv_eca_3_0= ruleDSL_ECA_STATEMENT )
            {
            // InternalSensinact.g:182:4: (lv_eca_3_0= ruleDSL_ECA_STATEMENT )
            // InternalSensinact.g:183:5: lv_eca_3_0= ruleDSL_ECA_STATEMENT
            {

            					newCompositeNode(grammarAccess.getDSL_SENSINACTAccess().getEcaDSL_ECA_STATEMENTParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_eca_3_0=ruleDSL_ECA_STATEMENT();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_SENSINACTRule());
            					}
            					set(
            						current,
            						"eca",
            						lv_eca_3_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_ECA_STATEMENT");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_SENSINACT"


    // $ANTLR start "entryRuleDSL_Resource"
    // InternalSensinact.g:204:1: entryRuleDSL_Resource returns [EObject current=null] : iv_ruleDSL_Resource= ruleDSL_Resource EOF ;
    public final EObject entryRuleDSL_Resource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_Resource = null;


        try {
            // InternalSensinact.g:204:53: (iv_ruleDSL_Resource= ruleDSL_Resource EOF )
            // InternalSensinact.g:205:2: iv_ruleDSL_Resource= ruleDSL_Resource EOF
            {
             newCompositeNode(grammarAccess.getDSL_ResourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_Resource=ruleDSL_Resource();

            state._fsp--;

             current =iv_ruleDSL_Resource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_Resource"


    // $ANTLR start "ruleDSL_Resource"
    // InternalSensinact.g:211:1: ruleDSL_Resource returns [EObject current=null] : (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '[' ( (lv_gatewayID_4_0= ruleEXTENDED_ID ) ) otherlv_5= '/' ( (lv_deviceID_6_0= ruleEXTENDED_ID ) ) otherlv_7= '/' ( (lv_serviceID_8_0= ruleEXTENDED_ID ) ) otherlv_9= '/' ( (lv_resourceID_10_0= ruleEXTENDED_ID ) ) otherlv_11= ']' ) ;
    public final EObject ruleDSL_Resource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_gatewayID_4_0 = null;

        AntlrDatatypeRuleToken lv_deviceID_6_0 = null;

        AntlrDatatypeRuleToken lv_serviceID_8_0 = null;

        AntlrDatatypeRuleToken lv_resourceID_10_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:217:2: ( (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '[' ( (lv_gatewayID_4_0= ruleEXTENDED_ID ) ) otherlv_5= '/' ( (lv_deviceID_6_0= ruleEXTENDED_ID ) ) otherlv_7= '/' ( (lv_serviceID_8_0= ruleEXTENDED_ID ) ) otherlv_9= '/' ( (lv_resourceID_10_0= ruleEXTENDED_ID ) ) otherlv_11= ']' ) )
            // InternalSensinact.g:218:2: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '[' ( (lv_gatewayID_4_0= ruleEXTENDED_ID ) ) otherlv_5= '/' ( (lv_deviceID_6_0= ruleEXTENDED_ID ) ) otherlv_7= '/' ( (lv_serviceID_8_0= ruleEXTENDED_ID ) ) otherlv_9= '/' ( (lv_resourceID_10_0= ruleEXTENDED_ID ) ) otherlv_11= ']' )
            {
            // InternalSensinact.g:218:2: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '[' ( (lv_gatewayID_4_0= ruleEXTENDED_ID ) ) otherlv_5= '/' ( (lv_deviceID_6_0= ruleEXTENDED_ID ) ) otherlv_7= '/' ( (lv_serviceID_8_0= ruleEXTENDED_ID ) ) otherlv_9= '/' ( (lv_resourceID_10_0= ruleEXTENDED_ID ) ) otherlv_11= ']' )
            // InternalSensinact.g:219:3: otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '[' ( (lv_gatewayID_4_0= ruleEXTENDED_ID ) ) otherlv_5= '/' ( (lv_deviceID_6_0= ruleEXTENDED_ID ) ) otherlv_7= '/' ( (lv_serviceID_8_0= ruleEXTENDED_ID ) ) otherlv_9= '/' ( (lv_resourceID_10_0= ruleEXTENDED_ID ) ) otherlv_11= ']'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_ResourceAccess().getResourceKeyword_0());
            		
            // InternalSensinact.g:223:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSensinact.g:224:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSensinact.g:224:4: (lv_name_1_0= RULE_ID )
            // InternalSensinact.g:225:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSL_ResourceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSL_ResourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getDSL_ResourceAccess().getEqualsSignKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_ResourceAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalSensinact.g:249:3: ( (lv_gatewayID_4_0= ruleEXTENDED_ID ) )
            // InternalSensinact.g:250:4: (lv_gatewayID_4_0= ruleEXTENDED_ID )
            {
            // InternalSensinact.g:250:4: (lv_gatewayID_4_0= ruleEXTENDED_ID )
            // InternalSensinact.g:251:5: lv_gatewayID_4_0= ruleEXTENDED_ID
            {

            					newCompositeNode(grammarAccess.getDSL_ResourceAccess().getGatewayIDEXTENDED_IDParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_gatewayID_4_0=ruleEXTENDED_ID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ResourceRule());
            					}
            					set(
            						current,
            						"gatewayID",
            						lv_gatewayID_4_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.EXTENDED_ID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_ResourceAccess().getSolidusKeyword_5());
            		
            // InternalSensinact.g:272:3: ( (lv_deviceID_6_0= ruleEXTENDED_ID ) )
            // InternalSensinact.g:273:4: (lv_deviceID_6_0= ruleEXTENDED_ID )
            {
            // InternalSensinact.g:273:4: (lv_deviceID_6_0= ruleEXTENDED_ID )
            // InternalSensinact.g:274:5: lv_deviceID_6_0= ruleEXTENDED_ID
            {

            					newCompositeNode(grammarAccess.getDSL_ResourceAccess().getDeviceIDEXTENDED_IDParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_9);
            lv_deviceID_6_0=ruleEXTENDED_ID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ResourceRule());
            					}
            					set(
            						current,
            						"deviceID",
            						lv_deviceID_6_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.EXTENDED_ID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getDSL_ResourceAccess().getSolidusKeyword_7());
            		
            // InternalSensinact.g:295:3: ( (lv_serviceID_8_0= ruleEXTENDED_ID ) )
            // InternalSensinact.g:296:4: (lv_serviceID_8_0= ruleEXTENDED_ID )
            {
            // InternalSensinact.g:296:4: (lv_serviceID_8_0= ruleEXTENDED_ID )
            // InternalSensinact.g:297:5: lv_serviceID_8_0= ruleEXTENDED_ID
            {

            					newCompositeNode(grammarAccess.getDSL_ResourceAccess().getServiceIDEXTENDED_IDParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_9);
            lv_serviceID_8_0=ruleEXTENDED_ID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ResourceRule());
            					}
            					set(
            						current,
            						"serviceID",
            						lv_serviceID_8_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.EXTENDED_ID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getDSL_ResourceAccess().getSolidusKeyword_9());
            		
            // InternalSensinact.g:318:3: ( (lv_resourceID_10_0= ruleEXTENDED_ID ) )
            // InternalSensinact.g:319:4: (lv_resourceID_10_0= ruleEXTENDED_ID )
            {
            // InternalSensinact.g:319:4: (lv_resourceID_10_0= ruleEXTENDED_ID )
            // InternalSensinact.g:320:5: lv_resourceID_10_0= ruleEXTENDED_ID
            {

            					newCompositeNode(grammarAccess.getDSL_ResourceAccess().getResourceIDEXTENDED_IDParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_10);
            lv_resourceID_10_0=ruleEXTENDED_ID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ResourceRule());
            					}
            					set(
            						current,
            						"resourceID",
            						lv_resourceID_10_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.EXTENDED_ID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getDSL_ResourceAccess().getRightSquareBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_Resource"


    // $ANTLR start "entryRuleDSL_On"
    // InternalSensinact.g:345:1: entryRuleDSL_On returns [EObject current=null] : iv_ruleDSL_On= ruleDSL_On EOF ;
    public final EObject entryRuleDSL_On() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_On = null;


        try {
            // InternalSensinact.g:345:47: (iv_ruleDSL_On= ruleDSL_On EOF )
            // InternalSensinact.g:346:2: iv_ruleDSL_On= ruleDSL_On EOF
            {
             newCompositeNode(grammarAccess.getDSL_OnRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_On=ruleDSL_On();

            state._fsp--;

             current =iv_ruleDSL_On; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_On"


    // $ANTLR start "ruleDSL_On"
    // InternalSensinact.g:352:1: ruleDSL_On returns [EObject current=null] : (otherlv_0= 'on' ( (lv_triggers_1_0= ruleDSL_REF_CONDITION ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleDSL_REF_CONDITION ) ) )* ) ;
    public final EObject ruleDSL_On() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_triggers_1_0 = null;

        EObject lv_triggers_3_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:358:2: ( (otherlv_0= 'on' ( (lv_triggers_1_0= ruleDSL_REF_CONDITION ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleDSL_REF_CONDITION ) ) )* ) )
            // InternalSensinact.g:359:2: (otherlv_0= 'on' ( (lv_triggers_1_0= ruleDSL_REF_CONDITION ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleDSL_REF_CONDITION ) ) )* )
            {
            // InternalSensinact.g:359:2: (otherlv_0= 'on' ( (lv_triggers_1_0= ruleDSL_REF_CONDITION ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleDSL_REF_CONDITION ) ) )* )
            // InternalSensinact.g:360:3: otherlv_0= 'on' ( (lv_triggers_1_0= ruleDSL_REF_CONDITION ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleDSL_REF_CONDITION ) ) )*
            {
            otherlv_0=(Token)match(input,17,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_OnAccess().getOnKeyword_0());
            		
            // InternalSensinact.g:364:3: ( (lv_triggers_1_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:365:4: (lv_triggers_1_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:365:4: (lv_triggers_1_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:366:5: lv_triggers_1_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_OnAccess().getTriggersDSL_REF_CONDITIONParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
            lv_triggers_1_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_OnRule());
            					}
            					add(
            						current,
            						"triggers",
            						lv_triggers_1_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSensinact.g:383:3: (otherlv_2= ',' ( (lv_triggers_3_0= ruleDSL_REF_CONDITION ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSensinact.g:384:4: otherlv_2= ',' ( (lv_triggers_3_0= ruleDSL_REF_CONDITION ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_6); 

            	    				newLeafNode(otherlv_2, grammarAccess.getDSL_OnAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalSensinact.g:388:4: ( (lv_triggers_3_0= ruleDSL_REF_CONDITION ) )
            	    // InternalSensinact.g:389:5: (lv_triggers_3_0= ruleDSL_REF_CONDITION )
            	    {
            	    // InternalSensinact.g:389:5: (lv_triggers_3_0= ruleDSL_REF_CONDITION )
            	    // InternalSensinact.g:390:6: lv_triggers_3_0= ruleDSL_REF_CONDITION
            	    {

            	    						newCompositeNode(grammarAccess.getDSL_OnAccess().getTriggersDSL_REF_CONDITIONParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_triggers_3_0=ruleDSL_REF_CONDITION();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDSL_OnRule());
            	    						}
            	    						add(
            	    							current,
            	    							"triggers",
            	    							lv_triggers_3_0,
            	    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_On"


    // $ANTLR start "entryRuleDSL_ECA_STATEMENT"
    // InternalSensinact.g:412:1: entryRuleDSL_ECA_STATEMENT returns [EObject current=null] : iv_ruleDSL_ECA_STATEMENT= ruleDSL_ECA_STATEMENT EOF ;
    public final EObject entryRuleDSL_ECA_STATEMENT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_ECA_STATEMENT = null;


        try {
            // InternalSensinact.g:412:58: (iv_ruleDSL_ECA_STATEMENT= ruleDSL_ECA_STATEMENT EOF )
            // InternalSensinact.g:413:2: iv_ruleDSL_ECA_STATEMENT= ruleDSL_ECA_STATEMENT EOF
            {
             newCompositeNode(grammarAccess.getDSL_ECA_STATEMENTRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_ECA_STATEMENT=ruleDSL_ECA_STATEMENT();

            state._fsp--;

             current =iv_ruleDSL_ECA_STATEMENT; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_ECA_STATEMENT"


    // $ANTLR start "ruleDSL_ECA_STATEMENT"
    // InternalSensinact.g:419:1: ruleDSL_ECA_STATEMENT returns [EObject current=null] : ( ( (lv_ifdo_0_0= ruleDSL_IfDo ) ) ( (lv_elseIfdo_1_0= ruleDSL_ElseIfDo ) )* ( (lv_elsedo_2_0= ruleDSL_ElseDo ) )? otherlv_3= 'end if' ) ;
    public final EObject ruleDSL_ECA_STATEMENT() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_ifdo_0_0 = null;

        EObject lv_elseIfdo_1_0 = null;

        EObject lv_elsedo_2_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:425:2: ( ( ( (lv_ifdo_0_0= ruleDSL_IfDo ) ) ( (lv_elseIfdo_1_0= ruleDSL_ElseIfDo ) )* ( (lv_elsedo_2_0= ruleDSL_ElseDo ) )? otherlv_3= 'end if' ) )
            // InternalSensinact.g:426:2: ( ( (lv_ifdo_0_0= ruleDSL_IfDo ) ) ( (lv_elseIfdo_1_0= ruleDSL_ElseIfDo ) )* ( (lv_elsedo_2_0= ruleDSL_ElseDo ) )? otherlv_3= 'end if' )
            {
            // InternalSensinact.g:426:2: ( ( (lv_ifdo_0_0= ruleDSL_IfDo ) ) ( (lv_elseIfdo_1_0= ruleDSL_ElseIfDo ) )* ( (lv_elsedo_2_0= ruleDSL_ElseDo ) )? otherlv_3= 'end if' )
            // InternalSensinact.g:427:3: ( (lv_ifdo_0_0= ruleDSL_IfDo ) ) ( (lv_elseIfdo_1_0= ruleDSL_ElseIfDo ) )* ( (lv_elsedo_2_0= ruleDSL_ElseDo ) )? otherlv_3= 'end if'
            {
            // InternalSensinact.g:427:3: ( (lv_ifdo_0_0= ruleDSL_IfDo ) )
            // InternalSensinact.g:428:4: (lv_ifdo_0_0= ruleDSL_IfDo )
            {
            // InternalSensinact.g:428:4: (lv_ifdo_0_0= ruleDSL_IfDo )
            // InternalSensinact.g:429:5: lv_ifdo_0_0= ruleDSL_IfDo
            {

            					newCompositeNode(grammarAccess.getDSL_ECA_STATEMENTAccess().getIfdoDSL_IfDoParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_ifdo_0_0=ruleDSL_IfDo();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ECA_STATEMENTRule());
            					}
            					set(
            						current,
            						"ifdo",
            						lv_ifdo_0_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_IfDo");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSensinact.g:446:3: ( (lv_elseIfdo_1_0= ruleDSL_ElseIfDo ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==22) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSensinact.g:447:4: (lv_elseIfdo_1_0= ruleDSL_ElseIfDo )
            	    {
            	    // InternalSensinact.g:447:4: (lv_elseIfdo_1_0= ruleDSL_ElseIfDo )
            	    // InternalSensinact.g:448:5: lv_elseIfdo_1_0= ruleDSL_ElseIfDo
            	    {

            	    					newCompositeNode(grammarAccess.getDSL_ECA_STATEMENTAccess().getElseIfdoDSL_ElseIfDoParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_elseIfdo_1_0=ruleDSL_ElseIfDo();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSL_ECA_STATEMENTRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elseIfdo",
            	    						lv_elseIfdo_1_0,
            	    						"org.eclipse.sensinact.studio.language.Sensinact.DSL_ElseIfDo");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalSensinact.g:465:3: ( (lv_elsedo_2_0= ruleDSL_ElseDo ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSensinact.g:466:4: (lv_elsedo_2_0= ruleDSL_ElseDo )
                    {
                    // InternalSensinact.g:466:4: (lv_elsedo_2_0= ruleDSL_ElseDo )
                    // InternalSensinact.g:467:5: lv_elsedo_2_0= ruleDSL_ElseDo
                    {

                    					newCompositeNode(grammarAccess.getDSL_ECA_STATEMENTAccess().getElsedoDSL_ElseDoParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_13);
                    lv_elsedo_2_0=ruleDSL_ElseDo();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDSL_ECA_STATEMENTRule());
                    					}
                    					set(
                    						current,
                    						"elsedo",
                    						lv_elsedo_2_0,
                    						"org.eclipse.sensinact.studio.language.Sensinact.DSL_ElseDo");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_ECA_STATEMENTAccess().getEndIfKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_ECA_STATEMENT"


    // $ANTLR start "entryRuleDSL_IfDo"
    // InternalSensinact.g:492:1: entryRuleDSL_IfDo returns [EObject current=null] : iv_ruleDSL_IfDo= ruleDSL_IfDo EOF ;
    public final EObject entryRuleDSL_IfDo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_IfDo = null;


        try {
            // InternalSensinact.g:492:49: (iv_ruleDSL_IfDo= ruleDSL_IfDo EOF )
            // InternalSensinact.g:493:2: iv_ruleDSL_IfDo= ruleDSL_IfDo EOF
            {
             newCompositeNode(grammarAccess.getDSL_IfDoRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_IfDo=ruleDSL_IfDo();

            state._fsp--;

             current =iv_ruleDSL_IfDo; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_IfDo"


    // $ANTLR start "ruleDSL_IfDo"
    // InternalSensinact.g:499:1: ruleDSL_IfDo returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) ) ) ;
    public final EObject ruleDSL_IfDo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_actions_3_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:505:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) ) ) )
            // InternalSensinact.g:506:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) ) )
            {
            // InternalSensinact.g:506:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) ) )
            // InternalSensinact.g:507:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_IfDoAccess().getIfKeyword_0());
            		
            // InternalSensinact.g:511:3: ( (lv_condition_1_0= ruleDSL_Expression_Or ) )
            // InternalSensinact.g:512:4: (lv_condition_1_0= ruleDSL_Expression_Or )
            {
            // InternalSensinact.g:512:4: (lv_condition_1_0= ruleDSL_Expression_Or )
            // InternalSensinact.g:513:5: lv_condition_1_0= ruleDSL_Expression_Or
            {

            					newCompositeNode(grammarAccess.getDSL_IfDoAccess().getConditionDSL_Expression_OrParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_15);
            lv_condition_1_0=ruleDSL_Expression_Or();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_IfDoRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Or");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getDSL_IfDoAccess().getDoKeyword_2());
            		
            // InternalSensinact.g:534:3: ( (lv_actions_3_0= ruleDSL_ListActions ) )
            // InternalSensinact.g:535:4: (lv_actions_3_0= ruleDSL_ListActions )
            {
            // InternalSensinact.g:535:4: (lv_actions_3_0= ruleDSL_ListActions )
            // InternalSensinact.g:536:5: lv_actions_3_0= ruleDSL_ListActions
            {

            					newCompositeNode(grammarAccess.getDSL_IfDoAccess().getActionsDSL_ListActionsParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_actions_3_0=ruleDSL_ListActions();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_IfDoRule());
            					}
            					set(
            						current,
            						"actions",
            						lv_actions_3_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_ListActions");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_IfDo"


    // $ANTLR start "entryRuleDSL_ElseIfDo"
    // InternalSensinact.g:557:1: entryRuleDSL_ElseIfDo returns [EObject current=null] : iv_ruleDSL_ElseIfDo= ruleDSL_ElseIfDo EOF ;
    public final EObject entryRuleDSL_ElseIfDo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_ElseIfDo = null;


        try {
            // InternalSensinact.g:557:53: (iv_ruleDSL_ElseIfDo= ruleDSL_ElseIfDo EOF )
            // InternalSensinact.g:558:2: iv_ruleDSL_ElseIfDo= ruleDSL_ElseIfDo EOF
            {
             newCompositeNode(grammarAccess.getDSL_ElseIfDoRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_ElseIfDo=ruleDSL_ElseIfDo();

            state._fsp--;

             current =iv_ruleDSL_ElseIfDo; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_ElseIfDo"


    // $ANTLR start "ruleDSL_ElseIfDo"
    // InternalSensinact.g:564:1: ruleDSL_ElseIfDo returns [EObject current=null] : (otherlv_0= 'else if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) ) ) ;
    public final EObject ruleDSL_ElseIfDo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_actions_3_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:570:2: ( (otherlv_0= 'else if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) ) ) )
            // InternalSensinact.g:571:2: (otherlv_0= 'else if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) ) )
            {
            // InternalSensinact.g:571:2: (otherlv_0= 'else if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) ) )
            // InternalSensinact.g:572:3: otherlv_0= 'else if' ( (lv_condition_1_0= ruleDSL_Expression_Or ) ) otherlv_2= 'do' ( (lv_actions_3_0= ruleDSL_ListActions ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_ElseIfDoAccess().getElseIfKeyword_0());
            		
            // InternalSensinact.g:576:3: ( (lv_condition_1_0= ruleDSL_Expression_Or ) )
            // InternalSensinact.g:577:4: (lv_condition_1_0= ruleDSL_Expression_Or )
            {
            // InternalSensinact.g:577:4: (lv_condition_1_0= ruleDSL_Expression_Or )
            // InternalSensinact.g:578:5: lv_condition_1_0= ruleDSL_Expression_Or
            {

            					newCompositeNode(grammarAccess.getDSL_ElseIfDoAccess().getConditionDSL_Expression_OrParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_15);
            lv_condition_1_0=ruleDSL_Expression_Or();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ElseIfDoRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Or");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getDSL_ElseIfDoAccess().getDoKeyword_2());
            		
            // InternalSensinact.g:599:3: ( (lv_actions_3_0= ruleDSL_ListActions ) )
            // InternalSensinact.g:600:4: (lv_actions_3_0= ruleDSL_ListActions )
            {
            // InternalSensinact.g:600:4: (lv_actions_3_0= ruleDSL_ListActions )
            // InternalSensinact.g:601:5: lv_actions_3_0= ruleDSL_ListActions
            {

            					newCompositeNode(grammarAccess.getDSL_ElseIfDoAccess().getActionsDSL_ListActionsParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_actions_3_0=ruleDSL_ListActions();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ElseIfDoRule());
            					}
            					set(
            						current,
            						"actions",
            						lv_actions_3_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_ListActions");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_ElseIfDo"


    // $ANTLR start "entryRuleDSL_ElseDo"
    // InternalSensinact.g:622:1: entryRuleDSL_ElseDo returns [EObject current=null] : iv_ruleDSL_ElseDo= ruleDSL_ElseDo EOF ;
    public final EObject entryRuleDSL_ElseDo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_ElseDo = null;


        try {
            // InternalSensinact.g:622:51: (iv_ruleDSL_ElseDo= ruleDSL_ElseDo EOF )
            // InternalSensinact.g:623:2: iv_ruleDSL_ElseDo= ruleDSL_ElseDo EOF
            {
             newCompositeNode(grammarAccess.getDSL_ElseDoRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_ElseDo=ruleDSL_ElseDo();

            state._fsp--;

             current =iv_ruleDSL_ElseDo; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_ElseDo"


    // $ANTLR start "ruleDSL_ElseDo"
    // InternalSensinact.g:629:1: ruleDSL_ElseDo returns [EObject current=null] : (otherlv_0= 'else do' ( (lv_actions_1_0= ruleDSL_ListActions ) ) ) ;
    public final EObject ruleDSL_ElseDo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_actions_1_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:635:2: ( (otherlv_0= 'else do' ( (lv_actions_1_0= ruleDSL_ListActions ) ) ) )
            // InternalSensinact.g:636:2: (otherlv_0= 'else do' ( (lv_actions_1_0= ruleDSL_ListActions ) ) )
            {
            // InternalSensinact.g:636:2: (otherlv_0= 'else do' ( (lv_actions_1_0= ruleDSL_ListActions ) ) )
            // InternalSensinact.g:637:3: otherlv_0= 'else do' ( (lv_actions_1_0= ruleDSL_ListActions ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_ElseDoAccess().getElseDoKeyword_0());
            		
            // InternalSensinact.g:641:3: ( (lv_actions_1_0= ruleDSL_ListActions ) )
            // InternalSensinact.g:642:4: (lv_actions_1_0= ruleDSL_ListActions )
            {
            // InternalSensinact.g:642:4: (lv_actions_1_0= ruleDSL_ListActions )
            // InternalSensinact.g:643:5: lv_actions_1_0= ruleDSL_ListActions
            {

            					newCompositeNode(grammarAccess.getDSL_ElseDoAccess().getActionsDSL_ListActionsParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_actions_1_0=ruleDSL_ListActions();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ElseDoRule());
            					}
            					set(
            						current,
            						"actions",
            						lv_actions_1_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_ListActions");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_ElseDo"


    // $ANTLR start "entryRuleNUMBER"
    // InternalSensinact.g:664:1: entryRuleNUMBER returns [String current=null] : iv_ruleNUMBER= ruleNUMBER EOF ;
    public final String entryRuleNUMBER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER = null;


        try {
            // InternalSensinact.g:664:46: (iv_ruleNUMBER= ruleNUMBER EOF )
            // InternalSensinact.g:665:2: iv_ruleNUMBER= ruleNUMBER EOF
            {
             newCompositeNode(grammarAccess.getNUMBERRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNUMBER=ruleNUMBER();

            state._fsp--;

             current =iv_ruleNUMBER.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNUMBER"


    // $ANTLR start "ruleNUMBER"
    // InternalSensinact.g:671:1: ruleNUMBER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT ) ) ;
    public final AntlrDatatypeRuleToken ruleNUMBER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_INT_1=null;
        Token kw=null;
        Token this_INT_3=null;


        	enterRule();

        try {
            // InternalSensinact.g:677:2: ( (this_INT_0= RULE_INT | (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT ) ) )
            // InternalSensinact.g:678:2: (this_INT_0= RULE_INT | (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT ) )
            {
            // InternalSensinact.g:678:2: (this_INT_0= RULE_INT | (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==EOF||LA6_1==15||LA6_1==18||LA6_1==21||LA6_1==27||LA6_1==32||LA6_1==37||(LA6_1>=40 && LA6_1<=51)) ) {
                    alt6=1;
                }
                else if ( (LA6_1==24) ) {
                    alt6=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSensinact.g:679:3: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_0);
                    		

                    			newLeafNode(this_INT_0, grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSensinact.g:687:3: (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT )
                    {
                    // InternalSensinact.g:687:3: (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT )
                    // InternalSensinact.g:688:4: this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_16); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_1_0());
                    			
                    kw=(Token)match(input,24,FOLLOW_17); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getNUMBERAccess().getFullStopKeyword_1_1());
                    			
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_3);
                    			

                    				newLeafNode(this_INT_3, grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_1_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNUMBER"


    // $ANTLR start "entryRuleEXTENDED_ID"
    // InternalSensinact.g:712:1: entryRuleEXTENDED_ID returns [String current=null] : iv_ruleEXTENDED_ID= ruleEXTENDED_ID EOF ;
    public final String entryRuleEXTENDED_ID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEXTENDED_ID = null;


        try {
            // InternalSensinact.g:712:51: (iv_ruleEXTENDED_ID= ruleEXTENDED_ID EOF )
            // InternalSensinact.g:713:2: iv_ruleEXTENDED_ID= ruleEXTENDED_ID EOF
            {
             newCompositeNode(grammarAccess.getEXTENDED_IDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEXTENDED_ID=ruleEXTENDED_ID();

            state._fsp--;

             current =iv_ruleEXTENDED_ID.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEXTENDED_ID"


    // $ANTLR start "ruleEXTENDED_ID"
    // InternalSensinact.g:719:1: ruleEXTENDED_ID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleEXTENDED_ID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalSensinact.g:725:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSensinact.g:726:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSensinact.g:726:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSensinact.g:727:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getEXTENDED_IDAccess().getIDTerminalRuleCall_0());
            		
            // InternalSensinact.g:734:3: (kw= '.' this_ID_2= RULE_ID )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSensinact.g:735:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,24,FOLLOW_6); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getEXTENDED_IDAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_18); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getEXTENDED_IDAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEXTENDED_ID"


    // $ANTLR start "entryRuleDSL_REF_CONDITION"
    // InternalSensinact.g:752:1: entryRuleDSL_REF_CONDITION returns [EObject current=null] : iv_ruleDSL_REF_CONDITION= ruleDSL_REF_CONDITION EOF ;
    public final EObject entryRuleDSL_REF_CONDITION() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_REF_CONDITION = null;


        try {
            // InternalSensinact.g:752:58: (iv_ruleDSL_REF_CONDITION= ruleDSL_REF_CONDITION EOF )
            // InternalSensinact.g:753:2: iv_ruleDSL_REF_CONDITION= ruleDSL_REF_CONDITION EOF
            {
             newCompositeNode(grammarAccess.getDSL_REF_CONDITIONRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_REF_CONDITION=ruleDSL_REF_CONDITION();

            state._fsp--;

             current =iv_ruleDSL_REF_CONDITION; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_REF_CONDITION"


    // $ANTLR start "ruleDSL_REF_CONDITION"
    // InternalSensinact.g:759:1: ruleDSL_REF_CONDITION returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' otherlv_2= 'subscribe' otherlv_3= '(' otherlv_4= ')' ) ;
    public final EObject ruleDSL_REF_CONDITION() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalSensinact.g:765:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' otherlv_2= 'subscribe' otherlv_3= '(' otherlv_4= ')' ) )
            // InternalSensinact.g:766:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' otherlv_2= 'subscribe' otherlv_3= '(' otherlv_4= ')' )
            {
            // InternalSensinact.g:766:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' otherlv_2= 'subscribe' otherlv_3= '(' otherlv_4= ')' )
            // InternalSensinact.g:767:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' otherlv_2= 'subscribe' otherlv_3= '(' otherlv_4= ')'
            {
            // InternalSensinact.g:767:3: ( (otherlv_0= RULE_ID ) )
            // InternalSensinact.g:768:4: (otherlv_0= RULE_ID )
            {
            // InternalSensinact.g:768:4: (otherlv_0= RULE_ID )
            // InternalSensinact.g:769:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSL_REF_CONDITIONRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_0, grammarAccess.getDSL_REF_CONDITIONAccess().getRefDSL_REFCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_REF_CONDITIONAccess().getFullStopKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getDSL_REF_CONDITIONAccess().getSubscribeKeyword_2());
            		
            otherlv_3=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_REF_CONDITIONAccess().getLeftParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getDSL_REF_CONDITIONAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_REF_CONDITION"


    // $ANTLR start "entryRuleDSL_CEP_STATEMENT"
    // InternalSensinact.g:800:1: entryRuleDSL_CEP_STATEMENT returns [EObject current=null] : iv_ruleDSL_CEP_STATEMENT= ruleDSL_CEP_STATEMENT EOF ;
    public final EObject entryRuleDSL_CEP_STATEMENT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_STATEMENT = null;


        try {
            // InternalSensinact.g:800:58: (iv_ruleDSL_CEP_STATEMENT= ruleDSL_CEP_STATEMENT EOF )
            // InternalSensinact.g:801:2: iv_ruleDSL_CEP_STATEMENT= ruleDSL_CEP_STATEMENT EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_STATEMENTRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_STATEMENT=ruleDSL_CEP_STATEMENT();

            state._fsp--;

             current =iv_ruleDSL_CEP_STATEMENT; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_STATEMENT"


    // $ANTLR start "ruleDSL_CEP_STATEMENT"
    // InternalSensinact.g:807:1: ruleDSL_CEP_STATEMENT returns [EObject current=null] : (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT ) ) ) ) ;
    public final EObject ruleDSL_CEP_STATEMENT() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_operation_3_1 = null;

        EObject lv_operation_3_2 = null;

        EObject lv_operation_3_3 = null;

        EObject lv_operation_3_4 = null;

        EObject lv_operation_3_5 = null;

        EObject lv_operation_3_6 = null;

        EObject lv_operation_3_7 = null;

        EObject lv_operation_3_8 = null;



        	enterRule();

        try {
            // InternalSensinact.g:813:2: ( (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT ) ) ) ) )
            // InternalSensinact.g:814:2: (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT ) ) ) )
            {
            // InternalSensinact.g:814:2: (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT ) ) ) )
            // InternalSensinact.g:815:3: otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT ) ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_CEP_STATEMENTAccess().getDefineKeyword_0());
            		
            // InternalSensinact.g:819:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSensinact.g:820:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSensinact.g:820:4: (lv_name_1_0= RULE_ID )
            // InternalSensinact.g:821:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSL_CEP_STATEMENTAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSL_CEP_STATEMENTRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getDSL_CEP_STATEMENTAccess().getEqualsSignKeyword_2());
            		
            // InternalSensinact.g:841:3: ( ( (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT ) ) )
            // InternalSensinact.g:842:4: ( (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT ) )
            {
            // InternalSensinact.g:842:4: ( (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT ) )
            // InternalSensinact.g:843:5: (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT )
            {
            // InternalSensinact.g:843:5: (lv_operation_3_1= ruleDSL_CEP_AFTER | lv_operation_3_2= ruleDSL_CEP_BEFORE | lv_operation_3_3= ruleDSL_CEP_COINCIDE | lv_operation_3_4= ruleDSL_CEP_MIN | lv_operation_3_5= ruleDSL_CEP_MAX | lv_operation_3_6= ruleDSL_CEP_AVG | lv_operation_3_7= ruleDSL_CEP_SUM | lv_operation_3_8= ruleDSL_CEP_COUNT )
            int alt8=8;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt8=1;
                }
                break;
            case 30:
                {
                alt8=2;
                }
                break;
            case 31:
                {
                alt8=3;
                }
                break;
            case 32:
                {
                alt8=4;
                }
                break;
            case 33:
                {
                alt8=5;
                }
                break;
            case 34:
                {
                alt8=6;
                }
                break;
            case 35:
                {
                alt8=7;
                }
                break;
            case 36:
                {
                alt8=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalSensinact.g:844:6: lv_operation_3_1= ruleDSL_CEP_AFTER
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_AFTERParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operation_3_1=ruleDSL_CEP_AFTER();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_STATEMENTRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_3_1,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_AFTER");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalSensinact.g:860:6: lv_operation_3_2= ruleDSL_CEP_BEFORE
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_BEFOREParserRuleCall_3_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operation_3_2=ruleDSL_CEP_BEFORE();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_STATEMENTRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_3_2,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_BEFORE");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 3 :
                    // InternalSensinact.g:876:6: lv_operation_3_3= ruleDSL_CEP_COINCIDE
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_COINCIDEParserRuleCall_3_0_2());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operation_3_3=ruleDSL_CEP_COINCIDE();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_STATEMENTRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_3_3,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_COINCIDE");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 4 :
                    // InternalSensinact.g:892:6: lv_operation_3_4= ruleDSL_CEP_MIN
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_MINParserRuleCall_3_0_3());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operation_3_4=ruleDSL_CEP_MIN();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_STATEMENTRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_3_4,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_MIN");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 5 :
                    // InternalSensinact.g:908:6: lv_operation_3_5= ruleDSL_CEP_MAX
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_MAXParserRuleCall_3_0_4());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operation_3_5=ruleDSL_CEP_MAX();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_STATEMENTRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_3_5,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_MAX");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 6 :
                    // InternalSensinact.g:924:6: lv_operation_3_6= ruleDSL_CEP_AVG
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_AVGParserRuleCall_3_0_5());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operation_3_6=ruleDSL_CEP_AVG();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_STATEMENTRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_3_6,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_AVG");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 7 :
                    // InternalSensinact.g:940:6: lv_operation_3_7= ruleDSL_CEP_SUM
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_SUMParserRuleCall_3_0_6());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operation_3_7=ruleDSL_CEP_SUM();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_STATEMENTRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_3_7,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_SUM");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 8 :
                    // InternalSensinact.g:956:6: lv_operation_3_8= ruleDSL_CEP_COUNT
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_STATEMENTAccess().getOperationDSL_CEP_COUNTParserRuleCall_3_0_7());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operation_3_8=ruleDSL_CEP_COUNT();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_STATEMENTRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_3_8,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_COUNT");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_STATEMENT"


    // $ANTLR start "entryRuleDSL_CEP_AFTER"
    // InternalSensinact.g:978:1: entryRuleDSL_CEP_AFTER returns [EObject current=null] : iv_ruleDSL_CEP_AFTER= ruleDSL_CEP_AFTER EOF ;
    public final EObject entryRuleDSL_CEP_AFTER() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_AFTER = null;


        try {
            // InternalSensinact.g:978:54: (iv_ruleDSL_CEP_AFTER= ruleDSL_CEP_AFTER EOF )
            // InternalSensinact.g:979:2: iv_ruleDSL_CEP_AFTER= ruleDSL_CEP_AFTER EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_AFTERRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_AFTER=ruleDSL_CEP_AFTER();

            state._fsp--;

             current =iv_ruleDSL_CEP_AFTER; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_AFTER"


    // $ANTLR start "ruleDSL_CEP_AFTER"
    // InternalSensinact.g:985:1: ruleDSL_CEP_AFTER returns [EObject current=null] : (otherlv_0= 'after' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')' ) ;
    public final EObject ruleDSL_CEP_AFTER() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_ref1_2_0 = null;

        EObject lv_ref2_4_0 = null;

        EObject lv_start_6_0 = null;

        EObject lv_end_8_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:991:2: ( (otherlv_0= 'after' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')' ) )
            // InternalSensinact.g:992:2: (otherlv_0= 'after' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')' )
            {
            // InternalSensinact.g:992:2: (otherlv_0= 'after' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')' )
            // InternalSensinact.g:993:3: otherlv_0= 'after' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_CEP_AFTERAccess().getAfterKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_AFTERAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSensinact.g:1001:3: ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1002:4: (lv_ref1_2_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1002:4: (lv_ref1_2_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1003:5: lv_ref1_2_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_AFTERAccess().getRef1DSL_REF_CONDITIONParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref1_2_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_AFTERRule());
            					}
            					set(
            						current,
            						"ref1",
            						lv_ref1_2_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_CEP_AFTERAccess().getCommaKeyword_3());
            		
            // InternalSensinact.g:1024:3: ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1025:4: (lv_ref2_4_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1025:4: (lv_ref2_4_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1026:5: lv_ref2_4_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_AFTERAccess().getRef2DSL_REF_CONDITIONParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref2_4_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_AFTERRule());
            					}
            					set(
            						current,
            						"ref2",
            						lv_ref2_4_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_CEP_AFTERAccess().getCommaKeyword_5());
            		
            // InternalSensinact.g:1047:3: ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )?
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalSensinact.g:1048:4: ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ','
                    {
                    // InternalSensinact.g:1048:4: ( (lv_start_6_0= ruleDSL_CEP_DURATION ) )
                    // InternalSensinact.g:1049:5: (lv_start_6_0= ruleDSL_CEP_DURATION )
                    {
                    // InternalSensinact.g:1049:5: (lv_start_6_0= ruleDSL_CEP_DURATION )
                    // InternalSensinact.g:1050:6: lv_start_6_0= ruleDSL_CEP_DURATION
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_AFTERAccess().getStartDSL_CEP_DURATIONParserRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_start_6_0=ruleDSL_CEP_DURATION();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_AFTERRule());
                    						}
                    						set(
                    							current,
                    							"start",
                    							lv_start_6_0,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,18,FOLLOW_17); 

                    				newLeafNode(otherlv_7, grammarAccess.getDSL_CEP_AFTERAccess().getCommaKeyword_6_1());
                    			

                    }
                    break;

            }

            // InternalSensinact.g:1072:3: ( (lv_end_8_0= ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:1073:4: (lv_end_8_0= ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:1073:4: (lv_end_8_0= ruleDSL_CEP_DURATION )
            // InternalSensinact.g:1074:5: lv_end_8_0= ruleDSL_CEP_DURATION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_AFTERAccess().getEndDSL_CEP_DURATIONParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_21);
            lv_end_8_0=ruleDSL_CEP_DURATION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_AFTERRule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_8_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getDSL_CEP_AFTERAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_AFTER"


    // $ANTLR start "entryRuleDSL_CEP_BEFORE"
    // InternalSensinact.g:1099:1: entryRuleDSL_CEP_BEFORE returns [EObject current=null] : iv_ruleDSL_CEP_BEFORE= ruleDSL_CEP_BEFORE EOF ;
    public final EObject entryRuleDSL_CEP_BEFORE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_BEFORE = null;


        try {
            // InternalSensinact.g:1099:55: (iv_ruleDSL_CEP_BEFORE= ruleDSL_CEP_BEFORE EOF )
            // InternalSensinact.g:1100:2: iv_ruleDSL_CEP_BEFORE= ruleDSL_CEP_BEFORE EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_BEFORERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_BEFORE=ruleDSL_CEP_BEFORE();

            state._fsp--;

             current =iv_ruleDSL_CEP_BEFORE; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_BEFORE"


    // $ANTLR start "ruleDSL_CEP_BEFORE"
    // InternalSensinact.g:1106:1: ruleDSL_CEP_BEFORE returns [EObject current=null] : (otherlv_0= 'before' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')' ) ;
    public final EObject ruleDSL_CEP_BEFORE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_ref1_2_0 = null;

        EObject lv_ref2_4_0 = null;

        EObject lv_start_6_0 = null;

        EObject lv_end_8_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1112:2: ( (otherlv_0= 'before' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')' ) )
            // InternalSensinact.g:1113:2: (otherlv_0= 'before' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')' )
            {
            // InternalSensinact.g:1113:2: (otherlv_0= 'before' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')' )
            // InternalSensinact.g:1114:3: otherlv_0= 'before' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )? ( (lv_end_8_0= ruleDSL_CEP_DURATION ) ) otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_CEP_BEFOREAccess().getBeforeKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_BEFOREAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSensinact.g:1122:3: ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1123:4: (lv_ref1_2_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1123:4: (lv_ref1_2_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1124:5: lv_ref1_2_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_BEFOREAccess().getRef1DSL_REF_CONDITIONParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref1_2_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_BEFORERule());
            					}
            					set(
            						current,
            						"ref1",
            						lv_ref1_2_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_CEP_BEFOREAccess().getCommaKeyword_3());
            		
            // InternalSensinact.g:1145:3: ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1146:4: (lv_ref2_4_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1146:4: (lv_ref2_4_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1147:5: lv_ref2_4_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_BEFOREAccess().getRef2DSL_REF_CONDITIONParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref2_4_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_BEFORERule());
            					}
            					set(
            						current,
            						"ref2",
            						lv_ref2_4_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_CEP_BEFOREAccess().getCommaKeyword_5());
            		
            // InternalSensinact.g:1168:3: ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )?
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalSensinact.g:1169:4: ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ','
                    {
                    // InternalSensinact.g:1169:4: ( (lv_start_6_0= ruleDSL_CEP_DURATION ) )
                    // InternalSensinact.g:1170:5: (lv_start_6_0= ruleDSL_CEP_DURATION )
                    {
                    // InternalSensinact.g:1170:5: (lv_start_6_0= ruleDSL_CEP_DURATION )
                    // InternalSensinact.g:1171:6: lv_start_6_0= ruleDSL_CEP_DURATION
                    {

                    						newCompositeNode(grammarAccess.getDSL_CEP_BEFOREAccess().getStartDSL_CEP_DURATIONParserRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_start_6_0=ruleDSL_CEP_DURATION();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_CEP_BEFORERule());
                    						}
                    						set(
                    							current,
                    							"start",
                    							lv_start_6_0,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,18,FOLLOW_17); 

                    				newLeafNode(otherlv_7, grammarAccess.getDSL_CEP_BEFOREAccess().getCommaKeyword_6_1());
                    			

                    }
                    break;

            }

            // InternalSensinact.g:1193:3: ( (lv_end_8_0= ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:1194:4: (lv_end_8_0= ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:1194:4: (lv_end_8_0= ruleDSL_CEP_DURATION )
            // InternalSensinact.g:1195:5: lv_end_8_0= ruleDSL_CEP_DURATION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_BEFOREAccess().getEndDSL_CEP_DURATIONParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_21);
            lv_end_8_0=ruleDSL_CEP_DURATION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_BEFORERule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_8_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getDSL_CEP_BEFOREAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_BEFORE"


    // $ANTLR start "entryRuleDSL_CEP_COINCIDE"
    // InternalSensinact.g:1220:1: entryRuleDSL_CEP_COINCIDE returns [EObject current=null] : iv_ruleDSL_CEP_COINCIDE= ruleDSL_CEP_COINCIDE EOF ;
    public final EObject entryRuleDSL_CEP_COINCIDE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_COINCIDE = null;


        try {
            // InternalSensinact.g:1220:57: (iv_ruleDSL_CEP_COINCIDE= ruleDSL_CEP_COINCIDE EOF )
            // InternalSensinact.g:1221:2: iv_ruleDSL_CEP_COINCIDE= ruleDSL_CEP_COINCIDE EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_COINCIDERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_COINCIDE=ruleDSL_CEP_COINCIDE();

            state._fsp--;

             current =iv_ruleDSL_CEP_COINCIDE; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_COINCIDE"


    // $ANTLR start "ruleDSL_CEP_COINCIDE"
    // InternalSensinact.g:1227:1: ruleDSL_CEP_COINCIDE returns [EObject current=null] : (otherlv_0= 'coincide' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( (lv_window_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ')' ) ;
    public final EObject ruleDSL_CEP_COINCIDE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ref1_2_0 = null;

        EObject lv_ref2_4_0 = null;

        EObject lv_window_6_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1233:2: ( (otherlv_0= 'coincide' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( (lv_window_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ')' ) )
            // InternalSensinact.g:1234:2: (otherlv_0= 'coincide' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( (lv_window_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ')' )
            {
            // InternalSensinact.g:1234:2: (otherlv_0= 'coincide' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( (lv_window_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ')' )
            // InternalSensinact.g:1235:3: otherlv_0= 'coincide' otherlv_1= '(' ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) ) otherlv_5= ',' ( (lv_window_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_CEP_COINCIDEAccess().getCoincideKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_COINCIDEAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSensinact.g:1243:3: ( (lv_ref1_2_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1244:4: (lv_ref1_2_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1244:4: (lv_ref1_2_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1245:5: lv_ref1_2_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef1DSL_REF_CONDITIONParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref1_2_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_COINCIDERule());
            					}
            					set(
            						current,
            						"ref1",
            						lv_ref1_2_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_CEP_COINCIDEAccess().getCommaKeyword_3());
            		
            // InternalSensinact.g:1266:3: ( (lv_ref2_4_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1267:4: (lv_ref2_4_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1267:4: (lv_ref2_4_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1268:5: lv_ref2_4_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_COINCIDEAccess().getRef2DSL_REF_CONDITIONParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref2_4_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_COINCIDERule());
            					}
            					set(
            						current,
            						"ref2",
            						lv_ref2_4_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_CEP_COINCIDEAccess().getCommaKeyword_5());
            		
            // InternalSensinact.g:1289:3: ( (lv_window_6_0= ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:1290:4: (lv_window_6_0= ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:1290:4: (lv_window_6_0= ruleDSL_CEP_DURATION )
            // InternalSensinact.g:1291:5: lv_window_6_0= ruleDSL_CEP_DURATION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_COINCIDEAccess().getWindowDSL_CEP_DURATIONParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_21);
            lv_window_6_0=ruleDSL_CEP_DURATION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_COINCIDERule());
            					}
            					set(
            						current,
            						"window",
            						lv_window_6_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDSL_CEP_COINCIDEAccess().getRightParenthesisKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_COINCIDE"


    // $ANTLR start "entryRuleDSL_CEP_MIN"
    // InternalSensinact.g:1316:1: entryRuleDSL_CEP_MIN returns [EObject current=null] : iv_ruleDSL_CEP_MIN= ruleDSL_CEP_MIN EOF ;
    public final EObject entryRuleDSL_CEP_MIN() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_MIN = null;


        try {
            // InternalSensinact.g:1316:52: (iv_ruleDSL_CEP_MIN= ruleDSL_CEP_MIN EOF )
            // InternalSensinact.g:1317:2: iv_ruleDSL_CEP_MIN= ruleDSL_CEP_MIN EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_MINRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_MIN=ruleDSL_CEP_MIN();

            state._fsp--;

             current =iv_ruleDSL_CEP_MIN; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_MIN"


    // $ANTLR start "ruleDSL_CEP_MIN"
    // InternalSensinact.g:1323:1: ruleDSL_CEP_MIN returns [EObject current=null] : (otherlv_0= 'min' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) ;
    public final EObject ruleDSL_CEP_MIN() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ref_2_0 = null;

        EObject lv_window_4_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1329:2: ( (otherlv_0= 'min' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) )
            // InternalSensinact.g:1330:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            {
            // InternalSensinact.g:1330:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            // InternalSensinact.g:1331:3: otherlv_0= 'min' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_CEP_MINAccess().getMinKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_MINAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSensinact.g:1339:3: ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1340:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1340:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1341:5: lv_ref_2_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_MINAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref_2_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_MINRule());
            					}
            					set(
            						current,
            						"ref",
            						lv_ref_2_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_CEP_MINAccess().getCommaKeyword_3());
            		
            // InternalSensinact.g:1362:3: ( (lv_window_4_0= ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:1363:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:1363:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            // InternalSensinact.g:1364:5: lv_window_4_0= ruleDSL_CEP_DURATION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_MINAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_window_4_0=ruleDSL_CEP_DURATION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_MINRule());
            					}
            					set(
            						current,
            						"window",
            						lv_window_4_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_CEP_MINAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_MIN"


    // $ANTLR start "entryRuleDSL_CEP_MAX"
    // InternalSensinact.g:1389:1: entryRuleDSL_CEP_MAX returns [EObject current=null] : iv_ruleDSL_CEP_MAX= ruleDSL_CEP_MAX EOF ;
    public final EObject entryRuleDSL_CEP_MAX() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_MAX = null;


        try {
            // InternalSensinact.g:1389:52: (iv_ruleDSL_CEP_MAX= ruleDSL_CEP_MAX EOF )
            // InternalSensinact.g:1390:2: iv_ruleDSL_CEP_MAX= ruleDSL_CEP_MAX EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_MAXRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_MAX=ruleDSL_CEP_MAX();

            state._fsp--;

             current =iv_ruleDSL_CEP_MAX; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_MAX"


    // $ANTLR start "ruleDSL_CEP_MAX"
    // InternalSensinact.g:1396:1: ruleDSL_CEP_MAX returns [EObject current=null] : (otherlv_0= 'max' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) ;
    public final EObject ruleDSL_CEP_MAX() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ref_2_0 = null;

        EObject lv_window_4_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1402:2: ( (otherlv_0= 'max' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) )
            // InternalSensinact.g:1403:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            {
            // InternalSensinact.g:1403:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            // InternalSensinact.g:1404:3: otherlv_0= 'max' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_CEP_MAXAccess().getMaxKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_MAXAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSensinact.g:1412:3: ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1413:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1413:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1414:5: lv_ref_2_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_MAXAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref_2_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_MAXRule());
            					}
            					set(
            						current,
            						"ref",
            						lv_ref_2_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_CEP_MAXAccess().getCommaKeyword_3());
            		
            // InternalSensinact.g:1435:3: ( (lv_window_4_0= ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:1436:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:1436:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            // InternalSensinact.g:1437:5: lv_window_4_0= ruleDSL_CEP_DURATION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_MAXAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_window_4_0=ruleDSL_CEP_DURATION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_MAXRule());
            					}
            					set(
            						current,
            						"window",
            						lv_window_4_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_CEP_MAXAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_MAX"


    // $ANTLR start "entryRuleDSL_CEP_AVG"
    // InternalSensinact.g:1462:1: entryRuleDSL_CEP_AVG returns [EObject current=null] : iv_ruleDSL_CEP_AVG= ruleDSL_CEP_AVG EOF ;
    public final EObject entryRuleDSL_CEP_AVG() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_AVG = null;


        try {
            // InternalSensinact.g:1462:52: (iv_ruleDSL_CEP_AVG= ruleDSL_CEP_AVG EOF )
            // InternalSensinact.g:1463:2: iv_ruleDSL_CEP_AVG= ruleDSL_CEP_AVG EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_AVGRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_AVG=ruleDSL_CEP_AVG();

            state._fsp--;

             current =iv_ruleDSL_CEP_AVG; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_AVG"


    // $ANTLR start "ruleDSL_CEP_AVG"
    // InternalSensinact.g:1469:1: ruleDSL_CEP_AVG returns [EObject current=null] : (otherlv_0= 'avg' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) ;
    public final EObject ruleDSL_CEP_AVG() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ref_2_0 = null;

        EObject lv_window_4_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1475:2: ( (otherlv_0= 'avg' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) )
            // InternalSensinact.g:1476:2: (otherlv_0= 'avg' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            {
            // InternalSensinact.g:1476:2: (otherlv_0= 'avg' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            // InternalSensinact.g:1477:3: otherlv_0= 'avg' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_CEP_AVGAccess().getAvgKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_AVGAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSensinact.g:1485:3: ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1486:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1486:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1487:5: lv_ref_2_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_AVGAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref_2_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_AVGRule());
            					}
            					set(
            						current,
            						"ref",
            						lv_ref_2_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_CEP_AVGAccess().getCommaKeyword_3());
            		
            // InternalSensinact.g:1508:3: ( (lv_window_4_0= ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:1509:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:1509:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            // InternalSensinact.g:1510:5: lv_window_4_0= ruleDSL_CEP_DURATION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_AVGAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_window_4_0=ruleDSL_CEP_DURATION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_AVGRule());
            					}
            					set(
            						current,
            						"window",
            						lv_window_4_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_CEP_AVGAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_AVG"


    // $ANTLR start "entryRuleDSL_CEP_SUM"
    // InternalSensinact.g:1535:1: entryRuleDSL_CEP_SUM returns [EObject current=null] : iv_ruleDSL_CEP_SUM= ruleDSL_CEP_SUM EOF ;
    public final EObject entryRuleDSL_CEP_SUM() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_SUM = null;


        try {
            // InternalSensinact.g:1535:52: (iv_ruleDSL_CEP_SUM= ruleDSL_CEP_SUM EOF )
            // InternalSensinact.g:1536:2: iv_ruleDSL_CEP_SUM= ruleDSL_CEP_SUM EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_SUMRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_SUM=ruleDSL_CEP_SUM();

            state._fsp--;

             current =iv_ruleDSL_CEP_SUM; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_SUM"


    // $ANTLR start "ruleDSL_CEP_SUM"
    // InternalSensinact.g:1542:1: ruleDSL_CEP_SUM returns [EObject current=null] : (otherlv_0= 'sum' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) ;
    public final EObject ruleDSL_CEP_SUM() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ref_2_0 = null;

        EObject lv_window_4_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1548:2: ( (otherlv_0= 'sum' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) )
            // InternalSensinact.g:1549:2: (otherlv_0= 'sum' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            {
            // InternalSensinact.g:1549:2: (otherlv_0= 'sum' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            // InternalSensinact.g:1550:3: otherlv_0= 'sum' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_CEP_SUMAccess().getSumKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_SUMAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSensinact.g:1558:3: ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1559:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1559:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1560:5: lv_ref_2_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_SUMAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref_2_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_SUMRule());
            					}
            					set(
            						current,
            						"ref",
            						lv_ref_2_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_CEP_SUMAccess().getCommaKeyword_3());
            		
            // InternalSensinact.g:1581:3: ( (lv_window_4_0= ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:1582:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:1582:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            // InternalSensinact.g:1583:5: lv_window_4_0= ruleDSL_CEP_DURATION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_SUMAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_window_4_0=ruleDSL_CEP_DURATION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_SUMRule());
            					}
            					set(
            						current,
            						"window",
            						lv_window_4_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_CEP_SUMAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_SUM"


    // $ANTLR start "entryRuleDSL_CEP_COUNT"
    // InternalSensinact.g:1608:1: entryRuleDSL_CEP_COUNT returns [EObject current=null] : iv_ruleDSL_CEP_COUNT= ruleDSL_CEP_COUNT EOF ;
    public final EObject entryRuleDSL_CEP_COUNT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_COUNT = null;


        try {
            // InternalSensinact.g:1608:54: (iv_ruleDSL_CEP_COUNT= ruleDSL_CEP_COUNT EOF )
            // InternalSensinact.g:1609:2: iv_ruleDSL_CEP_COUNT= ruleDSL_CEP_COUNT EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_COUNTRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_COUNT=ruleDSL_CEP_COUNT();

            state._fsp--;

             current =iv_ruleDSL_CEP_COUNT; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_COUNT"


    // $ANTLR start "ruleDSL_CEP_COUNT"
    // InternalSensinact.g:1615:1: ruleDSL_CEP_COUNT returns [EObject current=null] : (otherlv_0= 'count' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) ;
    public final EObject ruleDSL_CEP_COUNT() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ref_2_0 = null;

        EObject lv_window_4_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1621:2: ( (otherlv_0= 'count' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' ) )
            // InternalSensinact.g:1622:2: (otherlv_0= 'count' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            {
            // InternalSensinact.g:1622:2: (otherlv_0= 'count' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')' )
            // InternalSensinact.g:1623:3: otherlv_0= 'count' otherlv_1= '(' ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) ) otherlv_3= ',' ( (lv_window_4_0= ruleDSL_CEP_DURATION ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getDSL_CEP_COUNTAccess().getCountKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_COUNTAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSensinact.g:1631:3: ( (lv_ref_2_0= ruleDSL_REF_CONDITION ) )
            // InternalSensinact.g:1632:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            {
            // InternalSensinact.g:1632:4: (lv_ref_2_0= ruleDSL_REF_CONDITION )
            // InternalSensinact.g:1633:5: lv_ref_2_0= ruleDSL_REF_CONDITION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_COUNTAccess().getRefDSL_REF_CONDITIONParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_ref_2_0=ruleDSL_REF_CONDITION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_COUNTRule());
            					}
            					set(
            						current,
            						"ref",
            						lv_ref_2_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_REF_CONDITION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_CEP_COUNTAccess().getCommaKeyword_3());
            		
            // InternalSensinact.g:1654:3: ( (lv_window_4_0= ruleDSL_CEP_DURATION ) )
            // InternalSensinact.g:1655:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            {
            // InternalSensinact.g:1655:4: (lv_window_4_0= ruleDSL_CEP_DURATION )
            // InternalSensinact.g:1656:5: lv_window_4_0= ruleDSL_CEP_DURATION
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_COUNTAccess().getWindowDSL_CEP_DURATIONParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_window_4_0=ruleDSL_CEP_DURATION();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_COUNTRule());
            					}
            					set(
            						current,
            						"window",
            						lv_window_4_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_CEP_COUNTAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_COUNT"


    // $ANTLR start "entryRuleDSL_CEP_DURATION"
    // InternalSensinact.g:1681:1: entryRuleDSL_CEP_DURATION returns [EObject current=null] : iv_ruleDSL_CEP_DURATION= ruleDSL_CEP_DURATION EOF ;
    public final EObject entryRuleDSL_CEP_DURATION() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_DURATION = null;


        try {
            // InternalSensinact.g:1681:57: (iv_ruleDSL_CEP_DURATION= ruleDSL_CEP_DURATION EOF )
            // InternalSensinact.g:1682:2: iv_ruleDSL_CEP_DURATION= ruleDSL_CEP_DURATION EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_DURATIONRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_DURATION=ruleDSL_CEP_DURATION();

            state._fsp--;

             current =iv_ruleDSL_CEP_DURATION; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_DURATION"


    // $ANTLR start "ruleDSL_CEP_DURATION"
    // InternalSensinact.g:1688:1: ruleDSL_CEP_DURATION returns [EObject current=null] : ( ( (lv_units_0_1= ruleDSL_CEP_DURATION_MIN | lv_units_0_2= ruleDSL_CEP_DURATION_SEC ) ) )+ ;
    public final EObject ruleDSL_CEP_DURATION() throws RecognitionException {
        EObject current = null;

        EObject lv_units_0_1 = null;

        EObject lv_units_0_2 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1694:2: ( ( ( (lv_units_0_1= ruleDSL_CEP_DURATION_MIN | lv_units_0_2= ruleDSL_CEP_DURATION_SEC ) ) )+ )
            // InternalSensinact.g:1695:2: ( ( (lv_units_0_1= ruleDSL_CEP_DURATION_MIN | lv_units_0_2= ruleDSL_CEP_DURATION_SEC ) ) )+
            {
            // InternalSensinact.g:1695:2: ( ( (lv_units_0_1= ruleDSL_CEP_DURATION_MIN | lv_units_0_2= ruleDSL_CEP_DURATION_SEC ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_INT) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalSensinact.g:1696:3: ( (lv_units_0_1= ruleDSL_CEP_DURATION_MIN | lv_units_0_2= ruleDSL_CEP_DURATION_SEC ) )
            	    {
            	    // InternalSensinact.g:1696:3: ( (lv_units_0_1= ruleDSL_CEP_DURATION_MIN | lv_units_0_2= ruleDSL_CEP_DURATION_SEC ) )
            	    // InternalSensinact.g:1697:4: (lv_units_0_1= ruleDSL_CEP_DURATION_MIN | lv_units_0_2= ruleDSL_CEP_DURATION_SEC )
            	    {
            	    // InternalSensinact.g:1697:4: (lv_units_0_1= ruleDSL_CEP_DURATION_MIN | lv_units_0_2= ruleDSL_CEP_DURATION_SEC )
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==RULE_INT) ) {
            	        switch ( input.LA(2) ) {
            	        case 24:
            	            {
            	            int LA11_2 = input.LA(3);

            	            if ( (LA11_2==RULE_INT) ) {
            	                int LA11_5 = input.LA(4);

            	                if ( (LA11_5==32) ) {
            	                    alt11=1;
            	                }
            	                else if ( (LA11_5==37) ) {
            	                    alt11=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("", 11, 5, input);

            	                    throw nvae;
            	                }
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 11, 2, input);

            	                throw nvae;
            	            }
            	            }
            	            break;
            	        case 32:
            	            {
            	            alt11=1;
            	            }
            	            break;
            	        case 37:
            	            {
            	            alt11=2;
            	            }
            	            break;
            	        default:
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 11, 1, input);

            	            throw nvae;
            	        }

            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // InternalSensinact.g:1698:5: lv_units_0_1= ruleDSL_CEP_DURATION_MIN
            	            {

            	            					newCompositeNode(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsDSL_CEP_DURATION_MINParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_24);
            	            lv_units_0_1=ruleDSL_CEP_DURATION_MIN();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getDSL_CEP_DURATIONRule());
            	            					}
            	            					add(
            	            						current,
            	            						"units",
            	            						lv_units_0_1,
            	            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION_MIN");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalSensinact.g:1714:5: lv_units_0_2= ruleDSL_CEP_DURATION_SEC
            	            {

            	            					newCompositeNode(grammarAccess.getDSL_CEP_DURATIONAccess().getUnitsDSL_CEP_DURATION_SECParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_24);
            	            lv_units_0_2=ruleDSL_CEP_DURATION_SEC();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getDSL_CEP_DURATIONRule());
            	            					}
            	            					add(
            	            						current,
            	            						"units",
            	            						lv_units_0_2,
            	            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_CEP_DURATION_SEC");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_DURATION"


    // $ANTLR start "entryRuleDSL_CEP_DURATION_MIN"
    // InternalSensinact.g:1735:1: entryRuleDSL_CEP_DURATION_MIN returns [EObject current=null] : iv_ruleDSL_CEP_DURATION_MIN= ruleDSL_CEP_DURATION_MIN EOF ;
    public final EObject entryRuleDSL_CEP_DURATION_MIN() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_DURATION_MIN = null;


        try {
            // InternalSensinact.g:1735:61: (iv_ruleDSL_CEP_DURATION_MIN= ruleDSL_CEP_DURATION_MIN EOF )
            // InternalSensinact.g:1736:2: iv_ruleDSL_CEP_DURATION_MIN= ruleDSL_CEP_DURATION_MIN EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_DURATION_MINRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_DURATION_MIN=ruleDSL_CEP_DURATION_MIN();

            state._fsp--;

             current =iv_ruleDSL_CEP_DURATION_MIN; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_DURATION_MIN"


    // $ANTLR start "ruleDSL_CEP_DURATION_MIN"
    // InternalSensinact.g:1742:1: ruleDSL_CEP_DURATION_MIN returns [EObject current=null] : ( ( (lv_min_0_0= ruleNUMBER ) ) otherlv_1= 'min' ) ;
    public final EObject ruleDSL_CEP_DURATION_MIN() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_min_0_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1748:2: ( ( ( (lv_min_0_0= ruleNUMBER ) ) otherlv_1= 'min' ) )
            // InternalSensinact.g:1749:2: ( ( (lv_min_0_0= ruleNUMBER ) ) otherlv_1= 'min' )
            {
            // InternalSensinact.g:1749:2: ( ( (lv_min_0_0= ruleNUMBER ) ) otherlv_1= 'min' )
            // InternalSensinact.g:1750:3: ( (lv_min_0_0= ruleNUMBER ) ) otherlv_1= 'min'
            {
            // InternalSensinact.g:1750:3: ( (lv_min_0_0= ruleNUMBER ) )
            // InternalSensinact.g:1751:4: (lv_min_0_0= ruleNUMBER )
            {
            // InternalSensinact.g:1751:4: (lv_min_0_0= ruleNUMBER )
            // InternalSensinact.g:1752:5: lv_min_0_0= ruleNUMBER
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_DURATION_MINAccess().getMinNUMBERParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_25);
            lv_min_0_0=ruleNUMBER();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_DURATION_MINRule());
            					}
            					set(
            						current,
            						"min",
            						lv_min_0_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.NUMBER");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_DURATION_MINAccess().getMinKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_DURATION_MIN"


    // $ANTLR start "entryRuleDSL_CEP_DURATION_SEC"
    // InternalSensinact.g:1777:1: entryRuleDSL_CEP_DURATION_SEC returns [EObject current=null] : iv_ruleDSL_CEP_DURATION_SEC= ruleDSL_CEP_DURATION_SEC EOF ;
    public final EObject entryRuleDSL_CEP_DURATION_SEC() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_CEP_DURATION_SEC = null;


        try {
            // InternalSensinact.g:1777:61: (iv_ruleDSL_CEP_DURATION_SEC= ruleDSL_CEP_DURATION_SEC EOF )
            // InternalSensinact.g:1778:2: iv_ruleDSL_CEP_DURATION_SEC= ruleDSL_CEP_DURATION_SEC EOF
            {
             newCompositeNode(grammarAccess.getDSL_CEP_DURATION_SECRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_CEP_DURATION_SEC=ruleDSL_CEP_DURATION_SEC();

            state._fsp--;

             current =iv_ruleDSL_CEP_DURATION_SEC; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_CEP_DURATION_SEC"


    // $ANTLR start "ruleDSL_CEP_DURATION_SEC"
    // InternalSensinact.g:1784:1: ruleDSL_CEP_DURATION_SEC returns [EObject current=null] : ( ( (lv_sec_0_0= ruleNUMBER ) ) otherlv_1= 'sec' ) ;
    public final EObject ruleDSL_CEP_DURATION_SEC() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_sec_0_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1790:2: ( ( ( (lv_sec_0_0= ruleNUMBER ) ) otherlv_1= 'sec' ) )
            // InternalSensinact.g:1791:2: ( ( (lv_sec_0_0= ruleNUMBER ) ) otherlv_1= 'sec' )
            {
            // InternalSensinact.g:1791:2: ( ( (lv_sec_0_0= ruleNUMBER ) ) otherlv_1= 'sec' )
            // InternalSensinact.g:1792:3: ( (lv_sec_0_0= ruleNUMBER ) ) otherlv_1= 'sec'
            {
            // InternalSensinact.g:1792:3: ( (lv_sec_0_0= ruleNUMBER ) )
            // InternalSensinact.g:1793:4: (lv_sec_0_0= ruleNUMBER )
            {
            // InternalSensinact.g:1793:4: (lv_sec_0_0= ruleNUMBER )
            // InternalSensinact.g:1794:5: lv_sec_0_0= ruleNUMBER
            {

            					newCompositeNode(grammarAccess.getDSL_CEP_DURATION_SECAccess().getSecNUMBERParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_26);
            lv_sec_0_0=ruleNUMBER();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_CEP_DURATION_SECRule());
            					}
            					set(
            						current,
            						"sec",
            						lv_sec_0_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.NUMBER");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getDSL_CEP_DURATION_SECAccess().getSecKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_CEP_DURATION_SEC"


    // $ANTLR start "entryRuleDSL_ListActions"
    // InternalSensinact.g:1819:1: entryRuleDSL_ListActions returns [EObject current=null] : iv_ruleDSL_ListActions= ruleDSL_ListActions EOF ;
    public final EObject entryRuleDSL_ListActions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_ListActions = null;


        try {
            // InternalSensinact.g:1819:56: (iv_ruleDSL_ListActions= ruleDSL_ListActions EOF )
            // InternalSensinact.g:1820:2: iv_ruleDSL_ListActions= ruleDSL_ListActions EOF
            {
             newCompositeNode(grammarAccess.getDSL_ListActionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_ListActions=ruleDSL_ListActions();

            state._fsp--;

             current =iv_ruleDSL_ListActions; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_ListActions"


    // $ANTLR start "ruleDSL_ListActions"
    // InternalSensinact.g:1826:1: ruleDSL_ListActions returns [EObject current=null] : ( ( (lv_actionList_0_0= ruleDSL_ResourceAction ) ) (otherlv_1= ',' ( (lv_actionList_2_0= ruleDSL_ResourceAction ) ) )* ) ;
    public final EObject ruleDSL_ListActions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_actionList_0_0 = null;

        EObject lv_actionList_2_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1832:2: ( ( ( (lv_actionList_0_0= ruleDSL_ResourceAction ) ) (otherlv_1= ',' ( (lv_actionList_2_0= ruleDSL_ResourceAction ) ) )* ) )
            // InternalSensinact.g:1833:2: ( ( (lv_actionList_0_0= ruleDSL_ResourceAction ) ) (otherlv_1= ',' ( (lv_actionList_2_0= ruleDSL_ResourceAction ) ) )* )
            {
            // InternalSensinact.g:1833:2: ( ( (lv_actionList_0_0= ruleDSL_ResourceAction ) ) (otherlv_1= ',' ( (lv_actionList_2_0= ruleDSL_ResourceAction ) ) )* )
            // InternalSensinact.g:1834:3: ( (lv_actionList_0_0= ruleDSL_ResourceAction ) ) (otherlv_1= ',' ( (lv_actionList_2_0= ruleDSL_ResourceAction ) ) )*
            {
            // InternalSensinact.g:1834:3: ( (lv_actionList_0_0= ruleDSL_ResourceAction ) )
            // InternalSensinact.g:1835:4: (lv_actionList_0_0= ruleDSL_ResourceAction )
            {
            // InternalSensinact.g:1835:4: (lv_actionList_0_0= ruleDSL_ResourceAction )
            // InternalSensinact.g:1836:5: lv_actionList_0_0= ruleDSL_ResourceAction
            {

            					newCompositeNode(grammarAccess.getDSL_ListActionsAccess().getActionListDSL_ResourceActionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_actionList_0_0=ruleDSL_ResourceAction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ListActionsRule());
            					}
            					add(
            						current,
            						"actionList",
            						lv_actionList_0_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_ResourceAction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSensinact.g:1853:3: (otherlv_1= ',' ( (lv_actionList_2_0= ruleDSL_ResourceAction ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==18) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSensinact.g:1854:4: otherlv_1= ',' ( (lv_actionList_2_0= ruleDSL_ResourceAction ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getDSL_ListActionsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalSensinact.g:1858:4: ( (lv_actionList_2_0= ruleDSL_ResourceAction ) )
            	    // InternalSensinact.g:1859:5: (lv_actionList_2_0= ruleDSL_ResourceAction )
            	    {
            	    // InternalSensinact.g:1859:5: (lv_actionList_2_0= ruleDSL_ResourceAction )
            	    // InternalSensinact.g:1860:6: lv_actionList_2_0= ruleDSL_ResourceAction
            	    {

            	    						newCompositeNode(grammarAccess.getDSL_ListActionsAccess().getActionListDSL_ResourceActionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_actionList_2_0=ruleDSL_ResourceAction();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDSL_ListActionsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"actionList",
            	    							lv_actionList_2_0,
            	    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_ResourceAction");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_ListActions"


    // $ANTLR start "entryRuleDSL_ResourceAction"
    // InternalSensinact.g:1882:1: entryRuleDSL_ResourceAction returns [EObject current=null] : iv_ruleDSL_ResourceAction= ruleDSL_ResourceAction EOF ;
    public final EObject entryRuleDSL_ResourceAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_ResourceAction = null;


        try {
            // InternalSensinact.g:1882:59: (iv_ruleDSL_ResourceAction= ruleDSL_ResourceAction EOF )
            // InternalSensinact.g:1883:2: iv_ruleDSL_ResourceAction= ruleDSL_ResourceAction EOF
            {
             newCompositeNode(grammarAccess.getDSL_ResourceActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_ResourceAction=ruleDSL_ResourceAction();

            state._fsp--;

             current =iv_ruleDSL_ResourceAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_ResourceAction"


    // $ANTLR start "ruleDSL_ResourceAction"
    // InternalSensinact.g:1889:1: ruleDSL_ResourceAction returns [EObject current=null] : ( ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( ( (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' ) ) ) otherlv_5= '(' ( (lv_listParam_6_0= ruleDSL_ListParam ) )? otherlv_7= ')' ) ;
    public final EObject ruleDSL_ResourceAction() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_actiontype_4_1=null;
        Token lv_actiontype_4_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_listParam_6_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:1895:2: ( ( ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( ( (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' ) ) ) otherlv_5= '(' ( (lv_listParam_6_0= ruleDSL_ListParam ) )? otherlv_7= ')' ) )
            // InternalSensinact.g:1896:2: ( ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( ( (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' ) ) ) otherlv_5= '(' ( (lv_listParam_6_0= ruleDSL_ListParam ) )? otherlv_7= ')' )
            {
            // InternalSensinact.g:1896:2: ( ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( ( (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' ) ) ) otherlv_5= '(' ( (lv_listParam_6_0= ruleDSL_ListParam ) )? otherlv_7= ')' )
            // InternalSensinact.g:1897:3: ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( ( (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' ) ) ) otherlv_5= '(' ( (lv_listParam_6_0= ruleDSL_ListParam ) )? otherlv_7= ')'
            {
            // InternalSensinact.g:1897:3: ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==13) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalSensinact.g:1898:4: ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // InternalSensinact.g:1898:4: ( (lv_variable_0_0= RULE_ID ) )
                    // InternalSensinact.g:1899:5: (lv_variable_0_0= RULE_ID )
                    {
                    // InternalSensinact.g:1899:5: (lv_variable_0_0= RULE_ID )
                    // InternalSensinact.g:1900:6: lv_variable_0_0= RULE_ID
                    {
                    lv_variable_0_0=(Token)match(input,RULE_ID,FOLLOW_7); 

                    						newLeafNode(lv_variable_0_0, grammarAccess.getDSL_ResourceActionAccess().getVariableIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSL_ResourceActionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"variable",
                    							lv_variable_0_0,
                    							"org.eclipse.sensinact.studio.language.Sensinact.ID");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getDSL_ResourceActionAccess().getEqualsSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalSensinact.g:1921:3: ( (otherlv_2= RULE_ID ) )
            // InternalSensinact.g:1922:4: (otherlv_2= RULE_ID )
            {
            // InternalSensinact.g:1922:4: (otherlv_2= RULE_ID )
            // InternalSensinact.g:1923:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSL_ResourceActionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_2, grammarAccess.getDSL_ResourceActionAccess().getRefDSL_REFCrossReference_1_0());
            				

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getDSL_ResourceActionAccess().getFullStopKeyword_2());
            		
            // InternalSensinact.g:1938:3: ( ( (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' ) ) )
            // InternalSensinact.g:1939:4: ( (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' ) )
            {
            // InternalSensinact.g:1939:4: ( (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' ) )
            // InternalSensinact.g:1940:5: (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' )
            {
            // InternalSensinact.g:1940:5: (lv_actiontype_4_1= 'act' | lv_actiontype_4_2= 'set' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==38) ) {
                alt15=1;
            }
            else if ( (LA15_0==39) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalSensinact.g:1941:6: lv_actiontype_4_1= 'act'
                    {
                    lv_actiontype_4_1=(Token)match(input,38,FOLLOW_20); 

                    						newLeafNode(lv_actiontype_4_1, grammarAccess.getDSL_ResourceActionAccess().getActiontypeActKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSL_ResourceActionRule());
                    						}
                    						setWithLastConsumed(current, "actiontype", lv_actiontype_4_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSensinact.g:1952:6: lv_actiontype_4_2= 'set'
                    {
                    lv_actiontype_4_2=(Token)match(input,39,FOLLOW_20); 

                    						newLeafNode(lv_actiontype_4_2, grammarAccess.getDSL_ResourceActionAccess().getActiontypeSetKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSL_ResourceActionRule());
                    						}
                    						setWithLastConsumed(current, "actiontype", lv_actiontype_4_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,26,FOLLOW_28); 

            			newLeafNode(otherlv_5, grammarAccess.getDSL_ResourceActionAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSensinact.g:1969:3: ( (lv_listParam_6_0= ruleDSL_ListParam ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_BOOLEAN)||LA16_0==26||LA16_0==53) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSensinact.g:1970:4: (lv_listParam_6_0= ruleDSL_ListParam )
                    {
                    // InternalSensinact.g:1970:4: (lv_listParam_6_0= ruleDSL_ListParam )
                    // InternalSensinact.g:1971:5: lv_listParam_6_0= ruleDSL_ListParam
                    {

                    					newCompositeNode(grammarAccess.getDSL_ResourceActionAccess().getListParamDSL_ListParamParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_21);
                    lv_listParam_6_0=ruleDSL_ListParam();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDSL_ResourceActionRule());
                    					}
                    					set(
                    						current,
                    						"listParam",
                    						lv_listParam_6_0,
                    						"org.eclipse.sensinact.studio.language.Sensinact.DSL_ListParam");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDSL_ResourceActionAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_ResourceAction"


    // $ANTLR start "entryRuleDSL_ListParam"
    // InternalSensinact.g:1996:1: entryRuleDSL_ListParam returns [EObject current=null] : iv_ruleDSL_ListParam= ruleDSL_ListParam EOF ;
    public final EObject entryRuleDSL_ListParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_ListParam = null;


        try {
            // InternalSensinact.g:1996:54: (iv_ruleDSL_ListParam= ruleDSL_ListParam EOF )
            // InternalSensinact.g:1997:2: iv_ruleDSL_ListParam= ruleDSL_ListParam EOF
            {
             newCompositeNode(grammarAccess.getDSL_ListParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_ListParam=ruleDSL_ListParam();

            state._fsp--;

             current =iv_ruleDSL_ListParam; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_ListParam"


    // $ANTLR start "ruleDSL_ListParam"
    // InternalSensinact.g:2003:1: ruleDSL_ListParam returns [EObject current=null] : ( ( (lv_param_0_0= ruleDSL_Expression_Or ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleDSL_Expression_Or ) ) )* ) ;
    public final EObject ruleDSL_ListParam() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:2009:2: ( ( ( (lv_param_0_0= ruleDSL_Expression_Or ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleDSL_Expression_Or ) ) )* ) )
            // InternalSensinact.g:2010:2: ( ( (lv_param_0_0= ruleDSL_Expression_Or ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleDSL_Expression_Or ) ) )* )
            {
            // InternalSensinact.g:2010:2: ( ( (lv_param_0_0= ruleDSL_Expression_Or ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleDSL_Expression_Or ) ) )* )
            // InternalSensinact.g:2011:3: ( (lv_param_0_0= ruleDSL_Expression_Or ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleDSL_Expression_Or ) ) )*
            {
            // InternalSensinact.g:2011:3: ( (lv_param_0_0= ruleDSL_Expression_Or ) )
            // InternalSensinact.g:2012:4: (lv_param_0_0= ruleDSL_Expression_Or )
            {
            // InternalSensinact.g:2012:4: (lv_param_0_0= ruleDSL_Expression_Or )
            // InternalSensinact.g:2013:5: lv_param_0_0= ruleDSL_Expression_Or
            {

            					newCompositeNode(grammarAccess.getDSL_ListParamAccess().getParamDSL_Expression_OrParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_param_0_0=ruleDSL_Expression_Or();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSL_ListParamRule());
            					}
            					add(
            						current,
            						"param",
            						lv_param_0_0,
            						"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Or");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSensinact.g:2030:3: (otherlv_1= ',' ( (lv_param_2_0= ruleDSL_Expression_Or ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==18) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalSensinact.g:2031:4: otherlv_1= ',' ( (lv_param_2_0= ruleDSL_Expression_Or ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_14); 

            	    				newLeafNode(otherlv_1, grammarAccess.getDSL_ListParamAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalSensinact.g:2035:4: ( (lv_param_2_0= ruleDSL_Expression_Or ) )
            	    // InternalSensinact.g:2036:5: (lv_param_2_0= ruleDSL_Expression_Or )
            	    {
            	    // InternalSensinact.g:2036:5: (lv_param_2_0= ruleDSL_Expression_Or )
            	    // InternalSensinact.g:2037:6: lv_param_2_0= ruleDSL_Expression_Or
            	    {

            	    						newCompositeNode(grammarAccess.getDSL_ListParamAccess().getParamDSL_Expression_OrParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_param_2_0=ruleDSL_Expression_Or();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDSL_ListParamRule());
            	    						}
            	    						add(
            	    							current,
            	    							"param",
            	    							lv_param_2_0,
            	    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Or");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_ListParam"


    // $ANTLR start "entryRuleDSL_Expression_Or"
    // InternalSensinact.g:2059:1: entryRuleDSL_Expression_Or returns [EObject current=null] : iv_ruleDSL_Expression_Or= ruleDSL_Expression_Or EOF ;
    public final EObject entryRuleDSL_Expression_Or() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_Expression_Or = null;


        try {
            // InternalSensinact.g:2059:58: (iv_ruleDSL_Expression_Or= ruleDSL_Expression_Or EOF )
            // InternalSensinact.g:2060:2: iv_ruleDSL_Expression_Or= ruleDSL_Expression_Or EOF
            {
             newCompositeNode(grammarAccess.getDSL_Expression_OrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_Expression_Or=ruleDSL_Expression_Or();

            state._fsp--;

             current =iv_ruleDSL_Expression_Or; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_Expression_Or"


    // $ANTLR start "ruleDSL_Expression_Or"
    // InternalSensinact.g:2066:1: ruleDSL_Expression_Or returns [EObject current=null] : (this_DSL_Expression_And_0= ruleDSL_Expression_And (otherlv_1= 'or' () ( (lv_right_3_0= ruleDSL_Expression_And ) ) )* ) ;
    public final EObject ruleDSL_Expression_Or() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_DSL_Expression_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:2072:2: ( (this_DSL_Expression_And_0= ruleDSL_Expression_And (otherlv_1= 'or' () ( (lv_right_3_0= ruleDSL_Expression_And ) ) )* ) )
            // InternalSensinact.g:2073:2: (this_DSL_Expression_And_0= ruleDSL_Expression_And (otherlv_1= 'or' () ( (lv_right_3_0= ruleDSL_Expression_And ) ) )* )
            {
            // InternalSensinact.g:2073:2: (this_DSL_Expression_And_0= ruleDSL_Expression_And (otherlv_1= 'or' () ( (lv_right_3_0= ruleDSL_Expression_And ) ) )* )
            // InternalSensinact.g:2074:3: this_DSL_Expression_And_0= ruleDSL_Expression_And (otherlv_1= 'or' () ( (lv_right_3_0= ruleDSL_Expression_And ) ) )*
            {

            			newCompositeNode(grammarAccess.getDSL_Expression_OrAccess().getDSL_Expression_AndParserRuleCall_0());
            		
            pushFollow(FOLLOW_29);
            this_DSL_Expression_And_0=ruleDSL_Expression_And();

            state._fsp--;


            			current = this_DSL_Expression_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSensinact.g:2082:3: (otherlv_1= 'or' () ( (lv_right_3_0= ruleDSL_Expression_And ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==40) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSensinact.g:2083:4: otherlv_1= 'or' () ( (lv_right_3_0= ruleDSL_Expression_And ) )
            	    {
            	    otherlv_1=(Token)match(input,40,FOLLOW_14); 

            	    				newLeafNode(otherlv_1, grammarAccess.getDSL_Expression_OrAccess().getOrKeyword_1_0());
            	    			
            	    // InternalSensinact.g:2087:4: ()
            	    // InternalSensinact.g:2088:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getDSL_Expression_OrAccess().getDSL_Expression_OrLeftAction_1_1(),
            	    						current);
            	    				

            	    }

            	    // InternalSensinact.g:2094:4: ( (lv_right_3_0= ruleDSL_Expression_And ) )
            	    // InternalSensinact.g:2095:5: (lv_right_3_0= ruleDSL_Expression_And )
            	    {
            	    // InternalSensinact.g:2095:5: (lv_right_3_0= ruleDSL_Expression_And )
            	    // InternalSensinact.g:2096:6: lv_right_3_0= ruleDSL_Expression_And
            	    {

            	    						newCompositeNode(grammarAccess.getDSL_Expression_OrAccess().getRightDSL_Expression_AndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_right_3_0=ruleDSL_Expression_And();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDSL_Expression_OrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_And");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_Expression_Or"


    // $ANTLR start "entryRuleDSL_Expression_And"
    // InternalSensinact.g:2118:1: entryRuleDSL_Expression_And returns [EObject current=null] : iv_ruleDSL_Expression_And= ruleDSL_Expression_And EOF ;
    public final EObject entryRuleDSL_Expression_And() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_Expression_And = null;


        try {
            // InternalSensinact.g:2118:59: (iv_ruleDSL_Expression_And= ruleDSL_Expression_And EOF )
            // InternalSensinact.g:2119:2: iv_ruleDSL_Expression_And= ruleDSL_Expression_And EOF
            {
             newCompositeNode(grammarAccess.getDSL_Expression_AndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_Expression_And=ruleDSL_Expression_And();

            state._fsp--;

             current =iv_ruleDSL_Expression_And; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_Expression_And"


    // $ANTLR start "ruleDSL_Expression_And"
    // InternalSensinact.g:2125:1: ruleDSL_Expression_And returns [EObject current=null] : (this_DSL_Expression_DiffEqual_0= ruleDSL_Expression_DiffEqual (otherlv_1= 'and' () ( (lv_right_3_0= ruleDSL_Expression_DiffEqual ) ) )* ) ;
    public final EObject ruleDSL_Expression_And() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_DSL_Expression_DiffEqual_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:2131:2: ( (this_DSL_Expression_DiffEqual_0= ruleDSL_Expression_DiffEqual (otherlv_1= 'and' () ( (lv_right_3_0= ruleDSL_Expression_DiffEqual ) ) )* ) )
            // InternalSensinact.g:2132:2: (this_DSL_Expression_DiffEqual_0= ruleDSL_Expression_DiffEqual (otherlv_1= 'and' () ( (lv_right_3_0= ruleDSL_Expression_DiffEqual ) ) )* )
            {
            // InternalSensinact.g:2132:2: (this_DSL_Expression_DiffEqual_0= ruleDSL_Expression_DiffEqual (otherlv_1= 'and' () ( (lv_right_3_0= ruleDSL_Expression_DiffEqual ) ) )* )
            // InternalSensinact.g:2133:3: this_DSL_Expression_DiffEqual_0= ruleDSL_Expression_DiffEqual (otherlv_1= 'and' () ( (lv_right_3_0= ruleDSL_Expression_DiffEqual ) ) )*
            {

            			newCompositeNode(grammarAccess.getDSL_Expression_AndAccess().getDSL_Expression_DiffEqualParserRuleCall_0());
            		
            pushFollow(FOLLOW_30);
            this_DSL_Expression_DiffEqual_0=ruleDSL_Expression_DiffEqual();

            state._fsp--;


            			current = this_DSL_Expression_DiffEqual_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSensinact.g:2141:3: (otherlv_1= 'and' () ( (lv_right_3_0= ruleDSL_Expression_DiffEqual ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==41) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSensinact.g:2142:4: otherlv_1= 'and' () ( (lv_right_3_0= ruleDSL_Expression_DiffEqual ) )
            	    {
            	    otherlv_1=(Token)match(input,41,FOLLOW_14); 

            	    				newLeafNode(otherlv_1, grammarAccess.getDSL_Expression_AndAccess().getAndKeyword_1_0());
            	    			
            	    // InternalSensinact.g:2146:4: ()
            	    // InternalSensinact.g:2147:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getDSL_Expression_AndAccess().getDSL_Expression_AndLeftAction_1_1(),
            	    						current);
            	    				

            	    }

            	    // InternalSensinact.g:2153:4: ( (lv_right_3_0= ruleDSL_Expression_DiffEqual ) )
            	    // InternalSensinact.g:2154:5: (lv_right_3_0= ruleDSL_Expression_DiffEqual )
            	    {
            	    // InternalSensinact.g:2154:5: (lv_right_3_0= ruleDSL_Expression_DiffEqual )
            	    // InternalSensinact.g:2155:6: lv_right_3_0= ruleDSL_Expression_DiffEqual
            	    {

            	    						newCompositeNode(grammarAccess.getDSL_Expression_AndAccess().getRightDSL_Expression_DiffEqualParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_30);
            	    lv_right_3_0=ruleDSL_Expression_DiffEqual();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDSL_Expression_AndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_DiffEqual");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_Expression_And"


    // $ANTLR start "entryRuleDSL_Expression_DiffEqual"
    // InternalSensinact.g:2177:1: entryRuleDSL_Expression_DiffEqual returns [EObject current=null] : iv_ruleDSL_Expression_DiffEqual= ruleDSL_Expression_DiffEqual EOF ;
    public final EObject entryRuleDSL_Expression_DiffEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_Expression_DiffEqual = null;


        try {
            // InternalSensinact.g:2177:65: (iv_ruleDSL_Expression_DiffEqual= ruleDSL_Expression_DiffEqual EOF )
            // InternalSensinact.g:2178:2: iv_ruleDSL_Expression_DiffEqual= ruleDSL_Expression_DiffEqual EOF
            {
             newCompositeNode(grammarAccess.getDSL_Expression_DiffEqualRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_Expression_DiffEqual=ruleDSL_Expression_DiffEqual();

            state._fsp--;

             current =iv_ruleDSL_Expression_DiffEqual; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_Expression_DiffEqual"


    // $ANTLR start "ruleDSL_Expression_DiffEqual"
    // InternalSensinact.g:2184:1: ruleDSL_Expression_DiffEqual returns [EObject current=null] : (this_DSL_Expression_Compare_0= ruleDSL_Expression_Compare ( (otherlv_1= '!=' () ( (lv_right_3_0= ruleDSL_Expression_Compare ) ) ) | (otherlv_4= '==' () ( (lv_right_6_0= ruleDSL_Expression_Compare ) ) ) )* ) ;
    public final EObject ruleDSL_Expression_DiffEqual() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_DSL_Expression_Compare_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:2190:2: ( (this_DSL_Expression_Compare_0= ruleDSL_Expression_Compare ( (otherlv_1= '!=' () ( (lv_right_3_0= ruleDSL_Expression_Compare ) ) ) | (otherlv_4= '==' () ( (lv_right_6_0= ruleDSL_Expression_Compare ) ) ) )* ) )
            // InternalSensinact.g:2191:2: (this_DSL_Expression_Compare_0= ruleDSL_Expression_Compare ( (otherlv_1= '!=' () ( (lv_right_3_0= ruleDSL_Expression_Compare ) ) ) | (otherlv_4= '==' () ( (lv_right_6_0= ruleDSL_Expression_Compare ) ) ) )* )
            {
            // InternalSensinact.g:2191:2: (this_DSL_Expression_Compare_0= ruleDSL_Expression_Compare ( (otherlv_1= '!=' () ( (lv_right_3_0= ruleDSL_Expression_Compare ) ) ) | (otherlv_4= '==' () ( (lv_right_6_0= ruleDSL_Expression_Compare ) ) ) )* )
            // InternalSensinact.g:2192:3: this_DSL_Expression_Compare_0= ruleDSL_Expression_Compare ( (otherlv_1= '!=' () ( (lv_right_3_0= ruleDSL_Expression_Compare ) ) ) | (otherlv_4= '==' () ( (lv_right_6_0= ruleDSL_Expression_Compare ) ) ) )*
            {

            			newCompositeNode(grammarAccess.getDSL_Expression_DiffEqualAccess().getDSL_Expression_CompareParserRuleCall_0());
            		
            pushFollow(FOLLOW_31);
            this_DSL_Expression_Compare_0=ruleDSL_Expression_Compare();

            state._fsp--;


            			current = this_DSL_Expression_Compare_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSensinact.g:2200:3: ( (otherlv_1= '!=' () ( (lv_right_3_0= ruleDSL_Expression_Compare ) ) ) | (otherlv_4= '==' () ( (lv_right_6_0= ruleDSL_Expression_Compare ) ) ) )*
            loop20:
            do {
                int alt20=3;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==42) ) {
                    alt20=1;
                }
                else if ( (LA20_0==43) ) {
                    alt20=2;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSensinact.g:2201:4: (otherlv_1= '!=' () ( (lv_right_3_0= ruleDSL_Expression_Compare ) ) )
            	    {
            	    // InternalSensinact.g:2201:4: (otherlv_1= '!=' () ( (lv_right_3_0= ruleDSL_Expression_Compare ) ) )
            	    // InternalSensinact.g:2202:5: otherlv_1= '!=' () ( (lv_right_3_0= ruleDSL_Expression_Compare ) )
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_14); 

            	    					newLeafNode(otherlv_1, grammarAccess.getDSL_Expression_DiffEqualAccess().getExclamationMarkEqualsSignKeyword_1_0_0());
            	    				
            	    // InternalSensinact.g:2206:5: ()
            	    // InternalSensinact.g:2207:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_DiffEqualAccess().getDSL_Expression_DiffLeftAction_1_0_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2213:5: ( (lv_right_3_0= ruleDSL_Expression_Compare ) )
            	    // InternalSensinact.g:2214:6: (lv_right_3_0= ruleDSL_Expression_Compare )
            	    {
            	    // InternalSensinact.g:2214:6: (lv_right_3_0= ruleDSL_Expression_Compare )
            	    // InternalSensinact.g:2215:7: lv_right_3_0= ruleDSL_Expression_Compare
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightDSL_Expression_CompareParserRuleCall_1_0_2_0());
            	    						
            	    pushFollow(FOLLOW_31);
            	    lv_right_3_0=ruleDSL_Expression_Compare();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_DiffEqualRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_3_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Compare");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSensinact.g:2234:4: (otherlv_4= '==' () ( (lv_right_6_0= ruleDSL_Expression_Compare ) ) )
            	    {
            	    // InternalSensinact.g:2234:4: (otherlv_4= '==' () ( (lv_right_6_0= ruleDSL_Expression_Compare ) ) )
            	    // InternalSensinact.g:2235:5: otherlv_4= '==' () ( (lv_right_6_0= ruleDSL_Expression_Compare ) )
            	    {
            	    otherlv_4=(Token)match(input,43,FOLLOW_14); 

            	    					newLeafNode(otherlv_4, grammarAccess.getDSL_Expression_DiffEqualAccess().getEqualsSignEqualsSignKeyword_1_1_0());
            	    				
            	    // InternalSensinact.g:2239:5: ()
            	    // InternalSensinact.g:2240:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_DiffEqualAccess().getDSL_Expression_EqualLeftAction_1_1_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2246:5: ( (lv_right_6_0= ruleDSL_Expression_Compare ) )
            	    // InternalSensinact.g:2247:6: (lv_right_6_0= ruleDSL_Expression_Compare )
            	    {
            	    // InternalSensinact.g:2247:6: (lv_right_6_0= ruleDSL_Expression_Compare )
            	    // InternalSensinact.g:2248:7: lv_right_6_0= ruleDSL_Expression_Compare
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_DiffEqualAccess().getRightDSL_Expression_CompareParserRuleCall_1_1_2_0());
            	    						
            	    pushFollow(FOLLOW_31);
            	    lv_right_6_0=ruleDSL_Expression_Compare();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_DiffEqualRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_6_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Compare");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_Expression_DiffEqual"


    // $ANTLR start "entryRuleDSL_Expression_Compare"
    // InternalSensinact.g:2271:1: entryRuleDSL_Expression_Compare returns [EObject current=null] : iv_ruleDSL_Expression_Compare= ruleDSL_Expression_Compare EOF ;
    public final EObject entryRuleDSL_Expression_Compare() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_Expression_Compare = null;


        try {
            // InternalSensinact.g:2271:63: (iv_ruleDSL_Expression_Compare= ruleDSL_Expression_Compare EOF )
            // InternalSensinact.g:2272:2: iv_ruleDSL_Expression_Compare= ruleDSL_Expression_Compare EOF
            {
             newCompositeNode(grammarAccess.getDSL_Expression_CompareRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_Expression_Compare=ruleDSL_Expression_Compare();

            state._fsp--;

             current =iv_ruleDSL_Expression_Compare; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_Expression_Compare"


    // $ANTLR start "ruleDSL_Expression_Compare"
    // InternalSensinact.g:2278:1: ruleDSL_Expression_Compare returns [EObject current=null] : (this_DSL_Expression_PlusMinus_0= ruleDSL_Expression_PlusMinus ( (otherlv_1= '>' () ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_4= '>=' () ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_7= '<' () ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_10= '<=' () ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) ) ) )* ) ;
    public final EObject ruleDSL_Expression_Compare() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject this_DSL_Expression_PlusMinus_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;

        EObject lv_right_9_0 = null;

        EObject lv_right_12_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:2284:2: ( (this_DSL_Expression_PlusMinus_0= ruleDSL_Expression_PlusMinus ( (otherlv_1= '>' () ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_4= '>=' () ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_7= '<' () ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_10= '<=' () ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) ) ) )* ) )
            // InternalSensinact.g:2285:2: (this_DSL_Expression_PlusMinus_0= ruleDSL_Expression_PlusMinus ( (otherlv_1= '>' () ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_4= '>=' () ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_7= '<' () ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_10= '<=' () ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) ) ) )* )
            {
            // InternalSensinact.g:2285:2: (this_DSL_Expression_PlusMinus_0= ruleDSL_Expression_PlusMinus ( (otherlv_1= '>' () ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_4= '>=' () ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_7= '<' () ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_10= '<=' () ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) ) ) )* )
            // InternalSensinact.g:2286:3: this_DSL_Expression_PlusMinus_0= ruleDSL_Expression_PlusMinus ( (otherlv_1= '>' () ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_4= '>=' () ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_7= '<' () ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_10= '<=' () ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) ) ) )*
            {

            			newCompositeNode(grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_PlusMinusParserRuleCall_0());
            		
            pushFollow(FOLLOW_32);
            this_DSL_Expression_PlusMinus_0=ruleDSL_Expression_PlusMinus();

            state._fsp--;


            			current = this_DSL_Expression_PlusMinus_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSensinact.g:2294:3: ( (otherlv_1= '>' () ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_4= '>=' () ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_7= '<' () ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) ) ) | (otherlv_10= '<=' () ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) ) ) )*
            loop21:
            do {
                int alt21=5;
                switch ( input.LA(1) ) {
                case 44:
                    {
                    alt21=1;
                    }
                    break;
                case 45:
                    {
                    alt21=2;
                    }
                    break;
                case 46:
                    {
                    alt21=3;
                    }
                    break;
                case 47:
                    {
                    alt21=4;
                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // InternalSensinact.g:2295:4: (otherlv_1= '>' () ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) ) )
            	    {
            	    // InternalSensinact.g:2295:4: (otherlv_1= '>' () ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) ) )
            	    // InternalSensinact.g:2296:5: otherlv_1= '>' () ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) )
            	    {
            	    otherlv_1=(Token)match(input,44,FOLLOW_14); 

            	    					newLeafNode(otherlv_1, grammarAccess.getDSL_Expression_CompareAccess().getGreaterThanSignKeyword_1_0_0());
            	    				
            	    // InternalSensinact.g:2300:5: ()
            	    // InternalSensinact.g:2301:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_LargerLeftAction_1_0_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2307:5: ( (lv_right_3_0= ruleDSL_Expression_PlusMinus ) )
            	    // InternalSensinact.g:2308:6: (lv_right_3_0= ruleDSL_Expression_PlusMinus )
            	    {
            	    // InternalSensinact.g:2308:6: (lv_right_3_0= ruleDSL_Expression_PlusMinus )
            	    // InternalSensinact.g:2309:7: lv_right_3_0= ruleDSL_Expression_PlusMinus
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_0_2_0());
            	    						
            	    pushFollow(FOLLOW_32);
            	    lv_right_3_0=ruleDSL_Expression_PlusMinus();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_CompareRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_3_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_PlusMinus");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSensinact.g:2328:4: (otherlv_4= '>=' () ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) ) )
            	    {
            	    // InternalSensinact.g:2328:4: (otherlv_4= '>=' () ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) ) )
            	    // InternalSensinact.g:2329:5: otherlv_4= '>=' () ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) )
            	    {
            	    otherlv_4=(Token)match(input,45,FOLLOW_14); 

            	    					newLeafNode(otherlv_4, grammarAccess.getDSL_Expression_CompareAccess().getGreaterThanSignEqualsSignKeyword_1_1_0());
            	    				
            	    // InternalSensinact.g:2333:5: ()
            	    // InternalSensinact.g:2334:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_Larger_EqualLeftAction_1_1_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2340:5: ( (lv_right_6_0= ruleDSL_Expression_PlusMinus ) )
            	    // InternalSensinact.g:2341:6: (lv_right_6_0= ruleDSL_Expression_PlusMinus )
            	    {
            	    // InternalSensinact.g:2341:6: (lv_right_6_0= ruleDSL_Expression_PlusMinus )
            	    // InternalSensinact.g:2342:7: lv_right_6_0= ruleDSL_Expression_PlusMinus
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_1_2_0());
            	    						
            	    pushFollow(FOLLOW_32);
            	    lv_right_6_0=ruleDSL_Expression_PlusMinus();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_CompareRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_6_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_PlusMinus");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSensinact.g:2361:4: (otherlv_7= '<' () ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) ) )
            	    {
            	    // InternalSensinact.g:2361:4: (otherlv_7= '<' () ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) ) )
            	    // InternalSensinact.g:2362:5: otherlv_7= '<' () ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) )
            	    {
            	    otherlv_7=(Token)match(input,46,FOLLOW_14); 

            	    					newLeafNode(otherlv_7, grammarAccess.getDSL_Expression_CompareAccess().getLessThanSignKeyword_1_2_0());
            	    				
            	    // InternalSensinact.g:2366:5: ()
            	    // InternalSensinact.g:2367:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_SmallerLeftAction_1_2_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2373:5: ( (lv_right_9_0= ruleDSL_Expression_PlusMinus ) )
            	    // InternalSensinact.g:2374:6: (lv_right_9_0= ruleDSL_Expression_PlusMinus )
            	    {
            	    // InternalSensinact.g:2374:6: (lv_right_9_0= ruleDSL_Expression_PlusMinus )
            	    // InternalSensinact.g:2375:7: lv_right_9_0= ruleDSL_Expression_PlusMinus
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_2_2_0());
            	    						
            	    pushFollow(FOLLOW_32);
            	    lv_right_9_0=ruleDSL_Expression_PlusMinus();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_CompareRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_9_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_PlusMinus");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalSensinact.g:2394:4: (otherlv_10= '<=' () ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) ) )
            	    {
            	    // InternalSensinact.g:2394:4: (otherlv_10= '<=' () ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) ) )
            	    // InternalSensinact.g:2395:5: otherlv_10= '<=' () ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) )
            	    {
            	    otherlv_10=(Token)match(input,47,FOLLOW_14); 

            	    					newLeafNode(otherlv_10, grammarAccess.getDSL_Expression_CompareAccess().getLessThanSignEqualsSignKeyword_1_3_0());
            	    				
            	    // InternalSensinact.g:2399:5: ()
            	    // InternalSensinact.g:2400:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_CompareAccess().getDSL_Expression_Smaller_EqualLeftAction_1_3_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2406:5: ( (lv_right_12_0= ruleDSL_Expression_PlusMinus ) )
            	    // InternalSensinact.g:2407:6: (lv_right_12_0= ruleDSL_Expression_PlusMinus )
            	    {
            	    // InternalSensinact.g:2407:6: (lv_right_12_0= ruleDSL_Expression_PlusMinus )
            	    // InternalSensinact.g:2408:7: lv_right_12_0= ruleDSL_Expression_PlusMinus
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_CompareAccess().getRightDSL_Expression_PlusMinusParserRuleCall_1_3_2_0());
            	    						
            	    pushFollow(FOLLOW_32);
            	    lv_right_12_0=ruleDSL_Expression_PlusMinus();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_CompareRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_12_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_PlusMinus");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_Expression_Compare"


    // $ANTLR start "entryRuleDSL_Expression_PlusMinus"
    // InternalSensinact.g:2431:1: entryRuleDSL_Expression_PlusMinus returns [EObject current=null] : iv_ruleDSL_Expression_PlusMinus= ruleDSL_Expression_PlusMinus EOF ;
    public final EObject entryRuleDSL_Expression_PlusMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_Expression_PlusMinus = null;


        try {
            // InternalSensinact.g:2431:65: (iv_ruleDSL_Expression_PlusMinus= ruleDSL_Expression_PlusMinus EOF )
            // InternalSensinact.g:2432:2: iv_ruleDSL_Expression_PlusMinus= ruleDSL_Expression_PlusMinus EOF
            {
             newCompositeNode(grammarAccess.getDSL_Expression_PlusMinusRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_Expression_PlusMinus=ruleDSL_Expression_PlusMinus();

            state._fsp--;

             current =iv_ruleDSL_Expression_PlusMinus; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_Expression_PlusMinus"


    // $ANTLR start "ruleDSL_Expression_PlusMinus"
    // InternalSensinact.g:2438:1: ruleDSL_Expression_PlusMinus returns [EObject current=null] : (this_DSL_Expression_MultiplicationDivision_0= ruleDSL_Expression_MultiplicationDivision ( (otherlv_1= '+' () ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) ) ) )* ) ;
    public final EObject ruleDSL_Expression_PlusMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_DSL_Expression_MultiplicationDivision_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:2444:2: ( (this_DSL_Expression_MultiplicationDivision_0= ruleDSL_Expression_MultiplicationDivision ( (otherlv_1= '+' () ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) ) ) )* ) )
            // InternalSensinact.g:2445:2: (this_DSL_Expression_MultiplicationDivision_0= ruleDSL_Expression_MultiplicationDivision ( (otherlv_1= '+' () ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) ) ) )* )
            {
            // InternalSensinact.g:2445:2: (this_DSL_Expression_MultiplicationDivision_0= ruleDSL_Expression_MultiplicationDivision ( (otherlv_1= '+' () ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) ) ) )* )
            // InternalSensinact.g:2446:3: this_DSL_Expression_MultiplicationDivision_0= ruleDSL_Expression_MultiplicationDivision ( (otherlv_1= '+' () ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) ) ) )*
            {

            			newCompositeNode(grammarAccess.getDSL_Expression_PlusMinusAccess().getDSL_Expression_MultiplicationDivisionParserRuleCall_0());
            		
            pushFollow(FOLLOW_33);
            this_DSL_Expression_MultiplicationDivision_0=ruleDSL_Expression_MultiplicationDivision();

            state._fsp--;


            			current = this_DSL_Expression_MultiplicationDivision_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSensinact.g:2454:3: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) ) ) )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==48) ) {
                    alt22=1;
                }
                else if ( (LA22_0==49) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalSensinact.g:2455:4: (otherlv_1= '+' () ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) ) )
            	    {
            	    // InternalSensinact.g:2455:4: (otherlv_1= '+' () ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) ) )
            	    // InternalSensinact.g:2456:5: otherlv_1= '+' () ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_14); 

            	    					newLeafNode(otherlv_1, grammarAccess.getDSL_Expression_PlusMinusAccess().getPlusSignKeyword_1_0_0());
            	    				
            	    // InternalSensinact.g:2460:5: ()
            	    // InternalSensinact.g:2461:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_PlusMinusAccess().getDSL_Expression_PlusLeftAction_1_0_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2467:5: ( (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision ) )
            	    // InternalSensinact.g:2468:6: (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision )
            	    {
            	    // InternalSensinact.g:2468:6: (lv_right_3_0= ruleDSL_Expression_MultiplicationDivision )
            	    // InternalSensinact.g:2469:7: lv_right_3_0= ruleDSL_Expression_MultiplicationDivision
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightDSL_Expression_MultiplicationDivisionParserRuleCall_1_0_2_0());
            	    						
            	    pushFollow(FOLLOW_33);
            	    lv_right_3_0=ruleDSL_Expression_MultiplicationDivision();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_PlusMinusRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_3_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_MultiplicationDivision");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSensinact.g:2488:4: (otherlv_4= '-' () ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) ) )
            	    {
            	    // InternalSensinact.g:2488:4: (otherlv_4= '-' () ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) ) )
            	    // InternalSensinact.g:2489:5: otherlv_4= '-' () ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) )
            	    {
            	    otherlv_4=(Token)match(input,49,FOLLOW_14); 

            	    					newLeafNode(otherlv_4, grammarAccess.getDSL_Expression_PlusMinusAccess().getHyphenMinusKeyword_1_1_0());
            	    				
            	    // InternalSensinact.g:2493:5: ()
            	    // InternalSensinact.g:2494:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_PlusMinusAccess().getDSL_Expression_MinusLeftAction_1_1_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2500:5: ( (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision ) )
            	    // InternalSensinact.g:2501:6: (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision )
            	    {
            	    // InternalSensinact.g:2501:6: (lv_right_6_0= ruleDSL_Expression_MultiplicationDivision )
            	    // InternalSensinact.g:2502:7: lv_right_6_0= ruleDSL_Expression_MultiplicationDivision
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_PlusMinusAccess().getRightDSL_Expression_MultiplicationDivisionParserRuleCall_1_1_2_0());
            	    						
            	    pushFollow(FOLLOW_33);
            	    lv_right_6_0=ruleDSL_Expression_MultiplicationDivision();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_PlusMinusRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_6_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_MultiplicationDivision");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_Expression_PlusMinus"


    // $ANTLR start "entryRuleDSL_Expression_MultiplicationDivision"
    // InternalSensinact.g:2525:1: entryRuleDSL_Expression_MultiplicationDivision returns [EObject current=null] : iv_ruleDSL_Expression_MultiplicationDivision= ruleDSL_Expression_MultiplicationDivision EOF ;
    public final EObject entryRuleDSL_Expression_MultiplicationDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_Expression_MultiplicationDivision = null;


        try {
            // InternalSensinact.g:2525:78: (iv_ruleDSL_Expression_MultiplicationDivision= ruleDSL_Expression_MultiplicationDivision EOF )
            // InternalSensinact.g:2526:2: iv_ruleDSL_Expression_MultiplicationDivision= ruleDSL_Expression_MultiplicationDivision EOF
            {
             newCompositeNode(grammarAccess.getDSL_Expression_MultiplicationDivisionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_Expression_MultiplicationDivision=ruleDSL_Expression_MultiplicationDivision();

            state._fsp--;

             current =iv_ruleDSL_Expression_MultiplicationDivision; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_Expression_MultiplicationDivision"


    // $ANTLR start "ruleDSL_Expression_MultiplicationDivision"
    // InternalSensinact.g:2532:1: ruleDSL_Expression_MultiplicationDivision returns [EObject current=null] : (this_DSL_Expression_Unary_0= ruleDSL_Expression_Unary ( (otherlv_1= '*' () ( (lv_right_3_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleDSL_Expression_Unary ) ) ) )* ) ;
    public final EObject ruleDSL_Expression_MultiplicationDivision() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject this_DSL_Expression_Unary_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;

        EObject lv_right_9_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:2538:2: ( (this_DSL_Expression_Unary_0= ruleDSL_Expression_Unary ( (otherlv_1= '*' () ( (lv_right_3_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleDSL_Expression_Unary ) ) ) )* ) )
            // InternalSensinact.g:2539:2: (this_DSL_Expression_Unary_0= ruleDSL_Expression_Unary ( (otherlv_1= '*' () ( (lv_right_3_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleDSL_Expression_Unary ) ) ) )* )
            {
            // InternalSensinact.g:2539:2: (this_DSL_Expression_Unary_0= ruleDSL_Expression_Unary ( (otherlv_1= '*' () ( (lv_right_3_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleDSL_Expression_Unary ) ) ) )* )
            // InternalSensinact.g:2540:3: this_DSL_Expression_Unary_0= ruleDSL_Expression_Unary ( (otherlv_1= '*' () ( (lv_right_3_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleDSL_Expression_Unary ) ) ) )*
            {

            			newCompositeNode(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_UnaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_34);
            this_DSL_Expression_Unary_0=ruleDSL_Expression_Unary();

            state._fsp--;


            			current = this_DSL_Expression_Unary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSensinact.g:2548:3: ( (otherlv_1= '*' () ( (lv_right_3_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleDSL_Expression_Unary ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleDSL_Expression_Unary ) ) ) )*
            loop23:
            do {
                int alt23=4;
                switch ( input.LA(1) ) {
                case 50:
                    {
                    alt23=1;
                    }
                    break;
                case 15:
                    {
                    alt23=2;
                    }
                    break;
                case 51:
                    {
                    alt23=3;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // InternalSensinact.g:2549:4: (otherlv_1= '*' () ( (lv_right_3_0= ruleDSL_Expression_Unary ) ) )
            	    {
            	    // InternalSensinact.g:2549:4: (otherlv_1= '*' () ( (lv_right_3_0= ruleDSL_Expression_Unary ) ) )
            	    // InternalSensinact.g:2550:5: otherlv_1= '*' () ( (lv_right_3_0= ruleDSL_Expression_Unary ) )
            	    {
            	    otherlv_1=(Token)match(input,50,FOLLOW_14); 

            	    					newLeafNode(otherlv_1, grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getAsteriskKeyword_1_0_0());
            	    				
            	    // InternalSensinact.g:2554:5: ()
            	    // InternalSensinact.g:2555:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_MultiplicationLeftAction_1_0_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2561:5: ( (lv_right_3_0= ruleDSL_Expression_Unary ) )
            	    // InternalSensinact.g:2562:6: (lv_right_3_0= ruleDSL_Expression_Unary )
            	    {
            	    // InternalSensinact.g:2562:6: (lv_right_3_0= ruleDSL_Expression_Unary )
            	    // InternalSensinact.g:2563:7: lv_right_3_0= ruleDSL_Expression_Unary
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightDSL_Expression_UnaryParserRuleCall_1_0_2_0());
            	    						
            	    pushFollow(FOLLOW_34);
            	    lv_right_3_0=ruleDSL_Expression_Unary();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_MultiplicationDivisionRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_3_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Unary");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSensinact.g:2582:4: (otherlv_4= '/' () ( (lv_right_6_0= ruleDSL_Expression_Unary ) ) )
            	    {
            	    // InternalSensinact.g:2582:4: (otherlv_4= '/' () ( (lv_right_6_0= ruleDSL_Expression_Unary ) ) )
            	    // InternalSensinact.g:2583:5: otherlv_4= '/' () ( (lv_right_6_0= ruleDSL_Expression_Unary ) )
            	    {
            	    otherlv_4=(Token)match(input,15,FOLLOW_14); 

            	    					newLeafNode(otherlv_4, grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getSolidusKeyword_1_1_0());
            	    				
            	    // InternalSensinact.g:2587:5: ()
            	    // InternalSensinact.g:2588:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_DivisionLeftAction_1_1_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2594:5: ( (lv_right_6_0= ruleDSL_Expression_Unary ) )
            	    // InternalSensinact.g:2595:6: (lv_right_6_0= ruleDSL_Expression_Unary )
            	    {
            	    // InternalSensinact.g:2595:6: (lv_right_6_0= ruleDSL_Expression_Unary )
            	    // InternalSensinact.g:2596:7: lv_right_6_0= ruleDSL_Expression_Unary
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightDSL_Expression_UnaryParserRuleCall_1_1_2_0());
            	    						
            	    pushFollow(FOLLOW_34);
            	    lv_right_6_0=ruleDSL_Expression_Unary();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_MultiplicationDivisionRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_6_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Unary");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSensinact.g:2615:4: (otherlv_7= '%' () ( (lv_right_9_0= ruleDSL_Expression_Unary ) ) )
            	    {
            	    // InternalSensinact.g:2615:4: (otherlv_7= '%' () ( (lv_right_9_0= ruleDSL_Expression_Unary ) ) )
            	    // InternalSensinact.g:2616:5: otherlv_7= '%' () ( (lv_right_9_0= ruleDSL_Expression_Unary ) )
            	    {
            	    otherlv_7=(Token)match(input,51,FOLLOW_14); 

            	    					newLeafNode(otherlv_7, grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getPercentSignKeyword_1_2_0());
            	    				
            	    // InternalSensinact.g:2620:5: ()
            	    // InternalSensinact.g:2621:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getDSL_Expression_ModuloLeftAction_1_2_1(),
            	    							current);
            	    					

            	    }

            	    // InternalSensinact.g:2627:5: ( (lv_right_9_0= ruleDSL_Expression_Unary ) )
            	    // InternalSensinact.g:2628:6: (lv_right_9_0= ruleDSL_Expression_Unary )
            	    {
            	    // InternalSensinact.g:2628:6: (lv_right_9_0= ruleDSL_Expression_Unary )
            	    // InternalSensinact.g:2629:7: lv_right_9_0= ruleDSL_Expression_Unary
            	    {

            	    							newCompositeNode(grammarAccess.getDSL_Expression_MultiplicationDivisionAccess().getRightDSL_Expression_UnaryParserRuleCall_1_2_2_0());
            	    						
            	    pushFollow(FOLLOW_34);
            	    lv_right_9_0=ruleDSL_Expression_Unary();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getDSL_Expression_MultiplicationDivisionRule());
            	    							}
            	    							set(
            	    								current,
            	    								"right",
            	    								lv_right_9_0,
            	    								"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Unary");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_Expression_MultiplicationDivision"


    // $ANTLR start "entryRuleDSL_Expression_Unary"
    // InternalSensinact.g:2652:1: entryRuleDSL_Expression_Unary returns [EObject current=null] : iv_ruleDSL_Expression_Unary= ruleDSL_Expression_Unary EOF ;
    public final EObject entryRuleDSL_Expression_Unary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSL_Expression_Unary = null;


        try {
            // InternalSensinact.g:2652:61: (iv_ruleDSL_Expression_Unary= ruleDSL_Expression_Unary EOF )
            // InternalSensinact.g:2653:2: iv_ruleDSL_Expression_Unary= ruleDSL_Expression_Unary EOF
            {
             newCompositeNode(grammarAccess.getDSL_Expression_UnaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSL_Expression_Unary=ruleDSL_Expression_Unary();

            state._fsp--;

             current =iv_ruleDSL_Expression_Unary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSL_Expression_Unary"


    // $ANTLR start "ruleDSL_Expression_Unary"
    // InternalSensinact.g:2659:1: ruleDSL_Expression_Unary returns [EObject current=null] : ( ( () ( (lv_value_1_0= ruleNUMBER ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) otherlv_8= '.get()' ) | (otherlv_9= '(' this_DSL_Expression_Or_10= ruleDSL_Expression_Or otherlv_11= ')' ) | (otherlv_12= 'not' () ( (lv_exp_14_0= ruleDSL_Expression_Unary ) ) ) ) ;
    public final EObject ruleDSL_Expression_Unary() throws RecognitionException {
        EObject current = null;

        Token lv_value_3_0=null;
        Token lv_value_5_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;

        EObject this_DSL_Expression_Or_10 = null;

        EObject lv_exp_14_0 = null;



        	enterRule();

        try {
            // InternalSensinact.g:2665:2: ( ( ( () ( (lv_value_1_0= ruleNUMBER ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) otherlv_8= '.get()' ) | (otherlv_9= '(' this_DSL_Expression_Or_10= ruleDSL_Expression_Or otherlv_11= ')' ) | (otherlv_12= 'not' () ( (lv_exp_14_0= ruleDSL_Expression_Unary ) ) ) ) )
            // InternalSensinact.g:2666:2: ( ( () ( (lv_value_1_0= ruleNUMBER ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) otherlv_8= '.get()' ) | (otherlv_9= '(' this_DSL_Expression_Or_10= ruleDSL_Expression_Or otherlv_11= ')' ) | (otherlv_12= 'not' () ( (lv_exp_14_0= ruleDSL_Expression_Unary ) ) ) )
            {
            // InternalSensinact.g:2666:2: ( ( () ( (lv_value_1_0= ruleNUMBER ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) otherlv_8= '.get()' ) | (otherlv_9= '(' this_DSL_Expression_Or_10= ruleDSL_Expression_Or otherlv_11= ')' ) | (otherlv_12= 'not' () ( (lv_exp_14_0= ruleDSL_Expression_Unary ) ) ) )
            int alt24=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt24=1;
                }
                break;
            case RULE_STRING:
                {
                alt24=2;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt24=3;
                }
                break;
            case RULE_ID:
                {
                alt24=4;
                }
                break;
            case 26:
                {
                alt24=5;
                }
                break;
            case 53:
                {
                alt24=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalSensinact.g:2667:3: ( () ( (lv_value_1_0= ruleNUMBER ) ) )
                    {
                    // InternalSensinact.g:2667:3: ( () ( (lv_value_1_0= ruleNUMBER ) ) )
                    // InternalSensinact.g:2668:4: () ( (lv_value_1_0= ruleNUMBER ) )
                    {
                    // InternalSensinact.g:2668:4: ()
                    // InternalSensinact.g:2669:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_NumberAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSensinact.g:2675:4: ( (lv_value_1_0= ruleNUMBER ) )
                    // InternalSensinact.g:2676:5: (lv_value_1_0= ruleNUMBER )
                    {
                    // InternalSensinact.g:2676:5: (lv_value_1_0= ruleNUMBER )
                    // InternalSensinact.g:2677:6: lv_value_1_0= ruleNUMBER
                    {

                    						newCompositeNode(grammarAccess.getDSL_Expression_UnaryAccess().getValueNUMBERParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleNUMBER();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_Expression_UnaryRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_1_0,
                    							"org.eclipse.sensinact.studio.language.Sensinact.NUMBER");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSensinact.g:2696:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    {
                    // InternalSensinact.g:2696:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    // InternalSensinact.g:2697:4: () ( (lv_value_3_0= RULE_STRING ) )
                    {
                    // InternalSensinact.g:2697:4: ()
                    // InternalSensinact.g:2698:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_StringAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSensinact.g:2704:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalSensinact.g:2705:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalSensinact.g:2705:5: (lv_value_3_0= RULE_STRING )
                    // InternalSensinact.g:2706:6: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getDSL_Expression_UnaryAccess().getValueSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSL_Expression_UnaryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSensinact.g:2724:3: ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) )
                    {
                    // InternalSensinact.g:2724:3: ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) )
                    // InternalSensinact.g:2725:4: () ( (lv_value_5_0= RULE_BOOLEAN ) )
                    {
                    // InternalSensinact.g:2725:4: ()
                    // InternalSensinact.g:2726:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_BooleanAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSensinact.g:2732:4: ( (lv_value_5_0= RULE_BOOLEAN ) )
                    // InternalSensinact.g:2733:5: (lv_value_5_0= RULE_BOOLEAN )
                    {
                    // InternalSensinact.g:2733:5: (lv_value_5_0= RULE_BOOLEAN )
                    // InternalSensinact.g:2734:6: lv_value_5_0= RULE_BOOLEAN
                    {
                    lv_value_5_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

                    						newLeafNode(lv_value_5_0, grammarAccess.getDSL_Expression_UnaryAccess().getValueBOOLEANTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSL_Expression_UnaryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"org.eclipse.sensinact.studio.language.Sensinact.BOOLEAN");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSensinact.g:2752:3: ( () ( (otherlv_7= RULE_ID ) ) otherlv_8= '.get()' )
                    {
                    // InternalSensinact.g:2752:3: ( () ( (otherlv_7= RULE_ID ) ) otherlv_8= '.get()' )
                    // InternalSensinact.g:2753:4: () ( (otherlv_7= RULE_ID ) ) otherlv_8= '.get()'
                    {
                    // InternalSensinact.g:2753:4: ()
                    // InternalSensinact.g:2754:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Object_RefAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSensinact.g:2760:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSensinact.g:2761:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSensinact.g:2761:5: (otherlv_7= RULE_ID )
                    // InternalSensinact.g:2762:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSL_Expression_UnaryRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_35); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSL_Expression_UnaryAccess().getValueDSL_REFCrossReference_3_1_0());
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,52,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getDSL_Expression_UnaryAccess().getGetKeyword_3_2());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSensinact.g:2779:3: (otherlv_9= '(' this_DSL_Expression_Or_10= ruleDSL_Expression_Or otherlv_11= ')' )
                    {
                    // InternalSensinact.g:2779:3: (otherlv_9= '(' this_DSL_Expression_Or_10= ruleDSL_Expression_Or otherlv_11= ')' )
                    // InternalSensinact.g:2780:4: otherlv_9= '(' this_DSL_Expression_Or_10= ruleDSL_Expression_Or otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,26,FOLLOW_14); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSL_Expression_UnaryAccess().getLeftParenthesisKeyword_4_0());
                    			

                    				newCompositeNode(grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Expression_OrParserRuleCall_4_1());
                    			
                    pushFollow(FOLLOW_21);
                    this_DSL_Expression_Or_10=ruleDSL_Expression_Or();

                    state._fsp--;


                    				current = this_DSL_Expression_Or_10;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_11=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSL_Expression_UnaryAccess().getRightParenthesisKeyword_4_2());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSensinact.g:2798:3: (otherlv_12= 'not' () ( (lv_exp_14_0= ruleDSL_Expression_Unary ) ) )
                    {
                    // InternalSensinact.g:2798:3: (otherlv_12= 'not' () ( (lv_exp_14_0= ruleDSL_Expression_Unary ) ) )
                    // InternalSensinact.g:2799:4: otherlv_12= 'not' () ( (lv_exp_14_0= ruleDSL_Expression_Unary ) )
                    {
                    otherlv_12=(Token)match(input,53,FOLLOW_14); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSL_Expression_UnaryAccess().getNotKeyword_5_0());
                    			
                    // InternalSensinact.g:2803:4: ()
                    // InternalSensinact.g:2804:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDSL_Expression_UnaryAccess().getDSL_Expression_NegateAction_5_1(),
                    						current);
                    				

                    }

                    // InternalSensinact.g:2810:4: ( (lv_exp_14_0= ruleDSL_Expression_Unary ) )
                    // InternalSensinact.g:2811:5: (lv_exp_14_0= ruleDSL_Expression_Unary )
                    {
                    // InternalSensinact.g:2811:5: (lv_exp_14_0= ruleDSL_Expression_Unary )
                    // InternalSensinact.g:2812:6: lv_exp_14_0= ruleDSL_Expression_Unary
                    {

                    						newCompositeNode(grammarAccess.getDSL_Expression_UnaryAccess().getExpDSL_Expression_UnaryParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_exp_14_0=ruleDSL_Expression_Unary();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSL_Expression_UnaryRule());
                    						}
                    						set(
                    							current,
                    							"exp",
                    							lv_exp_14_0,
                    							"org.eclipse.sensinact.studio.language.Sensinact.DSL_Expression_Unary");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSL_Expression_Unary"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    static final String dfa_1s = "\10\uffff";
    static final String dfa_2s = "\1\5\1\30\3\5\2\uffff\1\40";
    static final String dfa_3s = "\1\5\1\45\2\33\1\5\2\uffff\1\45";
    static final String dfa_4s = "\5\uffff\1\1\1\2\1\uffff";
    static final String dfa_5s = "\10\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\4\7\uffff\1\3\4\uffff\1\2",
            "\1\1\14\uffff\1\5\10\uffff\1\6",
            "\1\1\14\uffff\1\5\10\uffff\1\6",
            "\1\7",
            "",
            "",
            "\1\3\4\uffff\1\2"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1047:3: ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )?";
        }
    }
    static final String dfa_7s = "\1\5\1\30\3\5\1\40\2\uffff";
    static final String dfa_8s = "\1\5\1\45\1\5\2\33\1\45\2\uffff";
    static final String dfa_9s = "\6\uffff\1\1\1\2";
    static final String[] dfa_10s = {
            "\1\1",
            "\1\2\7\uffff\1\4\4\uffff\1\3",
            "\1\5",
            "\1\1\14\uffff\1\6\10\uffff\1\7",
            "\1\1\14\uffff\1\6\10\uffff\1\7",
            "\1\4\4\uffff\1\3",
            "",
            ""
    };
    static final char[] dfa_7 = DFA.unpackEncodedStringToUnsignedChars(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final short[][] dfa_10 = unpackEncodedStringArray(dfa_10s);

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_7;
            this.max = dfa_8;
            this.accept = dfa_9;
            this.special = dfa_5;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "1168:3: ( ( (lv_start_6_0= ruleDSL_CEP_DURATION ) ) otherlv_7= ',' )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000010021000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000C80000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00200000040000F0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001FE0000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x002000000C0000F0L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000F00000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000C000000008002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0010000000000000L});

}