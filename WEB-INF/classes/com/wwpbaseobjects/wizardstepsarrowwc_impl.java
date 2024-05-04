package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wizardstepsarrowwc_impl extends GXWebComponent
{
   public wizardstepsarrowwc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wizardstepsarrowwc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wizardstepsarrowwc_impl.class ));
   }

   public wizardstepsarrowwc_impl( int remoteHandle ,
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
               httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV18WizardSteps);
               AV11SelectedStep = httpContext.GetPar( "SelectedStep") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11SelectedStep", AV11SelectedStep);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV18WizardSteps,AV11SelectedStep});
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
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV19WizardStepsAux);
      AV11SelectedStep = httpContext.GetPar( "SelectedStep") ;
      AV9PreviousSelected = GXutil.strtobool( httpContext.GetPar( "PreviousSelected")) ;
      AV14StepNumber = (short)(GXutil.lval( httpContext.GetPar( "StepNumber"))) ;
      AV5FirstIsDummy = GXutil.strtobool( httpContext.GetPar( "FirstIsDummy")) ;
      AV6LastIsDummy = GXutil.strtobool( httpContext.GetPar( "LastIsDummy")) ;
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV18WizardSteps);
      AV10SecondIsDummy = GXutil.strtobool( httpContext.GetPar( "SecondIsDummy")) ;
      AV8PenultimateIsDummy = GXutil.strtobool( httpContext.GetPar( "PenultimateIsDummy")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridwizardsteps_refresh( AV15StepRealNumber, AV19WizardStepsAux, AV11SelectedStep, AV9PreviousSelected, AV14StepNumber, AV5FirstIsDummy, AV6LastIsDummy, AV18WizardSteps, AV10SecondIsDummy, AV8PenultimateIsDummy, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridwizardsteps_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa0D2( ) ;
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
         httpContext.writeValue( "Wizard Steps Arrow WC") ;
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
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"Form\" data-gx-class=\"Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.wizardstepsarrowwc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11SelectedStep))}, new String[] {"WizardSteps","SelectedStep"}) +"\">") ;
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
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDSTEPSAUX", AV19WizardStepsAux);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDSTEPSAUX", AV19WizardStepsAux);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSAUX", getSecureSignedToken( sPrefix, AV19WizardStepsAux));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPREVIOUSSELECTED", AV9PreviousSelected);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPREVIOUSSELECTED", getSecureSignedToken( sPrefix, AV9PreviousSelected));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV14StepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV14StepNumber), "ZZZ9")));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vFIRSTISDUMMY", AV5FirstIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV5FirstIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vLASTISDUMMY", AV6LastIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV6LastIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vSECONDISDUMMY", AV10SecondIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSECONDISDUMMY", getSecureSignedToken( sPrefix, AV10SecondIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPENULTIMATEISDUMMY", AV8PenultimateIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV8PenultimateIsDummy));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Wizardstepsaux", AV19WizardStepsAux);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Wizardstepsaux", AV19WizardStepsAux);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_Wizardstepsaux", getSecureSignedToken( sPrefix, AV19WizardStepsAux));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_5", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_5, (byte)(8), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV11SelectedStep", wcpOAV11SelectedStep);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPREALNUMBER", GXutil.ltrim( localUtil.ntoc( AV15StepRealNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDSTEPSAUX", AV19WizardStepsAux);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDSTEPSAUX", AV19WizardStepsAux);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSAUX", getSecureSignedToken( sPrefix, AV19WizardStepsAux));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSELECTEDSTEP", AV11SelectedStep);
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPREVIOUSSELECTED", AV9PreviousSelected);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPREVIOUSSELECTED", getSecureSignedToken( sPrefix, AV9PreviousSelected));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV14StepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV14StepNumber), "ZZZ9")));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vFIRSTISDUMMY", AV5FirstIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV5FirstIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vLASTISDUMMY", AV6LastIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV6LastIsDummy));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDSTEPS", AV18WizardSteps);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDSTEPS", AV18WizardSteps);
      }
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vSECONDISDUMMY", AV10SecondIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSECONDISDUMMY", getSecureSignedToken( sPrefix, AV10SecondIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPENULTIMATEISDUMMY", AV8PenultimateIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV8PenultimateIsDummy));
   }

   public void renderHtmlCloseForm0D2( )
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
      return "WWPBaseObjects.WizardStepsArrowWC" ;
   }

   public String getPgmdesc( )
   {
      return "Wizard Steps Arrow WC" ;
   }

   public void wb0D0( )
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
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.wwpbaseobjects.wizardstepsarrowwc");
         }
         com.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         wb_table1_2_0D2( true) ;
      }
      else
      {
         wb_table1_2_0D2( false) ;
      }
      return  ;
   }

   public void wb_table1_2_0D2e( boolean wbgen )
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
               AV20GXV1 = nGXsfl_5_idx ;
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

   public void start0D2( )
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
         Form.getMeta().addItem("description", "Wizard Steps Arrow WC", (short)(0)) ;
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
            strup0D0( ) ;
         }
      }
   }

   public void ws0D2( )
   {
      start0D2( ) ;
      evt0D2( ) ;
   }

   public void evt0D2( )
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
                              strup0D0( ) ;
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
                              strup0D0( ) ;
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
                              strup0D0( ) ;
                           }
                           nGXsfl_5_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_5_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_5_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_52( ) ;
                           AV20GXV1 = nGXsfl_5_idx ;
                           if ( ( AV19WizardStepsAux.size() >= AV20GXV1 ) && ( AV20GXV1 > 0 ) )
                           {
                              AV19WizardStepsAux.currentItem( ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV19WizardStepsAux.elementAt(-1+AV20GXV1)) );
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
                                       e110D2 ();
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
                                       e120D2 ();
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
                                    strup0D0( ) ;
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

   public void we0D2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0D2( ) ;
         }
      }
   }

   public void pa0D2( )
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
                                            GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV19WizardStepsAux ,
                                            String AV11SelectedStep ,
                                            boolean AV9PreviousSelected ,
                                            short AV14StepNumber ,
                                            boolean AV5FirstIsDummy ,
                                            boolean AV6LastIsDummy ,
                                            GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV18WizardSteps ,
                                            boolean AV10SecondIsDummy ,
                                            boolean AV8PenultimateIsDummy ,
                                            String sPrefix )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDWIZARDSTEPS_nCurrentRecord = 0 ;
      rf0D2( ) ;
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
      rf0D2( ) ;
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

   public void rf0D2( )
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
         e120D2 ();
         wbEnd = (short)(5) ;
         wb0D0( ) ;
      }
      bGXsfl_5_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0D2( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPREALNUMBER", GXutil.ltrim( localUtil.ntoc( AV15StepRealNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDSTEPSAUX", AV19WizardStepsAux);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDSTEPSAUX", AV19WizardStepsAux);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWIZARDSTEPSAUX", getSecureSignedToken( sPrefix, AV19WizardStepsAux));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPREVIOUSSELECTED", AV9PreviousSelected);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPREVIOUSSELECTED", getSecureSignedToken( sPrefix, AV9PreviousSelected));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV14StepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV14StepNumber), "ZZZ9")));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vFIRSTISDUMMY", AV5FirstIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV5FirstIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vLASTISDUMMY", AV6LastIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV6LastIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vSECONDISDUMMY", AV10SecondIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSECONDISDUMMY", getSecureSignedToken( sPrefix, AV10SecondIsDummy));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPENULTIMATEISDUMMY", AV8PenultimateIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV8PenultimateIsDummy));
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

   public void strup0D0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"Wizardstepsaux"), AV19WizardStepsAux);
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"vWIZARDSTEPSAUX"), AV19WizardStepsAux);
         /* Read saved values. */
         nRC_GXsfl_5 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_5"), ",", ".")) ;
         wcpOAV11SelectedStep = httpContext.cgiGet( sPrefix+"wcpOAV11SelectedStep") ;
         nRC_GXsfl_5 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_5"), ",", ".")) ;
         nGXsfl_5_fel_idx = 0 ;
         while ( nGXsfl_5_fel_idx < nRC_GXsfl_5 )
         {
            nGXsfl_5_fel_idx = ((subGridwizardsteps_Islastpage==1)&&(nGXsfl_5_fel_idx+1>subgridwizardsteps_fnc_recordsperpage( )) ? 1 : nGXsfl_5_fel_idx+1) ;
            sGXsfl_5_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_5_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_52( ) ;
            AV20GXV1 = nGXsfl_5_fel_idx ;
            if ( ( AV19WizardStepsAux.size() >= AV20GXV1 ) && ( AV20GXV1 > 0 ) )
            {
               AV19WizardStepsAux.currentItem( ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV19WizardStepsAux.elementAt(-1+AV20GXV1)) );
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
      e110D2 ();
      if (returnInSub) return;
   }

   public void e110D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV7MaxStepsToShow = (short)(8) ;
      AV19WizardStepsAux = AV18WizardSteps.Clone() ;
      gx_BV5 = true ;
      AV14StepNumber = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14StepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14StepNumber), 4, 0));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV14StepNumber), "ZZZ9")));
      AV15StepRealNumber = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15StepRealNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15StepRealNumber), 4, 0));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
      AV9PreviousSelected = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9PreviousSelected", AV9PreviousSelected);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPREVIOUSSELECTED", getSecureSignedToken( sPrefix, AV9PreviousSelected));
      AV5FirstIsDummy = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5FirstIsDummy", AV5FirstIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV5FirstIsDummy));
      AV10SecondIsDummy = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10SecondIsDummy", AV10SecondIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSECONDISDUMMY", getSecureSignedToken( sPrefix, AV10SecondIsDummy));
      AV8PenultimateIsDummy = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PenultimateIsDummy", AV8PenultimateIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV8PenultimateIsDummy));
      AV6LastIsDummy = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6LastIsDummy", AV6LastIsDummy);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV6LastIsDummy));
      if ( AV19WizardStepsAux.size() > AV7MaxStepsToShow )
      {
         AV7MaxStepsToShow = (short)(AV7MaxStepsToShow-1) ;
         AV12SelectedStepIndex = (short)(1) ;
         AV22GXV3 = 1 ;
         while ( AV22GXV3 <= AV19WizardStepsAux.size() )
         {
            AV17WizardStep = (com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV19WizardStepsAux.elementAt(-1+AV22GXV3));
            if ( GXutil.strcmp(AV17WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), AV11SelectedStep) == 0 )
            {
               if (true) break;
            }
            AV12SelectedStepIndex = (short)(AV12SelectedStepIndex+1) ;
            AV22GXV3 = (int)(AV22GXV3+1) ;
         }
         if ( AV12SelectedStepIndex > AV19WizardStepsAux.size() )
         {
            AV12SelectedStepIndex = (short)(1) ;
         }
         AV13StartIndex = (short)(1) ;
         if ( AV12SelectedStepIndex + 1 > DecimalUtil.doubleToDec((AV7MaxStepsToShow)).divide(DecimalUtil.doubleToDec(2), java.math.MathContext.DECIMAL128).doubleValue() )
         {
            AV13StartIndex = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV12SelectedStepIndex+1).subtract(DecimalUtil.doubleToDec((AV7MaxStepsToShow)).divide(DecimalUtil.doubleToDec(2), java.math.MathContext.DECIMAL128)))) ;
            if ( AV13StartIndex + AV7MaxStepsToShow > AV19WizardStepsAux.size() + 1 )
            {
               AV13StartIndex = (short)(AV19WizardStepsAux.size()+1-AV7MaxStepsToShow) ;
            }
         }
         AV15StepRealNumber = AV13StartIndex ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15StepRealNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15StepRealNumber), 4, 0));
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPREALNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9")));
         if ( AV13StartIndex > 1 )
         {
            AV5FirstIsDummy = true ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5FirstIsDummy", AV5FirstIsDummy);
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vFIRSTISDUMMY", getSecureSignedToken( sPrefix, AV5FirstIsDummy));
            AV7MaxStepsToShow = (short)(AV7MaxStepsToShow+1) ;
            if ( AV13StartIndex > 2 )
            {
               AV10SecondIsDummy = true ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10SecondIsDummy", AV10SecondIsDummy);
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSECONDISDUMMY", getSecureSignedToken( sPrefix, AV10SecondIsDummy));
               AV7MaxStepsToShow = (short)(AV7MaxStepsToShow+1) ;
               ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV19WizardStepsAux.elementAt(-1+2)).setgxTv_SdtWizardSteps_WizardStepsItem_Title( "..." );
               while ( AV13StartIndex > 3 )
               {
                  AV19WizardStepsAux.removeItem(3);
                  gx_BV5 = true ;
                  AV13StartIndex = (short)(AV13StartIndex-1) ;
               }
            }
         }
         if ( AV19WizardStepsAux.size() > AV7MaxStepsToShow )
         {
            AV6LastIsDummy = true ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6LastIsDummy", AV6LastIsDummy);
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLASTISDUMMY", getSecureSignedToken( sPrefix, AV6LastIsDummy));
            if ( AV19WizardStepsAux.size() > AV7MaxStepsToShow + 1 )
            {
               AV8PenultimateIsDummy = true ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PenultimateIsDummy", AV8PenultimateIsDummy);
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPENULTIMATEISDUMMY", getSecureSignedToken( sPrefix, AV8PenultimateIsDummy));
               ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV19WizardStepsAux.elementAt(-1+AV19WizardStepsAux.size()-1)).setgxTv_SdtWizardSteps_WizardStepsItem_Title( "..." );
               while ( AV19WizardStepsAux.size() > AV7MaxStepsToShow + 2 )
               {
                  AV19WizardStepsAux.removeItem(AV19WizardStepsAux.size()-2);
                  gx_BV5 = true ;
               }
            }
         }
      }
   }

   private void e120D2( )
   {
      /* Gridwizardsteps_Load Routine */
      returnInSub = false ;
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV19WizardStepsAux.size() )
      {
         AV19WizardStepsAux.currentItem( ((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV19WizardStepsAux.elementAt(-1+AV20GXV1)) );
         AV16TableContainerStepClass = "TableContainerStep" ;
         lblStepnumber_Caption = localUtil.format( DecimalUtil.doubleToDec(AV15StepRealNumber), "ZZZ9") ;
         if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)(AV19WizardStepsAux.currentItem())).getgxTv_SdtWizardSteps_WizardStepsItem_Code(), AV11SelectedStep) == 0 )
         {
            edtavWizardstepsaux__title_Class = "AttributeStepSelected" ;
            imgStepimg_gximage = "StepUnSelectedSelected" ;
            imgStepimg_Bitmap = context.getHttpContext().getImagePath( "8f7f2ead-3d17-4e23-a450-7d98b62b7f40", "", context.getHttpContext().getTheme( )) ;
            imgStepimg_Class = "StepImage" ;
            AV16TableContainerStepClass = "TableContainerStepSelected" ;
            lblStepnumber_Class = "StepNumberSelected" ;
            divTblstep_Class = "TableStepSelected" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblstep_Internalname, "Class", divTblstep_Class, !bGXsfl_5_Refreshing);
            AV9PreviousSelected = true ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9PreviousSelected", AV9PreviousSelected);
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPREVIOUSSELECTED", getSecureSignedToken( sPrefix, AV9PreviousSelected));
         }
         else
         {
            imgStepimg_gximage = "StepSelectedUnSelected" ;
            imgStepimg_Bitmap = context.getHttpContext().getImagePath( "2fe377a7-df7d-42aa-84d4-4f1b853d50aa", "", context.getHttpContext().getTheme( )) ;
            if ( AV9PreviousSelected )
            {
               imgStepimg_Class = "StepImage" ;
            }
            else
            {
               imgStepimg_Class = "StepImageUnSelected" ;
            }
            lblStepnumber_Class = "StepNumber" ;
            divTblstep_Class = "TableStep" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblstep_Internalname, "Class", divTblstep_Class, !bGXsfl_5_Refreshing);
            edtavWizardstepsaux__title_Class = "AttributeStep" ;
            AV9PreviousSelected = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9PreviousSelected", AV9PreviousSelected);
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPREVIOUSSELECTED", getSecureSignedToken( sPrefix, AV9PreviousSelected));
         }
         if ( AV14StepNumber == 1 )
         {
            imgStepimg_Visible = 0 ;
            AV16TableContainerStepClass += " " + "TableContainerStepFirst" ;
         }
         else
         {
            if ( AV14StepNumber == AV19WizardStepsAux.size() )
            {
               AV16TableContainerStepClass += " " + "TableContainerStepLast" ;
            }
            imgStepimg_Visible = 1 ;
         }
         tblTblcontainerstep_Class = AV16TableContainerStepClass ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblcontainerstep_Internalname, "Class", tblTblcontainerstep_Class, !bGXsfl_5_Refreshing);
         divTblstep_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblstep_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblstep_Visible), 5, 0), !bGXsfl_5_Refreshing);
         lblStepnumber_Visible = 1 ;
         edtavWizardstepsaux__title_Visible = 1 ;
         if ( ( AV14StepNumber == 1 ) && AV5FirstIsDummy )
         {
            lblStepnumber_Caption = GXutil.trim( GXutil.str( AV14StepNumber, 4, 0)) ;
            edtavWizardstepsaux__title_Visible = 0 ;
         }
         else if ( ( AV14StepNumber == AV19WizardStepsAux.size() ) && AV6LastIsDummy )
         {
            lblStepnumber_Caption = GXutil.trim( GXutil.str( AV18WizardSteps.size(), 9, 0)) ;
            edtavWizardstepsaux__title_Visible = 0 ;
         }
         else if ( ( ( AV14StepNumber == 2 ) && AV10SecondIsDummy ) || ( ( AV14StepNumber == AV19WizardStepsAux.size() - 1 ) && AV8PenultimateIsDummy ) )
         {
            lblStepnumber_Visible = 0 ;
            divTblstep_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblstep_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblstep_Visible), 5, 0), !bGXsfl_5_Refreshing);
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
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_2_0D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblTablemain_Internalname, tblTablemain_Internalname, "", "TableWizardStepsArrow", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
            AV20GXV1 = nGXsfl_5_idx ;
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
         wb_table1_2_0D2e( true) ;
      }
      else
      {
         wb_table1_2_0D2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV18WizardSteps = (GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>)getParm(obj,0) ;
      AV11SelectedStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11SelectedStep", AV11SelectedStep);
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
      pa0D2( ) ;
      ws0D2( ) ;
      we0D2( ) ;
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
      sCtrlAV18WizardSteps = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV11SelectedStep = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0D2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wizardstepsarrowwc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0D2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV18WizardSteps = (GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>)getParm(obj,2) ;
         AV11SelectedStep = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11SelectedStep", AV11SelectedStep);
      }
      wcpOAV11SelectedStep = httpContext.cgiGet( sPrefix+"wcpOAV11SelectedStep") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV11SelectedStep, wcpOAV11SelectedStep) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV11SelectedStep = AV11SelectedStep ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV18WizardSteps = httpContext.cgiGet( sPrefix+"AV18WizardSteps_CTRL") ;
      if ( GXutil.len( sCtrlAV18WizardSteps) > 0 )
      {
         AV18WizardSteps = new GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>() ;
      }
      else
      {
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"AV18WizardSteps_PARM"), AV18WizardSteps);
      }
      sCtrlAV11SelectedStep = httpContext.cgiGet( sPrefix+"AV11SelectedStep_CTRL") ;
      if ( GXutil.len( sCtrlAV11SelectedStep) > 0 )
      {
         AV11SelectedStep = httpContext.cgiGet( sCtrlAV11SelectedStep) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11SelectedStep", AV11SelectedStep);
      }
      else
      {
         AV11SelectedStep = httpContext.cgiGet( sPrefix+"AV11SelectedStep_PARM") ;
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
      pa0D2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0D2( ) ;
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
      ws0D2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"AV18WizardSteps_PARM", AV18WizardSteps);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"AV18WizardSteps_PARM", AV18WizardSteps);
      }
      if ( GXutil.len( GXutil.rtrim( sCtrlAV18WizardSteps)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV18WizardSteps_CTRL", GXutil.rtrim( sCtrlAV18WizardSteps));
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11SelectedStep_PARM", AV11SelectedStep);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV11SelectedStep)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11SelectedStep_CTRL", GXutil.rtrim( sCtrlAV11SelectedStep));
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
      we0D2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163541", true, true);
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
         httpContext.AddJavascriptSource("wwpbaseobjects/wizardstepsarrowwc.js", "?202442617163541", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_52( )
   {
      imgStepimg_Internalname = sPrefix+"STEPIMG_"+sGXsfl_5_idx ;
      lblStepnumber_Internalname = sPrefix+"STEPNUMBER_"+sGXsfl_5_idx ;
      edtavWizardstepsaux__title_Internalname = sPrefix+"WIZARDSTEPSAUX__TITLE_"+sGXsfl_5_idx ;
   }

   public void subsflControlProps_fel_52( )
   {
      imgStepimg_Internalname = sPrefix+"STEPIMG_"+sGXsfl_5_fel_idx ;
      lblStepnumber_Internalname = sPrefix+"STEPNUMBER_"+sGXsfl_5_fel_idx ;
      edtavWizardstepsaux__title_Internalname = sPrefix+"WIZARDSTEPSAUX__TITLE_"+sGXsfl_5_fel_idx ;
   }

   public void sendrow_52( )
   {
      subsflControlProps_52( ) ;
      wb0D0( ) ;
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
      GridwizardstepsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTblcontainerstep_Internalname+"_"+sGXsfl_5_idx,Integer.valueOf(1),tblTblcontainerstep_Class,"","","","","","",Integer.valueOf(0),Integer.valueOf(0),"","","","px","px",""});
      GridwizardstepsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Static images/pictures */
      ClassString = imgStepimg_Class + " " + ((GXutil.strcmp(imgStepimg_gximage, "")==0) ? "GX_Image__Class" : "GX_Image_"+imgStepimg_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = imgStepimg_Bitmap ;
      GridwizardstepsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {imgStepimg_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(imgStepimg_Visible),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         GridwizardstepsContainer.CloseTag("cell");
      }
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","TableStepNumberCell"});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayout_tblstep_Internalname+"_"+sGXsfl_5_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Section","start","top","","","div"});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Section","start","top"," "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ","","div"});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTblstep_Internalname+"_"+sGXsfl_5_idx,Integer.valueOf(divTblstep_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px",divTblstep_Class,"start","top","","","div"});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 StepNumberCell","start","top","","","div"});
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
      GridwizardstepsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","AttributeStepCell"});
      /* Single line edit */
      ROClassString = edtavWizardstepsaux__title_Class ;
      GridwizardstepsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWizardstepsaux__title_Internalname,((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV19WizardStepsAux.elementAt(-1+AV20GXV1)).getgxTv_SdtWizardSteps_WizardStepsItem_Title(),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavWizardstepsaux__title_Jsonclick,Integer.valueOf(0),edtavWizardstepsaux__title_Class,"",ROClassString,"","",Integer.valueOf(edtavWizardstepsaux__title_Visible),Integer.valueOf(edtavWizardstepsaux__title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","start",Boolean.valueOf(true),""});
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
      send_integrity_lvl_hashes0D2( ) ;
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
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsColumn.AddObjectProperty("Value", lblStepnumber_Caption);
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsColumn.AddObjectProperty("Class", GXutil.rtrim( edtavWizardstepsaux__title_Class));
         GridwizardstepsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavWizardstepsaux__title_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridwizardstepsColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavWizardstepsaux__title_Visible, (byte)(5), (byte)(0), ".", "")));
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
      imgStepimg_Internalname = sPrefix+"STEPIMG" ;
      lblStepnumber_Internalname = sPrefix+"STEPNUMBER" ;
      divTblstep_Internalname = sPrefix+"TBLSTEP" ;
      divLayout_tblstep_Internalname = sPrefix+"LAYOUT_TBLSTEP" ;
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
      edtavWizardstepsaux__title_Jsonclick = "" ;
      edtavWizardstepsaux__title_Class = "AttributeStep" ;
      edtavWizardstepsaux__title_Enabled = 0 ;
      edtavWizardstepsaux__title_Visible = 1 ;
      lblStepnumber_Class = "StepNumber" ;
      lblStepnumber_Caption = "1" ;
      lblStepnumber_Visible = 1 ;
      divTblstep_Visible = 1 ;
      imgStepimg_Class = "StepImageUnSelected" ;
      imgStepimg_Visible = 1 ;
      imgStepimg_Bitmap = "" ;
      subGridwizardsteps_Class = "FreeStyleSteps" ;
      tblTblcontainerstep_Class = "TableContainerStep" ;
      divTblstep_Class = "TableStep" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDWIZARDSTEPS_nFirstRecordOnPage'},{av:'GRIDWIZARDSTEPS_nEOF'},{av:'AV11SelectedStep',fld:'vSELECTEDSTEP',pic:''},{av:'AV18WizardSteps',fld:'vWIZARDSTEPS',pic:''},{av:'sPrefix'},{av:'AV19WizardStepsAux',fld:'vWIZARDSTEPSAUX',grid:5,pic:'',hsh:true},{av:'nGXsfl_5_idx',ctrl:'GRID',prop:'GridCurrRow',grid:5},{av:'nRC_GXsfl_5',ctrl:'GRIDWIZARDSTEPS',prop:'GridRC',grid:5},{av:'AV15StepRealNumber',fld:'vSTEPREALNUMBER',pic:'ZZZ9',hsh:true},{av:'AV9PreviousSelected',fld:'vPREVIOUSSELECTED',pic:'',hsh:true},{av:'AV14StepNumber',fld:'vSTEPNUMBER',pic:'ZZZ9',hsh:true},{av:'AV5FirstIsDummy',fld:'vFIRSTISDUMMY',pic:'',hsh:true},{av:'AV6LastIsDummy',fld:'vLASTISDUMMY',pic:'',hsh:true},{av:'AV10SecondIsDummy',fld:'vSECONDISDUMMY',pic:'',hsh:true},{av:'AV8PenultimateIsDummy',fld:'vPENULTIMATEISDUMMY',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDWIZARDSTEPS.LOAD","{handler:'e120D2',iparms:[{av:'AV15StepRealNumber',fld:'vSTEPREALNUMBER',pic:'ZZZ9',hsh:true},{av:'AV19WizardStepsAux',fld:'vWIZARDSTEPSAUX',grid:5,pic:'',hsh:true},{av:'nGXsfl_5_idx',ctrl:'GRID',prop:'GridCurrRow',grid:5},{av:'GRIDWIZARDSTEPS_nFirstRecordOnPage'},{av:'nRC_GXsfl_5',ctrl:'GRIDWIZARDSTEPS',prop:'GridRC',grid:5},{av:'AV11SelectedStep',fld:'vSELECTEDSTEP',pic:''},{av:'AV9PreviousSelected',fld:'vPREVIOUSSELECTED',pic:'',hsh:true},{av:'AV14StepNumber',fld:'vSTEPNUMBER',pic:'ZZZ9',hsh:true},{av:'AV5FirstIsDummy',fld:'vFIRSTISDUMMY',pic:'',hsh:true},{av:'AV6LastIsDummy',fld:'vLASTISDUMMY',pic:'',hsh:true},{av:'AV18WizardSteps',fld:'vWIZARDSTEPS',pic:''},{av:'AV10SecondIsDummy',fld:'vSECONDISDUMMY',pic:'',hsh:true},{av:'AV8PenultimateIsDummy',fld:'vPENULTIMATEISDUMMY',pic:'',hsh:true}]");
      setEventMetadata("GRIDWIZARDSTEPS.LOAD",",oparms:[{av:'lblStepnumber_Caption',ctrl:'STEPNUMBER',prop:'Caption'},{ctrl:'WIZARDSTEPSAUX__TITLE',prop:'Class'},{av:'imgStepimg_Class',ctrl:'STEPIMG',prop:'Class'},{av:'lblStepnumber_Class',ctrl:'STEPNUMBER',prop:'Class'},{av:'divTblstep_Class',ctrl:'TBLSTEP',prop:'Class'},{av:'AV9PreviousSelected',fld:'vPREVIOUSSELECTED',pic:'',hsh:true},{av:'imgStepimg_Visible',ctrl:'STEPIMG',prop:'Visible'},{av:'tblTblcontainerstep_Class',ctrl:'TBLCONTAINERSTEP',prop:'Class'},{av:'divTblstep_Visible',ctrl:'TBLSTEP',prop:'Visible'},{av:'lblStepnumber_Visible',ctrl:'STEPNUMBER',prop:'Visible'},{ctrl:'WIZARDSTEPSAUX__TITLE',prop:'Visible'},{av:'AV15StepRealNumber',fld:'vSTEPREALNUMBER',pic:'ZZZ9',hsh:true},{av:'AV14StepNumber',fld:'vSTEPNUMBER',pic:'ZZZ9',hsh:true}]}");
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
      wcpOAV11SelectedStep = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV18WizardSteps = new GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "Gregory", remoteHandle);
      AV11SelectedStep = "" ;
      AV19WizardStepsAux = new GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "Gregory", remoteHandle);
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
      AV17WizardStep = new com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV16TableContainerStepClass = "" ;
      imgStepimg_gximage = "" ;
      GridwizardstepsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV18WizardSteps = "" ;
      sCtrlAV11SelectedStep = "" ;
      subGridwizardsteps_Linesclass = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      lblStepnumber_Jsonclick = "" ;
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
   private short AV14StepNumber ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short AV7MaxStepsToShow ;
   private short AV12SelectedStepIndex ;
   private short AV13StartIndex ;
   private int nRC_GXsfl_5 ;
   private int nGXsfl_5_idx=1 ;
   private int AV20GXV1 ;
   private int subGridwizardsteps_Islastpage ;
   private int edtavWizardstepsaux__title_Enabled ;
   private int nGXsfl_5_fel_idx=1 ;
   private int AV22GXV3 ;
   private int imgStepimg_Visible ;
   private int divTblstep_Visible ;
   private int lblStepnumber_Visible ;
   private int edtavWizardstepsaux__title_Visible ;
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
   private String edtavWizardstepsaux__title_Class ;
   private String imgStepimg_gximage ;
   private String imgStepimg_Class ;
   private String lblStepnumber_Class ;
   private String divTblstep_Class ;
   private String divTblstep_Internalname ;
   private String tblTblcontainerstep_Class ;
   private String tblTblcontainerstep_Internalname ;
   private String tblTablemain_Internalname ;
   private String sCtrlAV18WizardSteps ;
   private String sCtrlAV11SelectedStep ;
   private String imgStepimg_Internalname ;
   private String lblStepnumber_Internalname ;
   private String subGridwizardsteps_Class ;
   private String subGridwizardsteps_Linesclass ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String divLayout_tblstep_Internalname ;
   private String lblStepnumber_Jsonclick ;
   private String ROClassString ;
   private String edtavWizardstepsaux__title_Jsonclick ;
   private String subGridwizardsteps_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV9PreviousSelected ;
   private boolean AV5FirstIsDummy ;
   private boolean AV6LastIsDummy ;
   private boolean AV10SecondIsDummy ;
   private boolean AV8PenultimateIsDummy ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_5_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV5 ;
   private String wcpOAV11SelectedStep ;
   private String AV11SelectedStep ;
   private String AV16TableContainerStepClass ;
   private String imgStepimg_Bitmap ;
   private com.genexus.webpanels.GXWebGrid GridwizardstepsContainer ;
   private com.genexus.webpanels.GXWebRow GridwizardstepsRow ;
   private com.genexus.webpanels.GXWebColumn GridwizardstepsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV18WizardSteps ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV19WizardStepsAux ;
   private com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV17WizardStep ;
}

