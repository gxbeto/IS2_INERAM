package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class protocoloww_impl extends GXDataArea
{
   public protocoloww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public protocoloww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( protocoloww_impl.class ));
   }

   public protocoloww_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynavEnfid = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "SelectedProtID") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "SelectedProtID") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "SelectedProtID") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            gxnrgrid_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
         {
            gxgrgrid_refresh_invoke( ) ;
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
            AV15SelectedProtID = GXutil.lval( gxfirstwebparm) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15SelectedProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SelectedProtID), 10, 0));
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDPROTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15SelectedProtID), "ZZZZZZZZZ9")));
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

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_23 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_23"))) ;
      nGXsfl_23_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_23_idx"))) ;
      sGXsfl_23_idx = httpContext.GetPar( "sGXsfl_23_idx") ;
      AV13DetailTabCaption = httpContext.GetPar( "DetailTabCaption") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      dynavEnfid.fromJSonString( httpContext.GetNextPar( ));
      AV24EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
      AV31Pgmname = httpContext.GetPar( "Pgmname") ;
      AV25OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV13DetailTabCaption = httpContext.GetPar( "DetailTabCaption") ;
      AV15SelectedProtID = GXutil.lval( httpContext.GetPar( "SelectedProtID")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV24EnfID, AV31Pgmname, AV25OrderedDsc, AV13DetailTabCaption, AV15SelectedProtID) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
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
      pa112( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start112( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/TabsPanel/BootstrapTabsPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.protocoloww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV15SelectedProtID,10,0))}, new String[] {"SelectedProtID"}) +"\">") ;
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
      com.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV31Pgmname));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31Pgmname, ""))));
      com.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDPROTID", GXutil.ltrim( localUtil.ntoc( AV15SelectedProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDPROTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15SelectedProtID), "ZZZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.GxWebStd.gx_hidden_field( httpContext, "GXH_vENFID", GXutil.ltrim( localUtil.ntoc( AV24EnfID, (byte)(10), (byte)(0), ",", "")));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_23", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_23, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV28DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV28DDO_TitleSettingsIcons);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV31Pgmname));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31Pgmname, ""))));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV25OrderedDsc);
      com.GxWebStd.gx_hidden_field( httpContext, "PROTORD", GXutil.ltrim( localUtil.ntoc( A26ProtOrd, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "vDETAILTABLENAME", AV17DetailTableName);
      com.GxWebStd.gx_boolean_hidden_field( httpContext, "vREFRESHGRID", AV22RefreshGrid);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDETAILWCINFO", AV21DetailWCInfo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDETAILWCINFO", AV21DetailWCInfo);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "vLOADDETAILACTION", GXutil.ltrim( localUtil.ntoc( AV18LoadDetailAction, (byte)(1), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDPROTID", GXutil.ltrim( localUtil.ntoc( AV15SelectedProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDPROTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15SelectedProtID), "ZZZZZZZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, "vDETAILWCLINK", AV19DetailWCLink);
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "DETAILTABSCOMPONENT_Width", GXutil.rtrim( Detailtabscomponent_Width));
      com.GxWebStd.gx_hidden_field( httpContext, "DETAILTABSCOMPONENT_Autowidth", GXutil.booltostr( Detailtabscomponent_Autowidth));
      com.GxWebStd.gx_hidden_field( httpContext, "DETAILTABSCOMPONENT_Autoheight", GXutil.booltostr( Detailtabscomponent_Autoheight));
      com.GxWebStd.gx_hidden_field( httpContext, "DETAILTABSCOMPONENT_Autoscroll", GXutil.booltostr( Detailtabscomponent_Autoscroll));
      com.GxWebStd.gx_hidden_field( httpContext, "DETAILTABSCOMPONENT_Cls", GXutil.rtrim( Detailtabscomponent_Cls));
      com.GxWebStd.gx_hidden_field( httpContext, "DETAILTABSCOMPONENT_Excessivetabsbehavior", GXutil.rtrim( Detailtabscomponent_Excessivetabsbehavior));
      com.GxWebStd.gx_hidden_field( httpContext, "DETAILTABSCOMPONENT_Designtimetabs", GXutil.rtrim( Detailtabscomponent_Designtimetabs));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Infinitescrolling", GXutil.rtrim( Grid_empowerer_Infinitescrolling));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
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
         we112( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt112( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.protocoloww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV15SelectedProtID,10,0))}, new String[] {"SelectedProtID"})  ;
   }

   public String getPgmname( )
   {
      return "ProtocoloWW" ;
   }

   public String getPgmdesc( )
   {
      return " Protocolo" ;
   }

   public void wb110( )
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
         com.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table TableWithSelectableGrid", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-lg-4 CellLeftSplitScreen", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTableleft_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTableheader1_Internalname, 1, 0, "px", 0, "px", "TableHeaderSplitScreen", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellNoPaddingHorizontal DscTop", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+dynavEnfid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, dynavEnfid.getInternalname(), "Enfermedad", " AttributeSearchSplitScreenLabel", 1, true, "");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'" + sGXsfl_23_idx + "',0)\"" ;
         /* ComboBox */
         com.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEnfid, dynavEnfid.getInternalname(), GXutil.trim( GXutil.str( AV24EnfID, 10, 0)), 1, dynavEnfid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEnfid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeSearchSplitScreen", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,17);\"", "", true, (byte)(0), "HLP_ProtocoloWW.htm");
         dynavEnfid.setValue( GXutil.trim( GXutil.str( AV24EnfID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEnfid.getInternalname(), "Values", dynavEnfid.ToJavascriptSource(), true);
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "start", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol23( ) ;
      }
      if ( wbEnd == 23 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_23 = (int)(nGXsfl_23_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-lg-8 CellWCSplitScreen CellWCSplitScreenWithTabs", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divHtml_tabs_detailtabscomponent_Internalname, 1, 0, "px", 0, "px", "Section", "start", "top", "", "", "div");
         /* User Defined Control */
         ucDetailtabscomponent.setProperty("Width", Detailtabscomponent_Width);
         ucDetailtabscomponent.setProperty("AutoWidth", Detailtabscomponent_Autowidth);
         ucDetailtabscomponent.setProperty("AutoHeight", Detailtabscomponent_Autoheight);
         ucDetailtabscomponent.setProperty("AutoScroll", Detailtabscomponent_Autoscroll);
         ucDetailtabscomponent.setProperty("Cls", Detailtabscomponent_Cls);
         ucDetailtabscomponent.setProperty("ExcessiveTabsBehavior", Detailtabscomponent_Excessivetabsbehavior);
         ucDetailtabscomponent.setProperty("DesignTimeTabs", Detailtabscomponent_Designtimetabs);
         ucDetailtabscomponent.render(context, "dvelop.gxbootstrap.tabspanel", Detailtabscomponent_Internalname, "DETAILTABSCOMPONENTContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "start", "top", "", "", "div");
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV28DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("InfiniteScrolling", Grid_empowerer_Infinitescrolling);
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 23 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start112( )
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
      Form.getMeta().addItem("description", " Protocolo", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup110( ) ;
   }

   public void ws112( )
   {
      start112( ) ;
      evt112( ) ;
   }

   public void evt112( )
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
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11112 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           AV30Protocolowwds_1_enfid = AV24EnfID ;
                           sEvt = httpContext.cgiGet( "GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_23_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_232( ) ;
                           A23CntdID = localUtil.ctol( httpContext.cgiGet( edtCntdID_Internalname), ",", ".") ;
                           n23CntdID = false ;
                           A24CntdDesc = httpContext.cgiGet( edtCntdDesc_Internalname) ;
                           AV13DetailTabCaption = httpContext.cgiGet( edtavDetailtabcaption_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDetailtabcaption_Internalname, AV13DetailTabCaption);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e12112 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e13112 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e14112 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Enfid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vENFID"), ",", ".") != AV24EnfID )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
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

   public void we112( )
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

   public void pa112( )
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
            GX_FocusControl = dynavEnfid.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvenfid111( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvenfid_data111( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvenfid_html111( )
   {
      long gxdynajaxvalue;
      gxdlvvenfid_data111( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEnfid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex)) ;
         dynavEnfid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 10, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV24EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV24EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
      }
   }

   protected void gxdlvvenfid_data111( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00112 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00112_A1EnfID[0], (byte)(10), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(GXutil.rtrim( H00112_A2EnfNombre[0]));
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxnrgrid_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_232( ) ;
      while ( nGXsfl_23_idx <= nRC_GXsfl_23 )
      {
         sendrow_232( ) ;
         nGXsfl_23_idx = ((subGrid_Islastpage==1)&&(nGXsfl_23_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_23_idx+1) ;
         sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_232( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 long AV24EnfID ,
                                 String AV31Pgmname ,
                                 boolean AV25OrderedDsc ,
                                 String AV13DetailTabCaption ,
                                 long AV15SelectedProtID )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID_nCurrentRecord = 0 ;
      rf112( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEnfid.setName( "vENFID" );
         dynavEnfid.setWebtags( "" );
         dynavEnfid.removeAllItems();
         /* Using cursor H00113 */
         pr_default.execute(1);
         while ( (pr_default.getStatus(1) != 101) )
         {
            dynavEnfid.addItem(GXutil.trim( GXutil.str( H00113_A1EnfID[0], 10, 0)), H00113_A2EnfNombre[0], (short)(0));
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( dynavEnfid.getItemCount() > 0 )
         {
            AV24EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV24EnfID, 10, 0)))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV24EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV24EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEnfid.setValue( GXutil.trim( GXutil.str( AV24EnfID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEnfid.getInternalname(), "Values", dynavEnfid.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      GRID_nCurrentRecord = 0 ;
      GXCCtl = "GRID_nFirstRecordOnPage_" + sGXsfl_23_idx ;
      com.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      send_integrity_hashes( ) ;
      rf112( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV31Pgmname = "ProtocoloWW" ;
      edtavDetailtabcaption_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDetailtabcaption_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDetailtabcaption_Enabled), 5, 0), !bGXsfl_23_Refreshing);
   }

   public void rf112( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(23) ;
      /* Execute user event: Refresh */
      e13112 ();
      nGXsfl_23_idx = (int)(1+GRID_nFirstRecordOnPage) ;
      sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_232( ) ;
      bGXsfl_23_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "WorkWithSelection WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_232( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(2, new Object[]{ new Object[]{
                                              Long.valueOf(AV30Protocolowwds_1_enfid) ,
                                              Long.valueOf(A1EnfID) ,
                                              Boolean.valueOf(AV25OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN
                                              }
         });
         /* Using cursor H00114 */
         pr_default.execute(2, new Object[] {Long.valueOf(AV30Protocolowwds_1_enfid), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_23_idx = (int)(1+GRID_nFirstRecordOnPage) ;
         sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_232( ) ;
         while ( ( (pr_default.getStatus(2) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1EnfID = H00114_A1EnfID[0] ;
            n1EnfID = H00114_n1EnfID[0] ;
            A26ProtOrd = H00114_A26ProtOrd[0] ;
            n26ProtOrd = H00114_n26ProtOrd[0] ;
            A24CntdDesc = H00114_A24CntdDesc[0] ;
            A23CntdID = H00114_A23CntdID[0] ;
            n23CntdID = H00114_n23CntdID[0] ;
            A25ProtID = H00114_A25ProtID[0] ;
            A24CntdDesc = H00114_A24CntdDesc[0] ;
            e14112 ();
            pr_default.readNext(2);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(2) == 101) ? 1 : 0)) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(2);
         wbEnd = (short)(23) ;
         wb110( ) ;
      }
      bGXsfl_23_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes112( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV31Pgmname));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31Pgmname, ""))));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID_nRecordCount).divide(DecimalUtil.doubleToDec(subgrid_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))) ;
      }
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID_nRecordCount).divide(DecimalUtil.doubleToDec(subgrid_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      AV30Protocolowwds_1_enfid = AV24EnfID ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           Long.valueOf(AV30Protocolowwds_1_enfid) ,
                                           Long.valueOf(A1EnfID) ,
                                           Boolean.valueOf(AV25OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor H00115 */
      pr_default.execute(3, new Object[] {Long.valueOf(AV30Protocolowwds_1_enfid)});
      GRID_nRecordCount = H00115_AGRID_nRecordCount[0] ;
      pr_default.close(3);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID_nFirstRecordOnPage).divide(DecimalUtil.doubleToDec(subgrid_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public short subgrid_firstpage( )
   {
      AV30Protocolowwds_1_enfid = AV24EnfID ;
      GRID_nFirstRecordOnPage = 0 ;
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV24EnfID, AV31Pgmname, AV25OrderedDsc, AV13DetailTabCaption, AV15SelectedProtID) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV30Protocolowwds_1_enfid = AV24EnfID ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      if ( GRID_nEOF == 1 )
      {
         GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV24EnfID, AV31Pgmname, AV25OrderedDsc, AV13DetailTabCaption, AV15SelectedProtID) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV30Protocolowwds_1_enfid = AV24EnfID ;
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV24EnfID, AV31Pgmname, AV25OrderedDsc, AV13DetailTabCaption, AV15SelectedProtID) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV30Protocolowwds_1_enfid = AV24EnfID ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV24EnfID, AV31Pgmname, AV25OrderedDsc, AV13DetailTabCaption, AV15SelectedProtID) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV30Protocolowwds_1_enfid = AV24EnfID ;
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV24EnfID, AV31Pgmname, AV25OrderedDsc, AV13DetailTabCaption, AV15SelectedProtID) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV31Pgmname = "ProtocoloWW" ;
      edtavDetailtabcaption_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDetailtabcaption_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDetailtabcaption_Enabled), 5, 0), !bGXsfl_23_Refreshing);
      edtCntdID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCntdID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdID_Enabled), 5, 0), !bGXsfl_23_Refreshing);
      edtCntdDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCntdDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdDesc_Enabled), 5, 0), !bGXsfl_23_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup110( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12112 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV28DDO_TitleSettingsIcons);
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vDETAILWCINFO"), AV21DetailWCInfo);
         /* Read saved values. */
         nRC_GXsfl_23 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_23"), ",", ".")) ;
         AV22RefreshGrid = GXutil.strtobool( httpContext.cgiGet( "vREFRESHGRID")) ;
         AV18LoadDetailAction = (byte)(localUtil.ctol( httpContext.cgiGet( "vLOADDETAILACTION"), ",", ".")) ;
         AV19DetailWCLink = httpContext.cgiGet( "vDETAILWCLINK") ;
         AV17DetailTableName = httpContext.cgiGet( "vDETAILTABLENAME") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), ",", ".") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), ",", ".")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Detailtabscomponent_Width = httpContext.cgiGet( "DETAILTABSCOMPONENT_Width") ;
         Detailtabscomponent_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DETAILTABSCOMPONENT_Autowidth")) ;
         Detailtabscomponent_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DETAILTABSCOMPONENT_Autoheight")) ;
         Detailtabscomponent_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DETAILTABSCOMPONENT_Autoscroll")) ;
         Detailtabscomponent_Cls = httpContext.cgiGet( "DETAILTABSCOMPONENT_Cls") ;
         Detailtabscomponent_Excessivetabsbehavior = httpContext.cgiGet( "DETAILTABSCOMPONENT_Excessivetabsbehavior") ;
         Detailtabscomponent_Designtimetabs = httpContext.cgiGet( "DETAILTABSCOMPONENT_Designtimetabs") ;
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Infinitescrolling = httpContext.cgiGet( "GRID_EMPOWERER_Infinitescrolling") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         /* Read variables values. */
         dynavEnfid.setName( dynavEnfid.getInternalname() );
         dynavEnfid.setValue( httpContext.cgiGet( dynavEnfid.getInternalname()) );
         AV24EnfID = GXutil.lval( httpContext.cgiGet( dynavEnfid.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
         /* Read subfile selected row values. */
         nGXsfl_23_idx = (int)(localUtil.cton( httpContext.cgiGet( subGrid_Internalname+"_ROW"), ",", ".")) ;
         sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_232( ) ;
         if ( nGXsfl_23_idx > 0 )
         {
            A23CntdID = localUtil.ctol( httpContext.cgiGet( edtCntdID_Internalname), ",", ".") ;
            n23CntdID = false ;
            A24CntdDesc = httpContext.cgiGet( edtCntdDesc_Internalname) ;
            AV13DetailTabCaption = httpContext.cgiGet( edtavDetailtabcaption_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDetailtabcaption_Internalname, AV13DetailTabCaption);
         }
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vENFID"), ",", ".") != AV24EnfID )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e12112 ();
      if (returnInSub) return;
   }

   public void e12112( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 50 ;
      com.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Protocolo" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV28DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0];
      AV28DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      if ( ! (0==AV15SelectedProtID) )
      {
         /* Using cursor H00116 */
         pr_default.execute(4, new Object[] {Long.valueOf(AV15SelectedProtID)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A25ProtID = H00116_A25ProtID[0] ;
            A26ProtOrd = H00116_A26ProtOrd[0] ;
            n26ProtOrd = H00116_n26ProtOrd[0] ;
            AV13DetailTabCaption = GXutil.str( A26ProtOrd, 4, 0) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDetailtabcaption_Internalname, AV13DetailTabCaption);
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
      }
   }

   public void e13112( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0];
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      AV30Protocolowwds_1_enfid = AV24EnfID ;
   }

   public void e11112( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV25OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25OrderedDsc", AV25OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e14112( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV13DetailTabCaption = GXutil.str( A26ProtOrd, 4, 0) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDetailtabcaption_Internalname, AV13DetailTabCaption);
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(23) ;
      }
      sendrow_232( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_23_Refreshing )
      {
         httpContext.doAjaxLoad(23, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = "-1:"+(AV25OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV14Session.getValue(AV31Pgmname+"GridState"), "") == 0 )
      {
         AV10GridState.fromxml(new com.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV31Pgmname+"GridState"), null, null);
      }
      else
      {
         AV10GridState.fromxml(AV14Session.getValue(AV31Pgmname+"GridState"), null, null);
      }
      AV25OrderedDsc = AV10GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25OrderedDsc", AV25OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      AV32GXV1 = 1 ;
      while ( AV32GXV1 <= AV10GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV11GridStateFilterValue = (com.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.wwpbaseobjects.SdtWWPGridState_FilterValue)AV10GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV32GXV1));
         if ( GXutil.strcmp(AV11GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "ENFID") == 0 )
         {
            AV24EnfID = GXutil.lval( AV11GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
         }
         AV32GXV1 = (int)(AV32GXV1+1) ;
      }
   }

   public void S132( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV10GridState.fromxml(AV14Session.getValue(AV31Pgmname+"GridState"), null, null);
      AV10GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV25OrderedDsc );
      AV10GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState4[0] = AV10GridState;
      new com.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState4, "ENFID", "", !(0==AV24EnfID), (short)(0), GXutil.trim( GXutil.str( AV24EnfID, 10, 0)), GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24EnfID), "ZZZZZZZZZ9")), false, "", "") ;
      AV10GridState = GXv_SdtWWPGridState4[0];
      new com.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV31Pgmname+"GridState", AV10GridState.toxml(false, true, "WWPGridState", "Gregory")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV8TrnContext = (com.wwpbaseobjects.SdtWWPTransactionContext)new com.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV31Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV7HTTPRequest.getScriptName()+"?"+AV7HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Protocolo" );
      AV14Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "Gregory"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV15SelectedProtID = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15SelectedProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SelectedProtID), 10, 0));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDPROTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15SelectedProtID), "ZZZZZZZZZ9")));
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
      pa112( ) ;
      ws112( ) ;
      we112( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617171862", true, true);
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
      httpContext.AddJavascriptSource("protocoloww.js", "?202442617171862", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/TabsPanel/BootstrapTabsPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_232( )
   {
      edtCntdID_Internalname = "CNTDID_"+sGXsfl_23_idx ;
      edtCntdDesc_Internalname = "CNTDDESC_"+sGXsfl_23_idx ;
      edtavDetailtabcaption_Internalname = "vDETAILTABCAPTION_"+sGXsfl_23_idx ;
   }

   public void subsflControlProps_fel_232( )
   {
      edtCntdID_Internalname = "CNTDID_"+sGXsfl_23_fel_idx ;
      edtCntdDesc_Internalname = "CNTDDESC_"+sGXsfl_23_fel_idx ;
      edtavDetailtabcaption_Internalname = "vDETAILTABCAPTION_"+sGXsfl_23_fel_idx ;
   }

   public void sendrow_232( )
   {
      subsflControlProps_232( ) ;
      wb110( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_23_idx - GRID_nFirstRecordOnPage <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_23_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWithSelection WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_23_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"end"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCntdID_Internalname,GXutil.ltrim( localUtil.ntoc( A23CntdID, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A23CntdID), "ZZZZZZZZZ9"))," dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCntdID_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Secuence","end",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCntdDesc_Internalname,GXutil.rtrim( A24CntdDesc),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCntdDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDetailtabcaption_Internalname,AV13DetailTabCaption,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDetailtabcaption_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavDetailtabcaption_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes112( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_23_idx = ((subGrid_Islastpage==1)&&(nGXsfl_23_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_23_idx+1) ;
         sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_232( ) ;
      }
      /* End function sendrow_232 */
   }

   public void startgridcontrol23( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"23\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "WorkWithSelection WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            subGrid_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid_Class) > 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Title" ;
            }
         }
         else
         {
            subGrid_Titlebackstyle = (byte)(1) ;
            if ( subGrid_Backcolorstyle == 1 )
            {
               subGrid_Titlebackcolor = subGrid_Allbackcolor ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"end"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "ID") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"start"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Tipo de Contenido") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"start"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "WorkWithSelection WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A23CntdID, (byte)(10), (byte)(0), ".", ""))));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( A24CntdDesc)));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV13DetailTabCaption));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDetailtabcaption_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      dynavEnfid.setInternalname( "vENFID" );
      divTableheader1_Internalname = "TABLEHEADER1" ;
      edtCntdID_Internalname = "CNTDID" ;
      edtCntdDesc_Internalname = "CNTDDESC" ;
      edtavDetailtabcaption_Internalname = "vDETAILTABCAPTION" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divTableleft_Internalname = "TABLELEFT" ;
      Detailtabscomponent_Internalname = "DETAILTABSCOMPONENT" ;
      divHtml_tabs_detailtabscomponent_Internalname = "HTML_TABS_DETAILTABSCOMPONENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowhovering = (byte)(0) ;
      subGrid_Allowselection = (byte)(1) ;
      subGrid_Header = "" ;
      edtavDetailtabcaption_Jsonclick = "" ;
      edtavDetailtabcaption_Enabled = 0 ;
      edtCntdDesc_Jsonclick = "" ;
      edtCntdID_Jsonclick = "" ;
      subGrid_Class = "WorkWithSelection WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtCntdDesc_Enabled = 0 ;
      edtCntdID_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      dynavEnfid.setJsonclick( "" );
      dynavEnfid.setEnabled( 1 );
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Grid_empowerer_Infinitescrolling = "Grid" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "-1" ;
      Ddo_grid_Columnids = "1:CntdDesc" ;
      Ddo_grid_Gridinternalname = "" ;
      Detailtabscomponent_Designtimetabs = "[]" ;
      Detailtabscomponent_Excessivetabsbehavior = "Slider" ;
      Detailtabscomponent_Cls = "" ;
      Detailtabscomponent_Autoscroll = GXutil.toBoolean( -1) ;
      Detailtabscomponent_Autoheight = GXutil.toBoolean( -1) ;
      Detailtabscomponent_Autowidth = GXutil.toBoolean( 0) ;
      Detailtabscomponent_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Protocolo" );
      subGrid_Rows = 50 ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      dynavEnfid.setName( "vENFID" );
      dynavEnfid.setWebtags( "" );
      dynavEnfid.removeAllItems();
      /* Using cursor H00117 */
      pr_default.execute(5);
      while ( (pr_default.getStatus(5) != 101) )
      {
         dynavEnfid.addItem(GXutil.trim( GXutil.str( H00117_A1EnfID[0], 10, 0)), H00117_A2EnfNombre[0], (short)(0));
         pr_default.readNext(5);
      }
      pr_default.close(5);
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV24EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV24EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13DetailTabCaption',fld:'vDETAILTABCAPTION',pic:''},{av:'AV25OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'AV31Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15SelectedProtID',fld:'vSELECTEDPROTID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e11112',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'AV31Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV25OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV13DetailTabCaption',fld:'vDETAILTABCAPTION',pic:''},{av:'AV15SelectedProtID',fld:'vSELECTEDPROTID',pic:'ZZZZZZZZZ9',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV25OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e14112',iparms:[{av:'A26ProtOrd',fld:'PROTORD',pic:'ZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV13DetailTabCaption',fld:'vDETAILTABCAPTION',pic:''}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13DetailTabCaption',fld:'vDETAILTABCAPTION',pic:''},{av:'AV15SelectedProtID',fld:'vSELECTEDPROTID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV31Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV25OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13DetailTabCaption',fld:'vDETAILTABCAPTION',pic:''},{av:'AV15SelectedProtID',fld:'vSELECTEDPROTID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV31Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV25OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13DetailTabCaption',fld:'vDETAILTABCAPTION',pic:''},{av:'AV15SelectedProtID',fld:'vSELECTEDPROTID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV31Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV25OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13DetailTabCaption',fld:'vDETAILTABCAPTION',pic:''},{av:'AV15SelectedProtID',fld:'vSELECTEDPROTID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV31Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV25OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALID_CNTDID","{handler:'valid_Cntdid',iparms:[]");
      setEventMetadata("VALID_CNTDID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Detailtabcaption',iparms:[]");
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
      Ddo_grid_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV13DetailTabCaption = "" ;
      AV31Pgmname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV28DDO_TitleSettingsIcons = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV17DetailTableName = "" ;
      AV21DetailWCInfo = new com.wwpbaseobjects.SdtSplitScreenDetailInfo(remoteHandle, context);
      AV19DetailWCLink = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucDetailtabscomponent = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A24CntdDesc = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      H00112_A1EnfID = new long[1] ;
      H00112_n1EnfID = new boolean[] {false} ;
      H00112_A2EnfNombre = new String[] {""} ;
      H00112_n2EnfNombre = new boolean[] {false} ;
      H00113_A1EnfID = new long[1] ;
      H00113_n1EnfID = new boolean[] {false} ;
      H00113_A2EnfNombre = new String[] {""} ;
      H00113_n2EnfNombre = new boolean[] {false} ;
      GXCCtl = "" ;
      H00114_A1EnfID = new long[1] ;
      H00114_n1EnfID = new boolean[] {false} ;
      H00114_A26ProtOrd = new short[1] ;
      H00114_n26ProtOrd = new boolean[] {false} ;
      H00114_A24CntdDesc = new String[] {""} ;
      H00114_A23CntdID = new long[1] ;
      H00114_n23CntdID = new boolean[] {false} ;
      H00114_A25ProtID = new long[1] ;
      H00115_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      H00116_A25ProtID = new long[1] ;
      H00116_A26ProtOrd = new short[1] ;
      H00116_n26ProtOrd = new boolean[] {false} ;
      AV6WWPContext = new com.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV14Session = httpContext.getWebSession();
      AV10GridState = new com.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV11GridStateFilterValue = new com.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState4 = new com.wwpbaseobjects.SdtWWPGridState[1] ;
      AV8TrnContext = new com.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV7HTTPRequest = httpContext.getHttpRequest();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      H00117_A1EnfID = new long[1] ;
      H00117_n1EnfID = new boolean[] {false} ;
      H00117_A2EnfNombre = new String[] {""} ;
      H00117_n2EnfNombre = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.protocoloww__default(),
         new Object[] {
             new Object[] {
            H00112_A1EnfID, H00112_A2EnfNombre, H00112_n2EnfNombre
            }
            , new Object[] {
            H00113_A1EnfID, H00113_A2EnfNombre, H00113_n2EnfNombre
            }
            , new Object[] {
            H00114_A1EnfID, H00114_n1EnfID, H00114_A26ProtOrd, H00114_n26ProtOrd, H00114_A24CntdDesc, H00114_A23CntdID, H00114_n23CntdID, H00114_A25ProtID
            }
            , new Object[] {
            H00115_AGRID_nRecordCount
            }
            , new Object[] {
            H00116_A25ProtID, H00116_A26ProtOrd, H00116_n26ProtOrd
            }
            , new Object[] {
            H00117_A1EnfID, H00117_A2EnfNombre, H00117_n2EnfNombre
            }
         }
      );
      AV31Pgmname = "ProtocoloWW" ;
      /* GeneXus formulas. */
      AV31Pgmname = "ProtocoloWW" ;
      edtavDetailtabcaption_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV18LoadDetailAction ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short A26ProtOrd ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int nRC_GXsfl_23 ;
   private int subGrid_Rows ;
   private int nGXsfl_23_idx=1 ;
   private int gxdynajaxindex ;
   private int subGrid_Islastpage ;
   private int edtavDetailtabcaption_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int edtCntdID_Enabled ;
   private int edtCntdDesc_Enabled ;
   private int AV32GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long wcpOAV15SelectedProtID ;
   private long GRID_nFirstRecordOnPage ;
   private long AV15SelectedProtID ;
   private long AV24EnfID ;
   private long AV30Protocolowwds_1_enfid ;
   private long A23CntdID ;
   private long GRID_nCurrentRecord ;
   private long A1EnfID ;
   private long A25ProtID ;
   private long GRID_nRecordCount ;
   private String Ddo_grid_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_23_idx="0001" ;
   private String AV31Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Detailtabscomponent_Width ;
   private String Detailtabscomponent_Cls ;
   private String Detailtabscomponent_Excessivetabsbehavior ;
   private String Detailtabscomponent_Designtimetabs ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Grid_empowerer_Gridinternalname ;
   private String Grid_empowerer_Infinitescrolling ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableleft_Internalname ;
   private String divTableheader1_Internalname ;
   private String TempTags ;
   private String divUnnamedtable1_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String divHtml_tabs_detailtabscomponent_Internalname ;
   private String Detailtabscomponent_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtCntdID_Internalname ;
   private String A24CntdDesc ;
   private String edtCntdDesc_Internalname ;
   private String edtavDetailtabcaption_Internalname ;
   private String gxwrpcisep ;
   private String GXCCtl ;
   private String sGXsfl_23_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCntdID_Jsonclick ;
   private String edtCntdDesc_Jsonclick ;
   private String edtavDetailtabcaption_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV25OrderedDsc ;
   private boolean AV22RefreshGrid ;
   private boolean Detailtabscomponent_Autowidth ;
   private boolean Detailtabscomponent_Autoheight ;
   private boolean Detailtabscomponent_Autoscroll ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n23CntdID ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_23_Refreshing=false ;
   private boolean n1EnfID ;
   private boolean n26ProtOrd ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String AV13DetailTabCaption ;
   private String AV17DetailTableName ;
   private String AV19DetailWCLink ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV7HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV14Session ;
   private com.genexus.webpanels.GXUserControl ucDetailtabscomponent ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private HTMLChoice dynavEnfid ;
   private IDataStoreProvider pr_default ;
   private long[] H00112_A1EnfID ;
   private boolean[] H00112_n1EnfID ;
   private String[] H00112_A2EnfNombre ;
   private boolean[] H00112_n2EnfNombre ;
   private long[] H00113_A1EnfID ;
   private boolean[] H00113_n1EnfID ;
   private String[] H00113_A2EnfNombre ;
   private boolean[] H00113_n2EnfNombre ;
   private long[] H00114_A1EnfID ;
   private boolean[] H00114_n1EnfID ;
   private short[] H00114_A26ProtOrd ;
   private boolean[] H00114_n26ProtOrd ;
   private String[] H00114_A24CntdDesc ;
   private long[] H00114_A23CntdID ;
   private boolean[] H00114_n23CntdID ;
   private long[] H00114_A25ProtID ;
   private long[] H00115_AGRID_nRecordCount ;
   private long[] H00116_A25ProtID ;
   private short[] H00116_A26ProtOrd ;
   private boolean[] H00116_n26ProtOrd ;
   private long[] H00117_A1EnfID ;
   private boolean[] H00117_n1EnfID ;
   private String[] H00117_A2EnfNombre ;
   private boolean[] H00117_n2EnfNombre ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
   private com.wwpbaseobjects.SdtWWPGridState AV10GridState ;
   private com.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState4[] ;
   private com.wwpbaseobjects.SdtWWPGridState_FilterValue AV11GridStateFilterValue ;
   private com.wwpbaseobjects.SdtSplitScreenDetailInfo AV21DetailWCInfo ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV28DDO_TitleSettingsIcons ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class protocoloww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00114( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          long AV30Protocolowwds_1_enfid ,
                                          long A1EnfID ,
                                          boolean AV25OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[4];
      Object[] GXv_Object6 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.EnfID, T1.ProtOrd, T2.CntdDesc, T1.CntdID, T1.ProtID" ;
      sFromString = " FROM (Protocolo T1 LEFT JOIN Contenidos T2 ON T2.CntdID = T1.CntdID)" ;
      sOrderString = "" ;
      if ( ! (0==AV30Protocolowwds_1_enfid) )
      {
         addWhere(sWhereString, "(T1.EnfID >= ?)");
      }
      else
      {
         GXv_int5[0] = (byte)(1) ;
      }
      if ( ! AV25OrderedDsc )
      {
         sOrderString += " ORDER BY T2.CntdDesc, T1.ProtID" ;
      }
      else if ( AV25OrderedDsc )
      {
         sOrderString += " ORDER BY T2.CntdDesc DESC, T1.ProtID" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.ProtID" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
   }

   protected Object[] conditional_H00115( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          long AV30Protocolowwds_1_enfid ,
                                          long A1EnfID ,
                                          boolean AV25OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[1];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (Protocolo T1 LEFT JOIN Contenidos T2 ON T2.CntdID = T1.CntdID)" ;
      if ( ! (0==AV30Protocolowwds_1_enfid) )
      {
         addWhere(sWhereString, "(T1.EnfID >= ?)");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ! AV25OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( AV25OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 2 :
                  return conditional_H00114(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).longValue() , ((Number) dynConstraints[1]).longValue() , ((Boolean) dynConstraints[2]).booleanValue() );
            case 3 :
                  return conditional_H00115(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).longValue() , ((Number) dynConstraints[1]).longValue() , ((Boolean) dynConstraints[2]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00112", "SELECT EnfID, EnfNombre FROM Enfermedades ORDER BY EnfNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00113", "SELECT EnfID, EnfNombre FROM Enfermedades ORDER BY EnfNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00114", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,51, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00115", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00116", "SELECT ProtID, ProtOrd FROM Protocolo WHERE ProtID = ? ORDER BY ProtID ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00117", "SELECT EnfID, EnfNombre FROM Enfermedades ORDER BY EnfNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 60);
               ((long[]) buf[5])[0] = rslt.getLong(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((long[]) buf[7])[0] = rslt.getLong(5);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[4]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[1]).longValue());
               }
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

