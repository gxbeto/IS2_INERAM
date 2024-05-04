package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wizardstepsverticalwc_impl extends GXWebComponent
{
   public wizardstepsverticalwc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wizardstepsverticalwc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wizardstepsverticalwc_impl.class ));
   }

   public wizardstepsverticalwc_impl( int remoteHandle ,
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
               AV6CurrentStep = httpContext.GetPar( "CurrentStep") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CurrentStep", AV6CurrentStep);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV18WizardSteps,AV6CurrentStep});
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
      nRC_GXsfl_9 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_9"))) ;
      nGXsfl_9_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_9_idx"))) ;
      sGXsfl_9_idx = httpContext.GetPar( "sGXsfl_9_idx") ;
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
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV18WizardSteps);
      AV15StepNumber = (short)(GXutil.lval( httpContext.GetPar( "StepNumber"))) ;
      AV13SelectedStepNumber = (short)(GXutil.lval( httpContext.GetPar( "SelectedStepNumber"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridwizardsteps_refresh( AV18WizardSteps, AV15StepNumber, AV13SelectedStepNumber, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridwizardsteps_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa0J2( ) ;
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
      com.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
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
         httpContext.writeValue( "Wizard Steps Vertical WC") ;
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
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.wizardstepsverticalwc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV6CurrentStep))}, new String[] {"WizardSteps","CurrentStep"}) +"\">") ;
            com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
            com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
            com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
            httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
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
         com.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
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
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV15StepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSELECTEDSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV13SelectedStepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV13SelectedStepNumber), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_9", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_9, (byte)(8), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6CurrentStep", wcpOAV6CurrentStep);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDSTEPS", AV18WizardSteps);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDSTEPS", AV18WizardSteps);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV15StepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSELECTEDSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV13SelectedStepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV13SelectedStepNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCURRENTSTEP", AV6CurrentStep);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"subGridwizardsteps_Recordcount", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Recordcount, (byte)(5), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDWIZARDSTEPS_Class", GXutil.rtrim( subGridwizardsteps_Class));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDWIZARDSTEPS_Flexdirection", GXutil.rtrim( subGridwizardsteps_Flexdirection));
   }

   public void renderHtmlCloseForm0J2( )
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
      return "WWPBaseObjects.WizardStepsVerticalWC" ;
   }

   public String getPgmdesc( )
   {
      return "Wizard Steps Vertical WC" ;
   }

   public void wb0J0( )
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
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.wwpbaseobjects.wizardstepsverticalwc");
         }
         com.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "start", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /*  Grid Control  */
         GridwizardstepsContainer.SetIsFreestyle(true);
         GridwizardstepsContainer.SetWrapped(nGXWrapped);
         startgridcontrol9( ) ;
      }
      if ( wbEnd == 9 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_9 = (int)(nGXsfl_9_idx-1) ;
         if ( GridwizardstepsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
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
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 9 )
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

   public void start0J2( )
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
         Form.getMeta().addItem("description", "Wizard Steps Vertical WC", (short)(0)) ;
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
            strup0J0( ) ;
         }
      }
   }

   public void ws0J2( )
   {
      start0J2( ) ;
      evt0J2( ) ;
   }

   public void evt0J2( )
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
                              strup0J0( ) ;
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
                              strup0J0( ) ;
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
                              strup0J0( ) ;
                           }
                           nGXsfl_9_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_92( ) ;
                           AV22WizardStepTitle = httpContext.cgiGet( edtavWizardsteptitle_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWizardsteptitle_Internalname, AV22WizardStepTitle);
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
                                       e110J2 ();
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
                                       e120J2 ();
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
                                    strup0J0( ) ;
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

   public void we0J2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0J2( ) ;
         }
      }
   }

   public void pa0J2( )
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
      subsflControlProps_92( ) ;
      while ( nGXsfl_9_idx <= nRC_GXsfl_9 )
      {
         sendrow_92( ) ;
         nGXsfl_9_idx = ((subGridwizardsteps_Islastpage==1)&&(nGXsfl_9_idx+1>subgridwizardsteps_fnc_recordsperpage( )) ? 1 : nGXsfl_9_idx+1) ;
         sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_92( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridwizardstepsContainer)) ;
      /* End function gxnrGridwizardsteps_newrow */
   }

   public void gxgrgridwizardsteps_refresh( GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV18WizardSteps ,
                                            short AV15StepNumber ,
                                            short AV13SelectedStepNumber ,
                                            String sPrefix )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDWIZARDSTEPS_nCurrentRecord = 0 ;
      rf0J2( ) ;
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
      rf0J2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavWizardsteptitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizardsteptitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizardsteptitle_Enabled), 5, 0), !bGXsfl_9_Refreshing);
   }

   public void rf0J2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridwizardstepsContainer.ClearRows();
      }
      wbStart = (short)(9) ;
      nGXsfl_9_idx = 1 ;
      sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_92( ) ;
      bGXsfl_9_Refreshing = true ;
      GridwizardstepsContainer.AddObjectProperty("GridName", "Gridwizardsteps");
      GridwizardstepsContainer.AddObjectProperty("CmpContext", sPrefix);
      GridwizardstepsContainer.AddObjectProperty("InMasterPage", "false");
      GridwizardstepsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleStepsVertical"));
      GridwizardstepsContainer.AddObjectProperty("Class", "FreeStyleStepsVertical");
      GridwizardstepsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridwizardstepsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridwizardstepsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridwizardsteps_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridwizardstepsContainer.setPageSize( subgridwizardsteps_fnc_recordsperpage( ) );
      if ( subGridwizardsteps_Islastpage != 0 )
      {
         GRIDWIZARDSTEPS_nFirstRecordOnPage = (long)(subgridwizardsteps_fnc_recordcount( )-subgridwizardsteps_fnc_recordsperpage( )) ;
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDWIZARDSTEPS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDWIZARDSTEPS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridwizardstepsContainer.AddObjectProperty("GRIDWIZARDSTEPS_nFirstRecordOnPage", GRIDWIZARDSTEPS_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_92( ) ;
         e120J2 ();
         wbEnd = (short)(9) ;
         wb0J0( ) ;
      }
      bGXsfl_9_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0J2( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV15StepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepNumber), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSELECTEDSTEPNUMBER", GXutil.ltrim( localUtil.ntoc( AV13SelectedStepNumber, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV13SelectedStepNumber), "ZZZ9")));
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
      edtavWizardsteptitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizardsteptitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizardsteptitle_Enabled), 5, 0), !bGXsfl_9_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup0J0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110J2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_9 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_9"), ",", ".")) ;
         wcpOAV6CurrentStep = httpContext.cgiGet( sPrefix+"wcpOAV6CurrentStep") ;
         subGridwizardsteps_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"subGridwizardsteps_Recordcount"), ",", ".")) ;
         subGridwizardsteps_Class = httpContext.cgiGet( sPrefix+"GRIDWIZARDSTEPS_Class") ;
         subGridwizardsteps_Flexdirection = httpContext.cgiGet( sPrefix+"GRIDWIZARDSTEPS_Flexdirection") ;
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
      e110J2 ();
      if (returnInSub) return;
   }

   public void e110J2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV13SelectedStepNumber = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13SelectedStepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13SelectedStepNumber), 4, 0));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV13SelectedStepNumber), "ZZZ9")));
      AV23GXV1 = 1 ;
      while ( AV23GXV1 <= AV18WizardSteps.size() )
      {
         AV5WizardStep = (com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV18WizardSteps.elementAt(-1+AV23GXV1));
         if ( GXutil.strcmp(AV5WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), AV6CurrentStep) == 0 )
         {
            if (true) break;
         }
         else
         {
            AV13SelectedStepNumber = (short)(AV13SelectedStepNumber+1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13SelectedStepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13SelectedStepNumber), 4, 0));
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSELECTEDSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV13SelectedStepNumber), "ZZZ9")));
         }
         AV23GXV1 = (int)(AV23GXV1+1) ;
      }
      AV15StepNumber = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15StepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15StepNumber), 4, 0));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepNumber), "ZZZ9")));
   }

   private void e120J2( )
   {
      /* Gridwizardsteps_Load Routine */
      returnInSub = false ;
      AV24GXV2 = 1 ;
      while ( AV24GXV2 <= AV18WizardSteps.size() )
      {
         AV5WizardStep = (com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV18WizardSteps.elementAt(-1+AV24GXV2));
         AV22WizardStepTitle = AV5WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Title() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWizardsteptitle_Internalname, AV22WizardStepTitle);
         lblStepnumber_Caption = localUtil.format( DecimalUtil.doubleToDec(AV15StepNumber), "ZZZ9") ;
         if ( AV15StepNumber < AV13SelectedStepNumber )
         {
            divUnnamedtablefsgridwizardsteps_Class = "Table CompletedStep" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divUnnamedtablefsgridwizardsteps_Internalname, "Class", divUnnamedtablefsgridwizardsteps_Class, !bGXsfl_9_Refreshing);
         }
         else if ( AV15StepNumber == AV13SelectedStepNumber )
         {
            divUnnamedtablefsgridwizardsteps_Class = "Table CurrentStep" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divUnnamedtablefsgridwizardsteps_Internalname, "Class", divUnnamedtablefsgridwizardsteps_Class, !bGXsfl_9_Refreshing);
         }
         else
         {
            divUnnamedtablefsgridwizardsteps_Class = "Table RemainingStep" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divUnnamedtablefsgridwizardsteps_Internalname, "Class", divUnnamedtablefsgridwizardsteps_Class, !bGXsfl_9_Refreshing);
         }
         lblStepnumber_Caption = GXutil.trim( GXutil.str( AV15StepNumber, 4, 0)) ;
         AV15StepNumber = (short)(AV15StepNumber+1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15StepNumber", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15StepNumber), 4, 0));
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSTEPNUMBER", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV15StepNumber), "ZZZ9")));
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(9) ;
         }
         sendrow_92( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_9_Refreshing )
         {
            httpContext.doAjaxLoad(9, GridwizardstepsRow);
         }
         AV24GXV2 = (int)(AV24GXV2+1) ;
      }
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV18WizardSteps = (GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>)getParm(obj,0) ;
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
      pa0J2( ) ;
      ws0J2( ) ;
      we0J2( ) ;
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
      sCtrlAV6CurrentStep = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0J2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wizardstepsverticalwc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0J2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV18WizardSteps = (GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>)getParm(obj,2) ;
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
      sCtrlAV18WizardSteps = httpContext.cgiGet( sPrefix+"AV18WizardSteps_CTRL") ;
      if ( GXutil.len( sCtrlAV18WizardSteps) > 0 )
      {
         AV18WizardSteps = new GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>() ;
      }
      else
      {
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"AV18WizardSteps_PARM"), AV18WizardSteps);
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
      pa0J2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0J2( ) ;
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
      ws0J2( ) ;
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
      we0J2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163458", true, true);
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
         httpContext.AddJavascriptSource("wwpbaseobjects/wizardstepsverticalwc.js", "?202442617163458", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_92( )
   {
      lblStepnumber_Internalname = sPrefix+"STEPNUMBER_"+sGXsfl_9_idx ;
      edtavWizardsteptitle_Internalname = sPrefix+"vWIZARDSTEPTITLE_"+sGXsfl_9_idx ;
   }

   public void subsflControlProps_fel_92( )
   {
      lblStepnumber_Internalname = sPrefix+"STEPNUMBER_"+sGXsfl_9_fel_idx ;
      edtavWizardsteptitle_Internalname = sPrefix+"vWIZARDSTEPTITLE_"+sGXsfl_9_fel_idx ;
   }

   public void sendrow_92( )
   {
      subsflControlProps_92( ) ;
      wb0J0( ) ;
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
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsgridwizardsteps_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",divUnnamedtablefsgridwizardsteps_Class,"start","top","","","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTblcontainerstep_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","start","top"," "+"data-gx-flex"+" ","","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablestepitem_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableStepVertical","start","top","","","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 StepNumberVerticalCell","start","top","","","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Text block */
      GridwizardstepsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblStepnumber_Internalname,lblStepnumber_Caption,"","",lblStepnumber_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","StepNumberVertical",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","hidden-xs","start","top","","flex-grow:1;","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Div Control */
      GridwizardstepsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Attribute/Variable Label */
      GridwizardstepsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavWizardsteptitle_Internalname,"Wizard Step Title","gx-form-item AttributeStepVerticalLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      /* Multiple line edit */
      ClassString = "AttributeStepVertical" ;
      StyleString = "" ;
      ClassString = "AttributeStepVertical" ;
      StyleString = "" ;
      GridwizardstepsRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavWizardsteptitle_Internalname,AV22WizardStepTitle,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavWizardsteptitle_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(false),"","'"+sPrefix+"'"+",false,"+"'"+""+"'",Integer.valueOf(0),""});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      GridwizardstepsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridwizardstepsRow.AddRenderProperties(GridwizardstepsColumn);
      send_integrity_lvl_hashes0J2( ) ;
      /* End of Columns property logic. */
      GridwizardstepsContainer.AddRow(GridwizardstepsRow);
      nGXsfl_9_idx = ((subGridwizardsteps_Islastpage==1)&&(nGXsfl_9_idx+1>subgridwizardsteps_fnc_recordsperpage( )) ? 1 : nGXsfl_9_idx+1) ;
      sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_92( ) ;
      /* End function sendrow_92 */
   }

   public void startgridcontrol9( )
   {
      if ( GridwizardstepsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridwizardstepsContainer"+"DivS\" data-gxgridid=\"9\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGridwizardsteps_Internalname, subGridwizardsteps_Internalname, "", "FreeStyleStepsVertical", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridwizardstepsContainer.AddObjectProperty("GridName", "Gridwizardsteps");
      }
      else
      {
         GridwizardstepsContainer.AddObjectProperty("GridName", "Gridwizardsteps");
         GridwizardstepsContainer.AddObjectProperty("Header", subGridwizardsteps_Header);
         GridwizardstepsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleStepsVertical"));
         GridwizardstepsContainer.AddObjectProperty("Class", "FreeStyleStepsVertical");
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
         GridwizardstepsColumn.AddObjectProperty("Value", lblStepnumber_Caption);
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsContainer.AddColumnProperties(GridwizardstepsColumn);
         GridwizardstepsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwizardstepsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV22WizardStepTitle));
         GridwizardstepsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavWizardsteptitle_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      lblStepnumber_Internalname = sPrefix+"STEPNUMBER" ;
      divTablestepitem_Internalname = sPrefix+"TABLESTEPITEM" ;
      edtavWizardsteptitle_Internalname = sPrefix+"vWIZARDSTEPTITLE" ;
      divTblcontainerstep_Internalname = sPrefix+"TBLCONTAINERSTEP" ;
      divUnnamedtablefsgridwizardsteps_Internalname = sPrefix+"UNNAMEDTABLEFSGRIDWIZARDSTEPS" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
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
      edtavWizardsteptitle_Enabled = 0 ;
      lblStepnumber_Caption = "1" ;
      divUnnamedtablefsgridwizardsteps_Class = "Table" ;
      subGridwizardsteps_Backcolorstyle = (byte)(0) ;
      subGridwizardsteps_Flexdirection = "column" ;
      subGridwizardsteps_Class = "FreeStyleStepsVertical" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDWIZARDSTEPS_nFirstRecordOnPage'},{av:'GRIDWIZARDSTEPS_nEOF'},{av:'AV18WizardSteps',fld:'vWIZARDSTEPS',pic:''},{av:'sPrefix'},{av:'AV15StepNumber',fld:'vSTEPNUMBER',pic:'ZZZ9',hsh:true},{av:'AV13SelectedStepNumber',fld:'vSELECTEDSTEPNUMBER',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDWIZARDSTEPS.LOAD","{handler:'e120J2',iparms:[{av:'AV18WizardSteps',fld:'vWIZARDSTEPS',pic:''},{av:'AV15StepNumber',fld:'vSTEPNUMBER',pic:'ZZZ9',hsh:true},{av:'AV13SelectedStepNumber',fld:'vSELECTEDSTEPNUMBER',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("GRIDWIZARDSTEPS.LOAD",",oparms:[{av:'AV22WizardStepTitle',fld:'vWIZARDSTEPTITLE',pic:''},{av:'lblStepnumber_Caption',ctrl:'STEPNUMBER',prop:'Caption'},{av:'divUnnamedtablefsgridwizardsteps_Class',ctrl:'UNNAMEDTABLEFSGRIDWIZARDSTEPS',prop:'Class'},{av:'AV15StepNumber',fld:'vSTEPNUMBER',pic:'ZZZ9',hsh:true}]}");
      setEventMetadata("NULL","{handler:'validv_Wizardsteptitle',iparms:[]");
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
      AV18WizardSteps = new GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "Gregory", remoteHandle);
      AV6CurrentStep = "" ;
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
      AV22WizardStepTitle = "" ;
      AV5WizardStep = new com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      GridwizardstepsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV18WizardSteps = "" ;
      sCtrlAV6CurrentStep = "" ;
      subGridwizardsteps_Linesclass = "" ;
      GridwizardstepsColumn = new com.genexus.webpanels.GXWebColumn();
      lblStepnumber_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      subGridwizardsteps_Header = "" ;
      /* GeneXus formulas. */
      edtavWizardsteptitle_Enabled = 0 ;
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
   private short AV15StepNumber ;
   private short AV13SelectedStepNumber ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int nRC_GXsfl_9 ;
   private int subGridwizardsteps_Recordcount ;
   private int nGXsfl_9_idx=1 ;
   private int subGridwizardsteps_Islastpage ;
   private int edtavWizardsteptitle_Enabled ;
   private int AV23GXV1 ;
   private int AV24GXV2 ;
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
   private String sGXsfl_9_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String subGridwizardsteps_Class ;
   private String subGridwizardsteps_Flexdirection ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String subGridwizardsteps_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavWizardsteptitle_Internalname ;
   private String lblStepnumber_Caption ;
   private String divUnnamedtablefsgridwizardsteps_Class ;
   private String divUnnamedtablefsgridwizardsteps_Internalname ;
   private String sCtrlAV18WizardSteps ;
   private String sCtrlAV6CurrentStep ;
   private String lblStepnumber_Internalname ;
   private String sGXsfl_9_fel_idx="0001" ;
   private String subGridwizardsteps_Linesclass ;
   private String divTblcontainerstep_Internalname ;
   private String divTablestepitem_Internalname ;
   private String lblStepnumber_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String subGridwizardsteps_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_9_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String wcpOAV6CurrentStep ;
   private String AV6CurrentStep ;
   private String AV22WizardStepTitle ;
   private com.genexus.webpanels.GXWebGrid GridwizardstepsContainer ;
   private com.genexus.webpanels.GXWebRow GridwizardstepsRow ;
   private com.genexus.webpanels.GXWebColumn GridwizardstepsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV18WizardSteps ;
   private com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV5WizardStep ;
}

