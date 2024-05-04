package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class login_impl extends GXDataArea
{
   public login_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public login_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( login_impl.class ));
   }

   public login_impl( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      nGotPars = 1 ;
      webExecute();
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
         gxfirstwebparm = httpContext.GetNextPar( ) ;
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
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetNextPar( ) ;
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
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.wwpbaseobjects.workwithplusmasterpageempty");
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
      pa1B2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1B2( ) ;
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
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal FormBackgroundImage\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormBackgroundImage\" data-gx-class=\"form-horizontal FormBackgroundImage\" novalidate action=\""+formatLink("com.wwpbaseobjects.login", new String[] {}, new String[] {}) +"\">") ;
      com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormBackgroundImage", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_Enablefixobjectfitcover", GXutil.booltostr( Wwputilities_Enablefixobjectfitcover));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_Enableconvertcombotobootstrapselect", GXutil.booltostr( Wwputilities_Enableconvertcombotobootstrapselect));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_Allowcolumnresizing", GXutil.booltostr( Wwputilities_Allowcolumnresizing));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_Allowcolumnreordering", GXutil.booltostr( Wwputilities_Allowcolumnreordering));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_Allowcolumnsrestore", GXutil.booltostr( Wwputilities_Allowcolumnsrestore));
      com.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_Comboloadtype", GXutil.rtrim( Wwputilities_Comboloadtype));
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
         com.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormBackgroundImage" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we1B2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1B2( ) ;
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
      return formatLink("com.wwpbaseobjects.login", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.login" ;
   }

   public String getPgmdesc( )
   {
      return "Sample Log In" ;
   }

   public void wb1B0( )
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
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginLoginImageLeft", "Center", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablelogincontent_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingLeft30", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablelogin_Internalname, 1, 0, "px", 0, "px", "TableLoginTransparency", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Static images/pictures */
         ClassString = "Image" + " " + ((GXutil.strcmp(imgLogologin_gximage, "")==0) ? "GX_Image_Logo_Class" : "GX_Image_"+imgLogologin_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "ee49c4f6-1cb0-4b77-b7d6-4299054bdaaf", "", context.getHttpContext().getTheme( )) ;
         com.GxWebStd.gx_bitmap( httpContext, imgLogologin_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects/login.htm");
         com.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "Center", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellLogin CellPaddingLogin CellLoginUserName", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, edtavSecusername_Internalname, "Sec User Name", "col-sm-3 AttributeLoginImageLeftLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavSecusername_Internalname, AV7SecUserName, GXutil.rtrim( localUtil.format( AV7SecUserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Email", edtavSecusername_Jsonclick, 0, "AttributeLoginImageLeft", "", "", "", "", 1, edtavSecusername_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/login.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellLogin CellPaddingLogin CellLoginPassword", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, edtavSecuserpassword_Internalname, "Sec User Password", "col-sm-3 AttributeLoginImageLeftLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavSecuserpassword_Internalname, AV8SecUserPassword, GXutil.rtrim( localUtil.format( AV8SecUserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Contraseña", edtavSecuserpassword_Jsonclick, 0, "AttributeLoginImageLeft", "", "", "", "", 1, edtavSecuserpassword_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/login.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellLogin CellPaddingLogin", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblForgotpassword_Internalname, "¿Se te olvidó tu contraseña?", "", "", lblForgotpassword_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionLogin", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects/login.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellLogin CellPaddingLogin", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial ButtonLogin" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", "Iniciar sesión", bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/login.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellLogin CellPaddingLogin", "start", "top", "", "", "div");
         wb_table1_35_1B2( true) ;
      }
      else
      {
         wb_table1_35_1B2( false) ;
      }
      return  ;
   }

   public void wb_table1_35_1B2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* User Defined Control */
         ucWwputilities.setProperty("EnableFixObjectFitCover", Wwputilities_Enablefixobjectfitcover);
         ucWwputilities.setProperty("EnableConvertComboToBootstrapSelect", Wwputilities_Enableconvertcombotobootstrapselect);
         ucWwputilities.setProperty("AllowColumnResizing", Wwputilities_Allowcolumnresizing);
         ucWwputilities.setProperty("AllowColumnReordering", Wwputilities_Allowcolumnreordering);
         ucWwputilities.setProperty("AllowColumnsRestore", Wwputilities_Allowcolumnsrestore);
         ucWwputilities.setProperty("ComboLoadType", Wwputilities_Comboloadtype);
         ucWwputilities.render(context, "wwp.workwithplusutilities_fal", Wwputilities_Internalname, "WWPUTILITIESContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      wbLoad = true ;
   }

   public void start1B2( )
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
      Form.getMeta().addItem("description", "Sample Log In", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1B0( ) ;
   }

   public void ws1B2( )
   {
      start1B2( ) ;
      evt1B2( ) ;
   }

   public void evt1B2( )
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e111B2 ();
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
                                 e121B2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e131B2 ();
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
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1B2( )
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

   public void pa1B2( )
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
            GX_FocusControl = edtavSecusername_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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
      rf1B2( ) ;
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

   public void rf1B2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e131B2 ();
         wb1B0( ) ;
      }
   }

   public void send_integrity_lvl_hashes1B2( )
   {
   }

   public void before_start_formulas( )
   {
      fix_multi_value_controls( ) ;
   }

   public void strup1B0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111B2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Wwputilities_Enablefixobjectfitcover = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Enablefixobjectfitcover")) ;
         Wwputilities_Enableconvertcombotobootstrapselect = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Enableconvertcombotobootstrapselect")) ;
         Wwputilities_Allowcolumnresizing = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Allowcolumnresizing")) ;
         Wwputilities_Allowcolumnreordering = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Allowcolumnreordering")) ;
         Wwputilities_Allowcolumnsrestore = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_Allowcolumnsrestore")) ;
         Wwputilities_Comboloadtype = httpContext.cgiGet( "WWPUTILITIES_Comboloadtype") ;
         /* Read variables values. */
         AV7SecUserName = httpContext.cgiGet( edtavSecusername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7SecUserName", AV7SecUserName);
         AV8SecUserPassword = httpContext.cgiGet( edtavSecuserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8SecUserPassword", AV8SecUserPassword);
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
      e111B2 ();
      if (returnInSub) return;
   }

   public void e111B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = "MainContainerNoBackground" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e121B2 ();
      if (returnInSub) return;
   }

   public void e121B2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV5LogInSuccessful = false ;
      if ( AV5LogInSuccessful )
      {
         httpContext.GX_msglist.addItem("Log In Successful!");
      }
      else
      {
         httpContext.GX_msglist.addItem("Incorrect User/Password");
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e131B2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_35_1B2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblUnnamedtable2_Internalname, tblUnnamedtable2_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblNoaccount_Internalname, "¿Aún no tienes cuenta?", "", "", lblNoaccount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/login.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblRegisteruser_Internalname, "Crear una ahora", "", "", lblRegisteruser_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionLogin", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/login.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_35_1B2e( true) ;
      }
      else
      {
         wb_table1_35_1B2e( false) ;
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
      pa1B2( ) ;
      ws1B2( ) ;
      we1B2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/fontawesome_vlatest/css/all.min.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442619203891", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/login.js", "?202442619203891", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgLogologin_Internalname = "LOGOLOGIN" ;
      edtavSecusername_Internalname = "vSECUSERNAME" ;
      edtavSecuserpassword_Internalname = "vSECUSERPASSWORD" ;
      lblForgotpassword_Internalname = "FORGOTPASSWORD" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      lblNoaccount_Internalname = "NOACCOUNT" ;
      lblRegisteruser_Internalname = "REGISTERUSER" ;
      tblUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divTablelogin_Internalname = "TABLELOGIN" ;
      divTablelogincontent_Internalname = "TABLELOGINCONTENT" ;
      Wwputilities_Internalname = "WWPUTILITIES" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      edtavSecuserpassword_Jsonclick = "" ;
      edtavSecuserpassword_Enabled = 1 ;
      edtavSecusername_Jsonclick = "" ;
      edtavSecusername_Enabled = 1 ;
      divLayoutmaintable_Class = "Table" ;
      Wwputilities_Comboloadtype = "InfiniteScrolling" ;
      Wwputilities_Allowcolumnsrestore = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnreordering = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnresizing = GXutil.toBoolean( -1) ;
      Wwputilities_Enableconvertcombotobootstrapselect = GXutil.toBoolean( -1) ;
      Wwputilities_Enablefixobjectfitcover = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Sample Log In" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e121B2',iparms:[]");
      setEventMetadata("ENTER",",oparms:[]}");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      imgLogologin_gximage = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      AV7SecUserName = "" ;
      AV8SecUserPassword = "" ;
      lblForgotpassword_Jsonclick = "" ;
      bttBtnenter_Jsonclick = "" ;
      ucWwputilities = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      sStyleString = "" ;
      lblNoaccount_Jsonclick = "" ;
      lblRegisteruser_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int edtavSecusername_Enabled ;
   private int edtavSecuserpassword_Enabled ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Wwputilities_Comboloadtype ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTablelogincontent_Internalname ;
   private String divTablelogin_Internalname ;
   private String ClassString ;
   private String imgLogologin_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgLogologin_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String edtavSecusername_Internalname ;
   private String TempTags ;
   private String edtavSecusername_Jsonclick ;
   private String edtavSecuserpassword_Internalname ;
   private String edtavSecuserpassword_Jsonclick ;
   private String lblForgotpassword_Internalname ;
   private String lblForgotpassword_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String Wwputilities_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String sStyleString ;
   private String tblUnnamedtable2_Internalname ;
   private String lblNoaccount_Internalname ;
   private String lblNoaccount_Jsonclick ;
   private String lblRegisteruser_Internalname ;
   private String lblRegisteruser_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Wwputilities_Enablefixobjectfitcover ;
   private boolean Wwputilities_Enableconvertcombotobootstrapselect ;
   private boolean Wwputilities_Allowcolumnresizing ;
   private boolean Wwputilities_Allowcolumnreordering ;
   private boolean Wwputilities_Allowcolumnsrestore ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV5LogInSuccessful ;
   private String AV7SecUserName ;
   private String AV8SecUserPassword ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucWwputilities ;
   private com.genexus.webpanels.GXWebForm Form ;
}

