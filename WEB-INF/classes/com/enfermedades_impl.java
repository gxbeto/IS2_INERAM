package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class enfermedades_impl extends GXDataArea
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
            AV7EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EnfID), 10, 0));
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vENFID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EnfID), "ZZZZZZZZZ9")));
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
      Form.getMeta().addItem("description", "Enfermedades", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEnfNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS", true);
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public enfermedades_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public enfermedades_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( enfermedades_impl.class ));
   }

   public enfermedades_impl( int remoteHandle ,
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
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtEnfNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtEnfNombre_Internalname, "Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      com.GxWebStd.gx_single_line_edit( httpContext, edtEnfNombre_Internalname, GXutil.rtrim( A2EnfNombre), GXutil.rtrim( localUtil.format( A2EnfNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEnfNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEnfNombre_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_Enfermedades.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+edtEnfDesc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.GxWebStd.gx_label_element( httpContext, edtEnfDesc_Internalname, "Descripcion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.GxWebStd.gx_html_textarea( httpContext, edtEnfDesc_Internalname, A3EnfDesc, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", (short)(0), 1, edtEnfDesc_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "1024", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "", "HLP_Enfermedades.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
      ClassString = "Button" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Enfermedades.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Enfermedades.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Enfermedades.htm");
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
      com.GxWebStd.gx_single_line_edit( httpContext, edtEnfID_Internalname, GXutil.ltrim( localUtil.ntoc( A1EnfID, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtEnfID_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EnfID), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EnfID), "ZZZZZZZZZ9"))), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEnfID_Jsonclick, 0, "Attribute", "", "", "", "", edtEnfID_Visible, edtEnfID_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Secuence", "end", false, "", "HLP_Enfermedades.htm");
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
      e11012 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z1EnfID = localUtil.ctol( httpContext.cgiGet( "Z1EnfID"), ",", ".") ;
            Z2EnfNombre = httpContext.cgiGet( "Z2EnfNombre") ;
            n2EnfNombre = ((GXutil.strcmp("", A2EnfNombre)==0) ? true : false) ;
            Z3EnfDesc = httpContext.cgiGet( "Z3EnfDesc") ;
            n3EnfDesc = ((GXutil.strcmp("", A3EnfDesc)==0) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7EnfID = localUtil.ctol( httpContext.cgiGet( "vENFID"), ",", ".") ;
            /* Read variables values. */
            A2EnfNombre = httpContext.cgiGet( edtEnfNombre_Internalname) ;
            n2EnfNombre = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A2EnfNombre", A2EnfNombre);
            n2EnfNombre = ((GXutil.strcmp("", A2EnfNombre)==0) ? true : false) ;
            A3EnfDesc = httpContext.cgiGet( edtEnfDesc_Internalname) ;
            n3EnfDesc = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A3EnfDesc", A3EnfDesc);
            n3EnfDesc = ((GXutil.strcmp("", A3EnfDesc)==0) ? true : false) ;
            A1EnfID = localUtil.ctol( httpContext.cgiGet( edtEnfID_Internalname), ",", ".") ;
            n1EnfID = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Enfermedades");
            A1EnfID = localUtil.ctol( httpContext.cgiGet( edtEnfID_Internalname), ",", ".") ;
            n1EnfID = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
            forbiddenHiddens.add("EnfID", localUtil.format( DecimalUtil.doubleToDec(A1EnfID), "ZZZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1EnfID != Z1EnfID ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("enfermedades:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
               n1EnfID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
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
                  sMode1 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode1 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound1 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_010( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "ENFID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEnfID_Internalname ;
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
                        e11012 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12012 ();
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
         e12012 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll011( ) ;
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
         disableAttributes011( ) ;
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

   public void confirm_010( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls011( ) ;
         }
         else
         {
            checkExtendedTable011( ) ;
            closeExtendedTableCursors011( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption010( )
   {
   }

   public void e11012( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0];
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      edtEnfID_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEnfID_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfID_Visible), 5, 0), true);
   }

   public void e12012( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.enfermedadesww", new String[] {}, new String[] {}) );
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

   public void zm011( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2EnfNombre = T00013_A2EnfNombre[0] ;
            Z3EnfDesc = T00013_A3EnfDesc[0] ;
         }
         else
         {
            Z2EnfNombre = A2EnfNombre ;
            Z3EnfDesc = A3EnfDesc ;
         }
      }
      if ( GX_JID == -3 )
      {
         Z1EnfID = A1EnfID ;
         Z2EnfNombre = A2EnfNombre ;
         Z3EnfDesc = A3EnfDesc ;
      }
   }

   public void standaloneNotModal( )
   {
      edtEnfID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEnfID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfID_Enabled), 5, 0), true);
      edtEnfID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEnfID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfID_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7EnfID) )
      {
         A1EnfID = AV7EnfID ;
         n1EnfID = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
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

   public void load011( )
   {
      /* Using cursor T00014 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A2EnfNombre = T00014_A2EnfNombre[0] ;
         n2EnfNombre = T00014_n2EnfNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2EnfNombre", A2EnfNombre);
         A3EnfDesc = T00014_A3EnfDesc[0] ;
         n3EnfDesc = T00014_n3EnfDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3EnfDesc", A3EnfDesc);
         zm011( -3) ;
      }
      pr_default.close(2);
      onLoadActions011( ) ;
   }

   public void onLoadActions011( )
   {
   }

   public void checkExtendedTable011( )
   {
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors011( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey011( )
   {
      /* Using cursor T00015 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound1 = (short)(1) ;
      }
      else
      {
         RcdFound1 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00013 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm011( 3) ;
         RcdFound1 = (short)(1) ;
         A1EnfID = T00013_A1EnfID[0] ;
         n1EnfID = T00013_n1EnfID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
         A2EnfNombre = T00013_A2EnfNombre[0] ;
         n2EnfNombre = T00013_n2EnfNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2EnfNombre", A2EnfNombre);
         A3EnfDesc = T00013_A3EnfDesc[0] ;
         n3EnfDesc = T00013_n3EnfDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3EnfDesc", A3EnfDesc);
         Z1EnfID = A1EnfID ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load011( ) ;
         if ( AnyError == 1 )
         {
            RcdFound1 = (short)(0) ;
            initializeNonKey011( ) ;
         }
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound1 = (short)(0) ;
         initializeNonKey011( ) ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey011( ) ;
      if ( RcdFound1 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T00016 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( T00016_A1EnfID[0] < A1EnfID ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( T00016_A1EnfID[0] > A1EnfID ) ) )
         {
            A1EnfID = T00016_A1EnfID[0] ;
            n1EnfID = T00016_n1EnfID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T00017 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( T00017_A1EnfID[0] > A1EnfID ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( T00017_A1EnfID[0] < A1EnfID ) ) )
         {
            A1EnfID = T00017_A1EnfID[0] ;
            n1EnfID = T00017_n1EnfID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey011( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEnfNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert011( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound1 == 1 )
         {
            if ( A1EnfID != Z1EnfID )
            {
               A1EnfID = Z1EnfID ;
               n1EnfID = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "ENFID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEnfID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEnfNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update011( ) ;
               GX_FocusControl = edtEnfNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1EnfID != Z1EnfID )
            {
               /* Insert record */
               GX_FocusControl = edtEnfNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert011( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ENFID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEnfID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtEnfNombre_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert011( ) ;
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
      if ( A1EnfID != Z1EnfID )
      {
         A1EnfID = Z1EnfID ;
         n1EnfID = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "ENFID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEnfID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEnfNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency011( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00012 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Enfermedades"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z2EnfNombre, T00012_A2EnfNombre[0]) != 0 ) || ( GXutil.strcmp(Z3EnfDesc, T00012_A3EnfDesc[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z2EnfNombre, T00012_A2EnfNombre[0]) != 0 )
            {
               GXutil.writeLogln("enfermedades:[seudo value changed for attri]"+"EnfNombre");
               GXutil.writeLogRaw("Old: ",Z2EnfNombre);
               GXutil.writeLogRaw("Current: ",T00012_A2EnfNombre[0]);
            }
            if ( GXutil.strcmp(Z3EnfDesc, T00012_A3EnfDesc[0]) != 0 )
            {
               GXutil.writeLogln("enfermedades:[seudo value changed for attri]"+"EnfDesc");
               GXutil.writeLogRaw("Old: ",Z3EnfDesc);
               GXutil.writeLogRaw("Current: ",T00012_A3EnfDesc[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Enfermedades"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert011( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         zm011( 0) ;
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00018 */
                  pr_default.execute(6, new Object[] {Boolean.valueOf(n2EnfNombre), A2EnfNombre, Boolean.valueOf(n3EnfDesc), A3EnfDesc});
                  /* Retrieving last key number assigned */
                  /* Using cursor T00019 */
                  pr_default.execute(7);
                  A1EnfID = T00019_A1EnfID[0] ;
                  n1EnfID = T00019_n1EnfID[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
                  pr_default.close(7);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Enfermedades");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption010( ) ;
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
            load011( ) ;
         }
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void update011( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000110 */
                  pr_default.execute(8, new Object[] {Boolean.valueOf(n2EnfNombre), A2EnfNombre, Boolean.valueOf(n3EnfDesc), A3EnfDesc, Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Enfermedades");
                  if ( (pr_default.getStatus(8) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Enfermedades"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate011( ) ;
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
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void deferredUpdate011( )
   {
   }

   public void delete( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls011( ) ;
         afterConfirm011( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete011( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000111 */
               pr_default.execute(9, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Enfermedades");
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
      sMode1 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel011( ) ;
      Gx_mode = sMode1 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls011( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor T000112 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Protocolo"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
      }
   }

   public void endLevel011( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete011( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "enfermedades");
         if ( AnyError == 0 )
         {
            confirmValues010( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "enfermedades");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart011( )
   {
      /* Scan By routine */
      /* Using cursor T000113 */
      pr_default.execute(11);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1EnfID = T000113_A1EnfID[0] ;
         n1EnfID = T000113_n1EnfID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext011( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1EnfID = T000113_A1EnfID[0] ;
         n1EnfID = T000113_n1EnfID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
      }
   }

   public void scanEnd011( )
   {
      pr_default.close(11);
   }

   public void afterConfirm011( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert011( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate011( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete011( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete011( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate011( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes011( )
   {
      edtEnfNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEnfNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfNombre_Enabled), 5, 0), true);
      edtEnfDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEnfDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfDesc_Enabled), 5, 0), true);
      edtEnfID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEnfID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEnfID_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes011( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues010( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.enfermedades", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7EnfID,10,0))}, new String[] {"Gx_mode","EnfID"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Enfermedades");
      forbiddenHiddens.add("EnfID", localUtil.format( DecimalUtil.doubleToDec(A1EnfID), "ZZZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("enfermedades:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, "Z1EnfID", GXutil.ltrim( localUtil.ntoc( Z1EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "Z2EnfNombre", GXutil.rtrim( Z2EnfNombre));
      com.GxWebStd.gx_hidden_field( httpContext, "Z3EnfDesc", Z3EnfDesc);
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
      com.GxWebStd.gx_hidden_field( httpContext, "vENFID", GXutil.ltrim( localUtil.ntoc( AV7EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vENFID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EnfID), "ZZZZZZZZZ9")));
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
      return formatLink("com.enfermedades", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7EnfID,10,0))}, new String[] {"Gx_mode","EnfID"})  ;
   }

   public String getPgmname( )
   {
      return "Enfermedades" ;
   }

   public String getPgmdesc( )
   {
      return "Enfermedades" ;
   }

   public void initializeNonKey011( )
   {
      A2EnfNombre = "" ;
      n2EnfNombre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2EnfNombre", A2EnfNombre);
      n2EnfNombre = ((GXutil.strcmp("", A2EnfNombre)==0) ? true : false) ;
      A3EnfDesc = "" ;
      n3EnfDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A3EnfDesc", A3EnfDesc);
      n3EnfDesc = ((GXutil.strcmp("", A3EnfDesc)==0) ? true : false) ;
      Z2EnfNombre = "" ;
      Z3EnfDesc = "" ;
   }

   public void initAll011( )
   {
      A1EnfID = 0 ;
      n1EnfID = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
      initializeNonKey011( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20244261716455", true, true);
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
      httpContext.AddJavascriptSource("enfermedades.js", "?20244261716456", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtEnfNombre_Internalname = "ENFNOMBRE" ;
      edtEnfDesc_Internalname = "ENFDESC" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtEnfID_Internalname = "ENFID" ;
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
      Form.setCaption( "Enfermedades" );
      edtEnfID_Jsonclick = "" ;
      edtEnfID_Enabled = 0 ;
      edtEnfID_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtEnfDesc_Enabled = 1 ;
      edtEnfNombre_Jsonclick = "" ;
      edtEnfNombre_Enabled = 1 ;
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12012',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_ENFID","{handler:'valid_Enfid',iparms:[]");
      setEventMetadata("VALID_ENFID",",oparms:[]}");
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
      Z2EnfNombre = "" ;
      Z3EnfDesc = "" ;
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
      A2EnfNombre = "" ;
      A3EnfDesc = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode1 = "" ;
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
      T00014_A1EnfID = new long[1] ;
      T00014_n1EnfID = new boolean[] {false} ;
      T00014_A2EnfNombre = new String[] {""} ;
      T00014_n2EnfNombre = new boolean[] {false} ;
      T00014_A3EnfDesc = new String[] {""} ;
      T00014_n3EnfDesc = new boolean[] {false} ;
      T00015_A1EnfID = new long[1] ;
      T00015_n1EnfID = new boolean[] {false} ;
      T00013_A1EnfID = new long[1] ;
      T00013_n1EnfID = new boolean[] {false} ;
      T00013_A2EnfNombre = new String[] {""} ;
      T00013_n2EnfNombre = new boolean[] {false} ;
      T00013_A3EnfDesc = new String[] {""} ;
      T00013_n3EnfDesc = new boolean[] {false} ;
      T00016_A1EnfID = new long[1] ;
      T00016_n1EnfID = new boolean[] {false} ;
      T00017_A1EnfID = new long[1] ;
      T00017_n1EnfID = new boolean[] {false} ;
      T00012_A1EnfID = new long[1] ;
      T00012_n1EnfID = new boolean[] {false} ;
      T00012_A2EnfNombre = new String[] {""} ;
      T00012_n2EnfNombre = new boolean[] {false} ;
      T00012_A3EnfDesc = new String[] {""} ;
      T00012_n3EnfDesc = new boolean[] {false} ;
      T00019_A1EnfID = new long[1] ;
      T00019_n1EnfID = new boolean[] {false} ;
      T000112_A25ProtID = new long[1] ;
      T000113_A1EnfID = new long[1] ;
      T000113_n1EnfID = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.enfermedades__default(),
         new Object[] {
             new Object[] {
            T00012_A1EnfID, T00012_A2EnfNombre, T00012_n2EnfNombre, T00012_A3EnfDesc, T00012_n3EnfDesc
            }
            , new Object[] {
            T00013_A1EnfID, T00013_A2EnfNombre, T00013_n2EnfNombre, T00013_A3EnfDesc, T00013_n3EnfDesc
            }
            , new Object[] {
            T00014_A1EnfID, T00014_A2EnfNombre, T00014_n2EnfNombre, T00014_A3EnfDesc, T00014_n3EnfDesc
            }
            , new Object[] {
            T00015_A1EnfID
            }
            , new Object[] {
            T00016_A1EnfID
            }
            , new Object[] {
            T00017_A1EnfID
            }
            , new Object[] {
            }
            , new Object[] {
            T00019_A1EnfID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000112_A25ProtID
            }
            , new Object[] {
            T000113_A1EnfID
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
   private short RcdFound1 ;
   private int trnEnded ;
   private int edtEnfNombre_Enabled ;
   private int edtEnfDesc_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtEnfID_Enabled ;
   private int edtEnfID_Visible ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7EnfID ;
   private long Z1EnfID ;
   private long AV7EnfID ;
   private long A1EnfID ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z2EnfNombre ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEnfNombre_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String A2EnfNombre ;
   private String edtEnfNombre_Jsonclick ;
   private String edtEnfDesc_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtEnfID_Internalname ;
   private String edtEnfID_Jsonclick ;
   private String hsh ;
   private String sMode1 ;
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
   private boolean n2EnfNombre ;
   private boolean n3EnfDesc ;
   private boolean n1EnfID ;
   private boolean returnInSub ;
   private String Z3EnfDesc ;
   private String A3EnfDesc ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private long[] T00014_A1EnfID ;
   private boolean[] T00014_n1EnfID ;
   private String[] T00014_A2EnfNombre ;
   private boolean[] T00014_n2EnfNombre ;
   private String[] T00014_A3EnfDesc ;
   private boolean[] T00014_n3EnfDesc ;
   private long[] T00015_A1EnfID ;
   private boolean[] T00015_n1EnfID ;
   private long[] T00013_A1EnfID ;
   private boolean[] T00013_n1EnfID ;
   private String[] T00013_A2EnfNombre ;
   private boolean[] T00013_n2EnfNombre ;
   private String[] T00013_A3EnfDesc ;
   private boolean[] T00013_n3EnfDesc ;
   private long[] T00016_A1EnfID ;
   private boolean[] T00016_n1EnfID ;
   private long[] T00017_A1EnfID ;
   private boolean[] T00017_n1EnfID ;
   private long[] T00012_A1EnfID ;
   private boolean[] T00012_n1EnfID ;
   private String[] T00012_A2EnfNombre ;
   private boolean[] T00012_n2EnfNombre ;
   private String[] T00012_A3EnfDesc ;
   private boolean[] T00012_n3EnfDesc ;
   private long[] T00019_A1EnfID ;
   private boolean[] T00019_n1EnfID ;
   private long[] T000112_A25ProtID ;
   private long[] T000113_A1EnfID ;
   private boolean[] T000113_n1EnfID ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class enfermedades__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00012", "SELECT EnfID, EnfNombre, EnfDesc FROM Enfermedades WHERE EnfID = ?  FOR UPDATE OF Enfermedades NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00013", "SELECT EnfID, EnfNombre, EnfDesc FROM Enfermedades WHERE EnfID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00014", "SELECT TM1.EnfID, TM1.EnfNombre, TM1.EnfDesc FROM Enfermedades TM1 WHERE TM1.EnfID = ? ORDER BY TM1.EnfID ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00015", "SELECT EnfID FROM Enfermedades WHERE EnfID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00016", "SELECT EnfID FROM Enfermedades WHERE ( EnfID > ?) ORDER BY EnfID  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00017", "SELECT EnfID FROM Enfermedades WHERE ( EnfID < ?) ORDER BY EnfID DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T00018", "SAVEPOINT gxupdate;INSERT INTO Enfermedades(EnfNombre, EnfDesc) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T00019", "SELECT currval('EnfID') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000110", "SAVEPOINT gxupdate;UPDATE Enfermedades SET EnfNombre=?, EnfDesc=?  WHERE EnfID = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000111", "SAVEPOINT gxupdate;DELETE FROM Enfermedades  WHERE EnfID = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000112", "SELECT ProtID FROM Protocolo WHERE EnfID = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000113", "SELECT EnfID FROM Enfermedades ORDER BY EnfID ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 60);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[3], 1024);
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 60);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[3], 1024);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
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

