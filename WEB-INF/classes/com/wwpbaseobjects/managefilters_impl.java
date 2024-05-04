package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class managefilters_impl extends GXDataArea
{
   public managefilters_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public managefilters_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( managefilters_impl.class ));
   }

   public managefilters_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavCollectionisempty = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "UserKey") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "UserKey") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "UserKey") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridgridstatecollections") == 0 )
         {
            gxnrgridgridstatecollections_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridgridstatecollections") == 0 )
         {
            gxgrgridgridstatecollections_refresh_invoke( ) ;
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
            AV14UserKey = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14UserKey", AV14UserKey);
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14UserKey, ""))));
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

   public void gxnrgridgridstatecollections_newrow_invoke( )
   {
      nRC_GXsfl_15 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_15"))) ;
      nGXsfl_15_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_15_idx"))) ;
      sGXsfl_15_idx = httpContext.GetPar( "sGXsfl_15_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridgridstatecollections_newrow( ) ;
      /* End function gxnrGridgridstatecollections_newrow_invoke */
   }

   public void gxgrgridgridstatecollections_refresh_invoke( )
   {
      subGridgridstatecollections_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridgridstatecollections_Rows"))) ;
      AV14UserKey = httpContext.GetPar( "UserKey") ;
      AV5CollectionIsEmpty = GXutil.strtobool( httpContext.GetPar( "CollectionIsEmpty")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridgridstatecollections_refresh_invoke */
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
      pa0G2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0G2( ) ;
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
      httpContext.AddJavascriptSource("shared/jquery/jquery1.9.1.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/bootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14UserKey))}, new String[] {"UserKey"}) +"\">") ;
      com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormNoBackgroundColor", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "vUSERKEY", AV14UserKey);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14UserKey, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Gridstatecollection", AV6GridStateCollection);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Gridstatecollection", AV6GridStateCollection);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_15", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_15, (byte)(8), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "vUSERKEY", AV14UserKey);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14UserKey, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATECOLLECTION", AV6GridStateCollection);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATECOLLECTION", AV6GridStateCollection);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDGRIDSTATECOLLECTIONS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Rows, (byte)(6), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridgridstatecollections_empowerer_Gridinternalname));
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
         com.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormNoBackgroundColor" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we0G2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0G2( ) ;
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
      return formatLink("com.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14UserKey))}, new String[] {"UserKey"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.ManageFilters" ;
   }

   public String getPgmdesc( )
   {
      return "Gestionador de filtros" ;
   }

   public void wb0G0( )
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
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "start", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransaction", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 PopupContentCell", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContent", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 EditableGridCell_LinedAtts HasGridEmpowerer", "start", "top", "", "", "div");
         /*  Grid Control  */
         GridgridstatecollectionsContainer.SetWrapped(nGXWrapped);
         startgridcontrol15( ) ;
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_15 = (int)(nGXsfl_15_idx-1) ;
         if ( GridgridstatecollectionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridgridstatecollectionsContainer.AddObjectProperty("GRIDGRIDSTATECOLLECTIONS_nEOF", GRIDGRIDSTATECOLLECTIONS_nEOF);
            GridgridstatecollectionsContainer.AddObjectProperty("GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage", GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage);
            AV15GXV1 = nGXsfl_15_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridgridstatecollectionsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridgridstatecollections", GridgridstatecollectionsContainer, subGridgridstatecollections_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "GridgridstatecollectionsContainerData", GridgridstatecollectionsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "GridgridstatecollectionsContainerData"+"V", GridgridstatecollectionsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridgridstatecollectionsContainerData"+"V"+"\" value='"+GridgridstatecollectionsContainer.GridValuesHidden()+"'/>") ;
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
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupRight", "start", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Guardar", bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/ManageFilters.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Cancelar", bttBtncancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/ManageFilters.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divHtml_usertable_utpaneldummy_Internalname, 1, 0, "px", 0, "px", "Section", "start", "top", "", "", "div");
         wb_table1_31_0G2( true) ;
      }
      else
      {
         wb_table1_31_0G2( false) ;
      }
      return  ;
   }

   public void wb_table1_31_0G2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'" + sGXsfl_15_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCollectionisempty.getInternalname(), GXutil.booltostr( AV5CollectionIsEmpty), "", "", chkavCollectionisempty.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(39, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,39);\"");
         /* User Defined Control */
         ucGridgridstatecollections_empowerer.render(context, "wwp.gridempowerer", Gridgridstatecollections_empowerer_Internalname, "GRIDGRIDSTATECOLLECTIONS_EMPOWERERContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridgridstatecollectionsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridgridstatecollectionsContainer.AddObjectProperty("GRIDGRIDSTATECOLLECTIONS_nEOF", GRIDGRIDSTATECOLLECTIONS_nEOF);
               GridgridstatecollectionsContainer.AddObjectProperty("GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage", GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage);
               AV15GXV1 = nGXsfl_15_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridgridstatecollectionsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridgridstatecollections", GridgridstatecollectionsContainer, subGridgridstatecollections_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "GridgridstatecollectionsContainerData", GridgridstatecollectionsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "GridgridstatecollectionsContainerData"+"V", GridgridstatecollectionsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridgridstatecollectionsContainerData"+"V"+"\" value='"+GridgridstatecollectionsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start0G2( )
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
      Form.getMeta().addItem("description", "Gestionador de filtros", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0G0( ) ;
   }

   public void ws0G2( )
   {
      start0G2( ) ;
      evt0G2( ) ;
   }

   public void evt0G2( )
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
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                                 /* Execute user event: Enter */
                                 e110G2 ();
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
                        else if ( GXutil.strcmp(sEvt, "GRIDGRIDSTATECOLLECTIONSPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDGRIDSTATECOLLECTIONSPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridgridstatecollections_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridgridstatecollections_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridgridstatecollections_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridgridstatecollections_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDGRIDSTATECOLLECTIONS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "VMOVEUP.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VMOVEDOWN.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 14), "VUDELETE.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "VMOVEUP.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VMOVEDOWN.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 14), "VUDELETE.CLICK") == 0 ) )
                        {
                           nGXsfl_15_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_152( ) ;
                           AV15GXV1 = (int)(nGXsfl_15_idx+GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage) ;
                           if ( ( AV6GridStateCollection.size() >= AV15GXV1 ) && ( AV15GXV1 > 0 ) )
                           {
                              AV6GridStateCollection.currentItem( ((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)) );
                              AV12MoveUp = httpContext.cgiGet( edtavMoveup_Internalname) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavMoveup_Internalname, AV12MoveUp);
                              AV11MoveDown = httpContext.cgiGet( edtavMovedown_Internalname) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavMovedown_Internalname, AV11MoveDown);
                              AV13UDelete = httpContext.cgiGet( edtavUdelete_Internalname) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavUdelete_Internalname, AV13UDelete);
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e120G2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDGRIDSTATECOLLECTIONS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e130G2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e140G2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VMOVEUP.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e150G2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VMOVEDOWN.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e160G2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VUDELETE.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e170G2 ();
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

   public void we0G2( )
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

   public void pa0G2( )
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
            GX_FocusControl = chkavCollectionisempty.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridgridstatecollections_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_152( ) ;
      while ( nGXsfl_15_idx <= nRC_GXsfl_15 )
      {
         sendrow_152( ) ;
         nGXsfl_15_idx = ((subGridgridstatecollections_Islastpage==1)&&(nGXsfl_15_idx+1>subgridgridstatecollections_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridgridstatecollectionsContainer)) ;
      /* End function gxnrGridgridstatecollections_newrow */
   }

   public void gxgrgridgridstatecollections_refresh( int subGridgridstatecollections_Rows ,
                                                     String AV14UserKey ,
                                                     boolean AV5CollectionIsEmpty )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDGRIDSTATECOLLECTIONS_nCurrentRecord = 0 ;
      rf0G2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridgridstatecollections_refresh */
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
      AV5CollectionIsEmpty = GXutil.strtobool( GXutil.booltostr( AV5CollectionIsEmpty)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CollectionIsEmpty", AV5CollectionIsEmpty);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0G2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavMoveup_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMoveup_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMoveup_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavMovedown_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMovedown_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMovedown_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavUdelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUdelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUdelete_Enabled), 5, 0), !bGXsfl_15_Refreshing);
   }

   public void rf0G2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridgridstatecollectionsContainer.ClearRows();
      }
      wbStart = (short)(15) ;
      /* Execute user event: Refresh */
      e140G2 ();
      nGXsfl_15_idx = 1 ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      bGXsfl_15_Refreshing = true ;
      GridgridstatecollectionsContainer.AddObjectProperty("GridName", "Gridgridstatecollections");
      GridgridstatecollectionsContainer.AddObjectProperty("CmpContext", "");
      GridgridstatecollectionsContainer.AddObjectProperty("InMasterPage", "false");
      GridgridstatecollectionsContainer.AddObjectProperty("Class", "WorkWith");
      GridgridstatecollectionsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridgridstatecollectionsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridgridstatecollectionsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridgridstatecollectionsContainer.setPageSize( subgridgridstatecollections_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_152( ) ;
         e130G2 ();
         if ( ( subGridgridstatecollections_Islastpage == 0 ) && ( GRIDGRIDSTATECOLLECTIONS_nCurrentRecord > 0 ) && ( GRIDGRIDSTATECOLLECTIONS_nGridOutOfScope == 0 ) && ( nGXsfl_15_idx == 1 ) )
         {
            GRIDGRIDSTATECOLLECTIONS_nCurrentRecord = 0 ;
            GRIDGRIDSTATECOLLECTIONS_nGridOutOfScope = 1 ;
            subgridgridstatecollections_firstpage( ) ;
            e130G2 ();
         }
         wbEnd = (short)(15) ;
         wb0G0( ) ;
      }
      bGXsfl_15_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0G2( )
   {
   }

   public int subgridgridstatecollections_fnc_pagecount( )
   {
      GRIDGRIDSTATECOLLECTIONS_nRecordCount = subgridgridstatecollections_fnc_recordcount( ) ;
      if ( ((int)((GRIDGRIDSTATECOLLECTIONS_nRecordCount) % (subgridgridstatecollections_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRIDGRIDSTATECOLLECTIONS_nRecordCount).divide(DecimalUtil.doubleToDec(subgridgridstatecollections_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))) ;
      }
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRIDGRIDSTATECOLLECTIONS_nRecordCount).divide(DecimalUtil.doubleToDec(subgridgridstatecollections_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public int subgridgridstatecollections_fnc_recordcount( )
   {
      return AV6GridStateCollection.size() ;
   }

   public int subgridgridstatecollections_fnc_recordsperpage( )
   {
      if ( subGridgridstatecollections_Rows > 0 )
      {
         return subGridgridstatecollections_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridgridstatecollections_fnc_currentpage( )
   {
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage).divide(DecimalUtil.doubleToDec(subgridgridstatecollections_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public short subgridgridstatecollections_firstpage( )
   {
      GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage = 0 ;
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridgridstatecollections_nextpage( )
   {
      GRIDGRIDSTATECOLLECTIONS_nRecordCount = subgridgridstatecollections_fnc_recordcount( ) ;
      if ( ( GRIDGRIDSTATECOLLECTIONS_nRecordCount >= subgridgridstatecollections_fnc_recordsperpage( ) ) && ( GRIDGRIDSTATECOLLECTIONS_nEOF == 0 ) )
      {
         GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage = (long)(GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage+subgridgridstatecollections_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridgridstatecollectionsContainer.AddObjectProperty("GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage", GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDGRIDSTATECOLLECTIONS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridgridstatecollections_previouspage( )
   {
      if ( GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage >= subgridgridstatecollections_fnc_recordsperpage( ) )
      {
         GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage = (long)(GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage-subgridgridstatecollections_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridgridstatecollections_lastpage( )
   {
      GRIDGRIDSTATECOLLECTIONS_nRecordCount = subgridgridstatecollections_fnc_recordcount( ) ;
      if ( GRIDGRIDSTATECOLLECTIONS_nRecordCount > subgridgridstatecollections_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDGRIDSTATECOLLECTIONS_nRecordCount) % (subgridgridstatecollections_fnc_recordsperpage( )))) == 0 )
         {
            GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage = (long)(GRIDGRIDSTATECOLLECTIONS_nRecordCount-subgridgridstatecollections_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage = (long)(GRIDGRIDSTATECOLLECTIONS_nRecordCount-((int)((GRIDGRIDSTATECOLLECTIONS_nRecordCount) % (subgridgridstatecollections_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage = 0 ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridgridstatecollections_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage = (long)(subgridgridstatecollections_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage = 0 ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      edtavMoveup_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMoveup_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMoveup_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavMovedown_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMovedown_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMovedown_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavUdelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUdelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUdelete_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup0G0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e120G2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.readJsonSdtValue(httpContext.cgiGet( "Gridstatecollection"), AV6GridStateCollection);
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vGRIDSTATECOLLECTION"), AV6GridStateCollection);
         /* Read saved values. */
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_15"), ",", ".")) ;
         GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage"), ",", ".") ;
         GRIDGRIDSTATECOLLECTIONS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDGRIDSTATECOLLECTIONS_nEOF"), ",", ".")) ;
         subGridgridstatecollections_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDGRIDSTATECOLLECTIONS_Rows"), ",", ".")) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridgridstatecollections_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDGRIDSTATECOLLECTIONS_EMPOWERER_Gridinternalname") ;
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_15"), ",", ".")) ;
         nGXsfl_15_fel_idx = 0 ;
         while ( nGXsfl_15_fel_idx < nRC_GXsfl_15 )
         {
            nGXsfl_15_fel_idx = ((subGridgridstatecollections_Islastpage==1)&&(nGXsfl_15_fel_idx+1>subgridgridstatecollections_fnc_recordsperpage( )) ? 1 : nGXsfl_15_fel_idx+1) ;
            sGXsfl_15_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_152( ) ;
            AV15GXV1 = (int)(nGXsfl_15_fel_idx+GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage) ;
            if ( ( AV6GridStateCollection.size() >= AV15GXV1 ) && ( AV15GXV1 > 0 ) )
            {
               AV6GridStateCollection.currentItem( ((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)) );
               AV12MoveUp = httpContext.cgiGet( edtavMoveup_Internalname) ;
               AV11MoveDown = httpContext.cgiGet( edtavMovedown_Internalname) ;
               AV13UDelete = httpContext.cgiGet( edtavUdelete_Internalname) ;
            }
         }
         if ( nGXsfl_15_fel_idx == 0 )
         {
            nGXsfl_15_idx = 1 ;
            sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_152( ) ;
         }
         nGXsfl_15_fel_idx = 1 ;
         /* Read variables values. */
         AV5CollectionIsEmpty = GXutil.strtobool( httpContext.cgiGet( chkavCollectionisempty.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CollectionIsEmpty", AV5CollectionIsEmpty);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e120G2 ();
      if (returnInSub) return;
   }

   public void e120G2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      chkavCollectionisempty.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavCollectionisempty.getInternalname(), "Visible", GXutil.ltrimstr( chkavCollectionisempty.getVisible(), 5, 0), true);
      Gridgridstatecollections_empowerer_Gridinternalname = subGridgridstatecollections_Internalname ;
      ucGridgridstatecollections_empowerer.sendProperty(context, "", false, Gridgridstatecollections_empowerer_Internalname, "GridInternalName", Gridgridstatecollections_empowerer_Gridinternalname);
      subGridgridstatecollections_Rows = 0 ;
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Rows, (byte)(6), (byte)(0), ".", "")));
      if ( GXutil.strcmp(AV8HTTPRequest.getMethod(), "GET") == 0 )
      {
         AV6GridStateCollection.fromxml(new com.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( AV14UserKey), null, null);
         gx_BV15 = true ;
      }
   }

   private void e130G2( )
   {
      /* Gridgridstatecollections_Load Routine */
      returnInSub = false ;
      AV15GXV1 = 1 ;
      while ( AV15GXV1 <= AV6GridStateCollection.size() )
      {
         AV6GridStateCollection.currentItem( ((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)) );
         AV12MoveUp = "<i class=\"fas fa-arrow-up\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavMoveup_Internalname, AV12MoveUp);
         AV11MoveDown = "<i class=\"fas fa-arrow-down\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavMovedown_Internalname, AV11MoveDown);
         AV13UDelete = "<i class=\"fas fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavUdelete_Internalname, AV13UDelete);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(15) ;
         }
         if ( ( subGridgridstatecollections_Islastpage == 1 ) || ( subGridgridstatecollections_Rows == 0 ) || ( ( GRIDGRIDSTATECOLLECTIONS_nCurrentRecord >= GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage ) && ( GRIDGRIDSTATECOLLECTIONS_nCurrentRecord < GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage + subgridgridstatecollections_fnc_recordsperpage( ) ) ) )
         {
            sendrow_152( ) ;
         }
         GRIDGRIDSTATECOLLECTIONS_nEOF = (byte)(((GRIDGRIDSTATECOLLECTIONS_nCurrentRecord<GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage+subgridgridstatecollections_fnc_recordsperpage( )) ? 1 : 0)) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRIDGRIDSTATECOLLECTIONS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDGRIDSTATECOLLECTIONS_nEOF, (byte)(1), (byte)(0), ".", "")));
         GRIDGRIDSTATECOLLECTIONS_nCurrentRecord = (long)(GRIDGRIDSTATECOLLECTIONS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_15_Refreshing )
         {
            httpContext.doAjaxLoad(15, GridgridstatecollectionsRow);
         }
         AV15GXV1 = (int)(AV15GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e140G2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(GXutil.lower( AV14UserKey), "appbookmarks") == 0 )
      {
         edtavGridstatecollection__title_Title = "Bookmark" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavGridstatecollection__title_Internalname, "Title", edtavGridstatecollection__title_Title, !bGXsfl_15_Refreshing);
         Form.setCaption( "Bookmark Manager" );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      }
      else
      {
         edtavGridstatecollection__gridstatexml_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavGridstatecollection__gridstatexml_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGridstatecollection__gridstatexml_Visible), 5, 0), !bGXsfl_15_Refreshing);
         edtavGridstatecollection__title_Class = "AttributeRealWidth" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavGridstatecollection__title_Internalname, "Class", edtavGridstatecollection__title_Class, !bGXsfl_15_Refreshing);
      }
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e110G2 ();
      if (returnInSub) return;
   }

   public void e110G2( )
   {
      AV15GXV1 = (int)(nGXsfl_15_idx+GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage) ;
      if ( ( AV15GXV1 > 0 ) && ( AV6GridStateCollection.size() >= AV15GXV1 ) )
      {
         AV6GridStateCollection.currentItem( ((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)) );
      }
      /* Enter Routine */
      returnInSub = false ;
      AV10IsOK = true ;
      AV18GXV4 = 1 ;
      while ( AV18GXV4 <= AV6GridStateCollection.size() )
      {
         AV7GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV18GXV4));
         if ( (GXutil.strcmp("", AV7GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Title())==0) )
         {
            httpContext.GX_msglist.addItem("Empty");
            AV10IsOK = false ;
            if (true) break;
         }
         AV18GXV4 = (int)(AV18GXV4+1) ;
      }
      if ( AV10IsOK )
      {
         if ( AV5CollectionIsEmpty )
         {
            AV6GridStateCollection = new GXBaseCollection<com.wwpbaseobjects.SdtGridStateCollection_Item>(com.wwpbaseobjects.SdtGridStateCollection_Item.class, "Item", "", remoteHandle) ;
            gx_BV15 = true ;
         }
         new com.wwpbaseobjects.savemanagefiltersstate(remoteHandle, context).execute( AV14UserKey, AV6GridStateCollection.toxml(false, true, "Items", "")) ;
         if ( GXutil.strcmp(GXutil.lower( AV14UserKey), "appbookmarks") == 0 )
         {
            this.executeExternalObjectMethod("", false, "GlobalEvents", "Master_RefreshHeader", new Object[] {}, true);
         }
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6GridStateCollection", AV6GridStateCollection);
      nGXsfl_15_bak_idx = nGXsfl_15_idx ;
      gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      nGXsfl_15_idx = nGXsfl_15_bak_idx ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
   }

   public void e150G2( )
   {
      AV15GXV1 = (int)(nGXsfl_15_idx+GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage) ;
      if ( ( AV15GXV1 > 0 ) && ( AV6GridStateCollection.size() >= AV15GXV1 ) )
      {
         AV6GridStateCollection.currentItem( ((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)) );
      }
      /* Moveup_Click Routine */
      returnInSub = false ;
      AV9i = (short)(AV6GridStateCollection.indexof(((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.currentItem()))) ;
      if ( AV9i > 1 )
      {
         AV7GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV9i));
         AV6GridStateCollection.removeItem(AV9i);
         gx_BV15 = true ;
         AV6GridStateCollection.add(AV7GridStateCollectionItem, AV9i-1);
         gx_BV15 = true ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6GridStateCollection", AV6GridStateCollection);
      nGXsfl_15_bak_idx = nGXsfl_15_idx ;
      gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      nGXsfl_15_idx = nGXsfl_15_bak_idx ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
   }

   public void e160G2( )
   {
      AV15GXV1 = (int)(nGXsfl_15_idx+GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage) ;
      if ( ( AV15GXV1 > 0 ) && ( AV6GridStateCollection.size() >= AV15GXV1 ) )
      {
         AV6GridStateCollection.currentItem( ((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)) );
      }
      /* Movedown_Click Routine */
      returnInSub = false ;
      AV9i = (short)(AV6GridStateCollection.indexof(((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.currentItem()))) ;
      if ( AV9i < AV6GridStateCollection.size() )
      {
         AV7GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV9i));
         AV6GridStateCollection.removeItem(AV9i);
         gx_BV15 = true ;
         AV6GridStateCollection.add(AV7GridStateCollectionItem, AV9i+1);
         gx_BV15 = true ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6GridStateCollection", AV6GridStateCollection);
      nGXsfl_15_bak_idx = nGXsfl_15_idx ;
      gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      nGXsfl_15_idx = nGXsfl_15_bak_idx ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
   }

   public void e170G2( )
   {
      AV15GXV1 = (int)(nGXsfl_15_idx+GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage) ;
      if ( ( AV15GXV1 > 0 ) && ( AV6GridStateCollection.size() >= AV15GXV1 ) )
      {
         AV6GridStateCollection.currentItem( ((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)) );
      }
      /* Udelete_Click Routine */
      returnInSub = false ;
      AV9i = (short)(AV6GridStateCollection.indexof(((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.currentItem()))) ;
      AV6GridStateCollection.removeItem(AV9i);
      gx_BV15 = true ;
      if ( AV6GridStateCollection.size() == 0 )
      {
         AV5CollectionIsEmpty = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CollectionIsEmpty", AV5CollectionIsEmpty);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6GridStateCollection", AV6GridStateCollection);
      nGXsfl_15_bak_idx = nGXsfl_15_idx ;
      gxgrgridgridstatecollections_refresh( subGridgridstatecollections_Rows, AV14UserKey, AV5CollectionIsEmpty) ;
      nGXsfl_15_idx = nGXsfl_15_bak_idx ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
   }

   public void wb_table1_31_0G2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblUtpaneldummy_Internalname, tblUtpaneldummy_Internalname, "", "Invisible", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvelop_bootstrap_panel1.setProperty("Title", Dvelop_bootstrap_panel1_Title);
         ucDvelop_bootstrap_panel1.render(context, "dvelop.bootstrap.panel", Dvelop_bootstrap_panel1_Internalname, "DVELOP_BOOTSTRAP_PANEL1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_BOOTSTRAP_PANEL1Container"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_31_0G2e( true) ;
      }
      else
      {
         wb_table1_31_0G2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV14UserKey = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14UserKey", AV14UserKey);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14UserKey, ""))));
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
      pa0G2( ) ;
      ws0G2( ) ;
      we0G2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/bootstrap.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617165661", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/managefilters.js", "?202442617165661", false, true);
      httpContext.AddJavascriptSource("shared/jquery/jquery1.9.1.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/bootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_152( )
   {
      edtavMoveup_Internalname = "vMOVEUP_"+sGXsfl_15_idx ;
      edtavMovedown_Internalname = "vMOVEDOWN_"+sGXsfl_15_idx ;
      edtavGridstatecollection__title_Internalname = "GRIDSTATECOLLECTION__TITLE_"+sGXsfl_15_idx ;
      edtavGridstatecollection__gridstatexml_Internalname = "GRIDSTATECOLLECTION__GRIDSTATEXML_"+sGXsfl_15_idx ;
      edtavUdelete_Internalname = "vUDELETE_"+sGXsfl_15_idx ;
   }

   public void subsflControlProps_fel_152( )
   {
      edtavMoveup_Internalname = "vMOVEUP_"+sGXsfl_15_fel_idx ;
      edtavMovedown_Internalname = "vMOVEDOWN_"+sGXsfl_15_fel_idx ;
      edtavGridstatecollection__title_Internalname = "GRIDSTATECOLLECTION__TITLE_"+sGXsfl_15_fel_idx ;
      edtavGridstatecollection__gridstatexml_Internalname = "GRIDSTATECOLLECTION__GRIDSTATEXML_"+sGXsfl_15_fel_idx ;
      edtavUdelete_Internalname = "vUDELETE_"+sGXsfl_15_fel_idx ;
   }

   public void sendrow_152( )
   {
      subsflControlProps_152( ) ;
      wb0G0( ) ;
      if ( ( subGridgridstatecollections_Rows * 1 == 0 ) || ( nGXsfl_15_idx <= subgridgridstatecollections_fnc_recordsperpage( ) * 1 ) )
      {
         GridgridstatecollectionsRow = GXWebRow.GetNew(context,GridgridstatecollectionsContainer) ;
         if ( subGridgridstatecollections_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridgridstatecollections_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridgridstatecollections_Class, "") != 0 )
            {
               subGridgridstatecollections_Linesclass = subGridgridstatecollections_Class+"Odd" ;
            }
         }
         else if ( subGridgridstatecollections_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridgridstatecollections_Backstyle = (byte)(0) ;
            subGridgridstatecollections_Backcolor = subGridgridstatecollections_Allbackcolor ;
            if ( GXutil.strcmp(subGridgridstatecollections_Class, "") != 0 )
            {
               subGridgridstatecollections_Linesclass = subGridgridstatecollections_Class+"Uniform" ;
            }
         }
         else if ( subGridgridstatecollections_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridgridstatecollections_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridgridstatecollections_Class, "") != 0 )
            {
               subGridgridstatecollections_Linesclass = subGridgridstatecollections_Class+"Odd" ;
            }
            subGridgridstatecollections_Backcolor = (int)(0x0) ;
         }
         else if ( subGridgridstatecollections_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridgridstatecollections_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_15_idx) % (2))) == 0 )
            {
               subGridgridstatecollections_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridgridstatecollections_Class, "") != 0 )
               {
                  subGridgridstatecollections_Linesclass = subGridgridstatecollections_Class+"Even" ;
               }
            }
            else
            {
               subGridgridstatecollections_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridgridstatecollections_Class, "") != 0 )
               {
                  subGridgridstatecollections_Linesclass = subGridgridstatecollections_Class+"Odd" ;
               }
            }
         }
         if ( GridgridstatecollectionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_15_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridgridstatecollectionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavMoveup_Enabled!=0)&&(edtavMoveup_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 16,'',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridgridstatecollectionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavMoveup_Internalname,GXutil.rtrim( AV12MoveUp),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavMoveup_Enabled!=0)&&(edtavMoveup_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,16);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVMOVEUP.CLICK."+sGXsfl_15_idx+"'","","","","",edtavMoveup_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavMoveup_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(30),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridgridstatecollectionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavMovedown_Enabled!=0)&&(edtavMovedown_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 17,'',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridgridstatecollectionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavMovedown_Internalname,GXutil.rtrim( AV11MoveDown),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavMovedown_Enabled!=0)&&(edtavMovedown_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,17);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVMOVEDOWN.CLICK."+sGXsfl_15_idx+"'","","","","",edtavMovedown_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavMovedown_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(30),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridgridstatecollectionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavGridstatecollection__title_Enabled!=0)&&(edtavGridstatecollection__title_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 18,'',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
         ROClassString = edtavGridstatecollection__title_Class ;
         GridgridstatecollectionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavGridstatecollection__title_Internalname,((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)).getgxTv_SdtGridStateCollection_Item_Title(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavGridstatecollection__title_Enabled!=0)&&(edtavGridstatecollection__title_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,18);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavGridstatecollection__title_Jsonclick,Integer.valueOf(0),edtavGridstatecollection__title_Class,"",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridgridstatecollectionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+((edtavGridstatecollection__gridstatexml_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavGridstatecollection__gridstatexml_Enabled!=0)&&(edtavGridstatecollection__gridstatexml_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 19,'',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridgridstatecollectionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavGridstatecollection__gridstatexml_Internalname,((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)).getgxTv_SdtGridStateCollection_Item_Gridstatexml(),((com.wwpbaseobjects.SdtGridStateCollection_Item)AV6GridStateCollection.elementAt(-1+AV15GXV1)).getgxTv_SdtGridStateCollection_Item_Gridstatexml(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavGridstatecollection__gridstatexml_Enabled!=0)&&(edtavGridstatecollection__gridstatexml_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,19);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavGridstatecollection__gridstatexml_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(edtavGridstatecollection__gridstatexml_Visible),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridgridstatecollectionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUdelete_Enabled!=0)&&(edtavUdelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 20,'',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridgridstatecollectionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUdelete_Internalname,GXutil.rtrim( AV13UDelete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUdelete_Enabled!=0)&&(edtavUdelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,20);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVUDELETE.CLICK."+sGXsfl_15_idx+"'","","","","",edtavUdelete_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavUdelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(30),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes0G2( ) ;
         GridgridstatecollectionsContainer.AddRow(GridgridstatecollectionsRow);
         nGXsfl_15_idx = ((subGridgridstatecollections_Islastpage==1)&&(nGXsfl_15_idx+1>subgridgridstatecollections_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      /* End function sendrow_152 */
   }

   public void startgridcontrol15( )
   {
      if ( GridgridstatecollectionsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridgridstatecollectionsContainer"+"DivS\" data-gxgridid=\"15\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGridgridstatecollections_Internalname, subGridgridstatecollections_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridgridstatecollections_Backcolorstyle == 0 )
         {
            subGridgridstatecollections_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridgridstatecollections_Class) > 0 )
            {
               subGridgridstatecollections_Linesclass = subGridgridstatecollections_Class+"Title" ;
            }
         }
         else
         {
            subGridgridstatecollections_Titlebackstyle = (byte)(1) ;
            if ( subGridgridstatecollections_Backcolorstyle == 1 )
            {
               subGridgridstatecollections_Titlebackcolor = subGridgridstatecollections_Allbackcolor ;
               if ( GXutil.len( subGridgridstatecollections_Class) > 0 )
               {
                  subGridgridstatecollections_Linesclass = subGridgridstatecollections_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridgridstatecollections_Class) > 0 )
               {
                  subGridgridstatecollections_Linesclass = subGridgridstatecollections_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"start"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(30), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"start"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(30), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"start"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavGridstatecollection__title_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( edtavGridstatecollection__title_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"start"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+((edtavGridstatecollection__gridstatexml_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "URL") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"start"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(30), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridgridstatecollectionsContainer.AddObjectProperty("GridName", "Gridgridstatecollections");
      }
      else
      {
         GridgridstatecollectionsContainer.AddObjectProperty("GridName", "Gridgridstatecollections");
         GridgridstatecollectionsContainer.AddObjectProperty("Header", subGridgridstatecollections_Header);
         GridgridstatecollectionsContainer.AddObjectProperty("Class", "WorkWith");
         GridgridstatecollectionsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddObjectProperty("CmpContext", "");
         GridgridstatecollectionsContainer.AddObjectProperty("InMasterPage", "false");
         GridgridstatecollectionsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridgridstatecollectionsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV12MoveUp)));
         GridgridstatecollectionsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavMoveup_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddColumnProperties(GridgridstatecollectionsColumn);
         GridgridstatecollectionsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridgridstatecollectionsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV11MoveDown)));
         GridgridstatecollectionsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavMovedown_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddColumnProperties(GridgridstatecollectionsColumn);
         GridgridstatecollectionsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridgridstatecollectionsColumn.AddObjectProperty("Title", GXutil.rtrim( edtavGridstatecollection__title_Title));
         GridgridstatecollectionsColumn.AddObjectProperty("Class", GXutil.rtrim( edtavGridstatecollection__title_Class));
         GridgridstatecollectionsContainer.AddColumnProperties(GridgridstatecollectionsColumn);
         GridgridstatecollectionsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridgridstatecollectionsColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavGridstatecollection__gridstatexml_Visible, (byte)(5), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddColumnProperties(GridgridstatecollectionsColumn);
         GridgridstatecollectionsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridgridstatecollectionsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV13UDelete)));
         GridgridstatecollectionsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUdelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddColumnProperties(GridgridstatecollectionsColumn);
         GridgridstatecollectionsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridgridstatecollectionsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridgridstatecollections_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavMoveup_Internalname = "vMOVEUP" ;
      edtavMovedown_Internalname = "vMOVEDOWN" ;
      edtavGridstatecollection__title_Internalname = "GRIDSTATECOLLECTION__TITLE" ;
      edtavGridstatecollection__gridstatexml_Internalname = "GRIDSTATECOLLECTION__GRIDSTATEXML" ;
      edtavUdelete_Internalname = "vUDELETE" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      Dvelop_bootstrap_panel1_Internalname = "DVELOP_BOOTSTRAP_PANEL1" ;
      tblUtpaneldummy_Internalname = "UTPANELDUMMY" ;
      divHtml_usertable_utpaneldummy_Internalname = "HTML_USERTABLE_UTPANELDUMMY" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      chkavCollectionisempty.setInternalname( "vCOLLECTIONISEMPTY" );
      Gridgridstatecollections_empowerer_Internalname = "GRIDGRIDSTATECOLLECTIONS_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridgridstatecollections_Internalname = "GRIDGRIDSTATECOLLECTIONS" ;
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
      subGridgridstatecollections_Allowcollapsing = (byte)(0) ;
      subGridgridstatecollections_Allowselection = (byte)(0) ;
      subGridgridstatecollections_Header = "" ;
      edtavGridstatecollection__title_Title = "Filtros" ;
      edtavUdelete_Jsonclick = "" ;
      edtavUdelete_Visible = -1 ;
      edtavUdelete_Enabled = 1 ;
      edtavGridstatecollection__gridstatexml_Jsonclick = "" ;
      edtavGridstatecollection__gridstatexml_Enabled = 1 ;
      edtavGridstatecollection__gridstatexml_Visible = -1 ;
      edtavGridstatecollection__title_Jsonclick = "" ;
      edtavGridstatecollection__title_Class = "Attribute" ;
      edtavGridstatecollection__title_Visible = -1 ;
      edtavGridstatecollection__title_Enabled = 1 ;
      edtavMovedown_Jsonclick = "" ;
      edtavMovedown_Visible = -1 ;
      edtavMovedown_Enabled = 1 ;
      edtavMoveup_Jsonclick = "" ;
      edtavMoveup_Visible = -1 ;
      edtavMoveup_Enabled = 1 ;
      subGridgridstatecollections_Class = "WorkWith" ;
      subGridgridstatecollections_Backcolorstyle = (byte)(0) ;
      Dvelop_bootstrap_panel1_Title = "" ;
      edtavGridstatecollection__title_Class = "Attribute" ;
      edtavGridstatecollection__gridstatexml_Visible = -1 ;
      edtavGridstatecollection__title_Title = "Filtros" ;
      chkavCollectionisempty.setVisible( 1 );
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Gestionador de filtros" );
      subGridgridstatecollections_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavCollectionisempty.setName( "vCOLLECTIONISEMPTY" );
      chkavCollectionisempty.setWebtags( "" );
      chkavCollectionisempty.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCollectionisempty.getInternalname(), "TitleCaption", chkavCollectionisempty.getCaption(), true);
      chkavCollectionisempty.setCheckedValue( "false" );
      AV5CollectionIsEmpty = GXutil.strtobool( GXutil.booltostr( AV5CollectionIsEmpty)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CollectionIsEmpty", AV5CollectionIsEmpty);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'GRIDGRIDSTATECOLLECTIONS_nEOF'},{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'subGridgridstatecollections_Rows',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'Rows'},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''},{av:'AV14UserKey',fld:'vUSERKEY',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Title'},{ctrl:'FORM',prop:'Caption'},{ctrl:'GRIDSTATECOLLECTION__GRIDSTATEXML',prop:'Visible'},{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Class'}]}");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS.LOAD","{handler:'e130G2',iparms:[]");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS.LOAD",",oparms:[{av:'AV12MoveUp',fld:'vMOVEUP',pic:''},{av:'AV11MoveDown',fld:'vMOVEDOWN',pic:''},{av:'AV13UDelete',fld:'vUDELETE',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e110G2',iparms:[{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''},{av:'AV14UserKey',fld:'vUSERKEY',pic:'',hsh:true},{av:'GRIDGRIDSTATECOLLECTIONS_nEOF'},{av:'subGridgridstatecollections_Rows',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'Rows'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15}]}");
      setEventMetadata("VMOVEUP.CLICK","{handler:'e150G2',iparms:[{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nEOF'},{av:'subGridgridstatecollections_Rows',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'Rows'},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''},{av:'AV14UserKey',fld:'vUSERKEY',pic:'',hsh:true}]");
      setEventMetadata("VMOVEUP.CLICK",",oparms:[{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15}]}");
      setEventMetadata("VMOVEDOWN.CLICK","{handler:'e160G2',iparms:[{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nEOF'},{av:'subGridgridstatecollections_Rows',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'Rows'},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''},{av:'AV14UserKey',fld:'vUSERKEY',pic:'',hsh:true}]");
      setEventMetadata("VMOVEDOWN.CLICK",",oparms:[{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15}]}");
      setEventMetadata("VUDELETE.CLICK","{handler:'e170G2',iparms:[{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nEOF'},{av:'subGridgridstatecollections_Rows',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'Rows'},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''},{av:'AV14UserKey',fld:'vUSERKEY',pic:'',hsh:true}]");
      setEventMetadata("VUDELETE.CLICK",",oparms:[{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''}]}");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS_FIRSTPAGE","{handler:'subgridgridstatecollections_firstpage',iparms:[{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'GRIDGRIDSTATECOLLECTIONS_nEOF'},{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'subGridgridstatecollections_Rows',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'Rows'},{av:'AV14UserKey',fld:'vUSERKEY',pic:'',hsh:true},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''}]");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS_FIRSTPAGE",",oparms:[{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Title'},{ctrl:'FORM',prop:'Caption'},{ctrl:'GRIDSTATECOLLECTION__GRIDSTATEXML',prop:'Visible'},{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Class'}]}");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS_PREVPAGE","{handler:'subgridgridstatecollections_previouspage',iparms:[{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'GRIDGRIDSTATECOLLECTIONS_nEOF'},{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'subGridgridstatecollections_Rows',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'Rows'},{av:'AV14UserKey',fld:'vUSERKEY',pic:'',hsh:true},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''}]");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS_PREVPAGE",",oparms:[{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Title'},{ctrl:'FORM',prop:'Caption'},{ctrl:'GRIDSTATECOLLECTION__GRIDSTATEXML',prop:'Visible'},{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Class'}]}");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS_NEXTPAGE","{handler:'subgridgridstatecollections_nextpage',iparms:[{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'GRIDGRIDSTATECOLLECTIONS_nEOF'},{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'subGridgridstatecollections_Rows',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'Rows'},{av:'AV14UserKey',fld:'vUSERKEY',pic:'',hsh:true},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''}]");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS_NEXTPAGE",",oparms:[{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Title'},{ctrl:'FORM',prop:'Caption'},{ctrl:'GRIDSTATECOLLECTION__GRIDSTATEXML',prop:'Visible'},{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Class'}]}");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS_LASTPAGE","{handler:'subgridgridstatecollections_lastpage',iparms:[{av:'GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage'},{av:'GRIDGRIDSTATECOLLECTIONS_nEOF'},{av:'AV6GridStateCollection',fld:'vGRIDSTATECOLLECTION',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'GridRC',grid:15},{av:'subGridgridstatecollections_Rows',ctrl:'GRIDGRIDSTATECOLLECTIONS',prop:'Rows'},{av:'AV14UserKey',fld:'vUSERKEY',pic:'',hsh:true},{av:'AV5CollectionIsEmpty',fld:'vCOLLECTIONISEMPTY',pic:''}]");
      setEventMetadata("GRIDGRIDSTATECOLLECTIONS_LASTPAGE",",oparms:[{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Title'},{ctrl:'FORM',prop:'Caption'},{ctrl:'GRIDSTATECOLLECTION__GRIDSTATEXML',prop:'Visible'},{ctrl:'GRIDSTATECOLLECTION__TITLE',prop:'Class'}]}");
      setEventMetadata("NULL","{handler:'validv_Udelete',iparms:[]");
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
      wcpOAV14UserKey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV14UserKey = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV6GridStateCollection = new GXBaseCollection<com.wwpbaseobjects.SdtGridStateCollection_Item>(com.wwpbaseobjects.SdtGridStateCollection_Item.class, "Item", "", remoteHandle);
      Gridgridstatecollections_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridgridstatecollectionsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      TempTags = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      ucGridgridstatecollections_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV12MoveUp = "" ;
      AV11MoveDown = "" ;
      AV13UDelete = "" ;
      AV8HTTPRequest = httpContext.getHttpRequest();
      GridgridstatecollectionsRow = new com.genexus.webpanels.GXWebRow();
      AV7GridStateCollectionItem = new com.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
      ucDvelop_bootstrap_panel1 = new com.genexus.webpanels.GXUserControl();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridgridstatecollections_Linesclass = "" ;
      ROClassString = "" ;
      GridgridstatecollectionsColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
      edtavMoveup_Enabled = 0 ;
      edtavMovedown_Enabled = 0 ;
      edtavUdelete_Enabled = 0 ;
   }

   private byte GRIDGRIDSTATECOLLECTIONS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGridgridstatecollections_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGridgridstatecollections_Backstyle ;
   private byte subGridgridstatecollections_Titlebackstyle ;
   private byte subGridgridstatecollections_Allowselection ;
   private byte subGridgridstatecollections_Allowhovering ;
   private byte subGridgridstatecollections_Allowcollapsing ;
   private byte subGridgridstatecollections_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short AV9i ;
   private int nRC_GXsfl_15 ;
   private int subGridgridstatecollections_Rows ;
   private int nGXsfl_15_idx=1 ;
   private int AV15GXV1 ;
   private int subGridgridstatecollections_Islastpage ;
   private int edtavMoveup_Enabled ;
   private int edtavMovedown_Enabled ;
   private int edtavUdelete_Enabled ;
   private int GRIDGRIDSTATECOLLECTIONS_nGridOutOfScope ;
   private int nGXsfl_15_fel_idx=1 ;
   private int edtavGridstatecollection__gridstatexml_Visible ;
   private int AV18GXV4 ;
   private int nGXsfl_15_bak_idx=1 ;
   private int idxLst ;
   private int subGridgridstatecollections_Backcolor ;
   private int subGridgridstatecollections_Allbackcolor ;
   private int edtavMoveup_Visible ;
   private int edtavMovedown_Visible ;
   private int edtavGridstatecollection__title_Enabled ;
   private int edtavGridstatecollection__title_Visible ;
   private int edtavGridstatecollection__gridstatexml_Enabled ;
   private int edtavUdelete_Visible ;
   private int subGridgridstatecollections_Titlebackcolor ;
   private int subGridgridstatecollections_Selectedindex ;
   private int subGridgridstatecollections_Selectioncolor ;
   private int subGridgridstatecollections_Hoveringcolor ;
   private long GRIDGRIDSTATECOLLECTIONS_nFirstRecordOnPage ;
   private long GRIDGRIDSTATECOLLECTIONS_nCurrentRecord ;
   private long GRIDGRIDSTATECOLLECTIONS_nRecordCount ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_15_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Gridgridstatecollections_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String sStyleString ;
   private String subGridgridstatecollections_Internalname ;
   private String TempTags ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String divHtml_usertable_utpaneldummy_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Gridgridstatecollections_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV12MoveUp ;
   private String edtavMoveup_Internalname ;
   private String AV11MoveDown ;
   private String edtavMovedown_Internalname ;
   private String AV13UDelete ;
   private String edtavUdelete_Internalname ;
   private String sGXsfl_15_fel_idx="0001" ;
   private String edtavGridstatecollection__title_Title ;
   private String edtavGridstatecollection__title_Internalname ;
   private String edtavGridstatecollection__gridstatexml_Internalname ;
   private String edtavGridstatecollection__title_Class ;
   private String tblUtpaneldummy_Internalname ;
   private String Dvelop_bootstrap_panel1_Title ;
   private String Dvelop_bootstrap_panel1_Internalname ;
   private String subGridgridstatecollections_Class ;
   private String subGridgridstatecollections_Linesclass ;
   private String ROClassString ;
   private String edtavMoveup_Jsonclick ;
   private String edtavMovedown_Jsonclick ;
   private String edtavGridstatecollection__title_Jsonclick ;
   private String edtavGridstatecollection__gridstatexml_Jsonclick ;
   private String edtavUdelete_Jsonclick ;
   private String subGridgridstatecollections_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV5CollectionIsEmpty ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_15_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV15 ;
   private boolean gx_refresh_fired ;
   private boolean AV10IsOK ;
   private String wcpOAV14UserKey ;
   private String AV14UserKey ;
   private com.genexus.webpanels.GXWebGrid GridgridstatecollectionsContainer ;
   private com.genexus.webpanels.GXWebRow GridgridstatecollectionsRow ;
   private com.genexus.webpanels.GXWebColumn GridgridstatecollectionsColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.GXUserControl ucGridgridstatecollections_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDvelop_bootstrap_panel1 ;
   private ICheckbox chkavCollectionisempty ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.wwpbaseobjects.SdtGridStateCollection_Item> AV6GridStateCollection ;
   private com.wwpbaseobjects.SdtGridStateCollection_Item AV7GridStateCollectionItem ;
}

