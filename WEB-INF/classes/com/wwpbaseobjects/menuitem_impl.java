package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class menuitem_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action36") == 0 )
      {
         A10MenuItemId = (short)(GXutil.lval( httpContext.GetPar( "MenuItemId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_36_033( A10MenuItemId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel28"+"_"+"MENUITEMCAPTION") == 0 )
      {
         AV14MenuItemCaption = httpContext.GetPar( "MenuItemCaption") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14MenuItemCaption", AV14MenuItemCaption);
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx28asamenuitemcaption033( AV14MenuItemCaption, Gx_BScreen) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel29"+"_"+"MENUITEMCAPTION") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx29asamenuitemcaption033( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_38") == 0 )
      {
         A11MenuItemFatherId = (short)(GXutil.lval( httpContext.GetPar( "MenuItemFatherId"))) ;
         n11MenuItemFatherId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_38( A11MenuItemFatherId) ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7MenuItemId = (short)(GXutil.lval( httpContext.GetPar( "MenuItemId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7MenuItemId), 4, 0));
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUITEMID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7MenuItemId), "ZZZ9")));
            AV13MenuItemFatherId = (short)(GXutil.lval( httpContext.GetPar( "MenuItemFatherId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13MenuItemFatherId), 4, 0));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 18_0_8-180599", (short)(0)) ;
         }
      }
      Form.getMeta().addItem("description", "Menu Item", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtMenuItemFatherId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS", true);
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public menuitem_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public menuitem_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuitem_impl.class ));
   }

   public menuitem_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbMenuItemType = new HTMLChoice();
      chkMenuItemLinkTarget = UIFactory.getCheckbox(this);
      chkMenuItemShowDeveloperMenuOptio = UIFactory.getCheckbox(this);
      chkMenuItemShowEditMenuOptions = UIFactory.getCheckbox(this);
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
      if ( cmbMenuItemType.getItemCount() > 0 )
      {
         A16MenuItemType = (byte)(GXutil.lval( cmbMenuItemType.getValidValue(GXutil.trim( GXutil.str( A16MenuItemType, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A16MenuItemType", GXutil.str( A16MenuItemType, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMenuItemType.setValue( GXutil.trim( GXutil.str( A16MenuItemType, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMenuItemType.getInternalname(), "Values", cmbMenuItemType.ToJavascriptSource(), true);
      }
      A14MenuItemLinkTarget = ((GXutil.strcmp(A14MenuItemLinkTarget, "_blank")==0) ? "_blank" : "_") ;
      httpContext.ajax_rsp_assign_attri("", false, "A14MenuItemLinkTarget", A14MenuItemLinkTarget);
      A20MenuItemShowDeveloperMenuOptio = GXutil.strtobool( GXutil.booltostr( A20MenuItemShowDeveloperMenuOptio)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A20MenuItemShowDeveloperMenuOptio", A20MenuItemShowDeveloperMenuOptio);
      A21MenuItemShowEditMenuOptions = GXutil.strtobool( GXutil.booltostr( A21MenuItemShowEditMenuOptions)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A21MenuItemShowEditMenuOptions", A21MenuItemShowEditMenuOptions);
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "start", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "start", "top", "", "", "div");
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
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-lg-6", "start", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divCombo_menuitemfatherid_cell_Internalname, 1, 0, "px", 0, "px", divCombo_menuitemfatherid_cell_Class, "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divTablesplittedmenuitemfatherid_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 MergeLabelCell", "start", "top", "", "", "div");
      /* Text block */
      com.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmenuitemfatherid_Internalname, "Inside Menu", "", "", lblTextblockmenuitemfatherid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8", "start", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_menuitemfatherid.setProperty("Caption", Combo_menuitemfatherid_Caption);
      ucCombo_menuitemfatherid.setProperty("Cls", Combo_menuitemfatherid_Cls);
      ucCombo_menuitemfatherid.setProperty("DataListProc", Combo_menuitemfatherid_Datalistproc);
      ucCombo_menuitemfatherid.setProperty("DataListProcParametersPrefix", Combo_menuitemfatherid_Datalistprocparametersprefix);
      ucCombo_menuitemfatherid.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_menuitemfatherid.setProperty("DropDownOptionsData", AV17MenuItemFatherId_Data);
      ucCombo_menuitemfatherid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_menuitemfatherid_Internalname, "COMBO_MENUITEMFATHERIDContainer");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtMenuItemFatherId_Internalname, "Inside Menu", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtMenuItemFatherId_Internalname, GXutil.ltrim( localUtil.ntoc( A11MenuItemFatherId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A11MenuItemFatherId), "ZZZ9")), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuItemFatherId_Jsonclick, 0, "Attribute", "", "", "", "", edtMenuItemFatherId_Visible, edtMenuItemFatherId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "end", false, "", "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtMenuItemCaption_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtMenuItemCaption_Internalname, "Caption", "col-sm-4 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-8 gx-attribute", "start", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtMenuItemCaption_Internalname, A12MenuItemCaption, GXutil.rtrim( localUtil.format( A12MenuItemCaption, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuItemCaption_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMenuItemCaption_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divMenuitemtype_cell_Internalname, 1, 0, "px", 0, "px", divMenuitemtype_cell_Class, "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", cmbMenuItemType.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+cmbMenuItemType.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, cmbMenuItemType.getInternalname(), "Type", "col-sm-4 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-8 gx-attribute", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      /* ComboBox */
      com.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMenuItemType, cmbMenuItemType.getInternalname(), GXutil.trim( GXutil.str( A16MenuItemType, 1, 0)), 1, cmbMenuItemType.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbMenuItemType.getVisible(), cmbMenuItemType.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "", true, (byte)(0), "HLP_WWPBaseObjects/MenuItem.htm");
      cmbMenuItemType.setValue( GXutil.trim( GXutil.str( A16MenuItemType, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMenuItemType.getInternalname(), "Values", cmbMenuItemType.ToJavascriptSource(), true);
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divMenuitemiconclass_cell_Internalname, 1, 0, "px", 0, "px", divMenuitemiconclass_cell_Class, "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", edtMenuItemIconClass_Visible, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtMenuItemIconClass_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtMenuItemIconClass_Internalname, "Icon Class", "col-sm-4 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-8 gx-attribute", "start", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtMenuItemIconClass_Internalname, A15MenuItemIconClass, GXutil.rtrim( localUtil.format( A15MenuItemIconClass, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuItemIconClass_Jsonclick, 0, "Attribute", "", "", "", "", edtMenuItemIconClass_Visible, edtMenuItemIconClass_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divMenuitemlink_cell_Internalname, 1, 0, "px", 0, "px", divMenuitemlink_cell_Class, "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", edtMenuItemLink_Visible, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtMenuItemLink_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtMenuItemLink_Internalname, "Link", "col-sm-4 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-8 gx-attribute", "start", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtMenuItemLink_Internalname, A13MenuItemLink, GXutil.rtrim( localUtil.format( A13MenuItemLink, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuItemLink_Jsonclick, 0, "Attribute", "", "", "", "", edtMenuItemLink_Visible, edtMenuItemLink_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divMenuitemlinkparameters_cell_Internalname, 1, 0, "px", 0, "px", divMenuitemlinkparameters_cell_Class, "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", edtMenuItemLinkParameters_Visible, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtMenuItemLinkParameters_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtMenuItemLinkParameters_Internalname, "Parameters", "col-sm-4 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-8 gx-attribute", "start", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtMenuItemLinkParameters_Internalname, A18MenuItemLinkParameters, GXutil.rtrim( localUtil.format( A18MenuItemLinkParameters, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuItemLinkParameters_Jsonclick, 0, "Attribute", "", "", "", "", edtMenuItemLinkParameters_Visible, edtMenuItemLinkParameters_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divMenuitemlinktarget_cell_Internalname, 1, 0, "px", 0, "px", divMenuitemlinktarget_cell_Class, "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", chkMenuItemLinkTarget.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+chkMenuItemLinkTarget.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, chkMenuItemLinkTarget.getInternalname(), " ", "col-sm-4 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-8 gx-attribute", "start", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      com.GxWebStd.gx_checkbox_ctrl( httpContext, chkMenuItemLinkTarget.getInternalname(), A14MenuItemLinkTarget, "", " ", chkMenuItemLinkTarget.getVisible(), chkMenuItemLinkTarget.getEnabled(), "_blank", "Open in new tab/window", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(58, this, '_blank', '_',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,58);\"");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divMenuitemshowdevelopermenuoption_cell_Internalname, 1, 0, "px", 0, "px", divMenuitemshowdevelopermenuoption_cell_Class, "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", chkMenuItemShowDeveloperMenuOptio.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+chkMenuItemShowDeveloperMenuOptio.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, chkMenuItemShowDeveloperMenuOptio.getInternalname(), " ", "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      com.GxWebStd.gx_checkbox_ctrl( httpContext, chkMenuItemShowDeveloperMenuOptio.getInternalname(), GXutil.booltostr( A20MenuItemShowDeveloperMenuOptio), "", " ", chkMenuItemShowDeveloperMenuOptio.getVisible(), chkMenuItemShowDeveloperMenuOptio.getEnabled(), "true", "Mostrar menú de desarrollo", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(63, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,63);\"");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divMenuitemshoweditmenuoptions_cell_Internalname, 1, 0, "px", 0, "px", divMenuitemshoweditmenuoptions_cell_Class, "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", chkMenuItemShowEditMenuOptions.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+chkMenuItemShowEditMenuOptions.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, chkMenuItemShowEditMenuOptions.getInternalname(), " ", "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      com.GxWebStd.gx_checkbox_ctrl( httpContext, chkMenuItemShowEditMenuOptions.getInternalname(), GXutil.booltostr( A21MenuItemShowEditMenuOptions), "", " ", chkMenuItemShowEditMenuOptions.getVisible(), chkMenuItemShowEditMenuOptions.getEnabled(), "true", "Mostrar opción para editar menú", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(68, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,68);\"");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      httpContext.writeText( "</div>") ;
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
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "start", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      ClassString = "Button" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/MenuItem.htm");
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
      com.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divSectionattribute_menuitemfatherid_Internalname, 1, 0, "px", 0, "px", "Section", "start", "top", "", "", "div");
      /* Single line edit */
      com.GxWebStd.gx_single_line_edit( httpContext, edtavCombomenuitemfatherid_Internalname, GXutil.ltrim( localUtil.ntoc( AV22ComboMenuItemFatherId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombomenuitemfatherid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV22ComboMenuItemFatherId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV22ComboMenuItemFatherId), "ZZZ9"))), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombomenuitemfatherid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombomenuitemfatherid_Visible, edtavCombomenuitemfatherid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "end", false, "", "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Single line edit */
      com.GxWebStd.gx_single_line_edit( httpContext, edtMenuItemId_Internalname, GXutil.ltrim( localUtil.ntoc( A10MenuItemId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtMenuItemId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A10MenuItemId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A10MenuItemId), "ZZZ9"))), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuItemId_Jsonclick, 0, "Attribute", "", "", "", "", edtMenuItemId_Visible, edtMenuItemId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "end", false, "", "HLP_WWPBaseObjects/MenuItem.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11032 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.readJsonSdtValue(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV18DDO_TitleSettingsIcons);
            httpContext.readJsonSdtValue(httpContext.cgiGet( "vMENUITEMFATHERID_DATA"), AV17MenuItemFatherId_Data);
            /* Read saved values. */
            Z10MenuItemId = (short)(localUtil.ctol( httpContext.cgiGet( "Z10MenuItemId"), ",", ".")) ;
            Z16MenuItemType = (byte)(localUtil.ctol( httpContext.cgiGet( "Z16MenuItemType"), ",", ".")) ;
            Z12MenuItemCaption = httpContext.cgiGet( "Z12MenuItemCaption") ;
            Z22MenuItemOrder = (short)(localUtil.ctol( httpContext.cgiGet( "Z22MenuItemOrder"), ",", ".")) ;
            Z13MenuItemLink = httpContext.cgiGet( "Z13MenuItemLink") ;
            Z18MenuItemLinkParameters = httpContext.cgiGet( "Z18MenuItemLinkParameters") ;
            Z14MenuItemLinkTarget = httpContext.cgiGet( "Z14MenuItemLinkTarget") ;
            Z15MenuItemIconClass = httpContext.cgiGet( "Z15MenuItemIconClass") ;
            Z20MenuItemShowDeveloperMenuOptio = GXutil.strtobool( httpContext.cgiGet( "Z20MenuItemShowDeveloperMenuOptio")) ;
            Z21MenuItemShowEditMenuOptions = GXutil.strtobool( httpContext.cgiGet( "Z21MenuItemShowEditMenuOptions")) ;
            Z11MenuItemFatherId = (short)(localUtil.ctol( httpContext.cgiGet( "Z11MenuItemFatherId"), ",", ".")) ;
            n11MenuItemFatherId = ((0==A11MenuItemFatherId) ? true : false) ;
            A22MenuItemOrder = (short)(localUtil.ctol( httpContext.cgiGet( "Z22MenuItemOrder"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N11MenuItemFatherId = (short)(localUtil.ctol( httpContext.cgiGet( "N11MenuItemFatherId"), ",", ".")) ;
            n11MenuItemFatherId = ((0==A11MenuItemFatherId) ? true : false) ;
            AV7MenuItemId = (short)(localUtil.ctol( httpContext.cgiGet( "vMENUITEMID"), ",", ".")) ;
            AV11Insert_MenuItemFatherId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_MENUITEMFATHERID"), ",", ".")) ;
            AV13MenuItemFatherId = (short)(localUtil.ctol( httpContext.cgiGet( "vMENUITEMFATHERID"), ",", ".")) ;
            AV14MenuItemCaption = httpContext.cgiGet( "vMENUITEMCAPTION") ;
            AV15MenuItemIconClass = httpContext.cgiGet( "vMENUITEMICONCLASS") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), ",", ".")) ;
            AV16MenuItemShowDeveloperMenuOption = GXutil.strtobool( httpContext.cgiGet( "vMENUITEMSHOWDEVELOPERMENUOPTION")) ;
            Gx_mode = httpContext.cgiGet( "vMODE") ;
            A22MenuItemOrder = (short)(localUtil.ctol( httpContext.cgiGet( "MENUITEMORDER"), ",", ".")) ;
            A17MenuItemFatherCaption = httpContext.cgiGet( "MENUITEMFATHERCAPTION") ;
            A19MenuItemFatherType = (byte)(localUtil.ctol( httpContext.cgiGet( "MENUITEMFATHERTYPE"), ",", ".")) ;
            AV24Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_menuitemfatherid_Objectcall = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Objectcall") ;
            Combo_menuitemfatherid_Class = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Class") ;
            Combo_menuitemfatherid_Icontype = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Icontype") ;
            Combo_menuitemfatherid_Icon = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Icon") ;
            Combo_menuitemfatherid_Caption = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Caption") ;
            Combo_menuitemfatherid_Tooltip = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Tooltip") ;
            Combo_menuitemfatherid_Cls = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Cls") ;
            Combo_menuitemfatherid_Selectedvalue_set = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Selectedvalue_set") ;
            Combo_menuitemfatherid_Selectedvalue_get = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Selectedvalue_get") ;
            Combo_menuitemfatherid_Selectedtext_set = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Selectedtext_set") ;
            Combo_menuitemfatherid_Selectedtext_get = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Selectedtext_get") ;
            Combo_menuitemfatherid_Gamoauthtoken = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Gamoauthtoken") ;
            Combo_menuitemfatherid_Ddointernalname = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Ddointernalname") ;
            Combo_menuitemfatherid_Titlecontrolalign = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Titlecontrolalign") ;
            Combo_menuitemfatherid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Dropdownoptionstype") ;
            Combo_menuitemfatherid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Enabled")) ;
            Combo_menuitemfatherid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Visible")) ;
            Combo_menuitemfatherid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Titlecontrolidtoreplace") ;
            Combo_menuitemfatherid_Datalisttype = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Datalisttype") ;
            Combo_menuitemfatherid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Allowmultipleselection")) ;
            Combo_menuitemfatherid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Datalistfixedvalues") ;
            Combo_menuitemfatherid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Isgriditem")) ;
            Combo_menuitemfatherid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Hasdescription")) ;
            Combo_menuitemfatherid_Datalistproc = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Datalistproc") ;
            Combo_menuitemfatherid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Datalistprocparametersprefix") ;
            Combo_menuitemfatherid_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Remoteservicesparameters") ;
            Combo_menuitemfatherid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_menuitemfatherid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Includeonlyselectedoption")) ;
            Combo_menuitemfatherid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Includeselectalloption")) ;
            Combo_menuitemfatherid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Emptyitem")) ;
            Combo_menuitemfatherid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Includeaddnewoption")) ;
            Combo_menuitemfatherid_Htmltemplate = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Htmltemplate") ;
            Combo_menuitemfatherid_Multiplevaluestype = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Multiplevaluestype") ;
            Combo_menuitemfatherid_Loadingdata = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Loadingdata") ;
            Combo_menuitemfatherid_Noresultsfound = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Noresultsfound") ;
            Combo_menuitemfatherid_Emptyitemtext = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Emptyitemtext") ;
            Combo_menuitemfatherid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Onlyselectedvalues") ;
            Combo_menuitemfatherid_Selectalltext = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Selectalltext") ;
            Combo_menuitemfatherid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Multiplevaluesseparator") ;
            Combo_menuitemfatherid_Addnewoptiontext = httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Addnewoptiontext") ;
            Combo_menuitemfatherid_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MENUITEMFATHERID_Gxcontroltype"), ",", ".")) ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), ",", ".")) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMenuItemFatherId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMenuItemFatherId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MENUITEMFATHERID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMenuItemFatherId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A11MenuItemFatherId = (short)(0) ;
               n11MenuItemFatherId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
            }
            else
            {
               A11MenuItemFatherId = (short)(localUtil.ctol( httpContext.cgiGet( edtMenuItemFatherId_Internalname), ",", ".")) ;
               n11MenuItemFatherId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
            }
            n11MenuItemFatherId = ((0==A11MenuItemFatherId) ? true : false) ;
            A12MenuItemCaption = httpContext.cgiGet( edtMenuItemCaption_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A12MenuItemCaption", A12MenuItemCaption);
            cmbMenuItemType.setValue( httpContext.cgiGet( cmbMenuItemType.getInternalname()) );
            A16MenuItemType = (byte)(GXutil.lval( httpContext.cgiGet( cmbMenuItemType.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A16MenuItemType", GXutil.str( A16MenuItemType, 1, 0));
            A15MenuItemIconClass = httpContext.cgiGet( edtMenuItemIconClass_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A15MenuItemIconClass", A15MenuItemIconClass);
            A13MenuItemLink = httpContext.cgiGet( edtMenuItemLink_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A13MenuItemLink", A13MenuItemLink);
            A18MenuItemLinkParameters = httpContext.cgiGet( edtMenuItemLinkParameters_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A18MenuItemLinkParameters", A18MenuItemLinkParameters);
            A14MenuItemLinkTarget = ((GXutil.strcmp(httpContext.cgiGet( chkMenuItemLinkTarget.getInternalname()), "_blank")==0) ? "_blank" : "_") ;
            httpContext.ajax_rsp_assign_attri("", false, "A14MenuItemLinkTarget", A14MenuItemLinkTarget);
            A20MenuItemShowDeveloperMenuOptio = GXutil.strtobool( httpContext.cgiGet( chkMenuItemShowDeveloperMenuOptio.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A20MenuItemShowDeveloperMenuOptio", A20MenuItemShowDeveloperMenuOptio);
            A21MenuItemShowEditMenuOptions = GXutil.strtobool( httpContext.cgiGet( chkMenuItemShowEditMenuOptions.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A21MenuItemShowEditMenuOptions", A21MenuItemShowEditMenuOptions);
            AV22ComboMenuItemFatherId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombomenuitemfatherid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ComboMenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboMenuItemFatherId), 4, 0));
            A10MenuItemId = (short)(localUtil.ctol( httpContext.cgiGet( edtMenuItemId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"MenuItem");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("MenuItemOrder", localUtil.format( DecimalUtil.doubleToDec(A22MenuItemOrder), "ZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A10MenuItemId != Z10MenuItemId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("wwpbaseobjects\\menuitem:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A10MenuItemId = (short)(GXutil.lval( httpContext.GetPar( "MenuItemId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode3 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode3 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound3 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_030( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "MENUITEMID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtMenuItemId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11032 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12032 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e12032 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll033( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes033( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomenuitemfatherid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomenuitemfatherid_Enabled), 5, 0), true);
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_030( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls033( ) ;
         }
         else
         {
            checkExtendedTable033( ) ;
            closeExtendedTableCursors033( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption030( )
   {
   }

   public void e11032( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0];
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV18DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0];
      AV18DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtMenuItemFatherId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemFatherId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemFatherId_Visible), 5, 0), true);
      AV22ComboMenuItemFatherId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboMenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboMenuItemFatherId), 4, 0));
      edtavCombomenuitemfatherid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomenuitemfatherid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomenuitemfatherid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOMENUITEMFATHERID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV24Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV25GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GXV1), 8, 0));
         while ( AV25GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV12TrnContextAtt = (com.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV25GXV1));
            if ( GXutil.strcmp(AV12TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MenuItemFatherId") == 0 )
            {
               AV11Insert_MenuItemFatherId = (short)(GXutil.lval( AV12TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_MenuItemFatherId), 4, 0));
               if ( ! (0==AV11Insert_MenuItemFatherId) )
               {
                  AV22ComboMenuItemFatherId = AV11Insert_MenuItemFatherId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboMenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboMenuItemFatherId), 4, 0));
                  Combo_menuitemfatherid_Selectedvalue_set = GXutil.trim( GXutil.str( AV22ComboMenuItemFatherId, 4, 0)) ;
                  ucCombo_menuitemfatherid.sendProperty(context, "", false, Combo_menuitemfatherid_Internalname, "SelectedValue_set", Combo_menuitemfatherid_Selectedvalue_set);
                  GXt_char4 = AV21Combo_DataJson ;
                  GXv_char5[0] = AV19ComboSelectedValue ;
                  GXv_char6[0] = AV20ComboSelectedText ;
                  GXv_char7[0] = GXt_char4 ;
                  new com.wwpbaseobjects.menuitemloaddvcombo(remoteHandle, context).execute( "MenuItemFatherId", "GET", false, AV7MenuItemId, AV12TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char5, GXv_char6, GXv_char7) ;
                  menuitem_impl.this.AV19ComboSelectedValue = GXv_char5[0] ;
                  menuitem_impl.this.AV20ComboSelectedText = GXv_char6[0] ;
                  menuitem_impl.this.GXt_char4 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
                  AV21Combo_DataJson = GXt_char4 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
                  Combo_menuitemfatherid_Selectedtext_set = AV20ComboSelectedText ;
                  ucCombo_menuitemfatherid.sendProperty(context, "", false, Combo_menuitemfatherid_Internalname, "SelectedText_set", Combo_menuitemfatherid_Selectedtext_set);
                  Combo_menuitemfatherid_Enabled = false ;
                  ucCombo_menuitemfatherid.sendProperty(context, "", false, Combo_menuitemfatherid_Internalname, "Enabled", GXutil.booltostr( Combo_menuitemfatherid_Enabled));
               }
            }
            AV25GXV1 = (int)(AV25GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GXV1), 8, 0));
         }
      }
      edtMenuItemId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Visible), 5, 0), true);
      if ( AV13MenuItemFatherId == 0 )
      {
         AV16MenuItemShowDeveloperMenuOption = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16MenuItemShowDeveloperMenuOption", AV16MenuItemShowDeveloperMenuOption);
      }
   }

   public void e12032( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {Short.valueOf(AV13MenuItemFatherId)});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV13MenuItemFatherId"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( AV13MenuItemFatherId == 0 )
      {
         Combo_menuitemfatherid_Visible = false ;
         ucCombo_menuitemfatherid.sendProperty(context, "", false, Combo_menuitemfatherid_Internalname, "Visible", GXutil.booltostr( Combo_menuitemfatherid_Visible));
         divCombo_menuitemfatherid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divCombo_menuitemfatherid_cell_Internalname, "Class", divCombo_menuitemfatherid_cell_Class, true);
         cmbMenuItemType.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbMenuItemType.getInternalname(), "Visible", GXutil.ltrimstr( cmbMenuItemType.getVisible(), 5, 0), true);
         divMenuitemtype_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemtype_cell_Internalname, "Class", divMenuitemtype_cell_Class, true);
         edtMenuItemIconClass_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemIconClass_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemIconClass_Visible), 5, 0), true);
         divMenuitemiconclass_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemiconclass_cell_Internalname, "Class", divMenuitemiconclass_cell_Class, true);
         edtMenuItemLink_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLink_Visible), 5, 0), true);
         divMenuitemlink_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemlink_cell_Internalname, "Class", divMenuitemlink_cell_Class, true);
         edtMenuItemLinkParameters_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLinkParameters_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLinkParameters_Visible), 5, 0), true);
         divMenuitemlinkparameters_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinkparameters_cell_Internalname, "Class", divMenuitemlinkparameters_cell_Class, true);
         chkMenuItemLinkTarget.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkMenuItemLinkTarget.getInternalname(), "Visible", GXutil.ltrimstr( chkMenuItemLinkTarget.getVisible(), 5, 0), true);
         divMenuitemlinktarget_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinktarget_cell_Internalname, "Class", divMenuitemlinktarget_cell_Class, true);
         chkMenuItemShowDeveloperMenuOptio.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkMenuItemShowDeveloperMenuOptio.getInternalname(), "Visible", GXutil.ltrimstr( chkMenuItemShowDeveloperMenuOptio.getVisible(), 5, 0), true);
         divMenuitemshowdevelopermenuoption_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemshowdevelopermenuoption_cell_Internalname, "Class", divMenuitemshowdevelopermenuoption_cell_Class, true);
         chkMenuItemShowEditMenuOptions.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkMenuItemShowEditMenuOptions.getInternalname(), "Visible", GXutil.ltrimstr( chkMenuItemShowEditMenuOptions.getVisible(), 5, 0), true);
         divMenuitemshoweditmenuoptions_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemshoweditmenuoptions_cell_Internalname, "Class", divMenuitemshoweditmenuoptions_cell_Class, true);
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOMENUITEMFATHERID' Routine */
      returnInSub = false ;
      GXt_char4 = AV21Combo_DataJson ;
      GXv_char7[0] = AV19ComboSelectedValue ;
      GXv_char6[0] = AV20ComboSelectedText ;
      GXv_char5[0] = GXt_char4 ;
      new com.wwpbaseobjects.menuitemloaddvcombo(remoteHandle, context).execute( "MenuItemFatherId", Gx_mode, false, AV7MenuItemId, "", GXv_char7, GXv_char6, GXv_char5) ;
      menuitem_impl.this.AV19ComboSelectedValue = GXv_char7[0] ;
      menuitem_impl.this.AV20ComboSelectedText = GXv_char6[0] ;
      menuitem_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
      AV21Combo_DataJson = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
      Combo_menuitemfatherid_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_menuitemfatherid.sendProperty(context, "", false, Combo_menuitemfatherid_Internalname, "SelectedValue_set", Combo_menuitemfatherid_Selectedvalue_set);
      Combo_menuitemfatherid_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_menuitemfatherid.sendProperty(context, "", false, Combo_menuitemfatherid_Internalname, "SelectedText_set", Combo_menuitemfatherid_Selectedtext_set);
      AV22ComboMenuItemFatherId = (short)(GXutil.lval( AV19ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboMenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboMenuItemFatherId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_menuitemfatherid_Enabled = false ;
         ucCombo_menuitemfatherid.sendProperty(context, "", false, Combo_menuitemfatherid_Internalname, "Enabled", GXutil.booltostr( Combo_menuitemfatherid_Enabled));
      }
   }

   public void zm033( int GX_JID )
   {
      if ( ( GX_JID == 37 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z16MenuItemType = T00033_A16MenuItemType[0] ;
            Z12MenuItemCaption = T00033_A12MenuItemCaption[0] ;
            Z22MenuItemOrder = T00033_A22MenuItemOrder[0] ;
            Z13MenuItemLink = T00033_A13MenuItemLink[0] ;
            Z18MenuItemLinkParameters = T00033_A18MenuItemLinkParameters[0] ;
            Z14MenuItemLinkTarget = T00033_A14MenuItemLinkTarget[0] ;
            Z15MenuItemIconClass = T00033_A15MenuItemIconClass[0] ;
            Z20MenuItemShowDeveloperMenuOptio = T00033_A20MenuItemShowDeveloperMenuOptio[0] ;
            Z21MenuItemShowEditMenuOptions = T00033_A21MenuItemShowEditMenuOptions[0] ;
            Z11MenuItemFatherId = T00033_A11MenuItemFatherId[0] ;
         }
         else
         {
            Z16MenuItemType = A16MenuItemType ;
            Z12MenuItemCaption = A12MenuItemCaption ;
            Z22MenuItemOrder = A22MenuItemOrder ;
            Z13MenuItemLink = A13MenuItemLink ;
            Z18MenuItemLinkParameters = A18MenuItemLinkParameters ;
            Z14MenuItemLinkTarget = A14MenuItemLinkTarget ;
            Z15MenuItemIconClass = A15MenuItemIconClass ;
            Z20MenuItemShowDeveloperMenuOptio = A20MenuItemShowDeveloperMenuOptio ;
            Z21MenuItemShowEditMenuOptions = A21MenuItemShowEditMenuOptions ;
            Z11MenuItemFatherId = A11MenuItemFatherId ;
         }
      }
      if ( GX_JID == -37 )
      {
         Z10MenuItemId = A10MenuItemId ;
         Z16MenuItemType = A16MenuItemType ;
         Z12MenuItemCaption = A12MenuItemCaption ;
         Z22MenuItemOrder = A22MenuItemOrder ;
         Z13MenuItemLink = A13MenuItemLink ;
         Z18MenuItemLinkParameters = A18MenuItemLinkParameters ;
         Z14MenuItemLinkTarget = A14MenuItemLinkTarget ;
         Z15MenuItemIconClass = A15MenuItemIconClass ;
         Z20MenuItemShowDeveloperMenuOptio = A20MenuItemShowDeveloperMenuOptio ;
         Z21MenuItemShowEditMenuOptions = A21MenuItemShowEditMenuOptions ;
         Z11MenuItemFatherId = A11MenuItemFatherId ;
         Z17MenuItemFatherCaption = A17MenuItemFatherCaption ;
         Z19MenuItemFatherType = A19MenuItemFatherType ;
      }
   }

   public void standaloneNotModal( )
   {
      edtMenuItemId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Enabled), 5, 0), true);
      AV24Pgmname = "WWPBaseObjects.MenuItem" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtMenuItemId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7MenuItemId) )
      {
         A10MenuItemId = AV7MenuItemId ;
         httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
      }
      Combo_menuitemfatherid_Visible = (boolean)((AV13MenuItemFatherId>0)) ;
      ucCombo_menuitemfatherid.sendProperty(context, "", false, Combo_menuitemfatherid_Internalname, "Visible", GXutil.booltostr( Combo_menuitemfatherid_Visible));
      if ( ! ( ( AV13MenuItemFatherId > 0 ) ) )
      {
         divCombo_menuitemfatherid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divCombo_menuitemfatherid_cell_Internalname, "Class", divCombo_menuitemfatherid_cell_Class, true);
      }
      else
      {
         if ( AV13MenuItemFatherId > 0 )
         {
            divCombo_menuitemfatherid_cell_Class = "col-xs-12 DataContentCell ExtendedComboCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divCombo_menuitemfatherid_cell_Internalname, "Class", divCombo_menuitemfatherid_cell_Class, true);
         }
      }
      cmbMenuItemType.setVisible( ((AV13MenuItemFatherId>0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMenuItemType.getInternalname(), "Visible", GXutil.ltrimstr( cmbMenuItemType.getVisible(), 5, 0), true);
      if ( ! ( ( AV13MenuItemFatherId > 0 ) ) )
      {
         divMenuitemtype_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemtype_cell_Internalname, "Class", divMenuitemtype_cell_Class, true);
      }
      else
      {
         if ( AV13MenuItemFatherId > 0 )
         {
            divMenuitemtype_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemtype_cell_Internalname, "Class", divMenuitemtype_cell_Class, true);
         }
      }
      edtMenuItemIconClass_Visible = ((AV13MenuItemFatherId>0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemIconClass_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemIconClass_Visible), 5, 0), true);
      if ( ! ( ( AV13MenuItemFatherId > 0 ) ) )
      {
         divMenuitemiconclass_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemiconclass_cell_Internalname, "Class", divMenuitemiconclass_cell_Class, true);
      }
      else
      {
         if ( AV13MenuItemFatherId > 0 )
         {
            divMenuitemiconclass_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemiconclass_cell_Internalname, "Class", divMenuitemiconclass_cell_Class, true);
         }
      }
      chkMenuItemShowDeveloperMenuOptio.setVisible( ((AV13MenuItemFatherId==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemShowDeveloperMenuOptio.getInternalname(), "Visible", GXutil.ltrimstr( chkMenuItemShowDeveloperMenuOptio.getVisible(), 5, 0), true);
      if ( ! ( ( AV13MenuItemFatherId == 0 ) ) )
      {
         divMenuitemshowdevelopermenuoption_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemshowdevelopermenuoption_cell_Internalname, "Class", divMenuitemshowdevelopermenuoption_cell_Class, true);
      }
      else
      {
         if ( AV13MenuItemFatherId == 0 )
         {
            divMenuitemshowdevelopermenuoption_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemshowdevelopermenuoption_cell_Internalname, "Class", divMenuitemshowdevelopermenuoption_cell_Class, true);
         }
      }
      chkMenuItemShowEditMenuOptions.setVisible( ((AV13MenuItemFatherId==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemShowEditMenuOptions.getInternalname(), "Visible", GXutil.ltrimstr( chkMenuItemShowEditMenuOptions.getVisible(), 5, 0), true);
      if ( ! ( ( AV13MenuItemFatherId == 0 ) ) )
      {
         divMenuitemshoweditmenuoptions_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemshoweditmenuoptions_cell_Internalname, "Class", divMenuitemshoweditmenuoptions_cell_Class, true);
      }
      else
      {
         if ( AV13MenuItemFatherId == 0 )
         {
            divMenuitemshoweditmenuoptions_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemshoweditmenuoptions_cell_Internalname, "Class", divMenuitemshoweditmenuoptions_cell_Class, true);
         }
      }
      if ( AV13MenuItemFatherId == 0 )
      {
         AV14MenuItemCaption = "MainMenu" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14MenuItemCaption", AV14MenuItemCaption);
      }
      if ( AV13MenuItemFatherId > 0 )
      {
         AV15MenuItemIconClass = "menu-icon fa fa-asterisk" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15MenuItemIconClass", AV15MenuItemIconClass);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_MenuItemFatherId) )
      {
         edtMenuItemFatherId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemFatherId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemFatherId_Enabled), 5, 0), true);
      }
      else
      {
         if ( ( AV13MenuItemFatherId > 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
         {
            edtMenuItemFatherId_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuItemFatherId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemFatherId_Enabled), 5, 0), true);
         }
         else
         {
            edtMenuItemFatherId_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuItemFatherId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemFatherId_Enabled), 5, 0), true);
         }
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_MenuItemFatherId) )
      {
         A11MenuItemFatherId = AV11Insert_MenuItemFatherId ;
         n11MenuItemFatherId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
      }
      else
      {
         if ( (0==AV22ComboMenuItemFatherId) )
         {
            A11MenuItemFatherId = (short)(0) ;
            n11MenuItemFatherId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
            n11MenuItemFatherId = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
         }
         else
         {
            if ( ! (0==AV22ComboMenuItemFatherId) )
            {
               A11MenuItemFatherId = AV22ComboMenuItemFatherId ;
               n11MenuItemFatherId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
            }
            else
            {
               if ( ( AV13MenuItemFatherId > 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
               {
                  A11MenuItemFatherId = AV13MenuItemFatherId ;
                  n11MenuItemFatherId = false ;
                  httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
               }
            }
         }
      }
      if ( AV13MenuItemFatherId == 0 )
      {
         A16MenuItemType = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A16MenuItemType", GXutil.str( A16MenuItemType, 1, 0));
      }
      if ( ( AV13MenuItemFatherId > 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         edtMenuItemFatherId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemFatherId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemFatherId_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( isIns( )  && (GXutil.strcmp("", A12MenuItemCaption)==0) && ( Gx_BScreen == 0 ) )
      {
         A12MenuItemCaption = AV14MenuItemCaption ;
         httpContext.ajax_rsp_assign_attri("", false, "A12MenuItemCaption", A12MenuItemCaption);
      }
      if ( isIns( )  && (GXutil.strcmp("", A15MenuItemIconClass)==0) && ( Gx_BScreen == 0 ) )
      {
         A15MenuItemIconClass = AV15MenuItemIconClass ;
         httpContext.ajax_rsp_assign_attri("", false, "A15MenuItemIconClass", A15MenuItemIconClass);
      }
      if ( isIns( )  && (false==A20MenuItemShowDeveloperMenuOptio) && ( Gx_BScreen == 0 ) )
      {
         A20MenuItemShowDeveloperMenuOptio = AV16MenuItemShowDeveloperMenuOption ;
         httpContext.ajax_rsp_assign_attri("", false, "A20MenuItemShowDeveloperMenuOptio", A20MenuItemShowDeveloperMenuOptio);
      }
      if ( isIns( )  && (false==A21MenuItemShowEditMenuOptions) && ( Gx_BScreen == 0 ) )
      {
         A21MenuItemShowEditMenuOptions = AV16MenuItemShowDeveloperMenuOption ;
         httpContext.ajax_rsp_assign_attri("", false, "A21MenuItemShowEditMenuOptions", A21MenuItemShowEditMenuOptions);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T00034 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId)});
         A17MenuItemFatherCaption = T00034_A17MenuItemFatherCaption[0] ;
         A19MenuItemFatherType = T00034_A19MenuItemFatherType[0] ;
         pr_default.close(2);
         chkMenuItemLinkTarget.setVisible( ((A16MenuItemType==1) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, chkMenuItemLinkTarget.getInternalname(), "Visible", GXutil.ltrimstr( chkMenuItemLinkTarget.getVisible(), 5, 0), true);
         if ( ! ( ( A16MenuItemType == 1 ) ) )
         {
            divMenuitemlinktarget_cell_Class = "Invisible" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinktarget_cell_Internalname, "Class", divMenuitemlinktarget_cell_Class, true);
         }
         else
         {
            if ( A16MenuItemType == 1 )
            {
               divMenuitemlinktarget_cell_Class = "col-xs-12 DataContentCell" ;
               httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinktarget_cell_Internalname, "Class", divMenuitemlinktarget_cell_Class, true);
            }
         }
         edtMenuItemLink_Visible = ((AV13MenuItemFatherId>0)&&(A16MenuItemType==1) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLink_Visible), 5, 0), true);
         if ( ! ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) ) )
         {
            divMenuitemlink_cell_Class = "Invisible" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlink_cell_Internalname, "Class", divMenuitemlink_cell_Class, true);
         }
         else
         {
            if ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) )
            {
               divMenuitemlink_cell_Class = "col-xs-12 DataContentCell" ;
               httpContext.ajax_rsp_assign_prop("", false, divMenuitemlink_cell_Internalname, "Class", divMenuitemlink_cell_Class, true);
            }
         }
         edtMenuItemLinkParameters_Visible = ((AV13MenuItemFatherId>0)&&(A16MenuItemType==1) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLinkParameters_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLinkParameters_Visible), 5, 0), true);
         if ( ! ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) ) )
         {
            divMenuitemlinkparameters_cell_Class = "Invisible" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinkparameters_cell_Internalname, "Class", divMenuitemlinkparameters_cell_Class, true);
         }
         else
         {
            if ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) )
            {
               divMenuitemlinkparameters_cell_Class = "col-xs-12 DataContentCell" ;
               httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinkparameters_cell_Internalname, "Class", divMenuitemlinkparameters_cell_Class, true);
            }
         }
      }
   }

   public void load033( )
   {
      /* Using cursor T00035 */
      pr_default.execute(3, new Object[] {Short.valueOf(A10MenuItemId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A16MenuItemType = T00035_A16MenuItemType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16MenuItemType", GXutil.str( A16MenuItemType, 1, 0));
         A12MenuItemCaption = T00035_A12MenuItemCaption[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12MenuItemCaption", A12MenuItemCaption);
         A22MenuItemOrder = T00035_A22MenuItemOrder[0] ;
         A17MenuItemFatherCaption = T00035_A17MenuItemFatherCaption[0] ;
         A19MenuItemFatherType = T00035_A19MenuItemFatherType[0] ;
         A13MenuItemLink = T00035_A13MenuItemLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13MenuItemLink", A13MenuItemLink);
         A18MenuItemLinkParameters = T00035_A18MenuItemLinkParameters[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18MenuItemLinkParameters", A18MenuItemLinkParameters);
         A14MenuItemLinkTarget = T00035_A14MenuItemLinkTarget[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14MenuItemLinkTarget", A14MenuItemLinkTarget);
         A15MenuItemIconClass = T00035_A15MenuItemIconClass[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A15MenuItemIconClass", A15MenuItemIconClass);
         A20MenuItemShowDeveloperMenuOptio = T00035_A20MenuItemShowDeveloperMenuOptio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20MenuItemShowDeveloperMenuOptio", A20MenuItemShowDeveloperMenuOptio);
         A21MenuItemShowEditMenuOptions = T00035_A21MenuItemShowEditMenuOptions[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A21MenuItemShowEditMenuOptions", A21MenuItemShowEditMenuOptions);
         A11MenuItemFatherId = T00035_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = T00035_n11MenuItemFatherId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
         zm033( -37) ;
      }
      pr_default.close(3);
      onLoadActions033( ) ;
   }

   public void onLoadActions033( )
   {
      edtMenuItemLink_Visible = ((AV13MenuItemFatherId>0)&&(A16MenuItemType==1) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLink_Visible), 5, 0), true);
      if ( ! ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) ) )
      {
         divMenuitemlink_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemlink_cell_Internalname, "Class", divMenuitemlink_cell_Class, true);
      }
      else
      {
         if ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) )
         {
            divMenuitemlink_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlink_cell_Internalname, "Class", divMenuitemlink_cell_Class, true);
         }
      }
      edtMenuItemLinkParameters_Visible = ((AV13MenuItemFatherId>0)&&(A16MenuItemType==1) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLinkParameters_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLinkParameters_Visible), 5, 0), true);
      if ( ! ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) ) )
      {
         divMenuitemlinkparameters_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinkparameters_cell_Internalname, "Class", divMenuitemlinkparameters_cell_Class, true);
      }
      else
      {
         if ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) )
         {
            divMenuitemlinkparameters_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinkparameters_cell_Internalname, "Class", divMenuitemlinkparameters_cell_Class, true);
         }
      }
      chkMenuItemLinkTarget.setVisible( ((A16MenuItemType==1) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemLinkTarget.getInternalname(), "Visible", GXutil.ltrimstr( chkMenuItemLinkTarget.getVisible(), 5, 0), true);
      if ( ! ( ( A16MenuItemType == 1 ) ) )
      {
         divMenuitemlinktarget_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinktarget_cell_Internalname, "Class", divMenuitemlinktarget_cell_Class, true);
      }
      else
      {
         if ( A16MenuItemType == 1 )
         {
            divMenuitemlinktarget_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinktarget_cell_Internalname, "Class", divMenuitemlinktarget_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable033( )
   {
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      edtMenuItemLink_Visible = ((AV13MenuItemFatherId>0)&&(A16MenuItemType==1) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLink_Visible), 5, 0), true);
      if ( ! ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) ) )
      {
         divMenuitemlink_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemlink_cell_Internalname, "Class", divMenuitemlink_cell_Class, true);
      }
      else
      {
         if ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) )
         {
            divMenuitemlink_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlink_cell_Internalname, "Class", divMenuitemlink_cell_Class, true);
         }
      }
      edtMenuItemLinkParameters_Visible = ((AV13MenuItemFatherId>0)&&(A16MenuItemType==1) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLinkParameters_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLinkParameters_Visible), 5, 0), true);
      if ( ! ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) ) )
      {
         divMenuitemlinkparameters_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinkparameters_cell_Internalname, "Class", divMenuitemlinkparameters_cell_Class, true);
      }
      else
      {
         if ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) )
         {
            divMenuitemlinkparameters_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinkparameters_cell_Internalname, "Class", divMenuitemlinkparameters_cell_Class, true);
         }
      }
      if ( ( new com.wwpbaseobjects.getamountofmainmenus(remoteHandle, context).executeUdp( A12MenuItemCaption) > 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         httpContext.GX_msglist.addItem("Ya existe", 1, "MENUITEMCAPTION");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMenuItemCaption_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00034 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A11MenuItemFatherId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Menu Item Father'.", "ForeignKeyNotFound", 1, "MENUITEMFATHERID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtMenuItemFatherId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A17MenuItemFatherCaption = T00034_A17MenuItemFatherCaption[0] ;
      A19MenuItemFatherType = T00034_A19MenuItemFatherType[0] ;
      pr_default.close(2);
      if ( ! ( ( A16MenuItemType == 1 ) || ( A16MenuItemType == 2 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Type fuera de rango", "OutOfRange", 1, "MENUITEMTYPE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMenuItemType.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      chkMenuItemLinkTarget.setVisible( ((A16MenuItemType==1) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemLinkTarget.getInternalname(), "Visible", GXutil.ltrimstr( chkMenuItemLinkTarget.getVisible(), 5, 0), true);
      if ( ! ( ( A16MenuItemType == 1 ) ) )
      {
         divMenuitemlinktarget_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinktarget_cell_Internalname, "Class", divMenuitemlinktarget_cell_Class, true);
      }
      else
      {
         if ( A16MenuItemType == 1 )
         {
            divMenuitemlinktarget_cell_Class = "col-xs-12 DataContentCell" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinktarget_cell_Internalname, "Class", divMenuitemlinktarget_cell_Class, true);
         }
      }
   }

   public void closeExtendedTableCursors033( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_38( short A11MenuItemFatherId )
   {
      /* Using cursor T00036 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A11MenuItemFatherId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Menu Item Father'.", "ForeignKeyNotFound", 1, "MENUITEMFATHERID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtMenuItemFatherId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A17MenuItemFatherCaption = T00036_A17MenuItemFatherCaption[0] ;
      A19MenuItemFatherType = T00036_A19MenuItemFatherType[0] ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A17MenuItemFatherCaption)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A19MenuItemFatherType, (byte)(1), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey033( )
   {
      /* Using cursor T00037 */
      pr_default.execute(5, new Object[] {Short.valueOf(A10MenuItemId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound3 = (short)(1) ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00033 */
      pr_default.execute(1, new Object[] {Short.valueOf(A10MenuItemId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm033( 37) ;
         RcdFound3 = (short)(1) ;
         A10MenuItemId = T00033_A10MenuItemId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
         A16MenuItemType = T00033_A16MenuItemType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16MenuItemType", GXutil.str( A16MenuItemType, 1, 0));
         A12MenuItemCaption = T00033_A12MenuItemCaption[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12MenuItemCaption", A12MenuItemCaption);
         A22MenuItemOrder = T00033_A22MenuItemOrder[0] ;
         A13MenuItemLink = T00033_A13MenuItemLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13MenuItemLink", A13MenuItemLink);
         A18MenuItemLinkParameters = T00033_A18MenuItemLinkParameters[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18MenuItemLinkParameters", A18MenuItemLinkParameters);
         A14MenuItemLinkTarget = T00033_A14MenuItemLinkTarget[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14MenuItemLinkTarget", A14MenuItemLinkTarget);
         A15MenuItemIconClass = T00033_A15MenuItemIconClass[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A15MenuItemIconClass", A15MenuItemIconClass);
         A20MenuItemShowDeveloperMenuOptio = T00033_A20MenuItemShowDeveloperMenuOptio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20MenuItemShowDeveloperMenuOptio", A20MenuItemShowDeveloperMenuOptio);
         A21MenuItemShowEditMenuOptions = T00033_A21MenuItemShowEditMenuOptions[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A21MenuItemShowEditMenuOptions", A21MenuItemShowEditMenuOptions);
         A11MenuItemFatherId = T00033_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = T00033_n11MenuItemFatherId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
         Z10MenuItemId = A10MenuItemId ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load033( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey033( ) ;
         }
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey033( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey033( ) ;
      if ( RcdFound3 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T00038 */
      pr_default.execute(6, new Object[] {Short.valueOf(A10MenuItemId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00038_A10MenuItemId[0] < A10MenuItemId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00038_A10MenuItemId[0] > A10MenuItemId ) ) )
         {
            A10MenuItemId = T00038_A10MenuItemId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T00039 */
      pr_default.execute(7, new Object[] {Short.valueOf(A10MenuItemId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00039_A10MenuItemId[0] > A10MenuItemId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00039_A10MenuItemId[0] < A10MenuItemId ) ) )
         {
            A10MenuItemId = T00039_A10MenuItemId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey033( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtMenuItemFatherId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert033( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound3 == 1 )
         {
            if ( A10MenuItemId != Z10MenuItemId )
            {
               A10MenuItemId = Z10MenuItemId ;
               httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "MENUITEMID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMenuItemId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtMenuItemFatherId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update033( ) ;
               GX_FocusControl = edtMenuItemFatherId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A10MenuItemId != Z10MenuItemId )
            {
               /* Insert record */
               GX_FocusControl = edtMenuItemFatherId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert033( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "MENUITEMID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtMenuItemId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtMenuItemFatherId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert033( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( A10MenuItemId != Z10MenuItemId )
      {
         A10MenuItemId = Z10MenuItemId ;
         httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "MENUITEMID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMenuItemId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtMenuItemFatherId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency033( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00032 */
         pr_default.execute(0, new Object[] {Short.valueOf(A10MenuItemId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuItem"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z16MenuItemType != T00032_A16MenuItemType[0] ) || ( GXutil.strcmp(Z12MenuItemCaption, T00032_A12MenuItemCaption[0]) != 0 ) || ( Z22MenuItemOrder != T00032_A22MenuItemOrder[0] ) || ( GXutil.strcmp(Z13MenuItemLink, T00032_A13MenuItemLink[0]) != 0 ) || ( GXutil.strcmp(Z18MenuItemLinkParameters, T00032_A18MenuItemLinkParameters[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z14MenuItemLinkTarget, T00032_A14MenuItemLinkTarget[0]) != 0 ) || ( GXutil.strcmp(Z15MenuItemIconClass, T00032_A15MenuItemIconClass[0]) != 0 ) || ( Z20MenuItemShowDeveloperMenuOptio != T00032_A20MenuItemShowDeveloperMenuOptio[0] ) || ( Z21MenuItemShowEditMenuOptions != T00032_A21MenuItemShowEditMenuOptions[0] ) || ( Z11MenuItemFatherId != T00032_A11MenuItemFatherId[0] ) )
         {
            if ( Z16MenuItemType != T00032_A16MenuItemType[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemType");
               GXutil.writeLogRaw("Old: ",Z16MenuItemType);
               GXutil.writeLogRaw("Current: ",T00032_A16MenuItemType[0]);
            }
            if ( GXutil.strcmp(Z12MenuItemCaption, T00032_A12MenuItemCaption[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemCaption");
               GXutil.writeLogRaw("Old: ",Z12MenuItemCaption);
               GXutil.writeLogRaw("Current: ",T00032_A12MenuItemCaption[0]);
            }
            if ( Z22MenuItemOrder != T00032_A22MenuItemOrder[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemOrder");
               GXutil.writeLogRaw("Old: ",Z22MenuItemOrder);
               GXutil.writeLogRaw("Current: ",T00032_A22MenuItemOrder[0]);
            }
            if ( GXutil.strcmp(Z13MenuItemLink, T00032_A13MenuItemLink[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemLink");
               GXutil.writeLogRaw("Old: ",Z13MenuItemLink);
               GXutil.writeLogRaw("Current: ",T00032_A13MenuItemLink[0]);
            }
            if ( GXutil.strcmp(Z18MenuItemLinkParameters, T00032_A18MenuItemLinkParameters[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemLinkParameters");
               GXutil.writeLogRaw("Old: ",Z18MenuItemLinkParameters);
               GXutil.writeLogRaw("Current: ",T00032_A18MenuItemLinkParameters[0]);
            }
            if ( GXutil.strcmp(Z14MenuItemLinkTarget, T00032_A14MenuItemLinkTarget[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemLinkTarget");
               GXutil.writeLogRaw("Old: ",Z14MenuItemLinkTarget);
               GXutil.writeLogRaw("Current: ",T00032_A14MenuItemLinkTarget[0]);
            }
            if ( GXutil.strcmp(Z15MenuItemIconClass, T00032_A15MenuItemIconClass[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemIconClass");
               GXutil.writeLogRaw("Old: ",Z15MenuItemIconClass);
               GXutil.writeLogRaw("Current: ",T00032_A15MenuItemIconClass[0]);
            }
            if ( Z20MenuItemShowDeveloperMenuOptio != T00032_A20MenuItemShowDeveloperMenuOptio[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemShowDeveloperMenuOptio");
               GXutil.writeLogRaw("Old: ",Z20MenuItemShowDeveloperMenuOptio);
               GXutil.writeLogRaw("Current: ",T00032_A20MenuItemShowDeveloperMenuOptio[0]);
            }
            if ( Z21MenuItemShowEditMenuOptions != T00032_A21MenuItemShowEditMenuOptions[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemShowEditMenuOptions");
               GXutil.writeLogRaw("Old: ",Z21MenuItemShowEditMenuOptions);
               GXutil.writeLogRaw("Current: ",T00032_A21MenuItemShowEditMenuOptions[0]);
            }
            if ( Z11MenuItemFatherId != T00032_A11MenuItemFatherId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.menuitem:[seudo value changed for attri]"+"MenuItemFatherId");
               GXutil.writeLogRaw("Old: ",Z11MenuItemFatherId);
               GXutil.writeLogRaw("Current: ",T00032_A11MenuItemFatherId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MenuItem"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         zm033( 0) ;
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert033( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000310 */
                  pr_default.execute(8, new Object[] {Byte.valueOf(A16MenuItemType), A12MenuItemCaption, Short.valueOf(A22MenuItemOrder), A13MenuItemLink, A18MenuItemLinkParameters, A14MenuItemLinkTarget, A15MenuItemIconClass, Boolean.valueOf(A20MenuItemShowDeveloperMenuOptio), Boolean.valueOf(A21MenuItemShowEditMenuOptions), Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000311 */
                  pr_default.execute(9);
                  A10MenuItemId = T000311_A10MenuItemId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
                  pr_default.close(9);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     GXv_int8[0] = A10MenuItemId ;
                     new com.wwpbaseobjects.updatemenuitemorder(remoteHandle, context).execute( GXv_int8) ;
                     menuitem_impl.this.A10MenuItemId = GXv_int8[0] ;
                     httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption030( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load033( ) ;
         }
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void update033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate033( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000312 */
                  pr_default.execute(10, new Object[] {Byte.valueOf(A16MenuItemType), A12MenuItemCaption, Short.valueOf(A22MenuItemOrder), A13MenuItemLink, A18MenuItemLinkParameters, A14MenuItemLinkTarget, A15MenuItemIconClass, Boolean.valueOf(A20MenuItemShowDeveloperMenuOptio), Boolean.valueOf(A21MenuItemShowEditMenuOptions), Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId), Short.valueOf(A10MenuItemId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuItem"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate033( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void deferredUpdate033( )
   {
   }

   public void delete( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls033( ) ;
         afterConfirm033( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete033( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000313 */
               pr_default.execute(11, new Object[] {Short.valueOf(A10MenuItemId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode3 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel033( ) ;
      Gx_mode = sMode3 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls033( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000314 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId)});
         A17MenuItemFatherCaption = T000314_A17MenuItemFatherCaption[0] ;
         A19MenuItemFatherType = T000314_A19MenuItemFatherType[0] ;
         pr_default.close(12);
         edtMenuItemLink_Visible = ((AV13MenuItemFatherId>0)&&(A16MenuItemType==1) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLink_Visible), 5, 0), true);
         if ( ! ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) ) )
         {
            divMenuitemlink_cell_Class = "Invisible" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlink_cell_Internalname, "Class", divMenuitemlink_cell_Class, true);
         }
         else
         {
            if ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) )
            {
               divMenuitemlink_cell_Class = "col-xs-12 DataContentCell" ;
               httpContext.ajax_rsp_assign_prop("", false, divMenuitemlink_cell_Internalname, "Class", divMenuitemlink_cell_Class, true);
            }
         }
         edtMenuItemLinkParameters_Visible = ((AV13MenuItemFatherId>0)&&(A16MenuItemType==1) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLinkParameters_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLinkParameters_Visible), 5, 0), true);
         if ( ! ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) ) )
         {
            divMenuitemlinkparameters_cell_Class = "Invisible" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinkparameters_cell_Internalname, "Class", divMenuitemlinkparameters_cell_Class, true);
         }
         else
         {
            if ( ( AV13MenuItemFatherId > 0 ) && ( A16MenuItemType == 1 ) )
            {
               divMenuitemlinkparameters_cell_Class = "col-xs-12 DataContentCell" ;
               httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinkparameters_cell_Internalname, "Class", divMenuitemlinkparameters_cell_Class, true);
            }
         }
         chkMenuItemLinkTarget.setVisible( ((A16MenuItemType==1) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, chkMenuItemLinkTarget.getInternalname(), "Visible", GXutil.ltrimstr( chkMenuItemLinkTarget.getVisible(), 5, 0), true);
         if ( ! ( ( A16MenuItemType == 1 ) ) )
         {
            divMenuitemlinktarget_cell_Class = "Invisible" ;
            httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinktarget_cell_Internalname, "Class", divMenuitemlinktarget_cell_Class, true);
         }
         else
         {
            if ( A16MenuItemType == 1 )
            {
               divMenuitemlinktarget_cell_Class = "col-xs-12 DataContentCell" ;
               httpContext.ajax_rsp_assign_prop("", false, divMenuitemlinktarget_cell_Internalname, "Class", divMenuitemlinktarget_cell_Class, true);
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000315 */
         pr_default.execute(13, new Object[] {Short.valueOf(A10MenuItemId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Item de Menú"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel033( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete033( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.menuitem");
         if ( AnyError == 0 )
         {
            confirmValues030( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.menuitem");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart033( )
   {
      /* Scan By routine */
      /* Using cursor T000316 */
      pr_default.execute(14);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A10MenuItemId = T000316_A10MenuItemId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext033( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A10MenuItemId = T000316_A10MenuItemId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
      }
   }

   public void scanEnd033( )
   {
      pr_default.close(14);
   }

   public void afterConfirm033( )
   {
      /* After Confirm Rules */
      if ( (0==A11MenuItemFatherId) )
      {
         A11MenuItemFatherId = (short)(0) ;
         n11MenuItemFatherId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
         n11MenuItemFatherId = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
      }
   }

   public void beforeInsert033( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate033( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete033( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete033( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate033( )
   {
      /* Before Validate Rules */
      GXt_int9 = (short)(0) ;
      GXv_int8[0] = GXt_int9 ;
      new com.wwpbaseobjects.getamountofmainmenus(remoteHandle, context).execute( "MainMenu", GXv_int8) ;
      menuitem_impl.this.GXt_int9 = GXv_int8[0] ;
      if ( GXt_int9 == 0 )
      {
         A12MenuItemCaption = "MainMenu" ;
         httpContext.ajax_rsp_assign_attri("", false, "A12MenuItemCaption", A12MenuItemCaption);
      }
   }

   public void disableAttributes033( )
   {
      edtMenuItemFatherId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemFatherId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemFatherId_Enabled), 5, 0), true);
      edtMenuItemCaption_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemCaption_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemCaption_Enabled), 5, 0), true);
      cmbMenuItemType.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMenuItemType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMenuItemType.getEnabled(), 5, 0), true);
      edtMenuItemIconClass_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemIconClass_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemIconClass_Enabled), 5, 0), true);
      edtMenuItemLink_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLink_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLink_Enabled), 5, 0), true);
      edtMenuItemLinkParameters_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemLinkParameters_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemLinkParameters_Enabled), 5, 0), true);
      chkMenuItemLinkTarget.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemLinkTarget.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuItemLinkTarget.getEnabled(), 5, 0), true);
      chkMenuItemShowDeveloperMenuOptio.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemShowDeveloperMenuOptio.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuItemShowDeveloperMenuOptio.getEnabled(), 5, 0), true);
      chkMenuItemShowEditMenuOptions.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemShowEditMenuOptions.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuItemShowEditMenuOptions.getEnabled(), 5, 0), true);
      edtavCombomenuitemfatherid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomenuitemfatherid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomenuitemfatherid_Enabled), 5, 0), true);
      edtMenuItemId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes033( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues030( )
   {
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
      MasterPageObj.master_styles();
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.menuitem", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7MenuItemId,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13MenuItemFatherId,4,0))}, new String[] {"Gx_mode","MenuItemId","MenuItemFatherId"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"MenuItem");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("MenuItemOrder", localUtil.format( DecimalUtil.doubleToDec(A22MenuItemOrder), "ZZZ9"));
      com.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("wwpbaseobjects\\menuitem:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, "Z10MenuItemId", GXutil.ltrim( localUtil.ntoc( Z10MenuItemId, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Z16MenuItemType", GXutil.ltrim( localUtil.ntoc( Z16MenuItemType, (byte)(1), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Z12MenuItemCaption", Z12MenuItemCaption);
      com.GxWebStd.gx_hidden_field( httpContext, "Z22MenuItemOrder", GXutil.ltrim( localUtil.ntoc( Z22MenuItemOrder, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Z13MenuItemLink", Z13MenuItemLink);
      com.GxWebStd.gx_hidden_field( httpContext, "Z18MenuItemLinkParameters", Z18MenuItemLinkParameters);
      com.GxWebStd.gx_hidden_field( httpContext, "Z14MenuItemLinkTarget", Z14MenuItemLinkTarget);
      com.GxWebStd.gx_hidden_field( httpContext, "Z15MenuItemIconClass", Z15MenuItemIconClass);
      com.GxWebStd.gx_boolean_hidden_field( httpContext, "Z20MenuItemShowDeveloperMenuOptio", Z20MenuItemShowDeveloperMenuOptio);
      com.GxWebStd.gx_boolean_hidden_field( httpContext, "Z21MenuItemShowEditMenuOptions", Z21MenuItemShowEditMenuOptions);
      com.GxWebStd.gx_hidden_field( httpContext, "Z11MenuItemFatherId", GXutil.ltrim( localUtil.ntoc( Z11MenuItemFatherId, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.GxWebStd.gx_hidden_field( httpContext, "N11MenuItemFatherId", GXutil.ltrim( localUtil.ntoc( A11MenuItemFatherId, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMENUITEMFATHERID_DATA", AV17MenuItemFatherId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMENUITEMFATHERID_DATA", AV17MenuItemFatherId_Data);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "vMENUITEMID", GXutil.ltrim( localUtil.ntoc( AV7MenuItemId, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUITEMID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7MenuItemId), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, "vINSERT_MENUITEMFATHERID", GXutil.ltrim( localUtil.ntoc( AV11Insert_MenuItemFatherId, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "vMENUITEMFATHERID", GXutil.ltrim( localUtil.ntoc( AV13MenuItemFatherId, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "vMENUITEMCAPTION", AV14MenuItemCaption);
      com.GxWebStd.gx_hidden_field( httpContext, "vMENUITEMICONCLASS", AV15MenuItemIconClass);
      com.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, "vMENUITEMSHOWDEVELOPERMENUOPTION", AV16MenuItemShowDeveloperMenuOption);
      com.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.GxWebStd.gx_hidden_field( httpContext, "MENUITEMORDER", GXutil.ltrim( localUtil.ntoc( A22MenuItemOrder, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "MENUITEMFATHERCAPTION", A17MenuItemFatherCaption);
      com.GxWebStd.gx_hidden_field( httpContext, "MENUITEMFATHERTYPE", GXutil.ltrim( localUtil.ntoc( A19MenuItemFatherType, (byte)(1), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV24Pgmname));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_MENUITEMFATHERID_Objectcall", GXutil.rtrim( Combo_menuitemfatherid_Objectcall));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_MENUITEMFATHERID_Cls", GXutil.rtrim( Combo_menuitemfatherid_Cls));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_MENUITEMFATHERID_Selectedvalue_set", GXutil.rtrim( Combo_menuitemfatherid_Selectedvalue_set));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_MENUITEMFATHERID_Selectedtext_set", GXutil.rtrim( Combo_menuitemfatherid_Selectedtext_set));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_MENUITEMFATHERID_Enabled", GXutil.booltostr( Combo_menuitemfatherid_Enabled));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_MENUITEMFATHERID_Visible", GXutil.booltostr( Combo_menuitemfatherid_Visible));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_MENUITEMFATHERID_Datalistproc", GXutil.rtrim( Combo_menuitemfatherid_Datalistproc));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_MENUITEMFATHERID_Datalistprocparametersprefix", GXutil.rtrim( Combo_menuitemfatherid_Datalistprocparametersprefix));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      com.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      com.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
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
      return formatLink("com.wwpbaseobjects.menuitem", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7MenuItemId,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13MenuItemFatherId,4,0))}, new String[] {"Gx_mode","MenuItemId","MenuItemFatherId"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.MenuItem" ;
   }

   public String getPgmdesc( )
   {
      return "Menu Item" ;
   }

   public void initializeNonKey033( )
   {
      A11MenuItemFatherId = (short)(0) ;
      n11MenuItemFatherId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A11MenuItemFatherId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11MenuItemFatherId), 4, 0));
      n11MenuItemFatherId = ((0==A11MenuItemFatherId) ? true : false) ;
      A16MenuItemType = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A16MenuItemType", GXutil.str( A16MenuItemType, 1, 0));
      A22MenuItemOrder = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A22MenuItemOrder", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22MenuItemOrder), 4, 0));
      A17MenuItemFatherCaption = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A17MenuItemFatherCaption", A17MenuItemFatherCaption);
      A19MenuItemFatherType = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A19MenuItemFatherType", GXutil.str( A19MenuItemFatherType, 1, 0));
      A13MenuItemLink = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A13MenuItemLink", A13MenuItemLink);
      A18MenuItemLinkParameters = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A18MenuItemLinkParameters", A18MenuItemLinkParameters);
      A14MenuItemLinkTarget = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A14MenuItemLinkTarget", A14MenuItemLinkTarget);
      A12MenuItemCaption = AV14MenuItemCaption ;
      httpContext.ajax_rsp_assign_attri("", false, "A12MenuItemCaption", A12MenuItemCaption);
      A15MenuItemIconClass = AV15MenuItemIconClass ;
      httpContext.ajax_rsp_assign_attri("", false, "A15MenuItemIconClass", A15MenuItemIconClass);
      A20MenuItemShowDeveloperMenuOptio = AV16MenuItemShowDeveloperMenuOption ;
      httpContext.ajax_rsp_assign_attri("", false, "A20MenuItemShowDeveloperMenuOptio", A20MenuItemShowDeveloperMenuOptio);
      A21MenuItemShowEditMenuOptions = AV16MenuItemShowDeveloperMenuOption ;
      httpContext.ajax_rsp_assign_attri("", false, "A21MenuItemShowEditMenuOptions", A21MenuItemShowEditMenuOptions);
      Z16MenuItemType = (byte)(0) ;
      Z12MenuItemCaption = "" ;
      Z22MenuItemOrder = (short)(0) ;
      Z13MenuItemLink = "" ;
      Z18MenuItemLinkParameters = "" ;
      Z14MenuItemLinkTarget = "" ;
      Z15MenuItemIconClass = "" ;
      Z20MenuItemShowDeveloperMenuOptio = false ;
      Z21MenuItemShowEditMenuOptions = false ;
      Z11MenuItemFatherId = (short)(0) ;
   }

   public void initAll033( )
   {
      A10MenuItemId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
      initializeNonKey033( ) ;
   }

   public void standaloneModalInsert( )
   {
      A12MenuItemCaption = i12MenuItemCaption ;
      httpContext.ajax_rsp_assign_attri("", false, "A12MenuItemCaption", A12MenuItemCaption);
      A15MenuItemIconClass = i15MenuItemIconClass ;
      httpContext.ajax_rsp_assign_attri("", false, "A15MenuItemIconClass", A15MenuItemIconClass);
      A20MenuItemShowDeveloperMenuOptio = i20MenuItemShowDeveloperMenuOptio ;
      httpContext.ajax_rsp_assign_attri("", false, "A20MenuItemShowDeveloperMenuOptio", A20MenuItemShowDeveloperMenuOptio);
      A21MenuItemShowEditMenuOptions = i21MenuItemShowEditMenuOptions ;
      httpContext.ajax_rsp_assign_attri("", false, "A21MenuItemShowEditMenuOptions", A21MenuItemShowEditMenuOptions);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617165136", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/menuitem.js", "?202442617165136", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockmenuitemfatherid_Internalname = "TEXTBLOCKMENUITEMFATHERID" ;
      Combo_menuitemfatherid_Internalname = "COMBO_MENUITEMFATHERID" ;
      edtMenuItemFatherId_Internalname = "MENUITEMFATHERID" ;
      divTablesplittedmenuitemfatherid_Internalname = "TABLESPLITTEDMENUITEMFATHERID" ;
      divCombo_menuitemfatherid_cell_Internalname = "COMBO_MENUITEMFATHERID_CELL" ;
      edtMenuItemCaption_Internalname = "MENUITEMCAPTION" ;
      cmbMenuItemType.setInternalname( "MENUITEMTYPE" );
      divMenuitemtype_cell_Internalname = "MENUITEMTYPE_CELL" ;
      edtMenuItemIconClass_Internalname = "MENUITEMICONCLASS" ;
      divMenuitemiconclass_cell_Internalname = "MENUITEMICONCLASS_CELL" ;
      edtMenuItemLink_Internalname = "MENUITEMLINK" ;
      divMenuitemlink_cell_Internalname = "MENUITEMLINK_CELL" ;
      edtMenuItemLinkParameters_Internalname = "MENUITEMLINKPARAMETERS" ;
      divMenuitemlinkparameters_cell_Internalname = "MENUITEMLINKPARAMETERS_CELL" ;
      chkMenuItemLinkTarget.setInternalname( "MENUITEMLINKTARGET" );
      divMenuitemlinktarget_cell_Internalname = "MENUITEMLINKTARGET_CELL" ;
      chkMenuItemShowDeveloperMenuOptio.setInternalname( "MENUITEMSHOWDEVELOPERMENUOPTIO" );
      divMenuitemshowdevelopermenuoption_cell_Internalname = "MENUITEMSHOWDEVELOPERMENUOPTION_CELL" ;
      chkMenuItemShowEditMenuOptions.setInternalname( "MENUITEMSHOWEDITMENUOPTIONS" );
      divMenuitemshoweditmenuoptions_cell_Internalname = "MENUITEMSHOWEDITMENUOPTIONS_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombomenuitemfatherid_Internalname = "vCOMBOMENUITEMFATHERID" ;
      divSectionattribute_menuitemfatherid_Internalname = "SECTIONATTRIBUTE_MENUITEMFATHERID" ;
      edtMenuItemId_Internalname = "MENUITEMID" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Menu Item" );
      Combo_menuitemfatherid_Visible = GXutil.toBoolean( -1) ;
      edtMenuItemId_Jsonclick = "" ;
      edtMenuItemId_Enabled = 0 ;
      edtMenuItemId_Visible = 1 ;
      edtavCombomenuitemfatherid_Jsonclick = "" ;
      edtavCombomenuitemfatherid_Enabled = 0 ;
      edtavCombomenuitemfatherid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkMenuItemShowEditMenuOptions.setEnabled( 1 );
      chkMenuItemShowEditMenuOptions.setVisible( 1 );
      divMenuitemshoweditmenuoptions_cell_Class = "col-xs-12" ;
      chkMenuItemShowDeveloperMenuOptio.setEnabled( 1 );
      chkMenuItemShowDeveloperMenuOptio.setVisible( 1 );
      divMenuitemshowdevelopermenuoption_cell_Class = "col-xs-12" ;
      chkMenuItemLinkTarget.setEnabled( 1 );
      chkMenuItemLinkTarget.setVisible( 1 );
      divMenuitemlinktarget_cell_Class = "col-xs-12" ;
      edtMenuItemLinkParameters_Jsonclick = "" ;
      edtMenuItemLinkParameters_Enabled = 1 ;
      edtMenuItemLinkParameters_Visible = 1 ;
      divMenuitemlinkparameters_cell_Class = "col-xs-12" ;
      edtMenuItemLink_Jsonclick = "" ;
      edtMenuItemLink_Enabled = 1 ;
      edtMenuItemLink_Visible = 1 ;
      divMenuitemlink_cell_Class = "col-xs-12" ;
      edtMenuItemIconClass_Jsonclick = "" ;
      edtMenuItemIconClass_Enabled = 1 ;
      edtMenuItemIconClass_Visible = 1 ;
      divMenuitemiconclass_cell_Class = "col-xs-12" ;
      cmbMenuItemType.setJsonclick( "" );
      cmbMenuItemType.setEnabled( 1 );
      cmbMenuItemType.setVisible( 1 );
      divMenuitemtype_cell_Class = "col-xs-12" ;
      edtMenuItemCaption_Jsonclick = "" ;
      edtMenuItemCaption_Enabled = 1 ;
      edtMenuItemFatherId_Jsonclick = "" ;
      edtMenuItemFatherId_Enabled = 1 ;
      edtMenuItemFatherId_Visible = 1 ;
      Combo_menuitemfatherid_Datalistprocparametersprefix = " \"ComboName\": \"MenuItemFatherId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"MenuItemId\": 0" ;
      Combo_menuitemfatherid_Datalistproc = "WWPBaseObjects.MenuItemLoadDVCombo" ;
      Combo_menuitemfatherid_Cls = "ExtendedCombo Attribute" ;
      Combo_menuitemfatherid_Caption = "" ;
      Combo_menuitemfatherid_Enabled = GXutil.toBoolean( -1) ;
      divCombo_menuitemfatherid_cell_Class = "col-xs-12" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = "General Information" ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gx28asamenuitemcaption033( String AV14MenuItemCaption ,
                                          byte Gx_BScreen )
   {
      if ( isIns( )  && (GXutil.strcmp("", A12MenuItemCaption)==0) && ( Gx_BScreen == 0 ) )
      {
         A12MenuItemCaption = AV14MenuItemCaption ;
         httpContext.ajax_rsp_assign_attri("", false, "A12MenuItemCaption", A12MenuItemCaption);
      }
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A12MenuItemCaption)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx29asamenuitemcaption033( )
   {
      GXt_int9 = (short)(0) ;
      GXv_int8[0] = GXt_int9 ;
      new com.wwpbaseobjects.getamountofmainmenus(remoteHandle, context).execute( "MainMenu", GXv_int8) ;
      menuitem_impl.this.GXt_int9 = GXv_int8[0] ;
      if ( GXt_int9 == 0 )
      {
         A12MenuItemCaption = "MainMenu" ;
         httpContext.ajax_rsp_assign_attri("", false, "A12MenuItemCaption", A12MenuItemCaption);
      }
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A12MenuItemCaption)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_36_033( short A10MenuItemId )
   {
      GXv_int8[0] = A10MenuItemId ;
      new com.wwpbaseobjects.updatemenuitemorder(remoteHandle, context).execute( GXv_int8) ;
      A10MenuItemId = GXv_int8[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A10MenuItemId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10MenuItemId), 4, 0));
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A10MenuItemId, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      cmbMenuItemType.setName( "MENUITEMTYPE" );
      cmbMenuItemType.setWebtags( "" );
      cmbMenuItemType.addItem("1", "Link Item", (short)(0));
      cmbMenuItemType.addItem("2", "Menu", (short)(0));
      if ( cmbMenuItemType.getItemCount() > 0 )
      {
         A16MenuItemType = (byte)(GXutil.lval( cmbMenuItemType.getValidValue(GXutil.trim( GXutil.str( A16MenuItemType, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A16MenuItemType", GXutil.str( A16MenuItemType, 1, 0));
      }
      chkMenuItemLinkTarget.setName( "MENUITEMLINKTARGET" );
      chkMenuItemLinkTarget.setWebtags( "" );
      chkMenuItemLinkTarget.setCaption( "Open in new tab/window" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemLinkTarget.getInternalname(), "TitleCaption", chkMenuItemLinkTarget.getCaption(), true);
      chkMenuItemLinkTarget.setCheckedValue( "_" );
      A14MenuItemLinkTarget = ((GXutil.strcmp(A14MenuItemLinkTarget, "_blank")==0) ? "_blank" : "_") ;
      httpContext.ajax_rsp_assign_attri("", false, "A14MenuItemLinkTarget", A14MenuItemLinkTarget);
      chkMenuItemShowDeveloperMenuOptio.setName( "MENUITEMSHOWDEVELOPERMENUOPTIO" );
      chkMenuItemShowDeveloperMenuOptio.setWebtags( "" );
      chkMenuItemShowDeveloperMenuOptio.setCaption( "Mostrar menú de desarrollo" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemShowDeveloperMenuOptio.getInternalname(), "TitleCaption", chkMenuItemShowDeveloperMenuOptio.getCaption(), true);
      chkMenuItemShowDeveloperMenuOptio.setCheckedValue( "false" );
      if ( isIns( ) && (false==A20MenuItemShowDeveloperMenuOptio) )
      {
         A20MenuItemShowDeveloperMenuOptio = AV16MenuItemShowDeveloperMenuOption ;
         httpContext.ajax_rsp_assign_attri("", false, "A20MenuItemShowDeveloperMenuOptio", A20MenuItemShowDeveloperMenuOptio);
      }
      chkMenuItemShowEditMenuOptions.setName( "MENUITEMSHOWEDITMENUOPTIONS" );
      chkMenuItemShowEditMenuOptions.setWebtags( "" );
      chkMenuItemShowEditMenuOptions.setCaption( "Mostrar opción para editar menú" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuItemShowEditMenuOptions.getInternalname(), "TitleCaption", chkMenuItemShowEditMenuOptions.getCaption(), true);
      chkMenuItemShowEditMenuOptions.setCheckedValue( "false" );
      if ( isIns( ) && (false==A21MenuItemShowEditMenuOptions) )
      {
         A21MenuItemShowEditMenuOptions = AV16MenuItemShowDeveloperMenuOption ;
         httpContext.ajax_rsp_assign_attri("", false, "A21MenuItemShowEditMenuOptions", A21MenuItemShowEditMenuOptions);
      }
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Menuitemfatherid( )
   {
      n11MenuItemFatherId = false ;
      /* Using cursor T000314 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A11MenuItemFatherId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Menu Item Father'.", "ForeignKeyNotFound", 1, "MENUITEMFATHERID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtMenuItemFatherId_Internalname ;
         }
      }
      A17MenuItemFatherCaption = T000314_A17MenuItemFatherCaption[0] ;
      A19MenuItemFatherType = T000314_A19MenuItemFatherType[0] ;
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A17MenuItemFatherCaption", A17MenuItemFatherCaption);
      httpContext.ajax_rsp_assign_attri("", false, "A19MenuItemFatherType", GXutil.ltrim( localUtil.ntoc( A19MenuItemFatherType, (byte)(1), (byte)(0), ".", "")));
   }

   public void valid_Menuitemcaption( )
   {
      if ( ( new com.wwpbaseobjects.getamountofmainmenus(remoteHandle, context).executeUdp( A12MenuItemCaption) > 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         httpContext.GX_msglist.addItem("Ya existe", 1, "MENUITEMCAPTION");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMenuItemCaption_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7MenuItemId',fld:'vMENUITEMID',pic:'ZZZ9',hsh:true},{av:'AV13MenuItemFatherId',fld:'vMENUITEMFATHERID',pic:'ZZZ9'},{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7MenuItemId',fld:'vMENUITEMID',pic:'ZZZ9',hsh:true},{av:'A22MenuItemOrder',fld:'MENUITEMORDER',pic:'ZZZ9'},{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12032',iparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]}");
      setEventMetadata("VALID_MENUITEMFATHERID","{handler:'valid_Menuitemfatherid',iparms:[{av:'A11MenuItemFatherId',fld:'MENUITEMFATHERID',pic:'ZZZ9'},{av:'A17MenuItemFatherCaption',fld:'MENUITEMFATHERCAPTION',pic:''},{av:'A19MenuItemFatherType',fld:'MENUITEMFATHERTYPE',pic:'9'},{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]");
      setEventMetadata("VALID_MENUITEMFATHERID",",oparms:[{av:'A17MenuItemFatherCaption',fld:'MENUITEMFATHERCAPTION',pic:''},{av:'A19MenuItemFatherType',fld:'MENUITEMFATHERTYPE',pic:'9'},{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]}");
      setEventMetadata("VALID_MENUITEMCAPTION","{handler:'valid_Menuitemcaption',iparms:[{av:'A12MenuItemCaption',fld:'MENUITEMCAPTION',pic:''},{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]");
      setEventMetadata("VALID_MENUITEMCAPTION",",oparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]}");
      setEventMetadata("VALID_MENUITEMTYPE","{handler:'valid_Menuitemtype',iparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]");
      setEventMetadata("VALID_MENUITEMTYPE",",oparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]}");
      setEventMetadata("VALIDV_COMBOMENUITEMFATHERID","{handler:'validv_Combomenuitemfatherid',iparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]");
      setEventMetadata("VALIDV_COMBOMENUITEMFATHERID",",oparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]}");
      setEventMetadata("VALID_MENUITEMID","{handler:'valid_Menuitemid',iparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]");
      setEventMetadata("VALID_MENUITEMID",",oparms:[{av:'A14MenuItemLinkTarget',fld:'MENUITEMLINKTARGET',pic:''},{av:'A20MenuItemShowDeveloperMenuOptio',fld:'MENUITEMSHOWDEVELOPERMENUOPTIO',pic:''},{av:'A21MenuItemShowEditMenuOptions',fld:'MENUITEMSHOWEDITMENUOPTIONS',pic:''}]}");
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z12MenuItemCaption = "" ;
      Z13MenuItemLink = "" ;
      Z18MenuItemLinkParameters = "" ;
      Z14MenuItemLinkTarget = "" ;
      Z15MenuItemIconClass = "" ;
      Combo_menuitemfatherid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV14MenuItemCaption = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A14MenuItemLinkTarget = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockmenuitemfatherid_Jsonclick = "" ;
      ucCombo_menuitemfatherid = new com.genexus.webpanels.GXUserControl();
      AV18DDO_TitleSettingsIcons = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV17MenuItemFatherId_Data = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A12MenuItemCaption = "" ;
      A15MenuItemIconClass = "" ;
      A13MenuItemLink = "" ;
      A18MenuItemLinkParameters = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV15MenuItemIconClass = "" ;
      A17MenuItemFatherCaption = "" ;
      AV24Pgmname = "" ;
      Combo_menuitemfatherid_Objectcall = "" ;
      Combo_menuitemfatherid_Class = "" ;
      Combo_menuitemfatherid_Icontype = "" ;
      Combo_menuitemfatherid_Icon = "" ;
      Combo_menuitemfatherid_Tooltip = "" ;
      Combo_menuitemfatherid_Selectedvalue_set = "" ;
      Combo_menuitemfatherid_Selectedtext_set = "" ;
      Combo_menuitemfatherid_Selectedtext_get = "" ;
      Combo_menuitemfatherid_Gamoauthtoken = "" ;
      Combo_menuitemfatherid_Ddointernalname = "" ;
      Combo_menuitemfatherid_Titlecontrolalign = "" ;
      Combo_menuitemfatherid_Dropdownoptionstype = "" ;
      Combo_menuitemfatherid_Titlecontrolidtoreplace = "" ;
      Combo_menuitemfatherid_Datalisttype = "" ;
      Combo_menuitemfatherid_Datalistfixedvalues = "" ;
      Combo_menuitemfatherid_Remoteservicesparameters = "" ;
      Combo_menuitemfatherid_Htmltemplate = "" ;
      Combo_menuitemfatherid_Multiplevaluestype = "" ;
      Combo_menuitemfatherid_Loadingdata = "" ;
      Combo_menuitemfatherid_Noresultsfound = "" ;
      Combo_menuitemfatherid_Emptyitemtext = "" ;
      Combo_menuitemfatherid_Onlyselectedvalues = "" ;
      Combo_menuitemfatherid_Selectalltext = "" ;
      Combo_menuitemfatherid_Multiplevaluesseparator = "" ;
      Combo_menuitemfatherid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode3 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new com.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV9TrnContext = new com.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV12TrnContextAtt = new com.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV21Combo_DataJson = "" ;
      AV19ComboSelectedValue = "" ;
      AV20ComboSelectedText = "" ;
      GXt_char4 = "" ;
      GXv_char7 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char5 = new String[1] ;
      Z17MenuItemFatherCaption = "" ;
      T00034_A17MenuItemFatherCaption = new String[] {""} ;
      T00034_A19MenuItemFatherType = new byte[1] ;
      T00035_A10MenuItemId = new short[1] ;
      T00035_A16MenuItemType = new byte[1] ;
      T00035_A12MenuItemCaption = new String[] {""} ;
      T00035_A22MenuItemOrder = new short[1] ;
      T00035_A17MenuItemFatherCaption = new String[] {""} ;
      T00035_A19MenuItemFatherType = new byte[1] ;
      T00035_A13MenuItemLink = new String[] {""} ;
      T00035_A18MenuItemLinkParameters = new String[] {""} ;
      T00035_A14MenuItemLinkTarget = new String[] {""} ;
      T00035_A15MenuItemIconClass = new String[] {""} ;
      T00035_A20MenuItemShowDeveloperMenuOptio = new boolean[] {false} ;
      T00035_A21MenuItemShowEditMenuOptions = new boolean[] {false} ;
      T00035_A11MenuItemFatherId = new short[1] ;
      T00035_n11MenuItemFatherId = new boolean[] {false} ;
      T00036_A17MenuItemFatherCaption = new String[] {""} ;
      T00036_A19MenuItemFatherType = new byte[1] ;
      T00037_A10MenuItemId = new short[1] ;
      T00033_A10MenuItemId = new short[1] ;
      T00033_A16MenuItemType = new byte[1] ;
      T00033_A12MenuItemCaption = new String[] {""} ;
      T00033_A22MenuItemOrder = new short[1] ;
      T00033_A13MenuItemLink = new String[] {""} ;
      T00033_A18MenuItemLinkParameters = new String[] {""} ;
      T00033_A14MenuItemLinkTarget = new String[] {""} ;
      T00033_A15MenuItemIconClass = new String[] {""} ;
      T00033_A20MenuItemShowDeveloperMenuOptio = new boolean[] {false} ;
      T00033_A21MenuItemShowEditMenuOptions = new boolean[] {false} ;
      T00033_A11MenuItemFatherId = new short[1] ;
      T00033_n11MenuItemFatherId = new boolean[] {false} ;
      T00038_A10MenuItemId = new short[1] ;
      T00039_A10MenuItemId = new short[1] ;
      T00032_A10MenuItemId = new short[1] ;
      T00032_A16MenuItemType = new byte[1] ;
      T00032_A12MenuItemCaption = new String[] {""} ;
      T00032_A22MenuItemOrder = new short[1] ;
      T00032_A13MenuItemLink = new String[] {""} ;
      T00032_A18MenuItemLinkParameters = new String[] {""} ;
      T00032_A14MenuItemLinkTarget = new String[] {""} ;
      T00032_A15MenuItemIconClass = new String[] {""} ;
      T00032_A20MenuItemShowDeveloperMenuOptio = new boolean[] {false} ;
      T00032_A21MenuItemShowEditMenuOptions = new boolean[] {false} ;
      T00032_A11MenuItemFatherId = new short[1] ;
      T00032_n11MenuItemFatherId = new boolean[] {false} ;
      T000311_A10MenuItemId = new short[1] ;
      T000314_A17MenuItemFatherCaption = new String[] {""} ;
      T000314_A19MenuItemFatherType = new byte[1] ;
      T000315_A11MenuItemFatherId = new short[1] ;
      T000315_n11MenuItemFatherId = new boolean[] {false} ;
      T000316_A10MenuItemId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i12MenuItemCaption = "" ;
      i15MenuItemIconClass = "" ;
      GXv_int8 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.menuitem__default(),
         new Object[] {
             new Object[] {
            T00032_A10MenuItemId, T00032_A16MenuItemType, T00032_A12MenuItemCaption, T00032_A22MenuItemOrder, T00032_A13MenuItemLink, T00032_A18MenuItemLinkParameters, T00032_A14MenuItemLinkTarget, T00032_A15MenuItemIconClass, T00032_A20MenuItemShowDeveloperMenuOptio, T00032_A21MenuItemShowEditMenuOptions,
            T00032_A11MenuItemFatherId, T00032_n11MenuItemFatherId
            }
            , new Object[] {
            T00033_A10MenuItemId, T00033_A16MenuItemType, T00033_A12MenuItemCaption, T00033_A22MenuItemOrder, T00033_A13MenuItemLink, T00033_A18MenuItemLinkParameters, T00033_A14MenuItemLinkTarget, T00033_A15MenuItemIconClass, T00033_A20MenuItemShowDeveloperMenuOptio, T00033_A21MenuItemShowEditMenuOptions,
            T00033_A11MenuItemFatherId, T00033_n11MenuItemFatherId
            }
            , new Object[] {
            T00034_A17MenuItemFatherCaption, T00034_A19MenuItemFatherType
            }
            , new Object[] {
            T00035_A10MenuItemId, T00035_A16MenuItemType, T00035_A12MenuItemCaption, T00035_A22MenuItemOrder, T00035_A17MenuItemFatherCaption, T00035_A19MenuItemFatherType, T00035_A13MenuItemLink, T00035_A18MenuItemLinkParameters, T00035_A14MenuItemLinkTarget, T00035_A15MenuItemIconClass,
            T00035_A20MenuItemShowDeveloperMenuOptio, T00035_A21MenuItemShowEditMenuOptions, T00035_A11MenuItemFatherId, T00035_n11MenuItemFatherId
            }
            , new Object[] {
            T00036_A17MenuItemFatherCaption, T00036_A19MenuItemFatherType
            }
            , new Object[] {
            T00037_A10MenuItemId
            }
            , new Object[] {
            T00038_A10MenuItemId
            }
            , new Object[] {
            T00039_A10MenuItemId
            }
            , new Object[] {
            }
            , new Object[] {
            T000311_A10MenuItemId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000314_A17MenuItemFatherCaption, T000314_A19MenuItemFatherType
            }
            , new Object[] {
            T000315_A11MenuItemFatherId
            }
            , new Object[] {
            T000316_A10MenuItemId
            }
         }
      );
      AV24Pgmname = "WWPBaseObjects.MenuItem" ;
      Z21MenuItemShowEditMenuOptions = false ;
      A21MenuItemShowEditMenuOptions = false ;
      i21MenuItemShowEditMenuOptions = false ;
      Z20MenuItemShowDeveloperMenuOptio = false ;
      A20MenuItemShowDeveloperMenuOptio = false ;
      i20MenuItemShowDeveloperMenuOptio = false ;
      Z15MenuItemIconClass = "" ;
      A15MenuItemIconClass = "" ;
      i15MenuItemIconClass = "" ;
      Z12MenuItemCaption = "" ;
      A12MenuItemCaption = "" ;
      i12MenuItemCaption = "" ;
   }

   private byte Z16MenuItemType ;
   private byte GxWebError ;
   private byte Gx_BScreen ;
   private byte nKeyPressed ;
   private byte A16MenuItemType ;
   private byte A19MenuItemFatherType ;
   private byte Z19MenuItemFatherType ;
   private byte gxajaxcallmode ;
   private short wcpOAV7MenuItemId ;
   private short wcpOAV13MenuItemFatherId ;
   private short Z10MenuItemId ;
   private short Z22MenuItemOrder ;
   private short Z11MenuItemFatherId ;
   private short N11MenuItemFatherId ;
   private short A10MenuItemId ;
   private short A11MenuItemFatherId ;
   private short AV7MenuItemId ;
   private short AV13MenuItemFatherId ;
   private short gxcookieaux ;
   private short AnyError ;
   private short IsModified ;
   private short IsConfirmed ;
   private short AV22ComboMenuItemFatherId ;
   private short A22MenuItemOrder ;
   private short AV11Insert_MenuItemFatherId ;
   private short RcdFound3 ;
   private short GXt_int9 ;
   private short GXv_int8[] ;
   private int trnEnded ;
   private int edtMenuItemFatherId_Visible ;
   private int edtMenuItemFatherId_Enabled ;
   private int edtMenuItemCaption_Enabled ;
   private int edtMenuItemIconClass_Visible ;
   private int edtMenuItemIconClass_Enabled ;
   private int edtMenuItemLink_Visible ;
   private int edtMenuItemLink_Enabled ;
   private int edtMenuItemLinkParameters_Visible ;
   private int edtMenuItemLinkParameters_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombomenuitemfatherid_Enabled ;
   private int edtavCombomenuitemfatherid_Visible ;
   private int edtMenuItemId_Enabled ;
   private int edtMenuItemId_Visible ;
   private int Combo_menuitemfatherid_Datalistupdateminimumcharacters ;
   private int Combo_menuitemfatherid_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV25GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Combo_menuitemfatherid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtMenuItemFatherId_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String divCombo_menuitemfatherid_cell_Internalname ;
   private String divCombo_menuitemfatherid_cell_Class ;
   private String divTablesplittedmenuitemfatherid_Internalname ;
   private String lblTextblockmenuitemfatherid_Internalname ;
   private String lblTextblockmenuitemfatherid_Jsonclick ;
   private String Combo_menuitemfatherid_Caption ;
   private String Combo_menuitemfatherid_Cls ;
   private String Combo_menuitemfatherid_Datalistproc ;
   private String Combo_menuitemfatherid_Datalistprocparametersprefix ;
   private String Combo_menuitemfatherid_Internalname ;
   private String TempTags ;
   private String edtMenuItemFatherId_Jsonclick ;
   private String edtMenuItemCaption_Internalname ;
   private String edtMenuItemCaption_Jsonclick ;
   private String divMenuitemtype_cell_Internalname ;
   private String divMenuitemtype_cell_Class ;
   private String divMenuitemiconclass_cell_Internalname ;
   private String divMenuitemiconclass_cell_Class ;
   private String edtMenuItemIconClass_Internalname ;
   private String edtMenuItemIconClass_Jsonclick ;
   private String divMenuitemlink_cell_Internalname ;
   private String divMenuitemlink_cell_Class ;
   private String edtMenuItemLink_Internalname ;
   private String edtMenuItemLink_Jsonclick ;
   private String divMenuitemlinkparameters_cell_Internalname ;
   private String divMenuitemlinkparameters_cell_Class ;
   private String edtMenuItemLinkParameters_Internalname ;
   private String edtMenuItemLinkParameters_Jsonclick ;
   private String divMenuitemlinktarget_cell_Internalname ;
   private String divMenuitemlinktarget_cell_Class ;
   private String divMenuitemshowdevelopermenuoption_cell_Internalname ;
   private String divMenuitemshowdevelopermenuoption_cell_Class ;
   private String divMenuitemshoweditmenuoptions_cell_Internalname ;
   private String divMenuitemshoweditmenuoptions_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_menuitemfatherid_Internalname ;
   private String edtavCombomenuitemfatherid_Internalname ;
   private String edtavCombomenuitemfatherid_Jsonclick ;
   private String edtMenuItemId_Internalname ;
   private String edtMenuItemId_Jsonclick ;
   private String AV24Pgmname ;
   private String Combo_menuitemfatherid_Objectcall ;
   private String Combo_menuitemfatherid_Class ;
   private String Combo_menuitemfatherid_Icontype ;
   private String Combo_menuitemfatherid_Icon ;
   private String Combo_menuitemfatherid_Tooltip ;
   private String Combo_menuitemfatherid_Selectedvalue_set ;
   private String Combo_menuitemfatherid_Selectedtext_set ;
   private String Combo_menuitemfatherid_Selectedtext_get ;
   private String Combo_menuitemfatherid_Gamoauthtoken ;
   private String Combo_menuitemfatherid_Ddointernalname ;
   private String Combo_menuitemfatherid_Titlecontrolalign ;
   private String Combo_menuitemfatherid_Dropdownoptionstype ;
   private String Combo_menuitemfatherid_Titlecontrolidtoreplace ;
   private String Combo_menuitemfatherid_Datalisttype ;
   private String Combo_menuitemfatherid_Datalistfixedvalues ;
   private String Combo_menuitemfatherid_Remoteservicesparameters ;
   private String Combo_menuitemfatherid_Htmltemplate ;
   private String Combo_menuitemfatherid_Multiplevaluestype ;
   private String Combo_menuitemfatherid_Loadingdata ;
   private String Combo_menuitemfatherid_Noresultsfound ;
   private String Combo_menuitemfatherid_Emptyitemtext ;
   private String Combo_menuitemfatherid_Onlyselectedvalues ;
   private String Combo_menuitemfatherid_Selectalltext ;
   private String Combo_menuitemfatherid_Multiplevaluesseparator ;
   private String Combo_menuitemfatherid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode3 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char4 ;
   private String GXv_char7[] ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean Z20MenuItemShowDeveloperMenuOptio ;
   private boolean Z21MenuItemShowEditMenuOptions ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n11MenuItemFatherId ;
   private boolean wbErr ;
   private boolean A20MenuItemShowDeveloperMenuOptio ;
   private boolean A21MenuItemShowEditMenuOptions ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV16MenuItemShowDeveloperMenuOption ;
   private boolean Combo_menuitemfatherid_Enabled ;
   private boolean Combo_menuitemfatherid_Visible ;
   private boolean Combo_menuitemfatherid_Allowmultipleselection ;
   private boolean Combo_menuitemfatherid_Isgriditem ;
   private boolean Combo_menuitemfatherid_Hasdescription ;
   private boolean Combo_menuitemfatherid_Includeonlyselectedoption ;
   private boolean Combo_menuitemfatherid_Includeselectalloption ;
   private boolean Combo_menuitemfatherid_Emptyitem ;
   private boolean Combo_menuitemfatherid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean Gx_longc ;
   private boolean i20MenuItemShowDeveloperMenuOptio ;
   private boolean i21MenuItemShowEditMenuOptions ;
   private String AV21Combo_DataJson ;
   private String Z12MenuItemCaption ;
   private String Z13MenuItemLink ;
   private String Z18MenuItemLinkParameters ;
   private String Z14MenuItemLinkTarget ;
   private String Z15MenuItemIconClass ;
   private String AV14MenuItemCaption ;
   private String A14MenuItemLinkTarget ;
   private String A12MenuItemCaption ;
   private String A15MenuItemIconClass ;
   private String A13MenuItemLink ;
   private String A18MenuItemLinkParameters ;
   private String AV15MenuItemIconClass ;
   private String A17MenuItemFatherCaption ;
   private String AV19ComboSelectedValue ;
   private String AV20ComboSelectedText ;
   private String Z17MenuItemFatherCaption ;
   private String i12MenuItemCaption ;
   private String i15MenuItemIconClass ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_menuitemfatherid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbMenuItemType ;
   private ICheckbox chkMenuItemLinkTarget ;
   private ICheckbox chkMenuItemShowDeveloperMenuOptio ;
   private ICheckbox chkMenuItemShowEditMenuOptions ;
   private IDataStoreProvider pr_default ;
   private String[] T00034_A17MenuItemFatherCaption ;
   private byte[] T00034_A19MenuItemFatherType ;
   private short[] T00035_A10MenuItemId ;
   private byte[] T00035_A16MenuItemType ;
   private String[] T00035_A12MenuItemCaption ;
   private short[] T00035_A22MenuItemOrder ;
   private String[] T00035_A17MenuItemFatherCaption ;
   private byte[] T00035_A19MenuItemFatherType ;
   private String[] T00035_A13MenuItemLink ;
   private String[] T00035_A18MenuItemLinkParameters ;
   private String[] T00035_A14MenuItemLinkTarget ;
   private String[] T00035_A15MenuItemIconClass ;
   private boolean[] T00035_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] T00035_A21MenuItemShowEditMenuOptions ;
   private short[] T00035_A11MenuItemFatherId ;
   private boolean[] T00035_n11MenuItemFatherId ;
   private String[] T00036_A17MenuItemFatherCaption ;
   private byte[] T00036_A19MenuItemFatherType ;
   private short[] T00037_A10MenuItemId ;
   private short[] T00033_A10MenuItemId ;
   private byte[] T00033_A16MenuItemType ;
   private String[] T00033_A12MenuItemCaption ;
   private short[] T00033_A22MenuItemOrder ;
   private String[] T00033_A13MenuItemLink ;
   private String[] T00033_A18MenuItemLinkParameters ;
   private String[] T00033_A14MenuItemLinkTarget ;
   private String[] T00033_A15MenuItemIconClass ;
   private boolean[] T00033_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] T00033_A21MenuItemShowEditMenuOptions ;
   private short[] T00033_A11MenuItemFatherId ;
   private boolean[] T00033_n11MenuItemFatherId ;
   private short[] T00038_A10MenuItemId ;
   private short[] T00039_A10MenuItemId ;
   private short[] T00032_A10MenuItemId ;
   private byte[] T00032_A16MenuItemType ;
   private String[] T00032_A12MenuItemCaption ;
   private short[] T00032_A22MenuItemOrder ;
   private String[] T00032_A13MenuItemLink ;
   private String[] T00032_A18MenuItemLinkParameters ;
   private String[] T00032_A14MenuItemLinkTarget ;
   private String[] T00032_A15MenuItemIconClass ;
   private boolean[] T00032_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] T00032_A21MenuItemShowEditMenuOptions ;
   private short[] T00032_A11MenuItemFatherId ;
   private boolean[] T00032_n11MenuItemFatherId ;
   private short[] T000311_A10MenuItemId ;
   private String[] T000314_A17MenuItemFatherCaption ;
   private byte[] T000314_A19MenuItemFatherType ;
   private short[] T000315_A11MenuItemFatherId ;
   private boolean[] T000315_n11MenuItemFatherId ;
   private short[] T000316_A10MenuItemId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV17MenuItemFatherId_Data ;
   private com.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV12TrnContextAtt ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV18DDO_TitleSettingsIcons ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class menuitem__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00032", "SELECT MenuItemId, MenuItemType, MenuItemCaption, MenuItemOrder, MenuItemLink, MenuItemLinkParameters, MenuItemLinkTarget, MenuItemIconClass, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions, MenuItemFatherId FROM MenuItem WHERE MenuItemId = ?  FOR UPDATE OF MenuItem NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00033", "SELECT MenuItemId, MenuItemType, MenuItemCaption, MenuItemOrder, MenuItemLink, MenuItemLinkParameters, MenuItemLinkTarget, MenuItemIconClass, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions, MenuItemFatherId FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00034", "SELECT MenuItemCaption AS MenuItemFatherCaption, MenuItemType AS MenuItemFatherType FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00035", "SELECT TM1.MenuItemId, TM1.MenuItemType, TM1.MenuItemCaption, TM1.MenuItemOrder, T2.MenuItemCaption AS MenuItemFatherCaption, T2.MenuItemType AS MenuItemFatherType, TM1.MenuItemLink, TM1.MenuItemLinkParameters, TM1.MenuItemLinkTarget, TM1.MenuItemIconClass, TM1.MenuItemShowDeveloperMenuOptio, TM1.MenuItemShowEditMenuOptions, TM1.MenuItemFatherId AS MenuItemFatherId FROM (MenuItem TM1 LEFT JOIN MenuItem T2 ON T2.MenuItemId = TM1.MenuItemFatherId) WHERE TM1.MenuItemId = ? ORDER BY TM1.MenuItemId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00036", "SELECT MenuItemCaption AS MenuItemFatherCaption, MenuItemType AS MenuItemFatherType FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00037", "SELECT MenuItemId FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00038", "SELECT MenuItemId FROM MenuItem WHERE ( MenuItemId > ?) ORDER BY MenuItemId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00039", "SELECT MenuItemId FROM MenuItem WHERE ( MenuItemId < ?) ORDER BY MenuItemId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000310", "SAVEPOINT gxupdate;INSERT INTO MenuItem(MenuItemType, MenuItemCaption, MenuItemOrder, MenuItemLink, MenuItemLinkParameters, MenuItemLinkTarget, MenuItemIconClass, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions, MenuItemFatherId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000311", "SELECT currval('MenuItemId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000312", "SAVEPOINT gxupdate;UPDATE MenuItem SET MenuItemType=?, MenuItemCaption=?, MenuItemOrder=?, MenuItemLink=?, MenuItemLinkParameters=?, MenuItemLinkTarget=?, MenuItemIconClass=?, MenuItemShowDeveloperMenuOptio=?, MenuItemShowEditMenuOptions=?, MenuItemFatherId=?  WHERE MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000313", "SAVEPOINT gxupdate;DELETE FROM MenuItem  WHERE MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000314", "SELECT MenuItemCaption AS MenuItemFatherCaption, MenuItemType AS MenuItemFatherType FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000315", "SELECT MenuItemId AS MenuItemFatherId FROM MenuItem WHERE MenuItemFatherId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000316", "SELECT MenuItemId FROM MenuItem ORDER BY MenuItemId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setVarchar(6, (String)parms[5], 10, false);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[10]).shortValue());
               }
               return;
            case 10 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setVarchar(6, (String)parms[5], 10, false);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[10]).shortValue());
               }
               stmt.setShort(11, ((Number) parms[11]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

