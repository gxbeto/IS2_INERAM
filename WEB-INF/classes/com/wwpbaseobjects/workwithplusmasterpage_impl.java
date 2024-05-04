package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class workwithplusmasterpage_impl extends GXMasterPage
{
   public workwithplusmasterpage_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public workwithplusmasterpage_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( workwithplusmasterpage_impl.class ));
   }

   public workwithplusmasterpage_impl( int remoteHandle ,
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
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa0R2( ) ;
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws0R2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we0R2( ) ;
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         GXWebForm.addResponsiveMetaHeaders((getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getMeta());
         getDataAreaObject().renderHtmlHeaders();
      }
   }

   public void renderHtmlOpenForm( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlOpenForm();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "vPROGRAMDESCRIPTION_MPAGE", AV37ProgramDescription);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROGRAMDESCRIPTION_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV37ProgramDescription, ""))));
      com.GxWebStd.gx_hidden_field( httpContext, "vINDEXTOADDITEMS_MPAGE", GXutil.ltrim( localUtil.ntoc( AV36IndexToAddItems, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINDEXTOADDITEMS_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV36IndexToAddItems), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vBOOKMARKSDATA_MPAGE", AV31BookmarksData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBOOKMARKSDATA_MPAGE", AV31BookmarksData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vDVELOP_MENU_MPAGE", AV23DVelop_Menu);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_MENU_MPAGE", AV23DVelop_Menu);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vDVELOP_MENU_USERDATA_MPAGE", AV29DVelop_Menu_UserData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_MENU_USERDATA_MPAGE", AV29DVelop_Menu_UserData);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "vPROGRAMDESCRIPTION_MPAGE", AV37ProgramDescription);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROGRAMDESCRIPTION_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV37ProgramDescription, ""))));
      com.GxWebStd.gx_hidden_field( httpContext, "vSEARCHAUX_MPAGE", AV15SearchAux);
      com.GxWebStd.gx_hidden_field( httpContext, "vINDEXTOADDITEMS_MPAGE", GXutil.ltrim( localUtil.ntoc( AV36IndexToAddItems, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINDEXTOADDITEMS_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV36IndexToAddItems), "ZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Icontype", GXutil.rtrim( Ddo_bookmarks_Icontype));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Icon", GXutil.rtrim( Ddo_bookmarks_Icon));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Tooltip", GXutil.rtrim( Ddo_bookmarks_Tooltip));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Cls", GXutil.rtrim( Ddo_bookmarks_Cls));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Titlecontrolalign", GXutil.rtrim( Ddo_bookmarks_Titlecontrolalign));
      com.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Icontype", GXutil.rtrim( Ddc_adminag_Icontype));
      com.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Icon", GXutil.rtrim( Ddc_adminag_Icon));
      com.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Cls", GXutil.rtrim( Ddc_adminag_Cls));
      com.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Componentwidth", GXutil.ltrim( localUtil.ntoc( Ddc_adminag_Componentwidth, (byte)(9), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Sidebarmainclass", GXutil.rtrim( Ucmenu_Sidebarmainclass));
      com.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Scrollwidth", GXutil.ltrim( localUtil.ntoc( Ucmenu_Scrollwidth, (byte)(9), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Scrollalwaysvisible", GXutil.booltostr( Ucmenu_Scrollalwaysvisible));
      com.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Hidescrollincompactmenu", GXutil.booltostr( Ucmenu_Hidescrollincompactmenu));
      com.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Stoponerror", GXutil.booltostr( Ucmessage_Stoponerror));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enablefixobjectfitcover", GXutil.booltostr( Wwputilities_Enablefixobjectfitcover));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Empowertabs", GXutil.booltostr( Wwputilities_Empowertabs));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enableupdaterowselectionstatus", GXutil.booltostr( Wwputilities_Enableupdaterowselectionstatus));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enableconvertcombotobootstrapselect", GXutil.booltostr( Wwputilities_Enableconvertcombotobootstrapselect));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnresizing", GXutil.booltostr( Wwputilities_Allowcolumnresizing));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnreordering", GXutil.booltostr( Wwputilities_Allowcolumnreordering));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumndragging", GXutil.booltostr( Wwputilities_Allowcolumndragging));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnsrestore", GXutil.booltostr( Wwputilities_Allowcolumnsrestore));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Pagbarincludegoto", GXutil.booltostr( Wwputilities_Pagbarincludegoto));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Comboloadtype", GXutil.rtrim( Wwputilities_Comboloadtype));
      com.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Iteminternalname", GXutil.rtrim( Popover_search_Iteminternalname));
      com.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Trigger", GXutil.rtrim( Popover_search_Trigger));
      com.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Triggerelement", GXutil.rtrim( Popover_search_Triggerelement));
      com.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Popoverwidth", GXutil.ltrim( localUtil.ntoc( Popover_search_Popoverwidth, (byte)(9), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Position", GXutil.rtrim( Popover_search_Position));
      com.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Keepopened", GXutil.booltostr( Popover_search_Keepopened));
      com.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Reloadonkeychange", GXutil.booltostr( Popover_search_Reloadonkeychange));
      com.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Minimumcharacters", GXutil.ltrim( localUtil.ntoc( Popover_search_Minimumcharacters, (byte)(9), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "BOOKMARK_MODAL_MPAGE_Width", GXutil.rtrim( Bookmark_modal_Width));
      com.GxWebStd.gx_hidden_field( httpContext, "BOOKMARK_MODAL_MPAGE_Title", GXutil.rtrim( Bookmark_modal_Title));
      com.GxWebStd.gx_hidden_field( httpContext, "BOOKMARK_MODAL_MPAGE_Confirmtype", GXutil.rtrim( Bookmark_modal_Confirmtype));
      com.GxWebStd.gx_hidden_field( httpContext, "BOOKMARK_MODAL_MPAGE_Bodytype", GXutil.rtrim( Bookmark_modal_Bodytype));
      com.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_bookmarks_Activeeventkey));
      com.GxWebStd.gx_hidden_field( httpContext, "vHTTPREQUEST_MPAGE_Baseurl", GXutil.rtrim( AV27Httprequest.getBaseURL()));
      com.GxWebStd.gx_hidden_field( httpContext, "FORM_MPAGE_Caption", GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption()));
      com.GxWebStd.gx_hidden_field( httpContext, "FORM_MPAGE_Caption", GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption()));
   }

   public void renderHtmlCloseForm0R2( )
   {
      sendCloseFormHiddens( ) ;
      sendSecurityToken(sPrefix);
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlCloseForm();
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         WebComp_Wwpaux_wc.componentjscripts();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1720180), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1720180), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1720180), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/slimscroll/jquery.slimscroll.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/SidebarMenu/BootstrapSidebarMenuRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Tooltip/BootstrapTooltipRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DatePicker/DatePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("wwpbaseobjects/workwithplusmasterpage.js", "?2024426171721", false, true);
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.WorkWithPlusMasterPage" ;
   }

   public String getPgmdesc( )
   {
      return "Master Page" ;
   }

   public void wb0R0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         if ( ! ShowMPWhenPopUp( ) && httpContext.isPopUpObject( ) )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            /* Content placeholder */
            httpContext.writeText( "<div") ;
            com.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
            httpContext.writeText( ">") ;
            if ( ! isFullAjaxMode( ) )
            {
               getDataAreaObject().renderHtmlContent();
            }
            httpContext.writeText( "</div>") ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
            wbLoad = true ;
            return  ;
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
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainWhiteHeader", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "TableHeaderSidebarImage", "start", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "start", "top", "", "", "div");
         wb_table1_11_0R2( true) ;
      }
      else
      {
         wb_table1_11_0R2( false) ;
      }
      return  ;
   }

   public void wb_table1_11_0R2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "ShowMenuImageCellNotFixedRight page-content", "start", "top", "", "flex-grow:1;", "div");
         wb_table2_18_0R2( true) ;
      }
      else
      {
         wb_table2_18_0R2( false) ;
      }
      return  ;
   }

   public void wb_table2_18_0R2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellHeaderBar hidden-xs", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTableuserrole_Internalname, 1, 0, "px", 0, "px", "Flex", "start", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellAttributeSearch", "start", "top", "", "align-self:center;", "div");
         wb_table3_27_0R2( true) ;
      }
      else
      {
         wb_table3_27_0R2( false) ;
      }
      return  ;
   }

   public void wb_table3_27_0R2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "start", "top", "", "", "div");
         /* User Defined Control */
         ucDdo_bookmarks.setProperty("IconType", Ddo_bookmarks_Icontype);
         ucDdo_bookmarks.setProperty("Icon", Ddo_bookmarks_Icon);
         ucDdo_bookmarks.setProperty("Caption", Ddo_bookmarks_Caption);
         ucDdo_bookmarks.setProperty("Cls", Ddo_bookmarks_Cls);
         ucDdo_bookmarks.setProperty("DropDownOptionsData", AV31BookmarksData);
         ucDdo_bookmarks.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_bookmarks_Internalname, "DDO_BOOKMARKS_MPAGEContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "MasterTopIconsCell", "start", "top", "", "", "div");
         /* User Defined Control */
         ucDdc_adminag.setProperty("IconType", Ddc_adminag_Icontype);
         ucDdc_adminag.setProperty("Icon", Ddc_adminag_Icon);
         ucDdc_adminag.setProperty("Caption", Ddc_adminag_Caption);
         ucDdc_adminag.setProperty("Cls", Ddc_adminag_Cls);
         ucDdc_adminag.setProperty("ComponentWidth", Ddc_adminag_Componentwidth);
         ucDdc_adminag.render(context, "dvelop.gxbootstrap.ddcomponent", Ddc_adminag_Internalname, "DDC_ADMINAG_MPAGEContainer");
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
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* User Defined Control */
         ucUcmenu.setProperty("SidebarMainClass", Ucmenu_Sidebarmainclass);
         ucUcmenu.setProperty("ScrollWidth", Ucmenu_Scrollwidth);
         ucUcmenu.setProperty("ScrollAlwaysVisible", Ucmenu_Scrollalwaysvisible);
         ucUcmenu.setProperty("HideScrollInCompactMenu", Ucmenu_Hidescrollincompactmenu);
         ucUcmenu.setProperty("SidebarMenuOptionsData", AV23DVelop_Menu);
         ucUcmenu.setProperty("SidebarMenuUserData", AV29DVelop_Menu_UserData);
         ucUcmenu.render(context, "dvelop.gxbootstrap.sidebarmenu", Ucmenu_Internalname, "UCMENU_MPAGEContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 page-content page-content-back-image CellTableContentWithFooter", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         /* Content placeholder */
         httpContext.writeText( "<div") ;
         com.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
         httpContext.writeText( ">") ;
         if ( ! isFullAjaxMode( ) )
         {
            getDataAreaObject().renderHtmlContent();
         }
         httpContext.writeText( "</div>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
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
         /* User Defined Control */
         ucUcmessage.setProperty("StopOnError", Ucmessage_Stoponerror);
         ucUcmessage.render(context, "dvelop.dvmessage", Ucmessage_Internalname, "UCMESSAGE_MPAGEContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* User Defined Control */
         ucUctooltip.render(context, "dvelop.gxbootstrap.tooltip", Uctooltip_Internalname, "UCTOOLTIP_MPAGEContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* User Defined Control */
         ucWwputilities.setProperty("EnableFixObjectFitCover", Wwputilities_Enablefixobjectfitcover);
         ucWwputilities.setProperty("EmpowerTabs", Wwputilities_Empowertabs);
         ucWwputilities.setProperty("EnableUpdateRowSelectionStatus", Wwputilities_Enableupdaterowselectionstatus);
         ucWwputilities.setProperty("EnableConvertComboToBootstrapSelect", Wwputilities_Enableconvertcombotobootstrapselect);
         ucWwputilities.setProperty("AllowColumnResizing", Wwputilities_Allowcolumnresizing);
         ucWwputilities.setProperty("AllowColumnReordering", Wwputilities_Allowcolumnreordering);
         ucWwputilities.setProperty("AllowColumnDragging", Wwputilities_Allowcolumndragging);
         ucWwputilities.setProperty("AllowColumnsRestore", Wwputilities_Allowcolumnsrestore);
         ucWwputilities.setProperty("PagBarIncludeGoTo", Wwputilities_Pagbarincludegoto);
         ucWwputilities.setProperty("ComboLoadType", Wwputilities_Comboloadtype);
         ucWwputilities.render(context, "wwp.workwithplusutilities_fal", Wwputilities_Internalname, "WWPUTILITIES_MPAGEContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* User Defined Control */
         ucWwpdatepicker.render(context, "wwp.datepicker", Wwpdatepicker_Internalname, "WWPDATEPICKER_MPAGEContainer");
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
         ucPopover_search.setProperty("Trigger", Popover_search_Trigger);
         ucPopover_search.setProperty("TriggerElement", Popover_search_Triggerelement);
         ucPopover_search.setProperty("PopoverWidth", Popover_search_Popoverwidth);
         ucPopover_search.setProperty("Position", Popover_search_Position);
         ucPopover_search.setProperty("KeepOpened", Popover_search_Keepopened);
         ucPopover_search.setProperty("ReloadOnKeyChange", Popover_search_Reloadonkeychange);
         ucPopover_search.setProperty("MinimumCharacters", Popover_search_Minimumcharacters);
         ucPopover_search.render(context, "dvelop.wwppopover", Popover_search_Internalname, "POPOVER_SEARCH_MPAGEContainer");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',true,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavPickerdummyvariable_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavPickerdummyvariable_Internalname, localUtil.format(AV39PickerDummyVariable, "99/99/99"), localUtil.format( AV39PickerDummyVariable, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", "", "", edtavPickerdummyvariable_Jsonclick, 0, "Invisible", "", "", "", "", 1, 1, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "end", false, "", "HLP_WWPBaseObjects/WorkWithPlusMasterPage.htm");
         com.GxWebStd.gx_bitmap( httpContext, edtavPickerdummyvariable_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects/WorkWithPlusMasterPage.htm");
         httpContext.writeTextNL( "</div>") ;
         wb_table4_67_0R2( true) ;
      }
      else
      {
         wb_table4_67_0R2( false) ;
      }
      return  ;
   }

   public void wb_table4_67_0R2e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divDiv_wwpauxwc_Internalname, 1, 0, "px", 0, "px", "Invisible", "start", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.GxWebStd.gx_hidden_field( httpContext, "MPW0073"+"", GXutil.rtrim( WebComp_Wwpaux_wc_Component));
            httpContext.writeText( "<div") ;
            com.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpMPW0073"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0073"+"");
               }
               WebComp_Wwpaux_wc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      wbLoad = true ;
   }

   public void start0R2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0R0( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( getDataAreaObject().executeStartEvent() != 0 )
         {
            httpContext.setAjaxCallMode();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void ws0R2( )
   {
      start0R2( ) ;
      evt0R2( ) ;
   }

   public void evt0R2( )
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
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "RFR_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "BOOKMARK_MODAL_MPAGE.CLOSE_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e110R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "BOOKMARK_MODAL_MPAGE.ONLOADCOMPONENT_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e120R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e130R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Refresh */
                        e140R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS_MPAGE.MASTER_REFRESHHEADER_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e150R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e160R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! wbErr )
                        {
                           Rfr0gs = false ;
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
                        dynload_actions( ) ;
                     }
                  }
                  else
                  {
                  }
               }
               else if ( GXutil.strcmp(sEvtType, "M") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, GXutil.len( sEvt)-2) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-6) ;
                  nCmpId = (short)(GXutil.lval( sEvtType)) ;
                  if ( nCmpId == 73 )
                  {
                     OldWwpaux_wc = httpContext.cgiGet( "MPW0073") ;
                     if ( ( GXutil.len( OldWwpaux_wc) == 0 ) || ( GXutil.strcmp(OldWwpaux_wc, WebComp_Wwpaux_wc_Component) != 0 ) )
                     {
                        WebComp_Wwpaux_wc = WebFrontendUtils.getWebComponent(getClass(), "com." + OldWwpaux_wc + "_impl", remoteHandle, context);
                        WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                     }
                     if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
                     {
                        WebComp_Wwpaux_wc.componentprocess("MPW0073", "", sEvt);
                     }
                     WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                  }
               }
               if ( httpContext.wbHandled == 0 )
               {
                  getDataAreaObject().dispatchEvents();
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void we0R2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0R2( ) ;
         }
      }
   }

   public void pa0R2( )
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
            GX_FocusControl = edtavSearch_Internalname ;
            httpContext.ajax_rsp_assign_attri("", true, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
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
      rf0R2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
   }

   public void rf0R2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ShowMPWhenPopUp( ) || ! httpContext.isPopUpObject( ) )
      {
         /* Execute user event: Refresh */
         e140R2 ();
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
         {
            if ( 1 != 0 )
            {
               if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
               {
                  WebComp_Wwpaux_wc.componentstart();
               }
            }
         }
         gxdyncontrolsrefreshing = true ;
         fix_multi_value_controls( ) ;
         gxdyncontrolsrefreshing = false ;
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e160R2 ();
         wb0R0( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
   }

   public void send_integrity_lvl_hashes0R2( )
   {
   }

   public void before_start_formulas( )
   {
      fix_multi_value_controls( ) ;
   }

   public void strup0R0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e130R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vBOOKMARKSDATA_MPAGE"), AV31BookmarksData);
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vDVELOP_MENU_MPAGE"), AV23DVelop_Menu);
         httpContext.readJsonSdtValue(httpContext.cgiGet( "vDVELOP_MENU_USERDATA_MPAGE"), AV29DVelop_Menu_UserData);
         /* Read saved values. */
         AV15SearchAux = httpContext.cgiGet( "vSEARCHAUX_MPAGE") ;
         Ddo_bookmarks_Icontype = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Icontype") ;
         Ddo_bookmarks_Icon = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Icon") ;
         Ddo_bookmarks_Tooltip = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Tooltip") ;
         Ddo_bookmarks_Cls = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Cls") ;
         Ddo_bookmarks_Titlecontrolalign = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Titlecontrolalign") ;
         Ddc_adminag_Icontype = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Icontype") ;
         Ddc_adminag_Icon = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Icon") ;
         Ddc_adminag_Cls = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Cls") ;
         Ddc_adminag_Componentwidth = (int)(localUtil.ctol( httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Componentwidth"), ",", ".")) ;
         Ucmenu_Sidebarmainclass = httpContext.cgiGet( "UCMENU_MPAGE_Sidebarmainclass") ;
         Ucmenu_Scrollwidth = (int)(localUtil.ctol( httpContext.cgiGet( "UCMENU_MPAGE_Scrollwidth"), ",", ".")) ;
         Ucmenu_Scrollalwaysvisible = GXutil.strtobool( httpContext.cgiGet( "UCMENU_MPAGE_Scrollalwaysvisible")) ;
         Ucmenu_Hidescrollincompactmenu = GXutil.strtobool( httpContext.cgiGet( "UCMENU_MPAGE_Hidescrollincompactmenu")) ;
         Ucmessage_Stoponerror = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Stoponerror")) ;
         Wwputilities_Enablefixobjectfitcover = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enablefixobjectfitcover")) ;
         Wwputilities_Empowertabs = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Empowertabs")) ;
         Wwputilities_Enableupdaterowselectionstatus = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enableupdaterowselectionstatus")) ;
         Wwputilities_Enableconvertcombotobootstrapselect = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enableconvertcombotobootstrapselect")) ;
         Wwputilities_Allowcolumnresizing = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnresizing")) ;
         Wwputilities_Allowcolumnreordering = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnreordering")) ;
         Wwputilities_Allowcolumndragging = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumndragging")) ;
         Wwputilities_Allowcolumnsrestore = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnsrestore")) ;
         Wwputilities_Pagbarincludegoto = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Pagbarincludegoto")) ;
         Wwputilities_Comboloadtype = httpContext.cgiGet( "WWPUTILITIES_MPAGE_Comboloadtype") ;
         Popover_search_Iteminternalname = httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Iteminternalname") ;
         Popover_search_Trigger = httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Trigger") ;
         Popover_search_Triggerelement = httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Triggerelement") ;
         Popover_search_Popoverwidth = (int)(localUtil.ctol( httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Popoverwidth"), ",", ".")) ;
         Popover_search_Position = httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Position") ;
         Popover_search_Keepopened = GXutil.strtobool( httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Keepopened")) ;
         Popover_search_Reloadonkeychange = GXutil.strtobool( httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Reloadonkeychange")) ;
         Popover_search_Minimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Minimumcharacters"), ",", ".")) ;
         Bookmark_modal_Width = httpContext.cgiGet( "BOOKMARK_MODAL_MPAGE_Width") ;
         Bookmark_modal_Title = httpContext.cgiGet( "BOOKMARK_MODAL_MPAGE_Title") ;
         Bookmark_modal_Confirmtype = httpContext.cgiGet( "BOOKMARK_MODAL_MPAGE_Confirmtype") ;
         Bookmark_modal_Bodytype = httpContext.cgiGet( "BOOKMARK_MODAL_MPAGE_Bodytype") ;
         (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setCaption( httpContext.cgiGet( "FORM_MPAGE_Caption") );
         /* Read variables values. */
         AV19Search = httpContext.cgiGet( edtavSearch_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV19Search", AV19Search);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavPickerdummyvariable_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vPICKERDUMMYVARIABLE_MPAGE");
            GX_FocusControl = edtavPickerdummyvariable_Internalname ;
            httpContext.ajax_rsp_assign_attri("", true, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV39PickerDummyVariable = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", true, "AV39PickerDummyVariable", localUtil.format(AV39PickerDummyVariable, "99/99/99"));
         }
         else
         {
            AV39PickerDummyVariable = localUtil.ctod( httpContext.cgiGet( edtavPickerdummyvariable_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", true, "AV39PickerDummyVariable", localUtil.format(AV39PickerDummyVariable, "99/99/99"));
         }
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
      e130R2 ();
      if (returnInSub) return;
   }

   public void e130R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\""+httpContext.convertURL( context.getHttpContext().getImagePath( "ee49c4f6-1cb0-4b77-b7d6-4299054bdaaf", "", context.getHttpContext().getTheme( )))+"\">" );
      divLayoutmaintable_Class = "MainContainer" ;
      httpContext.ajax_rsp_assign_prop("", true, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXt_objcol_SdtDVelop_Menu_Item1 = AV23DVelop_Menu ;
      GXv_objcol_SdtDVelop_Menu_Item2[0] = GXt_objcol_SdtDVelop_Menu_Item1 ;
      new com.wwpbaseobjects.loadmenu_nosecurity(remoteHandle, context).execute( "MainMenu", GXv_objcol_SdtDVelop_Menu_Item2) ;
      GXt_objcol_SdtDVelop_Menu_Item1 = GXv_objcol_SdtDVelop_Menu_Item2[0] ;
      AV23DVelop_Menu = GXt_objcol_SdtDVelop_Menu_Item1 ;
      Popover_search_Iteminternalname = edtavSearch_Internalname ;
      ucPopover_search.sendProperty(context, "", true, Popover_search_Internalname, "ItemInternalName", Popover_search_Iteminternalname);
      AV31BookmarksData = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV32BookmarksDataItem = (com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Bookmark Page" );
      AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-star FontIconTopRightActions" );
      AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "Bookmark" );
      AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV31BookmarksData.add(AV32BookmarksDataItem, 0);
      Ddo_bookmarks_Tooltip = "Marcadores" ;
      ucDdo_bookmarks.sendProperty(context, "", true, Ddo_bookmarks_Internalname, "Tooltip", Ddo_bookmarks_Tooltip);
      Ddo_bookmarks_Titlecontrolalign = "Left" ;
      ucDdo_bookmarks.sendProperty(context, "", true, Ddo_bookmarks_Internalname, "TitleControlAlign", Ddo_bookmarks_Titlecontrolalign);
      lblActionsearch_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", true, lblActionsearch_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblActionsearch_Enabled), 5, 0), true);
      if ( GXutil.strcmp(AV27Httprequest.getMethod(), "GET") == 0 )
      {
         GXt_SdtWWP_DesignSystemSettings3 = AV16WWP_DesignSystemSettings;
         GXv_SdtWWP_DesignSystemSettings4[0] = GXt_SdtWWP_DesignSystemSettings3;
         new com.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings4) ;
         GXt_SdtWWP_DesignSystemSettings3 = GXv_SdtWWP_DesignSystemSettings4[0];
         AV16WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings3;
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"base-color",AV16WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Basecolor()}, false);
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"background-color",AV16WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle()}, false);
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"menu-color",AV16WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Menucolor()}, false);
         this.executeExternalObjectMethod("", true, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
      }
      GXt_char5 = "" ;
      GXv_char6[0] = GXt_char5 ;
      new com.workwithplus.wwp_getsystemparameter(remoteHandle, context).execute( "AD_Application_Title", GXv_char6) ;
      workwithplusmasterpage_impl.this.GXt_char5 = GXv_char6[0] ;
      lblLogodsc_Caption = GXt_char5 ;
      httpContext.ajax_rsp_assign_prop("", true, lblLogodsc_Internalname, "Caption", lblLogodsc_Caption, true);
   }

   public void e120R2( )
   {
      /* Bookmark_modal_Onloadcomponent Routine */
      returnInSub = false ;
      /* Object Property */
      if ( true )
      {
         bDynCreated_Wwpaux_wc = true ;
      }
      if ( GXutil.strcmp(GXutil.lower( WebComp_Wwpaux_wc_Component), GXutil.lower( "WWPBaseObjects.EditBookmark")) != 0 )
      {
         WebComp_Wwpaux_wc = WebFrontendUtils.getWebComponent(getClass(), "com.wwpbaseobjects.editbookmark_impl", remoteHandle, context);
         WebComp_Wwpaux_wc_Component = "WWPBaseObjects.EditBookmark" ;
      }
      if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
      {
         WebComp_Wwpaux_wc.setjustcreated();
         WebComp_Wwpaux_wc.componentprepare(new Object[] {"MPW0073","",AV27Httprequest.getBaseURL()+AV27Httprequest.getScriptName()+((GXutil.strcmp("", GXutil.trim( AV27Httprequest.getQuerystring()))==0) ? "" : "?"+AV27Httprequest.getQuerystring()),AV37ProgramDescription});
         WebComp_Wwpaux_wc.componentbind(new Object[] {""+""+""+""+""+""+""+""+""+"","",""+""+""+"",""});
      }
      if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wwpaux_wc )
      {
         httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0073"+"");
         WebComp_Wwpaux_wc.componentdraw();
         httpContext.ajax_rspEndCmp();
      }
      /*  Sending Event outputs  */
   }

   public void e110R2( )
   {
      /* Bookmark_modal_Close Routine */
      returnInSub = false ;
      httpContext.doAjaxRefresh();
   }

   public void S112( )
   {
      /* 'DO BOOKMARK' Routine */
      returnInSub = false ;
      this.executeUsercontrolMethod("", true, "BOOKMARK_MODAL_MPAGEContainer", "Confirm", "", new Object[] {});
   }

   public void e140R2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      lblTextblocktitle_Caption = (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption() ;
      httpContext.ajax_rsp_assign_prop("", true, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
      /* Execute user subroutine: 'LOADBOOKMARKS' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", true, "AV31BookmarksData", AV31BookmarksData);
   }

   public void e150R2( )
   {
      /* General\GlobalEvents_Master_refreshheader Routine */
      returnInSub = false ;
      httpContext.doAjaxRefresh();
   }

   public void S122( )
   {
      /* 'LOADBOOKMARKS' Routine */
      returnInSub = false ;
      AV31BookmarksData = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV32BookmarksDataItem = (com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "AddBookmark" );
      AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV31BookmarksData.add(AV32BookmarksDataItem, 0);
      AV37ProgramDescription = Contentholder.getPgmdesc() ;
      httpContext.ajax_rsp_assign_attri("", true, "AV37ProgramDescription", AV37ProgramDescription);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROGRAMDESCRIPTION_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV37ProgramDescription, ""))));
      AV33CurrentURL = AV27Httprequest.getBaseURL() + AV27Httprequest.getScriptName() + ((GXutil.strcmp("", GXutil.trim( AV27Httprequest.getQuerystring()))==0) ? "" : "?"+AV27Httprequest.getQuerystring()) ;
      AV34GridStateCollection.fromxml(new com.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( "AppBookmarks"), null, null);
      AV30BookmarkFound = false ;
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV34GridStateCollection.size() )
      {
         AV35GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)((com.wwpbaseobjects.SdtGridStateCollection_Item)AV34GridStateCollection.elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV35GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV33CurrentURL) == 0 )
         {
            AV37ProgramDescription = AV35GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Title() ;
            httpContext.ajax_rsp_assign_attri("", true, "AV37ProgramDescription", AV37ProgramDescription);
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROGRAMDESCRIPTION_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV37ProgramDescription, ""))));
            AV30BookmarkFound = true ;
            if (true) break;
         }
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
      if ( AV30BookmarkFound )
      {
         this.executeUsercontrolMethod("", true, "DDO_BOOKMARKS_MPAGEContainer", "Update", "", new Object[] {"","fas fa-star "+"FontColorIconBookmarkTitleAdded"});
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Editar marcador para esta página" );
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-star "+"FontColorIconBookmarkAdded" );
      }
      else
      {
         this.executeUsercontrolMethod("", true, "DDO_BOOKMARKS_MPAGEContainer", "Update", "", new Object[] {"","far fa-star "+"FontColorIconBookmarkTitle"});
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Crear marcador para esta página" );
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "far fa-star "+"FontColorIconBookmark" );
      }
      if ( AV34GridStateCollection.size() > 0 )
      {
         AV32BookmarksDataItem = (com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( true );
         AV31BookmarksData.add(AV32BookmarksDataItem, 0);
         AV41GXV2 = 1 ;
         while ( AV41GXV2 <= AV34GridStateCollection.size() )
         {
            AV35GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)((com.wwpbaseobjects.SdtGridStateCollection_Item)AV34GridStateCollection.elementAt(-1+AV41GXV2));
            AV32BookmarksDataItem = (com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
            AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( AV35GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Title() );
            AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Link( AV35GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml() );
            GXt_char5 = AV38FontIcon ;
            GXv_char6[0] = GXt_char5 ;
            new com.wwpbaseobjects.getbookmarkfonticon(remoteHandle, context).execute( GXutil.strReplace( AV35GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV27Httprequest.getBaseURL(), ""), AV23DVelop_Menu, GXv_char6) ;
            workwithplusmasterpage_impl.this.GXt_char5 = GXv_char6[0] ;
            AV38FontIcon = GXt_char5 ;
            AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( ((GXutil.strcmp(AV38FontIcon, "")==0) ? "FontColorIconBookmark fas fa-link" : "FontColorIconBookmark"+" "+AV38FontIcon) );
            AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
            AV31BookmarksData.add(AV32BookmarksDataItem, 0);
            AV36IndexToAddItems = (short)(AV36IndexToAddItems+1) ;
            httpContext.ajax_rsp_assign_attri("", true, "AV36IndexToAddItems", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36IndexToAddItems), 4, 0));
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINDEXTOADDITEMS_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV36IndexToAddItems), "ZZZ9")));
            AV41GXV2 = (int)(AV41GXV2+1) ;
         }
         AV32BookmarksDataItem = (com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( true );
         AV31BookmarksData.add(AV32BookmarksDataItem, 0);
         AV32BookmarksDataItem = (com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Bookmark manager" );
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-cog "+"FontColorIconBookmark" );
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "ManageBookmarks" );
         AV32BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
         AV31BookmarksData.add(AV32BookmarksDataItem, 0);
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e160R2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table4_67_0R2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblTablebookmark_modal_Internalname, tblTablebookmark_modal_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucBookmark_modal.setProperty("Width", Bookmark_modal_Width);
         ucBookmark_modal.setProperty("Title", Bookmark_modal_Title);
         ucBookmark_modal.setProperty("ConfirmType", Bookmark_modal_Confirmtype);
         ucBookmark_modal.setProperty("BodyType", Bookmark_modal_Bodytype);
         ucBookmark_modal.render(context, "dvelop.gxbootstrap.confirmpanel", Bookmark_modal_Internalname, "BOOKMARK_MODAL_MPAGEContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"BOOKMARK_MODAL_MPAGEContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_67_0R2e( true) ;
      }
      else
      {
         wb_table4_67_0R2e( false) ;
      }
   }

   public void wb_table3_27_0R2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblUnnamedtable4_Internalname, tblUnnamedtable4_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, edtavSearch_Internalname, "Search", "gx-form-item AttributeSearchLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',true,'',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavSearch_Internalname, AV19Search, GXutil.rtrim( localUtil.format( AV19Search, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", "", "Search...", edtavSearch_Jsonclick, 0, "AttributeSearch", "", "", "", "", 1, edtavSearch_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/WorkWithPlusMasterPage.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblActionsearch_Internalname, "<i class=\"fas fa-search ImageSearchIcon\"></i>", "", "", lblActionsearch_Jsonclick, "'"+""+"'"+",true,"+"'"+"e170r1_client"+"'", "", "TextBlock", 7, "", 1, lblActionsearch_Enabled, 1, (short)(1), "HLP_WWPBaseObjects/WorkWithPlusMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_27_0R2e( true) ;
      }
      else
      {
         wb_table3_27_0R2e( false) ;
      }
   }

   public void wb_table2_18_0R2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblUnnamedtable3_Internalname, tblUnnamedtable3_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblShowmenu_Internalname, "<i class=\"fas fa-bars FontIconMenu\"></i>", "", "", lblShowmenu_Jsonclick, "'"+""+"'"+",true,"+"'"+"e180r1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects/WorkWithPlusMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlockTitleMaterial", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WorkWithPlusMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_18_0R2e( true) ;
      }
      else
      {
         wb_table2_18_0R2e( false) ;
      }
   }

   public void wb_table1_11_0R2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblUnnamedtable2_Internalname, tblUnnamedtable2_Internalname, "", "TableLogo page-content", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Static images/pictures */
         ClassString = "ImageTopHeader" + " " + ((GXutil.strcmp(imgHeader_gximage, "")==0) ? "GX_Image_Logo_Class" : "GX_Image_"+imgHeader_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "ee49c4f6-1cb0-4b77-b7d6-4299054bdaaf", "", context.getHttpContext().getTheme( )) ;
         com.GxWebStd.gx_bitmap( httpContext, imgHeader_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects/WorkWithPlusMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblLogodsc_Internalname, lblLogodsc_Caption, "", "", lblLogodsc_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlockLogo", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WorkWithPlusMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_11_0R2e( true) ;
      }
      else
      {
         wb_table1_11_0R2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
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
      pa0R2( ) ;
      ws0R2( ) ;
      we0R2( ) ;
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

   public void master_styles( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/fontawesome_vlatest/css/all.min.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
         {
            WebComp_Wwpaux_wc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().item(idxLst)), "?20244261717433", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/workwithplusmasterpage.js", "?20244261717434", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/slimscroll/jquery.slimscroll.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/SidebarMenu/BootstrapSidebarMenuRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Tooltip/BootstrapTooltipRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DatePicker/DatePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgHeader_Internalname = "HEADER_MPAGE" ;
      lblLogodsc_Internalname = "LOGODSC_MPAGE" ;
      tblUnnamedtable2_Internalname = "UNNAMEDTABLE2_MPAGE" ;
      lblShowmenu_Internalname = "SHOWMENU_MPAGE" ;
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE_MPAGE" ;
      tblUnnamedtable3_Internalname = "UNNAMEDTABLE3_MPAGE" ;
      edtavSearch_Internalname = "vSEARCH_MPAGE" ;
      lblActionsearch_Internalname = "ACTIONSEARCH_MPAGE" ;
      tblUnnamedtable4_Internalname = "UNNAMEDTABLE4_MPAGE" ;
      Ddo_bookmarks_Internalname = "DDO_BOOKMARKS_MPAGE" ;
      Ddc_adminag_Internalname = "DDC_ADMINAG_MPAGE" ;
      divTableuserrole_Internalname = "TABLEUSERROLE_MPAGE" ;
      divTableheader_Internalname = "TABLEHEADER_MPAGE" ;
      Ucmenu_Internalname = "UCMENU_MPAGE" ;
      divTablecontent_Internalname = "TABLECONTENT_MPAGE" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1_MPAGE" ;
      Ucmessage_Internalname = "UCMESSAGE_MPAGE" ;
      Uctooltip_Internalname = "UCTOOLTIP_MPAGE" ;
      Wwputilities_Internalname = "WWPUTILITIES_MPAGE" ;
      Wwpdatepicker_Internalname = "WWPDATEPICKER_MPAGE" ;
      divTablemain_Internalname = "TABLEMAIN_MPAGE" ;
      Popover_search_Internalname = "POPOVER_SEARCH_MPAGE" ;
      edtavPickerdummyvariable_Internalname = "vPICKERDUMMYVARIABLE_MPAGE" ;
      Bookmark_modal_Internalname = "BOOKMARK_MODAL_MPAGE" ;
      tblTablebookmark_modal_Internalname = "TABLEBOOKMARK_MODAL_MPAGE" ;
      divDiv_wwpauxwc_Internalname = "DIV_WWPAUXWC_MPAGE" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS_MPAGE" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE_MPAGE" ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setInternalname( "FORM_MPAGE" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      lblActionsearch_Enabled = 1 ;
      edtavSearch_Jsonclick = "" ;
      edtavSearch_Enabled = 1 ;
      lblTextblocktitle_Caption = " Title" ;
      lblLogodsc_Caption = "Application" ;
      edtavPickerdummyvariable_Jsonclick = "" ;
      Ddc_adminag_Caption = "" ;
      divLayoutmaintable_Class = "Table" ;
      Bookmark_modal_Bodytype = "WebComponent" ;
      Bookmark_modal_Confirmtype = "" ;
      Bookmark_modal_Title = "Add/Edit Bookmark" ;
      Bookmark_modal_Width = "735" ;
      Popover_search_Minimumcharacters = 2 ;
      Popover_search_Reloadonkeychange = GXutil.toBoolean( -1) ;
      Popover_search_Keepopened = GXutil.toBoolean( 0) ;
      Popover_search_Position = "Bottom" ;
      Popover_search_Popoverwidth = 400 ;
      Popover_search_Triggerelement = "Value" ;
      Popover_search_Trigger = "Click" ;
      Popover_search_Iteminternalname = "" ;
      Wwputilities_Comboloadtype = "InfiniteScrolling" ;
      Wwputilities_Pagbarincludegoto = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnsrestore = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumndragging = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnreordering = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnresizing = GXutil.toBoolean( -1) ;
      Wwputilities_Enableconvertcombotobootstrapselect = GXutil.toBoolean( -1) ;
      Wwputilities_Enableupdaterowselectionstatus = GXutil.toBoolean( -1) ;
      Wwputilities_Empowertabs = GXutil.toBoolean( -1) ;
      Wwputilities_Enablefixobjectfitcover = GXutil.toBoolean( -1) ;
      Ucmessage_Stoponerror = GXutil.toBoolean( -1) ;
      Ucmenu_Hidescrollincompactmenu = GXutil.toBoolean( 0) ;
      Ucmenu_Scrollalwaysvisible = GXutil.toBoolean( -1) ;
      Ucmenu_Scrollwidth = 5 ;
      Ucmenu_Sidebarmainclass = "page-sidebar sidebar-fixed sidebar-back-image" ;
      Ddc_adminag_Componentwidth = 210 ;
      Ddc_adminag_Cls = "DropDownOptionsHeader" ;
      Ddc_adminag_Icon = "fa fa-user FontUserIcon" ;
      Ddc_adminag_Icontype = "FontIcon" ;
      Ddo_bookmarks_Titlecontrolalign = "Automatic" ;
      Ddo_bookmarks_Cls = "DropDownOptionsNoBackHover" ;
      Ddo_bookmarks_Tooltip = "" ;
      Ddo_bookmarks_Icon = "far fa-star" ;
      Ddo_bookmarks_Icontype = "FontIcon" ;
      Contentholder.setDataArea(getDataAreaObject());
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
      setEventMetadata("REFRESH_MPAGE","{handler:'refresh',iparms:[{ctrl:'FORM_MPAGE',prop:'Caption'},{av:'AV27Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'},{av:'AV23DVelop_Menu',fld:'vDVELOP_MENU_MPAGE',pic:''},{av:'AV37ProgramDescription',fld:'vPROGRAMDESCRIPTION_MPAGE',pic:'',hsh:true},{av:'AV36IndexToAddItems',fld:'vINDEXTOADDITEMS_MPAGE',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH_MPAGE",",oparms:[{av:'lblTextblocktitle_Caption',ctrl:'TEXTBLOCKTITLE_MPAGE',prop:'Caption'},{av:'AV31BookmarksData',fld:'vBOOKMARKSDATA_MPAGE',pic:''},{av:'AV37ProgramDescription',fld:'vPROGRAMDESCRIPTION_MPAGE',pic:'',hsh:true},{av:'AV36IndexToAddItems',fld:'vINDEXTOADDITEMS_MPAGE',pic:'ZZZ9',hsh:true}]}");
      setEventMetadata("BOOKMARK_MODAL_MPAGE.ONLOADCOMPONENT_MPAGE","{handler:'e120R2',iparms:[{av:'AV27Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'},{av:'AV37ProgramDescription',fld:'vPROGRAMDESCRIPTION_MPAGE',pic:'',hsh:true}]");
      setEventMetadata("BOOKMARK_MODAL_MPAGE.ONLOADCOMPONENT_MPAGE",",oparms:[{ctrl:'WWPAUX_WC_MPAGE'}]}");
      setEventMetadata("BOOKMARK_MODAL_MPAGE.CLOSE_MPAGE","{handler:'e110R2',iparms:[]");
      setEventMetadata("BOOKMARK_MODAL_MPAGE.CLOSE_MPAGE",",oparms:[]}");
      setEventMetadata("DOACTIONSEARCH_MPAGE","{handler:'e170R1',iparms:[{av:'AV15SearchAux',fld:'vSEARCHAUX_MPAGE',pic:''}]");
      setEventMetadata("DOACTIONSEARCH_MPAGE",",oparms:[]}");
      setEventMetadata("DOSHOWMENU_MPAGE","{handler:'e180R1',iparms:[]");
      setEventMetadata("DOSHOWMENU_MPAGE",",oparms:[]}");
      setEventMetadata("GLOBALEVENTS_MPAGE.MASTER_REFRESHHEADER_MPAGE","{handler:'e150R2',iparms:[]");
      setEventMetadata("GLOBALEVENTS_MPAGE.MASTER_REFRESHHEADER_MPAGE",",oparms:[]}");
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
      Contentholder = new com.genexus.webpanels.GXDataAreaControl();
      Ddo_bookmarks_Activeeventkey = "" ;
      AV27Httprequest = httpContext.getHttpRequest();
      Form = new com.genexus.webpanels.GXWebForm();
      AV37ProgramDescription = "" ;
      GXKey = "" ;
      AV31BookmarksData = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV23DVelop_Menu = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>(com.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Gregory", remoteHandle);
      AV29DVelop_Menu_UserData = new com.wwpbaseobjects.SdtDVelop_Menu_UserData(remoteHandle, context);
      AV15SearchAux = "" ;
      sPrefix = "" ;
      ucDdo_bookmarks = new com.genexus.webpanels.GXUserControl();
      Ddo_bookmarks_Caption = "" ;
      ucDdc_adminag = new com.genexus.webpanels.GXUserControl();
      ucUcmenu = new com.genexus.webpanels.GXUserControl();
      ucUcmessage = new com.genexus.webpanels.GXUserControl();
      ucUctooltip = new com.genexus.webpanels.GXUserControl();
      ucWwputilities = new com.genexus.webpanels.GXUserControl();
      ucWwpdatepicker = new com.genexus.webpanels.GXUserControl();
      ucPopover_search = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV39PickerDummyVariable = GXutil.nullDate() ;
      WebComp_Wwpaux_wc_Component = "" ;
      OldWwpaux_wc = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GX_FocusControl = "" ;
      AV19Search = "" ;
      GXt_objcol_SdtDVelop_Menu_Item1 = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>(com.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Gregory", remoteHandle);
      AV32BookmarksDataItem = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV16WWP_DesignSystemSettings = new com.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXt_SdtWWP_DesignSystemSettings3 = new com.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXv_SdtWWP_DesignSystemSettings4 = new com.wwpbaseobjects.SdtWWP_DesignSystemSettings[1] ;
      AV33CurrentURL = "" ;
      AV34GridStateCollection = new GXBaseCollection<com.wwpbaseobjects.SdtGridStateCollection_Item>(com.wwpbaseobjects.SdtGridStateCollection_Item.class, "Item", "", remoteHandle);
      AV35GridStateCollectionItem = new com.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
      AV38FontIcon = "" ;
      GXt_char5 = "" ;
      GXv_char6 = new String[1] ;
      sStyleString = "" ;
      ucBookmark_modal = new com.genexus.webpanels.GXUserControl();
      lblActionsearch_Jsonclick = "" ;
      lblShowmenu_Jsonclick = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      imgHeader_gximage = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      lblLogodsc_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sDynURL = "" ;
      /* GeneXus formulas. */
      WebComp_Wwpaux_wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      initializeGenerics();
   }

   @SuppressWarnings("unchecked")
   private void initializeGenerics( )
   {
      GXv_objcol_SdtDVelop_Menu_Item2 = new GXBaseCollection[1] ;
   }

   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGotPars ;
   private byte nGXWrapped ;
   private short AV36IndexToAddItems ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private int Ddc_adminag_Componentwidth ;
   private int Ucmenu_Scrollwidth ;
   private int Popover_search_Popoverwidth ;
   private int Popover_search_Minimumcharacters ;
   private int lblActionsearch_Enabled ;
   private int AV40GXV1 ;
   private int AV41GXV2 ;
   private int edtavSearch_Enabled ;
   private int idxLst ;
   private String Ddo_bookmarks_Activeeventkey ;
   private String GXKey ;
   private String Ddo_bookmarks_Icontype ;
   private String Ddo_bookmarks_Icon ;
   private String Ddo_bookmarks_Tooltip ;
   private String Ddo_bookmarks_Cls ;
   private String Ddo_bookmarks_Titlecontrolalign ;
   private String Ddc_adminag_Icontype ;
   private String Ddc_adminag_Icon ;
   private String Ddc_adminag_Cls ;
   private String Ucmenu_Sidebarmainclass ;
   private String Wwputilities_Comboloadtype ;
   private String Popover_search_Iteminternalname ;
   private String Popover_search_Trigger ;
   private String Popover_search_Triggerelement ;
   private String Popover_search_Position ;
   private String Bookmark_modal_Width ;
   private String Bookmark_modal_Title ;
   private String Bookmark_modal_Confirmtype ;
   private String Bookmark_modal_Bodytype ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableuserrole_Internalname ;
   private String Ddo_bookmarks_Caption ;
   private String Ddo_bookmarks_Internalname ;
   private String Ddc_adminag_Caption ;
   private String Ddc_adminag_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String Ucmenu_Internalname ;
   private String divTablecontent_Internalname ;
   private String Ucmessage_Internalname ;
   private String Uctooltip_Internalname ;
   private String Wwputilities_Internalname ;
   private String Wwpdatepicker_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Popover_search_Internalname ;
   private String TempTags ;
   private String edtavPickerdummyvariable_Internalname ;
   private String edtavPickerdummyvariable_Jsonclick ;
   private String divDiv_wwpauxwc_Internalname ;
   private String WebComp_Wwpaux_wc_Component ;
   private String OldWwpaux_wc ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GX_FocusControl ;
   private String edtavSearch_Internalname ;
   private String lblActionsearch_Internalname ;
   private String lblLogodsc_Caption ;
   private String lblLogodsc_Internalname ;
   private String lblTextblocktitle_Caption ;
   private String lblTextblocktitle_Internalname ;
   private String GXt_char5 ;
   private String GXv_char6[] ;
   private String sStyleString ;
   private String tblTablebookmark_modal_Internalname ;
   private String Bookmark_modal_Internalname ;
   private String tblUnnamedtable4_Internalname ;
   private String edtavSearch_Jsonclick ;
   private String lblActionsearch_Jsonclick ;
   private String tblUnnamedtable3_Internalname ;
   private String lblShowmenu_Internalname ;
   private String lblShowmenu_Jsonclick ;
   private String lblTextblocktitle_Jsonclick ;
   private String tblUnnamedtable2_Internalname ;
   private String ClassString ;
   private String imgHeader_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgHeader_Internalname ;
   private String lblLogodsc_Jsonclick ;
   private String sDynURL ;
   private java.util.Date AV39PickerDummyVariable ;
   private boolean Ucmenu_Scrollalwaysvisible ;
   private boolean Ucmenu_Hidescrollincompactmenu ;
   private boolean Ucmessage_Stoponerror ;
   private boolean Wwputilities_Enablefixobjectfitcover ;
   private boolean Wwputilities_Empowertabs ;
   private boolean Wwputilities_Enableupdaterowselectionstatus ;
   private boolean Wwputilities_Enableconvertcombotobootstrapselect ;
   private boolean Wwputilities_Allowcolumnresizing ;
   private boolean Wwputilities_Allowcolumnreordering ;
   private boolean Wwputilities_Allowcolumndragging ;
   private boolean Wwputilities_Allowcolumnsrestore ;
   private boolean Wwputilities_Pagbarincludegoto ;
   private boolean Popover_search_Keepopened ;
   private boolean Popover_search_Reloadonkeychange ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean toggleJsOutput ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean bDynCreated_Wwpaux_wc ;
   private boolean AV30BookmarkFound ;
   private String AV37ProgramDescription ;
   private String AV15SearchAux ;
   private String AV19Search ;
   private String AV33CurrentURL ;
   private String AV38FontIcon ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wwpaux_wc ;
   private com.genexus.internet.HttpRequest AV27Httprequest ;
   private com.genexus.webpanels.GXUserControl ucDdo_bookmarks ;
   private com.genexus.webpanels.GXUserControl ucDdc_adminag ;
   private com.genexus.webpanels.GXUserControl ucUcmenu ;
   private com.genexus.webpanels.GXUserControl ucUcmessage ;
   private com.genexus.webpanels.GXUserControl ucUctooltip ;
   private com.genexus.webpanels.GXUserControl ucWwputilities ;
   private com.genexus.webpanels.GXUserControl ucWwpdatepicker ;
   private com.genexus.webpanels.GXUserControl ucPopover_search ;
   private com.genexus.webpanels.GXUserControl ucBookmark_modal ;
   private com.genexus.webpanels.GXDataAreaControl Contentholder ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV31BookmarksData ;
   private GXBaseCollection<com.wwpbaseobjects.SdtGridStateCollection_Item> AV34GridStateCollection ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> AV23DVelop_Menu ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> GXt_objcol_SdtDVelop_Menu_Item1 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> GXv_objcol_SdtDVelop_Menu_Item2[] ;
   private com.wwpbaseobjects.SdtDVelop_Menu_UserData AV29DVelop_Menu_UserData ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV32BookmarksDataItem ;
   private com.wwpbaseobjects.SdtGridStateCollection_Item AV35GridStateCollectionItem ;
   private com.wwpbaseobjects.SdtWWP_DesignSystemSettings AV16WWP_DesignSystemSettings ;
   private com.wwpbaseobjects.SdtWWP_DesignSystemSettings GXt_SdtWWP_DesignSystemSettings3 ;
   private com.wwpbaseobjects.SdtWWP_DesignSystemSettings GXv_SdtWWP_DesignSystemSettings4[] ;
}

