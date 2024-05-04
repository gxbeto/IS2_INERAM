package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class protocoloconsultar_impl extends GXDataArea
{
   public protocoloconsultar_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public protocoloconsultar_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( protocoloconsultar_impl.class ));
   }

   public protocoloconsultar_impl( int remoteHandle ,
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
      nRC_GXsfl_25 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_25"))) ;
      nGXsfl_25_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_25_idx"))) ;
      sGXsfl_25_idx = httpContext.GetPar( "sGXsfl_25_idx") ;
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
      A1EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
      n1EnfID = false ;
      dynavEnfid.fromJSonString( httpContext.GetNextPar( ));
      AV11EnfID = GXutil.lval( httpContext.GetPar( "EnfID")) ;
      A23CntdID = GXutil.lval( httpContext.GetPar( "CntdID")) ;
      n23CntdID = false ;
      dynavCntdid.fromJSonString( httpContext.GetNextPar( ));
      AV5CntdID = GXutil.lval( httpContext.GetPar( "CntdID")) ;
      A24CntdDesc = httpContext.GetPar( "CntdDesc") ;
      A27ProtTxt = httpContext.GetPar( "ProtTxt") ;
      n27ProtTxt = false ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid2_refresh( A1EnfID, AV11EnfID, A23CntdID, AV5CntdID, A24CntdDesc, A27ProtTxt) ;
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
      pa1A2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1A2( ) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.protocoloconsultar", new String[] {}, new String[] {}) +"\">") ;
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
      com.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_25", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_25, (byte)(8), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "ENFID", GXutil.ltrim( localUtil.ntoc( A1EnfID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "CNTDID", GXutil.ltrim( localUtil.ntoc( A23CntdID, (byte)(10), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, "CNTDDESC", GXutil.rtrim( A24CntdDesc));
      com.GxWebStd.gx_hidden_field( httpContext, "PROTTXT", A27ProtTxt);
      com.GxWebStd.gx_hidden_field( httpContext, "subGrid2_Recordcount", GXutil.ltrim( localUtil.ntoc( subGrid2_Recordcount, (byte)(5), (byte)(0), ",", "")));
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
         we1A2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1A2( ) ;
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
      return formatLink("com.protocoloconsultar", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "ProtocoloConsultar" ;
   }

   public String getPgmdesc( )
   {
      return "Protocolo: Definicion de Contenidos " ;
   }

   public void wb1A0( )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'" + sGXsfl_25_idx + "',0)\"" ;
         /* ComboBox */
         com.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEnfid, dynavEnfid.getInternalname(), GXutil.trim( GXutil.str( AV11EnfID, 10, 0)), 1, dynavEnfid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEnfid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,17);\"", "", true, (byte)(0), "HLP_ProtocoloConsultar.htm");
         dynavEnfid.setValue( GXutil.trim( GXutil.str( AV11EnfID, 10, 0)) );
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'" + sGXsfl_25_idx + "',0)\"" ;
         /* ComboBox */
         com.GxWebStd.gx_combobox_ctrl1( httpContext, dynavCntdid, dynavCntdid.getInternalname(), GXutil.trim( GXutil.str( AV5CntdID, 10, 0)), 1, dynavCntdid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavCntdid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_ProtocoloConsultar.htm");
         dynavCntdid.setValue( GXutil.trim( GXutil.str( AV5CntdID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavCntdid.getInternalname(), "Values", dynavCntdid.ToJavascriptSource(), true);
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /*  Grid Control  */
         Grid2Container.SetIsFreestyle(true);
         Grid2Container.SetWrapped(nGXWrapped);
         startgridcontrol25( ) ;
      }
      if ( wbEnd == 25 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_25 = (int)(nGXsfl_25_idx-1) ;
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
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 25 )
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

   public void start1A2( )
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
      Form.getMeta().addItem("description", "Protocolo: Definicion de Contenidos ", (short)(0)) ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1A0( ) ;
   }

   public void ws1A2( )
   {
      start1A2( ) ;
      evt1A2( ) ;
   }

   public void evt1A2( )
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID2.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_25_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_252( ) ;
                           AV17ProtTxt = httpContext.cgiGet( edtavProttxt_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavProttxt_Internalname, AV17ProtTxt);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e111A2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID2.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e121A2 ();
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

   public void we1A2( )
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

   public void pa1A2( )
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

   public void gxdlvvcntdid1A1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvcntdid_data1A1( ) ;
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

   public void gxvvcntdid_html1A1( )
   {
      long gxdynajaxvalue;
      gxdlvvcntdid_data1A1( ) ;
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
         AV5CntdID = GXutil.lval( dynavCntdid.getValidValue(GXutil.trim( GXutil.str( AV5CntdID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CntdID), 10, 0));
      }
   }

   protected void gxdlvvcntdid_data1A1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H001A2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H001A2_A23CntdID[0], (byte)(10), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(GXutil.rtrim( H001A2_A24CntdDesc[0]));
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvenfid1A1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvenfid_data1A1( ) ;
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

   public void gxvvenfid_html1A1( )
   {
      long gxdynajaxvalue;
      gxdlvvenfid_data1A1( ) ;
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
         AV11EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV11EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EnfID), 10, 0));
      }
   }

   protected void gxdlvvenfid_data1A1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H001A3 */
      pr_default.execute(1);
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H001A3_A1EnfID[0], (byte)(10), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(GXutil.rtrim( H001A3_A2EnfNombre[0]));
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxnrgrid2_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_252( ) ;
      while ( nGXsfl_25_idx <= nRC_GXsfl_25 )
      {
         sendrow_252( ) ;
         nGXsfl_25_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_25_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_25_idx+1) ;
         sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_252( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid2Container)) ;
      /* End function gxnrGrid2_newrow */
   }

   public void gxgrgrid2_refresh( long A1EnfID ,
                                  long AV11EnfID ,
                                  long A23CntdID ,
                                  long AV5CntdID ,
                                  String A24CntdDesc ,
                                  String A27ProtTxt )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID2_nCurrentRecord = 0 ;
      rf1A2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid2_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavCntdid.setName( "vCNTDID" );
         dynavCntdid.setWebtags( "" );
         dynavCntdid.removeAllItems();
         /* Using cursor H001A4 */
         pr_default.execute(2);
         while ( (pr_default.getStatus(2) != 101) )
         {
            dynavCntdid.addItem(GXutil.trim( GXutil.str( H001A4_A23CntdID[0], 10, 0)), H001A4_A24CntdDesc[0], (short)(0));
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( dynavCntdid.getItemCount() > 0 )
         {
            AV5CntdID = GXutil.lval( dynavCntdid.getValidValue(GXutil.trim( GXutil.str( AV5CntdID, 10, 0)))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CntdID), 10, 0));
         }
         dynavEnfid.setName( "vENFID" );
         dynavEnfid.setWebtags( "" );
         dynavEnfid.removeAllItems();
         /* Using cursor H001A5 */
         pr_default.execute(3);
         while ( (pr_default.getStatus(3) != 101) )
         {
            dynavEnfid.addItem(GXutil.trim( GXutil.str( H001A5_A1EnfID[0], 10, 0)), H001A5_A2EnfNombre[0], (short)(0));
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( dynavEnfid.getItemCount() > 0 )
         {
            AV11EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV11EnfID, 10, 0)))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EnfID), 10, 0));
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV11EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV11EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EnfID), 10, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEnfid.setValue( GXutil.trim( GXutil.str( AV11EnfID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEnfid.getInternalname(), "Values", dynavEnfid.ToJavascriptSource(), true);
      }
      if ( dynavCntdid.getItemCount() > 0 )
      {
         AV5CntdID = GXutil.lval( dynavCntdid.getValidValue(GXutil.trim( GXutil.str( AV5CntdID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CntdID), 10, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavCntdid.setValue( GXutil.trim( GXutil.str( AV5CntdID, 10, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavCntdid.getInternalname(), "Values", dynavCntdid.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1A2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavProttxt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProttxt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProttxt_Enabled), 5, 0), !bGXsfl_25_Refreshing);
   }

   public void rf1A2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid2Container.ClearRows();
      }
      wbStart = (short)(25) ;
      nGXsfl_25_idx = 1 ;
      sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_252( ) ;
      bGXsfl_25_Refreshing = true ;
      Grid2Container.AddObjectProperty("GridName", "Grid2");
      Grid2Container.AddObjectProperty("CmpContext", "");
      Grid2Container.AddObjectProperty("InMasterPage", "false");
      Grid2Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      Grid2Container.AddObjectProperty("Class", "FreeStyleGrid");
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
         subsflControlProps_252( ) ;
         e121A2 ();
         wbEnd = (short)(25) ;
         wb1A0( ) ;
      }
      bGXsfl_25_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1A2( )
   {
   }

   public int subgrid2_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      edtavProttxt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProttxt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProttxt_Enabled), 5, 0), !bGXsfl_25_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1A0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_25 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_25"), ",", ".")) ;
         subGrid2_Recordcount = (int)(localUtil.ctol( httpContext.cgiGet( "subGrid2_Recordcount"), ",", ".")) ;
         /* Read variables values. */
         dynavEnfid.setName( dynavEnfid.getInternalname() );
         dynavEnfid.setValue( httpContext.cgiGet( dynavEnfid.getInternalname()) );
         AV11EnfID = GXutil.lval( httpContext.cgiGet( dynavEnfid.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EnfID), 10, 0));
         dynavCntdid.setName( dynavCntdid.getInternalname() );
         dynavCntdid.setValue( httpContext.cgiGet( dynavCntdid.getInternalname()) );
         AV5CntdID = GXutil.lval( httpContext.cgiGet( dynavCntdid.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CntdID), 10, 0));
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
      e111A2 ();
      if (returnInSub) return;
   }

   public void e111A2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   private void e121A2( )
   {
      /* Grid2_Load Routine */
      returnInSub = false ;
      AV18GXLvl20 = (byte)(0) ;
      /* Using cursor H001A6 */
      pr_default.execute(4, new Object[] {Long.valueOf(AV5CntdID), Long.valueOf(AV11EnfID)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A23CntdID = H001A6_A23CntdID[0] ;
         n23CntdID = H001A6_n23CntdID[0] ;
         A1EnfID = H001A6_A1EnfID[0] ;
         n1EnfID = H001A6_n1EnfID[0] ;
         A24CntdDesc = H001A6_A24CntdDesc[0] ;
         A27ProtTxt = H001A6_A27ProtTxt[0] ;
         n27ProtTxt = H001A6_n27ProtTxt[0] ;
         A24CntdDesc = H001A6_A24CntdDesc[0] ;
         AV18GXLvl20 = (byte)(1) ;
         AV17ProtTxt = GXutil.trim( A24CntdDesc) ;
         httpContext.ajax_rsp_assign_attri("", false, edtavProttxt_Internalname, AV17ProtTxt);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(25) ;
         }
         sendrow_252( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_25_Refreshing )
         {
            httpContext.doAjaxLoad(25, Grid2Row);
         }
         AV17ProtTxt = A27ProtTxt ;
         httpContext.ajax_rsp_assign_attri("", false, edtavProttxt_Internalname, AV17ProtTxt);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(25) ;
         }
         sendrow_252( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_25_Refreshing )
         {
            httpContext.doAjaxLoad(25, Grid2Row);
         }
         pr_default.readNext(4);
      }
      pr_default.close(4);
      if ( AV18GXLvl20 == 0 )
      {
         AV17ProtTxt = "No se encontro contenido." ;
         httpContext.ajax_rsp_assign_attri("", false, edtavProttxt_Internalname, AV17ProtTxt);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(25) ;
         }
         sendrow_252( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_25_Refreshing )
         {
            httpContext.doAjaxLoad(25, Grid2Row);
         }
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
      pa1A2( ) ;
      ws1A2( ) ;
      we1A2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442618163428", true, true);
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
         httpContext.AddJavascriptSource("protocoloconsultar.js", "?202442618163428", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_252( )
   {
      edtavProttxt_Internalname = "vPROTTXT_"+sGXsfl_25_idx ;
   }

   public void subsflControlProps_fel_252( )
   {
      edtavProttxt_Internalname = "vPROTTXT_"+sGXsfl_25_fel_idx ;
   }

   public void sendrow_252( )
   {
      subsflControlProps_252( ) ;
      wb1A0( ) ;
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
         subGrid2_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGrid2_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGrid2_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_25_idx) % (2))) == 0 )
         {
            subGrid2_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Even" ;
            }
         }
         else
         {
            subGrid2_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Grid2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGrid2_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_25_idx+"\">") ;
      }
      /* Table start */
      Grid2Row.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblGrid2layouttable_Internalname+"_"+sGXsfl_25_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Grid2Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Grid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","start","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavProttxt_Internalname,"Contenido","gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      Grid2Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavProttxt_Internalname,AV17ProtTxt,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(edtavProttxt_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",Integer.valueOf(0),StyleString,ClassString,"","","10240",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0),""});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"start","top","div"});
      if ( Grid2Container.GetWrapped() == 1 )
      {
         Grid2Container.CloseTag("cell");
      }
      if ( Grid2Container.GetWrapped() == 1 )
      {
         Grid2Container.CloseTag("row");
      }
      if ( Grid2Container.GetWrapped() == 1 )
      {
         Grid2Container.CloseTag("table");
      }
      /* End of table */
      send_integrity_lvl_hashes1A2( ) ;
      /* End of Columns property logic. */
      Grid2Container.AddRow(Grid2Row);
      nGXsfl_25_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_25_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_25_idx+1) ;
      sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_252( ) ;
      /* End function sendrow_252 */
   }

   public void startgridcontrol25( )
   {
      if ( Grid2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid2Container"+"DivS\" data-gxgridid=\"25\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGrid2_Internalname, subGrid2_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         Grid2Container.AddObjectProperty("GridName", "Grid2");
      }
      else
      {
         Grid2Container.AddObjectProperty("GridName", "Grid2");
         Grid2Container.AddObjectProperty("Header", subGrid2_Header);
         Grid2Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         Grid2Container.AddObjectProperty("Class", "FreeStyleGrid");
         Grid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Grid2Container.AddObjectProperty("CmpContext", "");
         Grid2Container.AddObjectProperty("InMasterPage", "false");
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Container.AddColumnProperties(Grid2Column);
         Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid2Column.AddObjectProperty("Value", WebUtils.htmlEncode( AV17ProtTxt));
         Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavProttxt_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      edtavProttxt_Internalname = "vPROTTXT" ;
      tblGrid2layouttable_Internalname = "GRID2LAYOUTTABLE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      edtavProttxt_Enabled = 0 ;
      subGrid2_Class = "FreeStyleGrid" ;
      subGrid2_Backcolorstyle = (byte)(0) ;
      dynavCntdid.setJsonclick( "" );
      dynavCntdid.setEnabled( 1 );
      dynavEnfid.setJsonclick( "" );
      dynavEnfid.setEnabled( 1 );
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Protocolo: Definicion de Contenidos " );
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
      /* Using cursor H001A7 */
      pr_default.execute(5);
      while ( (pr_default.getStatus(5) != 101) )
      {
         dynavEnfid.addItem(GXutil.trim( GXutil.str( H001A7_A1EnfID[0], 10, 0)), H001A7_A2EnfNombre[0], (short)(0));
         pr_default.readNext(5);
      }
      pr_default.close(5);
      if ( dynavEnfid.getItemCount() > 0 )
      {
         AV11EnfID = GXutil.lval( dynavEnfid.getValidValue(GXutil.trim( GXutil.str( AV11EnfID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11EnfID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EnfID), 10, 0));
      }
      dynavCntdid.setName( "vCNTDID" );
      dynavCntdid.setWebtags( "" );
      dynavCntdid.removeAllItems();
      /* Using cursor H001A8 */
      pr_default.execute(6);
      while ( (pr_default.getStatus(6) != 101) )
      {
         dynavCntdid.addItem(GXutil.trim( GXutil.str( H001A8_A23CntdID[0], 10, 0)), H001A8_A24CntdDesc[0], (short)(0));
         pr_default.readNext(6);
      }
      pr_default.close(6);
      if ( dynavCntdid.getItemCount() > 0 )
      {
         AV5CntdID = GXutil.lval( dynavCntdid.getValidValue(GXutil.trim( GXutil.str( AV5CntdID, 10, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CntdID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CntdID), 10, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'A27ProtTxt',fld:'PROTTXT',pic:''},{av:'dynavCntdid'},{av:'AV5CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV11EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID2.LOAD","{handler:'e121A2',iparms:[{av:'A1EnfID',fld:'ENFID',pic:'ZZZZZZZZZ9'},{av:'dynavEnfid'},{av:'AV11EnfID',fld:'vENFID',pic:'ZZZZZZZZZ9'},{av:'A23CntdID',fld:'CNTDID',pic:'ZZZZZZZZZ9'},{av:'dynavCntdid'},{av:'AV5CntdID',fld:'vCNTDID',pic:'ZZZZZZZZZ9'},{av:'A24CntdDesc',fld:'CNTDDESC',pic:''},{av:'A27ProtTxt',fld:'PROTTXT',pic:''}]");
      setEventMetadata("GRID2.LOAD",",oparms:[{av:'AV17ProtTxt',fld:'vPROTTXT',pic:''}]}");
      setEventMetadata("VALIDV_CNTDID","{handler:'validv_Cntdid',iparms:[]");
      setEventMetadata("VALIDV_CNTDID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Prottxt',iparms:[]");
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
      A27ProtTxt = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      Grid2Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17ProtTxt = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      H001A2_A23CntdID = new long[1] ;
      H001A2_n23CntdID = new boolean[] {false} ;
      H001A2_A24CntdDesc = new String[] {""} ;
      H001A3_A1EnfID = new long[1] ;
      H001A3_n1EnfID = new boolean[] {false} ;
      H001A3_A2EnfNombre = new String[] {""} ;
      H001A3_n2EnfNombre = new boolean[] {false} ;
      H001A4_A23CntdID = new long[1] ;
      H001A4_n23CntdID = new boolean[] {false} ;
      H001A4_A24CntdDesc = new String[] {""} ;
      H001A5_A1EnfID = new long[1] ;
      H001A5_n1EnfID = new boolean[] {false} ;
      H001A5_A2EnfNombre = new String[] {""} ;
      H001A5_n2EnfNombre = new boolean[] {false} ;
      H001A6_A25ProtID = new long[1] ;
      H001A6_A23CntdID = new long[1] ;
      H001A6_n23CntdID = new boolean[] {false} ;
      H001A6_A1EnfID = new long[1] ;
      H001A6_n1EnfID = new boolean[] {false} ;
      H001A6_A24CntdDesc = new String[] {""} ;
      H001A6_A27ProtTxt = new String[] {""} ;
      H001A6_n27ProtTxt = new boolean[] {false} ;
      Grid2Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid2_Linesclass = "" ;
      subGrid2_Header = "" ;
      Grid2Column = new com.genexus.webpanels.GXWebColumn();
      H001A7_A1EnfID = new long[1] ;
      H001A7_n1EnfID = new boolean[] {false} ;
      H001A7_A2EnfNombre = new String[] {""} ;
      H001A7_n2EnfNombre = new boolean[] {false} ;
      H001A8_A23CntdID = new long[1] ;
      H001A8_n23CntdID = new boolean[] {false} ;
      H001A8_A24CntdDesc = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.protocoloconsultar__default(),
         new Object[] {
             new Object[] {
            H001A2_A23CntdID, H001A2_A24CntdDesc
            }
            , new Object[] {
            H001A3_A1EnfID, H001A3_A2EnfNombre, H001A3_n2EnfNombre
            }
            , new Object[] {
            H001A4_A23CntdID, H001A4_A24CntdDesc
            }
            , new Object[] {
            H001A5_A1EnfID, H001A5_A2EnfNombre, H001A5_n2EnfNombre
            }
            , new Object[] {
            H001A6_A25ProtID, H001A6_A23CntdID, H001A6_n23CntdID, H001A6_A1EnfID, H001A6_n1EnfID, H001A6_A24CntdDesc, H001A6_A27ProtTxt, H001A6_n27ProtTxt
            }
            , new Object[] {
            H001A7_A1EnfID, H001A7_A2EnfNombre, H001A7_n2EnfNombre
            }
            , new Object[] {
            H001A8_A23CntdID, H001A8_A24CntdDesc
            }
         }
      );
      /* GeneXus formulas. */
      edtavProttxt_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGrid2_Backcolorstyle ;
   private byte AV18GXLvl20 ;
   private byte subGrid2_Backstyle ;
   private byte subGrid2_Allowselection ;
   private byte subGrid2_Allowhovering ;
   private byte subGrid2_Allowcollapsing ;
   private byte subGrid2_Collapsed ;
   private byte GRID2_nEOF ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int nRC_GXsfl_25 ;
   private int subGrid2_Recordcount ;
   private int nGXsfl_25_idx=1 ;
   private int gxdynajaxindex ;
   private int subGrid2_Islastpage ;
   private int edtavProttxt_Enabled ;
   private int idxLst ;
   private int subGrid2_Backcolor ;
   private int subGrid2_Allbackcolor ;
   private int subGrid2_Selectedindex ;
   private int subGrid2_Selectioncolor ;
   private int subGrid2_Hoveringcolor ;
   private long A1EnfID ;
   private long AV11EnfID ;
   private long A23CntdID ;
   private long AV5CntdID ;
   private long GRID2_nCurrentRecord ;
   private long GRID2_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_25_idx="0001" ;
   private String A24CntdDesc ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String TempTags ;
   private String sStyleString ;
   private String subGrid2_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavProttxt_Internalname ;
   private String gxwrpcisep ;
   private String sGXsfl_25_fel_idx="0001" ;
   private String subGrid2_Class ;
   private String subGrid2_Linesclass ;
   private String tblGrid2layouttable_Internalname ;
   private String subGrid2_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1EnfID ;
   private boolean n23CntdID ;
   private boolean n27ProtTxt ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_25_Refreshing=false ;
   private boolean returnInSub ;
   private String A27ProtTxt ;
   private String AV17ProtTxt ;
   private com.genexus.webpanels.GXWebGrid Grid2Container ;
   private com.genexus.webpanels.GXWebRow Grid2Row ;
   private com.genexus.webpanels.GXWebColumn Grid2Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private HTMLChoice dynavEnfid ;
   private HTMLChoice dynavCntdid ;
   private IDataStoreProvider pr_default ;
   private long[] H001A2_A23CntdID ;
   private boolean[] H001A2_n23CntdID ;
   private String[] H001A2_A24CntdDesc ;
   private long[] H001A3_A1EnfID ;
   private boolean[] H001A3_n1EnfID ;
   private String[] H001A3_A2EnfNombre ;
   private boolean[] H001A3_n2EnfNombre ;
   private long[] H001A4_A23CntdID ;
   private boolean[] H001A4_n23CntdID ;
   private String[] H001A4_A24CntdDesc ;
   private long[] H001A5_A1EnfID ;
   private boolean[] H001A5_n1EnfID ;
   private String[] H001A5_A2EnfNombre ;
   private boolean[] H001A5_n2EnfNombre ;
   private long[] H001A6_A25ProtID ;
   private long[] H001A6_A23CntdID ;
   private boolean[] H001A6_n23CntdID ;
   private long[] H001A6_A1EnfID ;
   private boolean[] H001A6_n1EnfID ;
   private String[] H001A6_A24CntdDesc ;
   private String[] H001A6_A27ProtTxt ;
   private boolean[] H001A6_n27ProtTxt ;
   private long[] H001A7_A1EnfID ;
   private boolean[] H001A7_n1EnfID ;
   private String[] H001A7_A2EnfNombre ;
   private boolean[] H001A7_n2EnfNombre ;
   private long[] H001A8_A23CntdID ;
   private boolean[] H001A8_n23CntdID ;
   private String[] H001A8_A24CntdDesc ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class protocoloconsultar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001A2", "SELECT CntdID, CntdDesc FROM Contenidos ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001A3", "SELECT EnfID, EnfNombre FROM Enfermedades ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001A4", "SELECT CntdID, CntdDesc FROM Contenidos ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001A5", "SELECT EnfID, EnfNombre FROM Enfermedades ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001A6", "SELECT T1.ProtID, T1.CntdID, T1.EnfID, T2.CntdDesc, T1.ProtTxt FROM (Protocolo T1 LEFT JOIN Contenidos T2 ON T2.CntdID = T1.CntdID) WHERE (T1.CntdID = ?) AND (T1.EnfID = ?) ORDER BY T1.CntdID ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001A7", "SELECT EnfID, EnfNombre FROM Enfermedades ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001A8", "SELECT CntdID, CntdDesc FROM Contenidos ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((long[]) buf[3])[0] = rslt.getLong(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 60);
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
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
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

