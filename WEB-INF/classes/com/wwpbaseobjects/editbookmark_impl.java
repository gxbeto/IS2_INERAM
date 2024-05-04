package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class editbookmark_impl extends GXWebComponent
{
   public editbookmark_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public editbookmark_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( editbookmark_impl.class ));
   }

   public editbookmark_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "InBookmarkURL") ;
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
               AV16InBookmarkURL = httpContext.GetPar( "InBookmarkURL") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16InBookmarkURL", AV16InBookmarkURL);
               AV9BookmarkPageDescription = httpContext.GetPar( "BookmarkPageDescription") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9BookmarkPageDescription", AV9BookmarkPageDescription);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV16InBookmarkURL,AV9BookmarkPageDescription});
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
               gxfirstwebparm = httpContext.GetFirstPar( "InBookmarkURL") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "InBookmarkURL") ;
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
         pa0U2( ) ;
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
         FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
         httpContext.writeText( " "+"class=\"form-horizontal FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.wwpbaseobjects.editbookmark", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16InBookmarkURL)),GXutil.URLEncode(GXutil.rtrim(AV9BookmarkPageDescription))}, new String[] {"InBookmarkURL","BookmarkPageDescription"}) +"\">") ;
         com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal FormNoBackgroundColor", true);
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
         com.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormNoBackgroundColor" : Form.getThemeClass())+"-fx");
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
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vI", GXutil.ltrim( localUtil.ntoc( AV29i, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vI", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV16InBookmarkURL", wcpOAV16InBookmarkURL);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9BookmarkPageDescription", wcpOAV9BookmarkPageDescription);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vI", GXutil.ltrim( localUtil.ntoc( AV29i, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vI", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
      com.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISEDIT", AV18IsEdit);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINBOOKMARKURL", AV16InBookmarkURL);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vBOOKMARKPAGEDESCRIPTION", AV9BookmarkPageDescription);
   }

   public void renderHtmlCloseForm0U2( )
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
      return "WWPBaseObjects.EditBookmark" ;
   }

   public String getPgmdesc( )
   {
      return "Add/Edit Bookmark" ;
   }

   public void wb0U0( )
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
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.wwpbaseobjects.editbookmark");
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
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "start", "top", " "+"data-gx-flex"+" ", "flex-direction:column;flex-wrap:wrap;", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "start", "top", "", "flex-grow:1;", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "PopupContentCell", "start", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtablebookmarkname_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 MergeLabelCell CellWidth_12_5", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblTextblockbookmarkname_Internalname, "Nombre", "", "", lblTextblockbookmarkname_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/EditBookmark.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 CellWidth_87_5", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, edtavBookmarkname_Internalname, "Bookmark Name", "col-sm-3 AttributeRealWidthLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'" + sPrefix + "',false,'',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavBookmarkname_Internalname, AV5BookmarkName, GXutil.rtrim( localUtil.format( AV5BookmarkName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,19);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBookmarkname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavBookmarkname_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/EditBookmark.htm");
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
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtablebookmarkurl_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 MergeLabelCell CellWidth_12_5", "start", "top", "", "", "div");
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblTextblockbookmarkurl_Internalname, "Dirección", "", "", lblTextblockbookmarkurl_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/EditBookmark.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 CellWidth_87_5", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, edtavBookmarkurl_Internalname, "Bookmark URL", "col-sm-3 AttributeRealWidthLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'" + sPrefix + "',false,'',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavBookmarkurl_Internalname, AV10BookmarkURL, GXutil.rtrim( localUtil.format( AV10BookmarkURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", AV10BookmarkURL, "_blank", "", "", edtavBookmarkurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavBookmarkurl_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "start", true, "", "HLP_WWPBaseObjects/EditBookmark.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellMarginTop10", "start", "top", "", "align-self:flex-end;", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "start", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", "Guardar", bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/EditBookmark.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtndel_Internalname, "", "REMOVE", bttBtndel_Jsonclick, 5, "REMOVE", "", StyleString, ClassString, bttBtndel_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DODEL\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/EditBookmark.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnusercancel_Internalname, "", "Cancelar", bttBtnusercancel_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e110u1_client"+"'", TempTags, "", 2, "HLP_WWPBaseObjects/EditBookmark.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
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

   public void start0U2( )
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
         Form.getMeta().addItem("description", "Add/Edit Bookmark", (short)(0)) ;
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
            strup0U0( ) ;
         }
      }
   }

   public void ws0U2( )
   {
      start0U2( ) ;
      evt0U2( ) ;
   }

   public void evt0U2( )
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
                              strup0U0( ) ;
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
                              strup0U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e120U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DODEL'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoDel' */
                                 e130U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0U0( ) ;
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
                                       /* Execute user event: Enter */
                                       e140U2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e150U2 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavBookmarkname_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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

   public void we0U2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0U2( ) ;
         }
      }
   }

   public void pa0U2( )
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
            GX_FocusControl = edtavBookmarkname_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
      rf0U2( ) ;
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

   public void rf0U2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e150U2 ();
         wb0U0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0U2( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vI", GXutil.ltrim( localUtil.ntoc( AV29i, (byte)(4), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vI", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
   }

   public void before_start_formulas( )
   {
      fix_multi_value_controls( ) ;
   }

   public void strup0U0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e120U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV16InBookmarkURL = httpContext.cgiGet( sPrefix+"wcpOAV16InBookmarkURL") ;
         wcpOAV9BookmarkPageDescription = httpContext.cgiGet( sPrefix+"wcpOAV9BookmarkPageDescription") ;
         /* Read variables values. */
         AV5BookmarkName = httpContext.cgiGet( edtavBookmarkname_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5BookmarkName", AV5BookmarkName);
         AV10BookmarkURL = httpContext.cgiGet( edtavBookmarkurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10BookmarkURL", AV10BookmarkURL);
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
      e120U2 ();
      if (returnInSub) return;
   }

   public void e120U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV10BookmarkURL = AV16InBookmarkURL ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10BookmarkURL", AV10BookmarkURL);
      AV5BookmarkName = AV9BookmarkPageDescription ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5BookmarkName", AV5BookmarkName);
      AV13GridStateCollection.fromxml(new com.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( "AppBookmarks"), null, null);
      AV29i = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29i), 4, 0));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vI", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
      AV31GXV1 = 1 ;
      while ( AV31GXV1 <= AV13GridStateCollection.size() )
      {
         AV14GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)((com.wwpbaseobjects.SdtGridStateCollection_Item)AV13GridStateCollection.elementAt(-1+AV31GXV1));
         if ( GXutil.strcmp(AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV10BookmarkURL) == 0 )
         {
            AV30ProgramDescription = AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Title() ;
            if (true) break;
         }
         else
         {
            AV29i = (short)(AV29i+1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29i), 4, 0));
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vI", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
         }
         AV31GXV1 = (int)(AV31GXV1+1) ;
      }
      if ( AV29i > AV13GridStateCollection.size() )
      {
         bttBtndel_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndel_Visible), 5, 0), true);
         Form.setCaption( "Crear marcador para esta página" );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Caption", Form.getCaption(), true);
      }
      else
      {
         Form.setCaption( "Editar marcador para esta página" );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Caption", Form.getCaption(), true);
      }
   }

   public void e130U2( )
   {
      /* 'DoDel' Routine */
      returnInSub = false ;
      AV13GridStateCollection.fromxml(new com.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( "AppBookmarks"), null, null);
      if ( AV29i <= AV13GridStateCollection.size() )
      {
         AV13GridStateCollection.removeItem(AV29i);
         new com.wwpbaseobjects.savemanagefiltersstate(remoteHandle, context).execute( "AppBookmarks", AV13GridStateCollection.toxml(false, true, "Items", "")) ;
         this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "Master_RefreshHeader", new Object[] {}, true);
         this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "WCPopup_Close", new Object[] {""}, false);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e140U2 ();
      if (returnInSub) return;
   }

   public void e140U2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV5BookmarkName = GXutil.trim( AV5BookmarkName) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5BookmarkName", AV5BookmarkName);
      if ( (GXutil.strcmp("", AV5BookmarkName)==0) )
      {
         httpContext.GX_msglist.addItem("Empty");
      }
      else
      {
         AV13GridStateCollection.fromxml(new com.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( "AppBookmarks"), null, null);
         AV19IsNameUnique = true ;
         AV32GXV2 = 1 ;
         while ( AV32GXV2 <= AV13GridStateCollection.size() )
         {
            AV14GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)((com.wwpbaseobjects.SdtGridStateCollection_Item)AV13GridStateCollection.elementAt(-1+AV32GXV2));
            if ( GXutil.strcmp(AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV10BookmarkURL) == 0 )
            {
               AV18IsEdit = true ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18IsEdit", AV18IsEdit);
            }
            AV32GXV2 = (int)(AV32GXV2+1) ;
         }
         if ( AV18IsEdit )
         {
            AV33GXV3 = 1 ;
            while ( AV33GXV3 <= AV13GridStateCollection.size() )
            {
               AV14GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)((com.wwpbaseobjects.SdtGridStateCollection_Item)AV13GridStateCollection.elementAt(-1+AV33GXV3));
               if ( GXutil.strcmp(AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV10BookmarkURL) == 0 )
               {
                  AV14GridStateCollectionItem.setgxTv_SdtGridStateCollection_Item_Title( AV5BookmarkName );
               }
               AV33GXV3 = (int)(AV33GXV3+1) ;
            }
         }
         else
         {
            AV14GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)new com.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
            AV14GridStateCollectionItem.setgxTv_SdtGridStateCollection_Item_Title( AV5BookmarkName );
            AV14GridStateCollectionItem.setgxTv_SdtGridStateCollection_Item_Gridstatexml( AV10BookmarkURL );
            AV13GridStateCollection.add(AV14GridStateCollectionItem, 1);
         }
         new com.wwpbaseobjects.savemanagefiltersstate(remoteHandle, context).execute( "AppBookmarks", AV13GridStateCollection.toxml(false, true, "Items", "")) ;
         this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "Master_RefreshHeader", new Object[] {}, true);
         this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "WCPopup_Close", new Object[] {""}, false);
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e150U2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV16InBookmarkURL = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16InBookmarkURL", AV16InBookmarkURL);
      AV9BookmarkPageDescription = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9BookmarkPageDescription", AV9BookmarkPageDescription);
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
      pa0U2( ) ;
      ws0U2( ) ;
      we0U2( ) ;
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
      sCtrlAV16InBookmarkURL = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV9BookmarkPageDescription = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0U2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\editbookmark", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0U2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV16InBookmarkURL = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16InBookmarkURL", AV16InBookmarkURL);
         AV9BookmarkPageDescription = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9BookmarkPageDescription", AV9BookmarkPageDescription);
      }
      wcpOAV16InBookmarkURL = httpContext.cgiGet( sPrefix+"wcpOAV16InBookmarkURL") ;
      wcpOAV9BookmarkPageDescription = httpContext.cgiGet( sPrefix+"wcpOAV9BookmarkPageDescription") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV16InBookmarkURL, wcpOAV16InBookmarkURL) != 0 ) || ( GXutil.strcmp(AV9BookmarkPageDescription, wcpOAV9BookmarkPageDescription) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV16InBookmarkURL = AV16InBookmarkURL ;
      wcpOAV9BookmarkPageDescription = AV9BookmarkPageDescription ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV16InBookmarkURL = httpContext.cgiGet( sPrefix+"AV16InBookmarkURL_CTRL") ;
      if ( GXutil.len( sCtrlAV16InBookmarkURL) > 0 )
      {
         AV16InBookmarkURL = httpContext.cgiGet( sCtrlAV16InBookmarkURL) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16InBookmarkURL", AV16InBookmarkURL);
      }
      else
      {
         AV16InBookmarkURL = httpContext.cgiGet( sPrefix+"AV16InBookmarkURL_PARM") ;
      }
      sCtrlAV9BookmarkPageDescription = httpContext.cgiGet( sPrefix+"AV9BookmarkPageDescription_CTRL") ;
      if ( GXutil.len( sCtrlAV9BookmarkPageDescription) > 0 )
      {
         AV9BookmarkPageDescription = httpContext.cgiGet( sCtrlAV9BookmarkPageDescription) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9BookmarkPageDescription", AV9BookmarkPageDescription);
      }
      else
      {
         AV9BookmarkPageDescription = httpContext.cgiGet( sPrefix+"AV9BookmarkPageDescription_PARM") ;
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
      pa0U2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0U2( ) ;
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
      ws0U2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16InBookmarkURL_PARM", AV16InBookmarkURL);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV16InBookmarkURL)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16InBookmarkURL_CTRL", GXutil.rtrim( sCtrlAV16InBookmarkURL));
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9BookmarkPageDescription_PARM", AV9BookmarkPageDescription);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV9BookmarkPageDescription)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9BookmarkPageDescription_CTRL", GXutil.rtrim( sCtrlAV9BookmarkPageDescription));
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
      we0U2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163223", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/editbookmark.js", "?202442617163224", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockbookmarkname_Internalname = sPrefix+"TEXTBLOCKBOOKMARKNAME" ;
      edtavBookmarkname_Internalname = sPrefix+"vBOOKMARKNAME" ;
      divUnnamedtablebookmarkname_Internalname = sPrefix+"UNNAMEDTABLEBOOKMARKNAME" ;
      lblTextblockbookmarkurl_Internalname = sPrefix+"TEXTBLOCKBOOKMARKURL" ;
      edtavBookmarkurl_Internalname = sPrefix+"vBOOKMARKURL" ;
      divUnnamedtablebookmarkurl_Internalname = sPrefix+"UNNAMEDTABLEBOOKMARKURL" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      bttBtndel_Internalname = sPrefix+"BTNDEL" ;
      bttBtnusercancel_Internalname = sPrefix+"BTNUSERCANCEL" ;
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
      bttBtndel_Visible = 1 ;
      edtavBookmarkurl_Jsonclick = "" ;
      edtavBookmarkurl_Enabled = 1 ;
      edtavBookmarkname_Jsonclick = "" ;
      edtavBookmarkname_Enabled = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Form.setCaption( "Add/Edit Bookmark" );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV29i',fld:'vI',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DODEL'","{handler:'e130U2',iparms:[{av:'AV29i',fld:'vI',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DODEL'",",oparms:[]}");
      setEventMetadata("'DOUSERCANCEL'","{handler:'e110U1',iparms:[]");
      setEventMetadata("'DOUSERCANCEL'",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e140U2',iparms:[{av:'AV5BookmarkName',fld:'vBOOKMARKNAME',pic:''},{av:'AV10BookmarkURL',fld:'vBOOKMARKURL',pic:''},{av:'AV18IsEdit',fld:'vISEDIT',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV5BookmarkName',fld:'vBOOKMARKNAME',pic:''},{av:'AV18IsEdit',fld:'vISEDIT',pic:''}]}");
      setEventMetadata("VALIDV_BOOKMARKURL","{handler:'validv_Bookmarkurl',iparms:[]");
      setEventMetadata("VALIDV_BOOKMARKURL",",oparms:[]}");
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
      wcpOAV16InBookmarkURL = "" ;
      wcpOAV9BookmarkPageDescription = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV16InBookmarkURL = "" ;
      AV9BookmarkPageDescription = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblockbookmarkname_Jsonclick = "" ;
      TempTags = "" ;
      AV5BookmarkName = "" ;
      lblTextblockbookmarkurl_Jsonclick = "" ;
      AV10BookmarkURL = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtndel_Jsonclick = "" ;
      bttBtnusercancel_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV13GridStateCollection = new GXBaseCollection<com.wwpbaseobjects.SdtGridStateCollection_Item>(com.wwpbaseobjects.SdtGridStateCollection_Item.class, "Item", "", remoteHandle);
      AV14GridStateCollectionItem = new com.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
      AV30ProgramDescription = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV16InBookmarkURL = "" ;
      sCtrlAV9BookmarkPageDescription = "" ;
      /* GeneXus formulas. */
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short AV29i ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int edtavBookmarkname_Enabled ;
   private int edtavBookmarkurl_Enabled ;
   private int bttBtndel_Visible ;
   private int AV31GXV1 ;
   private int AV32GXV2 ;
   private int AV33GXV3 ;
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
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String divUnnamedtablebookmarkname_Internalname ;
   private String lblTextblockbookmarkname_Internalname ;
   private String lblTextblockbookmarkname_Jsonclick ;
   private String edtavBookmarkname_Internalname ;
   private String TempTags ;
   private String edtavBookmarkname_Jsonclick ;
   private String divUnnamedtablebookmarkurl_Internalname ;
   private String lblTextblockbookmarkurl_Internalname ;
   private String lblTextblockbookmarkurl_Jsonclick ;
   private String edtavBookmarkurl_Internalname ;
   private String edtavBookmarkurl_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtndel_Internalname ;
   private String bttBtndel_Jsonclick ;
   private String bttBtnusercancel_Internalname ;
   private String bttBtnusercancel_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String sCtrlAV16InBookmarkURL ;
   private String sCtrlAV9BookmarkPageDescription ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV18IsEdit ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV19IsNameUnique ;
   private String wcpOAV16InBookmarkURL ;
   private String wcpOAV9BookmarkPageDescription ;
   private String AV16InBookmarkURL ;
   private String AV9BookmarkPageDescription ;
   private String AV5BookmarkName ;
   private String AV10BookmarkURL ;
   private String AV30ProgramDescription ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXBaseCollection<com.wwpbaseobjects.SdtGridStateCollection_Item> AV13GridStateCollection ;
   private com.wwpbaseobjects.SdtGridStateCollection_Item AV14GridStateCollectionItem ;
}

