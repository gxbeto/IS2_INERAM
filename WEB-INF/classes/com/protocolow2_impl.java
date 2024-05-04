package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class protocolow2_impl extends GXDataArea
{
   public protocolow2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public protocolow2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( protocolow2_impl.class ));
   }

   public protocolow2_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynavEnfid = new HTMLChoice();
      dynavCntdid = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid2") == 0 )
         {
            gxnrgrid2_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid2") == 0 )
         {
            gxgrgrid2_refresh_invoke( ) ;
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

   public void gxnrgrid2_newrow_invoke( )
   {
      nRC_GXsfl_31 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_31"))) ;
      nGXsfl_31_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_31_idx"))) ;
      sGXsfl_31_idx = httpContext.GetPar( "sGXsfl_31_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid2_newrow( ) ;
      /* End function gxnrGrid2_newrow_invoke */
   }

   public void gxgrgrid2_refresh_invoke( )
   {
      subGrid2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid2_Rows"))) ;
      A1EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
      n1EnfID = false ;
      dynavEnfid.fromJSonString( httpContext.GetNextPar( ));
      AV24EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
      A25ProtID = GXutil.lval( httpContext.GetPar( "ProtID")) ;
      A24CntdDesc = httpContext.GetPar( "CntdDesc") ;
      dynavCntdid.fromJSonString( httpContext.GetNextPar( ));
      AV40CntdID = GXutil.lval( httpContext.GetPar( "CntdID")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV24EnfID, A25ProtID, A24CntdDesc, AV40CntdID) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid2_refresh_invoke */
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
      pa132( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start132( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.protocolow2", new String[] {}, new String[] {}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_31", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_31, (byte)(8), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "vGRID2PAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV51Grid2PageCount, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "vGRID2APPLIEDFILTERS", AV52Grid2AppliedFilters);
      com.GxWebStd.gx_hidden_field( httpContext, "ENFID", GXutil.ltrim( localUtil.ntoc( A1EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "PROTID", GXutil.ltrim( localUtil.ntoc( A25ProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "CNTDDESC", GXutil.rtrim( A24CntdDesc));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID2_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nEOF", GXutil.ltrim( localUtil.ntoc( GRID2_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "subGrid2_Recordcount", GXutil.ltrim( localUtil.ntoc( subGrid2_Recordcount, (byte)(5), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_Rows", GXutil.ltrim( localUtil.ntoc( subGrid2_Rows, (byte)(6), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Class", GXutil.rtrim( Grid2paginationbar_Class));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Showfirst", GXutil.booltostr( Grid2paginationbar_Showfirst));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Showprevious", GXutil.booltostr( Grid2paginationbar_Showprevious));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Shownext", GXutil.booltostr( Grid2paginationbar_Shownext));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Showlast", GXutil.booltostr( Grid2paginationbar_Showlast));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Grid2paginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Grid2paginationbar_Pagingbuttonsposition));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Grid2paginationbar_Pagingcaptionposition));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Emptygridclass", GXutil.rtrim( Grid2paginationbar_Emptygridclass));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Grid2paginationbar_Rowsperpageselector));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Grid2paginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Grid2paginationbar_Rowsperpageoptions));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Previous", GXutil.rtrim( Grid2paginationbar_Previous));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Next", GXutil.rtrim( Grid2paginationbar_Next));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Caption", GXutil.rtrim( Grid2paginationbar_Caption));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Grid2paginationbar_Emptygridcaption));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Grid2paginationbar_Rowsperpagecaption));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid2_empowerer_Gridinternalname));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Selectedpage", GXutil.rtrim( Grid2paginationbar_Selectedpage));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Grid2paginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Selectedpage", GXutil.rtrim( Grid2paginationbar_Selectedpage));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2PAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Grid2paginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
         we132( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt132( ) ;
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
      return formatLink("com.protocolow2", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Protocolow2" ;
   }

   public String getPgmdesc( )
   {
      return "Protocolo: Contenidos " ;
   }

   public void wb130( )
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
         com.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+dynavEnfid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, dynavEnfid.getInternalname(), "Seleccione una enfermedad", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'" + sGXsfl_31_idx + "',0)\"" ;
         /* ComboBox */
         com.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEnfid, dynavEnfid.getInternalname(), GXutil.trim( GXutil.str( AV24EnfID, 10, 0)), 1, dynavEnfid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEnfid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,17);\"", "", true, (byte)(0), "HLP_Protocolow2.htm");
         dynavEnfid.setValue( GXutil.trim( GXutil.str( AV24EnfID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEnfid.getInternalname(), "Values", dynavEnfid.ToJavascriptSource(), true);
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+dynavCntdid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, dynavCntdid.getInternalname(), "Seleccione un tipo de contendio", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'" + sGXsfl_31_idx + "',0)\"" ;
         /* ComboBox */
         com.GxWebStd.gx_combobox_ctrl1( httpContext, dynavCntdid, dynavCntdid.getInternalname(), GXutil.trim( GXutil.str( AV40CntdID, 10, 0)), 1, dynavCntdid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavCntdid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_Protocolow2.htm");
         dynavCntdid.setValue( GXutil.trim( GXutil.str( AV40CntdID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavCntdid.getInternalname(), "Values", dynavCntdid.ToJavascriptSource(), true);
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "end", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnagregar_contenido_Internalname, "gx.evt.setGridEvt("+GXutil.str( 31, 2, 0)+","+"null"+");", "Agregar", bttBtnagregar_contenido_Jsonclick, 5, "Agregar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOAGREGAR_CONTENIDO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Protocolow2.htm");
         com.GxWebStd.gx_div_end( httpContext, "end", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divGrid2tablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /*  Grid Control  */
         Grid2Container.SetWrapped(nGXWrapped);
         startgridcontrol31( ) ;
      }
      if ( wbEnd == 31 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_31 = (int)(nGXsfl_31_idx-1) ;
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Grid2Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid2", Grid2Container, subGrid2_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData", Grid2Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData"+"V", Grid2Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid2ContainerData"+"V"+"\" value='"+Grid2Container.GridValuesHidden()+"'/>") ;
            }
         }
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* User Defined Control */
         ucGrid2paginationbar.setProperty("Class", Grid2paginationbar_Class);
         ucGrid2paginationbar.setProperty("ShowFirst", Grid2paginationbar_Showfirst);
         ucGrid2paginationbar.setProperty("ShowPrevious", Grid2paginationbar_Showprevious);
         ucGrid2paginationbar.setProperty("ShowNext", Grid2paginationbar_Shownext);
         ucGrid2paginationbar.setProperty("ShowLast", Grid2paginationbar_Showlast);
         ucGrid2paginationbar.setProperty("PagesToShow", Grid2paginationbar_Pagestoshow);
         ucGrid2paginationbar.setProperty("PagingButtonsPosition", Grid2paginationbar_Pagingbuttonsposition);
         ucGrid2paginationbar.setProperty("PagingCaptionPosition", Grid2paginationbar_Pagingcaptionposition);
         ucGrid2paginationbar.setProperty("EmptyGridClass", Grid2paginationbar_Emptygridclass);
         ucGrid2paginationbar.setProperty("RowsPerPageSelector", Grid2paginationbar_Rowsperpageselector);
         ucGrid2paginationbar.setProperty("RowsPerPageOptions", Grid2paginationbar_Rowsperpageoptions);
         ucGrid2paginationbar.setProperty("Previous", Grid2paginationbar_Previous);
         ucGrid2paginationbar.setProperty("Next", Grid2paginationbar_Next);
         ucGrid2paginationbar.setProperty("Caption", Grid2paginationbar_Caption);
         ucGrid2paginationbar.setProperty("EmptyGridCaption", Grid2paginationbar_Emptygridcaption);
         ucGrid2paginationbar.setProperty("RowsPerPageCaption", Grid2paginationbar_Rowsperpagecaption);
         ucGrid2paginationbar.setProperty("CurrentPage", AV50Grid2CurrentPage);
         ucGrid2paginationbar.setProperty("PageCount", AV51Grid2PageCount);
         ucGrid2paginationbar.setProperty("AppliedFilters", AV52Grid2AppliedFilters);
         ucGrid2paginationbar.render(context, "dvelop.dvpaginationbar", Grid2paginationbar_Internalname, "GRID2PAGINATIONBARContainer");
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
         com.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "start", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'',false,'" + sGXsfl_31_idx + "',0)\"" ;
         com.GxWebStd.gx_single_line_edit( httpContext, edtavGrid2currentpage_Internalname, GXutil.ltrim( localUtil.ntoc( AV50Grid2CurrentPage, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV50Grid2CurrentPage), "ZZZZZZZZZ9")), " dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,41);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGrid2currentpage_Jsonclick, 0, "Attribute", "", "", "", "", edtavGrid2currentpage_Visible, 1, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "end", false, "", "HLP_Protocolow2.htm");
         /* User Defined Control */
         ucGrid2_empowerer.render(context, "wwp.gridempowerer", Grid2_empowerer_Internalname, "GRID2_EMPOWERERContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 31 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid2Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Grid2Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid2", Grid2Container, subGrid2_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData", Grid2Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData"+"V", Grid2Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid2ContainerData"+"V"+"\" value='"+Grid2Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start132( )
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
      Form.getMeta().addItem("description", "Protocolo: Contenidos ", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup130( ) ;
   }

   public void ws132( )
   {
      start132( ) ;
      evt132( ) ;
   }

   public void evt132( )
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
                        else if ( GXutil.strcmp(sEvt, "GRID2PAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11132 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRID2PAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12132 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOAGREGAR_CONTENIDO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoAgregar_Contenido' */
                           e13132 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID2.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "VELIMINAR_CONTENIDO.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "VELIMINAR_CONTENIDO.CLICK") == 0 ) )
                        {
                           nGXsfl_31_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_31_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_31_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_312( ) ;
                           AV42Eliminar_Contenido = httpContext.cgiGet( edtavEliminar_contenido_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminar_contenido_Internalname, AV42Eliminar_Contenido);
                           AV39CntdDesc = httpContext.cgiGet( edtavCntddesc_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCntddesc_Internalname, AV39CntdDesc);
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavProtid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavProtid_Internalname), ",", ".") > 9999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPROTID");
                              GX_FocusControl = edtavProtid_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV41ProtID = 0 ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavProtid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41ProtID), 10, 0));
                              com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, localUtil.format( DecimalUtil.doubleToDec(AV41ProtID), "ZZZZZZZZZ9")));
                           }
                           else
                           {
                              AV41ProtID = localUtil.ctol( httpContext.cgiGet( edtavProtid_Internalname), ",", ".") ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavProtid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41ProtID), 10, 0));
                              com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, localUtil.format( DecimalUtil.doubleToDec(AV41ProtID), "ZZZZZZZZZ9")));
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e14132 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15132 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID2.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e16132 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VELIMINAR_CONTENIDO.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e17132 ();
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

   public void we132( )
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

   public void pa132( )
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
            GX_FocusControl = dynavEnfid.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvcntdid131( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvcntdid_data131( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvcntdid_html131( )
   {
      long gxdynajaxvalue;
      gxdlvvcntdid_data131( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavCntdid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex)) ;
         dynavCntdid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 10, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavCntdid.getItemCount() > 0 )
      {
         AV40CntdID = GXutil.lval( dynavCntdid.getValidValue(GXutil.trim( GXutil.str( AV40CntdID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40CntdID), 10, 0));
      }
   }

   protected void gxdlvvcntdid_data131( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00132 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00132_A23CntdID[0], (byte)(10), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(GXutil.rtrim( H00132_A24CntdDesc[0]));
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvenfid131( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvenfid_data131( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvenfid_html131( )
   {
      long gxdynajaxvalue;
      gxdlvvenfid_data131( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEnfid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex)) ;
         dynavEnfid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 10, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV24EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV24EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
      }
   }

   protected void gxdlvvenfid_data131( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00133 */
      pr_default.execute(1);
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00133_A1EnfID[0], (byte)(10), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(GXutil.rtrim( H00133_A2EnfNombre[0]));
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxnrgrid2_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_312( ) ;
      while ( nGXsfl_31_idx <= nRC_GXsfl_31 )
      {
         sendrow_312( ) ;
         nGXsfl_31_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_31_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_31_idx+1) ;
         sGXsfl_31_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_31_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_312( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid2Container)) ;
      /* End function gxnrGrid2_newrow */
   }

   public void gxgrgrid2_refresh( int subGrid2_Rows ,
                                  long A1EnfID ,
                                  long AV24EnfID ,
                                  long A25ProtID ,
                                  String A24CntdDesc ,
                                  long AV40CntdID )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID2_nCurrentRecord = 0 ;
      rf132( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid2_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV41ProtID), "ZZZZZZZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, "vPROTID", GXutil.ltrim( localUtil.ntoc( AV41ProtID, (byte)(10), (byte)(0), ".", "")));
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavCntdid.setName( "vCNTDID" );
         dynavCntdid.setWebtags( "" );
         dynavCntdid.removeAllItems();
         /* Using cursor H00134 */
         pr_default.execute(2);
         while ( (pr_default.getStatus(2) != 101) )
         {
            dynavCntdid.addItem(GXutil.trim( GXutil.str( H00134_A23CntdID[0], 10, 0)), H00134_A24CntdDesc[0], (short)(0));
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( dynavCntdid.getItemCount() > 0 )
         {
            AV40CntdID = GXutil.lval( dynavCntdid.getValidValue(GXutil.trim( GXutil.str( AV40CntdID, 10, 0)))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40CntdID), 10, 0));
         }
         dynavEnfid.setName( "vENFID" );
         dynavEnfid.setWebtags( "" );
         dynavEnfid.removeAllItems();
         /* Using cursor H00135 */
         pr_default.execute(3);
         while ( (pr_default.getStatus(3) != 101) )
         {
            dynavEnfid.addItem(GXutil.trim( GXutil.str( H00135_A1EnfID[0], 10, 0)), H00135_A2EnfNombre[0], (short)(0));
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( dynavEnfid.getItemCount() > 0 )
         {
            AV24EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV24EnfID, 10, 0)))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV24EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV24EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEnfid.setValue( GXutil.trim( GXutil.str( AV24EnfID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEnfid.getInternalname(), "Values", dynavEnfid.ToJavascriptSource(), true);
      }
      if ( dynavCntdid.getItemCount() > 0 )
      {
         AV40CntdID = GXutil.lval( dynavCntdid.getValidValue(GXutil.trim( GXutil.str( AV40CntdID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40CntdID), 10, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavCntdid.setValue( GXutil.trim( GXutil.str( AV40CntdID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavCntdid.getInternalname(), "Values", dynavCntdid.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf132( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavEliminar_contenido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminar_contenido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_contenido_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavCntddesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntddesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntddesc_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavProtid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProtid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProtid_Enabled), 5, 0), !bGXsfl_31_Refreshing);
   }

   public void rf132( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid2Container.ClearRows();
      }
      wbStart = (short)(31) ;
      /* Execute user event: Refresh */
      e15132 ();
      nGXsfl_31_idx = 1 ;
      sGXsfl_31_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_31_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_312( ) ;
      bGXsfl_31_Refreshing = true ;
      Grid2Container.AddObjectProperty("GridName", "Grid2");
      Grid2Container.AddObjectProperty("CmpContext", "");
      Grid2Container.AddObjectProperty("InMasterPage", "false");
      Grid2Container.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      Grid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid2Container.setPageSize( subgrid2_fnc_recordsperpage( ) );
      if ( subGrid2_Islastpage != 0 )
      {
         GRID2_nFirstRecordOnPage = (long)(subgrid2_fnc_recordcount( )-subgrid2_fnc_recordsperpage( )) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("GRID2_nFirstRecordOnPage", GRID2_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_312( ) ;
         e16132 ();
         if ( ( subGrid2_Islastpage == 0 ) && ( GRID2_nCurrentRecord > 0 ) && ( GRID2_nGridOutOfScope == 0 ) && ( nGXsfl_31_idx == 1 ) )
         {
            GRID2_nCurrentRecord = 0 ;
            GRID2_nGridOutOfScope = 1 ;
            subgrid2_firstpage( ) ;
            e16132 ();
         }
         wbEnd = (short)(31) ;
         wb130( ) ;
      }
      bGXsfl_31_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes132( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, localUtil.format( DecimalUtil.doubleToDec(AV41ProtID), "ZZZZZZZZZ9")));
   }

   public int subgrid2_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_recordcount( )
   {
      return (int)(((subGrid2_Recordcount==0) ? GRID2_nFirstRecordOnPage+1 : subGrid2_Recordcount)) ;
   }

   public int subgrid2_fnc_recordsperpage( )
   {
      if ( subGrid2_Rows > 0 )
      {
         return subGrid2_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid2_fnc_currentpage( )
   {
      return (int)(((subGrid2_Islastpage==1) ? GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(subgrid2_fnc_recordcount( )).divide(DecimalUtil.doubleToDec(subgrid2_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+((((int)((subgrid2_fnc_recordcount( )) % (subgrid2_fnc_recordsperpage( ))))==0) ? 0 : 1) : GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID2_nFirstRecordOnPage).divide(DecimalUtil.doubleToDec(subgrid2_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1)) ;
   }

   public short subgrid2_firstpage( )
   {
      GRID2_nFirstRecordOnPage = 0 ;
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV24EnfID, A25ProtID, A24CntdDesc, AV40CntdID) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid2_nextpage( )
   {
      if ( GRID2_nEOF == 0 )
      {
         GRID2_nFirstRecordOnPage = (long)(GRID2_nFirstRecordOnPage+subgrid2_fnc_recordsperpage( )) ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Grid2Container.AddObjectProperty("GRID2_nFirstRecordOnPage", GRID2_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV24EnfID, A25ProtID, A24CntdDesc, AV40CntdID) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID2_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid2_previouspage( )
   {
      if ( GRID2_nFirstRecordOnPage >= subgrid2_fnc_recordsperpage( ) )
      {
         GRID2_nFirstRecordOnPage = (long)(GRID2_nFirstRecordOnPage-subgrid2_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV24EnfID, A25ProtID, A24CntdDesc, AV40CntdID) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid2_lastpage( )
   {
      subGrid2_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV24EnfID, A25ProtID, A24CntdDesc, AV40CntdID) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid2_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID2_nFirstRecordOnPage = (long)(subgrid2_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID2_nFirstRecordOnPage = 0 ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV24EnfID, A25ProtID, A24CntdDesc, AV40CntdID) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      edtavEliminar_contenido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminar_contenido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_contenido_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavCntddesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntddesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntddesc_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavProtid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProtid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProtid_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup130( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e14132 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_31 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_31"), ",", ".")) ;
         AV51Grid2PageCount = localUtil.ctol( httpContext.cgiGet( "vGRID2PAGECOUNT"), ",", ".") ;
         AV52Grid2AppliedFilters = httpContext.cgiGet( "vGRID2APPLIEDFILTERS") ;
         GRID2_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID2_nFirstRecordOnPage"), ",", ".") ;
         GRID2_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID2_nEOF"), ",", ".")) ;
         subGrid2_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( "subGrid2_Recordcount"), ",", ".")) ;
         subGrid2_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID2_Rows"), ",", ".")) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRID2_Rows", GXutil.ltrim( localUtil.ntoc( subGrid2_Rows, (byte)(6), (byte)(0), ".", "")));
         Grid2paginationbar_Class = httpContext.cgiGet( "GRID2PAGINATIONBAR_Class") ;
         Grid2paginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRID2PAGINATIONBAR_Showfirst")) ;
         Grid2paginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRID2PAGINATIONBAR_Showprevious")) ;
         Grid2paginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRID2PAGINATIONBAR_Shownext")) ;
         Grid2paginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRID2PAGINATIONBAR_Showlast")) ;
         Grid2paginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRID2PAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Grid2paginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRID2PAGINATIONBAR_Pagingbuttonsposition") ;
         Grid2paginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRID2PAGINATIONBAR_Pagingcaptionposition") ;
         Grid2paginationbar_Emptygridclass = httpContext.cgiGet( "GRID2PAGINATIONBAR_Emptygridclass") ;
         Grid2paginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRID2PAGINATIONBAR_Rowsperpageselector")) ;
         Grid2paginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRID2PAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Grid2paginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRID2PAGINATIONBAR_Rowsperpageoptions") ;
         Grid2paginationbar_Previous = httpContext.cgiGet( "GRID2PAGINATIONBAR_Previous") ;
         Grid2paginationbar_Next = httpContext.cgiGet( "GRID2PAGINATIONBAR_Next") ;
         Grid2paginationbar_Caption = httpContext.cgiGet( "GRID2PAGINATIONBAR_Caption") ;
         Grid2paginationbar_Emptygridcaption = httpContext.cgiGet( "GRID2PAGINATIONBAR_Emptygridcaption") ;
         Grid2paginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRID2PAGINATIONBAR_Rowsperpagecaption") ;
         Grid2_empowerer_Gridinternalname = httpContext.cgiGet( "GRID2_EMPOWERER_Gridinternalname") ;
         Grid2paginationbar_Selectedpage = httpContext.cgiGet( "GRID2PAGINATIONBAR_Selectedpage") ;
         Grid2paginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRID2PAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         /* Read variables values. */
         dynavEnfid.setName( dynavEnfid.getInternalname() );
         dynavEnfid.setValue( httpContext.cgiGet( dynavEnfid.getInternalname()) );
         AV24EnfID = GXutil.lval( httpContext.cgiGet( dynavEnfid.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
         dynavCntdid.setName( dynavCntdid.getInternalname() );
         dynavCntdid.setValue( httpContext.cgiGet( dynavCntdid.getInternalname()) );
         AV40CntdID = GXutil.lval( httpContext.cgiGet( dynavCntdid.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40CntdID), 10, 0));
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavGrid2currentpage_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavGrid2currentpage_Internalname), ",", ".") > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vGRID2CURRENTPAGE");
            GX_FocusControl = edtavGrid2currentpage_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV50Grid2CurrentPage = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50Grid2CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50Grid2CurrentPage), 10, 0));
         }
         else
         {
            AV50Grid2CurrentPage = localUtil.ctol( httpContext.cgiGet( edtavGrid2currentpage_Internalname), ",", ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50Grid2CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50Grid2CurrentPage), 10, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e14132 ();
      if (returnInSub) return;
   }

   public void e14132( )
   {
      /* Start Routine */
      returnInSub = false ;
      Grid2_empowerer_Gridinternalname = subGrid2_Internalname ;
      ucGrid2_empowerer.sendProperty(context, "", false, Grid2_empowerer_Internalname, "GridInternalName", Grid2_empowerer_Gridinternalname);
      subGrid2_Rows = 10 ;
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_Rows", GXutil.ltrim( localUtil.ntoc( subGrid2_Rows, (byte)(6), (byte)(0), ".", "")));
      AV50Grid2CurrentPage = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50Grid2CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50Grid2CurrentPage), 10, 0));
      edtavGrid2currentpage_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGrid2currentpage_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGrid2currentpage_Visible), 5, 0), true);
      AV51Grid2PageCount = -1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51Grid2PageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51Grid2PageCount), 10, 0));
      Grid2paginationbar_Rowsperpageselectedvalue = subGrid2_Rows ;
      ucGrid2paginationbar.sendProperty(context, "", false, Grid2paginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Grid2paginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e15132( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
   }

   private void e16132( )
   {
      /* Grid2_Load Routine */
      returnInSub = false ;
      AV42Eliminar_Contenido = "<i class=\"fas fa-x\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminar_contenido_Internalname, AV42Eliminar_Contenido);
      /* Using cursor H00136 */
      pr_default.execute(4, new Object[] {Long.valueOf(AV24EnfID)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A23CntdID = H00136_A23CntdID[0] ;
         n23CntdID = H00136_n23CntdID[0] ;
         A1EnfID = H00136_A1EnfID[0] ;
         n1EnfID = H00136_n1EnfID[0] ;
         A25ProtID = H00136_A25ProtID[0] ;
         A24CntdDesc = H00136_A24CntdDesc[0] ;
         A24CntdDesc = H00136_A24CntdDesc[0] ;
         AV41ProtID = A25ProtID ;
         httpContext.ajax_rsp_assign_attri("", false, edtavProtid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41ProtID), 10, 0));
         com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, localUtil.format( DecimalUtil.doubleToDec(AV41ProtID), "ZZZZZZZZZ9")));
         AV39CntdDesc = A24CntdDesc ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCntddesc_Internalname, AV39CntdDesc);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(31) ;
         }
         if ( ( subGrid2_Islastpage == 1 ) || ( subGrid2_Rows == 0 ) || ( ( GRID2_nCurrentRecord >= GRID2_nFirstRecordOnPage ) && ( GRID2_nCurrentRecord < GRID2_nFirstRecordOnPage + subgrid2_fnc_recordsperpage( ) ) ) )
         {
            sendrow_312( ) ;
         }
         GRID2_nEOF = (byte)(((GRID2_nCurrentRecord<GRID2_nFirstRecordOnPage+subgrid2_fnc_recordsperpage( )) ? 1 : 0)) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nEOF", GXutil.ltrim( localUtil.ntoc( GRID2_nEOF, (byte)(1), (byte)(0), ".", "")));
         GRID2_nCurrentRecord = (long)(GRID2_nCurrentRecord+1) ;
         subGrid2_Recordcount = (int)(GRID2_nCurrentRecord) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_31_Refreshing )
         {
            httpContext.doAjaxLoad(31, Grid2Row);
         }
         pr_default.readNext(4);
      }
      pr_default.close(4);
      /*  Sending Event outputs  */
   }

   public void e11132( )
   {
      /* Grid2paginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Grid2paginationbar_Selectedpage, "Previous") == 0 )
      {
         AV50Grid2CurrentPage = (long)(AV50Grid2CurrentPage-1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50Grid2CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50Grid2CurrentPage), 10, 0));
         subgrid2_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Grid2paginationbar_Selectedpage, "Next") == 0 )
      {
         AV50Grid2CurrentPage = (long)(AV50Grid2CurrentPage+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50Grid2CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50Grid2CurrentPage), 10, 0));
         subgrid2_nextpage( ) ;
      }
      else
      {
         AV49PageToGo = (int)(GXutil.lval( Grid2paginationbar_Selectedpage)) ;
         AV50Grid2CurrentPage = AV49PageToGo ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50Grid2CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50Grid2CurrentPage), 10, 0));
         subgrid2_gotopage( AV49PageToGo) ;
      }
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void e12132( )
   {
      /* Grid2paginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid2_Rows = Grid2paginationbar_Rowsperpageselectedvalue ;
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_Rows", GXutil.ltrim( localUtil.ntoc( subGrid2_Rows, (byte)(6), (byte)(0), ".", "")));
      AV50Grid2CurrentPage = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50Grid2CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50Grid2CurrentPage), 10, 0));
      subgrid2_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13132( )
   {
      /* 'DoAgregar_Contenido' Routine */
      returnInSub = false ;
      new com.protocolins(remoteHandle, context).execute( AV24EnfID, AV40CntdID) ;
      gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV24EnfID, A25ProtID, A24CntdDesc, AV40CntdID) ;
   }

   public void e17132( )
   {
      /* Eliminar_contenido_Click Routine */
      returnInSub = false ;
      new com.protocoldlt(remoteHandle, context).execute( AV41ProtID) ;
      gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV24EnfID, A25ProtID, A24CntdDesc, AV40CntdID) ;
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
      pa132( ) ;
      ws132( ) ;
      we132( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442619154768", true, true);
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
         httpContext.AddJavascriptSource("protocolow2.js", "?202442619154768", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_312( )
   {
      edtavEliminar_contenido_Internalname = "vELIMINAR_CONTENIDO_"+sGXsfl_31_idx ;
      edtavCntddesc_Internalname = "vCNTDDESC_"+sGXsfl_31_idx ;
      edtavProtid_Internalname = "vPROTID_"+sGXsfl_31_idx ;
   }

   public void subsflControlProps_fel_312( )
   {
      edtavEliminar_contenido_Internalname = "vELIMINAR_CONTENIDO_"+sGXsfl_31_fel_idx ;
      edtavCntddesc_Internalname = "vCNTDDESC_"+sGXsfl_31_fel_idx ;
      edtavProtid_Internalname = "vPROTID_"+sGXsfl_31_fel_idx ;
   }

   public void sendrow_312( )
   {
      subsflControlProps_312( ) ;
      wb130( ) ;
      if ( ( subGrid2_Rows * 1 == 0 ) || ( nGXsfl_31_idx <= subgrid2_fnc_recordsperpage( ) * 1 ) )
      {
         Grid2Row = GXWebRow.GetNew(context,Grid2Container) ;
         if ( subGrid2_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid2_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Odd" ;
            }
         }
         else if ( subGrid2_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid2_Backstyle = (byte)(0) ;
            subGrid2_Backcolor = subGrid2_Allbackcolor ;
            if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Uniform" ;
            }
         }
         else if ( subGrid2_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid2_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Odd" ;
            }
            subGrid2_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid2_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid2_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_31_idx) % (2))) == 0 )
            {
               subGrid2_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
               {
                  subGrid2_Linesclass = subGrid2_Class+"Even" ;
               }
            }
            else
            {
               subGrid2_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
               {
                  subGrid2_Linesclass = subGrid2_Class+"Odd" ;
               }
            }
         }
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_31_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminar_contenido_Enabled!=0)&&(edtavEliminar_contenido_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 32,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "Attribute" ;
         Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminar_contenido_Internalname,GXutil.rtrim( AV42Eliminar_Contenido),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminar_contenido_Enabled!=0)&&(edtavEliminar_contenido_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,32);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVELIMINAR_CONTENIDO.CLICK."+sGXsfl_31_idx+"'","","","","",edtavEliminar_contenido_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEliminar_contenido_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavCntddesc_Enabled!=0)&&(edtavCntddesc_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 33,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "Attribute" ;
         Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCntddesc_Internalname,GXutil.rtrim( AV39CntdDesc),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCntddesc_Enabled!=0)&&(edtavCntddesc_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,33);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCntddesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavCntddesc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"end"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavProtid_Enabled!=0)&&(edtavProtid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 34,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "Attribute" ;
         Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavProtid_Internalname,GXutil.ltrim( localUtil.ntoc( AV41ProtID, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( ((edtavProtid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV41ProtID), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV41ProtID), "ZZZZZZZZZ9")))," dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+((edtavProtid_Enabled!=0)&&(edtavProtid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,34);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavProtid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavProtid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","end",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes132( ) ;
         Grid2Container.AddRow(Grid2Row);
         nGXsfl_31_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_31_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_31_idx+1) ;
         sGXsfl_31_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_31_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_312( ) ;
      }
      /* End function sendrow_312 */
   }

   public void startgridcontrol31( )
   {
      if ( Grid2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid2Container"+"DivS\" data-gxgridid=\"31\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGrid2_Internalname, subGrid2_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid2_Backcolorstyle == 0 )
         {
            subGrid2_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid2_Class) > 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Title" ;
            }
         }
         else
         {
            subGrid2_Titlebackstyle = (byte)(1) ;
            if ( subGrid2_Backcolorstyle == 1 )
            {
               subGrid2_Titlebackcolor = subGrid2_Allbackcolor ;
               if ( GXutil.len( subGrid2_Class) > 0 )
               {
                  subGrid2_Linesclass = subGrid2_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid2_Class) > 0 )
               {
                  subGrid2_Linesclass = subGrid2_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"start"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"start"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Contenido Seleccionado") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"end"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "ID") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Grid2Container.AddObjectProperty("GridName", "Grid2");
      }
      else
      {
         Grid2Container.AddObjectProperty("GridName", "Grid2");
         Grid2Container.AddObjectProperty("Header", subGrid2_Header);
         Grid2Container.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         Grid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("CmpContext", "");
         Grid2Container.AddObjectProperty("InMasterPage", "false");
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV42Eliminar_Contenido)));
         Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminar_contenido_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV39CntdDesc)));
         Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCntddesc_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( AV41ProtID, (byte)(10), (byte)(0), ".", ""))));
         Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavProtid_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid2_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid2_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid2_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid2_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid2_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid2_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid2_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      divTablecontent_Internalname = "TABLECONTENT" ;
      dynavEnfid.setInternalname( "vENFID" );
      dynavCntdid.setInternalname( "vCNTDID" );
      bttBtnagregar_contenido_Internalname = "BTNAGREGAR_CONTENIDO" ;
      edtavEliminar_contenido_Internalname = "vELIMINAR_CONTENIDO" ;
      edtavCntddesc_Internalname = "vCNTDDESC" ;
      edtavProtid_Internalname = "vPROTID" ;
      Grid2paginationbar_Internalname = "GRID2PAGINATIONBAR" ;
      divGrid2tablewithpaginationbar_Internalname = "GRID2TABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavGrid2currentpage_Internalname = "vGRID2CURRENTPAGE" ;
      Grid2_empowerer_Internalname = "GRID2_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid2_Internalname = "GRID2" ;
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
      subGrid2_Allowcollapsing = (byte)(0) ;
      subGrid2_Allowselection = (byte)(0) ;
      subGrid2_Header = "" ;
      edtavProtid_Jsonclick = "" ;
      edtavProtid_Visible = 0 ;
      edtavProtid_Enabled = 1 ;
      edtavCntddesc_Jsonclick = "" ;
      edtavCntddesc_Visible = -1 ;
      edtavCntddesc_Enabled = 1 ;
      edtavEliminar_contenido_Jsonclick = "" ;
      edtavEliminar_contenido_Visible = -1 ;
      edtavEliminar_contenido_Enabled = 1 ;
      subGrid2_Class = "GridWithPaginationBar WorkWith" ;
      subGrid2_Backcolorstyle = (byte)(0) ;
      edtavGrid2currentpage_Jsonclick = "" ;
      edtavGrid2currentpage_Visible = 1 ;
      dynavCntdid.setJsonclick( "" );
      dynavCntdid.setEnabled( 1 );
      dynavEnfid.setJsonclick( "" );
      dynavEnfid.setEnabled( 1 );
      Grid2paginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Grid2paginationbar_Emptygridcaption = "Sin contenidos" ;
      Grid2paginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Grid2paginationbar_Next = "WWP_PagingNextCaption" ;
      Grid2paginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Grid2paginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Grid2paginationbar_Rowsperpageselectedvalue = 10 ;
      Grid2paginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Grid2paginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Grid2paginationbar_Pagingcaptionposition = "Left" ;
      Grid2paginationbar_Pagingbuttonsposition = "Right" ;
      Grid2paginationbar_Pagestoshow = 5 ;
      Grid2paginationbar_Showlast = GXutil.toBoolean( 0) ;
      Grid2paginationbar_Shownext = GXutil.toBoolean( -1) ;
      Grid2paginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Grid2paginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Grid2paginationbar_Class = "PaginationBar" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Protocolo: Contenidos " );
      subGrid2_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      dynavEnfid.setName( "vENFID" );
      dynavEnfid.setWebtags( "" );
      dynavEnfid.removeAllItems();
      /* Using cursor H00137 */
      pr_default.execute(5);
      while ( (pr_default.getStatus(5) != 101) )
      {
         dynavEnfid.addItem(GXutil.trim( GXutil.str( H00137_A1EnfID[0], 10, 0)), H00137_A2EnfNombre[0], (short)(0));
         pr_default.readNext(5);
      }
      pr_default.close(5);
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV24EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV24EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24EnfID), 10, 0));
      }
      dynavCntdid.setName( "vCNTDID" );
      dynavCntdid.setWebtags( "" );
      dynavCntdid.removeAllItems();
      /* Using cursor H00138 */
      pr_default.execute(6);
      while ( (pr_default.getStatus(6) != 101) )
      {
         dynavCntdid.addItem(GXutil.trim( GXutil.str( H00138_A23CntdID[0], 10, 0)), H00138_A24CntdDesc[0], (short)(0));
         pr_default.readNext(6);
      }
      pr_default.close(6);
      if ( dynavCntdid.getItemCount() > 0 )
      {
         AV40CntdID = GXutil.lval( dynavCntdid.getValidValue(GXutil.trim( GXutil.str( AV40CntdID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40CntdID), 10, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'dynavCntdid'},{av:'AV40CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID2.LOAD","{handler:'e16132',iparms:[{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''}]");
      setEventMetadata("GRID2.LOAD",",oparms:[{av:'AV42Eliminar_Contenido',fld:'vELIMINAR_CONTENIDO',pic:''},{av:'AV41ProtID',fld:'vPROTID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV39CntdDesc',fld:'vCNTDDESC',pic:''}]}");
      setEventMetadata("GRID2PAGINATIONBAR.CHANGEPAGE","{handler:'e11132',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'dynavCntdid'},{av:'AV40CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9'},{av:'Grid2paginationbar_Selectedpage',ctrl:'GRID2PAGINATIONBAR',prop:'SelectedPage'},{av:'AV50Grid2CurrentPage',fld:'vGRID2CURRENTPAGE',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID2PAGINATIONBAR.CHANGEPAGE",",oparms:[{av:'AV50Grid2CurrentPage',fld:'vGRID2CURRENTPAGE',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRID2PAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12132',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'dynavCntdid'},{av:'AV40CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9'},{av:'Grid2paginationbar_Rowsperpageselectedvalue',ctrl:'GRID2PAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRID2PAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'AV50Grid2CurrentPage',fld:'vGRID2CURRENTPAGE',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("'DOAGREGAR_CONTENIDO'","{handler:'e13132',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'dynavCntdid'},{av:'AV40CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("'DOAGREGAR_CONTENIDO'",",oparms:[]}");
      setEventMetadata("VELIMINAR_CONTENIDO.CLICK","{handler:'e17132',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV24EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'dynavCntdid'},{av:'AV40CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9'},{av:'AV41ProtID',fld:'vPROTID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("VELIMINAR_CONTENIDO.CLICK",",oparms:[]}");
      setEventMetadata("VALIDV_ENFID","{handler:'validv_Enfid',iparms:[]");
      setEventMetadata("VALIDV_ENFID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Protid',iparms:[]");
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
      Grid2paginationbar_Selectedpage = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A24CntdDesc = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV52Grid2AppliedFilters = "" ;
      Grid2_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtnagregar_contenido_Jsonclick = "" ;
      Grid2Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGrid2paginationbar = new com.genexus.webpanels.GXUserControl();
      ucGrid2_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV42Eliminar_Contenido = "" ;
      AV39CntdDesc = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      H00132_A23CntdID = new long[1] ;
      H00132_n23CntdID = new boolean[] {false} ;
      H00132_A24CntdDesc = new String[] {""} ;
      H00133_A1EnfID = new long[1] ;
      H00133_n1EnfID = new boolean[] {false} ;
      H00133_A2EnfNombre = new String[] {""} ;
      H00133_n2EnfNombre = new boolean[] {false} ;
      H00134_A23CntdID = new long[1] ;
      H00134_n23CntdID = new boolean[] {false} ;
      H00134_A24CntdDesc = new String[] {""} ;
      H00135_A1EnfID = new long[1] ;
      H00135_n1EnfID = new boolean[] {false} ;
      H00135_A2EnfNombre = new String[] {""} ;
      H00135_n2EnfNombre = new boolean[] {false} ;
      H00136_A23CntdID = new long[1] ;
      H00136_n23CntdID = new boolean[] {false} ;
      H00136_A1EnfID = new long[1] ;
      H00136_n1EnfID = new boolean[] {false} ;
      H00136_A25ProtID = new long[1] ;
      H00136_A24CntdDesc = new String[] {""} ;
      Grid2Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid2_Linesclass = "" ;
      ROClassString = "" ;
      Grid2Column = new com.genexus.webpanels.GXWebColumn();
      H00137_A1EnfID = new long[1] ;
      H00137_n1EnfID = new boolean[] {false} ;
      H00137_A2EnfNombre = new String[] {""} ;
      H00137_n2EnfNombre = new boolean[] {false} ;
      H00138_A23CntdID = new long[1] ;
      H00138_n23CntdID = new boolean[] {false} ;
      H00138_A24CntdDesc = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.protocolow2__default(),
         new Object[] {
             new Object[] {
            H00132_A23CntdID, H00132_A24CntdDesc
            }
            , new Object[] {
            H00133_A1EnfID, H00133_A2EnfNombre, H00133_n2EnfNombre
            }
            , new Object[] {
            H00134_A23CntdID, H00134_A24CntdDesc
            }
            , new Object[] {
            H00135_A1EnfID, H00135_A2EnfNombre, H00135_n2EnfNombre
            }
            , new Object[] {
            H00136_A23CntdID, H00136_n23CntdID, H00136_A1EnfID, H00136_n1EnfID, H00136_A25ProtID, H00136_A24CntdDesc
            }
            , new Object[] {
            H00137_A1EnfID, H00137_A2EnfNombre, H00137_n2EnfNombre
            }
            , new Object[] {
            H00138_A23CntdID, H00138_A24CntdDesc
            }
         }
      );
      /* GeneXus formulas. */
      edtavEliminar_contenido_Enabled = 0 ;
      edtavCntddesc_Enabled = 0 ;
      edtavProtid_Enabled = 0 ;
   }

   private byte GRID2_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGrid2_Backcolorstyle ;
   private byte subGrid2_Backstyle ;
   private byte subGrid2_Titlebackstyle ;
   private byte subGrid2_Allowselection ;
   private byte subGrid2_Allowhovering ;
   private byte subGrid2_Allowcollapsing ;
   private byte subGrid2_Collapsed ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int Grid2paginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_31 ;
   private int subGrid2_Recordcount ;
   private int subGrid2_Rows ;
   private int nGXsfl_31_idx=1 ;
   private int Grid2paginationbar_Pagestoshow ;
   private int edtavGrid2currentpage_Visible ;
   private int gxdynajaxindex ;
   private int subGrid2_Islastpage ;
   private int edtavEliminar_contenido_Enabled ;
   private int edtavCntddesc_Enabled ;
   private int edtavProtid_Enabled ;
   private int GRID2_nGridOutOfScope ;
   private int AV49PageToGo ;
   private int idxLst ;
   private int subGrid2_Backcolor ;
   private int subGrid2_Allbackcolor ;
   private int edtavEliminar_contenido_Visible ;
   private int edtavCntddesc_Visible ;
   private int edtavProtid_Visible ;
   private int subGrid2_Titlebackcolor ;
   private int subGrid2_Selectedindex ;
   private int subGrid2_Selectioncolor ;
   private int subGrid2_Hoveringcolor ;
   private long GRID2_nFirstRecordOnPage ;
   private long A1EnfID ;
   private long AV24EnfID ;
   private long A25ProtID ;
   private long AV40CntdID ;
   private long AV51Grid2PageCount ;
   private long AV50Grid2CurrentPage ;
   private long AV41ProtID ;
   private long GRID2_nCurrentRecord ;
   private long A23CntdID ;
   private String Grid2paginationbar_Selectedpage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_31_idx="0001" ;
   private String A24CntdDesc ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Grid2paginationbar_Class ;
   private String Grid2paginationbar_Pagingbuttonsposition ;
   private String Grid2paginationbar_Pagingcaptionposition ;
   private String Grid2paginationbar_Emptygridclass ;
   private String Grid2paginationbar_Rowsperpageoptions ;
   private String Grid2paginationbar_Previous ;
   private String Grid2paginationbar_Next ;
   private String Grid2paginationbar_Caption ;
   private String Grid2paginationbar_Emptygridcaption ;
   private String Grid2paginationbar_Rowsperpagecaption ;
   private String Grid2_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String TempTags ;
   private String bttBtnagregar_contenido_Internalname ;
   private String bttBtnagregar_contenido_Jsonclick ;
   private String divGrid2tablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid2_Internalname ;
   private String Grid2paginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavGrid2currentpage_Internalname ;
   private String edtavGrid2currentpage_Jsonclick ;
   private String Grid2_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV42Eliminar_Contenido ;
   private String edtavEliminar_contenido_Internalname ;
   private String AV39CntdDesc ;
   private String edtavCntddesc_Internalname ;
   private String edtavProtid_Internalname ;
   private String gxwrpcisep ;
   private String sGXsfl_31_fel_idx="0001" ;
   private String subGrid2_Class ;
   private String subGrid2_Linesclass ;
   private String ROClassString ;
   private String edtavEliminar_contenido_Jsonclick ;
   private String edtavCntddesc_Jsonclick ;
   private String edtavProtid_Jsonclick ;
   private String subGrid2_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1EnfID ;
   private boolean Grid2paginationbar_Showfirst ;
   private boolean Grid2paginationbar_Showprevious ;
   private boolean Grid2paginationbar_Shownext ;
   private boolean Grid2paginationbar_Showlast ;
   private boolean Grid2paginationbar_Rowsperpageselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_31_Refreshing=false ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean n23CntdID ;
   private String AV52Grid2AppliedFilters ;
   private com.genexus.webpanels.GXWebGrid Grid2Container ;
   private com.genexus.webpanels.GXWebRow Grid2Row ;
   private com.genexus.webpanels.GXWebColumn Grid2Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucGrid2paginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid2_empowerer ;
   private HTMLChoice dynavEnfid ;
   private HTMLChoice dynavCntdid ;
   private IDataStoreProvider pr_default ;
   private long[] H00132_A23CntdID ;
   private boolean[] H00132_n23CntdID ;
   private String[] H00132_A24CntdDesc ;
   private long[] H00133_A1EnfID ;
   private boolean[] H00133_n1EnfID ;
   private String[] H00133_A2EnfNombre ;
   private boolean[] H00133_n2EnfNombre ;
   private long[] H00134_A23CntdID ;
   private boolean[] H00134_n23CntdID ;
   private String[] H00134_A24CntdDesc ;
   private long[] H00135_A1EnfID ;
   private boolean[] H00135_n1EnfID ;
   private String[] H00135_A2EnfNombre ;
   private boolean[] H00135_n2EnfNombre ;
   private long[] H00136_A23CntdID ;
   private boolean[] H00136_n23CntdID ;
   private long[] H00136_A1EnfID ;
   private boolean[] H00136_n1EnfID ;
   private long[] H00136_A25ProtID ;
   private String[] H00136_A24CntdDesc ;
   private long[] H00137_A1EnfID ;
   private boolean[] H00137_n1EnfID ;
   private String[] H00137_A2EnfNombre ;
   private boolean[] H00137_n2EnfNombre ;
   private long[] H00138_A23CntdID ;
   private boolean[] H00138_n23CntdID ;
   private String[] H00138_A24CntdDesc ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class protocolow2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00132", "SELECT CntdID, CntdDesc FROM Contenidos ORDER BY CntdDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00133", "SELECT EnfID, EnfNombre FROM Enfermedades ORDER BY EnfNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00134", "SELECT CntdID, CntdDesc FROM Contenidos ORDER BY CntdDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00135", "SELECT EnfID, EnfNombre FROM Enfermedades ORDER BY EnfNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00136", "SELECT T1.CntdID, T1.EnfID, T1.ProtID, T2.CntdDesc FROM (Protocolo T1 LEFT JOIN Contenidos T2 ON T2.CntdID = T1.CntdID) WHERE T1.EnfID = ? ORDER BY T1.EnfID ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00137", "SELECT EnfID, EnfNombre FROM Enfermedades ORDER BY EnfNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00138", "SELECT CntdID, CntdDesc FROM Contenidos ORDER BY CntdDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((long[]) buf[2])[0] = rslt.getLong(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((long[]) buf[4])[0] = rslt.getLong(3);
               ((String[]) buf[5])[0] = rslt.getString(4, 60);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

