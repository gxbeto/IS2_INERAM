package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_searchwc_impl extends GXWebComponent
{
   public wwp_searchwc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_searchwc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_searchwc_impl.class ));
   }

   public wwp_searchwc_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "SearchText") ;
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
               AV22SearchText = httpContext.GetPar( "SearchText") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22SearchText", AV22SearchText);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV22SearchText});
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
               gxfirstwebparm = httpContext.GetFirstPar( "SearchText") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "SearchText") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Fsresults") == 0 )
            {
               gxnrfsresults_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Fsresults") == 0 )
            {
               gxgrfsresults_refresh_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Fsresultcategories") == 0 )
            {
               gxnrfsresultcategories_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Fsresultcategories") == 0 )
            {
               gxgrfsresultcategories_refresh_invoke( ) ;
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

   public void gxnrfsresults_newrow_invoke( )
   {
      nRC_GXsfl_29 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_29"))) ;
      nGXsfl_29_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_29_idx"))) ;
      sGXsfl_29_idx = httpContext.GetPar( "sGXsfl_29_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      edtavUrl_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUrl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Visible), 5, 0), !bGXsfl_29_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrfsresults_newrow( ) ;
      /* End function gxnrFsresults_newrow_invoke */
   }

   public void gxgrfsresults_refresh_invoke( )
   {
      edtavUrl_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUrl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Visible), 5, 0), !bGXsfl_29_Refreshing);
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV26WWP_SearchResults);
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfsresults_refresh( AV26WWP_SearchResults, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFsresults_refresh_invoke */
   }

   public void gxnrfsresultcategories_newrow_invoke( )
   {
      nRC_GXsfl_21 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_21"))) ;
      nGXsfl_21_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_21_idx"))) ;
      sGXsfl_21_idx = httpContext.GetPar( "sGXsfl_21_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrfsresultcategories_newrow( ) ;
      /* End function gxnrFsresultcategories_newrow_invoke */
   }

   public void gxgrfsresultcategories_refresh_invoke( )
   {
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV26WWP_SearchResults);
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfsresultcategories_refresh( AV26WWP_SearchResults, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFsresultcategories_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa0N2( ) ;
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
         httpContext.writeValue( "WWP_Search WC") ;
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
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.wwp_searchwc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22SearchText))}, new String[] {"SearchText"}) +"\">") ;
         com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
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
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWWP_SEARCHRESULTS", AV26WWP_SearchResults);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWWP_SEARCHRESULTS", AV26WWP_SearchResults);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWP_SEARCHRESULTS", getSecureSignedToken( sPrefix, AV26WWP_SearchResults));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Wwp_searchresults", AV26WWP_SearchResults);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Wwp_searchresults", AV26WWP_SearchResults);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_Wwp_searchresults", getSecureSignedToken( sPrefix, AV26WWP_SearchResults));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_21", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_21, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV9DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV9DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vADVFILTERENTITIES_DATA", AV6AdvFilterEntities_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vADVFILTERENTITIES_DATA", AV6AdvFilterEntities_Data);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV22SearchText", wcpOAV22SearchText);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWWP_SEARCHRESULTS", AV26WWP_SearchResults);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWWP_SEARCHRESULTS", AV26WWP_SearchResults);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWP_SEARCHRESULTS", getSecureSignedToken( sPrefix, AV26WWP_SearchResults));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSEARCHTEXT", AV22SearchText);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vADVFILTERENTITIES", AV5AdvFilterEntities);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vADVFILTERENTITIES", AV5AdvFilterEntities);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TABLEADVANCEDSEARCHCELL_Class", GXutil.rtrim( divTableadvancedsearchcell_Class));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TABLESIMPLESEARCHCELL_Class", GXutil.rtrim( divTablesimplesearchcell_Class));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_ADVFILTERENTITIES_Selectedvalue_get", GXutil.rtrim( Combo_advfilterentities_Selectedvalue_get));
   }

   public void renderHtmlCloseForm0N2( )
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
         httpContext.writeTextNL( "</form>") ;
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
      return "WWPBaseObjects.WWP_SearchWC" ;
   }

   public String getPgmdesc( )
   {
      return "WWP_Search WC" ;
   }

   public void wb0N0( )
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
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.wwpbaseobjects.wwp_searchwc");
            httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
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
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CloseSearchIconCell", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblClosesearch_Internalname, "<i class=\"fa fa-times\"></i>", "", "", lblClosesearch_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOCLOSESEARCH\\'."+"'", "", "TextBlock", 5, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects/WWP_SearchWC.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divShowall_cell_Internalname, 1, 0, "px", 0, "px", divShowall_cell_Class, "start", "top", "", "", "div");
         /* User Defined Control */
         ucBtnshowall.setProperty("TooltipText", Btnshowall_Tooltiptext);
         ucBtnshowall.setProperty("BeforeIconClass", Btnshowall_Beforeiconclass);
         ucBtnshowall.setProperty("Caption", Btnshowall_Caption);
         ucBtnshowall.setProperty("Class", Btnshowall_Class);
         ucBtnshowall.render(context, "wwp_iconbutton", Btnshowall_Internalname, sPrefix+"BTNSHOWALLContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTxtnoresultscell_Internalname, 1, 0, "px", 0, "px", divTxtnoresultscell_Class, "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblTxtnoresults_Internalname, lblTxtnoresults_Caption, "", "", lblTxtnoresults_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlockShowingOnly", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_SearchWC.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablesimplesearchcell_Internalname, 1, 0, "px", 0, "px", divTablesimplesearchcell_Class, "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablesimplesearch_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divFsresultcategories_cell_Internalname, 1, 0, "px", 0, "px", divFsresultcategories_cell_Class, "start", "top", "", "", "div");
         /*  Grid Control  */
         FsresultcategoriesContainer.SetIsFreestyle(true);
         FsresultcategoriesContainer.SetWrapped(nGXWrapped);
         startgridcontrol21( ) ;
      }
      if ( wbEnd == 21 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_21 = (int)(nGXsfl_21_idx-1) ;
         if ( FsresultcategoriesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV28GXV1 = nGXsfl_21_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"FsresultcategoriesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Fsresultcategories", FsresultcategoriesContainer, subFsresultcategories_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FsresultcategoriesContainerData", FsresultcategoriesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FsresultcategoriesContainerData"+"V", FsresultcategoriesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"FsresultcategoriesContainerData"+"V"+"\" value='"+FsresultcategoriesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTableadvancedsearchcell_Internalname, 1, 0, "px", 0, "px", divTableadvancedsearchcell_Class, "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTableadvancedsearch_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtavAdvfiltertext_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, edtavAdvfiltertext_Internalname, "Buscar", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'" + sPrefix + "',false,'" + sGXsfl_21_idx + "',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavAdvfiltertext_Internalname, AV8AdvFilterText, GXutil.rtrim( localUtil.format( AV8AdvFilterText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAdvfiltertext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavAdvfiltertext_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/WWP_SearchWC.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablesplittedadvfilterentities_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_advfilterentities_Internalname, "Buscar en", "", "", lblTextblockcombo_advfilterentities_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_SearchWC.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "start", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_advfilterentities.setProperty("Caption", Combo_advfilterentities_Caption);
         ucCombo_advfilterentities.setProperty("Cls", Combo_advfilterentities_Cls);
         ucCombo_advfilterentities.setProperty("AllowMultipleSelection", Combo_advfilterentities_Allowmultipleselection);
         ucCombo_advfilterentities.setProperty("IncludeOnlySelectedOption", Combo_advfilterentities_Includeonlyselectedoption);
         ucCombo_advfilterentities.setProperty("EmptyItem", Combo_advfilterentities_Emptyitem);
         ucCombo_advfilterentities.setProperty("MultipleValuesType", Combo_advfilterentities_Multiplevaluestype);
         ucCombo_advfilterentities.setProperty("DropDownOptionsTitleSettingsIcons", AV9DDO_TitleSettingsIcons);
         ucCombo_advfilterentities.setProperty("DropDownOptionsData", AV6AdvFilterEntities_Data);
         ucCombo_advfilterentities.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_advfilterentities_Internalname, sPrefix+"COMBO_ADVFILTERENTITIESContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "end", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnadvsearch_Internalname, "gx.evt.setGridEvt("+GXutil.str( 21, 2, 0)+","+"null"+");", "Buscar", bttBtnbtnadvsearch_Jsonclick, 5, "Buscar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOBTNADVSEARCH\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/WWP_SearchWC.htm");
         com.GxWebStd.gx_div_end( httpContext, "end", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 BtnAdvancedSearchCell", "start", "top", "", "", "div");
         /* User Defined Control */
         ucBtnadvancedsearch.setProperty("TooltipText", Btnadvancedsearch_Tooltiptext);
         ucBtnadvancedsearch.setProperty("BeforeIconClass", Btnadvancedsearch_Beforeiconclass);
         ucBtnadvancedsearch.setProperty("Caption", Btnadvancedsearch_Caption);
         ucBtnadvancedsearch.setProperty("Class", Btnadvancedsearch_Class);
         ucBtnadvancedsearch.render(context, "wwp_iconbutton", Btnadvancedsearch_Internalname, sPrefix+"BTNADVANCEDSEARCHContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 21 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( FsresultcategoriesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV28GXV1 = nGXsfl_21_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"FsresultcategoriesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Fsresultcategories", FsresultcategoriesContainer, subFsresultcategories_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FsresultcategoriesContainerData", FsresultcategoriesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FsresultcategoriesContainerData"+"V", FsresultcategoriesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"FsresultcategoriesContainerData"+"V"+"\" value='"+FsresultcategoriesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 29 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( FsresultsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV30GXV3 = nGXsfl_29_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"FsresultsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Fsresults", FsresultsContainer, subFsresults_Internalname);
               if ( ! isAjaxCallMode( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FsresultsContainerData", FsresultsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FsresultsContainerData"+"V", FsresultsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"FsresultsContainerData"+"V"+"\" value='"+FsresultsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start0N2( )
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
         Form.getMeta().addItem("description", "WWP_Search WC", (short)(0)) ;
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
            strup0N0( ) ;
         }
      }
   }

   public void ws0N2( )
   {
      start0N2( ) ;
      evt0N2( ) ;
   }

   public void evt0N2( )
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
                              strup0N0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "'DOCLOSESEARCH'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0N0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoCloseSearch' */
                                 e110N2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOSHOWALL'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0N0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoShowAll' */
                                 e120N2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNADVSEARCH'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0N0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoBtnAdvSearch' */
                                 e130N2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "UNNAMEDTABLEFSFSRESULTS.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0N0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e140N2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0N0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavAdvfiltertext_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "FSRESULTCATEGORIES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 14), "FSRESULTS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "UNNAMEDTABLEFSFSRESULTS.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0N0( ) ;
                           }
                           nGXsfl_21_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_212( ) ;
                           AV28GXV1 = nGXsfl_21_idx ;
                           if ( ( AV26WWP_SearchResults.size() >= AV28GXV1 ) && ( AV28GXV1 > 0 ) )
                           {
                              AV26WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV26WWP_SearchResults.elementAt(-1+AV28GXV1)) );
                           }
                           GXCCtl = "subFsresults_Recordcount_" + sGXsfl_21_idx ;
                           subFsresults_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+GXCCtl), ",", ".")) ;
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
                                       GX_FocusControl = edtavAdvfiltertext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e150N2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "FSRESULTCATEGORIES.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavAdvfiltertext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e160N2 ();
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
                                    strup0N0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavAdvfiltertext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
                              }
                           }
                           else
                           {
                              sEvtType = GXutil.right( sEvt, 4) ;
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                              if ( ( GXutil.strcmp(GXutil.left( sEvt, 14), "FSRESULTS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "UNNAMEDTABLEFSFSRESULTS.CLICK") == 0 ) )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup0N0( ) ;
                                 }
                                 nGXsfl_29_idx = (int)(GXutil.lval( sEvtType)) ;
                                 sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") + sGXsfl_21_idx ;
                                 subsflControlProps_293( ) ;
                                 AV24Url = httpContext.cgiGet( edtavUrl_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUrl_Internalname, AV24Url);
                                 AV10DisplayType1_Title = httpContext.cgiGet( edtavDisplaytype1_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype1_title_Internalname, AV10DisplayType1_Title);
                                 AV11DisplayType2_Title = httpContext.cgiGet( edtavDisplaytype2_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype2_title_Internalname, AV11DisplayType2_Title);
                                 AV13DisplayType3_Title = httpContext.cgiGet( edtavDisplaytype3_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype3_title_Internalname, AV13DisplayType3_Title);
                                 AV12DisplayType3_Subtitle = httpContext.cgiGet( edtavDisplaytype3_subtitle_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype3_subtitle_Internalname, AV12DisplayType3_Subtitle);
                                 AV14DisplayType4_Image = httpContext.cgiGet( edtavDisplaytype4_image_Internalname) ;
                                 httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype4_image_Internalname, "Bitmap", ((GXutil.strcmp("", AV14DisplayType4_Image)==0) ? AV31Displaytype4_image_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV14DisplayType4_Image))), !bGXsfl_29_Refreshing);
                                 httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype4_image_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV14DisplayType4_Image), true);
                                 AV15DisplayType4_Title = httpContext.cgiGet( edtavDisplaytype4_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype4_title_Internalname, AV15DisplayType4_Title);
                                 AV17DisplayType5_Title = httpContext.cgiGet( edtavDisplaytype5_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype5_title_Internalname, AV17DisplayType5_Title);
                                 AV16DisplayType5_Subtitle = httpContext.cgiGet( edtavDisplaytype5_subtitle_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype5_subtitle_Internalname, AV16DisplayType5_Subtitle);
                                 sEvtType = GXutil.right( sEvt, 1) ;
                                 if ( GXutil.strcmp(sEvtType, ".") == 0 )
                                 {
                                    sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                    if ( GXutil.strcmp(sEvt, "FSRESULTS.LOAD") == 0 )
                                    {
                                       if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                       {
                                          httpContext.wbHandled = (byte)(1) ;
                                          if ( ! wbErr )
                                          {
                                             dynload_actions( ) ;
                                             GX_FocusControl = edtavAdvfiltertext_Internalname ;
                                             httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                             e170N3 ();
                                          }
                                       }
                                    }
                                    else if ( GXutil.strcmp(sEvt, "UNNAMEDTABLEFSFSRESULTS.CLICK") == 0 )
                                    {
                                       if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                       {
                                          httpContext.wbHandled = (byte)(1) ;
                                          if ( ! wbErr )
                                          {
                                             dynload_actions( ) ;
                                             GX_FocusControl = edtavAdvfiltertext_Internalname ;
                                             httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                             e140N2 ();
                                          }
                                       }
                                    }
                                    else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                    {
                                       if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                       {
                                          strup0N0( ) ;
                                       }
                                       if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                       {
                                          httpContext.wbHandled = (byte)(1) ;
                                          if ( ! wbErr )
                                          {
                                             dynload_actions( ) ;
                                             GX_FocusControl = edtavAdvfiltertext_Internalname ;
                                             httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we0N2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0N2( ) ;
         }
      }
   }

   public void pa0N2( )
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
            GX_FocusControl = edtavAdvfiltertext_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrfsresultcategories_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_212( ) ;
      while ( nGXsfl_21_idx <= nRC_GXsfl_21 )
      {
         sendrow_212( ) ;
         nGXsfl_21_idx = ((subFsresultcategories_Islastpage==1)&&(nGXsfl_21_idx+1>subfsresultcategories_fnc_recordsperpage( )) ? 1 : nGXsfl_21_idx+1) ;
         sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_212( ) ;
      }
      addString( httpContext.getJSONContainerResponse( FsresultcategoriesContainer)) ;
      /* End function gxnrFsresultcategories_newrow */
   }

   public void gxnrfsresults_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_293( ) ;
      while ( nGXsfl_29_idx <= nRC_GXsfl_29 )
      {
         sendrow_293( ) ;
         nGXsfl_29_idx = ((subFsresults_Islastpage==1)&&(nGXsfl_29_idx+1>subfsresults_fnc_recordsperpage( )) ? 1 : nGXsfl_29_idx+1) ;
         sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") + sGXsfl_21_idx ;
         subsflControlProps_293( ) ;
      }
      addString( httpContext.getJSONContainerResponse( FsresultsContainer)) ;
      /* End function gxnrFsresults_newrow */
   }

   public void gxgrfsresults_refresh( GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV26WWP_SearchResults ,
                                      String sPrefix )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      FSRESULTS_nCurrentRecord = 0 ;
      rf0N3( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrFsresults_refresh */
   }

   public void gxgrfsresultcategories_refresh( GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV26WWP_SearchResults ,
                                               String sPrefix )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      FSRESULTCATEGORIES_nCurrentRecord = 0 ;
      rf0N2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrFsresultcategories_refresh */
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
      rf0N2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavWwp_searchresults__categoryname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwp_searchresults__categoryname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwp_searchresults__categoryname_Enabled), 5, 0), !bGXsfl_21_Refreshing);
      edtavDisplaytype1_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype1_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype1_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype2_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype2_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype2_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype3_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype3_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype3_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype3_subtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype3_subtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype3_subtitle_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype4_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype4_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype4_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype5_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype5_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype5_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype5_subtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype5_subtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype5_subtitle_Enabled), 5, 0), !bGXsfl_29_Refreshing);
   }

   public void rf0N2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         FsresultcategoriesContainer.ClearRows();
      }
      wbStart = (short)(21) ;
      nGXsfl_21_idx = 1 ;
      sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_212( ) ;
      bGXsfl_21_Refreshing = true ;
      FsresultcategoriesContainer.AddObjectProperty("GridName", "Fsresultcategories");
      FsresultcategoriesContainer.AddObjectProperty("CmpContext", sPrefix);
      FsresultcategoriesContainer.AddObjectProperty("InMasterPage", "false");
      FsresultcategoriesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGridMPSearch"));
      FsresultcategoriesContainer.AddObjectProperty("Class", "FreeStyleGridMPSearch");
      FsresultcategoriesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      FsresultcategoriesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      FsresultcategoriesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      FsresultcategoriesContainer.setPageSize( subfsresultcategories_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_212( ) ;
         e160N2 ();
         wbEnd = (short)(21) ;
         wb0N0( ) ;
      }
      bGXsfl_21_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0N2( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWWP_SEARCHRESULTS", AV26WWP_SearchResults);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWWP_SEARCHRESULTS", AV26WWP_SearchResults);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWP_SEARCHRESULTS", getSecureSignedToken( sPrefix, AV26WWP_SearchResults));
   }

   public void rf0N3( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         FsresultsContainer.ClearRows();
      }
      wbStart = (short)(29) ;
      nGXsfl_29_idx = 1 ;
      sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") + sGXsfl_21_idx ;
      subsflControlProps_293( ) ;
      bGXsfl_29_Refreshing = true ;
      FsresultsContainer.AddObjectProperty("GridName", "Fsresults");
      FsresultsContainer.AddObjectProperty("CmpContext", sPrefix);
      FsresultsContainer.AddObjectProperty("InMasterPage", "false");
      FsresultsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      FsresultsContainer.AddObjectProperty("Class", "FreeStyleGrid");
      FsresultsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      FsresultsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      FsresultsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFsresults_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      FsresultsContainer.setPageSize( subfsresults_fnc_recordsperpage( ) );
      GXCCtl = "FSRESULTS_nFirstRecordOnPage_" + sGXsfl_21_idx ;
      if ( subFsresults_Islastpage != 0 )
      {
         FSRESULTS_nFirstRecordOnPage = (long)(subfsresults_fnc_recordcount( )-subfsresults_fnc_recordsperpage( )) ;
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+GXCCtl, GXutil.ltrim( localUtil.ntoc( FSRESULTS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("FSRESULTS_nFirstRecordOnPage", FSRESULTS_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_293( ) ;
         e170N3 ();
         wbEnd = (short)(29) ;
         wb0N0( ) ;
      }
      bGXsfl_29_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0N3( )
   {
   }

   public int subfsresultcategories_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subfsresultcategories_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subfsresultcategories_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subfsresultcategories_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subfsresults_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subfsresults_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subfsresults_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subfsresults_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      edtavWwp_searchresults__categoryname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwp_searchresults__categoryname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwp_searchresults__categoryname_Enabled), 5, 0), !bGXsfl_21_Refreshing);
      edtavDisplaytype1_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype1_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype1_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype2_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype2_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype2_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype3_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype3_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype3_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype3_subtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype3_subtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype3_subtitle_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype4_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype4_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype4_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype5_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype5_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype5_title_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavDisplaytype5_subtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplaytype5_subtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype5_subtitle_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup0N0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e150N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"Wwp_searchresults"), AV26WWP_SearchResults);
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV9DDO_TitleSettingsIcons);
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"vADVFILTERENTITIES_DATA"), AV6AdvFilterEntities_Data);
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"vWWP_SEARCHRESULTS"), AV26WWP_SearchResults);
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"vADVFILTERENTITIES"), AV5AdvFilterEntities);
         /* Read saved values. */
         nRC_GXsfl_21 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_21"), ",", ".")) ;
         wcpOAV22SearchText = httpContext.cgiGet( sPrefix+"wcpOAV22SearchText") ;
         nRC_GXsfl_21 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_21"), ",", ".")) ;
         nGXsfl_21_fel_idx = 0 ;
         while ( nGXsfl_21_fel_idx < nRC_GXsfl_21 )
         {
            nGXsfl_21_fel_idx = ((subFsresultcategories_Islastpage==1)&&(nGXsfl_21_fel_idx+1>subfsresultcategories_fnc_recordsperpage( )) ? 1 : nGXsfl_21_fel_idx+1) ;
            sGXsfl_21_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_212( ) ;
            AV28GXV1 = nGXsfl_21_fel_idx ;
            if ( ( AV26WWP_SearchResults.size() >= AV28GXV1 ) && ( AV28GXV1 > 0 ) )
            {
               AV26WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV26WWP_SearchResults.elementAt(-1+AV28GXV1)) );
            }
            GXCCtl = "subFsresults_Recordcount_" + sGXsfl_21_fel_idx ;
            subFsresults_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+GXCCtl), ",", ".")) ;
         }
         if ( nGXsfl_21_fel_idx == 0 )
         {
            nGXsfl_21_idx = 1 ;
            sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_212( ) ;
         }
         nGXsfl_21_fel_idx = 1 ;
         /* Read variables values. */
         AV8AdvFilterText = httpContext.cgiGet( edtavAdvfiltertext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8AdvFilterText", AV8AdvFilterText);
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
      e150N2 ();
      if (returnInSub) return;
   }

   public void e150N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV20MinimumCharsToSearch = (short)(2) ;
      AV23ShowingRecents = false ;
      if ( GXutil.len( GXutil.trim( AV22SearchText)) < AV20MinimumCharsToSearch )
      {
         GXt_char1 = AV21RecentSearchResultsJson ;
         GXv_char2[0] = GXt_char1 ;
         new com.wwpbaseobjects.loaduserkeyvalue(remoteHandle, context).execute( "WWPRecentSearch", GXv_char2) ;
         wwp_searchwc_impl.this.GXt_char1 = GXv_char2[0] ;
         AV21RecentSearchResultsJson = GXt_char1 ;
         if ( ! (GXutil.strcmp("", AV21RecentSearchResultsJson)==0) )
         {
            AV26WWP_SearchResults.fromJSonString(AV21RecentSearchResultsJson, null);
            gx_BV21 = true ;
            AV23ShowingRecents = (boolean)(((AV26WWP_SearchResults.size()>0))) ;
         }
      }
      else
      {
         GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem3 = AV26WWP_SearchResults ;
         GXv_objcol_svchar4[0] = AV5AdvFilterEntities ;
         GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5[0] = GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem3 ;
         new com.wwpbaseobjects.wwp_getsearchwcdata(remoteHandle, context).execute( AV22SearchText, (short)(4), (short)(3), GXv_objcol_svchar4, GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5) ;
         AV5AdvFilterEntities = GXv_objcol_svchar4[0] ;
         GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem3 = GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5[0] ;
         AV26WWP_SearchResults = GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem3 ;
         gx_BV21 = true ;
      }
      if ( AV26WWP_SearchResults.size() == 0 )
      {
         divShowall_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divShowall_cell_Internalname, "Class", divShowall_cell_Class, true);
         divFsresultcategories_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divFsresultcategories_cell_Internalname, "Class", divFsresultcategories_cell_Class, true);
         if ( GXutil.len( GXutil.trim( AV22SearchText)) < AV20MinimumCharsToSearch )
         {
            lblTxtnoresults_Caption = "Escribe para buscar en la aplicación o el menú" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTxtnoresults_Internalname, "Caption", lblTxtnoresults_Caption, true);
         }
         else
         {
            lblTxtnoresults_Caption = GXutil.format( "No se encontraron resultados para '%1'.", AV22SearchText, "", "", "", "", "", "", "", "") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTxtnoresults_Internalname, "Caption", lblTxtnoresults_Caption, true);
         }
      }
      else
      {
         if ( AV23ShowingRecents )
         {
            divShowall_cell_Class = "Invisible" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divShowall_cell_Internalname, "Class", divShowall_cell_Class, true);
            lblTxtnoresults_Caption = "Mostrando resultados recientes" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTxtnoresults_Internalname, "Caption", lblTxtnoresults_Caption, true);
         }
         else
         {
            divTxtnoresultscell_Class = "Invisible" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divTxtnoresultscell_Internalname, "Class", divTxtnoresultscell_Class, true);
         }
      }
      Btnshowall_Caption = GXutil.format( "Mostrar todos los resultados para '%1'...", AV22SearchText, "", "", "", "", "", "", "", "") ;
      ucBtnshowall.sendProperty(context, sPrefix, false, Btnshowall_Internalname, "Caption", Btnshowall_Caption);
      divTableadvancedsearchcell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTableadvancedsearchcell_Internalname, "Class", divTableadvancedsearchcell_Class, true);
      AV8AdvFilterText = AV22SearchText ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8AdvFilterText", AV8AdvFilterText);
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = AV9DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6;
      new com.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7[0];
      AV9DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6;
      /* Execute user subroutine: 'LOADCOMBOADVFILTERENTITIES' */
      S112 ();
      if (returnInSub) return;
      edtavUrl_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUrl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Visible), 5, 0), !bGXsfl_29_Refreshing);
   }

   private void e160N2( )
   {
      /* Fsresultcategories_Load Routine */
      returnInSub = false ;
      AV28GXV1 = 1 ;
      while ( AV28GXV1 <= AV26WWP_SearchResults.size() )
      {
         AV26WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV26WWP_SearchResults.elementAt(-1+AV28GXV1)) );
         divShowingonlycell_Visible = ((!((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults()) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divShowingonlycell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divShowingonlycell_Visible), 5, 0), !bGXsfl_21_Refreshing);
         lblTxtshowingonly_Caption = GXutil.format( "Mostrando los primeros %1 resultados", GXutil.ltrimstr( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().size(), 9, 0), "", "", "", "", "", "", "", "") ;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(21) ;
         }
         sendrow_212( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_21_Refreshing )
         {
            httpContext.doAjaxLoad(21, FsresultcategoriesRow);
         }
         AV28GXV1 = (int)(AV28GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e110N2( )
   {
      /* 'DoCloseSearch' Routine */
      returnInSub = false ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "Popover_Close", new Object[] {divTablemain_Internalname,Boolean.valueOf(false)}, false);
   }

   public void e120N2( )
   {
      /* 'DoShowAll' Routine */
      returnInSub = false ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "Popover_Close", new Object[] {divTablemain_Internalname,Boolean.valueOf(false)}, false);
      callWebObject(formatLink("com.wwpbaseobjects.wwp_search", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22SearchText)),GXutil.URLEncode(GXutil.booltostr(false)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"DeafultSearchText","DefaultIsAdvancedSearch","DefaultAdvFilterEntitiesJson"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e130N2( )
   {
      /* 'DoBtnAdvSearch' Routine */
      returnInSub = false ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "Popover_Close", new Object[] {divTablemain_Internalname,Boolean.valueOf(false)}, false);
      callWebObject(formatLink("com.wwpbaseobjects.wwp_search", new String[] {GXutil.URLEncode(GXutil.rtrim(AV8AdvFilterText)),GXutil.URLEncode(GXutil.booltostr(true)),GXutil.URLEncode(GXutil.rtrim(AV5AdvFilterEntities.toJSonString(false)))}, new String[] {"DeafultSearchText","DefaultIsAdvancedSearch","DefaultAdvFilterEntitiesJson"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S112( )
   {
      /* 'LOADCOMBOADVFILTERENTITIES' Routine */
      returnInSub = false ;
      GXv_objcol_svchar4[0] = AV19EntityDescriptions ;
      GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5[0] = AV25WWP_SearchResultAux ;
      new com.wwpbaseobjects.wwp_getsearchwcdata(remoteHandle, context).execute( "", (short)(999), (short)(0), GXv_objcol_svchar4, GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5) ;
      AV19EntityDescriptions = GXv_objcol_svchar4[0] ;
      AV25WWP_SearchResultAux = GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5[0] ;
      AV6AdvFilterEntities_Data = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle) ;
      AV32GXV4 = 1 ;
      while ( AV32GXV4 <= AV19EntityDescriptions.size() )
      {
         AV18EntityDescription = (String)AV19EntityDescriptions.elementAt(-1+AV32GXV4) ;
         AV7AdvFilterEntities_DataItem = (com.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV7AdvFilterEntities_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( AV18EntityDescription );
         AV7AdvFilterEntities_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( AV18EntityDescription );
         AV6AdvFilterEntities_Data.add(AV7AdvFilterEntities_DataItem, 0);
         AV32GXV4 = (int)(AV32GXV4+1) ;
      }
      Combo_advfilterentities_Selectedvalue_set = AV5AdvFilterEntities.toJSonString(false) ;
      ucCombo_advfilterentities.sendProperty(context, sPrefix, false, Combo_advfilterentities_Internalname, "SelectedValue_set", Combo_advfilterentities_Selectedvalue_set);
   }

   public void e140N2( )
   {
      AV28GXV1 = nGXsfl_21_idx ;
      if ( ( AV28GXV1 > 0 ) && ( AV26WWP_SearchResults.size() >= AV28GXV1 ) )
      {
         AV26WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV26WWP_SearchResults.elementAt(-1+AV28GXV1)) );
      }
      /* Unnamedtablefsfsresults_Click Routine */
      returnInSub = false ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "Popover_Close", new Object[] {divTablemain_Internalname,Boolean.valueOf(false)}, false);
      new com.wwpbaseobjects.wwp_addrecentsearch(remoteHandle, context).execute( AV26WWP_SearchResults, AV24Url, (short)(4), (short)(3)) ;
      callWebObject(formatLink(AV24Url, new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(0) ;
   }

   private void e170N3( )
   {
      AV28GXV1 = nGXsfl_21_idx ;
      if ( AV26WWP_SearchResults.size() < AV28GXV1 )
      {
         return  ;
      }
      /* Fsresults_Load Routine */
      returnInSub = false ;
      AV30GXV3 = 1 ;
      while ( AV30GXV3 <= ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV26WWP_SearchResults.elementAt(-1+AV28GXV1)).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().size() )
      {
         ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV26WWP_SearchResults.elementAt(-1+AV28GXV1)).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV26WWP_SearchResults.elementAt(-1+AV28GXV1)).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().elementAt(-1+AV30GXV3)) );
         divDisplaytype1_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype1_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype1_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
         divDisplaytype2_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype2_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype2_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
         divDisplaytype3_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype3_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype3_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
         divDisplaytype4_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype4_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype4_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
         divDisplaytype5_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype5_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype5_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
         if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title") == 0 )
         {
            divDisplaytype1_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype1_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype1_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
            AV10DisplayType1_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype1_title_Internalname, AV10DisplayType1_Title);
         }
         else if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title and icon image") == 0 )
         {
            divDisplaytype2_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype2_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype2_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
            AV11DisplayType2_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype2_title_Internalname, AV11DisplayType2_Title);
            lblDisplaytype2_icon_Caption = GXutil.format( "<i class='SearchResultIcon %1'></i>", ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2(), "", "", "", "", "", "", "", "") ;
         }
         else if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title and subtitle") == 0 )
         {
            divDisplaytype3_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype3_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype3_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
            AV13DisplayType3_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype3_title_Internalname, AV13DisplayType3_Title);
            AV12DisplayType3_Subtitle = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype3_subtitle_Internalname, AV12DisplayType3_Subtitle);
         }
         else if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title and image") == 0 )
         {
            divDisplaytype4_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype4_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype4_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
            AV15DisplayType4_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype4_title_Internalname, AV15DisplayType4_Title);
            if ( (GXutil.strcmp("", ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2())==0) )
            {
               AV14DisplayType4_Image = "" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype4_image_Internalname, AV14DisplayType4_Image);
               AV31Displaytype4_image_GXI = "" ;
            }
            else
            {
               AV14DisplayType4_Image = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype4_image_Internalname, AV14DisplayType4_Image);
               AV31Displaytype4_image_GXI = GXDbFile.pathToUrl( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2(), context.getHttpContext()) ;
            }
            edtavDisplaytype4_image_Visible = ((!(GXutil.strcmp("", ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2())==0)) ? 1 : 0) ;
         }
         else if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title, subtitle and icon image") == 0 )
         {
            divDisplaytype5_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divDisplaytype5_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype5_cell_Visible), 5, 0), !bGXsfl_29_Refreshing);
            AV17DisplayType5_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype5_title_Internalname, AV17DisplayType5_Title);
            AV16DisplayType5_Subtitle = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplaytype5_subtitle_Internalname, AV16DisplayType5_Subtitle);
            lblDisplaytype5_icon_Caption = GXutil.format( "<i class='SearchResultIconWS %1'></i>", ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3(), "", "", "", "", "", "", "", "") ;
         }
         AV24Url = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV26WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUrl_Internalname, AV24Url);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(29) ;
         }
         sendrow_293( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_29_Refreshing )
         {
            httpContext.doAjaxLoad(29, FsresultsRow);
         }
         AV30GXV3 = (int)(AV30GXV3+1) ;
      }
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV22SearchText = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22SearchText", AV22SearchText);
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
      pa0N2( ) ;
      ws0N2( ) ;
      we0N2( ) ;
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
      sCtrlAV22SearchText = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0N2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wwp_searchwc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0N2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV22SearchText = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22SearchText", AV22SearchText);
      }
      wcpOAV22SearchText = httpContext.cgiGet( sPrefix+"wcpOAV22SearchText") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV22SearchText, wcpOAV22SearchText) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV22SearchText = AV22SearchText ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV22SearchText = httpContext.cgiGet( sPrefix+"AV22SearchText_CTRL") ;
      if ( GXutil.len( sCtrlAV22SearchText) > 0 )
      {
         AV22SearchText = httpContext.cgiGet( sCtrlAV22SearchText) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22SearchText", AV22SearchText);
      }
      else
      {
         AV22SearchText = httpContext.cgiGet( sPrefix+"AV22SearchText_PARM") ;
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
      pa0N2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0N2( ) ;
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
      ws0N2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV22SearchText_PARM", AV22SearchText);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV22SearchText)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV22SearchText_CTRL", GXutil.rtrim( sCtrlAV22SearchText));
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
      we0N2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163788", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/wwp_searchwc.js", "?202442617163789", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_293( )
   {
      edtavUrl_Internalname = sPrefix+"vURL_"+sGXsfl_29_idx ;
      edtavDisplaytype1_title_Internalname = sPrefix+"vDISPLAYTYPE1_TITLE_"+sGXsfl_29_idx ;
      lblDisplaytype2_icon_Internalname = sPrefix+"DISPLAYTYPE2_ICON_"+sGXsfl_29_idx ;
      edtavDisplaytype2_title_Internalname = sPrefix+"vDISPLAYTYPE2_TITLE_"+sGXsfl_29_idx ;
      edtavDisplaytype3_title_Internalname = sPrefix+"vDISPLAYTYPE3_TITLE_"+sGXsfl_29_idx ;
      edtavDisplaytype3_subtitle_Internalname = sPrefix+"vDISPLAYTYPE3_SUBTITLE_"+sGXsfl_29_idx ;
      edtavDisplaytype4_image_Internalname = sPrefix+"vDISPLAYTYPE4_IMAGE_"+sGXsfl_29_idx ;
      edtavDisplaytype4_title_Internalname = sPrefix+"vDISPLAYTYPE4_TITLE_"+sGXsfl_29_idx ;
      lblDisplaytype5_icon_Internalname = sPrefix+"DISPLAYTYPE5_ICON_"+sGXsfl_29_idx ;
      edtavDisplaytype5_title_Internalname = sPrefix+"vDISPLAYTYPE5_TITLE_"+sGXsfl_29_idx ;
      edtavDisplaytype5_subtitle_Internalname = sPrefix+"vDISPLAYTYPE5_SUBTITLE_"+sGXsfl_29_idx ;
   }

   public void subsflControlProps_fel_293( )
   {
      edtavUrl_Internalname = sPrefix+"vURL_"+sGXsfl_29_fel_idx ;
      edtavDisplaytype1_title_Internalname = sPrefix+"vDISPLAYTYPE1_TITLE_"+sGXsfl_29_fel_idx ;
      lblDisplaytype2_icon_Internalname = sPrefix+"DISPLAYTYPE2_ICON_"+sGXsfl_29_fel_idx ;
      edtavDisplaytype2_title_Internalname = sPrefix+"vDISPLAYTYPE2_TITLE_"+sGXsfl_29_fel_idx ;
      edtavDisplaytype3_title_Internalname = sPrefix+"vDISPLAYTYPE3_TITLE_"+sGXsfl_29_fel_idx ;
      edtavDisplaytype3_subtitle_Internalname = sPrefix+"vDISPLAYTYPE3_SUBTITLE_"+sGXsfl_29_fel_idx ;
      edtavDisplaytype4_image_Internalname = sPrefix+"vDISPLAYTYPE4_IMAGE_"+sGXsfl_29_fel_idx ;
      edtavDisplaytype4_title_Internalname = sPrefix+"vDISPLAYTYPE4_TITLE_"+sGXsfl_29_fel_idx ;
      lblDisplaytype5_icon_Internalname = sPrefix+"DISPLAYTYPE5_ICON_"+sGXsfl_29_fel_idx ;
      edtavDisplaytype5_title_Internalname = sPrefix+"vDISPLAYTYPE5_TITLE_"+sGXsfl_29_fel_idx ;
      edtavDisplaytype5_subtitle_Internalname = sPrefix+"vDISPLAYTYPE5_SUBTITLE_"+sGXsfl_29_fel_idx ;
   }

   public void sendrow_293( )
   {
      subsflControlProps_293( ) ;
      wb0N0( ) ;
      FsresultsRow = GXWebRow.GetNew(context,FsresultsContainer) ;
      if ( subFsresults_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFsresults_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFsresults_Class, "") != 0 )
         {
            subFsresults_Linesclass = subFsresults_Class+"Odd" ;
         }
      }
      else if ( subFsresults_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFsresults_Backstyle = (byte)(0) ;
         subFsresults_Backcolor = subFsresults_Allbackcolor ;
         if ( GXutil.strcmp(subFsresults_Class, "") != 0 )
         {
            subFsresults_Linesclass = subFsresults_Class+"Uniform" ;
         }
      }
      else if ( subFsresults_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFsresults_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFsresults_Class, "") != 0 )
         {
            subFsresults_Linesclass = subFsresults_Class+"Odd" ;
         }
         subFsresults_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFsresults_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFsresults_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_29_idx) % (2))) == 0 )
         {
            subFsresults_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subFsresults_Class, "") != 0 )
            {
               subFsresults_Linesclass = subFsresults_Class+"Even" ;
            }
         }
         else
         {
            subFsresults_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subFsresults_Class, "") != 0 )
            {
               subFsresults_Linesclass = subFsresults_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subFsresults_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_29_idx+"\">") ;
      }
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsfsresults_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","start","top"," "+"data-gx-flex"+" ","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Invisible","start","top","","flex-grow:1;","div"});
      /* Table start */
      FsresultsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsfsresults_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      FsresultsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      FsresultsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavUrl_Internalname,"Url","gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUrl_Internalname,AV24Url,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavUrl_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtavUrl_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("cell");
      }
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("row");
      }
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("table");
      }
      /* End of table */
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype1_cell_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(divDisplaytype1_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable1_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDisplaytype1_title_Internalname,"Display Type1_Title","col-sm-3 AttributeSearchResultTitleLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttributeSearchResultTitle" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype1_title_Internalname,AV10DisplayType1_Title,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype1_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype1_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype2_cell_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(divDisplaytype2_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;","div"});
      /* Table start */
      FsresultsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable2_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      FsresultsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      FsresultsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Text block */
      FsresultsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblDisplaytype2_icon_Internalname,lblDisplaytype2_icon_Caption,"","",lblDisplaytype2_icon_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("cell");
      }
      FsresultsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDisplaytype2_title_Internalname,"Display Type2_Title","gx-form-item AttributeSearchResultTitleLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "AttributeSearchResultTitle" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype2_title_Internalname,AV11DisplayType2_Title,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype2_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype2_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("cell");
      }
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("row");
      }
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("table");
      }
      /* End of table */
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype3_cell_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(divDisplaytype3_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable3_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDisplaytype3_title_Internalname,"Display Type3_Title","col-sm-3 AttributeSearchResultTitleLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttributeSearchResultTitle" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype3_title_Internalname,AV13DisplayType3_Title,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype3_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype3_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDisplaytype3_subtitle_Internalname,"Display Type3_Subtitle","col-sm-3 AttributeSearchResultSubtitleLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttributeSearchResultSubtitle" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype3_subtitle_Internalname,AV12DisplayType3_Subtitle,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype3_subtitle_Jsonclick,Integer.valueOf(0),"AttributeSearchResultSubtitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype3_subtitle_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      sendrow_29330( ) ;
   }

   public void sendrow_29330( )
   {
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype4_cell_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(divDisplaytype4_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable4_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","start","top"," "+"data-gx-flex"+" ","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","AttributeSearchResultImageCell","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"","Display Type4_Image","gx-form-item AttributeSearchResultImageLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Static Bitmap Variable */
      ClassString = "AttributeSearchResultImage" + " " + ((GXutil.strcmp(edtavDisplaytype4_image_gximage, "")==0) ? "" : "GX_Image_"+edtavDisplaytype4_image_gximage+"_Class") ;
      StyleString = "" ;
      AV14DisplayType4_Image_IsBlob = (boolean)(((GXutil.strcmp("", AV14DisplayType4_Image)==0)&&(GXutil.strcmp("", AV31Displaytype4_image_GXI)==0))||!(GXutil.strcmp("", AV14DisplayType4_Image)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV14DisplayType4_Image)==0) ? AV31Displaytype4_image_GXI : httpContext.getResourceRelative(AV14DisplayType4_Image)) ;
      FsresultsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype4_image_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavDisplaytype4_image_Visible),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV14DisplayType4_Image_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;align-self:center;","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDisplaytype4_title_Internalname,"Display Type4_Title","gx-form-item AttributeSearchResultTitleLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "AttributeSearchResultTitle" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype4_title_Internalname,AV15DisplayType4_Title,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype4_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype4_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype5_cell_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(divDisplaytype5_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;","div"});
      /* Table start */
      FsresultsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable5_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      FsresultsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      FsresultsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Text block */
      FsresultsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblDisplaytype5_icon_Internalname,lblDisplaytype5_icon_Caption,"","",lblDisplaytype5_icon_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("cell");
      }
      FsresultsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable6_Internalname+"_"+sGXsfl_29_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDisplaytype5_title_Internalname,"Display Type5_Title","col-sm-3 AttributeSearchResultTitleLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttributeSearchResultTitle" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype5_title_Internalname,AV17DisplayType5_Title,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype5_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype5_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDisplaytype5_subtitle_Internalname,"Display Type5_Subtitle","col-sm-3 AttributeSearchResultSubtitleLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttributeSearchResultSubtitle" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype5_subtitle_Internalname,AV16DisplayType5_Subtitle,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype5_subtitle_Jsonclick,Integer.valueOf(0),"AttributeSearchResultSubtitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype5_subtitle_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("cell");
      }
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("row");
      }
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("table");
      }
      /* End of table */
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      send_integrity_lvl_hashes0N3( ) ;
      /* End of Columns property logic. */
      FsresultsContainer.AddRow(FsresultsRow);
      nGXsfl_29_idx = ((subFsresults_Islastpage==1)&&(nGXsfl_29_idx+1>subfsresults_fnc_recordsperpage( )) ? 1 : nGXsfl_29_idx+1) ;
      sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") + sGXsfl_21_idx ;
      subsflControlProps_293( ) ;
      /* End function sendrow_293 */
   }

   public void subsflControlProps_212( )
   {
      edtavWwp_searchresults__categoryname_Internalname = sPrefix+"WWP_SEARCHRESULTS__CATEGORYNAME_"+sGXsfl_21_idx ;
      lblTxtshowingonly_Internalname = sPrefix+"TXTSHOWINGONLY_"+sGXsfl_21_idx ;
      subFsresults_Internalname = sPrefix+"FSRESULTS_"+sGXsfl_21_idx ;
   }

   public void subsflControlProps_fel_212( )
   {
      edtavWwp_searchresults__categoryname_Internalname = sPrefix+"WWP_SEARCHRESULTS__CATEGORYNAME_"+sGXsfl_21_fel_idx ;
      lblTxtshowingonly_Internalname = sPrefix+"TXTSHOWINGONLY_"+sGXsfl_21_fel_idx ;
      subFsresults_Internalname = sPrefix+"FSRESULTS_"+sGXsfl_21_fel_idx ;
   }

   public void sendrow_212( )
   {
      subsflControlProps_212( ) ;
      wb0N0( ) ;
      FsresultcategoriesRow = GXWebRow.GetNew(context,FsresultcategoriesContainer) ;
      if ( subFsresultcategories_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFsresultcategories_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFsresultcategories_Class, "") != 0 )
         {
            subFsresultcategories_Linesclass = subFsresultcategories_Class+"Odd" ;
         }
      }
      else if ( subFsresultcategories_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFsresultcategories_Backstyle = (byte)(0) ;
         subFsresultcategories_Backcolor = subFsresultcategories_Allbackcolor ;
         if ( GXutil.strcmp(subFsresultcategories_Class, "") != 0 )
         {
            subFsresultcategories_Linesclass = subFsresultcategories_Class+"Uniform" ;
         }
      }
      else if ( subFsresultcategories_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFsresultcategories_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFsresultcategories_Class, "") != 0 )
         {
            subFsresultcategories_Linesclass = subFsresultcategories_Class+"Odd" ;
         }
         subFsresultcategories_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFsresultcategories_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFsresultcategories_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_21_idx) % (2))) == 0 )
         {
            subFsresultcategories_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subFsresultcategories_Class, "") != 0 )
            {
               subFsresultcategories_Linesclass = subFsresultcategories_Class+"Even" ;
            }
         }
         else
         {
            subFsresultcategories_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subFsresultcategories_Class, "") != 0 )
            {
               subFsresultcategories_Linesclass = subFsresultcategories_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( FsresultcategoriesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subFsresultcategories_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_21_idx+"\">") ;
      }
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsfsresultcategories_Internalname+"_"+sGXsfl_21_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","start","top","","","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 SearchResultMPCategoryCell","start","top","","","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultcategoriesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavWwp_searchresults__categoryname_Internalname,"Category Name","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      FsresultcategoriesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWwp_searchresults__categoryname_Internalname,((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV26WWP_SearchResults.elementAt(-1+AV28GXV1)).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname(),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavWwp_searchresults__categoryname_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavWwp_searchresults__categoryname_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /*  Child Grid Control  */
      FsresultcategoriesRow.AddColumnProperties("subfile", -1, isAjaxCallMode( ), new Object[] {"FsresultsContainer"});
      if ( isAjaxCallMode( ) )
      {
         FsresultsContainer = new com.genexus.webpanels.GXWebGrid(context);
      }
      else
      {
         FsresultsContainer.Clear();
      }
      FsresultsContainer.SetIsFreestyle(true);
      FsresultsContainer.SetWrapped(nGXWrapped);
      startgridcontrol29( ) ;
      rf0N3( ) ;
      nRC_GXsfl_29 = (int)(nGXsfl_29_idx-1) ;
      send_integrity_footer_hashes( ) ;
      GXCCtl = "nRC_GXsfl_29_" + sGXsfl_21_idx ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+GXCCtl, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_29, (byte)(8), (byte)(0), ",", "")));
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "</table>") ;
      }
      else
      {
         if ( ! isAjaxCallMode( ) )
         {
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FsresultsContainerData"+"_"+sGXsfl_21_idx, FsresultsContainer.ToJavascriptSource());
         }
         if ( isAjaxCallMode( ) )
         {
            FsresultcategoriesRow.AddGrid("Fsresults", FsresultsContainer);
         }
         if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
         {
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FsresultsContainerData"+"V_"+sGXsfl_21_idx, FsresultsContainer.GridValuesHidden());
         }
         else
         {
            httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"FsresultsContainerData"+"V_"+sGXsfl_21_idx+"\" value='"+FsresultsContainer.GridValuesHidden()+"'/>") ;
         }
      }
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divShowingonlycell_Internalname+"_"+sGXsfl_21_idx,Integer.valueOf(divShowingonlycell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Text block */
      FsresultcategoriesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTxtshowingonly_Internalname,lblTxtshowingonly_Caption,"","",lblTxtshowingonly_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","TextBlockShowingOnly",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      send_integrity_lvl_hashes0N2( ) ;
      GXCCtl = "subFsresults_Recordcount_" + sGXsfl_21_idx ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+GXCCtl, GXutil.ltrim( localUtil.ntoc( subFsresults_Recordcount, (byte)(5), (byte)(0), ",", "")));
      /* End of Columns property logic. */
      FsresultcategoriesContainer.AddRow(FsresultcategoriesRow);
      nGXsfl_21_idx = ((subFsresultcategories_Islastpage==1)&&(nGXsfl_21_idx+1>subfsresultcategories_fnc_recordsperpage( )) ? 1 : nGXsfl_21_idx+1) ;
      sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_212( ) ;
      /* End function sendrow_212 */
   }

   public void startgridcontrol21( )
   {
      if ( FsresultcategoriesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"FsresultcategoriesContainer"+"DivS\" data-gxgridid=\"21\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subFsresultcategories_Internalname, subFsresultcategories_Internalname, "", "FreeStyleGridMPSearch", 0, "", "", 1, 2, sStyleString, "", "", 0);
         FsresultcategoriesContainer.AddObjectProperty("GridName", "Fsresultcategories");
      }
      else
      {
         FsresultcategoriesContainer.AddObjectProperty("GridName", "Fsresultcategories");
         FsresultcategoriesContainer.AddObjectProperty("Header", subFsresultcategories_Header);
         FsresultcategoriesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGridMPSearch"));
         FsresultcategoriesContainer.AddObjectProperty("Class", "FreeStyleGridMPSearch");
         FsresultcategoriesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("CmpContext", sPrefix);
         FsresultcategoriesContainer.AddObjectProperty("InMasterPage", "false");
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavWwp_searchresults__categoryname_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultcategoriesColumn.AddObjectProperty("Value", lblTxtshowingonly_Caption);
         FsresultcategoriesContainer.AddColumnProperties(FsresultcategoriesColumn);
         FsresultcategoriesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Allowselection, (byte)(1), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol29( )
   {
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"FsresultsContainer"+"DivS\" data-gxgridid=\"29\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subFsresults_Internalname, subFsresults_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         FsresultsContainer.AddObjectProperty("GridName", "Fsresults");
      }
      else
      {
         FsresultsContainer.AddObjectProperty("GridName", "Fsresults");
         FsresultsContainer.AddObjectProperty("Header", subFsresults_Header);
         FsresultsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         FsresultsContainer.AddObjectProperty("Class", "FreeStyleGrid");
         FsresultsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFsresults_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("CmpContext", sPrefix);
         FsresultsContainer.AddObjectProperty("InMasterPage", "false");
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV24Url));
         FsresultsColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUrl_Visible, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV10DisplayType1_Title));
         FsresultsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype1_title_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", lblDisplaytype2_icon_Caption);
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV11DisplayType2_Title));
         FsresultsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype2_title_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV13DisplayType3_Title));
         FsresultsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype3_title_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV12DisplayType3_Subtitle));
         FsresultsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype3_subtitle_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", httpContext.convertURL( AV14DisplayType4_Image));
         FsresultsColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype4_image_Visible, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV15DisplayType4_Title));
         FsresultsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype4_title_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", lblDisplaytype2_icon_Caption);
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV17DisplayType5_Title));
         FsresultsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype5_title_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV16DisplayType5_Subtitle));
         FsresultsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype5_subtitle_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFsresults_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFsresults_Allowselection, (byte)(1), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFsresults_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFsresults_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFsresults_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFsresults_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFsresults_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblClosesearch_Internalname = sPrefix+"CLOSESEARCH" ;
      Btnshowall_Internalname = sPrefix+"BTNSHOWALL" ;
      divShowall_cell_Internalname = sPrefix+"SHOWALL_CELL" ;
      lblTxtnoresults_Internalname = sPrefix+"TXTNORESULTS" ;
      divTxtnoresultscell_Internalname = sPrefix+"TXTNORESULTSCELL" ;
      edtavWwp_searchresults__categoryname_Internalname = sPrefix+"WWP_SEARCHRESULTS__CATEGORYNAME" ;
      edtavUrl_Internalname = sPrefix+"vURL" ;
      tblUnnamedtablecontentfsfsresults_Internalname = sPrefix+"UNNAMEDTABLECONTENTFSFSRESULTS" ;
      edtavDisplaytype1_title_Internalname = sPrefix+"vDISPLAYTYPE1_TITLE" ;
      divUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      divDisplaytype1_cell_Internalname = sPrefix+"DISPLAYTYPE1_CELL" ;
      lblDisplaytype2_icon_Internalname = sPrefix+"DISPLAYTYPE2_ICON" ;
      edtavDisplaytype2_title_Internalname = sPrefix+"vDISPLAYTYPE2_TITLE" ;
      tblUnnamedtable2_Internalname = sPrefix+"UNNAMEDTABLE2" ;
      divDisplaytype2_cell_Internalname = sPrefix+"DISPLAYTYPE2_CELL" ;
      edtavDisplaytype3_title_Internalname = sPrefix+"vDISPLAYTYPE3_TITLE" ;
      edtavDisplaytype3_subtitle_Internalname = sPrefix+"vDISPLAYTYPE3_SUBTITLE" ;
      divUnnamedtable3_Internalname = sPrefix+"UNNAMEDTABLE3" ;
      divDisplaytype3_cell_Internalname = sPrefix+"DISPLAYTYPE3_CELL" ;
      edtavDisplaytype4_image_Internalname = sPrefix+"vDISPLAYTYPE4_IMAGE" ;
      edtavDisplaytype4_title_Internalname = sPrefix+"vDISPLAYTYPE4_TITLE" ;
      divUnnamedtable4_Internalname = sPrefix+"UNNAMEDTABLE4" ;
      divDisplaytype4_cell_Internalname = sPrefix+"DISPLAYTYPE4_CELL" ;
      lblDisplaytype5_icon_Internalname = sPrefix+"DISPLAYTYPE5_ICON" ;
      edtavDisplaytype5_title_Internalname = sPrefix+"vDISPLAYTYPE5_TITLE" ;
      edtavDisplaytype5_subtitle_Internalname = sPrefix+"vDISPLAYTYPE5_SUBTITLE" ;
      divUnnamedtable6_Internalname = sPrefix+"UNNAMEDTABLE6" ;
      tblUnnamedtable5_Internalname = sPrefix+"UNNAMEDTABLE5" ;
      divDisplaytype5_cell_Internalname = sPrefix+"DISPLAYTYPE5_CELL" ;
      divUnnamedtablefsfsresults_Internalname = sPrefix+"UNNAMEDTABLEFSFSRESULTS" ;
      lblTxtshowingonly_Internalname = sPrefix+"TXTSHOWINGONLY" ;
      divShowingonlycell_Internalname = sPrefix+"SHOWINGONLYCELL" ;
      divUnnamedtablefsfsresultcategories_Internalname = sPrefix+"UNNAMEDTABLEFSFSRESULTCATEGORIES" ;
      divFsresultcategories_cell_Internalname = sPrefix+"FSRESULTCATEGORIES_CELL" ;
      divTablesimplesearch_Internalname = sPrefix+"TABLESIMPLESEARCH" ;
      divTablesimplesearchcell_Internalname = sPrefix+"TABLESIMPLESEARCHCELL" ;
      edtavAdvfiltertext_Internalname = sPrefix+"vADVFILTERTEXT" ;
      lblTextblockcombo_advfilterentities_Internalname = sPrefix+"TEXTBLOCKCOMBO_ADVFILTERENTITIES" ;
      Combo_advfilterentities_Internalname = sPrefix+"COMBO_ADVFILTERENTITIES" ;
      divTablesplittedadvfilterentities_Internalname = sPrefix+"TABLESPLITTEDADVFILTERENTITIES" ;
      bttBtnbtnadvsearch_Internalname = sPrefix+"BTNBTNADVSEARCH" ;
      divTableadvancedsearch_Internalname = sPrefix+"TABLEADVANCEDSEARCH" ;
      divTableadvancedsearchcell_Internalname = sPrefix+"TABLEADVANCEDSEARCHCELL" ;
      Btnadvancedsearch_Internalname = sPrefix+"BTNADVANCEDSEARCH" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subFsresults_Internalname = sPrefix+"FSRESULTS" ;
      subFsresultcategories_Internalname = sPrefix+"FSRESULTCATEGORIES" ;
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
      subFsresults_Allowcollapsing = (byte)(0) ;
      lblDisplaytype2_icon_Caption = "<i class='fa fa-home'></i>" ;
      subFsresultcategories_Allowcollapsing = (byte)(0) ;
      lblTxtshowingonly_Caption = "Mostrando los primeros %1 resultados" ;
      lblTxtshowingonly_Caption = "Mostrando los primeros %1 resultados" ;
      divShowingonlycell_Visible = 1 ;
      edtavWwp_searchresults__categoryname_Jsonclick = "" ;
      edtavWwp_searchresults__categoryname_Enabled = 0 ;
      subFsresultcategories_Class = "FreeStyleGridMPSearch" ;
      edtavDisplaytype5_subtitle_Jsonclick = "" ;
      edtavDisplaytype5_subtitle_Enabled = 0 ;
      edtavDisplaytype5_title_Jsonclick = "" ;
      edtavDisplaytype5_title_Enabled = 0 ;
      lblDisplaytype5_icon_Caption = "<i class='fa fa-home'></i>" ;
      divDisplaytype5_cell_Visible = 1 ;
      edtavDisplaytype4_title_Jsonclick = "" ;
      edtavDisplaytype4_title_Enabled = 0 ;
      edtavDisplaytype4_image_gximage = "" ;
      edtavDisplaytype4_image_Visible = 1 ;
      divDisplaytype4_cell_Visible = 1 ;
      edtavDisplaytype3_subtitle_Jsonclick = "" ;
      edtavDisplaytype3_subtitle_Enabled = 0 ;
      edtavDisplaytype3_title_Jsonclick = "" ;
      edtavDisplaytype3_title_Enabled = 0 ;
      divDisplaytype3_cell_Visible = 1 ;
      edtavDisplaytype2_title_Jsonclick = "" ;
      edtavDisplaytype2_title_Enabled = 0 ;
      lblDisplaytype2_icon_Caption = "<i class='fa fa-home'></i>" ;
      divDisplaytype2_cell_Visible = 1 ;
      edtavDisplaytype1_title_Jsonclick = "" ;
      edtavDisplaytype1_title_Enabled = 0 ;
      divDisplaytype1_cell_Visible = 1 ;
      edtavUrl_Jsonclick = "" ;
      subFsresults_Class = "FreeStyleGrid" ;
      subFsresults_Backcolorstyle = (byte)(0) ;
      subFsresultcategories_Backcolorstyle = (byte)(0) ;
      edtavWwp_searchresults__categoryname_Enabled = -1 ;
      Btnadvancedsearch_Class = "IconButtonLink" ;
      Btnadvancedsearch_Caption = "Búsqueda avanzada" ;
      Btnadvancedsearch_Beforeiconclass = "fas fa-filter" ;
      Btnadvancedsearch_Tooltiptext = "" ;
      Combo_advfilterentities_Multiplevaluestype = "Tags" ;
      Combo_advfilterentities_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_advfilterentities_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_advfilterentities_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_advfilterentities_Cls = "ExtendedCombo Attribute" ;
      Combo_advfilterentities_Caption = "" ;
      edtavAdvfiltertext_Jsonclick = "" ;
      edtavAdvfiltertext_Enabled = 1 ;
      divFsresultcategories_cell_Class = "col-xs-12 FSResultCategoriesCell" ;
      lblTxtnoresults_Caption = "No se encontraron resultados para '%1'." ;
      divTxtnoresultscell_Class = "col-xs-12" ;
      Btnshowall_Class = "IconButtonLink IconButtonSearchAll" ;
      Btnshowall_Caption = "Mostrar todos los resultados para '%1'..." ;
      Btnshowall_Beforeiconclass = "fas fa-search" ;
      Btnshowall_Tooltiptext = "" ;
      divShowall_cell_Class = "col-xs-12" ;
      divTablesimplesearchcell_Class = "col-xs-12" ;
      divTableadvancedsearchcell_Class = "col-xs-12 TableAdvancedSearchCell" ;
      edtavUrl_Visible = 1 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'FSRESULTCATEGORIES_nEOF'},{av:'FSRESULTS_nFirstRecordOnPage'},{av:'FSRESULTS_nEOF'},{av:'edtavUrl_Visible',ctrl:'vURL',prop:'Visible'},{av:'sPrefix'},{av:'AV26WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:21,pic:'',hsh:true},{av:'nGXsfl_21_idx',ctrl:'GRID',prop:'GridCurrRow',grid:21},{av:'nRC_GXsfl_21',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:21}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("FSRESULTCATEGORIES.LOAD","{handler:'e160N2',iparms:[{av:'AV26WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:21,pic:'',hsh:true},{av:'nGXsfl_21_idx',ctrl:'GRID',prop:'GridCurrRow',grid:21},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_21',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:21}]");
      setEventMetadata("FSRESULTCATEGORIES.LOAD",",oparms:[{av:'divShowingonlycell_Visible',ctrl:'SHOWINGONLYCELL',prop:'Visible'},{av:'lblTxtshowingonly_Caption',ctrl:'TXTSHOWINGONLY',prop:'Caption'}]}");
      setEventMetadata("FSRESULTS.LOAD","{handler:'e170N3',iparms:[{av:'AV26WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:21,pic:'',hsh:true},{av:'nGXsfl_21_idx',ctrl:'GRID',prop:'GridCurrRow',grid:21},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_21',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:21}]");
      setEventMetadata("FSRESULTS.LOAD",",oparms:[{av:'divDisplaytype1_cell_Visible',ctrl:'DISPLAYTYPE1_CELL',prop:'Visible'},{av:'divDisplaytype2_cell_Visible',ctrl:'DISPLAYTYPE2_CELL',prop:'Visible'},{av:'divDisplaytype3_cell_Visible',ctrl:'DISPLAYTYPE3_CELL',prop:'Visible'},{av:'divDisplaytype4_cell_Visible',ctrl:'DISPLAYTYPE4_CELL',prop:'Visible'},{av:'divDisplaytype5_cell_Visible',ctrl:'DISPLAYTYPE5_CELL',prop:'Visible'},{av:'AV10DisplayType1_Title',fld:'vDISPLAYTYPE1_TITLE',pic:''},{av:'AV11DisplayType2_Title',fld:'vDISPLAYTYPE2_TITLE',pic:''},{av:'lblDisplaytype2_icon_Caption',ctrl:'DISPLAYTYPE2_ICON',prop:'Caption'},{av:'AV13DisplayType3_Title',fld:'vDISPLAYTYPE3_TITLE',pic:''},{av:'AV12DisplayType3_Subtitle',fld:'vDISPLAYTYPE3_SUBTITLE',pic:''},{av:'AV15DisplayType4_Title',fld:'vDISPLAYTYPE4_TITLE',pic:''},{av:'AV14DisplayType4_Image',fld:'vDISPLAYTYPE4_IMAGE',pic:''},{av:'edtavDisplaytype4_image_Visible',ctrl:'vDISPLAYTYPE4_IMAGE',prop:'Visible'},{av:'AV17DisplayType5_Title',fld:'vDISPLAYTYPE5_TITLE',pic:''},{av:'AV16DisplayType5_Subtitle',fld:'vDISPLAYTYPE5_SUBTITLE',pic:''},{av:'lblDisplaytype5_icon_Caption',ctrl:'DISPLAYTYPE5_ICON',prop:'Caption'},{av:'AV24Url',fld:'vURL',pic:''}]}");
      setEventMetadata("'DOCLOSESEARCH'","{handler:'e110N2',iparms:[]");
      setEventMetadata("'DOCLOSESEARCH'",",oparms:[]}");
      setEventMetadata("'DOSHOWALL'","{handler:'e120N2',iparms:[{av:'AV22SearchText',fld:'vSEARCHTEXT',pic:''}]");
      setEventMetadata("'DOSHOWALL'",",oparms:[]}");
      setEventMetadata("'DOBTNADVSEARCH'","{handler:'e130N2',iparms:[{av:'AV8AdvFilterText',fld:'vADVFILTERTEXT',pic:''},{av:'AV5AdvFilterEntities',fld:'vADVFILTERENTITIES',pic:''}]");
      setEventMetadata("'DOBTNADVSEARCH'",",oparms:[]}");
      setEventMetadata("UNNAMEDTABLEFSFSRESULTS.CLICK","{handler:'e140N2',iparms:[{av:'AV26WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:21,pic:'',hsh:true},{av:'nGXsfl_21_idx',ctrl:'GRID',prop:'GridCurrRow',grid:21},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_21',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:21},{av:'AV24Url',fld:'vURL',pic:''}]");
      setEventMetadata("UNNAMEDTABLEFSFSRESULTS.CLICK",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv2',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Displaytype5_subtitle',iparms:[]");
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
      wcpOAV22SearchText = "" ;
      Combo_advfilterentities_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV22SearchText = "" ;
      AV26WWP_SearchResults = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Gregory", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV9DDO_TitleSettingsIcons = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV6AdvFilterEntities_Data = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV5AdvFilterEntities = new GXSimpleCollection<String>(String.class, "internal", "");
      GX_FocusControl = "" ;
      lblClosesearch_Jsonclick = "" ;
      ucBtnshowall = new com.genexus.webpanels.GXUserControl();
      lblTxtnoresults_Jsonclick = "" ;
      FsresultcategoriesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      TempTags = "" ;
      AV8AdvFilterText = "" ;
      lblTextblockcombo_advfilterentities_Jsonclick = "" ;
      ucCombo_advfilterentities = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      bttBtnbtnadvsearch_Jsonclick = "" ;
      ucBtnadvancedsearch = new com.genexus.webpanels.GXUserControl();
      FsresultsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXCCtl = "" ;
      AV24Url = "" ;
      AV10DisplayType1_Title = "" ;
      AV11DisplayType2_Title = "" ;
      AV13DisplayType3_Title = "" ;
      AV12DisplayType3_Subtitle = "" ;
      AV14DisplayType4_Image = "" ;
      AV31Displaytype4_image_GXI = "" ;
      AV15DisplayType4_Title = "" ;
      AV17DisplayType5_Title = "" ;
      AV16DisplayType5_Subtitle = "" ;
      AV21RecentSearchResultsJson = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem3 = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Gregory", remoteHandle);
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7 = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      FsresultcategoriesRow = new com.genexus.webpanels.GXWebRow();
      AV19EntityDescriptions = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar4 = new GXSimpleCollection[1] ;
      AV25WWP_SearchResultAux = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Gregory", remoteHandle);
      AV18EntityDescription = "" ;
      AV7AdvFilterEntities_DataItem = new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      Combo_advfilterentities_Selectedvalue_set = "" ;
      FsresultsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV22SearchText = "" ;
      subFsresults_Linesclass = "" ;
      ROClassString = "" ;
      lblDisplaytype2_icon_Jsonclick = "" ;
      sImgUrl = "" ;
      lblDisplaytype5_icon_Jsonclick = "" ;
      subFsresultcategories_Linesclass = "" ;
      lblTxtshowingonly_Jsonclick = "" ;
      subFsresultcategories_Header = "" ;
      FsresultcategoriesColumn = new com.genexus.webpanels.GXWebColumn();
      subFsresults_Header = "" ;
      FsresultsColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
      edtavWwp_searchresults__categoryname_Enabled = 0 ;
      edtavDisplaytype1_title_Enabled = 0 ;
      edtavDisplaytype2_title_Enabled = 0 ;
      edtavDisplaytype3_title_Enabled = 0 ;
      edtavDisplaytype3_subtitle_Enabled = 0 ;
      edtavDisplaytype4_title_Enabled = 0 ;
      edtavDisplaytype5_title_Enabled = 0 ;
      edtavDisplaytype5_subtitle_Enabled = 0 ;
      initializeGenerics();
   }

   @SuppressWarnings("unchecked")
   private void initializeGenerics( )
   {
      GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5 = new GXBaseCollection[1] ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subFsresultcategories_Backcolorstyle ;
   private byte subFsresults_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subFsresults_Backstyle ;
   private byte subFsresultcategories_Backstyle ;
   private byte subFsresultcategories_Allowselection ;
   private byte subFsresultcategories_Allowhovering ;
   private byte subFsresultcategories_Allowcollapsing ;
   private byte subFsresultcategories_Collapsed ;
   private byte subFsresults_Allowselection ;
   private byte subFsresults_Allowhovering ;
   private byte subFsresults_Allowcollapsing ;
   private byte subFsresults_Collapsed ;
   private byte FSRESULTCATEGORIES_nEOF ;
   private byte FSRESULTS_nEOF ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short AV20MinimumCharsToSearch ;
   private int nRC_GXsfl_29 ;
   private int nGXsfl_29_idx=1 ;
   private int nRC_GXsfl_21 ;
   private int edtavUrl_Visible ;
   private int nGXsfl_21_idx=1 ;
   private int AV28GXV1 ;
   private int edtavAdvfiltertext_Enabled ;
   private int AV30GXV3 ;
   private int subFsresults_Recordcount ;
   private int subFsresultcategories_Islastpage ;
   private int subFsresults_Islastpage ;
   private int edtavWwp_searchresults__categoryname_Enabled ;
   private int edtavDisplaytype1_title_Enabled ;
   private int edtavDisplaytype2_title_Enabled ;
   private int edtavDisplaytype3_title_Enabled ;
   private int edtavDisplaytype3_subtitle_Enabled ;
   private int edtavDisplaytype4_title_Enabled ;
   private int edtavDisplaytype5_title_Enabled ;
   private int edtavDisplaytype5_subtitle_Enabled ;
   private int nGXsfl_21_fel_idx=1 ;
   private int divShowingonlycell_Visible ;
   private int AV32GXV4 ;
   private int divDisplaytype1_cell_Visible ;
   private int divDisplaytype2_cell_Visible ;
   private int divDisplaytype3_cell_Visible ;
   private int divDisplaytype4_cell_Visible ;
   private int divDisplaytype5_cell_Visible ;
   private int edtavDisplaytype4_image_Visible ;
   private int idxLst ;
   private int subFsresults_Backcolor ;
   private int subFsresults_Allbackcolor ;
   private int subFsresultcategories_Backcolor ;
   private int subFsresultcategories_Allbackcolor ;
   private int subFsresultcategories_Selectedindex ;
   private int subFsresultcategories_Selectioncolor ;
   private int subFsresultcategories_Hoveringcolor ;
   private int subFsresults_Selectedindex ;
   private int subFsresults_Selectioncolor ;
   private int subFsresults_Hoveringcolor ;
   private long FSRESULTS_nCurrentRecord ;
   private long FSRESULTCATEGORIES_nCurrentRecord ;
   private long FSRESULTS_nFirstRecordOnPage ;
   private long FSRESULTCATEGORIES_nFirstRecordOnPage ;
   private String divTableadvancedsearchcell_Class ;
   private String divTablesimplesearchcell_Class ;
   private String Combo_advfilterentities_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_29_idx="0001" ;
   private String edtavUrl_Internalname ;
   private String sGXsfl_21_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String lblClosesearch_Internalname ;
   private String lblClosesearch_Jsonclick ;
   private String divShowall_cell_Internalname ;
   private String divShowall_cell_Class ;
   private String Btnshowall_Tooltiptext ;
   private String Btnshowall_Beforeiconclass ;
   private String Btnshowall_Caption ;
   private String Btnshowall_Class ;
   private String Btnshowall_Internalname ;
   private String divTxtnoresultscell_Internalname ;
   private String divTxtnoresultscell_Class ;
   private String lblTxtnoresults_Internalname ;
   private String lblTxtnoresults_Caption ;
   private String lblTxtnoresults_Jsonclick ;
   private String divTablesimplesearchcell_Internalname ;
   private String divTablesimplesearch_Internalname ;
   private String divFsresultcategories_cell_Internalname ;
   private String divFsresultcategories_cell_Class ;
   private String sStyleString ;
   private String subFsresultcategories_Internalname ;
   private String divTableadvancedsearchcell_Internalname ;
   private String divTableadvancedsearch_Internalname ;
   private String edtavAdvfiltertext_Internalname ;
   private String TempTags ;
   private String edtavAdvfiltertext_Jsonclick ;
   private String divTablesplittedadvfilterentities_Internalname ;
   private String lblTextblockcombo_advfilterentities_Internalname ;
   private String lblTextblockcombo_advfilterentities_Jsonclick ;
   private String Combo_advfilterentities_Caption ;
   private String Combo_advfilterentities_Cls ;
   private String Combo_advfilterentities_Multiplevaluestype ;
   private String Combo_advfilterentities_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnbtnadvsearch_Internalname ;
   private String bttBtnbtnadvsearch_Jsonclick ;
   private String Btnadvancedsearch_Tooltiptext ;
   private String Btnadvancedsearch_Beforeiconclass ;
   private String Btnadvancedsearch_Caption ;
   private String Btnadvancedsearch_Class ;
   private String Btnadvancedsearch_Internalname ;
   private String subFsresults_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GXCCtl ;
   private String edtavDisplaytype1_title_Internalname ;
   private String edtavDisplaytype2_title_Internalname ;
   private String edtavDisplaytype3_title_Internalname ;
   private String edtavDisplaytype3_subtitle_Internalname ;
   private String edtavDisplaytype4_image_Internalname ;
   private String edtavDisplaytype4_title_Internalname ;
   private String edtavDisplaytype5_title_Internalname ;
   private String edtavDisplaytype5_subtitle_Internalname ;
   private String edtavWwp_searchresults__categoryname_Internalname ;
   private String sGXsfl_21_fel_idx="0001" ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String divShowingonlycell_Internalname ;
   private String lblTxtshowingonly_Caption ;
   private String Combo_advfilterentities_Selectedvalue_set ;
   private String divDisplaytype1_cell_Internalname ;
   private String divDisplaytype2_cell_Internalname ;
   private String divDisplaytype3_cell_Internalname ;
   private String divDisplaytype4_cell_Internalname ;
   private String divDisplaytype5_cell_Internalname ;
   private String lblDisplaytype2_icon_Caption ;
   private String lblDisplaytype5_icon_Caption ;
   private String sCtrlAV22SearchText ;
   private String lblDisplaytype2_icon_Internalname ;
   private String lblDisplaytype5_icon_Internalname ;
   private String sGXsfl_29_fel_idx="0001" ;
   private String subFsresults_Class ;
   private String subFsresults_Linesclass ;
   private String divUnnamedtablefsfsresults_Internalname ;
   private String tblUnnamedtablecontentfsfsresults_Internalname ;
   private String ROClassString ;
   private String edtavUrl_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String edtavDisplaytype1_title_Jsonclick ;
   private String tblUnnamedtable2_Internalname ;
   private String lblDisplaytype2_icon_Jsonclick ;
   private String edtavDisplaytype2_title_Jsonclick ;
   private String divUnnamedtable3_Internalname ;
   private String edtavDisplaytype3_title_Jsonclick ;
   private String edtavDisplaytype3_subtitle_Jsonclick ;
   private String divUnnamedtable4_Internalname ;
   private String edtavDisplaytype4_image_gximage ;
   private String sImgUrl ;
   private String edtavDisplaytype4_title_Jsonclick ;
   private String tblUnnamedtable5_Internalname ;
   private String lblDisplaytype5_icon_Jsonclick ;
   private String divUnnamedtable6_Internalname ;
   private String edtavDisplaytype5_title_Jsonclick ;
   private String edtavDisplaytype5_subtitle_Jsonclick ;
   private String lblTxtshowingonly_Internalname ;
   private String subFsresultcategories_Class ;
   private String subFsresultcategories_Linesclass ;
   private String divUnnamedtablefsfsresultcategories_Internalname ;
   private String edtavWwp_searchresults__categoryname_Jsonclick ;
   private String lblTxtshowingonly_Jsonclick ;
   private String subFsresultcategories_Header ;
   private String subFsresults_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_29_Refreshing=false ;
   private boolean wbLoad ;
   private boolean Combo_advfilterentities_Allowmultipleselection ;
   private boolean Combo_advfilterentities_Includeonlyselectedoption ;
   private boolean Combo_advfilterentities_Emptyitem ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_21_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV23ShowingRecents ;
   private boolean gx_BV21 ;
   private boolean AV14DisplayType4_Image_IsBlob ;
   private String wcpOAV22SearchText ;
   private String AV22SearchText ;
   private String AV8AdvFilterText ;
   private String AV24Url ;
   private String AV10DisplayType1_Title ;
   private String AV11DisplayType2_Title ;
   private String AV13DisplayType3_Title ;
   private String AV12DisplayType3_Subtitle ;
   private String AV31Displaytype4_image_GXI ;
   private String AV15DisplayType4_Title ;
   private String AV17DisplayType5_Title ;
   private String AV16DisplayType5_Subtitle ;
   private String AV21RecentSearchResultsJson ;
   private String AV18EntityDescription ;
   private String AV14DisplayType4_Image ;
   private com.genexus.webpanels.GXWebGrid FsresultcategoriesContainer ;
   private com.genexus.webpanels.GXWebGrid FsresultsContainer ;
   private com.genexus.webpanels.GXWebRow FsresultcategoriesRow ;
   private com.genexus.webpanels.GXWebRow FsresultsRow ;
   private com.genexus.webpanels.GXWebColumn FsresultcategoriesColumn ;
   private com.genexus.webpanels.GXWebColumn FsresultsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucBtnshowall ;
   private com.genexus.webpanels.GXUserControl ucCombo_advfilterentities ;
   private com.genexus.webpanels.GXUserControl ucBtnadvancedsearch ;
   private GXSimpleCollection<String> AV5AdvFilterEntities ;
   private GXSimpleCollection<String> AV19EntityDescriptions ;
   private GXSimpleCollection<String> GXv_objcol_svchar4[] ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV6AdvFilterEntities_Data ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV26WWP_SearchResults ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem3 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV25WWP_SearchResultAux ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5[] ;
   private com.wwpbaseobjects.SdtDVB_SDTComboData_Item AV7AdvFilterEntities_DataItem ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV9DDO_TitleSettingsIcons ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7[] ;
}

