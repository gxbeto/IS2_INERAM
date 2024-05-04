package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class contenidos_impl extends GXDataArea
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
            AV7CntdID = GXutil.lval( httpContext.GetPar( "CntdID")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CntdID), 10, 0));
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCNTDID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CntdID), "ZZZZZZZZZ9")));
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
      Form.getMeta().addItem("description", "Contenidos", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCntdDesc_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS", true);
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public contenidos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public contenidos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( contenidos_impl.class ));
   }

   public contenidos_impl( int remoteHandle ,
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
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtCntdDesc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtCntdDesc_Internalname, "Tipo de Contenido", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtCntdDesc_Internalname, GXutil.rtrim( A24CntdDesc), GXutil.rtrim( localUtil.format( A24CntdDesc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCntdDesc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCntdDesc_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_Contenidos.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
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
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "start", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "Button" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Contenidos.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Contenidos.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Contenidos.htm");
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
      /* Single line edit */
      com.GxWebStd.gx_single_line_edit( httpContext, edtCntdID_Internalname, GXutil.ltrim( localUtil.ntoc( A23CntdID, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtCntdID_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A23CntdID), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A23CntdID), "ZZZZZZZZZ9"))), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCntdID_Jsonclick, 0, "Attribute", "", "", "", "", edtCntdID_Visible, edtCntdID_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Secuence", "end", false, "", "HLP_Contenidos.htm");
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
      e11042 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z23CntdID = localUtil.ctol( httpContext.cgiGet( "Z23CntdID"), ",", ".") ;
            Z24CntdDesc = httpContext.cgiGet( "Z24CntdDesc") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CntdID = localUtil.ctol( httpContext.cgiGet( "vCNTDID"), ",", ".") ;
            /* Read variables values. */
            A24CntdDesc = httpContext.cgiGet( edtCntdDesc_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A24CntdDesc", A24CntdDesc);
            A23CntdID = localUtil.ctol( httpContext.cgiGet( edtCntdID_Internalname), ",", ".") ;
            n23CntdID = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Contenidos");
            A23CntdID = localUtil.ctol( httpContext.cgiGet( edtCntdID_Internalname), ",", ".") ;
            n23CntdID = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
            forbiddenHiddens.add("CntdID", localUtil.format( DecimalUtil.doubleToDec(A23CntdID), "ZZZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A23CntdID != Z23CntdID ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("contenidos:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A23CntdID = GXutil.lval( httpContext.GetPar( "CntdID")) ;
               n23CntdID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
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
                  sMode4 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode4 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound4 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_040( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CNTDID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCntdID_Internalname ;
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
                        e11042 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12042 ();
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
         e12042 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll044( ) ;
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
         disableAttributes044( ) ;
      }
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

   public void confirm_040( )
   {
      beforeValidate044( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls044( ) ;
         }
         else
         {
            checkExtendedTable044( ) ;
            closeExtendedTableCursors044( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption040( )
   {
   }

   public void e11042( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0];
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      edtCntdID_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCntdID_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdID_Visible), 5, 0), true);
   }

   public void e12042( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.contenidosww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm044( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z24CntdDesc = T00043_A24CntdDesc[0] ;
         }
         else
         {
            Z24CntdDesc = A24CntdDesc ;
         }
      }
      if ( GX_JID == -3 )
      {
         Z23CntdID = A23CntdID ;
         Z24CntdDesc = A24CntdDesc ;
      }
   }

   public void standaloneNotModal( )
   {
      edtCntdID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCntdID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdID_Enabled), 5, 0), true);
      edtCntdID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCntdID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdID_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CntdID) )
      {
         A23CntdID = AV7CntdID ;
         n23CntdID = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
      }
   }

   public void standaloneModal( )
   {
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
   }

   public void load044( )
   {
      /* Using cursor T00044 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A24CntdDesc = T00044_A24CntdDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CntdDesc", A24CntdDesc);
         zm044( -3) ;
      }
      pr_default.close(2);
      onLoadActions044( ) ;
   }

   public void onLoadActions044( )
   {
   }

   public void checkExtendedTable044( )
   {
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors044( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey044( )
   {
      /* Using cursor T00045 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound4 = (short)(1) ;
      }
      else
      {
         RcdFound4 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00043 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm044( 3) ;
         RcdFound4 = (short)(1) ;
         A23CntdID = T00043_A23CntdID[0] ;
         n23CntdID = T00043_n23CntdID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
         A24CntdDesc = T00043_A24CntdDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CntdDesc", A24CntdDesc);
         Z23CntdID = A23CntdID ;
         sMode4 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load044( ) ;
         if ( AnyError == 1 )
         {
            RcdFound4 = (short)(0) ;
            initializeNonKey044( ) ;
         }
         Gx_mode = sMode4 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound4 = (short)(0) ;
         initializeNonKey044( ) ;
         sMode4 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode4 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey044( ) ;
      if ( RcdFound4 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound4 = (short)(0) ;
      /* Using cursor T00046 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( T00046_A23CntdID[0] < A23CntdID ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( T00046_A23CntdID[0] > A23CntdID ) ) )
         {
            A23CntdID = T00046_A23CntdID[0] ;
            n23CntdID = T00046_n23CntdID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
            RcdFound4 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound4 = (short)(0) ;
      /* Using cursor T00047 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( T00047_A23CntdID[0] > A23CntdID ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( T00047_A23CntdID[0] < A23CntdID ) ) )
         {
            A23CntdID = T00047_A23CntdID[0] ;
            n23CntdID = T00047_n23CntdID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
            RcdFound4 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey044( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCntdDesc_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert044( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound4 == 1 )
         {
            if ( A23CntdID != Z23CntdID )
            {
               A23CntdID = Z23CntdID ;
               n23CntdID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CNTDID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCntdID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCntdDesc_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update044( ) ;
               GX_FocusControl = edtCntdDesc_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A23CntdID != Z23CntdID )
            {
               /* Insert record */
               GX_FocusControl = edtCntdDesc_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert044( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CNTDID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCntdID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCntdDesc_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert044( ) ;
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
      if ( A23CntdID != Z23CntdID )
      {
         A23CntdID = Z23CntdID ;
         n23CntdID = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CNTDID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCntdID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCntdDesc_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency044( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00042 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Contenidos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z24CntdDesc, T00042_A24CntdDesc[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z24CntdDesc, T00042_A24CntdDesc[0]) != 0 )
            {
               GXutil.writeLogln("contenidos:[seudo value changed for attri]"+"CntdDesc");
               GXutil.writeLogRaw("Old: ",Z24CntdDesc);
               GXutil.writeLogRaw("Current: ",T00042_A24CntdDesc[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Contenidos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert044( )
   {
      beforeValidate044( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable044( ) ;
      }
      if ( AnyError == 0 )
      {
         zm044( 0) ;
         checkOptimisticConcurrency044( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm044( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert044( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00048 */
                  pr_default.execute(6, new Object[] {A24CntdDesc});
                  /* Retrieving last key number assigned */
                  /* Using cursor T00049 */
                  pr_default.execute(7);
                  A23CntdID = T00049_A23CntdID[0] ;
                  n23CntdID = T00049_n23CntdID[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
                  pr_default.close(7);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Contenidos");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption040( ) ;
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
            load044( ) ;
         }
         endLevel044( ) ;
      }
      closeExtendedTableCursors044( ) ;
   }

   public void update044( )
   {
      beforeValidate044( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable044( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency044( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm044( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate044( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000410 */
                  pr_default.execute(8, new Object[] {A24CntdDesc, Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Contenidos");
                  if ( (pr_default.getStatus(8) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Contenidos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate044( ) ;
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
         endLevel044( ) ;
      }
      closeExtendedTableCursors044( ) ;
   }

   public void deferredUpdate044( )
   {
   }

   public void delete( )
   {
      beforeValidate044( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency044( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls044( ) ;
         afterConfirm044( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete044( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000411 */
               pr_default.execute(9, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Contenidos");
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
      sMode4 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel044( ) ;
      Gx_mode = sMode4 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls044( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor T000412 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Protocolo"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
      }
   }

   public void endLevel044( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete044( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "contenidos");
         if ( AnyError == 0 )
         {
            confirmValues040( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "contenidos");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart044( )
   {
      /* Scan By routine */
      /* Using cursor T000413 */
      pr_default.execute(11);
      RcdFound4 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A23CntdID = T000413_A23CntdID[0] ;
         n23CntdID = T000413_n23CntdID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext044( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound4 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A23CntdID = T000413_A23CntdID[0] ;
         n23CntdID = T000413_n23CntdID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
      }
   }

   public void scanEnd044( )
   {
      pr_default.close(11);
   }

   public void afterConfirm044( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert044( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate044( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete044( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete044( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate044( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes044( )
   {
      edtCntdDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCntdDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdDesc_Enabled), 5, 0), true);
      edtCntdID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCntdID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCntdID_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes044( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues040( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.contenidos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CntdID,10,0))}, new String[] {"Gx_mode","CntdID"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Contenidos");
      forbiddenHiddens.add("CntdID", localUtil.format( DecimalUtil.doubleToDec(A23CntdID), "ZZZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("contenidos:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, "Z23CntdID", GXutil.ltrim( localUtil.ntoc( Z23CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Z24CntdDesc", GXutil.rtrim( Z24CntdDesc));
      com.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV9TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV9TrnContext);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV9TrnContext));
      com.GxWebStd.gx_hidden_field( httpContext, "vCNTDID", GXutil.ltrim( localUtil.ntoc( AV7CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCNTDID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CntdID), "ZZZZZZZZZ9")));
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
      return formatLink("com.contenidos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CntdID,10,0))}, new String[] {"Gx_mode","CntdID"})  ;
   }

   public String getPgmname( )
   {
      return "Contenidos" ;
   }

   public String getPgmdesc( )
   {
      return "Contenidos" ;
   }

   public void initializeNonKey044( )
   {
      A24CntdDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A24CntdDesc", A24CntdDesc);
      Z24CntdDesc = "" ;
   }

   public void initAll044( )
   {
      A23CntdID = 0 ;
      n23CntdID = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
      initializeNonKey044( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617164733", true, true);
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
      httpContext.AddJavascriptSource("contenidos.js", "?202442617164734", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCntdDesc_Internalname = "CNTDDESC" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCntdID_Internalname = "CNTDID" ;
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
      Form.setCaption( "Contenidos" );
      edtCntdID_Jsonclick = "" ;
      edtCntdID_Enabled = 0 ;
      edtCntdID_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtCntdDesc_Jsonclick = "" ;
      edtCntdDesc_Enabled = 1 ;
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

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12042',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CNTDID","{handler:'valid_Cntdid',iparms:[]");
      setEventMetadata("VALID_CNTDID",",oparms:[]}");
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
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z24CntdDesc = "" ;
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
      TempTags = "" ;
      A24CntdDesc = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode4 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new com.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.wwpbaseobjects.SdtWWPContext[1] ;
      AV9TrnContext = new com.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      T00044_A23CntdID = new long[1] ;
      T00044_n23CntdID = new boolean[] {false} ;
      T00044_A24CntdDesc = new String[] {""} ;
      T00045_A23CntdID = new long[1] ;
      T00045_n23CntdID = new boolean[] {false} ;
      T00043_A23CntdID = new long[1] ;
      T00043_n23CntdID = new boolean[] {false} ;
      T00043_A24CntdDesc = new String[] {""} ;
      T00046_A23CntdID = new long[1] ;
      T00046_n23CntdID = new boolean[] {false} ;
      T00047_A23CntdID = new long[1] ;
      T00047_n23CntdID = new boolean[] {false} ;
      T00042_A23CntdID = new long[1] ;
      T00042_n23CntdID = new boolean[] {false} ;
      T00042_A24CntdDesc = new String[] {""} ;
      T00049_A23CntdID = new long[1] ;
      T00049_n23CntdID = new boolean[] {false} ;
      T000412_A25ProtID = new long[1] ;
      T000413_A23CntdID = new long[1] ;
      T000413_n23CntdID = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.contenidos__default(),
         new Object[] {
             new Object[] {
            T00042_A23CntdID, T00042_A24CntdDesc
            }
            , new Object[] {
            T00043_A23CntdID, T00043_A24CntdDesc
            }
            , new Object[] {
            T00044_A23CntdID, T00044_A24CntdDesc
            }
            , new Object[] {
            T00045_A23CntdID
            }
            , new Object[] {
            T00046_A23CntdID
            }
            , new Object[] {
            T00047_A23CntdID
            }
            , new Object[] {
            }
            , new Object[] {
            T00049_A23CntdID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000412_A25ProtID
            }
            , new Object[] {
            T000413_A23CntdID
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short AnyError ;
   private short IsModified ;
   private short IsConfirmed ;
   private short RcdFound4 ;
   private int trnEnded ;
   private int edtCntdDesc_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCntdID_Enabled ;
   private int edtCntdID_Visible ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7CntdID ;
   private long Z23CntdID ;
   private long AV7CntdID ;
   private long A23CntdID ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z24CntdDesc ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCntdDesc_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String A24CntdDesc ;
   private String edtCntdDesc_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCntdID_Internalname ;
   private String edtCntdID_Jsonclick ;
   private String hsh ;
   private String sMode4 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean n23CntdID ;
   private boolean returnInSub ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private long[] T00044_A23CntdID ;
   private boolean[] T00044_n23CntdID ;
   private String[] T00044_A24CntdDesc ;
   private long[] T00045_A23CntdID ;
   private boolean[] T00045_n23CntdID ;
   private long[] T00043_A23CntdID ;
   private boolean[] T00043_n23CntdID ;
   private String[] T00043_A24CntdDesc ;
   private long[] T00046_A23CntdID ;
   private boolean[] T00046_n23CntdID ;
   private long[] T00047_A23CntdID ;
   private boolean[] T00047_n23CntdID ;
   private long[] T00042_A23CntdID ;
   private boolean[] T00042_n23CntdID ;
   private String[] T00042_A24CntdDesc ;
   private long[] T00049_A23CntdID ;
   private boolean[] T00049_n23CntdID ;
   private long[] T000412_A25ProtID ;
   private long[] T000413_A23CntdID ;
   private boolean[] T000413_n23CntdID ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class contenidos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00042", "SELECT CntdID, CntdDesc FROM Contenidos WHERE CntdID = ?  FOR UPDATE OF Contenidos NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00043", "SELECT CntdID, CntdDesc FROM Contenidos WHERE CntdID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00044", "SELECT TM1.CntdID, TM1.CntdDesc FROM Contenidos TM1 WHERE TM1.CntdID = ? ORDER BY TM1.CntdID ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00045", "SELECT CntdID FROM Contenidos WHERE CntdID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00046", "SELECT CntdID FROM Contenidos WHERE ( CntdID > ?) ORDER BY CntdID  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00047", "SELECT CntdID FROM Contenidos WHERE ( CntdID < ?) ORDER BY CntdID DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T00048", "SAVEPOINT gxupdate;INSERT INTO Contenidos(CntdDesc) VALUES(?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T00049", "SELECT currval('CntdID') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000410", "SAVEPOINT gxupdate;UPDATE Contenidos SET CntdDesc=?  WHERE CntdID = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000411", "SAVEPOINT gxupdate;DELETE FROM Contenidos  WHERE CntdID = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000412", "SELECT ProtID FROM Protocolo WHERE CntdID = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000413", "SELECT CntdID FROM Contenidos ORDER BY CntdID ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
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
               stmt.setString(1, (String)parms[0], 60);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 60);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(2, ((Number) parms[2]).longValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 10 :
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

