package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class protocolow3_impl extends GXDataArea
{
   public protocolow3_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public protocolow3_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( protocolow3_impl.class ));
   }

   public protocolow3_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynavEnfid = new HTMLChoice();
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
      nRC_GXsfl_26 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_26"))) ;
      nGXsfl_26_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_26_idx"))) ;
      sGXsfl_26_idx = httpContext.GetPar( "sGXsfl_26_idx") ;
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
      AV12EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
      A25ProtID = GXutil.lval( httpContext.GetPar( "ProtID")) ;
      A24CntdDesc = httpContext.GetPar( "CntdDesc") ;
      A23CntdID = GXutil.lval( httpContext.GetPar( "CntdID")) ;
      n23CntdID = false ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV12EnfID, A25ProtID, A24CntdDesc, A23CntdID) ;
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
      pa152( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start152( ) ;
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
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.protocolow3", new String[] {}, new String[] {}) +"\">") ;
      com.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
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
      com.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_26", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_26, (byte)(8), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "ENFID", GXutil.ltrim( localUtil.ntoc( A1EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "PROTID", GXutil.ltrim( localUtil.ntoc( A25ProtID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "CNTDDESC", GXutil.rtrim( A24CntdDesc));
      com.GxWebStd.gx_hidden_field( httpContext, "CNTDID", GXutil.ltrim( localUtil.ntoc( A23CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID2_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nEOF", GXutil.ltrim( localUtil.ntoc( GRID2_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "subGrid2_Recordcount", GXutil.ltrim( localUtil.ntoc( subGrid2_Recordcount, (byte)(5), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_Rows", GXutil.ltrim( localUtil.ntoc( subGrid2_Rows, (byte)(6), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid2_empowerer_Gridinternalname));
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
      if ( ! ( WebComp_Wcprotocolowc == null ) )
      {
         WebComp_Wcprotocolowc.componentjscripts();
      }
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we152( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt152( ) ;
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
      return formatLink("com.protocolow3", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Protocolow3" ;
   }

   public String getPgmdesc( )
   {
      return "Protocolow2" ;
   }

   public void wb150( )
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
         com.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TabsIFrame", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellTitleMasterHorizontalMenu", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "start", "top", ""+" data-gx-for=\""+dynavEnfid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.GxWebStd.gx_label_element( httpContext, dynavEnfid.getInternalname(), "Enfermedad", "col-sm-2 AttributeSearchSplitScreenLabel", 1, true, "");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-10 gx-attribute", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'" + sGXsfl_26_idx + "',0)\"" ;
         /* ComboBox */
         com.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEnfid, dynavEnfid.getInternalname(), GXutil.trim( GXutil.str( AV12EnfID, 10, 0)), 1, dynavEnfid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEnfid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeSearchSplitScreen", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,14);\"", "", true, (byte)(0), "HLP_Protocolow3.htm");
         dynavEnfid.setValue( GXutil.trim( GXutil.str( AV12EnfID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEnfid.getInternalname(), "Values", dynavEnfid.ToJavascriptSource(), true);
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
         com.GxWebStd.gx_div_start( httpContext, divTablerigth_Internalname, 1, 0, "px", 0, "px", "TableWizardMainWithShadow", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         wb_table1_20_152( true) ;
      }
      else
      {
         wb_table1_20_152( false) ;
      }
      return  ;
   }

   public void wb_table1_20_152e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         /* User Defined Control */
         ucGrid2_empowerer.render(context, "wwp.gridempowerer", Grid2_empowerer_Internalname, "GRID2_EMPOWERERContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 26 )
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
               Grid2Container.AddObjectProperty("GRID2_nEOF", GRID2_nEOF);
               Grid2Container.AddObjectProperty("GRID2_nFirstRecordOnPage", GRID2_nFirstRecordOnPage);
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

   public void start152( )
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
      Form.getMeta().addItem("description", "Protocolow2", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup150( ) ;
   }

   public void ws152( )
   {
      start152( ) ;
      evt152( ) ;
   }

   public void evt152( )
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
                        }
                        else if ( GXutil.strcmp(sEvt, "GRID2PAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRID2PAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid2_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid2_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid2_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid2_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID2.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_26_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_262( ) ;
                           AV10CntdDesc = httpContext.cgiGet( edtavCntddesc_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCntddesc_Internalname, AV10CntdDesc);
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCntdid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCntdid_Internalname), ",", ".") > 9999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCNTDID");
                              GX_FocusControl = edtavCntdid_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV5CntdID = 0 ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavCntdid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CntdID), 10, 0));
                           }
                           else
                           {
                              AV5CntdID = localUtil.ctol( httpContext.cgiGet( edtavCntdid_Internalname), ",", ".") ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavCntdid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CntdID), 10, 0));
                           }
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavProtid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavProtid_Internalname), ",", ".") > 9999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPROTID");
                              GX_FocusControl = edtavProtid_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV8ProtID = 0 ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavProtid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ProtID), 10, 0));
                              com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID"+"_"+sGXsfl_26_idx, getSecureSignedToken( sGXsfl_26_idx, localUtil.format( DecimalUtil.doubleToDec(AV8ProtID), "ZZZZZZZZZ9")));
                           }
                           else
                           {
                              AV8ProtID = localUtil.ctol( httpContext.cgiGet( edtavProtid_Internalname), ",", ".") ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavProtid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ProtID), 10, 0));
                              com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID"+"_"+sGXsfl_26_idx, getSecureSignedToken( sGXsfl_26_idx, localUtil.format( DecimalUtil.doubleToDec(AV8ProtID), "ZZZZZZZZZ9")));
                           }
                           AV13Editar_Contenido = httpContext.cgiGet( edtavEditar_contenido_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEditar_contenido_Internalname, AV13Editar_Contenido);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11152 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID2.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e12152 ();
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 35 )
                     {
                        OldWcprotocolowc = httpContext.cgiGet( "W0035") ;
                        if ( ( GXutil.len( OldWcprotocolowc) == 0 ) || ( GXutil.strcmp(OldWcprotocolowc, WebComp_Wcprotocolowc_Component) != 0 ) )
                        {
                           WebComp_Wcprotocolowc = WebFrontendUtils.getWebComponent(getClass(), "com." + OldWcprotocolowc + "_impl", remoteHandle, context);
                           WebComp_Wcprotocolowc_Component = OldWcprotocolowc ;
                        }
                        if ( GXutil.len( WebComp_Wcprotocolowc_Component) != 0 )
                        {
                           WebComp_Wcprotocolowc.componentprocess("W0035", "", sEvt);
                        }
                        WebComp_Wcprotocolowc_Component = OldWcprotocolowc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we152( )
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

   public void pa152( )
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

   public void gxdlvvenfid151( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvenfid_data151( ) ;
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

   public void gxvvenfid_html151( )
   {
      long gxdynajaxvalue;
      gxdlvvenfid_data151( ) ;
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
         AV12EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV12EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12EnfID), 10, 0));
      }
   }

   protected void gxdlvvenfid_data151( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00152 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00152_A1EnfID[0], (byte)(10), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(GXutil.rtrim( H00152_A2EnfNombre[0]));
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxnrgrid2_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_262( ) ;
      while ( nGXsfl_26_idx <= nRC_GXsfl_26 )
      {
         sendrow_262( ) ;
         nGXsfl_26_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_26_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_26_idx+1) ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid2Container)) ;
      /* End function gxnrGrid2_newrow */
   }

   public void gxgrgrid2_refresh( int subGrid2_Rows ,
                                  long A1EnfID ,
                                  long AV12EnfID ,
                                  long A25ProtID ,
                                  String A24CntdDesc ,
                                  long A23CntdID )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID2_nCurrentRecord = 0 ;
      rf152( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid2_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8ProtID), "ZZZZZZZZZ9")));
      com.GxWebStd.gx_hidden_field( httpContext, "vPROTID", GXutil.ltrim( localUtil.ntoc( AV8ProtID, (byte)(10), (byte)(0), ".", "")));
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEnfid.setName( "vENFID" );
         dynavEnfid.setWebtags( "" );
         dynavEnfid.removeAllItems();
         /* Using cursor H00153 */
         pr_default.execute(1);
         while ( (pr_default.getStatus(1) != 101) )
         {
            dynavEnfid.addItem(GXutil.trim( GXutil.str( H00153_A1EnfID[0], 10, 0)), H00153_A2EnfNombre[0], (short)(0));
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( dynavEnfid.getItemCount() > 0 )
         {
            AV12EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV12EnfID, 10, 0)))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12EnfID), 10, 0));
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV12EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV12EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12EnfID), 10, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEnfid.setValue( GXutil.trim( GXutil.str( AV12EnfID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEnfid.getInternalname(), "Values", dynavEnfid.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf152( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavCntddesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntddesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntddesc_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavCntdid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntdid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntdid_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavProtid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProtid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProtid_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavEditar_contenido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEditar_contenido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditar_contenido_Enabled), 5, 0), !bGXsfl_26_Refreshing);
   }

   public void rf152( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid2Container.ClearRows();
      }
      wbStart = (short)(26) ;
      nGXsfl_26_idx = 1 ;
      sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_262( ) ;
      bGXsfl_26_Refreshing = true ;
      Grid2Container.AddObjectProperty("GridName", "Grid2");
      Grid2Container.AddObjectProperty("CmpContext", "");
      Grid2Container.AddObjectProperty("InMasterPage", "false");
      Grid2Container.AddObjectProperty("Class", "WorkWith");
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
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( WebComp_Wcprotocolowc_Visible != 0 )
         {
            if ( GXutil.len( WebComp_Wcprotocolowc_Component) != 0 )
            {
               WebComp_Wcprotocolowc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_262( ) ;
         e12152 ();
         if ( ( subGrid2_Islastpage == 0 ) && ( GRID2_nCurrentRecord > 0 ) && ( GRID2_nGridOutOfScope == 0 ) && ( nGXsfl_26_idx == 1 ) )
         {
            GRID2_nCurrentRecord = 0 ;
            GRID2_nGridOutOfScope = 1 ;
            subgrid2_firstpage( ) ;
            e12152 ();
         }
         wbEnd = (short)(26) ;
         wb150( ) ;
      }
      bGXsfl_26_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes152( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID"+"_"+sGXsfl_26_idx, getSecureSignedToken( sGXsfl_26_idx, localUtil.format( DecimalUtil.doubleToDec(AV8ProtID), "ZZZZZZZZZ9")));
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
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV12EnfID, A25ProtID, A24CntdDesc, A23CntdID) ;
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
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV12EnfID, A25ProtID, A24CntdDesc, A23CntdID) ;
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
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV12EnfID, A25ProtID, A24CntdDesc, A23CntdID) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid2_lastpage( )
   {
      subGrid2_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV12EnfID, A25ProtID, A24CntdDesc, A23CntdID) ;
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
         gxgrgrid2_refresh( subGrid2_Rows, A1EnfID, AV12EnfID, A25ProtID, A24CntdDesc, A23CntdID) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      edtavCntddesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntddesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntddesc_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavCntdid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntdid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntdid_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavProtid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProtid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProtid_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavEditar_contenido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEditar_contenido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditar_contenido_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup150( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11152 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_26 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_26"), ",", ".")) ;
         GRID2_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID2_nFirstRecordOnPage"), ",", ".") ;
         GRID2_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID2_nEOF"), ",", ".")) ;
         subGrid2_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( "subGrid2_Recordcount"), ",", ".")) ;
         subGrid2_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID2_Rows"), ",", ".")) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRID2_Rows", GXutil.ltrim( localUtil.ntoc( subGrid2_Rows, (byte)(6), (byte)(0), ".", "")));
         Grid2_empowerer_Gridinternalname = httpContext.cgiGet( "GRID2_EMPOWERER_Gridinternalname") ;
         /* Read variables values. */
         dynavEnfid.setName( dynavEnfid.getInternalname() );
         dynavEnfid.setValue( httpContext.cgiGet( dynavEnfid.getInternalname()) );
         AV12EnfID = GXutil.lval( httpContext.cgiGet( dynavEnfid.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12EnfID), 10, 0));
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
      e11152 ();
      if (returnInSub) return;
   }

   public void e11152( )
   {
      /* Start Routine */
      returnInSub = false ;
      Grid2_empowerer_Gridinternalname = subGrid2_Internalname ;
      ucGrid2_empowerer.sendProperty(context, "", false, Grid2_empowerer_Internalname, "GridInternalName", Grid2_empowerer_Gridinternalname);
      subGrid2_Rows = 15 ;
      com.GxWebStd.gx_hidden_field( httpContext, "GRID2_Rows", GXutil.ltrim( localUtil.ntoc( subGrid2_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   private void e12152( )
   {
      /* Grid2_Load Routine */
      returnInSub = false ;
      AV13Editar_Contenido = "<i class=\"fas fa-arrow-right\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEditar_contenido_Internalname, AV13Editar_Contenido);
      /* Using cursor H00154 */
      pr_default.execute(2, new Object[] {Long.valueOf(AV12EnfID)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1EnfID = H00154_A1EnfID[0] ;
         n1EnfID = H00154_n1EnfID[0] ;
         A25ProtID = H00154_A25ProtID[0] ;
         A24CntdDesc = H00154_A24CntdDesc[0] ;
         A23CntdID = H00154_A23CntdID[0] ;
         n23CntdID = H00154_n23CntdID[0] ;
         A24CntdDesc = H00154_A24CntdDesc[0] ;
         AV8ProtID = A25ProtID ;
         httpContext.ajax_rsp_assign_attri("", false, edtavProtid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ProtID), 10, 0));
         com.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROTID"+"_"+sGXsfl_26_idx, getSecureSignedToken( sGXsfl_26_idx, localUtil.format( DecimalUtil.doubleToDec(AV8ProtID), "ZZZZZZZZZ9")));
         AV10CntdDesc = A24CntdDesc ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCntddesc_Internalname, AV10CntdDesc);
         AV5CntdID = A23CntdID ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCntdid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CntdID), 10, 0));
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(26) ;
         }
         if ( ( subGrid2_Islastpage == 1 ) || ( subGrid2_Rows == 0 ) || ( ( GRID2_nCurrentRecord >= GRID2_nFirstRecordOnPage ) && ( GRID2_nCurrentRecord < GRID2_nFirstRecordOnPage + subgrid2_fnc_recordsperpage( ) ) ) )
         {
            sendrow_262( ) ;
         }
         GRID2_nEOF = (byte)(((GRID2_nCurrentRecord<GRID2_nFirstRecordOnPage+subgrid2_fnc_recordsperpage( )) ? 1 : 0)) ;
         com.GxWebStd.gx_hidden_field( httpContext, "GRID2_nEOF", GXutil.ltrim( localUtil.ntoc( GRID2_nEOF, (byte)(1), (byte)(0), ".", "")));
         GRID2_nCurrentRecord = (long)(GRID2_nCurrentRecord+1) ;
         subGrid2_Recordcount = (int)(GRID2_nCurrentRecord) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_26_Refreshing )
         {
            httpContext.doAjaxLoad(26, Grid2Row);
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
      /*  Sending Event outputs  */
   }

   public void wb_table1_20_152( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, tblTablemergedunnamedtable2_Internalname, tblTablemergedunnamedtable2_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "start", "top", "", "", "div");
         /*  Grid Control  */
         Grid2Container.SetWrapped(nGXWrapped);
         startgridcontrol26( ) ;
      }
      if ( wbEnd == 26 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_26 = (int)(nGXsfl_26_idx-1) ;
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Grid2Container.AddObjectProperty("GRID2_nEOF", GRID2_nEOF);
            Grid2Container.AddObjectProperty("GRID2_nFirstRecordOnPage", GRID2_nFirstRecordOnPage);
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
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.GxWebStd.gx_hidden_field( httpContext, "W0035"+"", GXutil.rtrim( WebComp_Wcprotocolowc_Component));
            httpContext.writeText( "<div") ;
            com.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0035"+""+"\""+((WebComp_Wcprotocolowc_Visible==1) ? "" : " style=\"display:none;\"")) ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_26_Refreshing )
            {
               if ( GXutil.len( WebComp_Wcprotocolowc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldWcprotocolowc), GXutil.lower( WebComp_Wcprotocolowc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp("gxHTMLWrpW0035"+"");
                  }
                  WebComp_Wcprotocolowc.componentdraw();
                  if ( GXutil.strcmp(GXutil.lower( OldWcprotocolowc), GXutil.lower( WebComp_Wcprotocolowc_Component)) != 0 )
                  {
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_20_152e( true) ;
      }
      else
      {
         wb_table1_20_152e( false) ;
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
      pa152( ) ;
      ws152( ) ;
      we152( ) ;
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
      if ( ! ( WebComp_Wcprotocolowc == null ) )
      {
         if ( GXutil.len( WebComp_Wcprotocolowc_Component) != 0 )
         {
            WebComp_Wcprotocolowc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20244261717200", true, true);
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
      httpContext.AddJavascriptSource("protocolow3.js", "?20244261717200", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_262( )
   {
      edtavCntddesc_Internalname = "vCNTDDESC_"+sGXsfl_26_idx ;
      edtavCntdid_Internalname = "vCNTDID_"+sGXsfl_26_idx ;
      edtavProtid_Internalname = "vPROTID_"+sGXsfl_26_idx ;
      edtavEditar_contenido_Internalname = "vEDITAR_CONTENIDO_"+sGXsfl_26_idx ;
   }

   public void subsflControlProps_fel_262( )
   {
      edtavCntddesc_Internalname = "vCNTDDESC_"+sGXsfl_26_fel_idx ;
      edtavCntdid_Internalname = "vCNTDID_"+sGXsfl_26_fel_idx ;
      edtavProtid_Internalname = "vPROTID_"+sGXsfl_26_fel_idx ;
      edtavEditar_contenido_Internalname = "vEDITAR_CONTENIDO_"+sGXsfl_26_fel_idx ;
   }

   public void sendrow_262( )
   {
      subsflControlProps_262( ) ;
      wb150( ) ;
      if ( ( subGrid2_Rows * 1 == 0 ) || ( nGXsfl_26_idx <= subgrid2_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_26_idx) % (2))) == 0 )
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
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_26_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavCntddesc_Enabled!=0)&&(edtavCntddesc_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 27,'',false,'"+sGXsfl_26_idx+"',26)\"" : " ") ;
         ROClassString = "Attribute" ;
         Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCntddesc_Internalname,GXutil.rtrim( AV10CntdDesc),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCntddesc_Enabled!=0)&&(edtavCntddesc_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,27);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCntddesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavCntddesc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"end"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavCntdid_Enabled!=0)&&(edtavCntdid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 28,'',false,'"+sGXsfl_26_idx+"',26)\"" : " ") ;
         ROClassString = "Attribute" ;
         Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCntdid_Internalname,GXutil.ltrim( localUtil.ntoc( AV5CntdID, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCntdid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV5CntdID), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV5CntdID), "ZZZZZZZZZ9")))," dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+((edtavCntdid_Enabled!=0)&&(edtavCntdid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,28);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCntdid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavCntdid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","end",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"end"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavProtid_Enabled!=0)&&(edtavProtid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 29,'',false,'"+sGXsfl_26_idx+"',26)\"" : " ") ;
         ROClassString = "Attribute" ;
         Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavProtid_Internalname,GXutil.ltrim( localUtil.ntoc( AV8ProtID, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( ((edtavProtid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV8ProtID), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV8ProtID), "ZZZZZZZZZ9")))," dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+((edtavProtid_Enabled!=0)&&(edtavProtid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,29);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavProtid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavProtid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","end",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEditar_contenido_Enabled!=0)&&(edtavEditar_contenido_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 30,'',false,'"+sGXsfl_26_idx+"',26)\"" : " ") ;
         ROClassString = "Attribute" ;
         Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEditar_contenido_Internalname,GXutil.rtrim( AV13Editar_Contenido),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEditar_contenido_Enabled!=0)&&(edtavEditar_contenido_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,30);\"" : " "),"'"+""+"'"+",false,"+"'"+"e13152_client"+"'","","","","",edtavEditar_contenido_Jsonclick,Integer.valueOf(7),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEditar_contenido_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes152( ) ;
         Grid2Container.AddRow(Grid2Row);
         nGXsfl_26_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_26_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_26_idx+1) ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
      }
      /* End function sendrow_262 */
   }

   public void startgridcontrol26( )
   {
      if ( Grid2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid2Container"+"DivS\" data-gxgridid=\"26\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGrid2_Internalname, subGrid2_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         httpContext.writeValue( "Tipo de Contenido") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"end"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "ID") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"end"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "ID") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"start"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Grid2Container.AddObjectProperty("GridName", "Grid2");
      }
      else
      {
         Grid2Container.AddObjectProperty("GridName", "Grid2");
         Grid2Container.AddObjectProperty("Header", subGrid2_Header);
         Grid2Container.AddObjectProperty("Class", "WorkWith");
         Grid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("CmpContext", "");
         Grid2Container.AddObjectProperty("InMasterPage", "false");
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV10CntdDesc)));
         Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCntddesc_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( AV5CntdID, (byte)(10), (byte)(0), ".", ""))));
         Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCntdid_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( AV8ProtID, (byte)(10), (byte)(0), ".", ""))));
         Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavProtid_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV13Editar_Contenido)));
         Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEditar_contenido_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      dynavEnfid.setInternalname( "vENFID" );
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      edtavCntddesc_Internalname = "vCNTDDESC" ;
      edtavCntdid_Internalname = "vCNTDID" ;
      edtavProtid_Internalname = "vPROTID" ;
      edtavEditar_contenido_Internalname = "vEDITAR_CONTENIDO" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      tblTablemergedunnamedtable2_Internalname = "TABLEMERGEDUNNAMEDTABLE2" ;
      divTablerigth_Internalname = "TABLERIGTH" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      edtavEditar_contenido_Jsonclick = "" ;
      edtavEditar_contenido_Visible = -1 ;
      edtavEditar_contenido_Enabled = 1 ;
      edtavProtid_Jsonclick = "" ;
      edtavProtid_Visible = 0 ;
      edtavProtid_Enabled = 1 ;
      edtavCntdid_Jsonclick = "" ;
      edtavCntdid_Visible = 0 ;
      edtavCntdid_Enabled = 1 ;
      edtavCntddesc_Jsonclick = "" ;
      edtavCntddesc_Visible = -1 ;
      edtavCntddesc_Enabled = 1 ;
      subGrid2_Class = "WorkWith" ;
      subGrid2_Backcolorstyle = (byte)(0) ;
      WebComp_Wcprotocolowc_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, "gxHTMLWrpW0035"+"", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(WebComp_Wcprotocolowc_Visible), 5, 0), true);
      dynavEnfid.setJsonclick( "" );
      dynavEnfid.setEnabled( 1 );
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Protocolow2" );
      subGrid2_Rows = 0 ;
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
      /* Using cursor H00155 */
      pr_default.execute(3);
      while ( (pr_default.getStatus(3) != 101) )
      {
         dynavEnfid.addItem(GXutil.trim( GXutil.str( H00155_A1EnfID[0], 10, 0)), H00155_A2EnfNombre[0], (short)(0));
         pr_default.readNext(3);
      }
      pr_default.close(3);
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV12EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV12EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12EnfID), 10, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV12EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID2.LOAD","{handler:'e12152',iparms:[{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV12EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID2.LOAD",",oparms:[{av:'AV13Editar_Contenido',fld:'vEDITAR_CONTENIDO',pic:''},{av:'AV8ProtID',fld:'vPROTID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV10CntdDesc',fld:'vCNTDDESC',pic:''},{av:'AV5CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("VEDITAR_CONTENIDO.CLICK","{handler:'e13152',iparms:[{av:'AV8ProtID',fld:'vPROTID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("VEDITAR_CONTENIDO.CLICK",",oparms:[{ctrl:'WCPROTOCOLOWC',prop:'Visible'},{ctrl:'WCPROTOCOLOWC'}]}");
      setEventMetadata("GRID2_FIRSTPAGE","{handler:'subgrid2_firstpage',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV12EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID2_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID2_PREVPAGE","{handler:'subgrid2_previouspage',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV12EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID2_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID2_NEXTPAGE","{handler:'subgrid2_nextpage',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV12EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID2_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID2_LASTPAGE","{handler:'subgrid2_lastpage',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'subGrid2_Rows',ctrl:'GRID2',prop:'Rows'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'A25ProtID',fld:'PROTID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV12EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'subGrid2_Recordcount'}]");
      setEventMetadata("GRID2_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALIDV_ENFID","{handler:'validv_Enfid',iparms:[]");
      setEventMetadata("VALIDV_ENFID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Editar_contenido',iparms:[]");
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
      A24CntdDesc = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      Grid2_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ucGrid2_empowerer = new com.genexus.webpanels.GXUserControl();
      Grid2Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV10CntdDesc = "" ;
      AV13Editar_Contenido = "" ;
      OldWcprotocolowc = "" ;
      WebComp_Wcprotocolowc_Component = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      H00152_A1EnfID = new long[1] ;
      H00152_n1EnfID = new boolean[] {false} ;
      H00152_A2EnfNombre = new String[] {""} ;
      H00152_n2EnfNombre = new boolean[] {false} ;
      H00153_A1EnfID = new long[1] ;
      H00153_n1EnfID = new boolean[] {false} ;
      H00153_A2EnfNombre = new String[] {""} ;
      H00153_n2EnfNombre = new boolean[] {false} ;
      H00154_A1EnfID = new long[1] ;
      H00154_n1EnfID = new boolean[] {false} ;
      H00154_A25ProtID = new long[1] ;
      H00154_A24CntdDesc = new String[] {""} ;
      H00154_A23CntdID = new long[1] ;
      H00154_n23CntdID = new boolean[] {false} ;
      Grid2Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid2_Linesclass = "" ;
      ROClassString = "" ;
      Grid2Column = new com.genexus.webpanels.GXWebColumn();
      H00155_A1EnfID = new long[1] ;
      H00155_n1EnfID = new boolean[] {false} ;
      H00155_A2EnfNombre = new String[] {""} ;
      H00155_n2EnfNombre = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.protocolow3__default(),
         new Object[] {
             new Object[] {
            H00152_A1EnfID, H00152_A2EnfNombre, H00152_n2EnfNombre
            }
            , new Object[] {
            H00153_A1EnfID, H00153_A2EnfNombre, H00153_n2EnfNombre
            }
            , new Object[] {
            H00154_A1EnfID, H00154_n1EnfID, H00154_A25ProtID, H00154_A24CntdDesc, H00154_A23CntdID, H00154_n23CntdID
            }
            , new Object[] {
            H00155_A1EnfID, H00155_A2EnfNombre, H00155_n2EnfNombre
            }
         }
      );
      /* GeneXus formulas. */
      edtavCntddesc_Enabled = 0 ;
      edtavCntdid_Enabled = 0 ;
      edtavProtid_Enabled = 0 ;
      edtavEditar_contenido_Enabled = 0 ;
      WebComp_Wcprotocolowc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GRID2_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGrid2_Backcolorstyle ;
   private byte nGXWrapped ;
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
   private short nCmpId ;
   private short gxcookieaux ;
   private int nRC_GXsfl_26 ;
   private int subGrid2_Recordcount ;
   private int subGrid2_Rows ;
   private int nGXsfl_26_idx=1 ;
   private int gxdynajaxindex ;
   private int subGrid2_Islastpage ;
   private int edtavCntddesc_Enabled ;
   private int edtavCntdid_Enabled ;
   private int edtavProtid_Enabled ;
   private int edtavEditar_contenido_Enabled ;
   private int WebComp_Wcprotocolowc_Visible ;
   private int GRID2_nGridOutOfScope ;
   private int idxLst ;
   private int subGrid2_Backcolor ;
   private int subGrid2_Allbackcolor ;
   private int edtavCntddesc_Visible ;
   private int edtavCntdid_Visible ;
   private int edtavProtid_Visible ;
   private int edtavEditar_contenido_Visible ;
   private int subGrid2_Titlebackcolor ;
   private int subGrid2_Selectedindex ;
   private int subGrid2_Selectioncolor ;
   private int subGrid2_Hoveringcolor ;
   private long GRID2_nFirstRecordOnPage ;
   private long A1EnfID ;
   private long AV12EnfID ;
   private long A25ProtID ;
   private long A23CntdID ;
   private long AV5CntdID ;
   private long AV8ProtID ;
   private long GRID2_nCurrentRecord ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_26_idx="0001" ;
   private String A24CntdDesc ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Grid2_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String TempTags ;
   private String divTablerigth_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Grid2_empowerer_Internalname ;
   private String sStyleString ;
   private String subGrid2_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV10CntdDesc ;
   private String edtavCntddesc_Internalname ;
   private String edtavCntdid_Internalname ;
   private String edtavProtid_Internalname ;
   private String AV13Editar_Contenido ;
   private String edtavEditar_contenido_Internalname ;
   private String OldWcprotocolowc ;
   private String WebComp_Wcprotocolowc_Component ;
   private String gxwrpcisep ;
   private String tblTablemergedunnamedtable2_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String divUnnamedtable3_Internalname ;
   private String sGXsfl_26_fel_idx="0001" ;
   private String subGrid2_Class ;
   private String subGrid2_Linesclass ;
   private String ROClassString ;
   private String edtavCntddesc_Jsonclick ;
   private String edtavCntdid_Jsonclick ;
   private String edtavProtid_Jsonclick ;
   private String edtavEditar_contenido_Jsonclick ;
   private String subGrid2_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1EnfID ;
   private boolean n23CntdID ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_26_Refreshing=false ;
   private boolean returnInSub ;
   private com.genexus.webpanels.GXWebGrid Grid2Container ;
   private com.genexus.webpanels.GXWebRow Grid2Row ;
   private com.genexus.webpanels.GXWebColumn Grid2Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wcprotocolowc ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucGrid2_empowerer ;
   private HTMLChoice dynavEnfid ;
   private IDataStoreProvider pr_default ;
   private long[] H00152_A1EnfID ;
   private boolean[] H00152_n1EnfID ;
   private String[] H00152_A2EnfNombre ;
   private boolean[] H00152_n2EnfNombre ;
   private long[] H00153_A1EnfID ;
   private boolean[] H00153_n1EnfID ;
   private String[] H00153_A2EnfNombre ;
   private boolean[] H00153_n2EnfNombre ;
   private long[] H00154_A1EnfID ;
   private boolean[] H00154_n1EnfID ;
   private long[] H00154_A25ProtID ;
   private String[] H00154_A24CntdDesc ;
   private long[] H00154_A23CntdID ;
   private boolean[] H00154_n23CntdID ;
   private long[] H00155_A1EnfID ;
   private boolean[] H00155_n1EnfID ;
   private String[] H00155_A2EnfNombre ;
   private boolean[] H00155_n2EnfNombre ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class protocolow3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00152", "SELECT EnfID, EnfNombre FROM Enfermedades ORDER BY EnfNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00153", "SELECT EnfID, EnfNombre FROM Enfermedades ORDER BY EnfNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00154", "SELECT T1.EnfID, T1.ProtID, T2.CntdDesc, T1.CntdID FROM (Protocolo T1 LEFT JOIN Contenidos T2 ON T2.CntdID = T1.CntdID) WHERE T1.EnfID = ? ORDER BY T1.EnfID ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00155", "SELECT EnfID, EnfNombre FROM Enfermedades ORDER BY EnfNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((long[]) buf[2])[0] = rslt.getLong(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 60);
               ((long[]) buf[4])[0] = rslt.getLong(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

