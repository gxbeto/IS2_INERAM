package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class protocolo_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A1EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
         n1EnfID = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A1EnfID) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A23CntdID = GXutil.lval( httpContext.GetPar( "CntdID")) ;
         n23CntdID = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A23CntdID) ;
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
            AV7ProtID = GXutil.lval( httpContext.GetPar( "ProtID")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ProtID), 10, 0));
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ProtID), "ZZZZZZZZZ9")));
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
      Form.getMeta().addItem("description", "Protocolo", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEnfID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS", true);
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public protocolo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public protocolo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( protocolo_impl.class ));
   }

   public protocolo_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.wwpbaseobjects.masterpageframe");
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
      com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
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
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPanelNoBorderSplitScreenTabs", "start", "top", "", "", "div");
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
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtProtID_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtProtID_Internalname, "ID", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
      /* Single line edit */
      com.GxWebStd.gx_single_line_edit( httpContext, edtProtID_Internalname, GXutil.ltrim( localUtil.ntoc( A25ProtID, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtProtID_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A25ProtID), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A25ProtID), "ZZZZZZZZZ9"))), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProtID_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProtID_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Secuence", "end", false, "", "HLP_Protocolo.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divTablesplittedenfid_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "start", "top", "", "", "div");
      /* Text block */
      com.GxWebStd.gx_label_ctrl( httpContext, lblTextblockenfid_Internalname, "Enfermedad", "", "", lblTextblockenfid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Protocolo.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "start", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_enfid.setProperty("Caption", Combo_enfid_Caption);
      ucCombo_enfid.setProperty("Cls", Combo_enfid_Cls);
      ucCombo_enfid.setProperty("DataListProc", Combo_enfid_Datalistproc);
      ucCombo_enfid.setProperty("DataListProcParametersPrefix", Combo_enfid_Datalistprocparametersprefix);
      ucCombo_enfid.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_enfid.setProperty("DropDownOptionsData", AV14EnfID_Data);
      ucCombo_enfid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_enfid_Internalname, "COMBO_ENFIDContainer");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtEnfID_Internalname, "ID", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtEnfID_Internalname, GXutil.ltrim( localUtil.ntoc( A1EnfID, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EnfID), "ZZZZZZZZZ9")), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEnfID_Jsonclick, 0, "Attribute", "", "", "", "", edtEnfID_Visible, edtEnfID_Enabled, 1, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Secuence", "end", false, "", "HLP_Protocolo.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divTablesplittedcntdid_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "start", "top", "", "", "div");
      /* Text block */
      com.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcntdid_Internalname, "Tipo de Contenido", "", "", lblTextblockcntdid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Protocolo.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "start", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_cntdid.setProperty("Caption", Combo_cntdid_Caption);
      ucCombo_cntdid.setProperty("Cls", Combo_cntdid_Cls);
      ucCombo_cntdid.setProperty("DataListProc", Combo_cntdid_Datalistproc);
      ucCombo_cntdid.setProperty("DataListProcParametersPrefix", Combo_cntdid_Datalistprocparametersprefix);
      ucCombo_cntdid.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_cntdid.setProperty("DropDownOptionsData", AV20CntdID_Data);
      ucCombo_cntdid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_cntdid_Internalname, "COMBO_CNTDIDContainer");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtCntdID_Internalname, "ID", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtCntdID_Internalname, GXutil.ltrim( localUtil.ntoc( A23CntdID, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A23CntdID), "ZZZZZZZZZ9")), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCntdID_Jsonclick, 0, "Attribute", "", "", "", "", edtCntdID_Visible, edtCntdID_Enabled, 1, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Secuence", "end", false, "", "HLP_Protocolo.htm");
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
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtProtOrd_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtProtOrd_Internalname, "Orden", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtProtOrd_Internalname, GXutil.ltrim( localUtil.ntoc( A26ProtOrd, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtProtOrd_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A26ProtOrd), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A26ProtOrd), "ZZZ9"))), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProtOrd_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProtOrd_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "end", false, "", "HLP_Protocolo.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtProtTxt_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtProtTxt_Internalname, "Contenido", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.GxWebStd.gx_html_textarea( httpContext, edtProtTxt_Internalname, A27ProtTxt, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", (short)(0), 1, edtProtTxt_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "10240", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "", "HLP_Protocolo.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "Button" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Protocolo.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11055_client"+"'", TempTags, "", 2, "HLP_Protocolo.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Protocolo.htm");
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
      com.GxWebStd.gx_div_start( httpContext, divSectionattribute_enfid_Internalname, 1, 0, "px", 0, "px", "Section", "start", "top", "", "", "div");
      /* Single line edit */
      com.GxWebStd.gx_single_line_edit( httpContext, edtavComboenfid_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ComboEnfID, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavComboenfid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ComboEnfID), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ComboEnfID), "ZZZZZZZZZ9"))), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboenfid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboenfid_Visible, edtavComboenfid_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "end", false, "", "HLP_Protocolo.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divSectionattribute_cntdid_Internalname, 1, 0, "px", 0, "px", "Section", "start", "top", "", "", "div");
      /* Single line edit */
      com.GxWebStd.gx_single_line_edit( httpContext, edtavCombocntdid_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ComboCntdID, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombocntdid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21ComboCntdID), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21ComboCntdID), "ZZZZZZZZZ9"))), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocntdid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocntdid_Visible, edtavCombocntdid_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "end", false, "", "HLP_Protocolo.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* User Defined Control */
      ucWwputilities.render(context, "dvelop.workwithplusutilities", Wwputilities_Internalname, "WWPUTILITIESContainer");
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
      e12052 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.readJsonSdtValue(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
            httpContext.readJsonSdtValue(httpContext.cgiGet( "vENFID_DATA"), AV14EnfID_Data);
            httpContext.readJsonSdtValue(httpContext.cgiGet( "vCNTDID_DATA"), AV20CntdID_Data);
            httpContext.readJsonSdtValue(httpContext.cgiGet( "vDETAILWCINFO"), AV22DetailWCInfo);
            /* Read saved values. */
            Z25ProtID = localUtil.ctol( httpContext.cgiGet( "Z25ProtID"), ",", ".") ;
            Z26ProtOrd = (short)(localUtil.ctol( httpContext.cgiGet( "Z26ProtOrd"), ",", ".")) ;
            n26ProtOrd = ((0==A26ProtOrd) ? true : false) ;
            Z27ProtTxt = httpContext.cgiGet( "Z27ProtTxt") ;
            n27ProtTxt = ((GXutil.strcmp("", A27ProtTxt)==0) ? true : false) ;
            Z1EnfID = localUtil.ctol( httpContext.cgiGet( "Z1EnfID"), ",", ".") ;
            n1EnfID = ((0==A1EnfID) ? true : false) ;
            Z23CntdID = localUtil.ctol( httpContext.cgiGet( "Z23CntdID"), ",", ".") ;
            n23CntdID = ((0==A23CntdID) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1EnfID = localUtil.ctol( httpContext.cgiGet( "N1EnfID"), ",", ".") ;
            n1EnfID = ((0==A1EnfID) ? true : false) ;
            N23CntdID = localUtil.ctol( httpContext.cgiGet( "N23CntdID"), ",", ".") ;
            n23CntdID = ((0==A23CntdID) ? true : false) ;
            Gx_mode = httpContext.cgiGet( "vMODE") ;
            AV23CurrentTab_ReturnUrl = httpContext.cgiGet( "vCURRENTTAB_RETURNURL") ;
            AV7ProtID = localUtil.ctol( httpContext.cgiGet( "vPROTID"), ",", ".") ;
            AV11Insert_EnfID = localUtil.ctol( httpContext.cgiGet( "vINSERT_ENFID"), ",", ".") ;
            AV12Insert_CntdID = localUtil.ctol( httpContext.cgiGet( "vINSERT_CNTDID"), ",", ".") ;
            A3EnfDesc = httpContext.cgiGet( "ENFDESC") ;
            n3EnfDesc = false ;
            A24CntdDesc = httpContext.cgiGet( "CNTDDESC") ;
            AV24Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_enfid_Objectcall = httpContext.cgiGet( "COMBO_ENFID_Objectcall") ;
            Combo_enfid_Class = httpContext.cgiGet( "COMBO_ENFID_Class") ;
            Combo_enfid_Icontype = httpContext.cgiGet( "COMBO_ENFID_Icontype") ;
            Combo_enfid_Icon = httpContext.cgiGet( "COMBO_ENFID_Icon") ;
            Combo_enfid_Caption = httpContext.cgiGet( "COMBO_ENFID_Caption") ;
            Combo_enfid_Tooltip = httpContext.cgiGet( "COMBO_ENFID_Tooltip") ;
            Combo_enfid_Cls = httpContext.cgiGet( "COMBO_ENFID_Cls") ;
            Combo_enfid_Selectedvalue_set = httpContext.cgiGet( "COMBO_ENFID_Selectedvalue_set") ;
            Combo_enfid_Selectedvalue_get = httpContext.cgiGet( "COMBO_ENFID_Selectedvalue_get") ;
            Combo_enfid_Selectedtext_set = httpContext.cgiGet( "COMBO_ENFID_Selectedtext_set") ;
            Combo_enfid_Selectedtext_get = httpContext.cgiGet( "COMBO_ENFID_Selectedtext_get") ;
            Combo_enfid_Gamoauthtoken = httpContext.cgiGet( "COMBO_ENFID_Gamoauthtoken") ;
            Combo_enfid_Ddointernalname = httpContext.cgiGet( "COMBO_ENFID_Ddointernalname") ;
            Combo_enfid_Titlecontrolalign = httpContext.cgiGet( "COMBO_ENFID_Titlecontrolalign") ;
            Combo_enfid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_ENFID_Dropdownoptionstype") ;
            Combo_enfid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_ENFID_Enabled")) ;
            Combo_enfid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_ENFID_Visible")) ;
            Combo_enfid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_ENFID_Titlecontrolidtoreplace") ;
            Combo_enfid_Datalisttype = httpContext.cgiGet( "COMBO_ENFID_Datalisttype") ;
            Combo_enfid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_ENFID_Allowmultipleselection")) ;
            Combo_enfid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_ENFID_Datalistfixedvalues") ;
            Combo_enfid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ENFID_Isgriditem")) ;
            Combo_enfid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_ENFID_Hasdescription")) ;
            Combo_enfid_Datalistproc = httpContext.cgiGet( "COMBO_ENFID_Datalistproc") ;
            Combo_enfid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_ENFID_Datalistprocparametersprefix") ;
            Combo_enfid_Remoteservicesparameters = httpContext.cgiGet( "COMBO_ENFID_Remoteservicesparameters") ;
            Combo_enfid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ENFID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_enfid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ENFID_Includeonlyselectedoption")) ;
            Combo_enfid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ENFID_Includeselectalloption")) ;
            Combo_enfid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ENFID_Emptyitem")) ;
            Combo_enfid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ENFID_Includeaddnewoption")) ;
            Combo_enfid_Htmltemplate = httpContext.cgiGet( "COMBO_ENFID_Htmltemplate") ;
            Combo_enfid_Multiplevaluestype = httpContext.cgiGet( "COMBO_ENFID_Multiplevaluestype") ;
            Combo_enfid_Loadingdata = httpContext.cgiGet( "COMBO_ENFID_Loadingdata") ;
            Combo_enfid_Noresultsfound = httpContext.cgiGet( "COMBO_ENFID_Noresultsfound") ;
            Combo_enfid_Emptyitemtext = httpContext.cgiGet( "COMBO_ENFID_Emptyitemtext") ;
            Combo_enfid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_ENFID_Onlyselectedvalues") ;
            Combo_enfid_Selectalltext = httpContext.cgiGet( "COMBO_ENFID_Selectalltext") ;
            Combo_enfid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_ENFID_Multiplevaluesseparator") ;
            Combo_enfid_Addnewoptiontext = httpContext.cgiGet( "COMBO_ENFID_Addnewoptiontext") ;
            Combo_enfid_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ENFID_Gxcontroltype"), ",", ".")) ;
            Combo_cntdid_Objectcall = httpContext.cgiGet( "COMBO_CNTDID_Objectcall") ;
            Combo_cntdid_Class = httpContext.cgiGet( "COMBO_CNTDID_Class") ;
            Combo_cntdid_Icontype = httpContext.cgiGet( "COMBO_CNTDID_Icontype") ;
            Combo_cntdid_Icon = httpContext.cgiGet( "COMBO_CNTDID_Icon") ;
            Combo_cntdid_Caption = httpContext.cgiGet( "COMBO_CNTDID_Caption") ;
            Combo_cntdid_Tooltip = httpContext.cgiGet( "COMBO_CNTDID_Tooltip") ;
            Combo_cntdid_Cls = httpContext.cgiGet( "COMBO_CNTDID_Cls") ;
            Combo_cntdid_Selectedvalue_set = httpContext.cgiGet( "COMBO_CNTDID_Selectedvalue_set") ;
            Combo_cntdid_Selectedvalue_get = httpContext.cgiGet( "COMBO_CNTDID_Selectedvalue_get") ;
            Combo_cntdid_Selectedtext_set = httpContext.cgiGet( "COMBO_CNTDID_Selectedtext_set") ;
            Combo_cntdid_Selectedtext_get = httpContext.cgiGet( "COMBO_CNTDID_Selectedtext_get") ;
            Combo_cntdid_Gamoauthtoken = httpContext.cgiGet( "COMBO_CNTDID_Gamoauthtoken") ;
            Combo_cntdid_Ddointernalname = httpContext.cgiGet( "COMBO_CNTDID_Ddointernalname") ;
            Combo_cntdid_Titlecontrolalign = httpContext.cgiGet( "COMBO_CNTDID_Titlecontrolalign") ;
            Combo_cntdid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CNTDID_Dropdownoptionstype") ;
            Combo_cntdid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CNTDID_Enabled")) ;
            Combo_cntdid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CNTDID_Visible")) ;
            Combo_cntdid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CNTDID_Titlecontrolidtoreplace") ;
            Combo_cntdid_Datalisttype = httpContext.cgiGet( "COMBO_CNTDID_Datalisttype") ;
            Combo_cntdid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CNTDID_Allowmultipleselection")) ;
            Combo_cntdid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CNTDID_Datalistfixedvalues") ;
            Combo_cntdid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CNTDID_Isgriditem")) ;
            Combo_cntdid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CNTDID_Hasdescription")) ;
            Combo_cntdid_Datalistproc = httpContext.cgiGet( "COMBO_CNTDID_Datalistproc") ;
            Combo_cntdid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CNTDID_Datalistprocparametersprefix") ;
            Combo_cntdid_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CNTDID_Remoteservicesparameters") ;
            Combo_cntdid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CNTDID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_cntdid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CNTDID_Includeonlyselectedoption")) ;
            Combo_cntdid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CNTDID_Includeselectalloption")) ;
            Combo_cntdid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CNTDID_Emptyitem")) ;
            Combo_cntdid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CNTDID_Includeaddnewoption")) ;
            Combo_cntdid_Htmltemplate = httpContext.cgiGet( "COMBO_CNTDID_Htmltemplate") ;
            Combo_cntdid_Multiplevaluestype = httpContext.cgiGet( "COMBO_CNTDID_Multiplevaluestype") ;
            Combo_cntdid_Loadingdata = httpContext.cgiGet( "COMBO_CNTDID_Loadingdata") ;
            Combo_cntdid_Noresultsfound = httpContext.cgiGet( "COMBO_CNTDID_Noresultsfound") ;
            Combo_cntdid_Emptyitemtext = httpContext.cgiGet( "COMBO_CNTDID_Emptyitemtext") ;
            Combo_cntdid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CNTDID_Onlyselectedvalues") ;
            Combo_cntdid_Selectalltext = httpContext.cgiGet( "COMBO_CNTDID_Selectalltext") ;
            Combo_cntdid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CNTDID_Multiplevaluesseparator") ;
            Combo_cntdid_Addnewoptiontext = httpContext.cgiGet( "COMBO_CNTDID_Addnewoptiontext") ;
            Combo_cntdid_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CNTDID_Gxcontroltype"), ",", ".")) ;
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
            Wwputilities_Objectcall = httpContext.cgiGet( "WWPUTILITIES_Objectcall") ;
            Wwputilities_Class = httpContext.cgiGet( "WWPUTILITIES_Class") ;
            Wwputilities_Enabled = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Enabled")) ;
            Wwputilities_Enableautoupdatefromdocumenttitle = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Enableautoupdatefromdocumenttitle")) ;
            Wwputilities_Enablefixobjectfitcover = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Enablefixobjectfitcover")) ;
            Wwputilities_Enablefloatinglabels = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Enablefloatinglabels")) ;
            Wwputilities_Empowertabs = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Empowertabs")) ;
            Wwputilities_Enableupdaterowselectionstatus = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Enableupdaterowselectionstatus")) ;
            Wwputilities_Currenttab_returnurl = httpContext.cgiGet( "WWPUTILITIES_Currenttab_returnurl") ;
            Wwputilities_Enableconvertcombotobootstrapselect = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Enableconvertcombotobootstrapselect")) ;
            Wwputilities_Allowcolumnresizing = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Allowcolumnresizing")) ;
            Wwputilities_Allowcolumnreordering = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Allowcolumnreordering")) ;
            Wwputilities_Allowcolumndragging = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Allowcolumndragging")) ;
            Wwputilities_Allowcolumnsrestore = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Allowcolumnsrestore")) ;
            Wwputilities_Restorecolumnsiconclass = httpContext.cgiGet( "WWPUTILITIES_Restorecolumnsiconclass") ;
            Wwputilities_Pagbarincludegoto = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Pagbarincludegoto")) ;
            Wwputilities_Comboloadtype = httpContext.cgiGet( "WWPUTILITIES_Comboloadtype") ;
            Wwputilities_Infinitescrollingpage = (int)(localUtil.ctol( httpContext.cgiGet( "WWPUTILITIES_Infinitescrollingpage"), ",", ".")) ;
            Wwputilities_Updatebuttontext = httpContext.cgiGet( "WWPUTILITIES_Updatebuttontext") ;
            Wwputilities_Addnewoption = httpContext.cgiGet( "WWPUTILITIES_Addnewoption") ;
            Wwputilities_Onlyselectedvalues = httpContext.cgiGet( "WWPUTILITIES_Onlyselectedvalues") ;
            Wwputilities_Multiplevaluesseparator = httpContext.cgiGet( "WWPUTILITIES_Multiplevaluesseparator") ;
            Wwputilities_Selectall = httpContext.cgiGet( "WWPUTILITIES_Selectall") ;
            Wwputilities_Sortasc = httpContext.cgiGet( "WWPUTILITIES_Sortasc") ;
            Wwputilities_Sortdsc = httpContext.cgiGet( "WWPUTILITIES_Sortdsc") ;
            Wwputilities_Allowgrouptext = httpContext.cgiGet( "WWPUTILITIES_Allowgrouptext") ;
            Wwputilities_Fixlefttext = httpContext.cgiGet( "WWPUTILITIES_Fixlefttext") ;
            Wwputilities_Fixrighttext = httpContext.cgiGet( "WWPUTILITIES_Fixrighttext") ;
            Wwputilities_Loadingdata = httpContext.cgiGet( "WWPUTILITIES_Loadingdata") ;
            Wwputilities_Cleanfilter = httpContext.cgiGet( "WWPUTILITIES_Cleanfilter") ;
            Wwputilities_Rangefilterfrom = httpContext.cgiGet( "WWPUTILITIES_Rangefilterfrom") ;
            Wwputilities_Rangefilterto = httpContext.cgiGet( "WWPUTILITIES_Rangefilterto") ;
            Wwputilities_Rangepickerinvitemessage = httpContext.cgiGet( "WWPUTILITIES_Rangepickerinvitemessage") ;
            Wwputilities_Noresultsfound = httpContext.cgiGet( "WWPUTILITIES_Noresultsfound") ;
            Wwputilities_Searchbuttontext = httpContext.cgiGet( "WWPUTILITIES_Searchbuttontext") ;
            Wwputilities_Searchmultiplevaluesbuttontext = httpContext.cgiGet( "WWPUTILITIES_Searchmultiplevaluesbuttontext") ;
            Wwputilities_Columnselectorfixedleftcategory = httpContext.cgiGet( "WWPUTILITIES_Columnselectorfixedleftcategory") ;
            Wwputilities_Columnselectorfixedrightcategory = httpContext.cgiGet( "WWPUTILITIES_Columnselectorfixedrightcategory") ;
            Wwputilities_Columnselectornotfixedcategory = httpContext.cgiGet( "WWPUTILITIES_Columnselectornotfixedcategory") ;
            Wwputilities_Columnselectornocategorytext = httpContext.cgiGet( "WWPUTILITIES_Columnselectornocategorytext") ;
            Wwputilities_Columnselectorfixedempty = httpContext.cgiGet( "WWPUTILITIES_Columnselectorfixedempty") ;
            Wwputilities_Columnselectorrestoretooltip = httpContext.cgiGet( "WWPUTILITIES_Columnselectorrestoretooltip") ;
            Wwputilities_Pagbargotocaption = httpContext.cgiGet( "WWPUTILITIES_Pagbargotocaption") ;
            Wwputilities_Pagbargotoiconclass = httpContext.cgiGet( "WWPUTILITIES_Pagbargotoiconclass") ;
            Wwputilities_Pagbargototooltip = httpContext.cgiGet( "WWPUTILITIES_Pagbargototooltip") ;
            Wwputilities_Pagbaremptyfilteredgridcaption = httpContext.cgiGet( "WWPUTILITIES_Pagbaremptyfilteredgridcaption") ;
            Wwputilities_Visible = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Visible")) ;
            Wwputilities_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "WWPUTILITIES_Gxcontroltype"), ",", ".")) ;
            /* Read variables values. */
            A25ProtID = localUtil.ctol( httpContext.cgiGet( edtProtID_Internalname), ",", ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEnfID_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEnfID_Internalname), ",", ".") > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ENFID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEnfID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1EnfID = 0 ;
               n1EnfID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
            }
            else
            {
               A1EnfID = localUtil.ctol( httpContext.cgiGet( edtEnfID_Internalname), ",", ".") ;
               n1EnfID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
            }
            n1EnfID = ((0==A1EnfID) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCntdID_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCntdID_Internalname), ",", ".") > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CNTDID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCntdID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A23CntdID = 0 ;
               n23CntdID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
            }
            else
            {
               A23CntdID = localUtil.ctol( httpContext.cgiGet( edtCntdID_Internalname), ",", ".") ;
               n23CntdID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
            }
            n23CntdID = ((0==A23CntdID) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtProtOrd_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtProtOrd_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PROTORD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProtOrd_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A26ProtOrd = (short)(0) ;
               n26ProtOrd = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A26ProtOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26ProtOrd), 4, 0));
            }
            else
            {
               A26ProtOrd = (short)(localUtil.ctol( httpContext.cgiGet( edtProtOrd_Internalname), ",", ".")) ;
               n26ProtOrd = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A26ProtOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26ProtOrd), 4, 0));
            }
            n26ProtOrd = ((0==A26ProtOrd) ? true : false) ;
            A27ProtTxt = httpContext.cgiGet( edtProtTxt_Internalname) ;
            n27ProtTxt = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A27ProtTxt", A27ProtTxt);
            n27ProtTxt = ((GXutil.strcmp("", A27ProtTxt)==0) ? true : false) ;
            AV19ComboEnfID = localUtil.ctol( httpContext.cgiGet( edtavComboenfid_Internalname), ",", ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboEnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboEnfID), 10, 0));
            AV21ComboCntdID = localUtil.ctol( httpContext.cgiGet( edtavCombocntdid_Internalname), ",", ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCntdID), 10, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Protocolo");
            A25ProtID = localUtil.ctol( httpContext.cgiGet( edtProtID_Internalname), ",", ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
            forbiddenHiddens.add("ProtID", localUtil.format( DecimalUtil.doubleToDec(A25ProtID), "ZZZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A25ProtID != Z25ProtID ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("protocolo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A25ProtID = GXutil.lval( httpContext.GetPar( "ProtID")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
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
                  sMode5 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound5 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_050( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PROTID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtProtID_Internalname ;
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
                        e12052 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e13052 ();
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
         e13052 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll055( ) ;
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
         disableAttributes055( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboenfid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboenfid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocntdid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocntdid_Enabled), 5, 0), true);
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

   public void confirm_050( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls055( ) ;
         }
         else
         {
            checkExtendedTable055( ) ;
            closeExtendedTableCursors055( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption050( )
   {
   }

   public void e12052( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0];
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0];
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCntdID_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCntdID_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdID_Visible), 5, 0), true);
      AV21ComboCntdID = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCntdID), 10, 0));
      edtavCombocntdid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocntdid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocntdid_Visible), 5, 0), true);
      edtEnfID_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEnfID_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfID_Visible), 5, 0), true);
      AV19ComboEnfID = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboEnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboEnfID), 10, 0));
      edtavComboenfid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboenfid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboenfid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOENFID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOCNTDID' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(3);
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
            AV13TrnContextAtt = (com.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV25GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EnfID") == 0 )
            {
               AV11Insert_EnfID = GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_EnfID), 10, 0));
               if ( ! (0==AV11Insert_EnfID) )
               {
                  AV19ComboEnfID = AV11Insert_EnfID ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboEnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboEnfID), 10, 0));
                  Combo_enfid_Selectedvalue_set = GXutil.trim( GXutil.str( AV19ComboEnfID, 10, 0)) ;
                  ucCombo_enfid.sendProperty(context, "", false, Combo_enfid_Internalname, "SelectedValue_set", Combo_enfid_Selectedvalue_set);
                  GXt_char4 = AV18Combo_DataJson ;
                  GXv_char5[0] = AV16ComboSelectedValue ;
                  GXv_char6[0] = AV17ComboSelectedText ;
                  GXv_char7[0] = GXt_char4 ;
                  new com.protocololoaddvcombo(remoteHandle, context).execute( "EnfID", "GET", false, AV7ProtID, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char5, GXv_char6, GXv_char7) ;
                  protocolo_impl.this.AV16ComboSelectedValue = GXv_char5[0] ;
                  protocolo_impl.this.AV17ComboSelectedText = GXv_char6[0] ;
                  protocolo_impl.this.GXt_char4 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
                  AV18Combo_DataJson = GXt_char4 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
                  Combo_enfid_Selectedtext_set = AV17ComboSelectedText ;
                  ucCombo_enfid.sendProperty(context, "", false, Combo_enfid_Internalname, "SelectedText_set", Combo_enfid_Selectedtext_set);
                  Combo_enfid_Enabled = false ;
                  ucCombo_enfid.sendProperty(context, "", false, Combo_enfid_Internalname, "Enabled", GXutil.booltostr( Combo_enfid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CntdID") == 0 )
            {
               AV12Insert_CntdID = GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_CntdID), 10, 0));
               if ( ! (0==AV12Insert_CntdID) )
               {
                  AV21ComboCntdID = AV12Insert_CntdID ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCntdID), 10, 0));
                  Combo_cntdid_Selectedvalue_set = GXutil.trim( GXutil.str( AV21ComboCntdID, 10, 0)) ;
                  ucCombo_cntdid.sendProperty(context, "", false, Combo_cntdid_Internalname, "SelectedValue_set", Combo_cntdid_Selectedvalue_set);
                  GXt_char4 = AV18Combo_DataJson ;
                  GXv_char7[0] = AV16ComboSelectedValue ;
                  GXv_char6[0] = AV17ComboSelectedText ;
                  GXv_char5[0] = GXt_char4 ;
                  new com.protocololoaddvcombo(remoteHandle, context).execute( "CntdID", "GET", false, AV7ProtID, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char6, GXv_char5) ;
                  protocolo_impl.this.AV16ComboSelectedValue = GXv_char7[0] ;
                  protocolo_impl.this.AV17ComboSelectedText = GXv_char6[0] ;
                  protocolo_impl.this.GXt_char4 = GXv_char5[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
                  AV18Combo_DataJson = GXt_char4 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
                  Combo_cntdid_Selectedtext_set = AV17ComboSelectedText ;
                  ucCombo_cntdid.sendProperty(context, "", false, Combo_cntdid_Internalname, "SelectedText_set", Combo_cntdid_Selectedtext_set);
                  Combo_cntdid_Enabled = false ;
                  ucCombo_cntdid.sendProperty(context, "", false, Combo_cntdid_Internalname, "Enabled", GXutil.booltostr( Combo_cntdid_Enabled));
               }
            }
            AV25GXV1 = (int)(AV25GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GXV1), 8, 0));
         }
      }
   }

   public void e13052( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         AV22DetailWCInfo.setgxTv_SdtSplitScreenDetailInfo_Link( formatLink("com.protocolo", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.ltrimstr(A25ProtID,10,0))}, new String[] {"Mode","ProtID"})  );
         AV22DetailWCInfo.setgxTv_SdtSplitScreenDetailInfo_Title( GXutil.str( A26ProtOrd, 4, 0) );
         this.executeExternalObjectMethod("", false, "GlobalEvents", "SplitScreenWithTabs_UpdateTab", new Object[] {Integer.valueOf(3),AV22DetailWCInfo,Boolean.valueOf(true),"protocolo"}, true);
      }
      else if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         AV22DetailWCInfo.setgxTv_SdtSplitScreenDetailInfo_Link( formatLink("com.protocolo", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.ltrimstr(A25ProtID,10,0))}, new String[] {"Mode","ProtID"})  );
         AV22DetailWCInfo.setgxTv_SdtSplitScreenDetailInfo_Title( GXutil.str( A26ProtOrd, 4, 0) );
         this.executeExternalObjectMethod("", false, "GlobalEvents", "SplitScreenWithTabs_UpdateTab", new Object[] {Integer.valueOf(5),AV22DetailWCInfo,Boolean.valueOf(true),"protocolo"}, true);
      }
      else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         AV22DetailWCInfo.setgxTv_SdtSplitScreenDetailInfo_Link( formatLink("com.protocolo", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.ltrimstr(A25ProtID,10,0))}, new String[] {"Mode","ProtID"})  );
         this.executeExternalObjectMethod("", false, "GlobalEvents", "SplitScreenWithTabs_UpdateTab", new Object[] {Integer.valueOf(4),AV22DetailWCInfo,Boolean.valueOf(true),"protocolo"}, true);
      }
      this.executeUsercontrolMethod("", false, "WWPUTILITIESContainer", "CurrentTab_Return", "", new Object[] {});
      AV23CurrentTab_ReturnUrl = Wwputilities_Currenttab_returnurl ;
      if ( ! (GXutil.strcmp("", AV23CurrentTab_ReturnUrl)==0) )
      {
         callWebObject(formatLink(AV23CurrentTab_ReturnUrl, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22DetailWCInfo", AV22DetailWCInfo);
   }

   public void S122( )
   {
      /* 'LOADCOMBOCNTDID' Routine */
      returnInSub = false ;
      GXt_char4 = AV18Combo_DataJson ;
      GXv_char7[0] = AV16ComboSelectedValue ;
      GXv_char6[0] = AV17ComboSelectedText ;
      GXv_char5[0] = GXt_char4 ;
      new com.protocololoaddvcombo(remoteHandle, context).execute( "CntdID", Gx_mode, false, AV7ProtID, "", GXv_char7, GXv_char6, GXv_char5) ;
      protocolo_impl.this.AV16ComboSelectedValue = GXv_char7[0] ;
      protocolo_impl.this.AV17ComboSelectedText = GXv_char6[0] ;
      protocolo_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
      AV18Combo_DataJson = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
      Combo_cntdid_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_cntdid.sendProperty(context, "", false, Combo_cntdid_Internalname, "SelectedValue_set", Combo_cntdid_Selectedvalue_set);
      Combo_cntdid_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_cntdid.sendProperty(context, "", false, Combo_cntdid_Internalname, "SelectedText_set", Combo_cntdid_Selectedtext_set);
      AV21ComboCntdID = GXutil.lval( AV16ComboSelectedValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCntdID), 10, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_cntdid_Enabled = false ;
         ucCombo_cntdid.sendProperty(context, "", false, Combo_cntdid_Internalname, "Enabled", GXutil.booltostr( Combo_cntdid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOENFID' Routine */
      returnInSub = false ;
      GXt_char4 = AV18Combo_DataJson ;
      GXv_char7[0] = AV16ComboSelectedValue ;
      GXv_char6[0] = AV17ComboSelectedText ;
      GXv_char5[0] = GXt_char4 ;
      new com.protocololoaddvcombo(remoteHandle, context).execute( "EnfID", Gx_mode, false, AV7ProtID, "", GXv_char7, GXv_char6, GXv_char5) ;
      protocolo_impl.this.AV16ComboSelectedValue = GXv_char7[0] ;
      protocolo_impl.this.AV17ComboSelectedText = GXv_char6[0] ;
      protocolo_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
      AV18Combo_DataJson = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
      Combo_enfid_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_enfid.sendProperty(context, "", false, Combo_enfid_Internalname, "SelectedValue_set", Combo_enfid_Selectedvalue_set);
      Combo_enfid_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_enfid.sendProperty(context, "", false, Combo_enfid_Internalname, "SelectedText_set", Combo_enfid_Selectedtext_set);
      AV19ComboEnfID = GXutil.lval( AV16ComboSelectedValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboEnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboEnfID), 10, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_enfid_Enabled = false ;
         ucCombo_enfid.sendProperty(context, "", false, Combo_enfid_Internalname, "Enabled", GXutil.booltostr( Combo_enfid_Enabled));
      }
   }

   public void zm055( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z26ProtOrd = T00053_A26ProtOrd[0] ;
            Z27ProtTxt = T00053_A27ProtTxt[0] ;
            Z1EnfID = T00053_A1EnfID[0] ;
            Z23CntdID = T00053_A23CntdID[0] ;
         }
         else
         {
            Z26ProtOrd = A26ProtOrd ;
            Z27ProtTxt = A27ProtTxt ;
            Z1EnfID = A1EnfID ;
            Z23CntdID = A23CntdID ;
         }
      }
      if ( GX_JID == -11 )
      {
         Z25ProtID = A25ProtID ;
         Z26ProtOrd = A26ProtOrd ;
         Z27ProtTxt = A27ProtTxt ;
         Z1EnfID = A1EnfID ;
         Z23CntdID = A23CntdID ;
         Z3EnfDesc = A3EnfDesc ;
         Z24CntdDesc = A24CntdDesc ;
      }
   }

   public void standaloneNotModal( )
   {
      edtProtID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProtID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProtID_Enabled), 5, 0), true);
      AV24Pgmname = "Protocolo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      edtProtID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProtID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProtID_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7ProtID) )
      {
         A25ProtID = AV7ProtID ;
         httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_EnfID) )
      {
         edtEnfID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEnfID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfID_Enabled), 5, 0), true);
      }
      else
      {
         edtEnfID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEnfID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfID_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CntdID) )
      {
         edtCntdID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCntdID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdID_Enabled), 5, 0), true);
      }
      else
      {
         edtCntdID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCntdID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdID_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_EnfID) )
      {
         A1EnfID = AV11Insert_EnfID ;
         n1EnfID = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
      }
      else
      {
         if ( (0==AV19ComboEnfID) )
         {
            A1EnfID = 0 ;
            n1EnfID = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
            n1EnfID = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
         }
         else
         {
            if ( ! (0==AV19ComboEnfID) )
            {
               A1EnfID = AV19ComboEnfID ;
               n1EnfID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CntdID) )
      {
         A23CntdID = AV12Insert_CntdID ;
         n23CntdID = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
      }
      else
      {
         if ( (0==AV21ComboCntdID) )
         {
            A23CntdID = 0 ;
            n23CntdID = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
            n23CntdID = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
         }
         else
         {
            if ( ! (0==AV21ComboCntdID) )
            {
               A23CntdID = AV21ComboCntdID ;
               n23CntdID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
            }
         }
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T00054 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
         A3EnfDesc = T00054_A3EnfDesc[0] ;
         n3EnfDesc = T00054_n3EnfDesc[0] ;
         pr_default.close(2);
         /* Using cursor T00055 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
         A24CntdDesc = T00055_A24CntdDesc[0] ;
         pr_default.close(3);
      }
   }

   public void load055( )
   {
      /* Using cursor T00056 */
      pr_default.execute(4, new Object[] {Long.valueOf(A25ProtID)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A3EnfDesc = T00056_A3EnfDesc[0] ;
         n3EnfDesc = T00056_n3EnfDesc[0] ;
         A24CntdDesc = T00056_A24CntdDesc[0] ;
         A26ProtOrd = T00056_A26ProtOrd[0] ;
         n26ProtOrd = T00056_n26ProtOrd[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ProtOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26ProtOrd), 4, 0));
         A27ProtTxt = T00056_A27ProtTxt[0] ;
         n27ProtTxt = T00056_n27ProtTxt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ProtTxt", A27ProtTxt);
         A1EnfID = T00056_A1EnfID[0] ;
         n1EnfID = T00056_n1EnfID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
         A23CntdID = T00056_A23CntdID[0] ;
         n23CntdID = T00056_n23CntdID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
         zm055( -11) ;
      }
      pr_default.close(4);
      onLoadActions055( ) ;
   }

   public void onLoadActions055( )
   {
   }

   public void checkExtendedTable055( )
   {
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00054 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A1EnfID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Enfermedades'.", "ForeignKeyNotFound", 1, "ENFID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEnfID_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A3EnfDesc = T00054_A3EnfDesc[0] ;
      n3EnfDesc = T00054_n3EnfDesc[0] ;
      pr_default.close(2);
      /* Using cursor T00055 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A23CntdID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Contenidos'.", "ForeignKeyNotFound", 1, "CNTDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCntdID_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A24CntdDesc = T00055_A24CntdDesc[0] ;
      pr_default.close(3);
   }

   public void closeExtendedTableCursors055( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( long A1EnfID )
   {
      /* Using cursor T00057 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A1EnfID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Enfermedades'.", "ForeignKeyNotFound", 1, "ENFID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEnfID_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A3EnfDesc = T00057_A3EnfDesc[0] ;
      n3EnfDesc = T00057_n3EnfDesc[0] ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A3EnfDesc)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_13( long A23CntdID )
   {
      /* Using cursor T00058 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A23CntdID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Contenidos'.", "ForeignKeyNotFound", 1, "CNTDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCntdID_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A24CntdDesc = T00058_A24CntdDesc[0] ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A24CntdDesc))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey055( )
   {
      /* Using cursor T00059 */
      pr_default.execute(7, new Object[] {Long.valueOf(A25ProtID)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound5 = (short)(1) ;
      }
      else
      {
         RcdFound5 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00053 */
      pr_default.execute(1, new Object[] {Long.valueOf(A25ProtID)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm055( 11) ;
         RcdFound5 = (short)(1) ;
         A25ProtID = T00053_A25ProtID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
         A26ProtOrd = T00053_A26ProtOrd[0] ;
         n26ProtOrd = T00053_n26ProtOrd[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ProtOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26ProtOrd), 4, 0));
         A27ProtTxt = T00053_A27ProtTxt[0] ;
         n27ProtTxt = T00053_n27ProtTxt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ProtTxt", A27ProtTxt);
         A1EnfID = T00053_A1EnfID[0] ;
         n1EnfID = T00053_n1EnfID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
         A23CntdID = T00053_A23CntdID[0] ;
         n23CntdID = T00053_n23CntdID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
         Z25ProtID = A25ProtID ;
         sMode5 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load055( ) ;
         if ( AnyError == 1 )
         {
            RcdFound5 = (short)(0) ;
            initializeNonKey055( ) ;
         }
         Gx_mode = sMode5 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound5 = (short)(0) ;
         initializeNonKey055( ) ;
         sMode5 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode5 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey055( ) ;
      if ( RcdFound5 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound5 = (short)(0) ;
      /* Using cursor T000510 */
      pr_default.execute(8, new Object[] {Long.valueOf(A25ProtID)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000510_A25ProtID[0] < A25ProtID ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000510_A25ProtID[0] > A25ProtID ) ) )
         {
            A25ProtID = T000510_A25ProtID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
            RcdFound5 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound5 = (short)(0) ;
      /* Using cursor T000511 */
      pr_default.execute(9, new Object[] {Long.valueOf(A25ProtID)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000511_A25ProtID[0] > A25ProtID ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000511_A25ProtID[0] < A25ProtID ) ) )
         {
            A25ProtID = T000511_A25ProtID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
            RcdFound5 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey055( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEnfID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert055( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound5 == 1 )
         {
            if ( A25ProtID != Z25ProtID )
            {
               A25ProtID = Z25ProtID ;
               httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PROTID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProtID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEnfID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update055( ) ;
               GX_FocusControl = edtEnfID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A25ProtID != Z25ProtID )
            {
               /* Insert record */
               GX_FocusControl = edtEnfID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert055( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PROTID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtProtID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtEnfID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert055( ) ;
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
      if ( A25ProtID != Z25ProtID )
      {
         A25ProtID = Z25ProtID ;
         httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PROTID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProtID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEnfID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency055( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00052 */
         pr_default.execute(0, new Object[] {Long.valueOf(A25ProtID)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Protocolo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z26ProtOrd != T00052_A26ProtOrd[0] ) || ( GXutil.strcmp(Z27ProtTxt, T00052_A27ProtTxt[0]) != 0 ) || ( Z1EnfID != T00052_A1EnfID[0] ) || ( Z23CntdID != T00052_A23CntdID[0] ) )
         {
            if ( Z26ProtOrd != T00052_A26ProtOrd[0] )
            {
               GXutil.writeLogln("protocolo:[seudo value changed for attri]"+"ProtOrd");
               GXutil.writeLogRaw("Old: ",Z26ProtOrd);
               GXutil.writeLogRaw("Current: ",T00052_A26ProtOrd[0]);
            }
            if ( GXutil.strcmp(Z27ProtTxt, T00052_A27ProtTxt[0]) != 0 )
            {
               GXutil.writeLogln("protocolo:[seudo value changed for attri]"+"ProtTxt");
               GXutil.writeLogRaw("Old: ",Z27ProtTxt);
               GXutil.writeLogRaw("Current: ",T00052_A27ProtTxt[0]);
            }
            if ( Z1EnfID != T00052_A1EnfID[0] )
            {
               GXutil.writeLogln("protocolo:[seudo value changed for attri]"+"EnfID");
               GXutil.writeLogRaw("Old: ",Z1EnfID);
               GXutil.writeLogRaw("Current: ",T00052_A1EnfID[0]);
            }
            if ( Z23CntdID != T00052_A23CntdID[0] )
            {
               GXutil.writeLogln("protocolo:[seudo value changed for attri]"+"CntdID");
               GXutil.writeLogRaw("Old: ",Z23CntdID);
               GXutil.writeLogRaw("Current: ",T00052_A23CntdID[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Protocolo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert055( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable055( ) ;
      }
      if ( AnyError == 0 )
      {
         zm055( 0) ;
         checkOptimisticConcurrency055( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm055( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert055( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000512 */
                  pr_default.execute(10, new Object[] {Boolean.valueOf(n26ProtOrd), Short.valueOf(A26ProtOrd), Boolean.valueOf(n27ProtTxt), A27ProtTxt, Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID), Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000513 */
                  pr_default.execute(11);
                  A25ProtID = T000513_A25ProtID[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
                  pr_default.close(11);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Protocolo");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption050( ) ;
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
            load055( ) ;
         }
         endLevel055( ) ;
      }
      closeExtendedTableCursors055( ) ;
   }

   public void update055( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable055( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency055( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm055( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate055( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000514 */
                  pr_default.execute(12, new Object[] {Boolean.valueOf(n26ProtOrd), Short.valueOf(A26ProtOrd), Boolean.valueOf(n27ProtTxt), A27ProtTxt, Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID), Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID), Long.valueOf(A25ProtID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Protocolo");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Protocolo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate055( ) ;
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
         endLevel055( ) ;
      }
      closeExtendedTableCursors055( ) ;
   }

   public void deferredUpdate055( )
   {
   }

   public void delete( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency055( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls055( ) ;
         afterConfirm055( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete055( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000515 */
               pr_default.execute(13, new Object[] {Long.valueOf(A25ProtID)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Protocolo");
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
      sMode5 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel055( ) ;
      Gx_mode = sMode5 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls055( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000516 */
         pr_default.execute(14, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
         A3EnfDesc = T000516_A3EnfDesc[0] ;
         n3EnfDesc = T000516_n3EnfDesc[0] ;
         pr_default.close(14);
         /* Using cursor T000517 */
         pr_default.execute(15, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
         A24CntdDesc = T000517_A24CntdDesc[0] ;
         pr_default.close(15);
      }
   }

   public void endLevel055( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete055( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "protocolo");
         if ( AnyError == 0 )
         {
            confirmValues050( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "protocolo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart055( )
   {
      /* Scan By routine */
      /* Using cursor T000518 */
      pr_default.execute(16);
      RcdFound5 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A25ProtID = T000518_A25ProtID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext055( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound5 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A25ProtID = T000518_A25ProtID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
      }
   }

   public void scanEnd055( )
   {
      pr_default.close(16);
   }

   public void afterConfirm055( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert055( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate055( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete055( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete055( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate055( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes055( )
   {
      edtProtID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProtID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProtID_Enabled), 5, 0), true);
      edtEnfID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEnfID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfID_Enabled), 5, 0), true);
      edtCntdID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCntdID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdID_Enabled), 5, 0), true);
      edtProtOrd_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProtOrd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProtOrd_Enabled), 5, 0), true);
      edtProtTxt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProtTxt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProtTxt_Enabled), 5, 0), true);
      edtavComboenfid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboenfid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboenfid_Enabled), 5, 0), true);
      edtavCombocntdid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocntdid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocntdid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes055( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues050( )
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormSplitScreen\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormSplitScreen\" data-gx-class=\"form-horizontal FormSplitScreen\" novalidate action=\""+formatLink("com.protocolo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ProtID,10,0))}, new String[] {"Gx_mode","ProtID"}) +"\">") ;
      com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormSplitScreen", true);
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Protocolo");
      forbiddenHiddens.add("ProtID", localUtil.format( DecimalUtil.doubleToDec(A25ProtID), "ZZZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("protocolo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, "Z25ProtID", GXutil.ltrim( localUtil.ntoc( Z25ProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Z26ProtOrd", GXutil.ltrim( localUtil.ntoc( Z26ProtOrd, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Z27ProtTxt", Z27ProtTxt);
      com.GxWebStd.gx_hidden_field( httpContext, "Z1EnfID", GXutil.ltrim( localUtil.ntoc( Z1EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Z23CntdID", GXutil.ltrim( localUtil.ntoc( Z23CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.GxWebStd.gx_hidden_field( httpContext, "N1EnfID", GXutil.ltrim( localUtil.ntoc( A1EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "N23CntdID", GXutil.ltrim( localUtil.ntoc( A23CntdID, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vENFID_DATA", AV14EnfID_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vENFID_DATA", AV14EnfID_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCNTDID_DATA", AV20CntdID_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCNTDID_DATA", AV20CntdID_Data);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDETAILWCINFO", AV22DetailWCInfo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDETAILWCINFO", AV22DetailWCInfo);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDETAILWCINFO", getSecureSignedToken( "", AV22DetailWCInfo));
      com.GxWebStd.gx_hidden_field( httpContext, "vCURRENTTAB_RETURNURL", AV23CurrentTab_ReturnUrl);
      com.GxWebStd.gx_hidden_field( httpContext, "vPROTID", GXutil.ltrim( localUtil.ntoc( AV7ProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ProtID), "ZZZZZZZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ENFID", GXutil.ltrim( localUtil.ntoc( AV11Insert_EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CNTDID", GXutil.ltrim( localUtil.ntoc( AV12Insert_CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "ENFDESC", A3EnfDesc);
      com.GxWebStd.gx_hidden_field( httpContext, "CNTDDESC", GXutil.rtrim( A24CntdDesc));
      com.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV24Pgmname));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_ENFID_Objectcall", GXutil.rtrim( Combo_enfid_Objectcall));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_ENFID_Cls", GXutil.rtrim( Combo_enfid_Cls));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_ENFID_Selectedvalue_set", GXutil.rtrim( Combo_enfid_Selectedvalue_set));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_ENFID_Selectedtext_set", GXutil.rtrim( Combo_enfid_Selectedtext_set));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_ENFID_Enabled", GXutil.booltostr( Combo_enfid_Enabled));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_ENFID_Datalistproc", GXutil.rtrim( Combo_enfid_Datalistproc));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_ENFID_Datalistprocparametersprefix", GXutil.rtrim( Combo_enfid_Datalistprocparametersprefix));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_CNTDID_Objectcall", GXutil.rtrim( Combo_cntdid_Objectcall));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_CNTDID_Cls", GXutil.rtrim( Combo_cntdid_Cls));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_CNTDID_Selectedvalue_set", GXutil.rtrim( Combo_cntdid_Selectedvalue_set));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_CNTDID_Selectedtext_set", GXutil.rtrim( Combo_cntdid_Selectedtext_set));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_CNTDID_Enabled", GXutil.booltostr( Combo_cntdid_Enabled));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_CNTDID_Datalistproc", GXutil.rtrim( Combo_cntdid_Datalistproc));
      com.GxWebStd.gx_hidden_field( httpContext, "COMBO_CNTDID_Datalistprocparametersprefix", GXutil.rtrim( Combo_cntdid_Datalistprocparametersprefix));
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
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_Objectcall", GXutil.rtrim( Wwputilities_Objectcall));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_Enabled", GXutil.booltostr( Wwputilities_Enabled));
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
      com.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormSplitScreen" : Form.getThemeClass())+"-fx");
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
      return formatLink("com.protocolo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ProtID,10,0))}, new String[] {"Gx_mode","ProtID"})  ;
   }

   public String getPgmname( )
   {
      return "Protocolo" ;
   }

   public String getPgmdesc( )
   {
      return "Protocolo" ;
   }

   public void initializeNonKey055( )
   {
      A1EnfID = 0 ;
      n1EnfID = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
      n1EnfID = ((0==A1EnfID) ? true : false) ;
      A23CntdID = 0 ;
      n23CntdID = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
      n23CntdID = ((0==A23CntdID) ? true : false) ;
      A3EnfDesc = "" ;
      n3EnfDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A3EnfDesc", A3EnfDesc);
      A24CntdDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A24CntdDesc", A24CntdDesc);
      A26ProtOrd = (short)(0) ;
      n26ProtOrd = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A26ProtOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26ProtOrd), 4, 0));
      n26ProtOrd = ((0==A26ProtOrd) ? true : false) ;
      A27ProtTxt = "" ;
      n27ProtTxt = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A27ProtTxt", A27ProtTxt);
      n27ProtTxt = ((GXutil.strcmp("", A27ProtTxt)==0) ? true : false) ;
      Z26ProtOrd = (short)(0) ;
      Z27ProtTxt = "" ;
      Z1EnfID = 0 ;
      Z23CntdID = 0 ;
   }

   public void initAll055( )
   {
      A25ProtID = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
      initializeNonKey055( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/fontawesome/font-awesome.min.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617165685", true, true);
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
      httpContext.AddJavascriptSource("protocolo.js", "?202442617165685", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtProtID_Internalname = "PROTID" ;
      lblTextblockenfid_Internalname = "TEXTBLOCKENFID" ;
      Combo_enfid_Internalname = "COMBO_ENFID" ;
      edtEnfID_Internalname = "ENFID" ;
      divTablesplittedenfid_Internalname = "TABLESPLITTEDENFID" ;
      lblTextblockcntdid_Internalname = "TEXTBLOCKCNTDID" ;
      Combo_cntdid_Internalname = "COMBO_CNTDID" ;
      edtCntdID_Internalname = "CNTDID" ;
      divTablesplittedcntdid_Internalname = "TABLESPLITTEDCNTDID" ;
      edtProtOrd_Internalname = "PROTORD" ;
      edtProtTxt_Internalname = "PROTTXT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboenfid_Internalname = "vCOMBOENFID" ;
      divSectionattribute_enfid_Internalname = "SECTIONATTRIBUTE_ENFID" ;
      edtavCombocntdid_Internalname = "vCOMBOCNTDID" ;
      divSectionattribute_cntdid_Internalname = "SECTIONATTRIBUTE_CNTDID" ;
      Wwputilities_Internalname = "WWPUTILITIES" ;
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
      Form.setCaption( "Protocolo" );
      edtavCombocntdid_Jsonclick = "" ;
      edtavCombocntdid_Enabled = 0 ;
      edtavCombocntdid_Visible = 1 ;
      edtavComboenfid_Jsonclick = "" ;
      edtavComboenfid_Enabled = 0 ;
      edtavComboenfid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtProtTxt_Enabled = 1 ;
      edtProtOrd_Jsonclick = "" ;
      edtProtOrd_Enabled = 1 ;
      edtCntdID_Jsonclick = "" ;
      edtCntdID_Enabled = 1 ;
      edtCntdID_Visible = 1 ;
      Combo_cntdid_Datalistprocparametersprefix = " \"ComboName\": \"CntdID\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"ProtID\": 0" ;
      Combo_cntdid_Datalistproc = "ProtocoloLoadDVCombo" ;
      Combo_cntdid_Cls = "ExtendedCombo Attribute" ;
      Combo_cntdid_Caption = "" ;
      Combo_cntdid_Enabled = GXutil.toBoolean( -1) ;
      edtEnfID_Jsonclick = "" ;
      edtEnfID_Enabled = 1 ;
      edtEnfID_Visible = 1 ;
      Combo_enfid_Datalistprocparametersprefix = " \"ComboName\": \"EnfID\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"ProtID\": 0" ;
      Combo_enfid_Datalistproc = "ProtocoloLoadDVCombo" ;
      Combo_enfid_Cls = "ExtendedCombo Attribute" ;
      Combo_enfid_Caption = "" ;
      Combo_enfid_Enabled = GXutil.toBoolean( -1) ;
      edtProtID_Jsonclick = "" ;
      edtProtID_Enabled = 0 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = "Información General" ;
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

   public void init_web_controls( )
   {
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

   public void valid_Enfid( )
   {
      n1EnfID = false ;
      n3EnfDesc = false ;
      /* Using cursor T000516 */
      pr_default.execute(14, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (0==A1EnfID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Enfermedades'.", "ForeignKeyNotFound", 1, "ENFID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEnfID_Internalname ;
         }
      }
      A3EnfDesc = T000516_A3EnfDesc[0] ;
      n3EnfDesc = T000516_n3EnfDesc[0] ;
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A3EnfDesc", A3EnfDesc);
   }

   public void valid_Cntdid( )
   {
      n23CntdID = false ;
      /* Using cursor T000517 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         if ( ! ( (0==A23CntdID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Contenidos'.", "ForeignKeyNotFound", 1, "CNTDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCntdID_Internalname ;
         }
      }
      A24CntdDesc = T000517_A24CntdDesc[0] ;
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A24CntdDesc", GXutil.rtrim( A24CntdDesc));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ProtID',fld:'vPROTID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV22DetailWCInfo',fld:'vDETAILWCINFO',pic:'',hsh:true},{av:'AV7ProtID',fld:'vPROTID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e13052',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'AV22DetailWCInfo',fld:'vDETAILWCINFO',pic:'',hsh:true},{av:'A26ProtOrd',fld:'PROTORD',pic:'ZZZ9'},{av:'Wwputilities_Currenttab_returnurl',ctrl:'WWPUTILITIES',prop:'CurrentTab_ReturnUrl'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV22DetailWCInfo',fld:'vDETAILWCINFO',pic:'',hsh:true}]}");
      setEventMetadata("'CANCEL'","{handler:'e11055',iparms:[{av:'Wwputilities_Currenttab_returnurl',ctrl:'WWPUTILITIES',prop:'CurrentTab_ReturnUrl'},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV22DetailWCInfo',fld:'vDETAILWCINFO',pic:'',hsh:true}]");
      setEventMetadata("'CANCEL'",",oparms:[]}");
      setEventMetadata("VALID_PROTID","{handler:'valid_Protid',iparms:[]");
      setEventMetadata("VALID_PROTID",",oparms:[]}");
      setEventMetadata("VALID_ENFID","{handler:'valid_Enfid',iparms:[{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'A3EnfDesc',fld:'ENFDESC',pic:''}]");
      setEventMetadata("VALID_ENFID",",oparms:[{av:'A3EnfDesc',fld:'ENFDESC',pic:''}]}");
      setEventMetadata("VALID_CNTDID","{handler:'valid_Cntdid',iparms:[{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''}]");
      setEventMetadata("VALID_CNTDID",",oparms:[{av:'A24CntdDesc',fld:'CNTDDESC',pic:''}]}");
      setEventMetadata("VALIDV_COMBOENFID","{handler:'validv_Comboenfid',iparms:[]");
      setEventMetadata("VALIDV_COMBOENFID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOCNTDID","{handler:'validv_Combocntdid',iparms:[]");
      setEventMetadata("VALIDV_COMBOCNTDID",",oparms:[]}");
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
      pr_default.close(14);
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z27ProtTxt = "" ;
      Wwputilities_Currenttab_returnurl = "" ;
      Combo_cntdid_Selectedvalue_get = "" ;
      Combo_enfid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockenfid_Jsonclick = "" ;
      ucCombo_enfid = new com.genexus.webpanels.GXUserControl();
      AV15DDO_TitleSettingsIcons = new com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV14EnfID_Data = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblockcntdid_Jsonclick = "" ;
      ucCombo_cntdid = new com.genexus.webpanels.GXUserControl();
      AV20CntdID_Data = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A27ProtTxt = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucWwputilities = new com.genexus.webpanels.GXUserControl();
      AV22DetailWCInfo = new com.wwpbaseobjects.SdtSplitScreenDetailInfo(remoteHandle, context);
      AV23CurrentTab_ReturnUrl = "" ;
      A3EnfDesc = "" ;
      A24CntdDesc = "" ;
      AV24Pgmname = "" ;
      Combo_enfid_Objectcall = "" ;
      Combo_enfid_Class = "" ;
      Combo_enfid_Icontype = "" ;
      Combo_enfid_Icon = "" ;
      Combo_enfid_Tooltip = "" ;
      Combo_enfid_Selectedvalue_set = "" ;
      Combo_enfid_Selectedtext_set = "" ;
      Combo_enfid_Selectedtext_get = "" ;
      Combo_enfid_Gamoauthtoken = "" ;
      Combo_enfid_Ddointernalname = "" ;
      Combo_enfid_Titlecontrolalign = "" ;
      Combo_enfid_Dropdownoptionstype = "" ;
      Combo_enfid_Titlecontrolidtoreplace = "" ;
      Combo_enfid_Datalisttype = "" ;
      Combo_enfid_Datalistfixedvalues = "" ;
      Combo_enfid_Remoteservicesparameters = "" ;
      Combo_enfid_Htmltemplate = "" ;
      Combo_enfid_Multiplevaluestype = "" ;
      Combo_enfid_Loadingdata = "" ;
      Combo_enfid_Noresultsfound = "" ;
      Combo_enfid_Emptyitemtext = "" ;
      Combo_enfid_Onlyselectedvalues = "" ;
      Combo_enfid_Selectalltext = "" ;
      Combo_enfid_Multiplevaluesseparator = "" ;
      Combo_enfid_Addnewoptiontext = "" ;
      Combo_cntdid_Objectcall = "" ;
      Combo_cntdid_Class = "" ;
      Combo_cntdid_Icontype = "" ;
      Combo_cntdid_Icon = "" ;
      Combo_cntdid_Tooltip = "" ;
      Combo_cntdid_Selectedvalue_set = "" ;
      Combo_cntdid_Selectedtext_set = "" ;
      Combo_cntdid_Selectedtext_get = "" ;
      Combo_cntdid_Gamoauthtoken = "" ;
      Combo_cntdid_Ddointernalname = "" ;
      Combo_cntdid_Titlecontrolalign = "" ;
      Combo_cntdid_Dropdownoptionstype = "" ;
      Combo_cntdid_Titlecontrolidtoreplace = "" ;
      Combo_cntdid_Datalisttype = "" ;
      Combo_cntdid_Datalistfixedvalues = "" ;
      Combo_cntdid_Remoteservicesparameters = "" ;
      Combo_cntdid_Htmltemplate = "" ;
      Combo_cntdid_Multiplevaluestype = "" ;
      Combo_cntdid_Loadingdata = "" ;
      Combo_cntdid_Noresultsfound = "" ;
      Combo_cntdid_Emptyitemtext = "" ;
      Combo_cntdid_Onlyselectedvalues = "" ;
      Combo_cntdid_Selectalltext = "" ;
      Combo_cntdid_Multiplevaluesseparator = "" ;
      Combo_cntdid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Wwputilities_Objectcall = "" ;
      Wwputilities_Class = "" ;
      Wwputilities_Restorecolumnsiconclass = "" ;
      Wwputilities_Comboloadtype = "" ;
      Wwputilities_Updatebuttontext = "" ;
      Wwputilities_Addnewoption = "" ;
      Wwputilities_Onlyselectedvalues = "" ;
      Wwputilities_Multiplevaluesseparator = "" ;
      Wwputilities_Selectall = "" ;
      Wwputilities_Sortasc = "" ;
      Wwputilities_Sortdsc = "" ;
      Wwputilities_Allowgrouptext = "" ;
      Wwputilities_Fixlefttext = "" ;
      Wwputilities_Fixrighttext = "" ;
      Wwputilities_Loadingdata = "" ;
      Wwputilities_Cleanfilter = "" ;
      Wwputilities_Rangefilterfrom = "" ;
      Wwputilities_Rangefilterto = "" ;
      Wwputilities_Rangepickerinvitemessage = "" ;
      Wwputilities_Noresultsfound = "" ;
      Wwputilities_Searchbuttontext = "" ;
      Wwputilities_Searchmultiplevaluesbuttontext = "" ;
      Wwputilities_Columnselectorfixedleftcategory = "" ;
      Wwputilities_Columnselectorfixedrightcategory = "" ;
      Wwputilities_Columnselectornotfixedcategory = "" ;
      Wwputilities_Columnselectornocategorytext = "" ;
      Wwputilities_Columnselectorfixedempty = "" ;
      Wwputilities_Columnselectorrestoretooltip = "" ;
      Wwputilities_Pagbargotocaption = "" ;
      Wwputilities_Pagbargotoiconclass = "" ;
      Wwputilities_Pagbargototooltip = "" ;
      Wwputilities_Pagbaremptyfilteredgridcaption = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode5 = "" ;
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
      AV13TrnContextAtt = new com.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV18Combo_DataJson = "" ;
      AV16ComboSelectedValue = "" ;
      AV17ComboSelectedText = "" ;
      GXt_char4 = "" ;
      GXv_char7 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char5 = new String[1] ;
      Z3EnfDesc = "" ;
      Z24CntdDesc = "" ;
      T00054_A3EnfDesc = new String[] {""} ;
      T00054_n3EnfDesc = new boolean[] {false} ;
      T00055_A24CntdDesc = new String[] {""} ;
      T00056_A25ProtID = new long[1] ;
      T00056_A3EnfDesc = new String[] {""} ;
      T00056_n3EnfDesc = new boolean[] {false} ;
      T00056_A24CntdDesc = new String[] {""} ;
      T00056_A26ProtOrd = new short[1] ;
      T00056_n26ProtOrd = new boolean[] {false} ;
      T00056_A27ProtTxt = new String[] {""} ;
      T00056_n27ProtTxt = new boolean[] {false} ;
      T00056_A1EnfID = new long[1] ;
      T00056_n1EnfID = new boolean[] {false} ;
      T00056_A23CntdID = new long[1] ;
      T00056_n23CntdID = new boolean[] {false} ;
      T00057_A3EnfDesc = new String[] {""} ;
      T00057_n3EnfDesc = new boolean[] {false} ;
      T00058_A24CntdDesc = new String[] {""} ;
      T00059_A25ProtID = new long[1] ;
      T00053_A25ProtID = new long[1] ;
      T00053_A26ProtOrd = new short[1] ;
      T00053_n26ProtOrd = new boolean[] {false} ;
      T00053_A27ProtTxt = new String[] {""} ;
      T00053_n27ProtTxt = new boolean[] {false} ;
      T00053_A1EnfID = new long[1] ;
      T00053_n1EnfID = new boolean[] {false} ;
      T00053_A23CntdID = new long[1] ;
      T00053_n23CntdID = new boolean[] {false} ;
      T000510_A25ProtID = new long[1] ;
      T000511_A25ProtID = new long[1] ;
      T00052_A25ProtID = new long[1] ;
      T00052_A26ProtOrd = new short[1] ;
      T00052_n26ProtOrd = new boolean[] {false} ;
      T00052_A27ProtTxt = new String[] {""} ;
      T00052_n27ProtTxt = new boolean[] {false} ;
      T00052_A1EnfID = new long[1] ;
      T00052_n1EnfID = new boolean[] {false} ;
      T00052_A23CntdID = new long[1] ;
      T00052_n23CntdID = new boolean[] {false} ;
      T000513_A25ProtID = new long[1] ;
      T000516_A3EnfDesc = new String[] {""} ;
      T000516_n3EnfDesc = new boolean[] {false} ;
      T000517_A24CntdDesc = new String[] {""} ;
      T000518_A25ProtID = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.protocolo__default(),
         new Object[] {
             new Object[] {
            T00052_A25ProtID, T00052_A26ProtOrd, T00052_n26ProtOrd, T00052_A27ProtTxt, T00052_n27ProtTxt, T00052_A1EnfID, T00052_n1EnfID, T00052_A23CntdID, T00052_n23CntdID
            }
            , new Object[] {
            T00053_A25ProtID, T00053_A26ProtOrd, T00053_n26ProtOrd, T00053_A27ProtTxt, T00053_n27ProtTxt, T00053_A1EnfID, T00053_n1EnfID, T00053_A23CntdID, T00053_n23CntdID
            }
            , new Object[] {
            T00054_A3EnfDesc, T00054_n3EnfDesc
            }
            , new Object[] {
            T00055_A24CntdDesc
            }
            , new Object[] {
            T00056_A25ProtID, T00056_A3EnfDesc, T00056_n3EnfDesc, T00056_A24CntdDesc, T00056_A26ProtOrd, T00056_n26ProtOrd, T00056_A27ProtTxt, T00056_n27ProtTxt, T00056_A1EnfID, T00056_n1EnfID,
            T00056_A23CntdID, T00056_n23CntdID
            }
            , new Object[] {
            T00057_A3EnfDesc, T00057_n3EnfDesc
            }
            , new Object[] {
            T00058_A24CntdDesc
            }
            , new Object[] {
            T00059_A25ProtID
            }
            , new Object[] {
            T000510_A25ProtID
            }
            , new Object[] {
            T000511_A25ProtID
            }
            , new Object[] {
            }
            , new Object[] {
            T000513_A25ProtID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000516_A3EnfDesc, T000516_n3EnfDesc
            }
            , new Object[] {
            T000517_A24CntdDesc
            }
            , new Object[] {
            T000518_A25ProtID
            }
         }
      );
      AV24Pgmname = "Protocolo" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z26ProtOrd ;
   private short gxcookieaux ;
   private short AnyError ;
   private short IsModified ;
   private short IsConfirmed ;
   private short A26ProtOrd ;
   private short RcdFound5 ;
   private int trnEnded ;
   private int edtProtID_Enabled ;
   private int edtEnfID_Visible ;
   private int edtEnfID_Enabled ;
   private int edtCntdID_Visible ;
   private int edtCntdID_Enabled ;
   private int edtProtOrd_Enabled ;
   private int edtProtTxt_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboenfid_Enabled ;
   private int edtavComboenfid_Visible ;
   private int edtavCombocntdid_Enabled ;
   private int edtavCombocntdid_Visible ;
   private int Combo_enfid_Datalistupdateminimumcharacters ;
   private int Combo_enfid_Gxcontroltype ;
   private int Combo_cntdid_Datalistupdateminimumcharacters ;
   private int Combo_cntdid_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Wwputilities_Infinitescrollingpage ;
   private int Wwputilities_Gxcontroltype ;
   private int AV25GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7ProtID ;
   private long Z25ProtID ;
   private long Z1EnfID ;
   private long Z23CntdID ;
   private long N1EnfID ;
   private long N23CntdID ;
   private long A1EnfID ;
   private long A23CntdID ;
   private long AV7ProtID ;
   private long A25ProtID ;
   private long AV19ComboEnfID ;
   private long AV21ComboCntdID ;
   private long AV11Insert_EnfID ;
   private long AV12Insert_CntdID ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Wwputilities_Currenttab_returnurl ;
   private String Combo_cntdid_Selectedvalue_get ;
   private String Combo_enfid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEnfID_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTablecontent_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtProtID_Internalname ;
   private String edtProtID_Jsonclick ;
   private String divTablesplittedenfid_Internalname ;
   private String lblTextblockenfid_Internalname ;
   private String lblTextblockenfid_Jsonclick ;
   private String Combo_enfid_Caption ;
   private String Combo_enfid_Cls ;
   private String Combo_enfid_Datalistproc ;
   private String Combo_enfid_Datalistprocparametersprefix ;
   private String Combo_enfid_Internalname ;
   private String TempTags ;
   private String edtEnfID_Jsonclick ;
   private String divTablesplittedcntdid_Internalname ;
   private String lblTextblockcntdid_Internalname ;
   private String lblTextblockcntdid_Jsonclick ;
   private String Combo_cntdid_Caption ;
   private String Combo_cntdid_Cls ;
   private String Combo_cntdid_Datalistproc ;
   private String Combo_cntdid_Datalistprocparametersprefix ;
   private String Combo_cntdid_Internalname ;
   private String edtCntdID_Internalname ;
   private String edtCntdID_Jsonclick ;
   private String edtProtOrd_Internalname ;
   private String edtProtOrd_Jsonclick ;
   private String edtProtTxt_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_enfid_Internalname ;
   private String edtavComboenfid_Internalname ;
   private String edtavComboenfid_Jsonclick ;
   private String divSectionattribute_cntdid_Internalname ;
   private String edtavCombocntdid_Internalname ;
   private String edtavCombocntdid_Jsonclick ;
   private String Wwputilities_Internalname ;
   private String A24CntdDesc ;
   private String AV24Pgmname ;
   private String Combo_enfid_Objectcall ;
   private String Combo_enfid_Class ;
   private String Combo_enfid_Icontype ;
   private String Combo_enfid_Icon ;
   private String Combo_enfid_Tooltip ;
   private String Combo_enfid_Selectedvalue_set ;
   private String Combo_enfid_Selectedtext_set ;
   private String Combo_enfid_Selectedtext_get ;
   private String Combo_enfid_Gamoauthtoken ;
   private String Combo_enfid_Ddointernalname ;
   private String Combo_enfid_Titlecontrolalign ;
   private String Combo_enfid_Dropdownoptionstype ;
   private String Combo_enfid_Titlecontrolidtoreplace ;
   private String Combo_enfid_Datalisttype ;
   private String Combo_enfid_Datalistfixedvalues ;
   private String Combo_enfid_Remoteservicesparameters ;
   private String Combo_enfid_Htmltemplate ;
   private String Combo_enfid_Multiplevaluestype ;
   private String Combo_enfid_Loadingdata ;
   private String Combo_enfid_Noresultsfound ;
   private String Combo_enfid_Emptyitemtext ;
   private String Combo_enfid_Onlyselectedvalues ;
   private String Combo_enfid_Selectalltext ;
   private String Combo_enfid_Multiplevaluesseparator ;
   private String Combo_enfid_Addnewoptiontext ;
   private String Combo_cntdid_Objectcall ;
   private String Combo_cntdid_Class ;
   private String Combo_cntdid_Icontype ;
   private String Combo_cntdid_Icon ;
   private String Combo_cntdid_Tooltip ;
   private String Combo_cntdid_Selectedvalue_set ;
   private String Combo_cntdid_Selectedtext_set ;
   private String Combo_cntdid_Selectedtext_get ;
   private String Combo_cntdid_Gamoauthtoken ;
   private String Combo_cntdid_Ddointernalname ;
   private String Combo_cntdid_Titlecontrolalign ;
   private String Combo_cntdid_Dropdownoptionstype ;
   private String Combo_cntdid_Titlecontrolidtoreplace ;
   private String Combo_cntdid_Datalisttype ;
   private String Combo_cntdid_Datalistfixedvalues ;
   private String Combo_cntdid_Remoteservicesparameters ;
   private String Combo_cntdid_Htmltemplate ;
   private String Combo_cntdid_Multiplevaluestype ;
   private String Combo_cntdid_Loadingdata ;
   private String Combo_cntdid_Noresultsfound ;
   private String Combo_cntdid_Emptyitemtext ;
   private String Combo_cntdid_Onlyselectedvalues ;
   private String Combo_cntdid_Selectalltext ;
   private String Combo_cntdid_Multiplevaluesseparator ;
   private String Combo_cntdid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Wwputilities_Objectcall ;
   private String Wwputilities_Class ;
   private String Wwputilities_Restorecolumnsiconclass ;
   private String Wwputilities_Comboloadtype ;
   private String Wwputilities_Updatebuttontext ;
   private String Wwputilities_Addnewoption ;
   private String Wwputilities_Onlyselectedvalues ;
   private String Wwputilities_Multiplevaluesseparator ;
   private String Wwputilities_Selectall ;
   private String Wwputilities_Sortasc ;
   private String Wwputilities_Sortdsc ;
   private String Wwputilities_Allowgrouptext ;
   private String Wwputilities_Fixlefttext ;
   private String Wwputilities_Fixrighttext ;
   private String Wwputilities_Loadingdata ;
   private String Wwputilities_Cleanfilter ;
   private String Wwputilities_Rangefilterfrom ;
   private String Wwputilities_Rangefilterto ;
   private String Wwputilities_Rangepickerinvitemessage ;
   private String Wwputilities_Noresultsfound ;
   private String Wwputilities_Searchbuttontext ;
   private String Wwputilities_Searchmultiplevaluesbuttontext ;
   private String Wwputilities_Columnselectorfixedleftcategory ;
   private String Wwputilities_Columnselectorfixedrightcategory ;
   private String Wwputilities_Columnselectornotfixedcategory ;
   private String Wwputilities_Columnselectornocategorytext ;
   private String Wwputilities_Columnselectorfixedempty ;
   private String Wwputilities_Columnselectorrestoretooltip ;
   private String Wwputilities_Pagbargotocaption ;
   private String Wwputilities_Pagbargotoiconclass ;
   private String Wwputilities_Pagbargototooltip ;
   private String Wwputilities_Pagbaremptyfilteredgridcaption ;
   private String hsh ;
   private String sMode5 ;
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
   private String Z24CntdDesc ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1EnfID ;
   private boolean n23CntdID ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n26ProtOrd ;
   private boolean n27ProtTxt ;
   private boolean n3EnfDesc ;
   private boolean Combo_enfid_Enabled ;
   private boolean Combo_enfid_Visible ;
   private boolean Combo_enfid_Allowmultipleselection ;
   private boolean Combo_enfid_Isgriditem ;
   private boolean Combo_enfid_Hasdescription ;
   private boolean Combo_enfid_Includeonlyselectedoption ;
   private boolean Combo_enfid_Includeselectalloption ;
   private boolean Combo_enfid_Emptyitem ;
   private boolean Combo_enfid_Includeaddnewoption ;
   private boolean Combo_cntdid_Enabled ;
   private boolean Combo_cntdid_Visible ;
   private boolean Combo_cntdid_Allowmultipleselection ;
   private boolean Combo_cntdid_Isgriditem ;
   private boolean Combo_cntdid_Hasdescription ;
   private boolean Combo_cntdid_Includeonlyselectedoption ;
   private boolean Combo_cntdid_Includeselectalloption ;
   private boolean Combo_cntdid_Emptyitem ;
   private boolean Combo_cntdid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Wwputilities_Enabled ;
   private boolean Wwputilities_Enableautoupdatefromdocumenttitle ;
   private boolean Wwputilities_Enablefixobjectfitcover ;
   private boolean Wwputilities_Enablefloatinglabels ;
   private boolean Wwputilities_Empowertabs ;
   private boolean Wwputilities_Enableupdaterowselectionstatus ;
   private boolean Wwputilities_Enableconvertcombotobootstrapselect ;
   private boolean Wwputilities_Allowcolumnresizing ;
   private boolean Wwputilities_Allowcolumnreordering ;
   private boolean Wwputilities_Allowcolumndragging ;
   private boolean Wwputilities_Allowcolumnsrestore ;
   private boolean Wwputilities_Pagbarincludegoto ;
   private boolean Wwputilities_Visible ;
   private boolean returnInSub ;
   private String AV18Combo_DataJson ;
   private String Z27ProtTxt ;
   private String A27ProtTxt ;
   private String AV23CurrentTab_ReturnUrl ;
   private String A3EnfDesc ;
   private String AV16ComboSelectedValue ;
   private String AV17ComboSelectedText ;
   private String Z3EnfDesc ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_enfid ;
   private com.genexus.webpanels.GXUserControl ucCombo_cntdid ;
   private com.genexus.webpanels.GXUserControl ucWwputilities ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00054_A3EnfDesc ;
   private boolean[] T00054_n3EnfDesc ;
   private String[] T00055_A24CntdDesc ;
   private long[] T00056_A25ProtID ;
   private String[] T00056_A3EnfDesc ;
   private boolean[] T00056_n3EnfDesc ;
   private String[] T00056_A24CntdDesc ;
   private short[] T00056_A26ProtOrd ;
   private boolean[] T00056_n26ProtOrd ;
   private String[] T00056_A27ProtTxt ;
   private boolean[] T00056_n27ProtTxt ;
   private long[] T00056_A1EnfID ;
   private boolean[] T00056_n1EnfID ;
   private long[] T00056_A23CntdID ;
   private boolean[] T00056_n23CntdID ;
   private String[] T00057_A3EnfDesc ;
   private boolean[] T00057_n3EnfDesc ;
   private String[] T00058_A24CntdDesc ;
   private long[] T00059_A25ProtID ;
   private long[] T00053_A25ProtID ;
   private short[] T00053_A26ProtOrd ;
   private boolean[] T00053_n26ProtOrd ;
   private String[] T00053_A27ProtTxt ;
   private boolean[] T00053_n27ProtTxt ;
   private long[] T00053_A1EnfID ;
   private boolean[] T00053_n1EnfID ;
   private long[] T00053_A23CntdID ;
   private boolean[] T00053_n23CntdID ;
   private long[] T000510_A25ProtID ;
   private long[] T000511_A25ProtID ;
   private long[] T00052_A25ProtID ;
   private short[] T00052_A26ProtOrd ;
   private boolean[] T00052_n26ProtOrd ;
   private String[] T00052_A27ProtTxt ;
   private boolean[] T00052_n27ProtTxt ;
   private long[] T00052_A1EnfID ;
   private boolean[] T00052_n1EnfID ;
   private long[] T00052_A23CntdID ;
   private boolean[] T00052_n23CntdID ;
   private long[] T000513_A25ProtID ;
   private String[] T000516_A3EnfDesc ;
   private boolean[] T000516_n3EnfDesc ;
   private String[] T000517_A24CntdDesc ;
   private long[] T000518_A25ProtID ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14EnfID_Data ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV20CntdID_Data ;
   private com.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
   private com.wwpbaseobjects.SdtSplitScreenDetailInfo AV22DetailWCInfo ;
}

final  class protocolo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00052", "SELECT ProtID, ProtOrd, ProtTxt, EnfID, CntdID FROM Protocolo WHERE ProtID = ?  FOR UPDATE OF Protocolo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00053", "SELECT ProtID, ProtOrd, ProtTxt, EnfID, CntdID FROM Protocolo WHERE ProtID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00054", "SELECT EnfDesc FROM Enfermedades WHERE EnfID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00055", "SELECT CntdDesc FROM Contenidos WHERE CntdID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00056", "SELECT TM1.ProtID, T2.EnfDesc, T3.CntdDesc, TM1.ProtOrd, TM1.ProtTxt, TM1.EnfID, TM1.CntdID FROM ((Protocolo TM1 LEFT JOIN Enfermedades T2 ON T2.EnfID = TM1.EnfID) LEFT JOIN Contenidos T3 ON T3.CntdID = TM1.CntdID) WHERE TM1.ProtID = ? ORDER BY TM1.ProtID ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00057", "SELECT EnfDesc FROM Enfermedades WHERE EnfID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00058", "SELECT CntdDesc FROM Contenidos WHERE CntdID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00059", "SELECT ProtID FROM Protocolo WHERE ProtID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000510", "SELECT ProtID FROM Protocolo WHERE ( ProtID > ?) ORDER BY ProtID  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000511", "SELECT ProtID FROM Protocolo WHERE ( ProtID < ?) ORDER BY ProtID DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000512", "SAVEPOINT gxupdate;INSERT INTO Protocolo(ProtOrd, ProtTxt, EnfID, CntdID) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000513", "SELECT currval('ProtID') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000514", "SAVEPOINT gxupdate;UPDATE Protocolo SET ProtOrd=?, ProtTxt=?, EnfID=?, CntdID=?  WHERE ProtID = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000515", "SAVEPOINT gxupdate;DELETE FROM Protocolo  WHERE ProtID = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000516", "SELECT EnfDesc FROM Enfermedades WHERE EnfID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000517", "SELECT CntdDesc FROM Contenidos WHERE CntdID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000518", "SELECT ProtID FROM Protocolo ORDER BY ProtID ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((long[]) buf[5])[0] = rslt.getLong(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((long[]) buf[7])[0] = rslt.getLong(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((long[]) buf[5])[0] = rslt.getLong(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((long[]) buf[7])[0] = rslt.getLong(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 60);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 60);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((long[]) buf[8])[0] = rslt.getLong(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((long[]) buf[10])[0] = rslt.getLong(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 60);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 60);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[3], 10240);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(4, ((Number) parms[7]).longValue());
               }
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
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[3], 10240);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(4, ((Number) parms[7]).longValue());
               }
               stmt.setLong(5, ((Number) parms[8]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
      }
   }

}

