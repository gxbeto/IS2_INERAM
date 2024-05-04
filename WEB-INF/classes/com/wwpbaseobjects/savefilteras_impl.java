package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class savefilteras_impl extends GXDataArea
{
   public savefilteras_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public savefilteras_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( savefilteras_impl.class ));
   }

   public savefilteras_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
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
         gxfirstwebparm = httpContext.GetFirstPar( "UserKey") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "UserKey") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "UserKey") ;
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
            AV15UserKey = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15UserKey", AV15UserKey);
            com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15UserKey, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV5GridStateKey = httpContext.GetPar( "GridStateKey") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5GridStateKey", AV5GridStateKey);
               com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGRIDSTATEKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5GridStateKey, ""))));
            }
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

   public byte executeStartEvent( )
   {
      pa0I2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0I2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      com.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), false);
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
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"FormNoBackgroundColor\" data-gx-class=\"FormNoBackgroundColor\" novalidate action=\""+formatLink("com.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15UserKey)),GXutil.URLEncode(GXutil.rtrim(AV5GridStateKey))}, new String[] {"UserKey","GridStateKey"}) +"\">") ;
      com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "FormNoBackgroundColor", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "vUSERKEY", AV15UserKey);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15UserKey, ""))));
      com.GxWebStd.gx_hidden_field( httpContext, "vGRIDSTATEKEY", AV5GridStateKey);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGRIDSTATEKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5GridStateKey, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV20CheckRequiredFieldsResult);
      com.GxWebStd.gx_hidden_field( httpContext, "vUSERKEY", AV15UserKey);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15UserKey, ""))));
      com.GxWebStd.gx_hidden_field( httpContext, "vGRIDSTATEKEY", AV5GridStateKey);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGRIDSTATEKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5GridStateKey, ""))));
      com.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_Stoponerror", GXutil.booltostr( Ucmessage_Stoponerror));
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
         com.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "FormNoBackgroundColor" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we0I2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0I2( ) ;
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
      return formatLink("com.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15UserKey)),GXutil.URLEncode(GXutil.rtrim(AV5GridStateKey))}, new String[] {"UserKey","GridStateKey"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SaveFilterAs" ;
   }

   public String getPgmdesc( )
   {
      return "Guardar filtro como..." ;
   }

   public void wb0I0( )
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
         wb_table1_2_0I2( true) ;
      }
      else
      {
         wb_table1_2_0I2( false) ;
      }
      return  ;
   }

   public void wb_table1_2_0I2e( boolean wbgen )
   {
      if ( wbgen )
      {
      }
      wbLoad = true ;
   }

   public void start0I2( )
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
      Form.getMeta().addItem("description", "Guardar filtro como...", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0I0( ) ;
   }

   public void ws0I2( )
   {
      start0I2( ) ;
      evt0I2( ) ;
   }

   public void evt0I2( )
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
                           e110I2 ();
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
                                 e120I2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e130I2 ();
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

   public void we0I2( )
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

   public void pa0I2( )
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
            GX_FocusControl = edtavFiltername_Internalname ;
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
      rf0I2( ) ;
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

   public void rf0I2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e130I2 ();
         wb0I0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0I2( )
   {
   }

   public void before_start_formulas( )
   {
      fix_multi_value_controls( ) ;
   }

   public void strup0I0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Ucmessage_Stoponerror = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_Stoponerror")) ;
         /* Read variables values. */
         AV8FilterName = httpContext.cgiGet( edtavFiltername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8FilterName", AV8FilterName);
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
      e110I2 ();
      if (returnInSub) return;
   }

   public void e110I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      tblLayoutmaintable_Class = tblLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, tblLayoutmaintable_Internalname, "Class", tblLayoutmaintable_Class, true);
   }

   public void S112( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV20CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20CheckRequiredFieldsResult", AV20CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV8FilterName)==0) )
      {
         httpContext.GX_msglist.addItem(new com.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( "%1 es requerido.", "Nombre", "", "", "", "", "", "", "", ""), "error", edtavFiltername_Internalname, "true", ""));
         AV20CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20CheckRequiredFieldsResult", AV20CheckRequiredFieldsResult);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e120I2 ();
      if (returnInSub) return;
   }

   public void e120I2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV8FilterName = GXutil.trim( AV8FilterName) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8FilterName", AV8FilterName);
      /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
      S112 ();
      if (returnInSub) return;
      if ( AV20CheckRequiredFieldsResult )
      {
         AV10GridStateCollection.fromxml(new com.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( AV15UserKey), null, null);
         AV12IsNameUnique = true ;
         AV21GXV1 = 1 ;
         while ( AV21GXV1 <= AV10GridStateCollection.size() )
         {
            AV11GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)((com.wwpbaseobjects.SdtGridStateCollection_Item)AV10GridStateCollection.elementAt(-1+AV21GXV1));
            if ( GXutil.strcmp(AV11GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Title(), AV8FilterName) == 0 )
            {
               AV12IsNameUnique = false ;
            }
            AV21GXV1 = (int)(AV21GXV1+1) ;
         }
         if ( AV12IsNameUnique )
         {
            AV11GridStateCollectionItem = (com.wwpbaseobjects.SdtGridStateCollection_Item)new com.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
            AV11GridStateCollectionItem.setgxTv_SdtGridStateCollection_Item_Title( AV8FilterName );
            AV11GridStateCollectionItem.setgxTv_SdtGridStateCollection_Item_Gridstatexml( AV6Session.getValue(AV5GridStateKey) );
            AV10GridStateCollection.add(AV11GridStateCollectionItem, 1);
            new com.wwpbaseobjects.savemanagefiltersstate(remoteHandle, context).execute( AV15UserKey, AV10GridStateCollection.toxml(false, true, "Items", "")) ;
            httpContext.setWebReturnParms(new Object[] {});
            httpContext.setWebReturnParmsMetadata(new Object[] {});
            httpContext.wjLocDisableFrm = (byte)(1) ;
            httpContext.nUserReturn = (byte)(1) ;
            returnInSub = true;
            if (true) return;
         }
         else
         {
            httpContext.GX_msglist.addItem(new com.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", "Name must be unique", "error", edtavFiltername_Internalname, "true", ""));
         }
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e130I2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_2_0I2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblLayoutmaintable_Internalname, tblLayoutmaintable_Internalname, "", tblLayoutmaintable_Class, 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_5_0I2( true) ;
      }
      else
      {
         wb_table2_5_0I2( false) ;
      }
      return  ;
   }

   public void wb_table2_5_0I2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_2_0I2e( true) ;
      }
      else
      {
         wb_table1_2_0I2e( false) ;
      }
   }

   public void wb_table2_5_0I2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         sStyleString += " height: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(150), 10, 0) + "px" + ";" ;
         sStyleString += " width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(380), 10, 0) + "px" + ";" ;
         com.GxWebStd.gx_table_start( httpContext, tblTablemain_Internalname, tblTablemain_Internalname, "", "TableMain", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\" class='PopupContentCell'>") ;
         wb_table3_8_0I2( true) ;
      }
      else
      {
         wb_table3_8_0I2( false) ;
      }
      return  ;
   }

   public void wb_table3_8_0I2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divActiongroup_actions_Internalname, 1, 0, "px", 0, "px", "ActionGroupRightHTML", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'',0)\"" ;
         ClassString = "btn btn-default Button" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", "Guardar", bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/SaveFilterAs.htm");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
         ClassString = "btn btn-default BtnDefault" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", "Cancelar", bttBtncancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects/SaveFilterAs.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucUcmessage.setProperty("StopOnError", Ucmessage_Stoponerror);
         ucUcmessage.render(context, "dvelop.dvmessage", Ucmessage_Internalname, "UCMESSAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_5_0I2e( true) ;
      }
      else
      {
         wb_table2_5_0I2e( false) ;
      }
   }

   public void wb_table3_8_0I2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblTablecontent_Internalname, tblTablecontent_Internalname, "", "TableContent", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataDescriptionCell'>") ;
         /* Text block */
         com.GxWebStd.gx_label_ctrl( httpContext, lblTextblockfiltername_Internalname, "Nombre", "", "", lblTextblockfiltername_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects/SaveFilterAs.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='RequiredDataContentCell'>") ;
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 13,'',false,'',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavFiltername_Internalname, AV8FilterName, GXutil.rtrim( localUtil.format( AV8FilterName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,13);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFiltername_Jsonclick, 0, "AttributeManageFilters", "", "", "", "", 1, 1, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "start", true, "", "HLP_WWPBaseObjects/SaveFilterAs.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_8_0I2e( true) ;
      }
      else
      {
         wb_table3_8_0I2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV15UserKey = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15UserKey", AV15UserKey);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15UserKey, ""))));
      AV5GridStateKey = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5GridStateKey", AV5GridStateKey);
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGRIDSTATEKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5GridStateKey, ""))));
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
      pa0I2( ) ;
      ws0I2( ) ;
      we0I2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617165550", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/savefilteras.js", "?202442617165550", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockfiltername_Internalname = "TEXTBLOCKFILTERNAME" ;
      edtavFiltername_Internalname = "vFILTERNAME" ;
      tblTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      divActiongroup_actions_Internalname = "ACTIONGROUP_ACTIONS" ;
      Ucmessage_Internalname = "UCMESSAGE" ;
      tblTablemain_Internalname = "TABLEMAIN" ;
      tblLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
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
      edtavFiltername_Jsonclick = "" ;
      tblLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Ucmessage_Stoponerror = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Guardar filtro como..." );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV15UserKey',fld:'vUSERKEY',pic:'',hsh:true},{av:'AV5GridStateKey',fld:'vGRIDSTATEKEY',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e120I2',iparms:[{av:'AV8FilterName',fld:'vFILTERNAME',pic:''},{av:'AV20CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV15UserKey',fld:'vUSERKEY',pic:'',hsh:true},{av:'AV5GridStateKey',fld:'vGRIDSTATEKEY',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV8FilterName',fld:'vFILTERNAME',pic:''},{av:'AV20CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
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
      wcpOAV15UserKey = "" ;
      wcpOAV5GridStateKey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV15UserKey = "" ;
      AV5GridStateKey = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV8FilterName = "" ;
      AV10GridStateCollection = new GXBaseCollection<com.wwpbaseobjects.SdtGridStateCollection_Item>(com.wwpbaseobjects.SdtGridStateCollection_Item.class, "Item", "", remoteHandle);
      AV11GridStateCollectionItem = new com.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
      AV6Session = httpContext.getWebSession();
      sStyleString = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      ucUcmessage = new com.genexus.webpanels.GXUserControl();
      lblTextblockfiltername_Jsonclick = "" ;
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
   private int AV21GXV1 ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavFiltername_Internalname ;
   private String tblLayoutmaintable_Class ;
   private String tblLayoutmaintable_Internalname ;
   private String sStyleString ;
   private String tblTablemain_Internalname ;
   private String divActiongroup_actions_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String Ucmessage_Internalname ;
   private String tblTablecontent_Internalname ;
   private String lblTextblockfiltername_Internalname ;
   private String lblTextblockfiltername_Jsonclick ;
   private String edtavFiltername_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV20CheckRequiredFieldsResult ;
   private boolean Ucmessage_Stoponerror ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV12IsNameUnique ;
   private String wcpOAV15UserKey ;
   private String wcpOAV5GridStateKey ;
   private String AV15UserKey ;
   private String AV5GridStateKey ;
   private String AV8FilterName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV6Session ;
   private com.genexus.webpanels.GXUserControl ucUcmessage ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.wwpbaseobjects.SdtGridStateCollection_Item> AV10GridStateCollection ;
   private com.wwpbaseobjects.SdtGridStateCollection_Item AV11GridStateCollectionItem ;
}

