package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_wcmodules_impl extends GXWebComponent
{
   public wwp_wcmodules_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_wcmodules_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_wcmodules_impl.class ));
   }

   public wwp_wcmodules_impl( int remoteHandle ,
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
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridhomemodulessdts") == 0 )
            {
               gxnrgridhomemodulessdts_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridhomemodulessdts") == 0 )
            {
               gxgrgridhomemodulessdts_refresh_invoke( ) ;
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

   public void gxnrgridhomemodulessdts_newrow_invoke( )
   {
      nRC_GXsfl_12 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_12"))) ;
      nGXsfl_12_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_12_idx"))) ;
      sGXsfl_12_idx = httpContext.GetPar( "sGXsfl_12_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      edtavOptionlink_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptionlink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Visible), 5, 0), !bGXsfl_12_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridhomemodulessdts_newrow( ) ;
      /* End function gxnrGridhomemodulessdts_newrow_invoke */
   }

   public void gxgrgridhomemodulessdts_refresh_invoke( )
   {
      edtavOptionlink_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptionlink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Visible), 5, 0), !bGXsfl_12_Refreshing);
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV5HomeModulesSDT);
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridhomemodulessdts_refresh( AV5HomeModulesSDT, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridhomemodulessdts_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa092( ) ;
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
         httpContext.writeValue( "WWP_WCModules") ;
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
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.wwp_wcmodules", new String[] {}, new String[] {}) +"\">") ;
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
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vHOMEMODULESSDT", AV5HomeModulesSDT);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vHOMEMODULESSDT", AV5HomeModulesSDT);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHOMEMODULESSDT", getSecureSignedToken( sPrefix, AV5HomeModulesSDT));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_12", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_12, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vHOMEMODULESSDT", AV5HomeModulesSDT);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vHOMEMODULESSDT", AV5HomeModulesSDT);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHOMEMODULESSDT", getSecureSignedToken( sPrefix, AV5HomeModulesSDT));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"subGridhomemodulessdts_Recordcount", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Recordcount, (byte)(5), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDHOMEMODULESSDTS_Class", GXutil.rtrim( subGridhomemodulessdts_Class));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDHOMEMODULESSDTS_Flexwrap", GXutil.rtrim( subGridhomemodulessdts_Flexwrap));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vOPTIONLINK_Visible", GXutil.ltrim( localUtil.ntoc( edtavOptionlink_Visible, (byte)(5), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm092( )
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
         if ( ! ( WebComp_Layoutprogressbarwc == null ) )
         {
            WebComp_Layoutprogressbarwc.componentjscripts();
         }
         if ( ! ( WebComp_Layoutprogresscirclewc == null ) )
         {
            WebComp_Layoutprogresscirclewc.componentjscripts();
         }
         if ( ! ( WebComp_Layoutcustomwcwc == null ) )
         {
            WebComp_Layoutcustomwcwc.componentjscripts();
         }
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
      return "WWPBaseObjects.WWP_WCModules" ;
   }

   public String getPgmdesc( )
   {
      return "WWP_WCModules" ;
   }

   public void wb090( )
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
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.wwpbaseobjects.wwp_wcmodules");
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
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "start", "top", "", "", "div");
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
         /*  Grid Control  */
         GridhomemodulessdtsContainer.SetIsFreestyle(true);
         GridhomemodulessdtsContainer.SetWrapped(nGXWrapped);
         startgridcontrol12( ) ;
      }
      if ( wbEnd == 12 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_12 = (int)(nGXsfl_12_idx-1) ;
         if ( GridhomemodulessdtsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV11GXV1 = nGXsfl_12_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridhomemodulessdtsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridhomemodulessdts", GridhomemodulessdtsContainer, subGridhomemodulessdts_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridhomemodulessdtsContainerData", GridhomemodulessdtsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridhomemodulessdtsContainerData"+"V", GridhomemodulessdtsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridhomemodulessdtsContainerData"+"V"+"\" value='"+GridhomemodulessdtsContainer.GridValuesHidden()+"'/>") ;
            }
         }
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
      }
      if ( wbEnd == 12 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridhomemodulessdtsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV11GXV1 = nGXsfl_12_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"GridhomemodulessdtsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridhomemodulessdts", GridhomemodulessdtsContainer, subGridhomemodulessdts_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridhomemodulessdtsContainerData", GridhomemodulessdtsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridhomemodulessdtsContainerData"+"V", GridhomemodulessdtsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridhomemodulessdtsContainerData"+"V"+"\" value='"+GridhomemodulessdtsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start092( )
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
         Form.getMeta().addItem("description", "WWP_WCModules", (short)(0)) ;
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
            strup090( ) ;
         }
      }
   }

   public void ws092( )
   {
      start092( ) ;
      evt092( ) ;
   }

   public void evt092( )
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
                              strup090( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup090( ) ;
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 24), "GRIDHOMEMODULESSDTS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup090( ) ;
                           }
                           nGXsfl_12_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_122( ) ;
                           AV6OptionLink = httpContext.cgiGet( edtavOptionlink_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavOptionlink_Internalname, AV6OptionLink);
                           AV7OptionTitle = httpContext.cgiGet( edtavOptiontitle_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavOptiontitle_Internalname, AV7OptionTitle);
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
                                       e11092 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDHOMEMODULESSDTS.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       e12092 ();
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
                                    strup090( ) ;
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 33 )
                     {
                        sEvtType = GXutil.left( sEvt, 4) ;
                        sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                        sCmpCtrl = "W0033" + sEvtType ;
                        OldLayoutprogressbarwc = httpContext.cgiGet( sPrefix+sCmpCtrl) ;
                        if ( ( GXutil.len( OldLayoutprogressbarwc) == 0 ) || ( GXutil.strcmp(OldLayoutprogressbarwc, WebComp_GX_Process_Component) != 0 ) )
                        {
                           WebComp_GX_Process = WebFrontendUtils.getWebComponent(getClass(), "com." + OldLayoutprogressbarwc + "_impl", remoteHandle, context);
                           WebComp_GX_Process_Component = OldLayoutprogressbarwc ;
                        }
                        if ( GXutil.len( WebComp_GX_Process_Component) != 0 )
                        {
                           WebComp_GX_Process.componentprocess(sPrefix+"W0033", sEvtType, sEvt);
                        }
                        nGXsfl_12_webc_idx = (int)(GXutil.lval( sEvtType)) ;
                        WebCompHandler = "Layoutprogressbarwc" ;
                        WebComp_GX_Process_Component = OldLayoutprogressbarwc ;
                     }
                     else if ( nCmpId == 38 )
                     {
                        sEvtType = GXutil.left( sEvt, 4) ;
                        sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                        sCmpCtrl = "W0038" + sEvtType ;
                        OldLayoutprogresscirclewc = httpContext.cgiGet( sPrefix+sCmpCtrl) ;
                        if ( ( GXutil.len( OldLayoutprogresscirclewc) == 0 ) || ( GXutil.strcmp(OldLayoutprogresscirclewc, WebComp_GX_Process_Component) != 0 ) )
                        {
                           WebComp_GX_Process = WebFrontendUtils.getWebComponent(getClass(), "com." + OldLayoutprogresscirclewc + "_impl", remoteHandle, context);
                           WebComp_GX_Process_Component = OldLayoutprogresscirclewc ;
                        }
                        if ( GXutil.len( WebComp_GX_Process_Component) != 0 )
                        {
                           WebComp_GX_Process.componentprocess(sPrefix+"W0038", sEvtType, sEvt);
                        }
                        nGXsfl_12_webc_idx = (int)(GXutil.lval( sEvtType)) ;
                        WebCompHandler = "Layoutprogresscirclewc" ;
                        WebComp_GX_Process_Component = OldLayoutprogresscirclewc ;
                     }
                     else if ( nCmpId == 43 )
                     {
                        sEvtType = GXutil.left( sEvt, 4) ;
                        sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                        sCmpCtrl = "W0043" + sEvtType ;
                        OldLayoutcustomwcwc = httpContext.cgiGet( sPrefix+sCmpCtrl) ;
                        if ( ( GXutil.len( OldLayoutcustomwcwc) == 0 ) || ( GXutil.strcmp(OldLayoutcustomwcwc, WebComp_GX_Process_Component) != 0 ) )
                        {
                           WebComp_GX_Process = WebFrontendUtils.getWebComponent(getClass(), "com." + OldLayoutcustomwcwc + "_impl", remoteHandle, context);
                           WebComp_GX_Process_Component = OldLayoutcustomwcwc ;
                        }
                        if ( GXutil.len( WebComp_GX_Process_Component) != 0 )
                        {
                           WebComp_GX_Process.componentprocess(sPrefix+"W0043", sEvtType, sEvt);
                        }
                        nGXsfl_12_webc_idx = (int)(GXutil.lval( sEvtType)) ;
                        WebCompHandler = "Layoutcustomwcwc" ;
                        WebComp_GX_Process_Component = OldLayoutcustomwcwc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we092( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm092( ) ;
         }
      }
   }

   public void pa092( )
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

   public void gxnrgridhomemodulessdts_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_122( ) ;
      while ( nGXsfl_12_idx <= nRC_GXsfl_12 )
      {
         sendrow_122( ) ;
         nGXsfl_12_idx = ((subGridhomemodulessdts_Islastpage==1)&&(nGXsfl_12_idx+1>subgridhomemodulessdts_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
         sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_122( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridhomemodulessdtsContainer)) ;
      /* End function gxnrGridhomemodulessdts_newrow */
   }

   public void gxgrgridhomemodulessdts_refresh( GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> AV5HomeModulesSDT ,
                                                String sPrefix )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDHOMEMODULESSDTS_nCurrentRecord = 0 ;
      rf092( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridhomemodulessdts_refresh */
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
      rf092( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavOptiontitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptiontitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptiontitle_Enabled), 5, 0), !bGXsfl_12_Refreshing);
   }

   public void rf092( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridhomemodulessdtsContainer.ClearRows();
      }
      wbStart = (short)(12) ;
      nGXsfl_12_idx = 1 ;
      sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_122( ) ;
      bGXsfl_12_Refreshing = true ;
      GridhomemodulessdtsContainer.AddObjectProperty("GridName", "Gridhomemodulessdts");
      GridhomemodulessdtsContainer.AddObjectProperty("CmpContext", sPrefix);
      GridhomemodulessdtsContainer.AddObjectProperty("InMasterPage", "false");
      GridhomemodulessdtsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridhomemodulessdtsContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridhomemodulessdtsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridhomemodulessdtsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridhomemodulessdtsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridhomemodulessdtsContainer.setPageSize( subgridhomemodulessdts_fnc_recordsperpage( ) );
      if ( subGridhomemodulessdts_Islastpage != 0 )
      {
         GRIDHOMEMODULESSDTS_nFirstRecordOnPage = (long)(subgridhomemodulessdts_fnc_recordcount( )-subgridhomemodulessdts_fnc_recordsperpage( )) ;
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDHOMEMODULESSDTS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDHOMEMODULESSDTS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("GRIDHOMEMODULESSDTS_nFirstRecordOnPage", GRIDHOMEMODULESSDTS_nFirstRecordOnPage);
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_GX_Process_Component) != 0 )
            {
               WebComp_GX_Process.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Layoutprogressbarwc_Component) != 0 )
            {
               WebComp_Layoutprogressbarwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Layoutprogresscirclewc_Component) != 0 )
            {
               WebComp_Layoutprogresscirclewc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            WebComp_Layoutcustomwcwc.componentstart();
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_122( ) ;
         e12092 ();
         wbEnd = (short)(12) ;
         wb090( ) ;
      }
      bGXsfl_12_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes092( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vHOMEMODULESSDT", AV5HomeModulesSDT);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vHOMEMODULESSDT", AV5HomeModulesSDT);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHOMEMODULESSDT", getSecureSignedToken( sPrefix, AV5HomeModulesSDT));
   }

   public int subgridhomemodulessdts_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridhomemodulessdts_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridhomemodulessdts_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridhomemodulessdts_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      edtavOptiontitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptiontitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptiontitle_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup090( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11092 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_12 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_12"), ",", ".")) ;
         subGridhomemodulessdts_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"subGridhomemodulessdts_Recordcount"), ",", ".")) ;
         subGridhomemodulessdts_Class = httpContext.cgiGet( sPrefix+"GRIDHOMEMODULESSDTS_Class") ;
         subGridhomemodulessdts_Flexwrap = httpContext.cgiGet( sPrefix+"GRIDHOMEMODULESSDTS_Flexwrap") ;
         /* Read variables values. */
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
      e11092 ();
      if (returnInSub) return;
   }

   public void e11092( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavOptionlink_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptionlink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Visible), 5, 0), !bGXsfl_12_Refreshing);
      edtavOptionlink_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptionlink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Visible), 5, 0), !bGXsfl_12_Refreshing);
      edtavOptionlink_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptionlink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Visible), 5, 0), !bGXsfl_12_Refreshing);
      edtavOptionlink_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptionlink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Visible), 5, 0), !bGXsfl_12_Refreshing);
      AV5HomeModulesSDT = new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>(com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem.class, "HomeModulesSDTItem", "Gregory", remoteHandle) ;
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Sales and Distribution" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-credit-card" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Inventory" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-tasks" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Security" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-key" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Notifications" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fas fa-bell" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Configurations" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-cog" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Inventory management" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-tasks" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Security" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-key" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Notifications" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fas fa-bell" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Configurations" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-cog" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
      AV8HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Sales and Distribution" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-credit-card" );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      AV8HomeModulesSDTItem.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      AV5HomeModulesSDT.add(AV8HomeModulesSDTItem, 0);
   }

   private void e12092( )
   {
      /* Gridhomemodulessdts_Load Routine */
      returnInSub = false ;
      AV11GXV1 = 1 ;
      while ( AV11GXV1 <= AV5HomeModulesSDT.size() )
      {
         AV5HomeModulesSDT.currentItem( ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)AV5HomeModulesSDT.elementAt(-1+AV11GXV1)) );
         AV6OptionLink = ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavOptionlink_Internalname, AV6OptionLink);
         if ( ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype() == 1 )
         {
            lblLayoutoptionandtitleoptionicon_Caption = GXutil.format( "<i class='CardsMenuIcon %1' style='font-size: 40px'></i>", ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass(), "", "", "", "", "", "", "", "") ;
            AV7OptionTitle = ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavOptiontitle_Internalname, AV7OptionTitle);
         }
         divLayoutoptionandtitletablecell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutoptionandtitletablecell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divLayoutoptionandtitletablecell_Visible), 5, 0), !bGXsfl_12_Refreshing);
         divLayoutprogressbartablecell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutprogressbartablecell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divLayoutprogressbartablecell_Visible), 5, 0), !bGXsfl_12_Refreshing);
         divLayoutprogresscircletablecell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutprogresscircletablecell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divLayoutprogresscircletablecell_Visible), 5, 0), !bGXsfl_12_Refreshing);
         divLayoutcustomwctablecell_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutcustomwctablecell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divLayoutcustomwctablecell_Visible), 5, 0), !bGXsfl_12_Refreshing);
         if ( ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype() == 2 )
         {
            divLayoutprogressbartablecell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutprogressbartablecell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divLayoutprogressbartablecell_Visible), 5, 0), !bGXsfl_12_Refreshing);
            /* Object Property */
            if ( GXutil.len( sPrefix) == 0 )
            {
               bDynCreated_Layoutprogressbarwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Layoutprogressbarwc_Component), GXutil.lower( "WWPBaseObjects.HomeProgressBarWC")) != 0 )
            {
               WebComp_Layoutprogressbarwc = WebFrontendUtils.getWebComponent(getClass(), "com.wwpbaseobjects.homeprogressbarwc_impl", remoteHandle, context);
               WebComp_Layoutprogressbarwc_Component = "WWPBaseObjects.HomeProgressBarWC" ;
            }
            if ( GXutil.len( WebComp_Layoutprogressbarwc_Component) != 0 )
            {
               WebComp_Layoutprogressbarwc.setjustcreated();
               WebComp_Layoutprogressbarwc.componentprepare(new Object[] {sPrefix+"W0033",sGXsfl_12_idx,((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle(),((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription(),((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue()});
               WebComp_Layoutprogressbarwc.componentbind(new Object[] {"","",""});
            }
         }
         else if ( ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype() == 3 )
         {
            divLayoutprogresscircletablecell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutprogresscircletablecell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divLayoutprogresscircletablecell_Visible), 5, 0), !bGXsfl_12_Refreshing);
            /* Object Property */
            if ( GXutil.len( sPrefix) == 0 )
            {
               bDynCreated_Layoutprogresscirclewc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Layoutprogresscirclewc_Component), GXutil.lower( "WWPBaseObjects.HomeProgressBarCircleWC")) != 0 )
            {
               WebComp_Layoutprogresscirclewc = WebFrontendUtils.getWebComponent(getClass(), "com.wwpbaseobjects.homeprogressbarcirclewc_impl", remoteHandle, context);
               WebComp_Layoutprogresscirclewc_Component = "WWPBaseObjects.HomeProgressBarCircleWC" ;
            }
            if ( GXutil.len( WebComp_Layoutprogresscirclewc_Component) != 0 )
            {
               WebComp_Layoutprogresscirclewc.setjustcreated();
               WebComp_Layoutprogresscirclewc.componentprepare(new Object[] {sPrefix+"W0038",sGXsfl_12_idx,((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle(),((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue()});
               WebComp_Layoutprogresscirclewc.componentbind(new Object[] {"",""});
            }
         }
         else if ( ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV5HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype() == 4 )
         {
            divLayoutcustomwctablecell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutcustomwctablecell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divLayoutcustomwctablecell_Visible), 5, 0), !bGXsfl_12_Refreshing);
         }
         else
         {
            divLayoutoptionandtitletablecell_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutoptionandtitletablecell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divLayoutoptionandtitletablecell_Visible), 5, 0), !bGXsfl_12_Refreshing);
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(12) ;
         }
         sendrow_122( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
         {
            httpContext.doAjaxLoad(12, GridhomemodulessdtsRow);
         }
         AV11GXV1 = (int)(AV11GXV1+1) ;
      }
      /*  Sending Event outputs  */
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
      pa092( ) ;
      ws092( ) ;
      we092( ) ;
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
      pa092( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wwp_wcmodules", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa092( ) ;
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
      pa092( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws092( ) ;
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
      ws092( ) ;
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
      we092( ) ;
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
      if ( ! ( WebComp_GX_Process == null ) )
      {
         WebComp_GX_Process.componentjscripts();
      }
      if ( ! ( WebComp_Layoutprogressbarwc == null ) )
      {
         WebComp_Layoutprogressbarwc.componentjscripts();
      }
      if ( ! ( WebComp_Layoutprogresscirclewc == null ) )
      {
         WebComp_Layoutprogresscirclewc.componentjscripts();
      }
      if ( ! ( WebComp_Layoutcustomwcwc == null ) )
      {
         WebComp_Layoutcustomwcwc.componentjscripts();
      }
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Layoutprogressbarwc == null ) )
      {
         if ( GXutil.len( WebComp_Layoutprogressbarwc_Component) != 0 )
         {
            WebComp_Layoutprogressbarwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Layoutprogresscirclewc == null ) )
      {
         if ( GXutil.len( WebComp_Layoutprogresscirclewc_Component) != 0 )
         {
            WebComp_Layoutprogresscirclewc.componentthemes();
         }
      }
      if ( ! ( WebComp_Layoutcustomwcwc == null ) )
      {
         WebComp_Layoutcustomwcwc.componentthemes();
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163886", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/wwp_wcmodules.js", "?202442617163886", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_122( )
   {
      edtavOptionlink_Internalname = sPrefix+"vOPTIONLINK_"+sGXsfl_12_idx ;
      lblLayoutoptionandtitleoptionicon_Internalname = sPrefix+"LAYOUTOPTIONANDTITLEOPTIONICON_"+sGXsfl_12_idx ;
      edtavOptiontitle_Internalname = sPrefix+"vOPTIONTITLE_"+sGXsfl_12_idx ;
   }

   public void subsflControlProps_fel_122( )
   {
      edtavOptionlink_Internalname = sPrefix+"vOPTIONLINK_"+sGXsfl_12_fel_idx ;
      lblLayoutoptionandtitleoptionicon_Internalname = sPrefix+"LAYOUTOPTIONANDTITLEOPTIONICON_"+sGXsfl_12_fel_idx ;
      edtavOptiontitle_Internalname = sPrefix+"vOPTIONTITLE_"+sGXsfl_12_fel_idx ;
   }

   public void sendrow_122( )
   {
      subsflControlProps_122( ) ;
      wb090( ) ;
      GridhomemodulessdtsRow = GXWebRow.GetNew(context,GridhomemodulessdtsContainer) ;
      if ( subGridhomemodulessdts_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridhomemodulessdts_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridhomemodulessdts_Class, "") != 0 )
         {
            subGridhomemodulessdts_Linesclass = subGridhomemodulessdts_Class+"Odd" ;
         }
      }
      else if ( subGridhomemodulessdts_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridhomemodulessdts_Backstyle = (byte)(0) ;
         subGridhomemodulessdts_Backcolor = subGridhomemodulessdts_Allbackcolor ;
         if ( GXutil.strcmp(subGridhomemodulessdts_Class, "") != 0 )
         {
            subGridhomemodulessdts_Linesclass = subGridhomemodulessdts_Class+"Uniform" ;
         }
      }
      else if ( subGridhomemodulessdts_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridhomemodulessdts_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridhomemodulessdts_Class, "") != 0 )
         {
            subGridhomemodulessdts_Linesclass = subGridhomemodulessdts_Class+"Odd" ;
         }
         subGridhomemodulessdts_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridhomemodulessdts_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridhomemodulessdts_Backstyle = (byte)(1) ;
         subGridhomemodulessdts_Backcolor = (int)(0xFFFFFF) ;
         if ( GXutil.strcmp(subGridhomemodulessdts_Class, "") != 0 )
         {
            subGridhomemodulessdts_Linesclass = subGridhomemodulessdts_Class+"Odd" ;
         }
      }
      /* Start of Columns property logic. */
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGridhomemodulessdtslayouttable_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","start","top"," "+"data-gx-flex"+" ","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Invisible","start","top","","flex-grow:1;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Table start */
      GridhomemodulessdtsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsgridhomemodulessdts_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Attribute/Variable Label */
      GridhomemodulessdtsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavOptionlink_Internalname,"Option Link","gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      GridhomemodulessdtsRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavOptionlink_Internalname,AV6OptionLink,"","",Integer.valueOf(0),Integer.valueOf(edtavOptionlink_Visible),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+sPrefix+"'"+",false,"+"'"+""+"'",Integer.valueOf(0),""});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      if ( GridhomemodulessdtsContainer.GetWrapped() == 1 )
      {
         GridhomemodulessdtsContainer.CloseTag("cell");
      }
      if ( GridhomemodulessdtsContainer.GetWrapped() == 1 )
      {
         GridhomemodulessdtsContainer.CloseTag("row");
      }
      if ( GridhomemodulessdtsContainer.GetWrapped() == 1 )
      {
         GridhomemodulessdtsContainer.CloseTag("table");
      }
      /* End of table */
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayoutoptionandtitletablecell_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(divLayoutoptionandtitletablecell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayoutoptionandtitletable_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableCardsMenu","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","Center","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Text block */
      GridhomemodulessdtsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblLayoutoptionandtitleoptionicon_Internalname,lblLayoutoptionandtitleoptionicon_Caption,"","",lblLayoutoptionandtitleoptionicon_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 AttributeCardsMenuTitleCell","Center","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Attribute/Variable Label */
      GridhomemodulessdtsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavOptiontitle_Internalname,"Option Title","col-sm-3 AttributeCardsMenuTitleLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Single line edit */
      ROClassString = "AttributeCardsMenuTitle" ;
      GridhomemodulessdtsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavOptiontitle_Internalname,AV7OptionTitle,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavOptiontitle_Jsonclick,Integer.valueOf(0),"AttributeCardsMenuTitle","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavOptiontitle_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayoutprogressbartablecell_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(divLayoutprogressbartablecell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayoutprogressbartable_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableCardsMenu","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* WebComponent */
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0033"+sGXsfl_12_idx, GXutil.rtrim( WebComp_Layoutprogressbarwc_Component));
      httpContext.writeText( "<div") ;
      com.GxWebStd.classAttribute( httpContext, "gxwebcomponent"+" gxwebcomponent-loading");
      httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0033"+sGXsfl_12_idx+"\""+"") ;
      httpContext.writeText( ">") ;
      if ( bGXsfl_12_Refreshing )
      {
         if ( GXutil.len( WebComp_Layoutprogressbarwc_Component) != 0 )
         {
            if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strSearch( sPrefix+"W0033"+sGXsfl_12_idx, httpContext.cgiGet( "_EventName"), 1) != 0 ) )
            {
               if ( 1 != 0 )
               {
                  if ( GXutil.len( WebComp_Layoutprogressbarwc_Component) != 0 )
                  {
                     WebComp_Layoutprogressbarwc.componentstart();
                  }
               }
            }
            if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strcmp(GXutil.lower( OldLayoutprogressbarwc), GXutil.lower( WebComp_Layoutprogressbarwc_Component)) != 0 ) )
            {
               httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0033"+sGXsfl_12_idx);
            }
            WebComp_Layoutprogressbarwc.componentdraw();
            if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strcmp(GXutil.lower( OldLayoutprogressbarwc), GXutil.lower( WebComp_Layoutprogressbarwc_Component)) != 0 ) )
            {
               httpContext.ajax_rspEndCmp();
            }
         }
      }
      httpContext.writeText( "</div>") ;
      WebComp_Layoutprogressbarwc_Component = "" ;
      WebComp_Layoutprogressbarwc.componentjscripts();
      GridhomemodulessdtsRow.AddColumnProperties("webcomp", -1, isAjaxCallMode( ), new Object[] {"Layoutprogressbarwc"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayoutprogresscircletablecell_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(divLayoutprogresscircletablecell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayoutprogresscircletable_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableCardsMenu","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* WebComponent */
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0038"+sGXsfl_12_idx, GXutil.rtrim( WebComp_Layoutprogresscirclewc_Component));
      httpContext.writeText( "<div") ;
      com.GxWebStd.classAttribute( httpContext, "gxwebcomponent"+" gxwebcomponent-loading");
      httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0038"+sGXsfl_12_idx+"\""+"") ;
      httpContext.writeText( ">") ;
      if ( bGXsfl_12_Refreshing )
      {
         if ( GXutil.len( WebComp_Layoutprogresscirclewc_Component) != 0 )
         {
            if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strSearch( sPrefix+"W0038"+sGXsfl_12_idx, httpContext.cgiGet( "_EventName"), 1) != 0 ) )
            {
               if ( 1 != 0 )
               {
                  if ( GXutil.len( WebComp_Layoutprogresscirclewc_Component) != 0 )
                  {
                     WebComp_Layoutprogresscirclewc.componentstart();
                  }
               }
            }
            if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strcmp(GXutil.lower( OldLayoutprogresscirclewc), GXutil.lower( WebComp_Layoutprogresscirclewc_Component)) != 0 ) )
            {
               httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0038"+sGXsfl_12_idx);
            }
            WebComp_Layoutprogresscirclewc.componentdraw();
            if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strcmp(GXutil.lower( OldLayoutprogresscirclewc), GXutil.lower( WebComp_Layoutprogresscirclewc_Component)) != 0 ) )
            {
               httpContext.ajax_rspEndCmp();
            }
         }
      }
      httpContext.writeText( "</div>") ;
      WebComp_Layoutprogresscirclewc_Component = "" ;
      WebComp_Layoutprogresscirclewc.componentjscripts();
      GridhomemodulessdtsRow.AddColumnProperties("webcomp", -1, isAjaxCallMode( ), new Object[] {"Layoutprogresscirclewc"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayoutcustomwctablecell_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(divLayoutcustomwctablecell_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","start","top","","flex-grow:1;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divLayoutcustomwctable_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableCardsMenu","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* WebComponent */
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0043"+sGXsfl_12_idx, GXutil.rtrim( WebComp_Layoutcustomwcwc_Component));
      httpContext.writeText( "<div") ;
      com.GxWebStd.classAttribute( httpContext, "gxwebcomponent"+" gxwebcomponent-loading");
      httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0043"+sGXsfl_12_idx+"\""+"") ;
      httpContext.writeText( ">") ;
      if ( bGXsfl_12_Refreshing )
      {
         if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strSearch( sPrefix+"W0043"+sGXsfl_12_idx, httpContext.cgiGet( "_EventName"), 1) != 0 ) )
         {
            if ( 1 != 0 )
            {
               WebComp_Layoutcustomwcwc.componentstart();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strcmp(GXutil.lower( OldLayoutcustomwcwc), GXutil.lower( WebComp_Layoutcustomwcwc_Component)) != 0 ) )
         {
            httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0043"+sGXsfl_12_idx);
         }
         WebComp_Layoutcustomwcwc.componentdraw();
         if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strcmp(GXutil.lower( OldLayoutcustomwcwc), GXutil.lower( WebComp_Layoutcustomwcwc_Component)) != 0 ) )
         {
            httpContext.ajax_rspEndCmp();
         }
      }
      httpContext.writeText( "</div>") ;
      WebComp_Layoutcustomwcwc_Component = "" ;
      WebComp_Layoutcustomwcwc.componentjscripts();
      GridhomemodulessdtsRow.AddColumnProperties("webcomp", -1, isAjaxCallMode( ), new Object[] {"Layoutcustomwcwc"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      send_integrity_lvl_hashes092( ) ;
      /* End of Columns property logic. */
      GridhomemodulessdtsContainer.AddRow(GridhomemodulessdtsRow);
      nGXsfl_12_idx = ((subGridhomemodulessdts_Islastpage==1)&&(nGXsfl_12_idx+1>subgridhomemodulessdts_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
      sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_122( ) ;
      /* End function sendrow_122 */
   }

   public void startgridcontrol12( )
   {
      if ( GridhomemodulessdtsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridhomemodulessdtsContainer"+"DivS\" data-gxgridid=\"12\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGridhomemodulessdts_Internalname, subGridhomemodulessdts_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridhomemodulessdtsContainer.AddObjectProperty("GridName", "Gridhomemodulessdts");
      }
      else
      {
         GridhomemodulessdtsContainer.AddObjectProperty("GridName", "Gridhomemodulessdts");
         GridhomemodulessdtsContainer.AddObjectProperty("Header", subGridhomemodulessdts_Header);
         GridhomemodulessdtsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         GridhomemodulessdtsContainer.AddObjectProperty("Class", "FreeStyleGrid");
         GridhomemodulessdtsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("CmpContext", sPrefix);
         GridhomemodulessdtsContainer.AddObjectProperty("InMasterPage", "false");
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV6OptionLink));
         GridhomemodulessdtsColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavOptionlink_Visible, (byte)(5), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsColumn.AddObjectProperty("Value", lblLayoutoptionandtitleoptionicon_Caption);
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV7OptionTitle));
         GridhomemodulessdtsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavOptiontitle_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavOptionlink_Internalname = sPrefix+"vOPTIONLINK" ;
      tblUnnamedtablecontentfsgridhomemodulessdts_Internalname = sPrefix+"UNNAMEDTABLECONTENTFSGRIDHOMEMODULESSDTS" ;
      lblLayoutoptionandtitleoptionicon_Internalname = sPrefix+"LAYOUTOPTIONANDTITLEOPTIONICON" ;
      edtavOptiontitle_Internalname = sPrefix+"vOPTIONTITLE" ;
      divLayoutoptionandtitletable_Internalname = sPrefix+"LAYOUTOPTIONANDTITLETABLE" ;
      divLayoutoptionandtitletablecell_Internalname = sPrefix+"LAYOUTOPTIONANDTITLETABLECELL" ;
      divLayoutprogressbartable_Internalname = sPrefix+"LAYOUTPROGRESSBARTABLE" ;
      divLayoutprogressbartablecell_Internalname = sPrefix+"LAYOUTPROGRESSBARTABLECELL" ;
      divLayoutprogresscircletable_Internalname = sPrefix+"LAYOUTPROGRESSCIRCLETABLE" ;
      divLayoutprogresscircletablecell_Internalname = sPrefix+"LAYOUTPROGRESSCIRCLETABLECELL" ;
      divLayoutcustomwctable_Internalname = sPrefix+"LAYOUTCUSTOMWCTABLE" ;
      divLayoutcustomwctablecell_Internalname = sPrefix+"LAYOUTCUSTOMWCTABLECELL" ;
      divGridhomemodulessdtslayouttable_Internalname = sPrefix+"GRIDHOMEMODULESSDTSLAYOUTTABLE" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGridhomemodulessdts_Internalname = sPrefix+"GRIDHOMEMODULESSDTS" ;
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
      subGridhomemodulessdts_Allowcollapsing = (byte)(0) ;
      lblLayoutoptionandtitleoptionicon_Caption = "<i class='CardsMenuIcon fa fa-home' style='font-size: 40px'></i>" ;
      divLayoutcustomwctablecell_Visible = 1 ;
      divLayoutprogresscircletablecell_Visible = 1 ;
      divLayoutprogressbartablecell_Visible = 1 ;
      edtavOptiontitle_Jsonclick = "" ;
      edtavOptiontitle_Enabled = 0 ;
      lblLayoutoptionandtitleoptionicon_Caption = "<i class='CardsMenuIcon fa fa-home' style='font-size: 40px'></i>" ;
      divLayoutoptionandtitletablecell_Visible = 1 ;
      subGridhomemodulessdts_Backcolorstyle = (byte)(0) ;
      subGridhomemodulessdts_Flexwrap = "wrap" ;
      subGridhomemodulessdts_Class = "FreeStyleGrid" ;
      edtavOptionlink_Visible = 1 ;
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDHOMEMODULESSDTS_nFirstRecordOnPage'},{av:'GRIDHOMEMODULESSDTS_nEOF'},{av:'edtavOptionlink_Visible',ctrl:'vOPTIONLINK',prop:'Visible'},{av:'sPrefix'},{av:'AV5HomeModulesSDT',fld:'vHOMEMODULESSDT',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDHOMEMODULESSDTS.LOAD","{handler:'e12092',iparms:[{av:'AV5HomeModulesSDT',fld:'vHOMEMODULESSDT',pic:'',hsh:true}]");
      setEventMetadata("GRIDHOMEMODULESSDTS.LOAD",",oparms:[{av:'AV6OptionLink',fld:'vOPTIONLINK',pic:''},{av:'lblLayoutoptionandtitleoptionicon_Caption',ctrl:'LAYOUTOPTIONANDTITLEOPTIONICON',prop:'Caption'},{av:'AV7OptionTitle',fld:'vOPTIONTITLE',pic:''},{av:'divLayoutoptionandtitletablecell_Visible',ctrl:'LAYOUTOPTIONANDTITLETABLECELL',prop:'Visible'},{av:'divLayoutprogressbartablecell_Visible',ctrl:'LAYOUTPROGRESSBARTABLECELL',prop:'Visible'},{av:'divLayoutprogresscircletablecell_Visible',ctrl:'LAYOUTPROGRESSCIRCLETABLECELL',prop:'Visible'},{av:'divLayoutcustomwctablecell_Visible',ctrl:'LAYOUTCUSTOMWCTABLECELL',prop:'Visible'},{ctrl:'LAYOUTPROGRESSBARWC'},{ctrl:'LAYOUTPROGRESSCIRCLEWC'}]}");
      setEventMetadata("NULL","{handler:'validv_Optiontitle',iparms:[]");
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
      AV5HomeModulesSDT = new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>(com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem.class, "HomeModulesSDTItem", "Gregory", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      GridhomemodulessdtsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV6OptionLink = "" ;
      AV7OptionTitle = "" ;
      OldLayoutprogressbarwc = "" ;
      sCmpCtrl = "" ;
      WebComp_GX_Process_Component = "" ;
      WebCompHandler = "" ;
      OldLayoutprogresscirclewc = "" ;
      OldLayoutcustomwcwc = "" ;
      WebComp_Layoutprogressbarwc_Component = "" ;
      WebComp_Layoutprogresscirclewc_Component = "" ;
      AV8HomeModulesSDTItem = new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      GridhomemodulessdtsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridhomemodulessdts_Linesclass = "" ;
      GridhomemodulessdtsColumn = new com.genexus.webpanels.GXWebColumn();
      ClassString = "" ;
      StyleString = "" ;
      lblLayoutoptionandtitleoptionicon_Jsonclick = "" ;
      ROClassString = "" ;
      WebComp_Layoutcustomwcwc_Component = "" ;
      subGridhomemodulessdts_Header = "" ;
      /* GeneXus formulas. */
      edtavOptiontitle_Enabled = 0 ;
      WebComp_GX_Process = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Layoutprogressbarwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Layoutprogresscirclewc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Layoutcustomwcwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGridhomemodulessdts_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGridhomemodulessdts_Backstyle ;
   private byte subGridhomemodulessdts_Allowselection ;
   private byte subGridhomemodulessdts_Allowhovering ;
   private byte subGridhomemodulessdts_Allowcollapsing ;
   private byte subGridhomemodulessdts_Collapsed ;
   private byte GRIDHOMEMODULESSDTS_nEOF ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private int edtavOptionlink_Visible ;
   private int nRC_GXsfl_12 ;
   private int subGridhomemodulessdts_Recordcount ;
   private int nGXsfl_12_idx=1 ;
   private int AV11GXV1 ;
   private int nGXsfl_12_webc_idx ;
   private int subGridhomemodulessdts_Islastpage ;
   private int edtavOptiontitle_Enabled ;
   private int divLayoutoptionandtitletablecell_Visible ;
   private int divLayoutprogressbartablecell_Visible ;
   private int divLayoutprogresscircletablecell_Visible ;
   private int divLayoutcustomwctablecell_Visible ;
   private int idxLst ;
   private int subGridhomemodulessdts_Backcolor ;
   private int subGridhomemodulessdts_Allbackcolor ;
   private int subGridhomemodulessdts_Selectedindex ;
   private int subGridhomemodulessdts_Selectioncolor ;
   private int subGridhomemodulessdts_Hoveringcolor ;
   private long GRIDHOMEMODULESSDTS_nCurrentRecord ;
   private long GRIDHOMEMODULESSDTS_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_12_idx="0001" ;
   private String edtavOptionlink_Internalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String subGridhomemodulessdts_Class ;
   private String subGridhomemodulessdts_Flexwrap ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTablecontent_Internalname ;
   private String sStyleString ;
   private String subGridhomemodulessdts_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavOptiontitle_Internalname ;
   private String OldLayoutprogressbarwc ;
   private String sCmpCtrl ;
   private String WebComp_GX_Process_Component ;
   private String WebCompHandler ;
   private String OldLayoutprogresscirclewc ;
   private String OldLayoutcustomwcwc ;
   private String WebComp_Layoutprogressbarwc_Component ;
   private String WebComp_Layoutprogresscirclewc_Component ;
   private String lblLayoutoptionandtitleoptionicon_Caption ;
   private String divLayoutoptionandtitletablecell_Internalname ;
   private String divLayoutprogressbartablecell_Internalname ;
   private String divLayoutprogresscircletablecell_Internalname ;
   private String divLayoutcustomwctablecell_Internalname ;
   private String lblLayoutoptionandtitleoptionicon_Internalname ;
   private String sGXsfl_12_fel_idx="0001" ;
   private String subGridhomemodulessdts_Linesclass ;
   private String divGridhomemodulessdtslayouttable_Internalname ;
   private String tblUnnamedtablecontentfsgridhomemodulessdts_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divLayoutoptionandtitletable_Internalname ;
   private String lblLayoutoptionandtitleoptionicon_Jsonclick ;
   private String ROClassString ;
   private String edtavOptiontitle_Jsonclick ;
   private String divLayoutprogressbartable_Internalname ;
   private String divLayoutprogresscircletable_Internalname ;
   private String divLayoutcustomwctable_Internalname ;
   private String WebComp_Layoutcustomwcwc_Component ;
   private String subGridhomemodulessdts_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_12_Refreshing=false ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean bDynCreated_Layoutprogressbarwc ;
   private boolean bDynCreated_Layoutprogresscirclewc ;
   private String AV6OptionLink ;
   private String AV7OptionTitle ;
   private com.genexus.webpanels.GXWebGrid GridhomemodulessdtsContainer ;
   private com.genexus.webpanels.GXWebRow GridhomemodulessdtsRow ;
   private com.genexus.webpanels.GXWebColumn GridhomemodulessdtsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Layoutprogressbarwc ;
   private GXWebComponent WebComp_Layoutprogresscirclewc ;
   private GXWebComponent WebComp_Layoutcustomwcwc ;
   private GXWebComponent WebComp_GX_Process ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> AV5HomeModulesSDT ;
   private com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem AV8HomeModulesSDTItem ;
}

