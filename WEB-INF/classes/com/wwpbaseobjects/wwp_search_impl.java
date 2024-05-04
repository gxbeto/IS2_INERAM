package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_search_impl extends GXDataArea
{
   public wwp_search_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_search_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_search_impl.class ));
   }

   public wwp_search_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "DeafultSearchText") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "DeafultSearchText") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "DeafultSearchText") ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV10DeafultSearchText = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10DeafultSearchText", AV10DeafultSearchText);
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEAFULTSEARCHTEXT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10DeafultSearchText, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV12DefaultIsAdvancedSearch = GXutil.strtobool( httpContext.GetPar( "DefaultIsAdvancedSearch")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12DefaultIsAdvancedSearch", AV12DefaultIsAdvancedSearch);
               com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTISADVANCEDSEARCH", getSecureSignedToken( "", AV12DefaultIsAdvancedSearch));
               AV11DefaultAdvFilterEntitiesJson = httpContext.GetPar( "DefaultAdvFilterEntitiesJson") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11DefaultAdvFilterEntitiesJson", AV11DefaultAdvFilterEntitiesJson);
               com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTADVFILTERENTITIESJSON", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11DefaultAdvFilterEntitiesJson, ""))));
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrfsresults_newrow_invoke( )
   {
      nRC_GXsfl_56 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_56"))) ;
      nGXsfl_56_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_56_idx"))) ;
      sGXsfl_56_idx = httpContext.GetPar( "sGXsfl_56_idx") ;
      edtavUrl_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Visible), 5, 0), !bGXsfl_56_Refreshing);
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
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Visible), 5, 0), !bGXsfl_56_Refreshing);
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV28WWP_SearchResults);
      AV10DeafultSearchText = httpContext.GetPar( "DeafultSearchText") ;
      AV12DefaultIsAdvancedSearch = GXutil.strtobool( httpContext.GetPar( "DefaultIsAdvancedSearch")) ;
      AV11DefaultAdvFilterEntitiesJson = httpContext.GetPar( "DefaultAdvFilterEntitiesJson") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfsresults_refresh( AV28WWP_SearchResults, AV10DeafultSearchText, AV12DefaultIsAdvancedSearch, AV11DefaultAdvFilterEntitiesJson) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFsresults_refresh_invoke */
   }

   public void gxnrfsresultcategories_newrow_invoke( )
   {
      nRC_GXsfl_48 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_48"))) ;
      nGXsfl_48_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_48_idx"))) ;
      sGXsfl_48_idx = httpContext.GetPar( "sGXsfl_48_idx") ;
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
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV28WWP_SearchResults);
      AV10DeafultSearchText = httpContext.GetPar( "DeafultSearchText") ;
      AV12DefaultIsAdvancedSearch = GXutil.strtobool( httpContext.GetPar( "DefaultIsAdvancedSearch")) ;
      AV11DefaultAdvFilterEntitiesJson = httpContext.GetPar( "DefaultAdvFilterEntitiesJson") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfsresultcategories_refresh( AV28WWP_SearchResults, AV10DeafultSearchText, AV12DefaultIsAdvancedSearch, AV11DefaultAdvFilterEntitiesJson) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFsresultcategories_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.wwpbaseobjects.workwithplusmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
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
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      pa0O2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0O2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      com.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      httpContext.CloseStyles();
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      if ( GXutil.strcmp(httpContext.getLanguageProperty( "rtl"), "true") == 0 )
      {
         httpContext.writeText( " dir=\"rtl\" ") ;
      }
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.wwp_search", new String[] {GXutil.URLEncode(GXutil.rtrim(AV10DeafultSearchText)),GXutil.URLEncode(GXutil.booltostr(AV12DefaultIsAdvancedSearch)),GXutil.URLEncode(GXutil.rtrim(AV11DefaultAdvFilterEntitiesJson))}, new String[] {"DeafultSearchText","DefaultIsAdvancedSearch","DefaultAdvFilterEntitiesJson"}) +"\">") ;
      com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "vDEAFULTSEARCHTEXT", AV10DeafultSearchText);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEAFULTSEARCHTEXT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10DeafultSearchText, ""))));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, "vDEFAULTISADVANCEDSEARCH", AV12DefaultIsAdvancedSearch);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTISADVANCEDSEARCH", getSecureSignedToken( "", AV12DefaultIsAdvancedSearch));
      com.GxWebStd.gx_hidden_field( httpContext, "vDEFAULTADVFILTERENTITIESJSON", AV11DefaultAdvFilterEntitiesJson);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTADVFILTERENTITIESJSON", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11DefaultAdvFilterEntitiesJson, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Wwp_searchresults", AV28WWP_SearchResults);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Wwp_searchresults", AV28WWP_SearchResults);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_48", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_48, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV9DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV9DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vADVFILTERENTITIES_DATA", AV6AdvFilterEntities_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vADVFILTERENTITIES_DATA", AV6AdvFilterEntities_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vWWP_SEARCHRESULTS", AV28WWP_SearchResults);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vWWP_SEARCHRESULTS", AV28WWP_SearchResults);
      }
      com.GxWebStd.gx_boolean_hidden_field( httpContext, "vISADVANCEDSEARCH", AV23IsAdvancedSearch);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vADVFILTERENTITIES", AV5AdvFilterEntities);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vADVFILTERENTITIES", AV5AdvFilterEntities);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "vDEAFULTSEARCHTEXT", AV10DeafultSearchText);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEAFULTSEARCHTEXT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10DeafultSearchText, ""))));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, "vDEFAULTISADVANCEDSEARCH", AV12DefaultIsAdvancedSearch);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTISADVANCEDSEARCH", getSecureSignedToken( "", AV12DefaultIsAdvancedSearch));
      com.GxWebStd.gx_hidden_field( httpContext, "vDEFAULTADVFILTERENTITIESJSON", AV11DefaultAdvFilterEntitiesJson);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTADVFILTERENTITIESJSON", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11DefaultAdvFilterEntitiesJson, ""))));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_ADVFILTERENTITIES_Selectedvalue_get", GXutil.rtrim( Combo_advfilterentities_Selectedvalue_get));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
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
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we0O2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0O2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.wwpbaseobjects.wwp_search", new String[] {GXutil.URLEncode(GXutil.rtrim(AV10DeafultSearchText)),GXutil.URLEncode(GXutil.booltostr(AV12DefaultIsAdvancedSearch)),GXutil.URLEncode(GXutil.rtrim(AV11DefaultAdvFilterEntitiesJson))}, new String[] {"DeafultSearchText","DefaultIsAdvancedSearch","DefaultAdvFilterEntitiesJson"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.WWP_Search" ;
   }

   public String getPgmdesc( )
   {
      return "Search results" ;
   }

   public void wb0O0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         com.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
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
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell WWFiltersCell SearchFiltersCell", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "start", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablesimplesearchcell_Internalname, divTablesimplesearchcell_Visible, 0, "px", 0, "px", "", "start", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtable7_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-9", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtable9_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-md-8 col-lg-6 DataContentCell", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtavSearchtext_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, edtavSearchtext_Internalname, "Buscar", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'" + sGXsfl_48_idx + "',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavSearchtext_Internalname, AV25SearchText, GXutil.rtrim( localUtil.format( AV25SearchText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,19);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSearchtext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSearchtext_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/WWP_Search.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 48, 2, 0)+","+"null"+");", "Buscar", bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/WWP_Search.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3", "end", "top", "", "", "div");
         /* User Defined Control */
         ucBtnadvancedsearch.setProperty("TooltipText", Btnadvancedsearch_Tooltiptext);
         ucBtnadvancedsearch.setProperty("BeforeIconClass", Btnadvancedsearch_Beforeiconclass);
         ucBtnadvancedsearch.setProperty("Caption", Btnadvancedsearch_Caption);
         ucBtnadvancedsearch.setProperty("Class", Btnadvancedsearch_Class);
         ucBtnadvancedsearch.render(context, "wwp_iconbutton", Btnadvancedsearch_Internalname, "BTNADVANCEDSEARCHContainer");
         com.GxWebStd.gx_div_end( httpContext, "end", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTableadvancedsearchcell_Internalname, divTableadvancedsearchcell_Visible, 0, "px", 0, "px", "", "start", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTableadvancedsearch_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-9", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtable8_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-md-8 col-lg-6 DataContentCell", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtavAdvfiltertext_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, edtavAdvfiltertext_Internalname, "Buscar", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'" + sGXsfl_48_idx + "',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavAdvfiltertext_Internalname, AV8AdvFilterText, GXutil.rtrim( localUtil.format( AV8AdvFilterText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAdvfiltertext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavAdvfiltertext_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/WWP_Search.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-md-8 col-lg-6 DataContentCell ExtendedComboCell", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablesplittedadvfilterentities_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_advfilterentities_Internalname, "Buscar en", "", "", lblTextblockcombo_advfilterentities_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_Search.htm");
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
         ucCombo_advfilterentities.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_advfilterentities_Internalname, "COMBO_ADVFILTERENTITIESContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnadvsearch_Internalname, "gx.evt.setGridEvt("+GXutil.str( 48, 2, 0)+","+"null"+");", "Buscar", bttBtnbtnadvsearch_Jsonclick, 5, "Buscar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNADVSEARCH\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/WWP_Search.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3", "end", "top", "", "", "div");
         /* User Defined Control */
         ucBtnbasicsearch.setProperty("TooltipText", Btnbasicsearch_Tooltiptext);
         ucBtnbasicsearch.setProperty("BeforeIconClass", Btnbasicsearch_Beforeiconclass);
         ucBtnbasicsearch.setProperty("Caption", Btnbasicsearch_Caption);
         ucBtnbasicsearch.setProperty("Class", Btnbasicsearch_Class);
         ucBtnbasicsearch.render(context, "wwp_iconbutton", Btnbasicsearch_Internalname, "BTNBASICSEARCHContainer");
         com.GxWebStd.gx_div_end( httpContext, "end", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divFsresultcategoriescell_Internalname, divFsresultcategoriescell_Visible, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /*  Grid Control  */
         FsresultcategoriesContainer.SetIsFreestyle(true);
         FsresultcategoriesContainer.SetWrapped(nGXWrapped);
         startgridcontrol48( ) ;
      }
      if ( wbEnd == 48 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_48 = (int)(nGXsfl_48_idx-1) ;
         if ( FsresultcategoriesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV30GXV1 = nGXsfl_48_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"FsresultcategoriesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Fsresultcategories", FsresultcategoriesContainer, subFsresultcategories_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "FsresultcategoriesContainerData", FsresultcategoriesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "FsresultcategoriesContainerData"+"V", FsresultcategoriesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"FsresultcategoriesContainerData"+"V"+"\" value='"+FsresultcategoriesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTxtnoresultscell_Internalname, divTxtnoresultscell_Visible, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblTxtnoresults_Internalname, lblTxtnoresults_Caption, "", "", lblTxtnoresults_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockShowingOnly", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_Search.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 48 )
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
               AV30GXV1 = nGXsfl_48_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"FsresultcategoriesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Fsresultcategories", FsresultcategoriesContainer, subFsresultcategories_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "FsresultcategoriesContainerData", FsresultcategoriesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "FsresultcategoriesContainerData"+"V", FsresultcategoriesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"FsresultcategoriesContainerData"+"V"+"\" value='"+FsresultcategoriesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 56 )
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
               AV32GXV3 = nGXsfl_56_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"FsresultsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Fsresults", FsresultsContainer, subFsresults_Internalname);
               if ( ! isAjaxCallMode( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "FsresultsContainerData", FsresultsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "FsresultsContainerData"+"V", FsresultsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"FsresultsContainerData"+"V"+"\" value='"+FsresultsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start0O2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 18_0_8-180599", (short)(0)) ;
         }
      }
      Form.getMeta().addItem("description", "Search results", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0O0( ) ;
   }

   public void ws0O2( )
   {
      start0O2( ) ;
      evt0O2( ) ;
   }

   public void evt0O2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNADVSEARCH'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoBtnAdvSearch' */
                           e110O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                                 /* Execute user event: Enter */
                                 e120O2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "TABLEFSCARD.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e130O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "FSRESULTCATEGORIES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 14), "FSRESULTS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 17), "TABLEFSCARD.CLICK") == 0 ) )
                        {
                           nGXsfl_48_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_482( ) ;
                           AV30GXV1 = nGXsfl_48_idx ;
                           if ( ( AV28WWP_SearchResults.size() >= AV30GXV1 ) && ( AV30GXV1 > 0 ) )
                           {
                              AV28WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)) );
                           }
                           GXCCtl = "subFsresults_Recordcount_" + sGXsfl_48_idx ;
                           subFsresults_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e140O2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "FSRESULTCATEGORIES.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e150O2 ();
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                              sEvtType = GXutil.right( sEvt, 4) ;
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                              if ( ( GXutil.strcmp(GXutil.left( sEvt, 14), "FSRESULTS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 17), "TABLEFSCARD.CLICK") == 0 ) )
                              {
                                 nGXsfl_56_idx = (int)(GXutil.lval( sEvtType)) ;
                                 sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") + sGXsfl_48_idx ;
                                 subsflControlProps_563( ) ;
                                 AV26Url = httpContext.cgiGet( edtavUrl_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri("", false, edtavUrl_Internalname, AV26Url);
                                 AV13DisplayType1_Title = httpContext.cgiGet( edtavDisplaytype1_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype1_title_Internalname, AV13DisplayType1_Title);
                                 AV14DisplayType2_Title = httpContext.cgiGet( edtavDisplaytype2_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype2_title_Internalname, AV14DisplayType2_Title);
                                 AV16DisplayType3_Title = httpContext.cgiGet( edtavDisplaytype3_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype3_title_Internalname, AV16DisplayType3_Title);
                                 AV15DisplayType3_Subtitle = httpContext.cgiGet( edtavDisplaytype3_subtitle_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype3_subtitle_Internalname, AV15DisplayType3_Subtitle);
                                 AV17DisplayType4_Image = httpContext.cgiGet( edtavDisplaytype4_image_Internalname) ;
                                 httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype4_image_Internalname, "Bitmap", ((GXutil.strcmp("", AV17DisplayType4_Image)==0) ? AV33Displaytype4_image_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV17DisplayType4_Image))), !bGXsfl_56_Refreshing);
                                 httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype4_image_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV17DisplayType4_Image), true);
                                 AV18DisplayType4_Title = httpContext.cgiGet( edtavDisplaytype4_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype4_title_Internalname, AV18DisplayType4_Title);
                                 AV20DisplayType5_Title = httpContext.cgiGet( edtavDisplaytype5_title_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype5_title_Internalname, AV20DisplayType5_Title);
                                 AV19DisplayType5_Subtitle = httpContext.cgiGet( edtavDisplaytype5_subtitle_Internalname) ;
                                 httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype5_subtitle_Internalname, AV19DisplayType5_Subtitle);
                                 sEvtType = GXutil.right( sEvt, 1) ;
                                 if ( GXutil.strcmp(sEvtType, ".") == 0 )
                                 {
                                    sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                    if ( GXutil.strcmp(sEvt, "FSRESULTS.LOAD") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                       e160O3 ();
                                    }
                                    else if ( GXutil.strcmp(sEvt, "TABLEFSCARD.CLICK") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                       e130O2 ();
                                    }
                                    else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
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

   public void we0O2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa0O2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavSearchtext_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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
      subsflControlProps_482( ) ;
      while ( nGXsfl_48_idx <= nRC_GXsfl_48 )
      {
         sendrow_482( ) ;
         nGXsfl_48_idx = ((subFsresultcategories_Islastpage==1)&&(nGXsfl_48_idx+1>subfsresultcategories_fnc_recordsperpage( )) ? 1 : nGXsfl_48_idx+1) ;
         sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_482( ) ;
      }
      addString( httpContext.getJSONContainerResponse( FsresultcategoriesContainer)) ;
      /* End function gxnrFsresultcategories_newrow */
   }

   public void gxnrfsresults_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_563( ) ;
      while ( nGXsfl_56_idx <= nRC_GXsfl_56 )
      {
         sendrow_563( ) ;
         nGXsfl_56_idx = ((subFsresults_Islastpage==1)&&(nGXsfl_56_idx+1>subfsresults_fnc_recordsperpage( )) ? 1 : nGXsfl_56_idx+1) ;
         sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") + sGXsfl_48_idx ;
         subsflControlProps_563( ) ;
      }
      addString( httpContext.getJSONContainerResponse( FsresultsContainer)) ;
      /* End function gxnrFsresults_newrow */
   }

   public void gxgrfsresults_refresh( GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV28WWP_SearchResults ,
                                      String AV10DeafultSearchText ,
                                      boolean AV12DefaultIsAdvancedSearch ,
                                      String AV11DefaultAdvFilterEntitiesJson )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      FSRESULTS_nCurrentRecord = 0 ;
      rf0O3( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrFsresults_refresh */
   }

   public void gxgrfsresultcategories_refresh( GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV28WWP_SearchResults ,
                                               String AV10DeafultSearchText ,
                                               boolean AV12DefaultIsAdvancedSearch ,
                                               String AV11DefaultAdvFilterEntitiesJson )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      FSRESULTCATEGORIES_nCurrentRecord = 0 ;
      rf0O2( ) ;
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
      rf0O2( ) ;
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
      httpContext.ajax_rsp_assign_prop("", false, edtavWwp_searchresults__categoryname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwp_searchresults__categoryname_Enabled), 5, 0), !bGXsfl_48_Refreshing);
      edtavDisplaytype1_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype1_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype1_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype2_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype2_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype2_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype3_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype3_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype3_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype3_subtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype3_subtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype3_subtitle_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype4_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype4_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype4_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype5_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype5_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype5_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype5_subtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype5_subtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype5_subtitle_Enabled), 5, 0), !bGXsfl_56_Refreshing);
   }

   public void rf0O2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         FsresultcategoriesContainer.ClearRows();
      }
      wbStart = (short)(48) ;
      nGXsfl_48_idx = 1 ;
      sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_482( ) ;
      bGXsfl_48_Refreshing = true ;
      FsresultcategoriesContainer.AddObjectProperty("GridName", "Fsresultcategories");
      FsresultcategoriesContainer.AddObjectProperty("CmpContext", "");
      FsresultcategoriesContainer.AddObjectProperty("InMasterPage", "false");
      FsresultcategoriesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      FsresultcategoriesContainer.AddObjectProperty("Class", "FreeStyleGrid");
      FsresultcategoriesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      FsresultcategoriesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      FsresultcategoriesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      FsresultcategoriesContainer.setPageSize( subfsresultcategories_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_482( ) ;
         e150O2 ();
         wbEnd = (short)(48) ;
         wb0O0( ) ;
      }
      bGXsfl_48_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0O2( )
   {
   }

   public void rf0O3( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         FsresultsContainer.ClearRows();
      }
      wbStart = (short)(56) ;
      nGXsfl_56_idx = 1 ;
      sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") + sGXsfl_48_idx ;
      subsflControlProps_563( ) ;
      bGXsfl_56_Refreshing = true ;
      FsresultsContainer.AddObjectProperty("GridName", "Fsresults");
      FsresultsContainer.AddObjectProperty("CmpContext", "");
      FsresultsContainer.AddObjectProperty("InMasterPage", "false");
      FsresultsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      FsresultsContainer.AddObjectProperty("Class", "FreeStyleGrid");
      FsresultsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      FsresultsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      FsresultsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFsresults_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      FsresultsContainer.setPageSize( subfsresults_fnc_recordsperpage( ) );
      GXCCtl = "FSRESULTS_nFirstRecordOnPage_" + sGXsfl_48_idx ;
      if ( subFsresults_Islastpage != 0 )
      {
         FSRESULTS_nFirstRecordOnPage = (long)(subfsresults_fnc_recordcount( )-subfsresults_fnc_recordsperpage( )) ;
         com.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( FSRESULTS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         FsresultsContainer.AddObjectProperty("FSRESULTS_nFirstRecordOnPage", FSRESULTS_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_563( ) ;
         e160O3 ();
         wbEnd = (short)(56) ;
         wb0O0( ) ;
      }
      bGXsfl_56_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0O3( )
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
      httpContext.ajax_rsp_assign_prop("", false, edtavWwp_searchresults__categoryname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwp_searchresults__categoryname_Enabled), 5, 0), !bGXsfl_48_Refreshing);
      edtavDisplaytype1_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype1_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype1_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype2_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype2_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype2_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype3_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype3_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype3_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype3_subtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype3_subtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype3_subtitle_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype4_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype4_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype4_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype5_title_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype5_title_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype5_title_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDisplaytype5_subtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplaytype5_subtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplaytype5_subtitle_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup0O0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e140O2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.readJsonSdtValue(httpContext.cgiGet( "Wwp_searchresults"), AV28WWP_SearchResults);
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV9DDO_TitleSettingsIcons);
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vADVFILTERENTITIES_DATA"), AV6AdvFilterEntities_Data);
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vWWP_SEARCHRESULTS"), AV28WWP_SearchResults);
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vADVFILTERENTITIES"), AV5AdvFilterEntities);
         /* Read saved values. */
         nRC_GXsfl_48 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_48"), ",", ".")) ;
         AV23IsAdvancedSearch = GXutil.strtobool( httpContext.cgiGet( "vISADVANCEDSEARCH")) ;
         nRC_GXsfl_48 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_48"), ",", ".")) ;
         nGXsfl_48_fel_idx = 0 ;
         while ( nGXsfl_48_fel_idx < nRC_GXsfl_48 )
         {
            nGXsfl_48_fel_idx = ((subFsresultcategories_Islastpage==1)&&(nGXsfl_48_fel_idx+1>subfsresultcategories_fnc_recordsperpage( )) ? 1 : nGXsfl_48_fel_idx+1) ;
            sGXsfl_48_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_482( ) ;
            AV30GXV1 = nGXsfl_48_fel_idx ;
            if ( ( AV28WWP_SearchResults.size() >= AV30GXV1 ) && ( AV30GXV1 > 0 ) )
            {
               AV28WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)) );
            }
            GXCCtl = "subFsresults_Recordcount_" + sGXsfl_48_fel_idx ;
            subFsresults_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
         }
         if ( nGXsfl_48_fel_idx == 0 )
         {
            nGXsfl_48_idx = 1 ;
            sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_482( ) ;
         }
         nGXsfl_48_fel_idx = 1 ;
         /* Read variables values. */
         AV25SearchText = httpContext.cgiGet( edtavSearchtext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25SearchText", AV25SearchText);
         AV8AdvFilterText = httpContext.cgiGet( edtavAdvfiltertext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8AdvFilterText", AV8AdvFilterText);
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
      e140O2 ();
      if (returnInSub) return;
   }

   public void e140O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV25SearchText = AV10DeafultSearchText ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25SearchText", AV25SearchText);
      AV23IsAdvancedSearch = AV12DefaultIsAdvancedSearch ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23IsAdvancedSearch", AV23IsAdvancedSearch);
      AV8AdvFilterText = AV25SearchText ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8AdvFilterText", AV8AdvFilterText);
      if ( ! (GXutil.strcmp("", AV11DefaultAdvFilterEntitiesJson)==0) )
      {
         AV5AdvFilterEntities.fromJSonString(AV11DefaultAdvFilterEntitiesJson, null);
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV9DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0];
      AV9DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      /* Execute user subroutine: 'LOADCOMBOADVFILTERENTITIES' */
      S112 ();
      if (returnInSub) return;
      edtavUrl_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Visible), 5, 0), !bGXsfl_56_Refreshing);
      /* Execute user subroutine: 'EXECUTE SEARCH' */
      S122 ();
      if (returnInSub) return;
   }

   private void e150O2( )
   {
      /* Fsresultcategories_Load Routine */
      returnInSub = false ;
      AV30GXV1 = 1 ;
      while ( AV30GXV1 <= AV28WWP_SearchResults.size() )
      {
         AV28WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)) );
         if ( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults() )
         {
            lblTxtshowingonly_Caption = "" ;
         }
         else
         {
            lblTxtshowingonly_Caption = GXutil.format( "Mostrando los primeros %1 resultados", GXutil.ltrimstr( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().size(), 9, 0), "", "", "", "", "", "", "", "") ;
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(48) ;
         }
         sendrow_482( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_48_Refreshing )
         {
            httpContext.doAjaxLoad(48, FsresultcategoriesRow);
         }
         AV30GXV1 = (int)(AV30GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e110O2( )
   {
      AV30GXV1 = nGXsfl_48_idx ;
      if ( ( AV30GXV1 > 0 ) && ( AV28WWP_SearchResults.size() >= AV30GXV1 ) )
      {
         AV28WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)) );
      }
      /* 'DoBtnAdvSearch' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'EXECUTE SEARCH' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5AdvFilterEntities", AV5AdvFilterEntities);
      if ( gx_BV48 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28WWP_SearchResults", AV28WWP_SearchResults);
         nGXsfl_48_bak_idx = nGXsfl_48_idx ;
         gxgrfsresultcategories_refresh( AV28WWP_SearchResults, AV10DeafultSearchText, AV12DefaultIsAdvancedSearch, AV11DefaultAdvFilterEntitiesJson) ;
         nGXsfl_48_idx = nGXsfl_48_bak_idx ;
         sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_482( ) ;
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e120O2 ();
      if (returnInSub) return;
   }

   public void e120O2( )
   {
      AV30GXV1 = nGXsfl_48_idx ;
      if ( ( AV30GXV1 > 0 ) && ( AV28WWP_SearchResults.size() >= AV30GXV1 ) )
      {
         AV28WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)) );
      }
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'EXECUTE SEARCH' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5AdvFilterEntities", AV5AdvFilterEntities);
      if ( gx_BV48 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28WWP_SearchResults", AV28WWP_SearchResults);
         nGXsfl_48_bak_idx = nGXsfl_48_idx ;
         gxgrfsresultcategories_refresh( AV28WWP_SearchResults, AV10DeafultSearchText, AV12DefaultIsAdvancedSearch, AV11DefaultAdvFilterEntitiesJson) ;
         nGXsfl_48_idx = nGXsfl_48_bak_idx ;
         sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_482( ) ;
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOADVFILTERENTITIES' Routine */
      returnInSub = false ;
      GXv_objcol_svchar3[0] = AV22EntityDescriptions ;
      GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem4[0] = AV27WWP_SearchResultAux ;
      new com.wwpbaseobjects.wwp_getsearchwcdata(remoteHandle, context).execute( "", (short)(999), (short)(0), GXv_objcol_svchar3, GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem4) ;
      AV22EntityDescriptions = GXv_objcol_svchar3[0] ;
      AV27WWP_SearchResultAux = GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem4[0] ;
      AV6AdvFilterEntities_Data = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle) ;
      AV34GXV4 = 1 ;
      while ( AV34GXV4 <= AV22EntityDescriptions.size() )
      {
         AV21EntityDescription = (String)AV22EntityDescriptions.elementAt(-1+AV34GXV4) ;
         AV7AdvFilterEntities_DataItem = (com.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV7AdvFilterEntities_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( AV21EntityDescription );
         AV7AdvFilterEntities_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( AV21EntityDescription );
         AV6AdvFilterEntities_Data.add(AV7AdvFilterEntities_DataItem, 0);
         AV34GXV4 = (int)(AV34GXV4+1) ;
      }
      Combo_advfilterentities_Selectedvalue_set = AV5AdvFilterEntities.toJSonString(false) ;
      ucCombo_advfilterentities.sendProperty(context, "", false, Combo_advfilterentities_Internalname, "SelectedValue_set", Combo_advfilterentities_Selectedvalue_set);
   }

   public void e130O2( )
   {
      AV30GXV1 = nGXsfl_48_idx ;
      if ( ( AV30GXV1 > 0 ) && ( AV28WWP_SearchResults.size() >= AV30GXV1 ) )
      {
         AV28WWP_SearchResults.currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)) );
      }
      /* Tablefscard_Click Routine */
      returnInSub = false ;
      new com.wwpbaseobjects.wwp_addrecentsearch(remoteHandle, context).execute( AV28WWP_SearchResults, AV26Url, (short)(4), (short)(3)) ;
      callWebObject(formatLink(AV26Url, new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(0) ;
   }

   public void S122( )
   {
      /* 'EXECUTE SEARCH' Routine */
      returnInSub = false ;
      divTableadvancedsearchcell_Visible = (AV23IsAdvancedSearch ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divTableadvancedsearchcell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableadvancedsearchcell_Visible), 5, 0), true);
      divTablesimplesearchcell_Visible = ((!AV23IsAdvancedSearch) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divTablesimplesearchcell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesimplesearchcell_Visible), 5, 0), true);
      AV24MinimumCharsToSearch = (short)(1) ;
      AV25SearchText = (AV23IsAdvancedSearch ? AV8AdvFilterText : AV25SearchText) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25SearchText", AV25SearchText);
      if ( GXutil.len( GXutil.trim( AV25SearchText)) >= AV24MinimumCharsToSearch )
      {
         if ( ! AV23IsAdvancedSearch )
         {
            AV5AdvFilterEntities = new GXSimpleCollection<String>(String.class, "internal", "") ;
            Combo_advfilterentities_Selectedvalue_set = AV5AdvFilterEntities.toJSonString(false) ;
            ucCombo_advfilterentities.sendProperty(context, "", false, Combo_advfilterentities_Internalname, "SelectedValue_set", Combo_advfilterentities_Selectedvalue_set);
         }
         GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5 = AV28WWP_SearchResults ;
         GXv_objcol_svchar3[0] = AV5AdvFilterEntities ;
         GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem4[0] = GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5 ;
         new com.wwpbaseobjects.wwp_getsearchwcdata(remoteHandle, context).execute( AV25SearchText, (short)(10), (short)(12), GXv_objcol_svchar3, GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem4) ;
         AV5AdvFilterEntities = GXv_objcol_svchar3[0] ;
         GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5 = GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem4[0] ;
         AV28WWP_SearchResults = GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5 ;
         gx_BV48 = true ;
      }
      else
      {
         AV28WWP_SearchResults = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Gregory", remoteHandle) ;
         gx_BV48 = true ;
      }
      if ( AV28WWP_SearchResults.size() == 0 )
      {
         if ( GXutil.len( GXutil.trim( AV25SearchText)) < AV24MinimumCharsToSearch )
         {
            lblTxtnoresults_Caption = "Escribe para buscar en la aplicación o el menú" ;
            httpContext.ajax_rsp_assign_prop("", false, lblTxtnoresults_Internalname, "Caption", lblTxtnoresults_Caption, true);
         }
         else
         {
            lblTxtnoresults_Caption = GXutil.format( "No se encontraron resultados para '%1'.", AV25SearchText, "", "", "", "", "", "", "", "") ;
            httpContext.ajax_rsp_assign_prop("", false, lblTxtnoresults_Internalname, "Caption", lblTxtnoresults_Caption, true);
         }
      }
      divFsresultcategoriescell_Visible = (((AV28WWP_SearchResults.size()>0)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divFsresultcategoriescell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divFsresultcategoriescell_Visible), 5, 0), true);
      divTxtnoresultscell_Visible = (((AV28WWP_SearchResults.size()==0)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divTxtnoresultscell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTxtnoresultscell_Visible), 5, 0), true);
   }

   private void e160O3( )
   {
      AV30GXV1 = nGXsfl_48_idx ;
      if ( AV28WWP_SearchResults.size() < AV30GXV1 )
      {
         return  ;
      }
      /* Fsresults_Load Routine */
      returnInSub = false ;
      AV32GXV3 = 1 ;
      while ( AV32GXV3 <= ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().size() )
      {
         ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().elementAt(-1+AV32GXV3)) );
         divDisplaytype1_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divDisplaytype1_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype1_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
         divDisplaytype2_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divDisplaytype2_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype2_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
         divDisplaytype3_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divDisplaytype3_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype3_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
         divDisplaytype4_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divDisplaytype4_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype4_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
         divDisplaytype5_cell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divDisplaytype5_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype5_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
         if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title") == 0 )
         {
            divDisplaytype1_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divDisplaytype1_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype1_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
            AV13DisplayType1_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype1_title_Internalname, AV13DisplayType1_Title);
         }
         else if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title and icon image") == 0 )
         {
            divDisplaytype2_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divDisplaytype2_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype2_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
            AV14DisplayType2_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype2_title_Internalname, AV14DisplayType2_Title);
            lblDisplaytype2_icon_Caption = GXutil.format( "<i class='SearchResultIcon %1'></i>", ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2(), "", "", "", "", "", "", "", "") ;
         }
         else if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title and subtitle") == 0 )
         {
            divDisplaytype3_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divDisplaytype3_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype3_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
            AV16DisplayType3_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype3_title_Internalname, AV16DisplayType3_Title);
            AV15DisplayType3_Subtitle = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype3_subtitle_Internalname, AV15DisplayType3_Subtitle);
         }
         else if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title and image") == 0 )
         {
            divDisplaytype4_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divDisplaytype4_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype4_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
            AV18DisplayType4_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype4_title_Internalname, AV18DisplayType4_Title);
            if ( (GXutil.strcmp("", ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2())==0) )
            {
               AV17DisplayType4_Image = "" ;
               httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype4_image_Internalname, AV17DisplayType4_Image);
               AV33Displaytype4_image_GXI = "" ;
            }
            else
            {
               AV17DisplayType4_Image = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2() ;
               httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype4_image_Internalname, AV17DisplayType4_Image);
               AV33Displaytype4_image_GXI = GXDbFile.pathToUrl( ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2(), context.getHttpContext()) ;
            }
            edtavDisplaytype4_image_Visible = ((!(GXutil.strcmp("", ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2())==0)) ? 1 : 0) ;
         }
         else if ( GXutil.strcmp(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(), "Title, subtitle and icon image") == 0 )
         {
            divDisplaytype5_cell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divDisplaytype5_cell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divDisplaytype5_cell_Visible), 5, 0), !bGXsfl_56_Refreshing);
            AV20DisplayType5_Title = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype5_title_Internalname, AV20DisplayType5_Title);
            AV19DisplayType5_Subtitle = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDisplaytype5_subtitle_Internalname, AV19DisplayType5_Subtitle);
            lblDisplaytype5_icon_Caption = GXutil.format( "<i class='SearchResultIconWS %1'></i>", ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3(), "", "", "", "", "", "", "", "") ;
         }
         AV26Url = ((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(AV28WWP_SearchResults.currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().currentItem())).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavUrl_Internalname, AV26Url);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(56) ;
         }
         sendrow_563( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_56_Refreshing )
         {
            httpContext.doAjaxLoad(56, FsresultsRow);
         }
         AV32GXV3 = (int)(AV32GXV3+1) ;
      }
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10DeafultSearchText = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10DeafultSearchText", AV10DeafultSearchText);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEAFULTSEARCHTEXT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10DeafultSearchText, ""))));
      AV12DefaultIsAdvancedSearch = ((Boolean) getParm(obj,1)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12DefaultIsAdvancedSearch", AV12DefaultIsAdvancedSearch);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTISADVANCEDSEARCH", getSecureSignedToken( "", AV12DefaultIsAdvancedSearch));
      AV11DefaultAdvFilterEntitiesJson = (String)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11DefaultAdvFilterEntitiesJson", AV11DefaultAdvFilterEntitiesJson);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTADVFILTERENTITIESJSON", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11DefaultAdvFilterEntitiesJson, ""))));
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
      pa0O2( ) ;
      ws0O2( ) ;
      we0O2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20244261717377", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages.spa.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("wwpbaseobjects/wwp_search.js", "?20244261717377", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_563( )
   {
      edtavUrl_Internalname = "vURL_"+sGXsfl_56_idx ;
      edtavDisplaytype1_title_Internalname = "vDISPLAYTYPE1_TITLE_"+sGXsfl_56_idx ;
      lblDisplaytype2_icon_Internalname = "DISPLAYTYPE2_ICON_"+sGXsfl_56_idx ;
      edtavDisplaytype2_title_Internalname = "vDISPLAYTYPE2_TITLE_"+sGXsfl_56_idx ;
      edtavDisplaytype3_title_Internalname = "vDISPLAYTYPE3_TITLE_"+sGXsfl_56_idx ;
      edtavDisplaytype3_subtitle_Internalname = "vDISPLAYTYPE3_SUBTITLE_"+sGXsfl_56_idx ;
      edtavDisplaytype4_image_Internalname = "vDISPLAYTYPE4_IMAGE_"+sGXsfl_56_idx ;
      edtavDisplaytype4_title_Internalname = "vDISPLAYTYPE4_TITLE_"+sGXsfl_56_idx ;
      lblDisplaytype5_icon_Internalname = "DISPLAYTYPE5_ICON_"+sGXsfl_56_idx ;
      edtavDisplaytype5_title_Internalname = "vDISPLAYTYPE5_TITLE_"+sGXsfl_56_idx ;
      edtavDisplaytype5_subtitle_Internalname = "vDISPLAYTYPE5_SUBTITLE_"+sGXsfl_56_idx ;
   }

   public void subsflControlProps_fel_563( )
   {
      edtavUrl_Internalname = "vURL_"+sGXsfl_56_fel_idx ;
      edtavDisplaytype1_title_Internalname = "vDISPLAYTYPE1_TITLE_"+sGXsfl_56_fel_idx ;
      lblDisplaytype2_icon_Internalname = "DISPLAYTYPE2_ICON_"+sGXsfl_56_fel_idx ;
      edtavDisplaytype2_title_Internalname = "vDISPLAYTYPE2_TITLE_"+sGXsfl_56_fel_idx ;
      edtavDisplaytype3_title_Internalname = "vDISPLAYTYPE3_TITLE_"+sGXsfl_56_fel_idx ;
      edtavDisplaytype3_subtitle_Internalname = "vDISPLAYTYPE3_SUBTITLE_"+sGXsfl_56_fel_idx ;
      edtavDisplaytype4_image_Internalname = "vDISPLAYTYPE4_IMAGE_"+sGXsfl_56_fel_idx ;
      edtavDisplaytype4_title_Internalname = "vDISPLAYTYPE4_TITLE_"+sGXsfl_56_fel_idx ;
      lblDisplaytype5_icon_Internalname = "DISPLAYTYPE5_ICON_"+sGXsfl_56_fel_idx ;
      edtavDisplaytype5_title_Internalname = "vDISPLAYTYPE5_TITLE_"+sGXsfl_56_fel_idx ;
      edtavDisplaytype5_subtitle_Internalname = "vDISPLAYTYPE5_SUBTITLE_"+sGXsfl_56_fel_idx ;
   }

   public void sendrow_563( )
   {
      subsflControlProps_563( ) ;
      wb0O0( ) ;
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
         if ( ((int)((nGXsfl_56_idx) % (2))) == 0 )
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
         httpContext.writeText( "<tr"+" class=\""+subFsresults_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_56_idx+"\">") ;
      }
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsfsresults_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","start","top"," "+"data-gx-flex"+" ","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Invisible","start","top","","flex-grow:1;","div"});
      /* Table start */
      FsresultsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsfsresults_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      FsresultsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      FsresultsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavUrl_Internalname,"Url","gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUrl_Internalname,AV26Url,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavUrl_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtavUrl_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
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
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","CellMarginTop SearchResultCardCell","start","top","","flex-grow:1;","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablefscard_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","SimpleCardTable","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype1_cell_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(divDisplaytype1_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable1_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","start","top","","","div"});
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
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype1_title_Internalname,AV13DisplayType1_Title,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype1_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype1_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype2_cell_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(divDisplaytype2_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Table start */
      FsresultsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable2_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      FsresultsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      FsresultsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Text block */
      FsresultsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblDisplaytype2_icon_Internalname,lblDisplaytype2_icon_Caption,"","",lblDisplaytype2_icon_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
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
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype2_title_Internalname,AV14DisplayType2_Title,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype2_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype2_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
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
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype3_cell_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(divDisplaytype3_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable3_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      sendrow_56330( ) ;
   }

   public void sendrow_56330( )
   {
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDisplaytype3_title_Internalname,"Display Type3_Title","col-sm-3 AttributeSearchResultTitleLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttributeSearchResultTitle" ;
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype3_title_Internalname,AV16DisplayType3_Title,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype3_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype3_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
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
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype3_subtitle_Internalname,AV15DisplayType3_Subtitle,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype3_subtitle_Jsonclick,Integer.valueOf(0),"AttributeSearchResultSubtitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype3_subtitle_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype4_cell_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(divDisplaytype4_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable4_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","start","top"," "+"data-gx-flex"+" ","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","AttributeSearchResultImageCell","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"","Display Type4_Image","gx-form-item AttributeSearchResultImageLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Static Bitmap Variable */
      ClassString = "AttributeSearchResultImage" + " " + ((GXutil.strcmp(edtavDisplaytype4_image_gximage, "")==0) ? "" : "GX_Image_"+edtavDisplaytype4_image_gximage+"_Class") ;
      StyleString = "" ;
      AV17DisplayType4_Image_IsBlob = (boolean)(((GXutil.strcmp("", AV17DisplayType4_Image)==0)&&(GXutil.strcmp("", AV33Displaytype4_image_GXI)==0))||!(GXutil.strcmp("", AV17DisplayType4_Image)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV17DisplayType4_Image)==0) ? AV33Displaytype4_image_GXI : httpContext.getResourceRelative(AV17DisplayType4_Image)) ;
      FsresultsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype4_image_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavDisplaytype4_image_Visible),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV17DisplayType4_Image_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
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
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype4_title_Internalname,AV18DisplayType4_Title,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype4_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype4_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divDisplaytype5_cell_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(divDisplaytype5_cell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Table start */
      FsresultsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable5_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      FsresultsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      FsresultsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Text block */
      FsresultsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblDisplaytype5_icon_Internalname,lblDisplaytype5_icon_Caption,"","",lblDisplaytype5_icon_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         FsresultsContainer.CloseTag("cell");
      }
      FsresultsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      FsresultsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable6_Internalname+"_"+sGXsfl_56_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","start","top","","","div"});
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
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype5_title_Internalname,AV20DisplayType5_Title,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype5_title_Jsonclick,Integer.valueOf(0),"AttributeSearchResultTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype5_title_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
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
      FsresultsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplaytype5_subtitle_Internalname,AV19DisplayType5_Subtitle,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDisplaytype5_subtitle_Jsonclick,Integer.valueOf(0),"AttributeSearchResultSubtitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDisplaytype5_subtitle_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
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
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      send_integrity_lvl_hashes0O3( ) ;
      /* End of Columns property logic. */
      FsresultsContainer.AddRow(FsresultsRow);
      nGXsfl_56_idx = ((subFsresults_Islastpage==1)&&(nGXsfl_56_idx+1>subfsresults_fnc_recordsperpage( )) ? 1 : nGXsfl_56_idx+1) ;
      sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") + sGXsfl_48_idx ;
      subsflControlProps_563( ) ;
      /* End function sendrow_563 */
   }

   public void subsflControlProps_482( )
   {
      edtavWwp_searchresults__categoryname_Internalname = "WWP_SEARCHRESULTS__CATEGORYNAME_"+sGXsfl_48_idx ;
      lblTxtshowingonly_Internalname = "TXTSHOWINGONLY_"+sGXsfl_48_idx ;
      subFsresults_Internalname = "FSRESULTS_"+sGXsfl_48_idx ;
   }

   public void subsflControlProps_fel_482( )
   {
      edtavWwp_searchresults__categoryname_Internalname = "WWP_SEARCHRESULTS__CATEGORYNAME_"+sGXsfl_48_fel_idx ;
      lblTxtshowingonly_Internalname = "TXTSHOWINGONLY_"+sGXsfl_48_fel_idx ;
      subFsresults_Internalname = "FSRESULTS_"+sGXsfl_48_fel_idx ;
   }

   public void sendrow_482( )
   {
      subsflControlProps_482( ) ;
      wb0O0( ) ;
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
         if ( ((int)((nGXsfl_48_idx) % (2))) == 0 )
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
         httpContext.writeText( "<tr"+" class=\""+subFsresultcategories_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_48_idx+"\">") ;
      }
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsfsresultcategories_Internalname+"_"+sGXsfl_48_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","start","top","","","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 SearchResultCategoryCell","start","top","","","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FsresultcategoriesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavWwp_searchresults__categoryname_Internalname,"Category Name","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      FsresultcategoriesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWwp_searchresults__categoryname_Internalname,((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV28WWP_SearchResults.elementAt(-1+AV30GXV1)).getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavWwp_searchresults__categoryname_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavWwp_searchresults__categoryname_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(48),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
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
      startgridcontrol56( ) ;
      rf0O3( ) ;
      nRC_GXsfl_56 = (int)(nGXsfl_56_idx-1) ;
      send_integrity_footer_hashes( ) ;
      GXCCtl = "nRC_GXsfl_56_" + sGXsfl_48_idx ;
      com.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_56, (byte)(8), (byte)(0), ",", "")));
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "</table>") ;
      }
      else
      {
         if ( ! isAjaxCallMode( ) )
         {
            com.GxWebStd.gx_hidden_field( httpContext, "FsresultsContainerData"+"_"+sGXsfl_48_idx, FsresultsContainer.ToJavascriptSource());
         }
         if ( isAjaxCallMode( ) )
         {
            FsresultcategoriesRow.AddGrid("Fsresults", FsresultsContainer);
         }
         if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
         {
            com.GxWebStd.gx_hidden_field( httpContext, "FsresultsContainerData"+"V_"+sGXsfl_48_idx, FsresultsContainer.GridValuesHidden());
         }
         else
         {
            httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"FsresultsContainerData"+"V_"+sGXsfl_48_idx+"\" value='"+FsresultsContainer.GridValuesHidden()+"'/>") ;
         }
      }
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FsresultcategoriesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","end","top","","","div"});
      /* Text block */
      FsresultcategoriesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTxtshowingonly_Internalname,lblTxtshowingonly_Caption,"","",lblTxtshowingonly_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlockShowingOnly",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"end","top","div"});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FsresultcategoriesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      send_integrity_lvl_hashes0O2( ) ;
      GXCCtl = "subFsresults_Recordcount_" + sGXsfl_48_idx ;
      com.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subFsresults_Recordcount, (byte)(5), (byte)(0), ",", "")));
      /* End of Columns property logic. */
      FsresultcategoriesContainer.AddRow(FsresultcategoriesRow);
      nGXsfl_48_idx = ((subFsresultcategories_Islastpage==1)&&(nGXsfl_48_idx+1>subfsresultcategories_fnc_recordsperpage( )) ? 1 : nGXsfl_48_idx+1) ;
      sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_482( ) ;
      /* End function sendrow_482 */
   }

   public void startgridcontrol48( )
   {
      if ( FsresultcategoriesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"FsresultcategoriesContainer"+"DivS\" data-gxgridid=\"48\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subFsresultcategories_Internalname, subFsresultcategories_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         FsresultcategoriesContainer.AddObjectProperty("GridName", "Fsresultcategories");
      }
      else
      {
         FsresultcategoriesContainer.AddObjectProperty("GridName", "Fsresultcategories");
         FsresultcategoriesContainer.AddObjectProperty("Header", subFsresultcategories_Header);
         FsresultcategoriesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         FsresultcategoriesContainer.AddObjectProperty("Class", "FreeStyleGrid");
         FsresultcategoriesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFsresultcategories_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         FsresultcategoriesContainer.AddObjectProperty("CmpContext", "");
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

   public void startgridcontrol56( )
   {
      if ( FsresultsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"FsresultsContainer"+"DivS\" data-gxgridid=\"56\">") ;
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
         FsresultsContainer.AddObjectProperty("CmpContext", "");
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
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV26Url));
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
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV13DisplayType1_Title));
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
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", lblDisplaytype2_icon_Caption);
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV14DisplayType2_Title));
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
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV16DisplayType3_Title));
         FsresultsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype3_title_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV15DisplayType3_Subtitle));
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
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", httpContext.convertURL( AV17DisplayType4_Image));
         FsresultsColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype4_image_Visible, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV18DisplayType4_Title));
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
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV20DisplayType5_Title));
         FsresultsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplaytype5_title_Enabled, (byte)(5), (byte)(0), ".", "")));
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsContainer.AddColumnProperties(FsresultsColumn);
         FsresultsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FsresultsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV19DisplayType5_Subtitle));
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
      edtavSearchtext_Internalname = "vSEARCHTEXT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      divUnnamedtable9_Internalname = "UNNAMEDTABLE9" ;
      Btnadvancedsearch_Internalname = "BTNADVANCEDSEARCH" ;
      divUnnamedtable7_Internalname = "UNNAMEDTABLE7" ;
      divTablesimplesearchcell_Internalname = "TABLESIMPLESEARCHCELL" ;
      edtavAdvfiltertext_Internalname = "vADVFILTERTEXT" ;
      lblTextblockcombo_advfilterentities_Internalname = "TEXTBLOCKCOMBO_ADVFILTERENTITIES" ;
      Combo_advfilterentities_Internalname = "COMBO_ADVFILTERENTITIES" ;
      divTablesplittedadvfilterentities_Internalname = "TABLESPLITTEDADVFILTERENTITIES" ;
      bttBtnbtnadvsearch_Internalname = "BTNBTNADVSEARCH" ;
      divUnnamedtable8_Internalname = "UNNAMEDTABLE8" ;
      Btnbasicsearch_Internalname = "BTNBASICSEARCH" ;
      divTableadvancedsearch_Internalname = "TABLEADVANCEDSEARCH" ;
      divTableadvancedsearchcell_Internalname = "TABLEADVANCEDSEARCHCELL" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavWwp_searchresults__categoryname_Internalname = "WWP_SEARCHRESULTS__CATEGORYNAME" ;
      edtavUrl_Internalname = "vURL" ;
      tblUnnamedtablecontentfsfsresults_Internalname = "UNNAMEDTABLECONTENTFSFSRESULTS" ;
      edtavDisplaytype1_title_Internalname = "vDISPLAYTYPE1_TITLE" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divDisplaytype1_cell_Internalname = "DISPLAYTYPE1_CELL" ;
      lblDisplaytype2_icon_Internalname = "DISPLAYTYPE2_ICON" ;
      edtavDisplaytype2_title_Internalname = "vDISPLAYTYPE2_TITLE" ;
      tblUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      divDisplaytype2_cell_Internalname = "DISPLAYTYPE2_CELL" ;
      edtavDisplaytype3_title_Internalname = "vDISPLAYTYPE3_TITLE" ;
      edtavDisplaytype3_subtitle_Internalname = "vDISPLAYTYPE3_SUBTITLE" ;
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      divDisplaytype3_cell_Internalname = "DISPLAYTYPE3_CELL" ;
      edtavDisplaytype4_image_Internalname = "vDISPLAYTYPE4_IMAGE" ;
      edtavDisplaytype4_title_Internalname = "vDISPLAYTYPE4_TITLE" ;
      divUnnamedtable4_Internalname = "UNNAMEDTABLE4" ;
      divDisplaytype4_cell_Internalname = "DISPLAYTYPE4_CELL" ;
      lblDisplaytype5_icon_Internalname = "DISPLAYTYPE5_ICON" ;
      edtavDisplaytype5_title_Internalname = "vDISPLAYTYPE5_TITLE" ;
      edtavDisplaytype5_subtitle_Internalname = "vDISPLAYTYPE5_SUBTITLE" ;
      divUnnamedtable6_Internalname = "UNNAMEDTABLE6" ;
      tblUnnamedtable5_Internalname = "UNNAMEDTABLE5" ;
      divDisplaytype5_cell_Internalname = "DISPLAYTYPE5_CELL" ;
      divTablefscard_Internalname = "TABLEFSCARD" ;
      divUnnamedtablefsfsresults_Internalname = "UNNAMEDTABLEFSFSRESULTS" ;
      lblTxtshowingonly_Internalname = "TXTSHOWINGONLY" ;
      divUnnamedtablefsfsresultcategories_Internalname = "UNNAMEDTABLEFSFSRESULTCATEGORIES" ;
      divFsresultcategoriescell_Internalname = "FSRESULTCATEGORIESCELL" ;
      lblTxtnoresults_Internalname = "TXTNORESULTS" ;
      divTxtnoresultscell_Internalname = "TXTNORESULTSCELL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subFsresults_Internalname = "FSRESULTS" ;
      subFsresultcategories_Internalname = "FSRESULTCATEGORIES" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS", true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subFsresults_Allowcollapsing = (byte)(0) ;
      lblDisplaytype2_icon_Caption = "<i class='fa fa-home'></i>" ;
      subFsresultcategories_Allowcollapsing = (byte)(0) ;
      lblTxtshowingonly_Caption = "Showing only the first 3 results..." ;
      lblTxtshowingonly_Caption = "Showing only the first 3 results..." ;
      edtavWwp_searchresults__categoryname_Jsonclick = "" ;
      edtavWwp_searchresults__categoryname_Enabled = 0 ;
      subFsresultcategories_Class = "FreeStyleGrid" ;
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
      lblTxtnoresults_Caption = "No results found for '%1'." ;
      divTxtnoresultscell_Visible = 1 ;
      divFsresultcategoriescell_Visible = 1 ;
      Btnbasicsearch_Class = "IconButtonLink" ;
      Btnbasicsearch_Caption = "Búsqueda básica" ;
      Btnbasicsearch_Beforeiconclass = "fas fa-filter" ;
      Btnbasicsearch_Tooltiptext = "" ;
      Combo_advfilterentities_Multiplevaluestype = "Tags" ;
      Combo_advfilterentities_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_advfilterentities_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_advfilterentities_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_advfilterentities_Cls = "ExtendedCombo Attribute" ;
      Combo_advfilterentities_Caption = "" ;
      edtavAdvfiltertext_Jsonclick = "" ;
      edtavAdvfiltertext_Enabled = 1 ;
      divTableadvancedsearchcell_Visible = 1 ;
      Btnadvancedsearch_Class = "IconButtonLink" ;
      Btnadvancedsearch_Caption = "Búsqueda avanzada" ;
      Btnadvancedsearch_Beforeiconclass = "fas fa-filter" ;
      Btnadvancedsearch_Tooltiptext = "" ;
      edtavSearchtext_Jsonclick = "" ;
      edtavSearchtext_Enabled = 1 ;
      divTablesimplesearchcell_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Search results" );
      edtavUrl_Visible = 1 ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'FSRESULTCATEGORIES_nEOF'},{av:'FSRESULTS_nFirstRecordOnPage'},{av:'FSRESULTS_nEOF'},{av:'edtavUrl_Visible',ctrl:'vURL',prop:'Visible'},{av:'AV28WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:48,pic:''},{av:'nGXsfl_48_idx',ctrl:'GRID',prop:'GridCurrRow',grid:48},{av:'nRC_GXsfl_48',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:48},{av:'AV10DeafultSearchText',fld:'vDEAFULTSEARCHTEXT',pic:'',hsh:true},{av:'AV12DefaultIsAdvancedSearch',fld:'vDEFAULTISADVANCEDSEARCH',pic:'',hsh:true},{av:'AV11DefaultAdvFilterEntitiesJson',fld:'vDEFAULTADVFILTERENTITIESJSON',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("FSRESULTCATEGORIES.LOAD","{handler:'e150O2',iparms:[{av:'AV28WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:48,pic:''},{av:'nGXsfl_48_idx',ctrl:'GRID',prop:'GridCurrRow',grid:48},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_48',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:48}]");
      setEventMetadata("FSRESULTCATEGORIES.LOAD",",oparms:[{av:'lblTxtshowingonly_Caption',ctrl:'TXTSHOWINGONLY',prop:'Caption'}]}");
      setEventMetadata("FSRESULTS.LOAD","{handler:'e160O3',iparms:[{av:'AV28WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:48,pic:''},{av:'nGXsfl_48_idx',ctrl:'GRID',prop:'GridCurrRow',grid:48},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_48',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:48}]");
      setEventMetadata("FSRESULTS.LOAD",",oparms:[{av:'divDisplaytype1_cell_Visible',ctrl:'DISPLAYTYPE1_CELL',prop:'Visible'},{av:'divDisplaytype2_cell_Visible',ctrl:'DISPLAYTYPE2_CELL',prop:'Visible'},{av:'divDisplaytype3_cell_Visible',ctrl:'DISPLAYTYPE3_CELL',prop:'Visible'},{av:'divDisplaytype4_cell_Visible',ctrl:'DISPLAYTYPE4_CELL',prop:'Visible'},{av:'divDisplaytype5_cell_Visible',ctrl:'DISPLAYTYPE5_CELL',prop:'Visible'},{av:'AV13DisplayType1_Title',fld:'vDISPLAYTYPE1_TITLE',pic:''},{av:'AV14DisplayType2_Title',fld:'vDISPLAYTYPE2_TITLE',pic:''},{av:'lblDisplaytype2_icon_Caption',ctrl:'DISPLAYTYPE2_ICON',prop:'Caption'},{av:'AV16DisplayType3_Title',fld:'vDISPLAYTYPE3_TITLE',pic:''},{av:'AV15DisplayType3_Subtitle',fld:'vDISPLAYTYPE3_SUBTITLE',pic:''},{av:'AV18DisplayType4_Title',fld:'vDISPLAYTYPE4_TITLE',pic:''},{av:'AV17DisplayType4_Image',fld:'vDISPLAYTYPE4_IMAGE',pic:''},{av:'edtavDisplaytype4_image_Visible',ctrl:'vDISPLAYTYPE4_IMAGE',prop:'Visible'},{av:'AV20DisplayType5_Title',fld:'vDISPLAYTYPE5_TITLE',pic:''},{av:'AV19DisplayType5_Subtitle',fld:'vDISPLAYTYPE5_SUBTITLE',pic:''},{av:'lblDisplaytype5_icon_Caption',ctrl:'DISPLAYTYPE5_ICON',prop:'Caption'},{av:'AV26Url',fld:'vURL',pic:''}]}");
      setEventMetadata("'DOBTNADVSEARCH'","{handler:'e110O2',iparms:[{av:'AV23IsAdvancedSearch',fld:'vISADVANCEDSEARCH',pic:''},{av:'AV8AdvFilterText',fld:'vADVFILTERTEXT',pic:''},{av:'AV25SearchText',fld:'vSEARCHTEXT',pic:''},{av:'AV5AdvFilterEntities',fld:'vADVFILTERENTITIES',pic:''},{av:'AV28WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:48,pic:''},{av:'nGXsfl_48_idx',ctrl:'GRID',prop:'GridCurrRow',grid:48},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_48',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:48},{av:'FSRESULTCATEGORIES_nEOF'},{av:'FSRESULTS_nFirstRecordOnPage'},{av:'FSRESULTS_nEOF'},{av:'edtavUrl_Visible',ctrl:'vURL',prop:'Visible'},{av:'AV10DeafultSearchText',fld:'vDEAFULTSEARCHTEXT',pic:'',hsh:true},{av:'AV12DefaultIsAdvancedSearch',fld:'vDEFAULTISADVANCEDSEARCH',pic:'',hsh:true},{av:'AV11DefaultAdvFilterEntitiesJson',fld:'vDEFAULTADVFILTERENTITIESJSON',pic:'',hsh:true}]");
      setEventMetadata("'DOBTNADVSEARCH'",",oparms:[{av:'divTableadvancedsearchcell_Visible',ctrl:'TABLEADVANCEDSEARCHCELL',prop:'Visible'},{av:'divTablesimplesearchcell_Visible',ctrl:'TABLESIMPLESEARCHCELL',prop:'Visible'},{av:'AV25SearchText',fld:'vSEARCHTEXT',pic:''},{av:'AV5AdvFilterEntities',fld:'vADVFILTERENTITIES',pic:''},{av:'Combo_advfilterentities_Selectedvalue_set',ctrl:'COMBO_ADVFILTERENTITIES',prop:'SelectedValue_set'},{av:'AV28WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:48,pic:''},{av:'nGXsfl_48_idx',ctrl:'GRID',prop:'GridCurrRow',grid:48},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_48',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:48},{av:'lblTxtnoresults_Caption',ctrl:'TXTNORESULTS',prop:'Caption'},{av:'divFsresultcategoriescell_Visible',ctrl:'FSRESULTCATEGORIESCELL',prop:'Visible'},{av:'divTxtnoresultscell_Visible',ctrl:'TXTNORESULTSCELL',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e120O2',iparms:[{av:'AV23IsAdvancedSearch',fld:'vISADVANCEDSEARCH',pic:''},{av:'AV8AdvFilterText',fld:'vADVFILTERTEXT',pic:''},{av:'AV25SearchText',fld:'vSEARCHTEXT',pic:''},{av:'AV5AdvFilterEntities',fld:'vADVFILTERENTITIES',pic:''},{av:'AV28WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:48,pic:''},{av:'nGXsfl_48_idx',ctrl:'GRID',prop:'GridCurrRow',grid:48},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_48',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:48},{av:'FSRESULTCATEGORIES_nEOF'},{av:'FSRESULTS_nFirstRecordOnPage'},{av:'FSRESULTS_nEOF'},{av:'edtavUrl_Visible',ctrl:'vURL',prop:'Visible'},{av:'AV10DeafultSearchText',fld:'vDEAFULTSEARCHTEXT',pic:'',hsh:true},{av:'AV12DefaultIsAdvancedSearch',fld:'vDEFAULTISADVANCEDSEARCH',pic:'',hsh:true},{av:'AV11DefaultAdvFilterEntitiesJson',fld:'vDEFAULTADVFILTERENTITIESJSON',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'divTableadvancedsearchcell_Visible',ctrl:'TABLEADVANCEDSEARCHCELL',prop:'Visible'},{av:'divTablesimplesearchcell_Visible',ctrl:'TABLESIMPLESEARCHCELL',prop:'Visible'},{av:'AV25SearchText',fld:'vSEARCHTEXT',pic:''},{av:'AV5AdvFilterEntities',fld:'vADVFILTERENTITIES',pic:''},{av:'Combo_advfilterentities_Selectedvalue_set',ctrl:'COMBO_ADVFILTERENTITIES',prop:'SelectedValue_set'},{av:'AV28WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:48,pic:''},{av:'nGXsfl_48_idx',ctrl:'GRID',prop:'GridCurrRow',grid:48},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_48',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:48},{av:'lblTxtnoresults_Caption',ctrl:'TXTNORESULTS',prop:'Caption'},{av:'divFsresultcategoriescell_Visible',ctrl:'FSRESULTCATEGORIESCELL',prop:'Visible'},{av:'divTxtnoresultscell_Visible',ctrl:'TXTNORESULTSCELL',prop:'Visible'}]}");
      setEventMetadata("TABLEFSCARD.CLICK","{handler:'e130O2',iparms:[{av:'AV28WWP_SearchResults',fld:'vWWP_SEARCHRESULTS',grid:48,pic:''},{av:'nGXsfl_48_idx',ctrl:'GRID',prop:'GridCurrRow',grid:48},{av:'FSRESULTCATEGORIES_nFirstRecordOnPage'},{av:'nRC_GXsfl_48',ctrl:'FSRESULTCATEGORIES',prop:'GridRC',grid:48},{av:'AV26Url',fld:'vURL',pic:''}]");
      setEventMetadata("TABLEFSCARD.CLICK",",oparms:[]}");
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
      wcpOAV10DeafultSearchText = "" ;
      wcpOAV11DefaultAdvFilterEntitiesJson = "" ;
      Combo_advfilterentities_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV10DeafultSearchText = "" ;
      AV11DefaultAdvFilterEntitiesJson = "" ;
      AV28WWP_SearchResults = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Gregory", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV9DDO_TitleSettingsIcons = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV6AdvFilterEntities_Data = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV5AdvFilterEntities = new GXSimpleCollection<String>(String.class, "internal", "");
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      AV25SearchText = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnenter_Jsonclick = "" ;
      ucBtnadvancedsearch = new com.genexus.webpanels.GXUserControl();
      AV8AdvFilterText = "" ;
      lblTextblockcombo_advfilterentities_Jsonclick = "" ;
      ucCombo_advfilterentities = new com.genexus.webpanels.GXUserControl();
      bttBtnbtnadvsearch_Jsonclick = "" ;
      ucBtnbasicsearch = new com.genexus.webpanels.GXUserControl();
      FsresultcategoriesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      lblTxtnoresults_Jsonclick = "" ;
      FsresultsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXCCtl = "" ;
      AV26Url = "" ;
      AV13DisplayType1_Title = "" ;
      AV14DisplayType2_Title = "" ;
      AV16DisplayType3_Title = "" ;
      AV15DisplayType3_Subtitle = "" ;
      AV17DisplayType4_Image = "" ;
      AV33Displaytype4_image_GXI = "" ;
      AV18DisplayType4_Title = "" ;
      AV20DisplayType5_Title = "" ;
      AV19DisplayType5_Subtitle = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      FsresultcategoriesRow = new com.genexus.webpanels.GXWebRow();
      AV22EntityDescriptions = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27WWP_SearchResultAux = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Gregory", remoteHandle);
      AV21EntityDescription = "" ;
      AV7AdvFilterEntities_DataItem = new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      Combo_advfilterentities_Selectedvalue_set = "" ;
      GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5 = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Gregory", remoteHandle);
      GXv_objcol_svchar3 = new GXSimpleCollection[1] ;
      FsresultsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
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
      GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem4 = new GXBaseCollection[1] ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subFsresultcategories_Backcolorstyle ;
   private byte subFsresults_Backcolorstyle ;
   private byte FSRESULTCATEGORIES_nEOF ;
   private byte FSRESULTS_nEOF ;
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
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short AV24MinimumCharsToSearch ;
   private int nRC_GXsfl_56 ;
   private int nGXsfl_56_idx=1 ;
   private int nRC_GXsfl_48 ;
   private int edtavUrl_Visible ;
   private int nGXsfl_48_idx=1 ;
   private int divTablesimplesearchcell_Visible ;
   private int edtavSearchtext_Enabled ;
   private int divTableadvancedsearchcell_Visible ;
   private int edtavAdvfiltertext_Enabled ;
   private int divFsresultcategoriescell_Visible ;
   private int AV30GXV1 ;
   private int divTxtnoresultscell_Visible ;
   private int AV32GXV3 ;
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
   private int nGXsfl_48_fel_idx=1 ;
   private int nGXsfl_48_bak_idx=1 ;
   private int AV34GXV4 ;
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
   private String Combo_advfilterentities_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_56_idx="0001" ;
   private String edtavUrl_Internalname ;
   private String sGXsfl_48_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTablesimplesearchcell_Internalname ;
   private String divUnnamedtable7_Internalname ;
   private String divUnnamedtable9_Internalname ;
   private String edtavSearchtext_Internalname ;
   private String TempTags ;
   private String edtavSearchtext_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String Btnadvancedsearch_Tooltiptext ;
   private String Btnadvancedsearch_Beforeiconclass ;
   private String Btnadvancedsearch_Caption ;
   private String Btnadvancedsearch_Class ;
   private String Btnadvancedsearch_Internalname ;
   private String divTableadvancedsearchcell_Internalname ;
   private String divTableadvancedsearch_Internalname ;
   private String divUnnamedtable8_Internalname ;
   private String edtavAdvfiltertext_Internalname ;
   private String edtavAdvfiltertext_Jsonclick ;
   private String divTablesplittedadvfilterentities_Internalname ;
   private String lblTextblockcombo_advfilterentities_Internalname ;
   private String lblTextblockcombo_advfilterentities_Jsonclick ;
   private String Combo_advfilterentities_Caption ;
   private String Combo_advfilterentities_Cls ;
   private String Combo_advfilterentities_Multiplevaluestype ;
   private String Combo_advfilterentities_Internalname ;
   private String bttBtnbtnadvsearch_Internalname ;
   private String bttBtnbtnadvsearch_Jsonclick ;
   private String Btnbasicsearch_Tooltiptext ;
   private String Btnbasicsearch_Beforeiconclass ;
   private String Btnbasicsearch_Caption ;
   private String Btnbasicsearch_Class ;
   private String Btnbasicsearch_Internalname ;
   private String divFsresultcategoriescell_Internalname ;
   private String sStyleString ;
   private String subFsresultcategories_Internalname ;
   private String divTxtnoresultscell_Internalname ;
   private String lblTxtnoresults_Internalname ;
   private String lblTxtnoresults_Caption ;
   private String lblTxtnoresults_Jsonclick ;
   private String subFsresults_Internalname ;
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
   private String sGXsfl_48_fel_idx="0001" ;
   private String lblTxtshowingonly_Caption ;
   private String Combo_advfilterentities_Selectedvalue_set ;
   private String divDisplaytype1_cell_Internalname ;
   private String divDisplaytype2_cell_Internalname ;
   private String divDisplaytype3_cell_Internalname ;
   private String divDisplaytype4_cell_Internalname ;
   private String divDisplaytype5_cell_Internalname ;
   private String lblDisplaytype2_icon_Caption ;
   private String lblDisplaytype5_icon_Caption ;
   private String lblDisplaytype2_icon_Internalname ;
   private String lblDisplaytype5_icon_Internalname ;
   private String sGXsfl_56_fel_idx="0001" ;
   private String subFsresults_Class ;
   private String subFsresults_Linesclass ;
   private String divUnnamedtablefsfsresults_Internalname ;
   private String tblUnnamedtablecontentfsfsresults_Internalname ;
   private String ROClassString ;
   private String edtavUrl_Jsonclick ;
   private String divTablefscard_Internalname ;
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
   private boolean wcpOAV12DefaultIsAdvancedSearch ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV12DefaultIsAdvancedSearch ;
   private boolean bGXsfl_56_Refreshing=false ;
   private boolean AV23IsAdvancedSearch ;
   private boolean wbLoad ;
   private boolean Combo_advfilterentities_Allowmultipleselection ;
   private boolean Combo_advfilterentities_Includeonlyselectedoption ;
   private boolean Combo_advfilterentities_Emptyitem ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_48_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV48 ;
   private boolean AV17DisplayType4_Image_IsBlob ;
   private String wcpOAV10DeafultSearchText ;
   private String wcpOAV11DefaultAdvFilterEntitiesJson ;
   private String AV10DeafultSearchText ;
   private String AV11DefaultAdvFilterEntitiesJson ;
   private String AV25SearchText ;
   private String AV8AdvFilterText ;
   private String AV26Url ;
   private String AV13DisplayType1_Title ;
   private String AV14DisplayType2_Title ;
   private String AV16DisplayType3_Title ;
   private String AV15DisplayType3_Subtitle ;
   private String AV33Displaytype4_image_GXI ;
   private String AV18DisplayType4_Title ;
   private String AV20DisplayType5_Title ;
   private String AV19DisplayType5_Subtitle ;
   private String AV21EntityDescription ;
   private String AV17DisplayType4_Image ;
   private com.genexus.webpanels.GXWebGrid FsresultcategoriesContainer ;
   private com.genexus.webpanels.GXWebGrid FsresultsContainer ;
   private com.genexus.webpanels.GXWebRow FsresultcategoriesRow ;
   private com.genexus.webpanels.GXWebRow FsresultsRow ;
   private com.genexus.webpanels.GXWebColumn FsresultcategoriesColumn ;
   private com.genexus.webpanels.GXWebColumn FsresultsColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucBtnadvancedsearch ;
   private com.genexus.webpanels.GXUserControl ucCombo_advfilterentities ;
   private com.genexus.webpanels.GXUserControl ucBtnbasicsearch ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV5AdvFilterEntities ;
   private GXSimpleCollection<String> AV22EntityDescriptions ;
   private GXSimpleCollection<String> GXv_objcol_svchar3[] ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV6AdvFilterEntities_Data ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV28WWP_SearchResults ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV27WWP_SearchResultAux ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> GXt_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem5 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> GXv_objcol_SdtWWP_SearchResults_WWP_SearchResultsItem4[] ;
   private com.wwpbaseobjects.SdtDVB_SDTComboData_Item AV7AdvFilterEntities_DataItem ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV9DDO_TitleSettingsIcons ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

