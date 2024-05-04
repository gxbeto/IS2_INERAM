package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wizardstepsbulletwc_impl extends GXWebComponent
{
   public wizardstepsbulletwc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wizardstepsbulletwc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wizardstepsbulletwc_impl.class ));
   }

   public wizardstepsbulletwc_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "WizardSteps") ;
            gxfirstwebparm_bkp = gxfirstwebparm ;
            gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
            toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               dyncall( httpContext.GetNextPar( )) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV17WizardSteps);
               AV6CurrentStep = httpContext.GetPar( "CurrentStep") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CurrentStep", AV6CurrentStep);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV17WizardSteps,AV6CurrentStep});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "WizardSteps") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "WizardSteps") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridwizardsteps") == 0 )
            {
               gxnrgridwizardsteps_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridwizardsteps") == 0 )
            {
               gxgrgridwizardsteps_refresh_invoke( ) ;
               return  ;
            }
            else
            {
               if ( ! httpContext.IsValidAjaxCall( false) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = gxfirstwebparm_bkp ;
            }
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void gxnrgridwizardsteps_newrow_invoke( )
   {
      nRC_GXsfl_5 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_5"))) ;
      nGXsfl_5_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_5_idx"))) ;
      sGXsfl_5_idx = httpContext.GetPar( "sGXsfl_5_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridwizardsteps_newrow( ) ;
      /* End function gxnrGridwizardsteps_newrow_invoke */
   }

   public void gxgrgridwizardsteps_refresh_invoke( )
   {
      AV15StepRealNumber = (short)(GXutil.lval( httpContext.GetPar( "StepRealNumber"))) ;
      AV12SelectedStepNumber = (short)(GXutil.lval( httpContext.GetPar( "SelectedStepNumber"))) ;
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV18WizardStepsAux);
      AV14StepNumber = (short)(GXutil.lval( httpContext.GetPar( "StepNumber"))) ;
      AV20WizardStepsCount = (short)(GXutil.lval( httpContext.GetPar( "WizardStepsCount"))) ;
      AV7FirstIsDummy = GXutil.strtobool( httpContext.GetPar( "FirstIsDummy")) ;
      AV8LastIsDummy = GXutil.strtobool( httpContext.GetPar( "LastIsDummy")) ;
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV17WizardSteps);
      AV10PenultimateIsDummy = GXutil.strtobool( httpContext.GetPar( "PenultimateIsDummy")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridwizardsteps_refresh( AV15StepRealNumber, AV12SelectedStepNumber, AV18WizardStepsAux, AV14StepNumber, AV20WizardStepsCount, AV7FirstIsDummy, AV8LastIsDummy, AV17WizardSteps, AV10PenultimateIsDummy, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridwizardsteps_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa0E2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), false);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( "Wizard Steps Bullet WC.") ;
         httpContext.writeTextNL( "</title>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( GXutil.len( sDynURL) > 0 )
         {
            httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
         }
         define_styles( ) ;
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1720180), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1720180), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1720180), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
         httpContext.writeText( "<body ") ;
         if ( GXutil.strcmp(httpContext.getLanguageProperty( "rtl"), "true") == 0 )
         {
            httpContext.writeText( " dir=\"rtl\" ") ;
         }
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"Form\" data-gx-class=\"Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.wizardstepsbulletwc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV6CurrentStep))}, new String[] {"WizardSteps","CurrentStep"}) +"\">") ;
            com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
            com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
            com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
            httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "Form", true);
         }
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPREALNUMBER", GXutil.ltrim( localUtil.ntoc( AV15StepRealNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSELECTEDSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV12SelectedStepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12SelectedStepNumber), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDSTEPSAUX", AV18WizardStepsAux);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDSTEPSAUX", AV18WizardStepsAux);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSAUX", getSecureSignedToken( sPrefix, AV18WizardStepsAux));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV14StepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV14StepNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWIZARDSTEPSCOUNT", GXutil.ltrim( localUtil.ntoc( AV20WizardStepsCount, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSCOUNT", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV20WizardStepsCount), "ZZZ9")));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vFIRSTISDUMMY", AV7FirstIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV7FirstIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vLASTISDUMMY", AV8LastIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV8LastIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPENULTIMATEISDUMMY", AV10PenultimateIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV10PenultimateIsDummy));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Wizardstepsaux", AV18WizardStepsAux);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Wizardstepsaux", AV18WizardStepsAux);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_Wizardstepsaux", getSecureSignedToken( sPrefix, AV18WizardStepsAux));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_5", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_5, (byte)(8), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6CurrentStep", wcpOAV6CurrentStep);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPREALNUMBER", GXutil.ltrim( localUtil.ntoc( AV15StepRealNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSELECTEDSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV12SelectedStepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12SelectedStepNumber), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDSTEPSAUX", AV18WizardStepsAux);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDSTEPSAUX", AV18WizardStepsAux);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSAUX", getSecureSignedToken( sPrefix, AV18WizardStepsAux));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV14StepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV14StepNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWIZARDSTEPSCOUNT", GXutil.ltrim( localUtil.ntoc( AV20WizardStepsCount, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSCOUNT", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV20WizardStepsCount), "ZZZ9")));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vFIRSTISDUMMY", AV7FirstIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV7FirstIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vLASTISDUMMY", AV8LastIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV8LastIsDummy));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDSTEPS", AV17WizardSteps);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDSTEPS", AV17WizardSteps);
      }
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPENULTIMATEISDUMMY", AV10PenultimateIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV10PenultimateIsDummy));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCURRENTSTEP", AV6CurrentStep);
   }

   public void renderHtmlCloseForm0E2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
         httpContext.SendComponentObjects();
         httpContext.SendServerCommands();
         httpContext.SendState();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "</form>") ;
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         include_jscripts( ) ;
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.WizardStepsBulletWC" ;
   }

   public String getPgmdesc( )
   {
      return "Wizard Steps Bullet WC." ;
   }

   public void wb0E0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.wwpbaseobjects.wizardstepsbulletwc");
         }
         com.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         wb_table1_2_0E2( true) ;
      }
      else
      {
         wb_table1_2_0E2( false) ;
      }
      return  ;
   }

   public void wb_table1_2_0E2e( boolean wbgen )
   {
      if ( wbgen )
      {
      }
      if ( wbEnd == 5 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridwizardstepsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV22GXV1 = nGXsfl_5_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"GridwizardstepsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridwizardsteps", GridwizardstepsContainer, subGridwizardsteps_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridwizardstepsContainerData", GridwizardstepsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridwizardstepsContainerData"+"V", GridwizardstepsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridwizardstepsContainerData"+"V"+"\" value='"+GridwizardstepsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start0E2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 18_0_8-180599", (short)(0)) ;
            }
         }
         Form.getMeta().addItem("description", "Wizard Steps Bullet WC.", (short)(0)) ;
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup0E0( ) ;
         }
      }
   }

   public void ws0E2( )
   {
      start0E2( ) ;
      evt0E2( ) ;
   }

   public void evt0E2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0E0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0E0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "GRIDWIZARDSTEPS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0E0( ) ;
                           }
                           nGXsfl_5_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_5_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_5_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_52( ) ;
                           AV22GXV1 = nGXsfl_5_idx ;
                           if ( ( AV18WizardStepsAux.size() >= AV22GXV1 ) && ( AV22GXV1 > 0 ) )
                           {
                              AV18WizardStepsAux.currentItem( ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV18WizardStepsAux.elementAt(-1+AV22GXV1)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Start */
                                       e110E2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDWIZARDSTEPS.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       e120E2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup0E0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                    }
                                 }
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we0E2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0E2( ) ;
         }
      }
   }

   public void pa0E2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridwizardsteps_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_52( ) ;
      while ( nGXsfl_5_idx <= nRC_GXsfl_5 )
      {
         sendrow_52( ) ;
         nGXsfl_5_idx = ((subGridwizardsteps_Islastpage==1)&&(nGXsfl_5_idx+1>subgridwizardsteps_fnc_recordsperpage( )) ? 1 : nGXsfl_5_idx+1) ;
         sGXsfl_5_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_5_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_52( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridwizardstepsContainer)) ;
      /* End function gxnrGridwizardsteps_newrow */
   }

   public void gxgrgridwizardsteps_refresh( short AV15StepRealNumber ,
                                            short AV12SelectedStepNumber ,
                                            GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV18WizardStepsAux ,
                                            short AV14StepNumber ,
                                            short AV20WizardStepsCount ,
                                            boolean AV7FirstIsDummy ,
                                            boolean AV8LastIsDummy ,
                                            GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV17WizardSteps ,
                                            boolean AV10PenultimateIsDummy ,
                                            String sPrefix )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDWIZARDSTEPS_nCurrentRecord = 0 ;
      rf0E2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridwizardsteps_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0E2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavWizardstepsaux__title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizardstepsaux__title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizardstepsaux__title_Enabled), 5, 0), !bGXsfl_5_Refreshing);
   }

   public void rf0E2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridwizardstepsContainer.ClearRows();
      }
      wbStart = (short)(5) ;
      nGXsfl_5_idx = 1 ;
      sGXsfl_5_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_5_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_52( ) ;
      bGXsfl_5_Refreshing = true ;
      GridwizardstepsContainer.AddObjectProperty("GridName", "Gridwizardsteps");
      GridwizardstepsContainer.AddObjectProperty("CmpContext", sPrefix);
      GridwizardstepsContainer.AddObjectProperty("InMasterPage", "false");
      GridwizardstepsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleSteps"));
      GridwizardstepsContainer.AddObjectProperty("Class", "FreeStyleSteps");
      GridwizardstepsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridwizardstepsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridwizardstepsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridwizardstepsContainer.setPageSize( subgridwizardsteps_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_52( ) ;
         e120E2 ();
         wbEnd = (short)(5) ;
         wb0E0( ) ;
      }
      bGXsfl_5_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0E2( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPREALNUMBER", GXutil.ltrim( localUtil.ntoc( AV15StepRealNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSELECTEDSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV12SelectedStepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12SelectedStepNumber), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDSTEPSAUX", AV18WizardStepsAux);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDSTEPSAUX", AV18WizardStepsAux);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSAUX", getSecureSignedToken( sPrefix, AV18WizardStepsAux));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV14StepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV14StepNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWIZARDSTEPSCOUNT", GXutil.ltrim( localUtil.ntoc( AV20WizardStepsCount, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSCOUNT", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV20WizardStepsCount), "ZZZ9")));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vFIRSTISDUMMY", AV7FirstIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV7FirstIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vLASTISDUMMY", AV8LastIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV8LastIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPENULTIMATEISDUMMY", AV10PenultimateIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV10PenultimateIsDummy));
   }

   public int subgridwizardsteps_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridwizardsteps_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridwizardsteps_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridwizardsteps_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      edtavWizardstepsaux__title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizardstepsaux__title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizardstepsaux__title_Enabled), 5, 0), !bGXsfl_5_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup0E0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"Wizardstepsaux"), AV18WizardStepsAux);
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"vWIZARDSTEPSAUX"), AV18WizardStepsAux);
         /* Read saved values. */
         nRC_GXsfl_5 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_5"), ",", ".")) ;
         wcpOAV6CurrentStep = httpContext.cgiGet( sPrefix+"wcpOAV6CurrentStep") ;
         nRC_GXsfl_5 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_5"), ",", ".")) ;
         nGXsfl_5_fel_idx = 0 ;
         while ( nGXsfl_5_fel_idx < nRC_GXsfl_5 )
         {
            nGXsfl_5_fel_idx = ((subGridwizardsteps_Islastpage==1)&&(nGXsfl_5_fel_idx+1>subgridwizardsteps_fnc_recordsperpage( )) ? 1 : nGXsfl_5_fel_idx+1) ;
            sGXsfl_5_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_5_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_52( ) ;
            AV22GXV1 = nGXsfl_5_fel_idx ;
            if ( ( AV18WizardStepsAux.size() >= AV22GXV1 ) && ( AV22GXV1 > 0 ) )
            {
               AV18WizardStepsAux.currentItem( ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV18WizardStepsAux.elementAt(-1+AV22GXV1)) );
            }
         }
         if ( nGXsfl_5_fel_idx == 0 )
         {
            nGXsfl_5_idx = 1 ;
            sGXsfl_5_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_5_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_52( ) ;
         }
         nGXsfl_5_fel_idx = 1 ;
         /* Read variables values. */
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e110E2 ();
      if (returnInSub) return;
   }

   public void e110E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV9MaxStepsToShow = (short)(11) ;
      AV21MaxStepsToShowInXS = (short)(5) ;
      AV12SelectedStepNumber = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12SelectedStepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12SelectedStepNumber), 4, 0));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12SelectedStepNumber), "ZZZ9")));
      AV24GXV3 = 1 ;
      while ( AV24GXV3 <= AV17WizardSteps.size() )
      {
         AV5WizardStep = (com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV17WizardSteps.elementAt(-1+AV24GXV3));
         if ( GXutil.strcmp(AV5WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), AV6CurrentStep) == 0 )
         {
            if (true) break;
         }
         else
         {
            AV12SelectedStepNumber = (short)(AV12SelectedStepNumber+1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12SelectedStepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12SelectedStepNumber), 4, 0));
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12SelectedStepNumber), "ZZZ9")));
         }
         AV24GXV3 = (int)(AV24GXV3+1) ;
      }
      AV15StepRealNumber = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15StepRealNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15StepRealNumber), 4, 0));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
      AV18WizardStepsAux = AV17WizardSteps.Clone() ;
      gx_BV5 = true ;
      AV7FirstIsDummy = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7FirstIsDummy", AV7FirstIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV7FirstIsDummy));
      AV11SecondIsDummy = false ;
      AV10PenultimateIsDummy = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10PenultimateIsDummy", AV10PenultimateIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV10PenultimateIsDummy));
      AV8LastIsDummy = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8LastIsDummy", AV8LastIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV8LastIsDummy));
      if ( AV18WizardStepsAux.size() > AV9MaxStepsToShow )
      {
         if ( AV12SelectedStepNumber > AV18WizardStepsAux.size() )
         {
            AV12SelectedStepNumber = (short)(1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12SelectedStepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12SelectedStepNumber), 4, 0));
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12SelectedStepNumber), "ZZZ9")));
         }
         AV13StartIndex = (short)(1) ;
         if ( DecimalUtil.doubleToDec(AV12SelectedStepNumber+3).subtract(DecimalUtil.doubleToDec(AV9MaxStepsToShow).divide(DecimalUtil.doubleToDec(2), java.math.MathContext.DECIMAL128)).doubleValue() > 0 )
         {
            AV13StartIndex = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV12SelectedStepNumber+3).subtract(DecimalUtil.doubleToDec(AV9MaxStepsToShow).divide(DecimalUtil.doubleToDec(2), java.math.MathContext.DECIMAL128)))) ;
            if ( AV13StartIndex + ( AV9MaxStepsToShow - 2 ) > AV18WizardStepsAux.size() + 1 )
            {
               AV13StartIndex = (short)(AV18WizardStepsAux.size()-(AV9MaxStepsToShow-2)+1) ;
            }
         }
         if ( AV13StartIndex > 3 )
         {
            AV15StepRealNumber = AV13StartIndex ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15StepRealNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15StepRealNumber), 4, 0));
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
            AV7FirstIsDummy = true ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7FirstIsDummy", AV7FirstIsDummy);
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV7FirstIsDummy));
            AV11SecondIsDummy = true ;
            ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV18WizardStepsAux.elementAt(-1+2)).setgxTv_SdtWizardSteps_WizardStepsItem_Title( "..." );
            while ( AV13StartIndex > 3 )
            {
               AV18WizardStepsAux.removeItem(3);
               gx_BV5 = true ;
               AV13StartIndex = (short)(AV13StartIndex-1) ;
               AV12SelectedStepNumber = (short)(AV12SelectedStepNumber-1) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12SelectedStepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12SelectedStepNumber), 4, 0));
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12SelectedStepNumber), "ZZZ9")));
            }
         }
         if ( AV18WizardStepsAux.size() > AV9MaxStepsToShow )
         {
            AV8LastIsDummy = true ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8LastIsDummy", AV8LastIsDummy);
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV8LastIsDummy));
            AV10PenultimateIsDummy = true ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10PenultimateIsDummy", AV10PenultimateIsDummy);
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV10PenultimateIsDummy));
            ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV18WizardStepsAux.elementAt(-1+AV18WizardStepsAux.size()-1)).setgxTv_SdtWizardSteps_WizardStepsItem_Title( "" );
            while ( AV18WizardStepsAux.size() > AV9MaxStepsToShow )
            {
               AV18WizardStepsAux.removeItem(AV18WizardStepsAux.size()-2);
               gx_BV5 = true ;
            }
         }
      }
      AV20WizardStepsCount = (short)(AV18WizardStepsAux.size()) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20WizardStepsCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20WizardStepsCount), 4, 0));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSCOUNT", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV20WizardStepsCount), "ZZZ9")));
      if ( AV18WizardStepsAux.size() > AV21MaxStepsToShowInXS )
      {
         AV19WizardStepsItem = (com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
         AV19WizardStepsItem.setgxTv_SdtWizardSteps_WizardStepsItem_Title( "DummiesXS_Test" );
         AV19WizardStepsItem.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "FirstDummyXS" );
         AV18WizardStepsAux.add(AV19WizardStepsItem, 2);
         gx_BV5 = true ;
         AV19WizardStepsItem = (com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
         AV19WizardStepsItem.setgxTv_SdtWizardSteps_WizardStepsItem_Title( "DummiesXS_Test" );
         AV19WizardStepsItem.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "LastDummyXS" );
         AV18WizardStepsAux.add(AV19WizardStepsItem, AV18WizardStepsAux.size()-1);
         gx_BV5 = true ;
      }
      AV14StepNumber = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14StepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14StepNumber), 4, 0));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV14StepNumber), "ZZZ9")));
   }

   private void e120E2( )
   {
      /* Gridwizardsteps_Load Routine */
      returnInSub = false ;
      AV22GXV1 = 1 ;
      while ( AV22GXV1 <= AV18WizardStepsAux.size() )
      {
         AV18WizardStepsAux.currentItem( ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV18WizardStepsAux.elementAt(-1+AV22GXV1)) );
         lblStepnumber_Visible = 0 ;
         lblStepnumber_Caption = localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9") ;
         tblTablestepbulletlineleft_Class = "TableStepBulletLine" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTablestepbulletlineleft_Internalname, "Class", tblTablestepbulletlineleft_Class, !bGXsfl_5_Refreshing);
         tblTablestepbulletlineright_Class = "TableStepBulletLine" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTablestepbulletlineright_Internalname, "Class", tblTablestepbulletlineright_Class, !bGXsfl_5_Refreshing);
         tblTblcontainerstep_Class = "TableContainerStepBullet" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblcontainerstep_Internalname, "Class", tblTblcontainerstep_Class, !bGXsfl_5_Refreshing);
         if ( ( AV12SelectedStepNumber != AV14StepNumber ) && ( GXutil.strcmp(((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)(AV18WizardStepsAux.currentItem())).getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "FirstDummyXS") != 0 ) && ( GXutil.strcmp(((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)(AV18WizardStepsAux.currentItem())).getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "LastDummyXS") != 0 ) && ( AV14StepNumber > 1 ) && ( AV14StepNumber < AV20WizardStepsCount ) )
         {
            if ( ( AV12SelectedStepNumber <= 3 ) && ( AV14StepNumber > 3 ) )
            {
               tblTblcontainerstep_Class = tblTblcontainerstep_Class+" hidden-xs" ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblcontainerstep_Internalname, "Class", tblTblcontainerstep_Class, !bGXsfl_5_Refreshing);
            }
            if ( ( AV12SelectedStepNumber > 3 ) && ( AV14StepNumber > 1 ) && ( AV12SelectedStepNumber < AV20WizardStepsCount - 2 ) )
            {
               tblTblcontainerstep_Class = tblTblcontainerstep_Class+" hidden-xs" ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblcontainerstep_Internalname, "Class", tblTblcontainerstep_Class, !bGXsfl_5_Refreshing);
            }
            if ( ( AV12SelectedStepNumber >= AV20WizardStepsCount - 2 ) && ( AV14StepNumber < AV20WizardStepsCount - 2 ) )
            {
               tblTblcontainerstep_Class = tblTblcontainerstep_Class+" hidden-xs" ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblcontainerstep_Internalname, "Class", tblTblcontainerstep_Class, !bGXsfl_5_Refreshing);
            }
         }
         if ( AV14StepNumber < AV12SelectedStepNumber )
         {
            divTablestepitem_Class = "TableStepBulletChecked" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablestepitem_Internalname, "Class", divTablestepitem_Class, !bGXsfl_5_Refreshing);
            tblTablestepbulletlineleft_Class = "TableStepBulletLineChecked" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTablestepbulletlineleft_Internalname, "Class", tblTablestepbulletlineleft_Class, !bGXsfl_5_Refreshing);
            tblTablestepbulletlineright_Class = "TableStepBulletLineChecked" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTablestepbulletlineright_Internalname, "Class", tblTablestepbulletlineright_Class, !bGXsfl_5_Refreshing);
            edtavWizardstepsaux__title_Class = "AttributeStepBullet" ;
         }
         else if ( AV14StepNumber == AV12SelectedStepNumber )
         {
            lblStepnumber_Visible = 1 ;
            lblStepnumber_Class = "StepNumberBulletSelected" ;
            divTablestepitem_Class = "TableStepBulletSelected" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablestepitem_Internalname, "Class", divTablestepitem_Class, !bGXsfl_5_Refreshing);
            tblTablestepbulletlineleft_Class = "TableStepBulletLineChecked" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTablestepbulletlineleft_Internalname, "Class", tblTablestepbulletlineleft_Class, !bGXsfl_5_Refreshing);
            edtavWizardstepsaux__title_Class = "AttributeStepBulletSelected" ;
         }
         else if ( AV14StepNumber > AV12SelectedStepNumber )
         {
            lblStepnumber_Class = "StepNumberBullet" ;
            lblStepnumber_Visible = 1 ;
            divTablestepitem_Class = "TableStepBullet" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablestepitem_Internalname, "Class", divTablestepitem_Class, !bGXsfl_5_Refreshing);
            edtavWizardstepsaux__title_Class = "AttributeStepBulletUnSelected" ;
         }
         tblTblcontainerstep_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblcontainerstep_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblcontainerstep_Visible), 5, 0), !bGXsfl_5_Refreshing);
         if ( ! GXutil.contains( ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)(AV18WizardStepsAux.currentItem())).getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "DummyXS") )
         {
            if ( ( AV14StepNumber == 1 ) && AV7FirstIsDummy )
            {
               lblStepnumber_Caption = GXutil.trim( GXutil.str( AV14StepNumber, 4, 0)) ;
            }
            else if ( ( AV14StepNumber == AV20WizardStepsCount ) && AV8LastIsDummy )
            {
               lblStepnumber_Caption = GXutil.trim( GXutil.str( AV17WizardSteps.size(), 9, 0)) ;
            }
            else if ( ( AV14StepNumber == AV20WizardStepsCount - 1 ) && AV10PenultimateIsDummy )
            {
               lblStepnumber_Caption = "..." ;
            }
            else if ( ( AV14StepNumber == 2 ) && AV7FirstIsDummy )
            {
            }
            else
            {
               AV15StepRealNumber = (short)(AV15StepRealNumber+1) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15StepRealNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15StepRealNumber), 4, 0));
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
            }
            AV14StepNumber = (short)(AV14StepNumber+1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14StepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14StepNumber), 4, 0));
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV14StepNumber), "ZZZ9")));
         }
         else
         {
            lblStepnumber_Caption = "..." ;
            tblTblcontainerstep_Class = "TableContainerStepBullet hidden-sm hidden-lg hidden-md" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblcontainerstep_Internalname, "Class", tblTblcontainerstep_Class, !bGXsfl_5_Refreshing);
            if ( ( ( AV12SelectedStepNumber <= 3 ) && ( GXutil.strcmp(((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)(AV18WizardStepsAux.currentItem())).getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "FirstDummyXS") == 0 ) ) || ( ( AV12SelectedStepNumber >= AV20WizardStepsCount - 2 ) && ( GXutil.strcmp(((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)(AV18WizardStepsAux.currentItem())).getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "LastDummyXS") == 0 ) ) )
            {
               tblTblcontainerstep_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblcontainerstep_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblcontainerstep_Visible), 5, 0), !bGXsfl_5_Refreshing);
            }
            if ( ( AV12SelectedStepNumber > 3 ) && ( GXutil.strcmp(((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)(AV18WizardStepsAux.currentItem())).getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "FirstDummyXS") == 0 ) )
            {
               divTablestepitem_Class = "TableStepExtraBulletChecked" ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablestepitem_Internalname, "Class", divTablestepitem_Class, !bGXsfl_5_Refreshing);
               lblStepnumber_Visible = 1 ;
            }
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(5) ;
         }
         sendrow_52( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_5_Refreshing )
         {
            httpContext.doAjaxLoad(5, GridwizardstepsRow);
         }
         AV22GXV1 = (int)(AV22GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_2_0E2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblTablemain_Internalname, tblTablemain_Internalname, "", "TableWizardSteps TableAlignedCentered", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='WizardStepsContainerCell'>") ;
         /*  Grid Control  */
         GridwizardstepsContainer.SetIsFreestyle(true);
         GridwizardstepsContainer.SetWrapped(nGXWrapped);
         startgridcontrol5( ) ;
      }
      if ( wbEnd == 5 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_5 = (int)(nGXsfl_5_idx-1) ;
         if ( GridwizardstepsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV22GXV1 = nGXsfl_5_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridwizardstepsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridwizardsteps", GridwizardstepsContainer, subGridwizardsteps_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridwizardstepsContainerData", GridwizardstepsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridwizardstepsContainerData"+"V", GridwizardstepsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridwizardstepsContainerData"+"V"+"\" value='"+GridwizardstepsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_2_0E2e( true) ;
      }
      else
      {
         wb_table1_2_0E2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV17WizardSteps = (GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>)getParm(obj,0) ;
      AV6CurrentStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CurrentStep", AV6CurrentStep);
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa0E2( ) ;
      ws0E2( ) ;
      we0E2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV17WizardSteps = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV6CurrentStep = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0E2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wizardstepsbulletwc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0E2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV17WizardSteps = (GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>)getParm(obj,2) ;
         AV6CurrentStep = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CurrentStep", AV6CurrentStep);
      }
      wcpOAV6CurrentStep = httpContext.cgiGet( sPrefix+"wcpOAV6CurrentStep") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV6CurrentStep, wcpOAV6CurrentStep) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV6CurrentStep = AV6CurrentStep ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV17WizardSteps = httpContext.cgiGet( sPrefix+"AV17WizardSteps_CTRL") ;
      if ( GXutil.len( sCtrlAV17WizardSteps) > 0 )
      {
         AV17WizardSteps = new GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>() ;
      }
      else
      {
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"AV17WizardSteps_PARM"), AV17WizardSteps);
      }
      sCtrlAV6CurrentStep = httpContext.cgiGet( sPrefix+"AV6CurrentStep_CTRL") ;
      if ( GXutil.len( sCtrlAV6CurrentStep) > 0 )
      {
         AV6CurrentStep = httpContext.cgiGet( sCtrlAV6CurrentStep) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CurrentStep", AV6CurrentStep);
      }
      else
      {
         AV6CurrentStep = httpContext.cgiGet( sPrefix+"AV6CurrentStep_PARM") ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa0E2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0E2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws0E2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"AV17WizardSteps_PARM", AV17WizardSteps);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"AV17WizardSteps_PARM", AV17WizardSteps);
      }
      if ( GXutil.len( GXutil.rtrim( sCtrlAV17WizardSteps)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV17WizardSteps_CTRL", GXutil.rtrim( sCtrlAV17WizardSteps));
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6CurrentStep_PARM", AV6CurrentStep);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV6CurrentStep)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6CurrentStep_CTRL", GXutil.rtrim( sCtrlAV6CurrentStep));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we0E2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163593", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      httpContext.CloseStyles();
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("wwpbaseobjects/wizardstepsbulletwc.js", "?202442617163593", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_52( )
   {
      lblDummybulletlineleft_Internalname = sPrefix+"DUMMYBULLETLINELEFT_"+sGXsfl_5_idx ;
      lblStepnumber_Internalname = sPrefix+"STEPNUMBER_"+sGXsfl_5_idx ;
      lblDummybulletlineright_Internalname = sPrefix+"DUMMYBULLETLINERIGHT_"+sGXsfl_5_idx ;
      edtavWizardstepsaux__title_Internalname = sPrefix+"WIZARDSTEPSAUX__TITLE_"+sGXsfl_5_idx ;
   }

   public void subsflControlProps_fel_52( )
   {
      lblDummybulletlineleft_Internalname = sPrefix+"DUMMYBULLETLINELEFT_"+sGXsfl_5_fel_idx ;
      lblStepnumber_Internalname = sPrefix+"STEPNUMBER_"+sGXsfl_5_fel_idx ;
      lblDummybulletlineright_Internalname = sPrefix+"DUMMYBULLETLINERIGHT_"+sGXsfl_5_fel_idx ;
      edtavWizardstepsaux__title_Internalname = sPrefix+"WIZARDSTEPSAUX__TITLE_"+sGXsfl_5_fel_idx ;
   }

   public void sendrow_52( )
   {
      subsflControlProps_52( ) ;
      wb0E0( ) ;
      GridwizardstepsRow = GXWebRow.GetNew(context,GridwizardstepsContainer) ;
      if ( subGridwizardsteps_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridwizardsteps_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridwizardsteps_Class, "") != 0 )
         {
            subGridwizardsteps_Linesclass = subGridwizardsteps_Class+"Odd" ;
         }
      }
      else if ( subGridwizardsteps_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridwizardsteps_Backstyle = (byte)(0) ;
         subGridwizardsteps_Backcolor = subGridwizardsteps_Allbackcolor ;
         if ( GXutil.strcmp(subGridwizardsteps_Class, "") != 0 )
         {
            subGridwizardsteps_Linesclass = subGridwizardsteps_Class+"Uniform" ;
         }
      }
      else if ( subGridwizardsteps_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridwizardsteps_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridwizardsteps_Class, "") != 0 )
         {
            subGridwizardsteps_Linesclass = subGridwizardsteps_Class+"Odd" ;
         }
         subGridwizardsteps_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridwizardsteps_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridwizardsteps_Backstyle = (byte)(1) ;
         subGridwizardsteps_Backcolor = (int)(0xFFFFFF) ;
         if ( GXutil.strcmp(subGridwizardsteps_Class, "") != 0 )
         {
            subGridwizardsteps_Linesclass = subGridwizardsteps_Class+"Odd" ;
         }
      }
      /* Start of Columns property logic. */
      GridwizardstepsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"",subGridwizardsteps_Linesclass,""});
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Table start */
      GridwizardstepsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTblcontainerstep_Internalname+"_"+sGXsfl_5_idx,Integer.valueOf(tblTblcontainerstep_Visible),tblTblcontainerstep_Class,"","","","","","",Integer.valueOf(0),Integer.valueOf(0),"","","","px","px",""});
      GridwizardstepsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Table start */
      GridwizardstepsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablestepbulletline_Internalname+"_"+sGXsfl_5_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      GridwizardstepsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Table start */
      GridwizardstepsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablestepbulletlineleft_Internalname+"_"+sGXsfl_5_idx,Integer.valueOf(1),tblTablestepbulletlineleft_Class,"","","","","","",Integer.valueOf(0),Integer.valueOf(0),"","","","px","px",""});
      GridwizardstepsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Text block */
      GridwizardstepsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblDummybulletlineleft_Internalname," ","","",lblDummybulletlineleft_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("cell");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("row");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("table");
      }
      /* End of table */
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("cell");
      }
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayout_tablestepitem_Internalname+"_"+sGXsfl_5_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Section","start","top","","","div"});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Section","start","top"," "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ","","div"});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablestepitem_Internalname+"_"+sGXsfl_5_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",divTablestepitem_Class,"start","top","","","div"});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 StepNumberBulletCell","start","top","","","div"});
      /* Text block */
      GridwizardstepsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblStepnumber_Internalname,lblStepnumber_Caption,"","",lblStepnumber_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","",lblStepnumber_Class,Integer.valueOf(0),"",Integer.valueOf(lblStepnumber_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("cell");
      }
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Table start */
      GridwizardstepsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablestepbulletlineright_Internalname+"_"+sGXsfl_5_idx,Integer.valueOf(1),tblTablestepbulletlineright_Class,"","","","","","",Integer.valueOf(0),Integer.valueOf(0),"","","","px","px",""});
      GridwizardstepsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Text block */
      GridwizardstepsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblDummybulletlineright_Internalname," ","","",lblDummybulletlineright_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("cell");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("row");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("table");
      }
      /* End of table */
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("cell");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("row");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("table");
      }
      /* End of table */
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("cell");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("row");
      }
      sendrow_5230( ) ;
   }

   public void sendrow_5230( )
   {
      GridwizardstepsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","AttributeStepBulletCell"});
      /* Single line edit */
      ROClassString = edtavWizardstepsaux__title_Class ;
      GridwizardstepsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWizardstepsaux__title_Internalname,((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV18WizardStepsAux.elementAt(-1+AV22GXV1)).getgxTv_SdtWizardSteps_WizardStepsItem_Title(),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavWizardstepsaux__title_Jsonclick,Integer.valueOf(0),edtavWizardstepsaux__title_Class,"",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavWizardstepsaux__title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","start",Boolean.valueOf(true),""});
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("cell");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("row");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("table");
      }
      /* End of table */
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("cell");
      }
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("row");
      }
      send_integrity_lvl_hashes0E2( ) ;
      /* End of Columns property logic. */
      GridwizardstepsContainer.AddRow(GridwizardstepsRow);
      nGXsfl_5_idx = ((subGridwizardsteps_Islastpage==1)&&(nGXsfl_5_idx+1>subgridwizardsteps_fnc_recordsperpage( )) ? 1 : nGXsfl_5_idx+1) ;
      sGXsfl_5_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_5_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_52( ) ;
      /* End function sendrow_52 */
   }

   public void startgridcontrol5( )
   {
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridwizardstepsContainer"+"DivS\" data-gxgridid=\"5\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGridwizardsteps_Internalname, subGridwizardsteps_Internalname, "", "FreeStyleSteps", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridwizardstepsContainer.AddObjectProperty("GridName", "Gridwizardsteps");
      }
      else
      {
         GridwizardstepsContainer.AddObjectProperty("GridName", "Gridwizardsteps");
         GridwizardstepsContainer.AddObjectProperty("Header", subGridwizardsteps_Header);
         GridwizardstepsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleSteps"));
         GridwizardstepsContainer.AddObjectProperty("Class", "FreeStyleSteps");
         GridwizardstepsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("CmpContext", sPrefix);
         GridwizardstepsContainer.AddObjectProperty("InMasterPage", "false");
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsColumn.AddObjectProperty("Value", lblDummybulletlineleft_Caption);
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsColumn.AddObjectProperty("Value", lblStepnumber_Caption);
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsColumn.AddObjectProperty("Value", lblDummybulletlineleft_Caption);
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsColumn.AddObjectProperty("Class", GXutil.rtrim( edtavWizardstepsaux__title_Class));
         GridwizardstepsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavWizardstepsaux__title_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblDummybulletlineleft_Internalname = sPrefix+"DUMMYBULLETLINELEFT" ;
      tblTablestepbulletlineleft_Internalname = sPrefix+"TABLESTEPBULLETLINELEFT" ;
      lblStepnumber_Internalname = sPrefix+"STEPNUMBER" ;
      divTablestepitem_Internalname = sPrefix+"TABLESTEPITEM" ;
      divLayout_tablestepitem_Internalname = sPrefix+"LAYOUT_TABLESTEPITEM" ;
      lblDummybulletlineright_Internalname = sPrefix+"DUMMYBULLETLINERIGHT" ;
      tblTablestepbulletlineright_Internalname = sPrefix+"TABLESTEPBULLETLINERIGHT" ;
      tblTablestepbulletline_Internalname = sPrefix+"TABLESTEPBULLETLINE" ;
      edtavWizardstepsaux__title_Internalname = sPrefix+"WIZARDSTEPSAUX__TITLE" ;
      tblTblcontainerstep_Internalname = sPrefix+"TBLCONTAINERSTEP" ;
      tblTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGridwizardsteps_Internalname = sPrefix+"GRIDWIZARDSTEPS" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS", true);
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      subGridwizardsteps_Allowcollapsing = (byte)(0) ;
      lblStepnumber_Caption = "1" ;
      lblDummybulletlineleft_Caption = " " ;
      edtavWizardstepsaux__title_Jsonclick = "" ;
      edtavWizardstepsaux__title_Class = "AttributeStepBulletUnSelected" ;
      edtavWizardstepsaux__title_Enabled = 0 ;
      lblStepnumber_Class = "StepNumberBullet" ;
      lblStepnumber_Caption = "1" ;
      lblStepnumber_Visible = 1 ;
      subGridwizardsteps_Class = "FreeStyleSteps" ;
      tblTblcontainerstep_Visible = 1 ;
      divTablestepitem_Class = "TableStepBullet" ;
      tblTblcontainerstep_Class = "TableContainerStepBullet" ;
      tblTablestepbulletlineright_Class = "TableStepBulletLine" ;
      tblTablestepbulletlineleft_Class = "TableStepBulletLine" ;
      subGridwizardsteps_Backcolorstyle = (byte)(0) ;
      edtavWizardstepsaux__title_Enabled = -1 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDWIZARDSTEPS_nFirstRecordOnPage'},{av:'GRIDWIZARDSTEPS_nEOF'},{av:'AV17WizardSteps',fld:'vWIZARDSTEPS',pic:''},{av:'sPrefix'},{av:'AV18WizardStepsAux',fld:'vWIZARDSTEPSAUX',grid:5,pic:'',hsh:true},{av:'nGXsfl_5_idx',ctrl:'GRID',prop:'GridCurrRow',grid:5},{av:'nRC_GXsfl_5',ctrl:'GRIDWIZARDSTEPS',prop:'GridRC',grid:5},{av:'AV15StepRealNumber',fld:'vSTEPREALNUMBER',pic:'ZZZ9',hsh:true},{av:'AV12SelectedStepNumber',fld:'vSELECTEDSTEPNUMBER',pic:'ZZZ9',hsh:true},{av:'AV14StepNumber',fld:'vSTEPNUMBER',pic:'ZZZ9',hsh:true},{av:'AV20WizardStepsCount',fld:'vWIZARDSTEPSCOUNT',pic:'ZZZ9',hsh:true},{av:'AV7FirstIsDummy',fld:'vFIRSTISDUMMY',pic:'',hsh:true},{av:'AV8LastIsDummy',fld:'vLASTISDUMMY',pic:'',hsh:true},{av:'AV10PenultimateIsDummy',fld:'vPENULTIMATEISDUMMY',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDWIZARDSTEPS.LOAD","{handler:'e120E2',iparms:[{av:'AV15StepRealNumber',fld:'vSTEPREALNUMBER',pic:'ZZZ9',hsh:true},{av:'AV12SelectedStepNumber',fld:'vSELECTEDSTEPNUMBER',pic:'ZZZ9',hsh:true},{av:'AV18WizardStepsAux',fld:'vWIZARDSTEPSAUX',grid:5,pic:'',hsh:true},{av:'nGXsfl_5_idx',ctrl:'GRID',prop:'GridCurrRow',grid:5},{av:'GRIDWIZARDSTEPS_nFirstRecordOnPage'},{av:'nRC_GXsfl_5',ctrl:'GRIDWIZARDSTEPS',prop:'GridRC',grid:5},{av:'AV14StepNumber',fld:'vSTEPNUMBER',pic:'ZZZ9',hsh:true},{av:'AV20WizardStepsCount',fld:'vWIZARDSTEPSCOUNT',pic:'ZZZ9',hsh:true},{av:'AV7FirstIsDummy',fld:'vFIRSTISDUMMY',pic:'',hsh:true},{av:'AV8LastIsDummy',fld:'vLASTISDUMMY',pic:'',hsh:true},{av:'AV17WizardSteps',fld:'vWIZARDSTEPS',pic:''},{av:'AV10PenultimateIsDummy',fld:'vPENULTIMATEISDUMMY',pic:'',hsh:true}]");
      setEventMetadata("GRIDWIZARDSTEPS.LOAD",",oparms:[{av:'lblStepnumber_Visible',ctrl:'STEPNUMBER',prop:'Visible'},{av:'lblStepnumber_Caption',ctrl:'STEPNUMBER',prop:'Caption'},{av:'tblTablestepbulletlineleft_Class',ctrl:'TABLESTEPBULLETLINELEFT',prop:'Class'},{av:'tblTablestepbulletlineright_Class',ctrl:'TABLESTEPBULLETLINERIGHT',prop:'Class'},{av:'tblTblcontainerstep_Class',ctrl:'TBLCONTAINERSTEP',prop:'Class'},{av:'divTablestepitem_Class',ctrl:'TABLESTEPITEM',prop:'Class'},{ctrl:'WIZARDSTEPSAUX__TITLE',prop:'Class'},{av:'lblStepnumber_Class',ctrl:'STEPNUMBER',prop:'Class'},{av:'tblTblcontainerstep_Visible',ctrl:'TBLCONTAINERSTEP',prop:'Visible'},{av:'AV15StepRealNumber',fld:'vSTEPREALNUMBER',pic:'ZZZ9',hsh:true},{av:'AV14StepNumber',fld:'vSTEPNUMBER',pic:'ZZZ9',hsh:true}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv2',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOAV6CurrentStep = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV17WizardSteps = new GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "Gregory", remoteHandle);
      AV6CurrentStep = "" ;
      AV18WizardStepsAux = new GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "Gregory", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      GridwizardstepsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV5WizardStep = new com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV19WizardStepsItem = new com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      GridwizardstepsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV17WizardSteps = "" ;
      sCtrlAV6CurrentStep = "" ;
      subGridwizardsteps_Linesclass = "" ;
      lblDummybulletlineleft_Jsonclick = "" ;
      lblStepnumber_Jsonclick = "" ;
      lblDummybulletlineright_Jsonclick = "" ;
      ROClassString = "" ;
      subGridwizardsteps_Header = "" ;
      GridwizardstepsColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
      edtavWizardstepsaux__title_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nGXWrapped ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGridwizardsteps_Backcolorstyle ;
   private byte subGridwizardsteps_Backstyle ;
   private byte subGridwizardsteps_Allowselection ;
   private byte subGridwizardsteps_Allowhovering ;
   private byte subGridwizardsteps_Allowcollapsing ;
   private byte subGridwizardsteps_Collapsed ;
   private byte GRIDWIZARDSTEPS_nEOF ;
   private short AV15StepRealNumber ;
   private short AV12SelectedStepNumber ;
   private short AV14StepNumber ;
   private short AV20WizardStepsCount ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short AV9MaxStepsToShow ;
   private short AV21MaxStepsToShowInXS ;
   private short AV13StartIndex ;
   private int nRC_GXsfl_5 ;
   private int nGXsfl_5_idx=1 ;
   private int AV22GXV1 ;
   private int subGridwizardsteps_Islastpage ;
   private int edtavWizardstepsaux__title_Enabled ;
   private int nGXsfl_5_fel_idx=1 ;
   private int AV24GXV3 ;
   private int lblStepnumber_Visible ;
   private int tblTblcontainerstep_Visible ;
   private int idxLst ;
   private int subGridwizardsteps_Backcolor ;
   private int subGridwizardsteps_Allbackcolor ;
   private int subGridwizardsteps_Selectedindex ;
   private int subGridwizardsteps_Selectioncolor ;
   private int subGridwizardsteps_Hoveringcolor ;
   private long GRIDWIZARDSTEPS_nCurrentRecord ;
   private long GRIDWIZARDSTEPS_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_5_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sStyleString ;
   private String subGridwizardsteps_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavWizardstepsaux__title_Internalname ;
   private String sGXsfl_5_fel_idx="0001" ;
   private String lblStepnumber_Caption ;
   private String tblTablestepbulletlineleft_Class ;
   private String tblTablestepbulletlineleft_Internalname ;
   private String tblTablestepbulletlineright_Class ;
   private String tblTablestepbulletlineright_Internalname ;
   private String tblTblcontainerstep_Class ;
   private String tblTblcontainerstep_Internalname ;
   private String divTablestepitem_Class ;
   private String divTablestepitem_Internalname ;
   private String edtavWizardstepsaux__title_Class ;
   private String lblStepnumber_Class ;
   private String tblTablemain_Internalname ;
   private String sCtrlAV17WizardSteps ;
   private String sCtrlAV6CurrentStep ;
   private String lblDummybulletlineleft_Internalname ;
   private String lblStepnumber_Internalname ;
   private String lblDummybulletlineright_Internalname ;
   private String subGridwizardsteps_Class ;
   private String subGridwizardsteps_Linesclass ;
   private String tblTablestepbulletline_Internalname ;
   private String lblDummybulletlineleft_Jsonclick ;
   private String divLayout_tablestepitem_Internalname ;
   private String lblStepnumber_Jsonclick ;
   private String lblDummybulletlineright_Jsonclick ;
   private String ROClassString ;
   private String edtavWizardstepsaux__title_Jsonclick ;
   private String subGridwizardsteps_Header ;
   private String lblDummybulletlineleft_Caption ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV7FirstIsDummy ;
   private boolean AV8LastIsDummy ;
   private boolean AV10PenultimateIsDummy ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_5_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV5 ;
   private boolean AV11SecondIsDummy ;
   private String wcpOAV6CurrentStep ;
   private String AV6CurrentStep ;
   private com.genexus.webpanels.GXWebGrid GridwizardstepsContainer ;
   private com.genexus.webpanels.GXWebRow GridwizardstepsRow ;
   private com.genexus.webpanels.GXWebColumn GridwizardstepsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV17WizardSteps ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV18WizardStepsAux ;
   private com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV5WizardStep ;
   private com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV19WizardStepsItem ;
}

