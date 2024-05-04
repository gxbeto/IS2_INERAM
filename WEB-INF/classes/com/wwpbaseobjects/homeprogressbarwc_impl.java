package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class homeprogressbarwc_impl extends GXWebComponent
{
   public homeprogressbarwc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public homeprogressbarwc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( homeprogressbarwc_impl.class ));
   }

   public homeprogressbarwc_impl( int remoteHandle ,
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
               AV9BarDescription = httpContext.GetPar( "BarDescription") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9BarDescription", AV9BarDescription);
               AV6Percentage = (byte)(GXutil.lval( httpContext.GetPar( "Percentage"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Percentage), 2, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV5OptionTitle,AV9BarDescription,Byte.valueOf(AV6Percentage)});
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
         pa0A2( ) ;
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
         httpContext.writeValue( "Home Progress Bar WC") ;
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
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.wwpbaseobjects.homeprogressbarwc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV5OptionTitle)),GXutil.URLEncode(GXutil.rtrim(AV9BarDescription)),GXutil.URLEncode(GXutil.ltrimstr(AV6Percentage,2,0))}, new String[] {"OptionTitle","BarDescription","Percentage"}) +"\">") ;
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
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9BarDescription", wcpOAV9BarDescription);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6Percentage", GXutil.ltrim( localUtil.ntoc( wcpOAV6Percentage, (byte)(2), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vBARDESCRIPTION", AV9BarDescription);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPERCENTAGE", GXutil.ltrim( localUtil.ntoc( AV6Percentage, (byte)(2), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROGRESSBAR1_Type", GXutil.rtrim( Progressbar1_Type));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROGRESSBAR1_Percentage", GXutil.ltrim( localUtil.ntoc( Progressbar1_Percentage, (byte)(9), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm0A2( )
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
      return "WWPBaseObjects.HomeProgressBarWC" ;
   }

   public String getPgmdesc( )
   {
      return "Home Progress Bar WC" ;
   }

   public void wb0A0( )
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
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.wwpbaseobjects.homeprogressbarwc");
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
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableCardsMenuOptionWCPB", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblDescriptionprogressbar1_Internalname, lblDescriptionprogressbar1_Caption, "", "", lblDescriptionprogressbar1_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "ProgressBarCardsMenuDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/HomeProgressBarWC.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* User Defined Control */
         ucProgressbar1.setProperty("Type", Progressbar1_Type);
         ucProgressbar1.setProperty("Caption", Progressbar1_Caption);
         ucProgressbar1.setProperty("Percentage", Progressbar1_Percentage);
         ucProgressbar1.render(context, "dvelop.gxbootstrap.dvprogressindicator", Progressbar1_Internalname, sPrefix+"PROGRESSBAR1Container");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
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
         com.GxWebStd.gx_single_line_edit( httpContext, edtavOptiontitle_Internalname, AV5OptionTitle, GXutil.rtrim( localUtil.format( AV5OptionTitle, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOptiontitle_Jsonclick, 0, "AttributeCardsMenuTitle", "", "", "", "", 1, edtavOptiontitle_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), false, "", "start", true, "", "HLP_WWPBaseObjects/HomeProgressBarWC.htm");
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

   public void start0A2( )
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
         Form.getMeta().addItem("description", "Home Progress Bar WC", (short)(0)) ;
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
            strup0A0( ) ;
         }
      }
   }

   public void ws0A2( )
   {
      start0A2( ) ;
      evt0A2( ) ;
   }

   public void evt0A2( )
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
                              strup0A0( ) ;
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
                              strup0A0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e110A2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0A0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e120A2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0A0( ) ;
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
                              strup0A0( ) ;
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

   public void we0A2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0A2( ) ;
         }
      }
   }

   public void pa0A2( )
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
      rf0A2( ) ;
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

   public void rf0A2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e120A2 ();
         wb0A0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0A2( )
   {
   }

   public void before_start_formulas( )
   {
      edtavOptiontitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOptiontitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptiontitle_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup0A0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV5OptionTitle = httpContext.cgiGet( sPrefix+"wcpOAV5OptionTitle") ;
         wcpOAV9BarDescription = httpContext.cgiGet( sPrefix+"wcpOAV9BarDescription") ;
         wcpOAV6Percentage = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV6Percentage"), ",", ".")) ;
         Progressbar1_Type = httpContext.cgiGet( sPrefix+"PROGRESSBAR1_Type") ;
         Progressbar1_Percentage = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"PROGRESSBAR1_Percentage"), ",", ".")) ;
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
      e110A2 ();
      if (returnInSub) return;
   }

   public void e110A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Progressbar1_Percentage = AV6Percentage ;
      ucProgressbar1.sendProperty(context, sPrefix, false, Progressbar1_Internalname, "Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(Progressbar1_Percentage), 9, 0));
      lblDescriptionprogressbar1_Caption = AV9BarDescription ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblDescriptionprogressbar1_Internalname, "Caption", lblDescriptionprogressbar1_Caption, true);
   }

   protected void nextLoad( )
   {
   }

   protected void e120A2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV5OptionTitle = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5OptionTitle", AV5OptionTitle);
      AV9BarDescription = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9BarDescription", AV9BarDescription);
      AV6Percentage = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Percentage), 2, 0));
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
      pa0A2( ) ;
      ws0A2( ) ;
      we0A2( ) ;
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
      sCtrlAV9BarDescription = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV6Percentage = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0A2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\homeprogressbarwc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0A2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV5OptionTitle = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5OptionTitle", AV5OptionTitle);
         AV9BarDescription = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9BarDescription", AV9BarDescription);
         AV6Percentage = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Percentage), 2, 0));
      }
      wcpOAV5OptionTitle = httpContext.cgiGet( sPrefix+"wcpOAV5OptionTitle") ;
      wcpOAV9BarDescription = httpContext.cgiGet( sPrefix+"wcpOAV9BarDescription") ;
      wcpOAV6Percentage = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV6Percentage"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV5OptionTitle, wcpOAV5OptionTitle) != 0 ) || ( GXutil.strcmp(AV9BarDescription, wcpOAV9BarDescription) != 0 ) || ( AV6Percentage != wcpOAV6Percentage ) ) )
      {
         setjustcreated();
      }
      wcpOAV5OptionTitle = AV5OptionTitle ;
      wcpOAV9BarDescription = AV9BarDescription ;
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
      sCtrlAV9BarDescription = httpContext.cgiGet( sPrefix+"AV9BarDescription_CTRL") ;
      if ( GXutil.len( sCtrlAV9BarDescription) > 0 )
      {
         AV9BarDescription = httpContext.cgiGet( sCtrlAV9BarDescription) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9BarDescription", AV9BarDescription);
      }
      else
      {
         AV9BarDescription = httpContext.cgiGet( sPrefix+"AV9BarDescription_PARM") ;
      }
      sCtrlAV6Percentage = httpContext.cgiGet( sPrefix+"AV6Percentage_CTRL") ;
      if ( GXutil.len( sCtrlAV6Percentage) > 0 )
      {
         AV6Percentage = (byte)(localUtil.ctol( httpContext.cgiGet( sCtrlAV6Percentage), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6Percentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Percentage), 2, 0));
      }
      else
      {
         AV6Percentage = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV6Percentage_PARM"), ",", ".")) ;
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
      pa0A2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0A2( ) ;
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
      ws0A2( ) ;
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
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9BarDescription_PARM", AV9BarDescription);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV9BarDescription)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9BarDescription_CTRL", GXutil.rtrim( sCtrlAV9BarDescription));
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6Percentage_PARM", GXutil.ltrim( localUtil.ntoc( AV6Percentage, (byte)(2), (byte)(0), ",", "")));
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
      we0A2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163725", true, true);
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
         httpContext.AddJavascriptSource("wwpbaseobjects/homeprogressbarwc.js", "?202442617163725", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblDescriptionprogressbar1_Internalname = sPrefix+"DESCRIPTIONPROGRESSBAR1" ;
      Progressbar1_Internalname = sPrefix+"PROGRESSBAR1" ;
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
      Progressbar1_Caption = "" ;
      lblDescriptionprogressbar1_Caption = "Add Products to Cart" ;
      Progressbar1_Percentage = 83 ;
      Progressbar1_Type = "Bar" ;
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
      wcpOAV9BarDescription = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV5OptionTitle = "" ;
      AV9BarDescription = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      lblDescriptionprogressbar1_Jsonclick = "" ;
      ucProgressbar1 = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV5OptionTitle = "" ;
      sCtrlAV9BarDescription = "" ;
      sCtrlAV6Percentage = "" ;
      /* GeneXus formulas. */
      edtavOptiontitle_Enabled = 0 ;
   }

   private byte wcpOAV6Percentage ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV6Percentage ;
   private byte nGXWrapped ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int Progressbar1_Percentage ;
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
   private String Progressbar1_Type ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String lblDescriptionprogressbar1_Internalname ;
   private String lblDescriptionprogressbar1_Caption ;
   private String lblDescriptionprogressbar1_Jsonclick ;
   private String Progressbar1_Caption ;
   private String Progressbar1_Internalname ;
   private String edtavOptiontitle_Internalname ;
   private String edtavOptiontitle_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String sCtrlAV5OptionTitle ;
   private String sCtrlAV9BarDescription ;
   private String sCtrlAV6Percentage ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String wcpOAV5OptionTitle ;
   private String wcpOAV9BarDescription ;
   private String AV5OptionTitle ;
   private String AV9BarDescription ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucProgressbar1 ;
}

