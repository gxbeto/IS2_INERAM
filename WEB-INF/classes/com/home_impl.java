package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class home_impl extends GXDataArea
{
   public home_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public home_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( home_impl.class ));
   }

   public home_impl( int remoteHandle ,
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
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridhomemodulessdts_newrow_invoke( )
   {
      nRC_GXsfl_12 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_12"))) ;
      nGXsfl_12_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_12_idx"))) ;
      sGXsfl_12_idx = httpContext.GetPar( "sGXsfl_12_idx") ;
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
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV6HomeModulesSDT);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridhomemodulessdts_refresh( AV6HomeModulesSDT) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridhomemodulessdts_refresh_invoke */
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
      pa072( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start072( ) ;
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
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
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.home", new String[] {}, new String[] {}) +"\">") ;
         com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vHOMEMODULESSDT", AV6HomeModulesSDT);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vHOMEMODULESSDT", AV6HomeModulesSDT);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHOMEMODULESSDT", getSecureSignedToken( "", AV6HomeModulesSDT));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_12", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_12, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vHOMEMODULESSDT", AV6HomeModulesSDT);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vHOMEMODULESSDT", AV6HomeModulesSDT);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHOMEMODULESSDT", getSecureSignedToken( "", AV6HomeModulesSDT));
      com.GxWebStd.gx_hidden_field( httpContext, "subGridhomemodulessdts_Recordcount", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Recordcount, (byte)(5), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDHOMEMODULESSDTS_Class", GXutil.rtrim( subGridhomemodulessdts_Class));
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDHOMEMODULESSDTS_Flexwrap", GXutil.rtrim( subGridhomemodulessdts_Flexwrap));
      com.GxWebStd.gx_hidden_field( httpContext, "GRIDHOMEMODULESSDTS_Justifycontent", GXutil.rtrim( subGridhomemodulessdts_Justifycontent));
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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
         com.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we072( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt072( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.home", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Home" ;
   }

   public String getPgmdesc( )
   {
      return "Inicio" ;
   }

   public void wb070( )
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
            AV7GXV1 = nGXsfl_12_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridhomemodulessdtsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridhomemodulessdts", GridhomemodulessdtsContainer, subGridhomemodulessdts_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "GridhomemodulessdtsContainerData", GridhomemodulessdtsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "GridhomemodulessdtsContainerData"+"V", GridhomemodulessdtsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridhomemodulessdtsContainerData"+"V"+"\" value='"+GridhomemodulessdtsContainer.GridValuesHidden()+"'/>") ;
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
               AV7GXV1 = nGXsfl_12_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridhomemodulessdtsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridhomemodulessdts", GridhomemodulessdtsContainer, subGridhomemodulessdts_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "GridhomemodulessdtsContainerData", GridhomemodulessdtsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "GridhomemodulessdtsContainerData"+"V", GridhomemodulessdtsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridhomemodulessdtsContainerData"+"V"+"\" value='"+GridhomemodulessdtsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start072( )
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
      Form.getMeta().addItem("description", "Inicio", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup070( ) ;
   }

   public void ws072( )
   {
      start072( ) ;
      evt072( ) ;
   }

   public void evt072( )
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
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 24), "GRIDHOMEMODULESSDTS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_12_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_122( ) ;
                           AV5OptionLink = httpContext.cgiGet( edtavOptionlink_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavOptionlink_Internalname, AV5OptionLink);
                           com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPTIONLINK"+"_"+sGXsfl_12_idx, getSecureSignedToken( sGXsfl_12_idx, GXutil.rtrim( localUtil.format( AV5OptionLink, ""))));
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11072 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDHOMEMODULESSDTS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e12072 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
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

   public void we072( )
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

   public void pa072( )
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

   public void gxgrgridhomemodulessdts_refresh( GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> AV6HomeModulesSDT )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDHOMEMODULESSDTS_nCurrentRecord = 0 ;
      rf072( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridhomemodulessdts_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPTIONLINK", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5OptionLink, ""))));
      com.GxWebStd.gx_hidden_field( httpContext, "vOPTIONLINK", AV5OptionLink);
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
      rf072( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavOptionlink_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOptionlink_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Enabled), 5, 0), !bGXsfl_12_Refreshing);
   }

   public void rf072( )
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
      GridhomemodulessdtsContainer.AddObjectProperty("CmpContext", "");
      GridhomemodulessdtsContainer.AddObjectProperty("InMasterPage", "false");
      GridhomemodulessdtsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleHomeModulesBig"));
      GridhomemodulessdtsContainer.AddObjectProperty("Class", "FreeStyleHomeModulesBig");
      GridhomemodulessdtsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridhomemodulessdtsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridhomemodulessdtsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridhomemodulessdtsContainer.setPageSize( subgridhomemodulessdts_fnc_recordsperpage( ) );
      if ( subGridhomemodulessdts_Islastpage != 0 )
      {
         GRIDHOMEMODULESSDTS_nFirstRecordOnPage = (long)(subgridhomemodulessdts_fnc_recordcount( )-subgridhomemodulessdts_fnc_recordsperpage( )) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRIDHOMEMODULESSDTS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDHOMEMODULESSDTS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("GRIDHOMEMODULESSDTS_nFirstRecordOnPage", GRIDHOMEMODULESSDTS_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_122( ) ;
         e12072 ();
         wbEnd = (short)(12) ;
         wb070( ) ;
      }
      bGXsfl_12_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes072( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vHOMEMODULESSDT", AV6HomeModulesSDT);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vHOMEMODULESSDT", AV6HomeModulesSDT);
      }
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHOMEMODULESSDT", getSecureSignedToken( "", AV6HomeModulesSDT));
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPTIONLINK"+"_"+sGXsfl_12_idx, getSecureSignedToken( sGXsfl_12_idx, GXutil.rtrim( localUtil.format( AV5OptionLink, ""))));
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
      edtavOptionlink_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOptionlink_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup070( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11072 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_12 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_12"), ",", ".")) ;
         subGridhomemodulessdts_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( "subGridhomemodulessdts_Recordcount"), ",", ".")) ;
         subGridhomemodulessdts_Class = httpContext.cgiGet( "GRIDHOMEMODULESSDTS_Class") ;
         subGridhomemodulessdts_Flexwrap = httpContext.cgiGet( "GRIDHOMEMODULESSDTS_Flexwrap") ;
         subGridhomemodulessdts_Justifycontent = httpContext.cgiGet( "GRIDHOMEMODULESSDTS_Justifycontent") ;
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
      e11072 ();
      if (returnInSub) return;
   }

   public void e11072( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 = AV6HomeModulesSDT ;
      GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2[0] = GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 ;
      new com.wwpbaseobjects.getsomehomemodulessample(remoteHandle, context).execute( GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2) ;
      GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 = GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2[0] ;
      AV6HomeModulesSDT = GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 ;
      if ( 1 == 2 )
      {
         callWebObject(formatLink("com.protocoloconsultar", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
         callWebObject(formatLink("com.protocolow2", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
         callWebObject(formatLink("com.protocolow3", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
         callWebObject(formatLink("com.protocoloww", new String[] {}, new String[] {"SelectedProtID"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
   }

   private void e12072( )
   {
      /* Gridhomemodulessdts_Load Routine */
      returnInSub = false ;
      AV7GXV1 = 1 ;
      while ( AV7GXV1 <= AV6HomeModulesSDT.size() )
      {
         AV6HomeModulesSDT.currentItem( ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)AV6HomeModulesSDT.elementAt(-1+AV7GXV1)) );
         lblHomemodulesbig_optionicon_Caption = GXutil.format( "<i class='HomeModulesBigIcon %1' style='font-size: 55px'></i>", ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV6HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass(), "", "", "", "", "", "", "", "") ;
         lblHomemodulesbig_title_Caption = ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV6HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle() ;
         lblHomemodulesbig_description_Caption = ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV6HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription() ;
         AV5OptionLink = ((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(AV6HomeModulesSDT.currentItem())).getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavOptionlink_Internalname, AV5OptionLink);
         com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPTIONLINK"+"_"+sGXsfl_12_idx, getSecureSignedToken( sGXsfl_12_idx, GXutil.rtrim( localUtil.format( AV5OptionLink, ""))));
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
         AV7GXV1 = (int)(AV7GXV1+1) ;
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
      pa072( ) ;
      ws072( ) ;
      we072( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20245320274797", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages.spa.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("home.js", "?20245320274797", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_122( )
   {
      lblHomemodulesbig_optionicon_Internalname = "HOMEMODULESBIG_OPTIONICON_"+sGXsfl_12_idx ;
      lblHomemodulesbig_title_Internalname = "HOMEMODULESBIG_TITLE_"+sGXsfl_12_idx ;
      lblHomemodulesbig_description_Internalname = "HOMEMODULESBIG_DESCRIPTION_"+sGXsfl_12_idx ;
      edtavOptionlink_Internalname = "vOPTIONLINK_"+sGXsfl_12_idx ;
   }

   public void subsflControlProps_fel_122( )
   {
      lblHomemodulesbig_optionicon_Internalname = "HOMEMODULESBIG_OPTIONICON_"+sGXsfl_12_fel_idx ;
      lblHomemodulesbig_title_Internalname = "HOMEMODULESBIG_TITLE_"+sGXsfl_12_fel_idx ;
      lblHomemodulesbig_description_Internalname = "HOMEMODULESBIG_DESCRIPTION_"+sGXsfl_12_fel_idx ;
      edtavOptionlink_Internalname = "vOPTIONLINK_"+sGXsfl_12_fel_idx ;
   }

   public void sendrow_122( )
   {
      subsflControlProps_122( ) ;
      wb070( ) ;
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
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divMainlayout_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","CellMarginTop","start","top"," "+"data-gx-flex"+" ","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","HomeModulesBigCell","start","top","","flex-grow:1;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divHomemodulesbig_tablemodule_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","HomeModulesBig","start","top"," "+"data-gx-flex"+" ","flex-direction:column;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","HomeModulesBigIconCell","start","top","","flex-grow:1;align-self:center;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Text block */
      GridhomemodulessdtsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblHomemodulesbig_optionicon_Internalname,lblHomemodulesbig_optionicon_Caption,"","",lblHomemodulesbig_optionicon_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","HomeModulesBigTitleCell","start","top","","flex-grow:1;align-self:center;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Text block */
      GridhomemodulessdtsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblHomemodulesbig_title_Internalname,lblHomemodulesbig_title_Caption,"","",lblHomemodulesbig_title_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","AttributeHomeModulesBigTitle",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      GridhomemodulessdtsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","HomeModulesBigDescriptionCell","start","top","","flex-grow:1;align-self:center;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Text block */
      GridhomemodulessdtsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblHomemodulesbig_description_Internalname,lblHomemodulesbig_description_Caption,"","",lblHomemodulesbig_description_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","AttributeHomeModulesBigDescription",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
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
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Invisible","start","top","","flex-grow:1;","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group gx-default-form-group","start","top",""+" data-gx-for=\""+edtavOptionlink_Internalname+"\"","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Div Control */
      GridhomemodulessdtsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(75),"%",Integer.valueOf(0),"px","gx-form-item gx-attribute","start","top","","","div"});
      GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridhomemodulessdtsRow.AddRenderProperties(GridhomemodulessdtsColumn);
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      GridhomemodulessdtsRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavOptionlink_Internalname,AV5OptionLink,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavOptionlink_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0),""});
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
      send_integrity_lvl_hashes072( ) ;
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
         httpContext.writeText( "<div id=\""+"GridhomemodulessdtsContainer"+"DivS\" data-gxgridid=\"12\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGridhomemodulessdts_Internalname, subGridhomemodulessdts_Internalname, "", "FreeStyleHomeModulesBig", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridhomemodulessdtsContainer.AddObjectProperty("GridName", "Gridhomemodulessdts");
      }
      else
      {
         GridhomemodulessdtsContainer.AddObjectProperty("GridName", "Gridhomemodulessdts");
         GridhomemodulessdtsContainer.AddObjectProperty("Header", subGridhomemodulessdts_Header);
         GridhomemodulessdtsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleHomeModulesBig"));
         GridhomemodulessdtsContainer.AddObjectProperty("Class", "FreeStyleHomeModulesBig");
         GridhomemodulessdtsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridhomemodulessdts_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridhomemodulessdtsContainer.AddObjectProperty("CmpContext", "");
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
         GridhomemodulessdtsColumn.AddObjectProperty("Value", lblHomemodulesbig_optionicon_Caption);
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsColumn.AddObjectProperty("Value", lblHomemodulesbig_title_Caption);
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsColumn.AddObjectProperty("Value", lblHomemodulesbig_description_Caption);
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsContainer.AddColumnProperties(GridhomemodulessdtsColumn);
         GridhomemodulessdtsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridhomemodulessdtsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( AV5OptionLink));
         GridhomemodulessdtsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavOptionlink_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      lblHomemodulesbig_optionicon_Internalname = "HOMEMODULESBIG_OPTIONICON" ;
      lblHomemodulesbig_title_Internalname = "HOMEMODULESBIG_TITLE" ;
      lblHomemodulesbig_description_Internalname = "HOMEMODULESBIG_DESCRIPTION" ;
      divHomemodulesbig_tablemodule_Internalname = "HOMEMODULESBIG_TABLEMODULE" ;
      edtavOptionlink_Internalname = "vOPTIONLINK" ;
      divMainlayout_Internalname = "MAINLAYOUT" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridhomemodulessdts_Internalname = "GRIDHOMEMODULESSDTS" ;
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
      subGridhomemodulessdts_Allowcollapsing = (byte)(0) ;
      lblHomemodulesbig_description_Caption = "Description" ;
      lblHomemodulesbig_title_Caption = "Home" ;
      lblHomemodulesbig_optionicon_Caption = "<i class='HomeModulesBigIcon  fas fa-home' style='font-size: 55px'></i>" ;
      edtavOptionlink_Enabled = 0 ;
      lblHomemodulesbig_description_Caption = "Description" ;
      lblHomemodulesbig_title_Caption = "Home" ;
      lblHomemodulesbig_optionicon_Caption = "<i class='HomeModulesBigIcon  fas fa-home' style='font-size: 55px'></i>" ;
      subGridhomemodulessdts_Backcolorstyle = (byte)(0) ;
      subGridhomemodulessdts_Justifycontent = "center" ;
      subGridhomemodulessdts_Flexwrap = "wrap" ;
      subGridhomemodulessdts_Class = "FreeStyleHomeModulesBig" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Inicio" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDHOMEMODULESSDTS_nFirstRecordOnPage'},{av:'GRIDHOMEMODULESSDTS_nEOF'},{av:'AV6HomeModulesSDT',fld:'vHOMEMODULESSDT',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDHOMEMODULESSDTS.LOAD","{handler:'e12072',iparms:[{av:'AV6HomeModulesSDT',fld:'vHOMEMODULESSDT',pic:'',hsh:true}]");
      setEventMetadata("GRIDHOMEMODULESSDTS.LOAD",",oparms:[{av:'lblHomemodulesbig_optionicon_Caption',ctrl:'HOMEMODULESBIG_OPTIONICON',prop:'Caption'},{av:'lblHomemodulesbig_title_Caption',ctrl:'HOMEMODULESBIG_TITLE',prop:'Caption'},{av:'lblHomemodulesbig_description_Caption',ctrl:'HOMEMODULESBIG_DESCRIPTION',prop:'Caption'},{av:'AV5OptionLink',fld:'vOPTIONLINK',pic:'',hsh:true}]}");
      setEventMetadata("NULL","{handler:'validv_Optionlink',iparms:[]");
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
      AV6HomeModulesSDT = new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>(com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem.class, "HomeModulesSDTItem", "Gregory", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      GridhomemodulessdtsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV5OptionLink = "" ;
      GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 = new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>(com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem.class, "HomeModulesSDTItem", "Gregory", remoteHandle);
      GridhomemodulessdtsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridhomemodulessdts_Linesclass = "" ;
      GridhomemodulessdtsColumn = new com.genexus.webpanels.GXWebColumn();
      lblHomemodulesbig_optionicon_Jsonclick = "" ;
      lblHomemodulesbig_title_Jsonclick = "" ;
      lblHomemodulesbig_description_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      subGridhomemodulessdts_Header = "" ;
      /* GeneXus formulas. */
      edtavOptionlink_Enabled = 0 ;
      initializeGenerics();
   }

   @SuppressWarnings("unchecked")
   private void initializeGenerics( )
   {
      GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2 = new GXBaseCollection[1] ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGridhomemodulessdts_Backcolorstyle ;
   private byte subGridhomemodulessdts_Backstyle ;
   private byte subGridhomemodulessdts_Allowselection ;
   private byte subGridhomemodulessdts_Allowhovering ;
   private byte subGridhomemodulessdts_Allowcollapsing ;
   private byte subGridhomemodulessdts_Collapsed ;
   private byte GRIDHOMEMODULESSDTS_nEOF ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int nRC_GXsfl_12 ;
   private int subGridhomemodulessdts_Recordcount ;
   private int nGXsfl_12_idx=1 ;
   private int AV7GXV1 ;
   private int subGridhomemodulessdts_Islastpage ;
   private int edtavOptionlink_Enabled ;
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
   private String sGXsfl_12_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String subGridhomemodulessdts_Class ;
   private String subGridhomemodulessdts_Flexwrap ;
   private String subGridhomemodulessdts_Justifycontent ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTablecontent_Internalname ;
   private String sStyleString ;
   private String subGridhomemodulessdts_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavOptionlink_Internalname ;
   private String lblHomemodulesbig_optionicon_Caption ;
   private String lblHomemodulesbig_title_Caption ;
   private String lblHomemodulesbig_description_Caption ;
   private String lblHomemodulesbig_optionicon_Internalname ;
   private String lblHomemodulesbig_title_Internalname ;
   private String lblHomemodulesbig_description_Internalname ;
   private String sGXsfl_12_fel_idx="0001" ;
   private String subGridhomemodulessdts_Linesclass ;
   private String divMainlayout_Internalname ;
   private String divHomemodulesbig_tablemodule_Internalname ;
   private String lblHomemodulesbig_optionicon_Jsonclick ;
   private String lblHomemodulesbig_title_Jsonclick ;
   private String lblHomemodulesbig_description_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String subGridhomemodulessdts_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_12_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV5OptionLink ;
   private com.genexus.webpanels.GXWebGrid GridhomemodulessdtsContainer ;
   private com.genexus.webpanels.GXWebRow GridhomemodulessdtsRow ;
   private com.genexus.webpanels.GXWebColumn GridhomemodulessdtsColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> AV6HomeModulesSDT ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2[] ;
}

