package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class homeprogressbarcirclewc_impl extends GXWebComponent
{
   public homeprogressbarcirclewc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public homeprogressbarcirclewc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( homeprogressbarcirclewc_impl.class ));
   }

   public homeprogressbarcirclewc_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "OptionTitle") ;
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
               AV5OptionTitle = httpContext.GetPar( "OptionTitle") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5OptionTitle", AV5OptionTitle);
               AV6Percentage = (short)(GXutil.lval( httpContext.GetPar( "Percentage"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Percentage), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV5OptionTitle,Short.valueOf(AV6Percentage)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "OptionTitle") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "OptionTitle") ;
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

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa0B2( ) ;
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
         httpContext.writeValue( "Home Progress Bar Circle WC") ;
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
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
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.homeprogressbarcirclewc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV5OptionTitle)),GXutil.URLEncode(GXutil.ltrimstr(AV6Percentage,4,0))}, new String[] {"OptionTitle","Percentage"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV5OptionTitle", wcpOAV5OptionTitle);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6Percentage", GXutil.ltrim( localUtil.ntoc( wcpOAV6Percentage, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPERCENTAGE", GXutil.ltrim( localUtil.ntoc( AV6Percentage, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCPB_Caption", GXutil.rtrim( Ucpb_Caption));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCPB_Cls", GXutil.rtrim( Ucpb_Cls));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCPB_Percentage", GXutil.ltrim( localUtil.ntoc( Ucpb_Percentage, (byte)(9), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCPB_Circlewidth", GXutil.ltrim( localUtil.ntoc( Ucpb_Circlewidth, (byte)(9), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCPB_Circleprogresswidth", GXutil.ltrim( localUtil.ntoc( Ucpb_Circleprogresswidth, (byte)(9), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm0B2( )
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
      return "WWPBaseObjects.HomeProgressBarCircleWC" ;
   }

   public String getPgmdesc( )
   {
      return "Home Progress Bar Circle WC" ;
   }

   public void wb0B0( )
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
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.wwpbaseobjects.homeprogressbarcirclewc");
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
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
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableCardsMenuOptionWCCircle", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* User Defined Control */
         ucUcpb.setProperty("Caption", Ucpb_Caption);
         ucUcpb.setProperty("Cls", Ucpb_Cls);
         ucUcpb.setProperty("Percentage", Ucpb_Percentage);
         ucUcpb.setProperty("CircleWidth", Ucpb_Circlewidth);
         ucUcpb.setProperty("CircleProgressWidth", Ucpb_Circleprogresswidth);
         ucUcpb.render(context, "dvelop.gxbootstrap.dvprogressindicator", Ucpb_Internalname, sPrefix+"UCPBContainer");
         com.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 AttributeCardsMenuTitleCell", "Center", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, edtavOptiontitle_Internalname, "Option Title", "col-sm-3 AttributeCardsMenuTitleLabel", 0, true, "");
         /* Single line edit */
         com.GxWebStd.gx_single_line_edit( httpContext, edtavOptiontitle_Internalname, AV5OptionTitle, GXutil.rtrim( localUtil.format( AV5OptionTitle, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOptiontitle_Jsonclick, 0, "AttributeCardsMenuTitle", "", "", "", "", 1, edtavOptiontitle_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), false, "", "start", true, "", "HLP_WWPBaseObjects/HomeProgressBarCircleWC.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      wbLoad = true ;
   }

   public void start0B2( )
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
         Form.getMeta().addItem("description", "Home Progress Bar Circle WC", (short)(0)) ;
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
            strup0B0( ) ;
         }
      }
   }

   public void ws0B2( )
   {
      start0B2( ) ;
      evt0B2( ) ;
   }

   public void evt0B2( )
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
                              strup0B0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e110B2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e120B2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0B0( ) ;
                           }
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
                              strup0B0( ) ;
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
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we0B2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0B2( ) ;
         }
      }
   }

   public void pa0B2( )
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
      rf0B2( ) ;
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
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptiontitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptiontitle_Enabled), 5, 0), true);
   }

   public void rf0B2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e120B2 ();
         wb0B0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0B2( )
   {
   }

   public void before_start_formulas( )
   {
      edtavOptiontitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptiontitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptiontitle_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup0B0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110B2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV5OptionTitle = httpContext.cgiGet( sPrefix+"wcpOAV5OptionTitle") ;
         wcpOAV6Percentage = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV6Percentage"), ",", ".")) ;
         Ucpb_Caption = httpContext.cgiGet( sPrefix+"UCPB_Caption") ;
         Ucpb_Cls = httpContext.cgiGet( sPrefix+"UCPB_Cls") ;
         Ucpb_Percentage = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"UCPB_Percentage"), ",", ".")) ;
         Ucpb_Circlewidth = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"UCPB_Circlewidth"), ",", ".")) ;
         Ucpb_Circleprogresswidth = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"UCPB_Circleprogresswidth"), ",", ".")) ;
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
      e110B2 ();
      if (returnInSub) return;
   }

   public void e110B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Ucpb_Percentage = AV6Percentage ;
      ucUcpb.sendProperty(context, sPrefix, false, Ucpb_Internalname, "Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(Ucpb_Percentage), 9, 0));
      Ucpb_Caption = GXutil.trim( GXutil.str( AV6Percentage, 4, 0))+"%" ;
      ucUcpb.sendProperty(context, sPrefix, false, Ucpb_Internalname, "Caption", Ucpb_Caption);
   }

   protected void nextLoad( )
   {
   }

   protected void e120B2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV5OptionTitle = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5OptionTitle", AV5OptionTitle);
      AV6Percentage = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Percentage), 4, 0));
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
      pa0B2( ) ;
      ws0B2( ) ;
      we0B2( ) ;
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
      sCtrlAV5OptionTitle = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV6Percentage = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0B2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\homeprogressbarcirclewc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0B2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV5OptionTitle = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5OptionTitle", AV5OptionTitle);
         AV6Percentage = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Percentage), 4, 0));
      }
      wcpOAV5OptionTitle = httpContext.cgiGet( sPrefix+"wcpOAV5OptionTitle") ;
      wcpOAV6Percentage = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV6Percentage"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV5OptionTitle, wcpOAV5OptionTitle) != 0 ) || ( AV6Percentage != wcpOAV6Percentage ) ) )
      {
         setjustcreated();
      }
      wcpOAV5OptionTitle = AV5OptionTitle ;
      wcpOAV6Percentage = AV6Percentage ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV5OptionTitle = httpContext.cgiGet( sPrefix+"AV5OptionTitle_CTRL") ;
      if ( GXutil.len( sCtrlAV5OptionTitle) > 0 )
      {
         AV5OptionTitle = httpContext.cgiGet( sCtrlAV5OptionTitle) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5OptionTitle", AV5OptionTitle);
      }
      else
      {
         AV5OptionTitle = httpContext.cgiGet( sPrefix+"AV5OptionTitle_PARM") ;
      }
      sCtrlAV6Percentage = httpContext.cgiGet( sPrefix+"AV6Percentage_CTRL") ;
      if ( GXutil.len( sCtrlAV6Percentage) > 0 )
      {
         AV6Percentage = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV6Percentage), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Percentage), 4, 0));
      }
      else
      {
         AV6Percentage = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV6Percentage_PARM"), ",", ".")) ;
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
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa0B2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0B2( ) ;
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
      ws0B2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV5OptionTitle_PARM", AV5OptionTitle);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV5OptionTitle)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV5OptionTitle_CTRL", GXutil.rtrim( sCtrlAV5OptionTitle));
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6Percentage_PARM", GXutil.ltrim( localUtil.ntoc( AV6Percentage, (byte)(4), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV6Percentage)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6Percentage_CTRL", GXutil.rtrim( sCtrlAV6Percentage));
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
      we0B2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163667", true, true);
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
         httpContext.AddJavascriptSource("wwpbaseobjects/homeprogressbarcirclewc.js", "?202442617163668", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      Ucpb_Internalname = sPrefix+"UCPB" ;
      edtavOptiontitle_Internalname = sPrefix+"vOPTIONTITLE" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
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
      edtavOptiontitle_Jsonclick = "" ;
      edtavOptiontitle_Enabled = 0 ;
      Ucpb_Circleprogresswidth = 3 ;
      Ucpb_Circlewidth = 46 ;
      Ucpb_Percentage = 45 ;
      Ucpb_Cls = "CardsMenuProgressIndicatorCircle" ;
      Ucpb_Caption = "45%" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOAV5OptionTitle = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV5OptionTitle = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      ucUcpb = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV5OptionTitle = "" ;
      sCtrlAV6Percentage = "" ;
      /* GeneXus formulas. */
      edtavOptiontitle_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nGXWrapped ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private short wcpOAV6Percentage ;
   private short AV6Percentage ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int Ucpb_Percentage ;
   private int Ucpb_Circlewidth ;
   private int Ucpb_Circleprogresswidth ;
   private int edtavOptiontitle_Enabled ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Ucpb_Caption ;
   private String Ucpb_Cls ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String Ucpb_Internalname ;
   private String edtavOptiontitle_Internalname ;
   private String edtavOptiontitle_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String sCtrlAV5OptionTitle ;
   private String sCtrlAV6Percentage ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String wcpOAV5OptionTitle ;
   private String AV5OptionTitle ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucUcpb ;
}

