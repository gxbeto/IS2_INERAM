package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_masterpageruntimesettings_impl extends GXWebComponent
{
   public wwp_masterpageruntimesettings_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_masterpageruntimesettings_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_masterpageruntimesettings_impl.class ));
   }

   public wwp_masterpageruntimesettings_impl( int remoteHandle ,
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
      radavBackstyle = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
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
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Fscolor") == 0 )
            {
               gxnrfscolor_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Fscolor") == 0 )
            {
               gxgrfscolor_refresh_invoke( ) ;
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
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void gxnrfscolor_newrow_invoke( )
   {
      nRC_GXsfl_12 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_12"))) ;
      nGXsfl_12_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_12_idx"))) ;
      sGXsfl_12_idx = httpContext.GetPar( "sGXsfl_12_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      edtavColorname_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavColorname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavColorname_Visible), 5, 0), !bGXsfl_12_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrfscolor_newrow( ) ;
      /* End function gxnrFscolor_newrow_invoke */
   }

   public void gxgrfscolor_refresh_invoke( )
   {
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV5WWP_DesignSystemSettings);
      edtavColorname_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavColorname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavColorname_Visible), 5, 0), !bGXsfl_12_Refreshing);
      AV8ColorItemClass = httpContext.GetPar( "ColorItemClass") ;
      AV10ColorName = httpContext.GetPar( "ColorName") ;
      AV6BackStyle = httpContext.GetPar( "BackStyle") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfscolor_refresh( AV5WWP_DesignSystemSettings, AV8ColorItemClass, AV10ColorName, AV6BackStyle, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFscolor_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa0W2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
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
         httpContext.writeValue( "WWP_Master Page Runtime Settings") ;
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
         httpContext.writeText( "<body ") ;
         if ( GXutil.strcmp(httpContext.getLanguageProperty( "rtl"), "true") == 0 )
         {
            httpContext.writeText( " dir=\"rtl\" ") ;
         }
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.wwp_masterpageruntimesettings", new String[] {}, new String[] {}) +"\">") ;
            com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
            com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
            com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
            httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
         }
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
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCOLORITEMCLASS", AV8ColorItemClass);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCOLORITEMCLASS", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV8ColorItemClass, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_12", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_12, (byte)(8), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCOLORITEMCLASS", AV8ColorItemClass);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCOLORITEMCLASS", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV8ColorItemClass, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWWP_DESIGNSYSTEMSETTINGS", AV5WWP_DesignSystemSettings);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWWP_DESIGNSYSTEMSETTINGS", AV5WWP_DesignSystemSettings);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFONTSIZESELECTED", AV11FontSizeSelected);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"subFscolor_Recordcount", GXutil.ltrim( localUtil.ntoc( subFscolor_Recordcount, (byte)(5), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCOLORNAME_Visible", GXutil.ltrim( localUtil.ntoc( edtavColorname_Visible, (byte)(5), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm0W2( )
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
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "</form>") ;
         }
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
      return "WWPBaseObjects.WWP_MasterPageRuntimeSettings" ;
   }

   public String getPgmdesc( )
   {
      return "WWP_Master Page Runtime Settings" ;
   }

   public void wb0W0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.wwpbaseobjects.wwp_masterpageruntimesettings");
         }
         com.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "start", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainDesignerSelector", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblColortxt_Internalname, "Color", "", "", lblColortxt_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "RuntimeDesignSettingsTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_MasterPageRuntimeSettings.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingRight45", "start", "top", "", "", "div");
         /*  Grid Control  */
         FscolorContainer.SetIsFreestyle(true);
         FscolorContainer.SetWrapped(nGXWrapped);
         startgridcontrol12( ) ;
      }
      if ( wbEnd == 12 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_12 = (int)(nGXsfl_12_idx-1) ;
         if ( FscolorContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"FscolorContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Fscolor", FscolorContainer, subFscolor_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FscolorContainerData", FscolorContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FscolorContainerData"+"V", FscolorContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"FscolorContainerData"+"V"+"\" value='"+FscolorContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblBackstyletxt_Internalname, "Estilo de Fondo", "", "", lblBackstyletxt_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "RuntimeDesignSettingsTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_MasterPageRuntimeSettings.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+radavBackstyle.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "start", "top", "", "", "div");
         /* Radio button */
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'" + sPrefix + "',false,'" + sGXsfl_12_idx + "',0)\"" ;
         com.GxWebStd.gx_radio_ctrl( httpContext, radavBackstyle, radavBackstyle.getInternalname(), GXutil.rtrim( AV6BackStyle), "", 1, 1, 0, 0, StyleString, ClassString, "", "", 0, radavBackstyle.getJsonclick(), "'"+sPrefix+"'"+",false,"+"'"+""+"'", TempTags+" onclick="+"\""+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "HLP_WWPBaseObjects/WWP_MasterPageRuntimeSettings.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblFontsizetxt_Internalname, "Tamaño de Fuente", "", "", lblFontsizetxt_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "RuntimeDesignSettingsTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_MasterPageRuntimeSettings.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "Flex", "start", "top", " "+"data-gx-flex"+" ", "justify-content:space-around;", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "start", "top", "", "align-self:center;", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblFontsizesmall_Internalname, "A", "", "", lblFontsizesmall_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EFONTSIZESMALL.CLICK."+"'", "", lblFontsizesmall_Class, 5, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_MasterPageRuntimeSettings.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "start", "top", "", "align-self:center;", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblFontsizemedium_Internalname, "A", "", "", lblFontsizemedium_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EFONTSIZEMEDIUM.CLICK."+"'", "", lblFontsizemedium_Class, 5, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_MasterPageRuntimeSettings.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divFontsizelargecell_Internalname, 1, 0, "px", 0, "px", "", "start", "top", "", "align-self:center;", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblFontsizelarge_Internalname, "A", "", "", lblFontsizelarge_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EFONTSIZELARGE.CLICK."+"'", "", lblFontsizelarge_Class, 5, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/WWP_MasterPageRuntimeSettings.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 12 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( FscolorContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"FscolorContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Fscolor", FscolorContainer, subFscolor_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FscolorContainerData", FscolorContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FscolorContainerData"+"V", FscolorContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"FscolorContainerData"+"V"+"\" value='"+FscolorContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start0W2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 18_0_8-180599", (short)(0)) ;
            }
         }
         Form.getMeta().addItem("description", "WWP_Master Page Runtime Settings", (short)(0)) ;
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
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup0W0( ) ;
         }
      }
   }

   public void ws0W2( )
   {
      start0W2( ) ;
      evt0W2( ) ;
   }

   public void evt0W2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
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
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0W0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "FONTSIZESMALL.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0W0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e110W2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "FONTSIZEMEDIUM.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0W0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e120W2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "FONTSIZELARGE.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0W0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e130W2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VBACKSTYLE.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0W0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e140W2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "TABLECOLORITEM.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0W0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e150W2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0W0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "FSCOLOR.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "TABLECOLORITEM.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0W0( ) ;
                           }
                           nGXsfl_12_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_122( ) ;
                           AV10ColorName = httpContext.cgiGet( edtavColorname_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Start */
                                       e160W2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "FSCOLOR.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       e170W2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Refresh */
                                       e180W2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "TABLECOLORITEM.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       e150W2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup0W0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                    }
                                 }
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

   public void we0W2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0W2( ) ;
         }
      }
   }

   public void pa0W2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
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
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrfscolor_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_122( ) ;
      while ( nGXsfl_12_idx <= nRC_GXsfl_12 )
      {
         sendrow_122( ) ;
         nGXsfl_12_idx = ((subFscolor_Islastpage==1)&&(nGXsfl_12_idx+1>subfscolor_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
         sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_122( ) ;
      }
      addString( httpContext.getJSONContainerResponse( FscolorContainer)) ;
      /* End function gxnrFscolor_newrow */
   }

   public void gxgrfscolor_refresh( com.wwpbaseobjects.SdtWWP_DesignSystemSettings AV5WWP_DesignSystemSettings ,
                                    String AV8ColorItemClass ,
                                    String AV10ColorName ,
                                    String AV6BackStyle ,
                                    String sPrefix )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      FSCOLOR_nCurrentRecord = 0 ;
      rf0W2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrFscolor_refresh */
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
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6BackStyle", AV6BackStyle);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0W2( ) ;
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

   public void rf0W2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         FscolorContainer.ClearRows();
      }
      wbStart = (short)(12) ;
      /* Execute user event: Refresh */
      e180W2 ();
      nGXsfl_12_idx = 1 ;
      sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_122( ) ;
      bGXsfl_12_Refreshing = true ;
      FscolorContainer.AddObjectProperty("GridName", "Fscolor");
      FscolorContainer.AddObjectProperty("CmpContext", sPrefix);
      FscolorContainer.AddObjectProperty("InMasterPage", "false");
      FscolorContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      FscolorContainer.AddObjectProperty("Class", "FreeStyleGrid");
      FscolorContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      FscolorContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      FscolorContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFscolor_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      FscolorContainer.setPageSize( subfscolor_fnc_recordsperpage( ) );
      if ( subFscolor_Islastpage != 0 )
      {
         FSCOLOR_nFirstRecordOnPage = (long)(subfscolor_fnc_recordcount( )-subfscolor_fnc_recordsperpage( )) ;
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"FSCOLOR_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( FSCOLOR_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("FSCOLOR_nFirstRecordOnPage", FSCOLOR_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_122( ) ;
         e170W2 ();
         wbEnd = (short)(12) ;
         wb0W0( ) ;
      }
      bGXsfl_12_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0W2( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCOLORITEMCLASS", AV8ColorItemClass);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCOLORITEMCLASS", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV8ColorItemClass, ""))));
   }

   public int subfscolor_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subfscolor_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subfscolor_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subfscolor_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      fix_multi_value_controls( ) ;
   }

   public void strup0W0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e160W2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_12 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_12"), ",", ".")) ;
         subFscolor_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"subFscolor_Recordcount"), ",", ".")) ;
         /* Read variables values. */
         AV6BackStyle = httpContext.cgiGet( radavBackstyle.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6BackStyle", AV6BackStyle);
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
      e160W2 ();
      if (returnInSub) return;
   }

   public void e160W2( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavColorname_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavColorname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavColorname_Visible), 5, 0), !bGXsfl_12_Refreshing);
   }

   private void e170W2( )
   {
      /* Fscolor_Load Routine */
      returnInSub = false ;
      AV9ColorItemDefinition = "<div class=\"%1\" style=\"background-color:%2\">" ;
      AV10ColorName = "MediumViolet" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "MediumVioletRed", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "MediumPurple" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "MediumPurple", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Purple" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#7F4494", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Indigo" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "Indigo", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "LightBlue" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#39b3d7", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Blue" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#078bcd", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "SkyBlue" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#4978b0", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Navy" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#004080", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Green" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#5CB85C", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "SeaGreen" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#08A086", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Teal" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "Teal", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Olive" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#004000", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Salmon" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "Salmon", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Red" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#d9534f", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Tomato" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "Tomato", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Maroon" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#950000", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Orange" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#FF8040", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Yellow" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#f0ad4e", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Ecru" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#B75B00", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      AV10ColorName = "Brown" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavColorname_Internalname, AV10ColorName);
      /* Execute user subroutine: 'GETCOLORCLASS' */
      S112 ();
      if (returnInSub) return;
      lblColorsquare_Caption = GXutil.format( AV9ColorItemDefinition, AV8ColorItemClass, "#804000", "", "", "", "", "", "", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(12) ;
      }
      sendrow_122( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
      {
         httpContext.doAjaxLoad(12, FscolorRow);
      }
      /*  Sending Event outputs  */
   }

   public void e180W2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_SdtWWP_DesignSystemSettings1 = AV5WWP_DesignSystemSettings;
      GXv_SdtWWP_DesignSystemSettings2[0] = GXt_SdtWWP_DesignSystemSettings1;
      new com.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings2) ;
      GXt_SdtWWP_DesignSystemSettings1 = GXv_SdtWWP_DesignSystemSettings2[0];
      AV5WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings1;
      AV6BackStyle = AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6BackStyle", AV6BackStyle);
      /* Execute user subroutine: 'UPDATESELECTEDFONT' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
      radavBackstyle.setValue( GXutil.rtrim( AV6BackStyle) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, radavBackstyle.getInternalname(), "Values", radavBackstyle.ToJavascriptSource(), true);
   }

   public void e150W2( )
   {
      /* Tablecoloritem_Click Routine */
      returnInSub = false ;
      GXt_SdtWWP_DesignSystemSettings1 = AV5WWP_DesignSystemSettings;
      GXv_SdtWWP_DesignSystemSettings2[0] = GXt_SdtWWP_DesignSystemSettings1;
      new com.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings2) ;
      GXt_SdtWWP_DesignSystemSettings1 = GXv_SdtWWP_DesignSystemSettings2[0];
      AV5WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings1;
      AV5WWP_DesignSystemSettings.setgxTv_SdtWWP_DesignSystemSettings_Basecolor( AV10ColorName );
      new com.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( "DesignSystemSettings", AV5WWP_DesignSystemSettings.toJSonString(false, true)) ;
      this.executeExternalObjectMethod(sPrefix, false, "gx.core.ds", "setOption", new Object[] {"base-color",AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Basecolor()}, false);
      gxgrfscolor_refresh( AV5WWP_DesignSystemSettings, AV8ColorItemClass, AV10ColorName, AV6BackStyle, sPrefix) ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
      radavBackstyle.setValue( GXutil.rtrim( AV6BackStyle) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, radavBackstyle.getInternalname(), "Values", radavBackstyle.ToJavascriptSource(), true);
   }

   public void e110W2( )
   {
      /* Fontsizesmall_Click Routine */
      returnInSub = false ;
      AV11FontSizeSelected = "Small" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FontSizeSelected", AV11FontSizeSelected);
      /* Execute user subroutine: 'SELECTFONT' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UPDATESELECTEDFONT' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
   }

   public void e120W2( )
   {
      /* Fontsizemedium_Click Routine */
      returnInSub = false ;
      AV11FontSizeSelected = "Medium" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FontSizeSelected", AV11FontSizeSelected);
      /* Execute user subroutine: 'SELECTFONT' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UPDATESELECTEDFONT' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
   }

   public void e130W2( )
   {
      /* Fontsizelarge_Click Routine */
      returnInSub = false ;
      AV11FontSizeSelected = "Large" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FontSizeSelected", AV11FontSizeSelected);
      /* Execute user subroutine: 'SELECTFONT' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UPDATESELECTEDFONT' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
   }

   public void e140W2( )
   {
      /* Backstyle_Controlvaluechanged Routine */
      returnInSub = false ;
      GXt_SdtWWP_DesignSystemSettings1 = AV5WWP_DesignSystemSettings;
      GXv_SdtWWP_DesignSystemSettings2[0] = GXt_SdtWWP_DesignSystemSettings1;
      new com.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings2) ;
      GXt_SdtWWP_DesignSystemSettings1 = GXv_SdtWWP_DesignSystemSettings2[0];
      AV5WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings1;
      AV5WWP_DesignSystemSettings.setgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle( AV6BackStyle );
      this.executeExternalObjectMethod(sPrefix, false, "gx.core.ds", "setOption", new Object[] {"background-color",AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle()}, false);
      AV5WWP_DesignSystemSettings.setgxTv_SdtWWP_DesignSystemSettings_Menucolor( AV6BackStyle );
      this.executeExternalObjectMethod(sPrefix, false, "gx.core.ds", "setOption", new Object[] {"menu-color",AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Menucolor()}, false);
      new com.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( "DesignSystemSettings", AV5WWP_DesignSystemSettings.toJSonString(false, true)) ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
   }

   public void S112( )
   {
      /* 'GETCOLORCLASS' Routine */
      returnInSub = false ;
      AV7ColorItemBaseClass = "RuntimeSettingsColor" ;
      AV8ColorItemClass = ((GXutil.strcmp(AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Basecolor(), AV10ColorName)==0) ? AV7ColorItemBaseClass+"Selected" : AV7ColorItemBaseClass) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8ColorItemClass", AV8ColorItemClass);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCOLORITEMCLASS", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV8ColorItemClass, ""))));
   }

   public void S132( )
   {
      /* 'SELECTFONT' Routine */
      returnInSub = false ;
      GXt_SdtWWP_DesignSystemSettings1 = AV5WWP_DesignSystemSettings;
      GXv_SdtWWP_DesignSystemSettings2[0] = GXt_SdtWWP_DesignSystemSettings1;
      new com.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings2) ;
      GXt_SdtWWP_DesignSystemSettings1 = GXv_SdtWWP_DesignSystemSettings2[0];
      AV5WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings1;
      AV5WWP_DesignSystemSettings.setgxTv_SdtWWP_DesignSystemSettings_Fontsize( AV11FontSizeSelected );
      new com.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( "DesignSystemSettings", AV5WWP_DesignSystemSettings.toJSonString(false, true)) ;
      this.executeExternalObjectMethod(sPrefix, false, "gx.core.ds", "setOption", new Object[] {"font-size",AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Fontsize()}, false);
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
   }

   public void S122( )
   {
      /* 'UPDATESELECTEDFONT' Routine */
      returnInSub = false ;
      AV11FontSizeSelected = AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Fontsize() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FontSizeSelected", AV11FontSizeSelected);
      lblFontsizesmall_Class = "FontSizeSelectorSmall" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizesmall_Internalname, "Class", lblFontsizesmall_Class, true);
      lblFontsizemedium_Class = "FontSizeSelectorMedium" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizemedium_Internalname, "Class", lblFontsizemedium_Class, true);
      lblFontsizelarge_Class = "FontSizeSelectorLarge" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizelarge_Internalname, "Class", lblFontsizelarge_Class, true);
      if ( GXutil.strcmp(AV11FontSizeSelected, "Small") == 0 )
      {
         lblFontsizesmall_Class = lblFontsizesmall_Class+" "+"FontSizeSelectorSelected" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizesmall_Internalname, "Class", lblFontsizesmall_Class, true);
      }
      else if ( GXutil.strcmp(AV11FontSizeSelected, "Medium") == 0 )
      {
         lblFontsizemedium_Class = lblFontsizemedium_Class+" "+"FontSizeSelectorSelected" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizemedium_Internalname, "Class", lblFontsizemedium_Class, true);
      }
      else if ( GXutil.strcmp(AV11FontSizeSelected, "Large") == 0 )
      {
         lblFontsizelarge_Class = lblFontsizelarge_Class+" "+"FontSizeSelectorSelected" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizelarge_Internalname, "Class", lblFontsizelarge_Class, true);
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
      pa0W2( ) ;
      ws0W2( ) ;
      we0W2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0W2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wwp_masterpageruntimesettings", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0W2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
      }
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
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
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa0W2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0W2( ) ;
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
      ws0W2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
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
      we0W2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163318", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("wwpbaseobjects/wwp_masterpageruntimesettings.js", "?202442617163318", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_122( )
   {
      lblColorsquare_Internalname = sPrefix+"COLORSQUARE_"+sGXsfl_12_idx ;
      edtavColorname_Internalname = sPrefix+"vCOLORNAME_"+sGXsfl_12_idx ;
   }

   public void subsflControlProps_fel_122( )
   {
      lblColorsquare_Internalname = sPrefix+"COLORSQUARE_"+sGXsfl_12_fel_idx ;
      edtavColorname_Internalname = sPrefix+"vCOLORNAME_"+sGXsfl_12_fel_idx ;
   }

   public void sendrow_122( )
   {
      subsflControlProps_122( ) ;
      wb0W0( ) ;
      FscolorRow = GXWebRow.GetNew(context,FscolorContainer) ;
      if ( subFscolor_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFscolor_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFscolor_Class, "") != 0 )
         {
            subFscolor_Linesclass = subFscolor_Class+"Odd" ;
         }
      }
      else if ( subFscolor_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFscolor_Backstyle = (byte)(0) ;
         subFscolor_Backcolor = subFscolor_Allbackcolor ;
         if ( GXutil.strcmp(subFscolor_Class, "") != 0 )
         {
            subFscolor_Linesclass = subFscolor_Class+"Uniform" ;
         }
      }
      else if ( subFscolor_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFscolor_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFscolor_Class, "") != 0 )
         {
            subFscolor_Linesclass = subFscolor_Class+"Odd" ;
         }
         subFscolor_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFscolor_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFscolor_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_12_idx) % (2))) == 0 )
         {
            subFscolor_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subFscolor_Class, "") != 0 )
            {
               subFscolor_Linesclass = subFscolor_Class+"Even" ;
            }
         }
         else
         {
            subFscolor_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subFscolor_Class, "") != 0 )
            {
               subFscolor_Linesclass = subFscolor_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subFscolor_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_12_idx+"\">") ;
      }
      /* Table start */
      FscolorRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablefsfscolor_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      FscolorRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      FscolorRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      FscolorRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablecoloritem_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","start","top","","","div"});
      /* Div Control */
      FscolorRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      /* Div Control */
      FscolorRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      /* Text block */
      FscolorRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblColorsquare_Internalname,lblColorsquare_Caption,"","",lblColorsquare_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      FscolorRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FscolorRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      FscolorRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         FscolorContainer.CloseTag("cell");
      }
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         FscolorContainer.CloseTag("row");
      }
      FscolorRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      FscolorRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","Invisible"});
      /* Table start */
      FscolorRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsfscolor_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      FscolorRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      FscolorRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      FscolorRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      FscolorRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavColorname_Internalname,"Color Name","gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      FscolorRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavColorname_Internalname,AV10ColorName,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavColorname_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtavColorname_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      FscolorRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         FscolorContainer.CloseTag("cell");
      }
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         FscolorContainer.CloseTag("row");
      }
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         FscolorContainer.CloseTag("table");
      }
      /* End of table */
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         FscolorContainer.CloseTag("cell");
      }
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         FscolorContainer.CloseTag("row");
      }
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         FscolorContainer.CloseTag("table");
      }
      /* End of table */
      send_integrity_lvl_hashes0W2( ) ;
      /* End of Columns property logic. */
      FscolorContainer.AddRow(FscolorRow);
      nGXsfl_12_idx = ((subFscolor_Islastpage==1)&&(nGXsfl_12_idx+1>subfscolor_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
      sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_122( ) ;
      /* End function sendrow_122 */
   }

   public void startgridcontrol12( )
   {
      if ( FscolorContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"FscolorContainer"+"DivS\" data-gxgridid=\"12\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subFscolor_Internalname, subFscolor_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         FscolorContainer.AddObjectProperty("GridName", "Fscolor");
      }
      else
      {
         FscolorContainer.AddObjectProperty("GridName", "Fscolor");
         FscolorContainer.AddObjectProperty("Header", subFscolor_Header);
         FscolorContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         FscolorContainer.AddObjectProperty("Class", "FreeStyleGrid");
         FscolorContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFscolor_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("CmpContext", sPrefix);
         FscolorContainer.AddObjectProperty("InMasterPage", "false");
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorColumn.AddObjectProperty("Value", lblColorsquare_Caption);
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         FscolorColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV10ColorName));
         FscolorColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavColorname_Visible, (byte)(5), (byte)(0), ".", "")));
         FscolorContainer.AddColumnProperties(FscolorColumn);
         FscolorContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFscolor_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFscolor_Allowselection, (byte)(1), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFscolor_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFscolor_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFscolor_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFscolor_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         FscolorContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFscolor_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblColortxt_Internalname = sPrefix+"COLORTXT" ;
      lblColorsquare_Internalname = sPrefix+"COLORSQUARE" ;
      divTablecoloritem_Internalname = sPrefix+"TABLECOLORITEM" ;
      edtavColorname_Internalname = sPrefix+"vCOLORNAME" ;
      tblUnnamedtablecontentfsfscolor_Internalname = sPrefix+"UNNAMEDTABLECONTENTFSFSCOLOR" ;
      tblUnnamedtablefsfscolor_Internalname = sPrefix+"UNNAMEDTABLEFSFSCOLOR" ;
      lblBackstyletxt_Internalname = sPrefix+"BACKSTYLETXT" ;
      radavBackstyle.setInternalname( sPrefix+"vBACKSTYLE" );
      lblFontsizetxt_Internalname = sPrefix+"FONTSIZETXT" ;
      lblFontsizesmall_Internalname = sPrefix+"FONTSIZESMALL" ;
      lblFontsizemedium_Internalname = sPrefix+"FONTSIZEMEDIUM" ;
      lblFontsizelarge_Internalname = sPrefix+"FONTSIZELARGE" ;
      divFontsizelargecell_Internalname = sPrefix+"FONTSIZELARGECELL" ;
      divUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subFscolor_Internalname = sPrefix+"FSCOLOR" ;
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
      subFscolor_Allowcollapsing = (byte)(0) ;
      lblColorsquare_Caption = " " ;
      edtavColorname_Jsonclick = "" ;
      lblColorsquare_Caption = " " ;
      subFscolor_Class = "FreeStyleGrid" ;
      subFscolor_Backcolorstyle = (byte)(0) ;
      lblFontsizelarge_Class = "FontSizeSelectorLarge" ;
      lblFontsizemedium_Class = "FontSizeSelectorMedium" ;
      lblFontsizesmall_Class = "FontSizeSelectorSmall" ;
      radavBackstyle.setJsonclick( "" );
      edtavColorname_Visible = 1 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      radavBackstyle.setName( "vBACKSTYLE" );
      radavBackstyle.setWebtags( "" );
      radavBackstyle.addItem("Light", "Claro", (short)(0));
      radavBackstyle.addItem("Dark", "Oscuro", (short)(0));
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'FSCOLOR_nFirstRecordOnPage'},{av:'FSCOLOR_nEOF'},{av:'edtavColorname_Visible',ctrl:'vCOLORNAME',prop:'Visible'},{av:'AV10ColorName',fld:'vCOLORNAME',pic:''},{av:'sPrefix'},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'radavBackstyle'},{av:'AV6BackStyle',fld:'vBACKSTYLE',pic:''},{av:'AV8ColorItemClass',fld:'vCOLORITEMCLASS',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'radavBackstyle'},{av:'AV6BackStyle',fld:'vBACKSTYLE',pic:''},{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'lblFontsizesmall_Class',ctrl:'FONTSIZESMALL',prop:'Class'},{av:'lblFontsizemedium_Class',ctrl:'FONTSIZEMEDIUM',prop:'Class'},{av:'lblFontsizelarge_Class',ctrl:'FONTSIZELARGE',prop:'Class'}]}");
      setEventMetadata("FSCOLOR.LOAD","{handler:'e170W2',iparms:[{av:'AV8ColorItemClass',fld:'vCOLORITEMCLASS',pic:'',hsh:true},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'AV10ColorName',fld:'vCOLORNAME',pic:''}]");
      setEventMetadata("FSCOLOR.LOAD",",oparms:[{av:'AV10ColorName',fld:'vCOLORNAME',pic:''},{av:'lblColorsquare_Caption',ctrl:'COLORSQUARE',prop:'Caption'},{av:'AV8ColorItemClass',fld:'vCOLORITEMCLASS',pic:'',hsh:true}]}");
      setEventMetadata("TABLECOLORITEM.CLICK","{handler:'e150W2',iparms:[{av:'FSCOLOR_nFirstRecordOnPage'},{av:'FSCOLOR_nEOF'},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'edtavColorname_Visible',ctrl:'vCOLORNAME',prop:'Visible'},{av:'AV8ColorItemClass',fld:'vCOLORITEMCLASS',pic:'',hsh:true},{av:'AV10ColorName',fld:'vCOLORNAME',pic:''},{av:'radavBackstyle'},{av:'AV6BackStyle',fld:'vBACKSTYLE',pic:''},{av:'sPrefix'}]");
      setEventMetadata("TABLECOLORITEM.CLICK",",oparms:[{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'radavBackstyle'},{av:'AV6BackStyle',fld:'vBACKSTYLE',pic:''},{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'lblFontsizesmall_Class',ctrl:'FONTSIZESMALL',prop:'Class'},{av:'lblFontsizemedium_Class',ctrl:'FONTSIZEMEDIUM',prop:'Class'},{av:'lblFontsizelarge_Class',ctrl:'FONTSIZELARGE',prop:'Class'}]}");
      setEventMetadata("FONTSIZESMALL.CLICK","{handler:'e110W2',iparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''}]");
      setEventMetadata("FONTSIZESMALL.CLICK",",oparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'lblFontsizesmall_Class',ctrl:'FONTSIZESMALL',prop:'Class'},{av:'lblFontsizemedium_Class',ctrl:'FONTSIZEMEDIUM',prop:'Class'},{av:'lblFontsizelarge_Class',ctrl:'FONTSIZELARGE',prop:'Class'}]}");
      setEventMetadata("FONTSIZEMEDIUM.CLICK","{handler:'e120W2',iparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''}]");
      setEventMetadata("FONTSIZEMEDIUM.CLICK",",oparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'lblFontsizesmall_Class',ctrl:'FONTSIZESMALL',prop:'Class'},{av:'lblFontsizemedium_Class',ctrl:'FONTSIZEMEDIUM',prop:'Class'},{av:'lblFontsizelarge_Class',ctrl:'FONTSIZELARGE',prop:'Class'}]}");
      setEventMetadata("FONTSIZELARGE.CLICK","{handler:'e130W2',iparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''}]");
      setEventMetadata("FONTSIZELARGE.CLICK",",oparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'lblFontsizesmall_Class',ctrl:'FONTSIZESMALL',prop:'Class'},{av:'lblFontsizemedium_Class',ctrl:'FONTSIZEMEDIUM',prop:'Class'},{av:'lblFontsizelarge_Class',ctrl:'FONTSIZELARGE',prop:'Class'}]}");
      setEventMetadata("VBACKSTYLE.CONTROLVALUECHANGED","{handler:'e140W2',iparms:[{av:'radavBackstyle'},{av:'AV6BackStyle',fld:'vBACKSTYLE',pic:''}]");
      setEventMetadata("VBACKSTYLE.CONTROLVALUECHANGED",",oparms:[{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Colorname',iparms:[]");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV5WWP_DesignSystemSettings = new com.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      AV8ColorItemClass = "" ;
      AV10ColorName = "" ;
      AV6BackStyle = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV11FontSizeSelected = "" ;
      GX_FocusControl = "" ;
      lblColortxt_Jsonclick = "" ;
      FscolorContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      lblBackstyletxt_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      lblFontsizetxt_Jsonclick = "" ;
      lblFontsizesmall_Jsonclick = "" ;
      lblFontsizemedium_Jsonclick = "" ;
      lblFontsizelarge_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV9ColorItemDefinition = "" ;
      FscolorRow = new com.genexus.webpanels.GXWebRow();
      AV7ColorItemBaseClass = "" ;
      GXt_SdtWWP_DesignSystemSettings1 = new com.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXv_SdtWWP_DesignSystemSettings2 = new com.wwpbaseobjects.SdtWWP_DesignSystemSettings[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subFscolor_Linesclass = "" ;
      lblColorsquare_Jsonclick = "" ;
      ROClassString = "" ;
      subFscolor_Header = "" ;
      FscolorColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nGXWrapped ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subFscolor_Backcolorstyle ;
   private byte FSCOLOR_nEOF ;
   private byte subFscolor_Backstyle ;
   private byte subFscolor_Allowselection ;
   private byte subFscolor_Allowhovering ;
   private byte subFscolor_Allowcollapsing ;
   private byte subFscolor_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int edtavColorname_Visible ;
   private int nRC_GXsfl_12 ;
   private int subFscolor_Recordcount ;
   private int nGXsfl_12_idx=1 ;
   private int subFscolor_Islastpage ;
   private int idxLst ;
   private int subFscolor_Backcolor ;
   private int subFscolor_Allbackcolor ;
   private int subFscolor_Selectedindex ;
   private int subFscolor_Selectioncolor ;
   private int subFscolor_Hoveringcolor ;
   private long FSCOLOR_nCurrentRecord ;
   private long FSCOLOR_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_12_idx="0001" ;
   private String edtavColorname_Internalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String lblColortxt_Internalname ;
   private String lblColortxt_Jsonclick ;
   private String sStyleString ;
   private String subFscolor_Internalname ;
   private String lblBackstyletxt_Internalname ;
   private String lblBackstyletxt_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String lblFontsizetxt_Internalname ;
   private String lblFontsizetxt_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String lblFontsizesmall_Internalname ;
   private String lblFontsizesmall_Jsonclick ;
   private String lblFontsizesmall_Class ;
   private String lblFontsizemedium_Internalname ;
   private String lblFontsizemedium_Jsonclick ;
   private String lblFontsizemedium_Class ;
   private String divFontsizelargecell_Internalname ;
   private String lblFontsizelarge_Internalname ;
   private String lblFontsizelarge_Jsonclick ;
   private String lblFontsizelarge_Class ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String lblColorsquare_Caption ;
   private String lblColorsquare_Internalname ;
   private String sGXsfl_12_fel_idx="0001" ;
   private String subFscolor_Class ;
   private String subFscolor_Linesclass ;
   private String tblUnnamedtablefsfscolor_Internalname ;
   private String divTablecoloritem_Internalname ;
   private String lblColorsquare_Jsonclick ;
   private String tblUnnamedtablecontentfsfscolor_Internalname ;
   private String ROClassString ;
   private String edtavColorname_Jsonclick ;
   private String subFscolor_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_12_Refreshing=false ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String AV8ColorItemClass ;
   private String AV10ColorName ;
   private String AV6BackStyle ;
   private String AV11FontSizeSelected ;
   private String AV9ColorItemDefinition ;
   private String AV7ColorItemBaseClass ;
   private com.genexus.webpanels.GXWebGrid FscolorContainer ;
   private com.genexus.webpanels.GXWebRow FscolorRow ;
   private com.genexus.webpanels.GXWebColumn FscolorColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private HTMLChoice radavBackstyle ;
   private com.wwpbaseobjects.SdtWWP_DesignSystemSettings AV5WWP_DesignSystemSettings ;
   private com.wwpbaseobjects.SdtWWP_DesignSystemSettings GXt_SdtWWP_DesignSystemSettings1 ;
   private com.wwpbaseobjects.SdtWWP_DesignSystemSettings GXv_SdtWWP_DesignSystemSettings2[] ;
}

