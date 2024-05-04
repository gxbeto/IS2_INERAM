package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class protocolowc_impl extends GXWebComponent
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
      if ( GXutil.len( sPrefix) == 0 )
      {
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
            Gx_mode = httpContext.GetPar( "Mode") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
            AV24ProtID = GXutil.lval( httpContext.GetPar( "ProtID")) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ProtID), 10, 0));
            setjustcreated();
            componentprepare(new Object[] {sCompPrefix,sSFPrefix,Gx_mode,Long.valueOf(AV24ProtID)});
            componentstart();
            httpContext.ajax_rspStartCmp(sPrefix);
            componentdraw();
            httpContext.ajax_rspEndCmp();
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_9") == 0 )
         {
            A1EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
            n1EnfID = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_9( A1EnfID) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_10") == 0 )
         {
            A23CntdID = GXutil.lval( httpContext.GetPar( "CntdID")) ;
            n23CntdID = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_10( A23CntdID) ;
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
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 18_0_8-180599", (short)(0)) ;
            }
         }
         Form.getMeta().addItem("description", "Editar Contenido", (short)(0)) ;
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
         if ( nDynComponent == 0 )
         {
            httpContext.sendError( 404 );
            GXutil.writeLog("send_http_error_code 404");
            GxWebError = (byte)(1) ;
         }
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
      }
      wbErr = false ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS", true);
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public protocolowc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public protocolowc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( protocolowc_impl.class ));
   }

   public protocolowc_impl( int remoteHandle ,
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

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         userMain( ) ;
         if ( ! isFullAjaxMode( ) && ( nDynComponent == 0 ) )
         {
            draw( ) ;
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
         renderHtmlCloseForm065( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         renderHtmlHeaders( ) ;
      }
      renderHtmlOpenForm( ) ;
      if ( GXutil.len( sPrefix) != 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.protocolowc");
         httpContext.AddJavascriptSource("CKEditor/ckeditor/ckeditor.js", "", false, true);
         httpContext.AddJavascriptSource("CKEditor/CKEditorRender.js", "", false, true);
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
      com.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      com.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
      /* User Defined Control */
      ucProttxt.setProperty("Width", Prottxt_Width);
      ucProttxt.setProperty("Height", Prottxt_Height);
      ucProttxt.setProperty("Attribute", ProtTxt);
      ucProttxt.setProperty("CaptionClass", Prottxt_Captionclass);
      ucProttxt.setProperty("CaptionStyle", Prottxt_Captionstyle);
      ucProttxt.setProperty("CaptionPosition", Prottxt_Captionposition);
      ucProttxt.render(context, "fckeditor", Prottxt_Internalname, sPrefix+"PROTTXTContainer");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
      /* Div Control */
      com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "Button" ;
      StyleString = "" ;
      com.GxWebStd.gx_button_ctrl( httpContext, bttBtn_trn_enter_Internalname, "", "Confirmar", bttBtn_trn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_trn_enter_Visible, bttBtn_trn_enter_Enabled, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Protocolowc.htm");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
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
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            standaloneStartupServer( ) ;
         }
      }
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11062 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      nDoneStart = (byte)(1) ;
      if ( AnyError == 0 )
      {
         sXEvt = httpContext.cgiGet( "_EventName") ;
         if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z25ProtID = localUtil.ctol( httpContext.cgiGet( sPrefix+"Z25ProtID"), ",", ".") ;
            Z26ProtOrd = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z26ProtOrd"), ",", ".")) ;
            n26ProtOrd = ((0==A26ProtOrd) ? true : false) ;
            Z27ProtTxt = httpContext.cgiGet( sPrefix+"Z27ProtTxt") ;
            n27ProtTxt = ((GXutil.strcmp("", A27ProtTxt)==0) ? true : false) ;
            Z1EnfID = localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1EnfID"), ",", ".") ;
            n1EnfID = ((0==A1EnfID) ? true : false) ;
            Z23CntdID = localUtil.ctol( httpContext.cgiGet( sPrefix+"Z23CntdID"), ",", ".") ;
            n23CntdID = ((0==A23CntdID) ? true : false) ;
            wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
            wcpOAV24ProtID = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV24ProtID"), ",", ".") ;
            A26ProtOrd = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z26ProtOrd"), ",", ".")) ;
            n26ProtOrd = false ;
            n26ProtOrd = ((0==A26ProtOrd) ? true : false) ;
            A27ProtTxt = httpContext.cgiGet( sPrefix+"Z27ProtTxt") ;
            n27ProtTxt = false ;
            n27ProtTxt = ((GXutil.strcmp("", A27ProtTxt)==0) ? true : false) ;
            A1EnfID = localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1EnfID"), ",", ".") ;
            n1EnfID = false ;
            n1EnfID = ((0==A1EnfID) ? true : false) ;
            A23CntdID = localUtil.ctol( httpContext.cgiGet( sPrefix+"Z23CntdID"), ",", ".") ;
            n23CntdID = false ;
            n23CntdID = ((0==A23CntdID) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( sPrefix+"Mode") ;
            N1EnfID = localUtil.ctol( httpContext.cgiGet( sPrefix+"N1EnfID"), ",", ".") ;
            n1EnfID = ((0==A1EnfID) ? true : false) ;
            N23CntdID = localUtil.ctol( httpContext.cgiGet( sPrefix+"N23CntdID"), ",", ".") ;
            n23CntdID = ((0==A23CntdID) ? true : false) ;
            AV24ProtID = localUtil.ctol( httpContext.cgiGet( sPrefix+"vPROTID"), ",", ".") ;
            A25ProtID = localUtil.ctol( httpContext.cgiGet( sPrefix+"PROTID"), ",", ".") ;
            AV11Insert_EnfID = localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_ENFID"), ",", ".") ;
            A1EnfID = localUtil.ctol( httpContext.cgiGet( sPrefix+"ENFID"), ",", ".") ;
            n1EnfID = ((0==A1EnfID) ? true : false) ;
            AV12Insert_CntdID = localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_CNTDID"), ",", ".") ;
            A23CntdID = localUtil.ctol( httpContext.cgiGet( sPrefix+"CNTDID"), ",", ".") ;
            n23CntdID = ((0==A23CntdID) ? true : false) ;
            A26ProtOrd = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"PROTORD"), ",", ".")) ;
            n26ProtOrd = ((0==A26ProtOrd) ? true : false) ;
            A27ProtTxt = httpContext.cgiGet( sPrefix+"PROTTXT") ;
            n27ProtTxt = ((GXutil.strcmp("", A27ProtTxt)==0) ? true : false) ;
            A3EnfDesc = httpContext.cgiGet( sPrefix+"ENFDESC") ;
            n3EnfDesc = false ;
            A24CntdDesc = httpContext.cgiGet( sPrefix+"CNTDDESC") ;
            AV25Pgmname = httpContext.cgiGet( sPrefix+"vPGMNAME") ;
            Prottxt_Objectcall = httpContext.cgiGet( sPrefix+"PROTTXT_Objectcall") ;
            Prottxt_Class = httpContext.cgiGet( sPrefix+"PROTTXT_Class") ;
            Prottxt_Enabled = GXutil.strtobool( httpContext.cgiGet( sPrefix+"PROTTXT_Enabled")) ;
            Prottxt_Width = httpContext.cgiGet( sPrefix+"PROTTXT_Width") ;
            Prottxt_Height = httpContext.cgiGet( sPrefix+"PROTTXT_Height") ;
            Prottxt_Skin = httpContext.cgiGet( sPrefix+"PROTTXT_Skin") ;
            Prottxt_Toolbar = httpContext.cgiGet( sPrefix+"PROTTXT_Toolbar") ;
            Prottxt_Customtoolbar = httpContext.cgiGet( sPrefix+"PROTTXT_Customtoolbar") ;
            Prottxt_Customconfiguration = httpContext.cgiGet( sPrefix+"PROTTXT_Customconfiguration") ;
            Prottxt_Toolbarcancollapse = GXutil.strtobool( httpContext.cgiGet( sPrefix+"PROTTXT_Toolbarcancollapse")) ;
            Prottxt_Toolbarexpanded = GXutil.strtobool( httpContext.cgiGet( sPrefix+"PROTTXT_Toolbarexpanded")) ;
            Prottxt_Color = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"PROTTXT_Color"), ",", ".")) ;
            Prottxt_Buttonpressedid = httpContext.cgiGet( sPrefix+"PROTTXT_Buttonpressedid") ;
            Prottxt_Captionvalue = httpContext.cgiGet( sPrefix+"PROTTXT_Captionvalue") ;
            Prottxt_Captionclass = httpContext.cgiGet( sPrefix+"PROTTXT_Captionclass") ;
            Prottxt_Captionstyle = httpContext.cgiGet( sPrefix+"PROTTXT_Captionstyle") ;
            Prottxt_Captionposition = httpContext.cgiGet( sPrefix+"PROTTXT_Captionposition") ;
            Prottxt_Isabstractlayoutcontrol = GXutil.strtobool( httpContext.cgiGet( sPrefix+"PROTTXT_Isabstractlayoutcontrol")) ;
            Prottxt_Coltitle = httpContext.cgiGet( sPrefix+"PROTTXT_Coltitle") ;
            Prottxt_Coltitlefont = httpContext.cgiGet( sPrefix+"PROTTXT_Coltitlefont") ;
            Prottxt_Coltitlecolor = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"PROTTXT_Coltitlecolor"), ",", ".")) ;
            Prottxt_Usercontroliscolumn = GXutil.strtobool( httpContext.cgiGet( sPrefix+"PROTTXT_Usercontroliscolumn")) ;
            Prottxt_Visible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"PROTTXT_Visible")) ;
            /* Read variables values. */
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"Protocolowc");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ProtOrd", localUtil.format( DecimalUtil.doubleToDec(A26ProtOrd), "ZZZ9"));
            hsh = httpContext.cgiGet( sPrefix+"hsh") ;
            if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("protocolowc:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               A25ProtID = GXutil.lval( httpContext.GetPar( "ProtID")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode5 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode5 ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
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
                        confirm_060( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtn_trn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e11062 ();
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              if ( ! isDsp( ) )
                              {
                                 btn_enter( ) ;
                              }
                           }
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll065( ) ;
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
      if ( isDsp( ) || isDlt( ) )
      {
         if ( isDsp( ) )
         {
            bttBtn_trn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_trn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_trn_enter_Visible), 5, 0), true);
         }
         disableAttributes065( ) ;
      }
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_trn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_trn_enter_Visible), 5, 0), true);
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

   public void confirm_060( )
   {
      beforeValidate065( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls065( ) ;
         }
         else
         {
            checkExtendedTable065( ) ;
            closeExtendedTableCursors065( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption060( )
   {
   }

   public void e11062( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0];
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV25Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV26GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         while ( AV26GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV26GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EnfID") == 0 )
            {
               AV11Insert_EnfID = GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11Insert_EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_EnfID), 10, 0));
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CntdID") == 0 )
            {
               AV12Insert_CntdID = GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Insert_CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_CntdID), 10, 0));
            }
            AV26GXV1 = (int)(AV26GXV1+1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         }
      }
   }

   public void zm065( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z26ProtOrd = T00063_A26ProtOrd[0] ;
            Z27ProtTxt = T00063_A27ProtTxt[0] ;
            Z1EnfID = T00063_A1EnfID[0] ;
            Z23CntdID = T00063_A23CntdID[0] ;
         }
         else
         {
            Z26ProtOrd = A26ProtOrd ;
            Z27ProtTxt = A27ProtTxt ;
            Z1EnfID = A1EnfID ;
            Z23CntdID = A23CntdID ;
         }
      }
      if ( GX_JID == -8 )
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
      AV25Pgmname = "Protocolowc" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25Pgmname", AV25Pgmname);
      if ( ! (0==AV24ProtID) )
      {
         A25ProtID = AV24ProtID ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CntdID) )
      {
         A23CntdID = AV12Insert_CntdID ;
         n23CntdID = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_EnfID) )
      {
         A1EnfID = AV11Insert_EnfID ;
         n1EnfID = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_trn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_trn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_trn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_trn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_trn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_trn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T00065 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
         A24CntdDesc = T00065_A24CntdDesc[0] ;
         pr_default.close(3);
         /* Using cursor T00064 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
         A3EnfDesc = T00064_A3EnfDesc[0] ;
         n3EnfDesc = T00064_n3EnfDesc[0] ;
         pr_default.close(2);
      }
   }

   public void load065( )
   {
      /* Using cursor T00066 */
      pr_default.execute(4, new Object[] {Long.valueOf(A25ProtID)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A3EnfDesc = T00066_A3EnfDesc[0] ;
         n3EnfDesc = T00066_n3EnfDesc[0] ;
         A24CntdDesc = T00066_A24CntdDesc[0] ;
         A26ProtOrd = T00066_A26ProtOrd[0] ;
         n26ProtOrd = T00066_n26ProtOrd[0] ;
         A27ProtTxt = T00066_A27ProtTxt[0] ;
         n27ProtTxt = T00066_n27ProtTxt[0] ;
         A1EnfID = T00066_A1EnfID[0] ;
         n1EnfID = T00066_n1EnfID[0] ;
         A23CntdID = T00066_A23CntdID[0] ;
         n23CntdID = T00066_n23CntdID[0] ;
         zm065( -8) ;
      }
      pr_default.close(4);
      onLoadActions065( ) ;
   }

   public void onLoadActions065( )
   {
   }

   public void checkExtendedTable065( )
   {
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00064 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A1EnfID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Enfermedades'.", "ForeignKeyNotFound", 1, "ENFID");
            AnyError = (short)(1) ;
         }
      }
      A3EnfDesc = T00064_A3EnfDesc[0] ;
      n3EnfDesc = T00064_n3EnfDesc[0] ;
      pr_default.close(2);
      /* Using cursor T00065 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A23CntdID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Contenidos'.", "ForeignKeyNotFound", 1, "CNTDID");
            AnyError = (short)(1) ;
         }
      }
      A24CntdDesc = T00065_A24CntdDesc[0] ;
      pr_default.close(3);
   }

   public void closeExtendedTableCursors065( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_9( long A1EnfID )
   {
      /* Using cursor T00067 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A1EnfID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Enfermedades'.", "ForeignKeyNotFound", 1, "ENFID");
            AnyError = (short)(1) ;
         }
      }
      A3EnfDesc = T00067_A3EnfDesc[0] ;
      n3EnfDesc = T00067_n3EnfDesc[0] ;
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

   public void gxload_10( long A23CntdID )
   {
      /* Using cursor T00068 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A23CntdID) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Contenidos'.", "ForeignKeyNotFound", 1, "CNTDID");
            AnyError = (short)(1) ;
         }
      }
      A24CntdDesc = T00068_A24CntdDesc[0] ;
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

   public void getKey065( )
   {
      /* Using cursor T00069 */
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
      /* Using cursor T00063 */
      pr_default.execute(1, new Object[] {Long.valueOf(A25ProtID)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm065( 8) ;
         RcdFound5 = (short)(1) ;
         A25ProtID = T00063_A25ProtID[0] ;
         A26ProtOrd = T00063_A26ProtOrd[0] ;
         n26ProtOrd = T00063_n26ProtOrd[0] ;
         A27ProtTxt = T00063_A27ProtTxt[0] ;
         n27ProtTxt = T00063_n27ProtTxt[0] ;
         A1EnfID = T00063_A1EnfID[0] ;
         n1EnfID = T00063_n1EnfID[0] ;
         A23CntdID = T00063_A23CntdID[0] ;
         n23CntdID = T00063_n23CntdID[0] ;
         Z25ProtID = A25ProtID ;
         sMode5 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         load065( ) ;
         if ( AnyError == 1 )
         {
            RcdFound5 = (short)(0) ;
            initializeNonKey065( ) ;
         }
         Gx_mode = sMode5 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound5 = (short)(0) ;
         initializeNonKey065( ) ;
         sMode5 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode5 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey065( ) ;
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
      /* Using cursor T000610 */
      pr_default.execute(8, new Object[] {Long.valueOf(A25ProtID)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000610_A25ProtID[0] < A25ProtID ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000610_A25ProtID[0] > A25ProtID ) ) )
         {
            A25ProtID = T000610_A25ProtID[0] ;
            RcdFound5 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound5 = (short)(0) ;
      /* Using cursor T000611 */
      pr_default.execute(9, new Object[] {Long.valueOf(A25ProtID)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000611_A25ProtID[0] > A25ProtID ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000611_A25ProtID[0] < A25ProtID ) ) )
         {
            A25ProtID = T000611_A25ProtID[0] ;
            RcdFound5 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey065( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert065( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound5 == 1 )
         {
            if ( A25ProtID != Z25ProtID )
            {
               A25ProtID = Z25ProtID ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               /* Update record */
               update065( ) ;
            }
         }
         else
         {
            if ( A25ProtID != Z25ProtID )
            {
               /* Insert record */
               insert065( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                  AnyError = (short)(1) ;
               }
               else
               {
                  /* Insert record */
                  insert065( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( ( AnyError == 0 ) && ( GXutil.len( sPrefix) == 0 ) )
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
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "");
         AnyError = (short)(1) ;
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency065( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00062 */
         pr_default.execute(0, new Object[] {Long.valueOf(A25ProtID)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Protocolo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z26ProtOrd != T00062_A26ProtOrd[0] ) || ( GXutil.strcmp(Z27ProtTxt, T00062_A27ProtTxt[0]) != 0 ) || ( Z1EnfID != T00062_A1EnfID[0] ) || ( Z23CntdID != T00062_A23CntdID[0] ) )
         {
            if ( Z26ProtOrd != T00062_A26ProtOrd[0] )
            {
               GXutil.writeLogln("protocolowc:[seudo value changed for attri]"+"ProtOrd");
               GXutil.writeLogRaw("Old: ",Z26ProtOrd);
               GXutil.writeLogRaw("Current: ",T00062_A26ProtOrd[0]);
            }
            if ( GXutil.strcmp(Z27ProtTxt, T00062_A27ProtTxt[0]) != 0 )
            {
               GXutil.writeLogln("protocolowc:[seudo value changed for attri]"+"ProtTxt");
               GXutil.writeLogRaw("Old: ",Z27ProtTxt);
               GXutil.writeLogRaw("Current: ",T00062_A27ProtTxt[0]);
            }
            if ( Z1EnfID != T00062_A1EnfID[0] )
            {
               GXutil.writeLogln("protocolowc:[seudo value changed for attri]"+"EnfID");
               GXutil.writeLogRaw("Old: ",Z1EnfID);
               GXutil.writeLogRaw("Current: ",T00062_A1EnfID[0]);
            }
            if ( Z23CntdID != T00062_A23CntdID[0] )
            {
               GXutil.writeLogln("protocolowc:[seudo value changed for attri]"+"CntdID");
               GXutil.writeLogRaw("Old: ",Z23CntdID);
               GXutil.writeLogRaw("Current: ",T00062_A23CntdID[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Protocolo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert065( )
   {
      beforeValidate065( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable065( ) ;
      }
      if ( AnyError == 0 )
      {
         zm065( 0) ;
         checkOptimisticConcurrency065( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm065( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert065( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000612 */
                  pr_default.execute(10, new Object[] {Boolean.valueOf(n26ProtOrd), Short.valueOf(A26ProtOrd), Boolean.valueOf(n27ProtTxt), A27ProtTxt, Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID), Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000613 */
                  pr_default.execute(11);
                  A25ProtID = T000613_A25ProtID[0] ;
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
                        resetCaption060( ) ;
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
            load065( ) ;
         }
         endLevel065( ) ;
      }
      closeExtendedTableCursors065( ) ;
   }

   public void update065( )
   {
      beforeValidate065( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable065( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency065( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm065( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate065( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000614 */
                  pr_default.execute(12, new Object[] {Boolean.valueOf(n26ProtOrd), Short.valueOf(A26ProtOrd), Boolean.valueOf(n27ProtTxt), A27ProtTxt, Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID), Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID), Long.valueOf(A25ProtID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Protocolo");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Protocolo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate065( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( ( AnyError == 0 ) && ( GXutil.len( sPrefix) == 0 ) )
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
         endLevel065( ) ;
      }
      closeExtendedTableCursors065( ) ;
   }

   public void deferredUpdate065( )
   {
   }

   public void delete( )
   {
      beforeValidate065( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency065( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls065( ) ;
         afterConfirm065( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete065( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000615 */
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
                        if ( ( AnyError == 0 ) && ( GXutil.len( sPrefix) == 0 ) )
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
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      endLevel065( ) ;
      Gx_mode = sMode5 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls065( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000616 */
         pr_default.execute(14, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID)});
         A3EnfDesc = T000616_A3EnfDesc[0] ;
         n3EnfDesc = T000616_n3EnfDesc[0] ;
         pr_default.close(14);
         /* Using cursor T000617 */
         pr_default.execute(15, new Object[] {Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
         A24CntdDesc = T000617_A24CntdDesc[0] ;
         pr_default.close(15);
      }
   }

   public void endLevel065( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete065( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "protocolowc");
         if ( AnyError == 0 )
         {
            confirmValues060( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "protocolowc");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart065( )
   {
      /* Scan By routine */
      /* Using cursor T000618 */
      pr_default.execute(16);
      RcdFound5 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A25ProtID = T000618_A25ProtID[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext065( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound5 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A25ProtID = T000618_A25ProtID[0] ;
      }
   }

   public void scanEnd065( )
   {
      pr_default.close(16);
   }

   public void afterConfirm065( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert065( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate065( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete065( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete065( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate065( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes065( )
   {
      Prottxt_Enabled = GXutil.toBoolean( 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, Prottxt_Internalname, "Enabled", GXutil.booltostr( Prottxt_Enabled), true);
   }

   public void send_integrity_lvl_hashes065( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues060( )
   {
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
         httpContext.writeValue( "Editar Contenido") ;
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
      httpContext.AddJavascriptSource("CKEditor/ckeditor/ckeditor.js", "", false, true);
      httpContext.AddJavascriptSource("CKEditor/CKEditorRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
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
         bodyStyle = "" ;
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.protocolowc", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV24ProtID,10,0))}, new String[] {"Gx_mode","ProtID"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"Protocolowc");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ProtOrd", localUtil.format( DecimalUtil.doubleToDec(A26ProtOrd), "ZZZ9"));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("protocolowc:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z25ProtID", GXutil.ltrim( localUtil.ntoc( Z25ProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z26ProtOrd", GXutil.ltrim( localUtil.ntoc( Z26ProtOrd, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z27ProtTxt", Z27ProtTxt);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1EnfID", GXutil.ltrim( localUtil.ntoc( Z1EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z23CntdID", GXutil.ltrim( localUtil.ntoc( Z23CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOGx_mode", GXutil.rtrim( wcpOGx_mode));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV24ProtID", GXutil.ltrim( localUtil.ntoc( wcpOAV24ProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Mode", GXutil.rtrim( Gx_mode));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N1EnfID", GXutil.ltrim( localUtil.ntoc( A1EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N23CntdID", GXutil.ltrim( localUtil.ntoc( A23CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODE", GXutil.rtrim( Gx_mode));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPROTID", GXutil.ltrim( localUtil.ntoc( AV24ProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTID", GXutil.ltrim( localUtil.ntoc( A25ProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_ENFID", GXutil.ltrim( localUtil.ntoc( AV11Insert_EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"ENFID", GXutil.ltrim( localUtil.ntoc( A1EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_CNTDID", GXutil.ltrim( localUtil.ntoc( AV12Insert_CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CNTDID", GXutil.ltrim( localUtil.ntoc( A23CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTORD", GXutil.ltrim( localUtil.ntoc( A26ProtOrd, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTTXT", A27ProtTxt);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"ENFDESC", A3EnfDesc);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CNTDDESC", GXutil.rtrim( A24CntdDesc));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV25Pgmname));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTTXT_Objectcall", GXutil.rtrim( Prottxt_Objectcall));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTTXT_Enabled", GXutil.booltostr( Prottxt_Enabled));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTTXT_Width", GXutil.rtrim( Prottxt_Width));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTTXT_Height", GXutil.rtrim( Prottxt_Height));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTTXT_Captionclass", GXutil.rtrim( Prottxt_Captionclass));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTTXT_Captionstyle", GXutil.rtrim( Prottxt_Captionstyle));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROTTXT_Captionposition", GXutil.rtrim( Prottxt_Captionposition));
   }

   public void renderHtmlCloseForm065( )
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
      return "Protocolowc" ;
   }

   public String getPgmdesc( )
   {
      return "Editar Contenido" ;
   }

   public void initializeNonKey065( )
   {
      A1EnfID = 0 ;
      n1EnfID = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EnfID), 10, 0));
      A23CntdID = 0 ;
      n23CntdID = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A23CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23CntdID), 10, 0));
      A3EnfDesc = "" ;
      n3EnfDesc = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3EnfDesc", A3EnfDesc);
      A24CntdDesc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A24CntdDesc", A24CntdDesc);
      A26ProtOrd = (short)(0) ;
      n26ProtOrd = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ProtOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26ProtOrd), 4, 0));
      A27ProtTxt = "" ;
      n27ProtTxt = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A27ProtTxt", A27ProtTxt);
      Z26ProtOrd = (short)(0) ;
      Z27ProtTxt = "" ;
      Z1EnfID = 0 ;
      Z23CntdID = 0 ;
   }

   public void initAll065( )
   {
      A25ProtID = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25ProtID), 10, 0));
      initializeNonKey065( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlGx_mode = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV24ProtID = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      if ( GXutil.len( sPrefix) != 0 )
      {
         initialize_properties( ) ;
      }
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      if ( nDoneStart == 0 )
      {
      }
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "protocolowc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initenv( ) ;
         inittrn( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         Gx_mode = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         AV24ProtID = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ProtID), 10, 0));
      }
      wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
      wcpOAV24ProtID = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV24ProtID"), ",", ".") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(Gx_mode, wcpOGx_mode) != 0 ) || ( AV24ProtID != wcpOAV24ProtID ) ) )
      {
         setjustcreated();
      }
      wcpOGx_mode = Gx_mode ;
      wcpOAV24ProtID = AV24ProtID ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlGx_mode = httpContext.cgiGet( sPrefix+"Gx_mode_CTRL") ;
      if ( GXutil.len( sCtrlGx_mode) > 0 )
      {
         Gx_mode = httpContext.cgiGet( sCtrlGx_mode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = httpContext.cgiGet( sPrefix+"Gx_mode_PARM") ;
      }
      sCtrlAV24ProtID = httpContext.cgiGet( sPrefix+"AV24ProtID_CTRL") ;
      if ( GXutil.len( sCtrlAV24ProtID) > 0 )
      {
         AV24ProtID = localUtil.ctol( httpContext.cgiGet( sCtrlAV24ProtID), ",", ".") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ProtID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ProtID), 10, 0));
      }
      else
      {
         AV24ProtID = localUtil.ctol( httpContext.cgiGet( sPrefix+"AV24ProtID_PARM"), ",", ".") ;
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
      initenv( ) ;
      inittrn( ) ;
      nDraw = (byte)(0) ;
      sEvt = sCompEvt ;
      if ( isFullAjaxMode( ) )
      {
         userMain( ) ;
      }
      else
      {
         wcparametersget( ) ;
      }
      process( ) ;
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
      userMain( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gx_mode_PARM", GXutil.rtrim( Gx_mode));
      if ( GXutil.len( GXutil.rtrim( sCtrlGx_mode)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gx_mode_CTRL", GXutil.rtrim( sCtrlGx_mode));
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV24ProtID_PARM", GXutil.ltrim( localUtil.ntoc( AV24ProtID, (byte)(10), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV24ProtID)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV24ProtID_CTRL", GXutil.rtrim( sCtrlAV24ProtID));
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
      draw( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617164096", true, true);
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
      httpContext.AddJavascriptSource("protocolowc.js", "?202442617164097", false, true);
      httpContext.AddJavascriptSource("CKEditor/ckeditor/ckeditor.js", "", false, true);
      httpContext.AddJavascriptSource("CKEditor/CKEditorRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      Prottxt_Internalname = sPrefix+"PROTTXT" ;
      bttBtn_trn_enter_Internalname = sPrefix+"BTN_TRN_ENTER" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
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
      bttBtn_trn_enter_Enabled = 1 ;
      bttBtn_trn_enter_Visible = 1 ;
      Prottxt_Captionposition = "None" ;
      Prottxt_Captionstyle = "" ;
      Prottxt_Captionclass = "col-sm-3 AttributeLabel" ;
      Prottxt_Height = "100%" ;
      Prottxt_Width = "100%" ;
      Prottxt_Enabled = GXutil.toBoolean( 1) ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
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
      setEventMetadata("ENTER","{handler:'componentprocess',iparms:[{postForm:true},{sPrefix:true},{sSFPrefix:true},{sCompEvt:true},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV24ProtID',fld:'vPROTID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A26ProtOrd',fld:'PROTORD',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sXEvt = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucProttxt = new com.genexus.webpanels.GXUserControl();
      ProtTxt = "" ;
      TempTags = "" ;
      bttBtn_trn_enter_Jsonclick = "" ;
      A27ProtTxt = "" ;
      A3EnfDesc = "" ;
      A24CntdDesc = "" ;
      AV25Pgmname = "" ;
      Prottxt_Objectcall = "" ;
      Prottxt_Class = "" ;
      Prottxt_Skin = "" ;
      Prottxt_Toolbar = "" ;
      Prottxt_Customtoolbar = "" ;
      Prottxt_Customconfiguration = "" ;
      Prottxt_Buttonpressedid = "" ;
      Prottxt_Captionvalue = "" ;
      Prottxt_Coltitle = "" ;
      Prottxt_Coltitlefont = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode5 = "" ;
      GX_FocusControl = "" ;
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
      AV13TrnContextAtt = new com.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z3EnfDesc = "" ;
      Z24CntdDesc = "" ;
      T00065_A24CntdDesc = new String[] {""} ;
      T00064_A3EnfDesc = new String[] {""} ;
      T00064_n3EnfDesc = new boolean[] {false} ;
      T00066_A25ProtID = new long[1] ;
      T00066_A3EnfDesc = new String[] {""} ;
      T00066_n3EnfDesc = new boolean[] {false} ;
      T00066_A24CntdDesc = new String[] {""} ;
      T00066_A26ProtOrd = new short[1] ;
      T00066_n26ProtOrd = new boolean[] {false} ;
      T00066_A27ProtTxt = new String[] {""} ;
      T00066_n27ProtTxt = new boolean[] {false} ;
      T00066_A1EnfID = new long[1] ;
      T00066_n1EnfID = new boolean[] {false} ;
      T00066_A23CntdID = new long[1] ;
      T00066_n23CntdID = new boolean[] {false} ;
      T00067_A3EnfDesc = new String[] {""} ;
      T00067_n3EnfDesc = new boolean[] {false} ;
      T00068_A24CntdDesc = new String[] {""} ;
      T00069_A25ProtID = new long[1] ;
      T00063_A25ProtID = new long[1] ;
      T00063_A26ProtOrd = new short[1] ;
      T00063_n26ProtOrd = new boolean[] {false} ;
      T00063_A27ProtTxt = new String[] {""} ;
      T00063_n27ProtTxt = new boolean[] {false} ;
      T00063_A1EnfID = new long[1] ;
      T00063_n1EnfID = new boolean[] {false} ;
      T00063_A23CntdID = new long[1] ;
      T00063_n23CntdID = new boolean[] {false} ;
      T000610_A25ProtID = new long[1] ;
      T000611_A25ProtID = new long[1] ;
      T00062_A25ProtID = new long[1] ;
      T00062_A26ProtOrd = new short[1] ;
      T00062_n26ProtOrd = new boolean[] {false} ;
      T00062_A27ProtTxt = new String[] {""} ;
      T00062_n27ProtTxt = new boolean[] {false} ;
      T00062_A1EnfID = new long[1] ;
      T00062_n1EnfID = new boolean[] {false} ;
      T00062_A23CntdID = new long[1] ;
      T00062_n23CntdID = new boolean[] {false} ;
      T000613_A25ProtID = new long[1] ;
      T000616_A3EnfDesc = new String[] {""} ;
      T000616_n3EnfDesc = new boolean[] {false} ;
      T000617_A24CntdDesc = new String[] {""} ;
      T000618_A25ProtID = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      sCtrlGx_mode = "" ;
      sCtrlAV24ProtID = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.protocolowc__default(),
         new Object[] {
             new Object[] {
            T00062_A25ProtID, T00062_A26ProtOrd, T00062_n26ProtOrd, T00062_A27ProtTxt, T00062_n27ProtTxt, T00062_A1EnfID, T00062_n1EnfID, T00062_A23CntdID, T00062_n23CntdID
            }
            , new Object[] {
            T00063_A25ProtID, T00063_A26ProtOrd, T00063_n26ProtOrd, T00063_A27ProtTxt, T00063_n27ProtTxt, T00063_A1EnfID, T00063_n1EnfID, T00063_A23CntdID, T00063_n23CntdID
            }
            , new Object[] {
            T00064_A3EnfDesc, T00064_n3EnfDesc
            }
            , new Object[] {
            T00065_A24CntdDesc
            }
            , new Object[] {
            T00066_A25ProtID, T00066_A3EnfDesc, T00066_n3EnfDesc, T00066_A24CntdDesc, T00066_A26ProtOrd, T00066_n26ProtOrd, T00066_A27ProtTxt, T00066_n27ProtTxt, T00066_A1EnfID, T00066_n1EnfID,
            T00066_A23CntdID, T00066_n23CntdID
            }
            , new Object[] {
            T00067_A3EnfDesc, T00067_n3EnfDesc
            }
            , new Object[] {
            T00068_A24CntdDesc
            }
            , new Object[] {
            T00069_A25ProtID
            }
            , new Object[] {
            T000610_A25ProtID
            }
            , new Object[] {
            T000611_A25ProtID
            }
            , new Object[] {
            }
            , new Object[] {
            T000613_A25ProtID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000616_A3EnfDesc, T000616_n3EnfDesc
            }
            , new Object[] {
            T000617_A24CntdDesc
            }
            , new Object[] {
            T000618_A25ProtID
            }
         }
      );
      AV25Pgmname = "Protocolowc" ;
   }

   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nKeyPressed ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte Gx_BScreen ;
   private short Z26ProtOrd ;
   private short gxcookieaux ;
   private short AnyError ;
   private short IsModified ;
   private short IsConfirmed ;
   private short A26ProtOrd ;
   private short RcdFound5 ;
   private int trnEnded ;
   private int bttBtn_trn_enter_Visible ;
   private int bttBtn_trn_enter_Enabled ;
   private int Prottxt_Color ;
   private int Prottxt_Coltitlecolor ;
   private int AV26GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV24ProtID ;
   private long Z25ProtID ;
   private long Z1EnfID ;
   private long Z23CntdID ;
   private long N1EnfID ;
   private long N23CntdID ;
   private long AV24ProtID ;
   private long A1EnfID ;
   private long A23CntdID ;
   private long A25ProtID ;
   private long AV11Insert_EnfID ;
   private long AV12Insert_CntdID ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String sXEvt ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablecontent_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String Prottxt_Width ;
   private String Prottxt_Height ;
   private String Prottxt_Captionclass ;
   private String Prottxt_Captionstyle ;
   private String Prottxt_Captionposition ;
   private String Prottxt_Internalname ;
   private String TempTags ;
   private String bttBtn_trn_enter_Internalname ;
   private String bttBtn_trn_enter_Jsonclick ;
   private String A24CntdDesc ;
   private String AV25Pgmname ;
   private String Prottxt_Objectcall ;
   private String Prottxt_Class ;
   private String Prottxt_Skin ;
   private String Prottxt_Toolbar ;
   private String Prottxt_Customtoolbar ;
   private String Prottxt_Customconfiguration ;
   private String Prottxt_Buttonpressedid ;
   private String Prottxt_Captionvalue ;
   private String Prottxt_Coltitle ;
   private String Prottxt_Coltitlefont ;
   private String hsh ;
   private String sMode5 ;
   private String GX_FocusControl ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z24CntdDesc ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String sCtrlGx_mode ;
   private String sCtrlAV24ProtID ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1EnfID ;
   private boolean n23CntdID ;
   private boolean wbErr ;
   private boolean n26ProtOrd ;
   private boolean n27ProtTxt ;
   private boolean n3EnfDesc ;
   private boolean Prottxt_Enabled ;
   private boolean Prottxt_Toolbarcancollapse ;
   private boolean Prottxt_Toolbarexpanded ;
   private boolean Prottxt_Isabstractlayoutcontrol ;
   private boolean Prottxt_Usercontroliscolumn ;
   private boolean Prottxt_Visible ;
   private boolean returnInSub ;
   private String Z27ProtTxt ;
   private String ProtTxt ;
   private String A27ProtTxt ;
   private String A3EnfDesc ;
   private String Z3EnfDesc ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucProttxt ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00065_A24CntdDesc ;
   private String[] T00064_A3EnfDesc ;
   private boolean[] T00064_n3EnfDesc ;
   private long[] T00066_A25ProtID ;
   private String[] T00066_A3EnfDesc ;
   private boolean[] T00066_n3EnfDesc ;
   private String[] T00066_A24CntdDesc ;
   private short[] T00066_A26ProtOrd ;
   private boolean[] T00066_n26ProtOrd ;
   private String[] T00066_A27ProtTxt ;
   private boolean[] T00066_n27ProtTxt ;
   private long[] T00066_A1EnfID ;
   private boolean[] T00066_n1EnfID ;
   private long[] T00066_A23CntdID ;
   private boolean[] T00066_n23CntdID ;
   private String[] T00067_A3EnfDesc ;
   private boolean[] T00067_n3EnfDesc ;
   private String[] T00068_A24CntdDesc ;
   private long[] T00069_A25ProtID ;
   private long[] T00063_A25ProtID ;
   private short[] T00063_A26ProtOrd ;
   private boolean[] T00063_n26ProtOrd ;
   private String[] T00063_A27ProtTxt ;
   private boolean[] T00063_n27ProtTxt ;
   private long[] T00063_A1EnfID ;
   private boolean[] T00063_n1EnfID ;
   private long[] T00063_A23CntdID ;
   private boolean[] T00063_n23CntdID ;
   private long[] T000610_A25ProtID ;
   private long[] T000611_A25ProtID ;
   private long[] T00062_A25ProtID ;
   private short[] T00062_A26ProtOrd ;
   private boolean[] T00062_n26ProtOrd ;
   private String[] T00062_A27ProtTxt ;
   private boolean[] T00062_n27ProtTxt ;
   private long[] T00062_A1EnfID ;
   private boolean[] T00062_n1EnfID ;
   private long[] T00062_A23CntdID ;
   private boolean[] T00062_n23CntdID ;
   private long[] T000613_A25ProtID ;
   private String[] T000616_A3EnfDesc ;
   private boolean[] T000616_n3EnfDesc ;
   private String[] T000617_A24CntdDesc ;
   private long[] T000618_A25ProtID ;
   private com.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class protocolowc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00062", "SELECT ProtID, ProtOrd, ProtTxt, EnfID, CntdID FROM Protocolo WHERE ProtID = ?  FOR UPDATE OF Protocolo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00063", "SELECT ProtID, ProtOrd, ProtTxt, EnfID, CntdID FROM Protocolo WHERE ProtID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00064", "SELECT EnfDesc FROM Enfermedades WHERE EnfID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00065", "SELECT CntdDesc FROM Contenidos WHERE CntdID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00066", "SELECT TM1.ProtID, T2.EnfDesc, T3.CntdDesc, TM1.ProtOrd, TM1.ProtTxt, TM1.EnfID, TM1.CntdID FROM ((Protocolo TM1 LEFT JOIN Enfermedades T2 ON T2.EnfID = TM1.EnfID) LEFT JOIN Contenidos T3 ON T3.CntdID = TM1.CntdID) WHERE TM1.ProtID = ? ORDER BY TM1.ProtID ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00067", "SELECT EnfDesc FROM Enfermedades WHERE EnfID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00068", "SELECT CntdDesc FROM Contenidos WHERE CntdID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00069", "SELECT ProtID FROM Protocolo WHERE ProtID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000610", "SELECT ProtID FROM Protocolo WHERE ( ProtID > ?) ORDER BY ProtID  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000611", "SELECT ProtID FROM Protocolo WHERE ( ProtID < ?) ORDER BY ProtID DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000612", "SAVEPOINT gxupdate;INSERT INTO Protocolo(ProtOrd, ProtTxt, EnfID, CntdID) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000613", "SELECT currval('ProtID') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000614", "SAVEPOINT gxupdate;UPDATE Protocolo SET ProtOrd=?, ProtTxt=?, EnfID=?, CntdID=?  WHERE ProtID = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000615", "SAVEPOINT gxupdate;DELETE FROM Protocolo  WHERE ProtID = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000616", "SELECT EnfDesc FROM Enfermedades WHERE EnfID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000617", "SELECT CntdDesc FROM Contenidos WHERE CntdID = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000618", "SELECT ProtID FROM Protocolo ORDER BY ProtID ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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

