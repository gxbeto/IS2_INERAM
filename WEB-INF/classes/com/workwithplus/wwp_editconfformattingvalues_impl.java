package com.workwithplus ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_editconfformattingvalues_impl extends GXWebComponent
{
   public wwp_editconfformattingvalues_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_editconfformattingvalues_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_editconfformattingvalues_impl.class ));
   }

   public wwp_editconfformattingvalues_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "VarProgramName") ;
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
               AV7VarProgramName = httpContext.GetPar( "VarProgramName") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7VarProgramName", AV7VarProgramName);
               httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV6ConfFormattingVariables);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV7VarProgramName,AV6ConfFormattingVariables});
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
               gxfirstwebparm = httpContext.GetFirstPar( "VarProgramName") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "VarProgramName") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grids") == 0 )
            {
               gxnrgrids_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grids") == 0 )
            {
               gxgrgrids_refresh_invoke( ) ;
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

   public void gxnrgrids_newrow_invoke( )
   {
      nRC_GXsfl_15 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_15"))) ;
      nGXsfl_15_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_15_idx"))) ;
      sGXsfl_15_idx = httpContext.GetPar( "sGXsfl_15_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrids_newrow( ) ;
      /* End function gxnrGrids_newrow_invoke */
   }

   public void gxgrgrids_refresh_invoke( )
   {
      subGrids_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrids_Rows"))) ;
      httpContext.readJsonSdtValue(httpContext.GetNextPar( ), AV6ConfFormattingVariables);
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrids_refresh( subGrids_Rows, AV6ConfFormattingVariables, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrids_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa0P2( ) ;
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
         httpContext.writeValue( "Settings") ;
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
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.workwithplus.wwp_editconfformattingvalues", new String[] {GXutil.URLEncode(GXutil.rtrim(AV7VarProgramName))}, new String[] {"VarProgramName","ConfFormattingVariables"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Confformattingvariables", AV6ConfFormattingVariables);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Confformattingvariables", AV6ConfFormattingVariables);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_15", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_15, (byte)(8), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV7VarProgramName", wcpOAV7VarProgramName);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCONFFORMATTINGVARIABLES", AV6ConfFormattingVariables);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCONFFORMATTINGVARIABLES", AV6ConfFormattingVariables);
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vVARPROGRAMNAME", AV7VarProgramName);
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGrids_Rows, (byte)(6), (byte)(0), ".", "")));
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_EMPOWERER_Gridinternalname", GXutil.rtrim( Grids_empowerer_Gridinternalname));
   }

   public void renderHtmlCloseForm0P2( )
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
      return "WorkWithPlus.WWP_EditConfFormattingValues" ;
   }

   public String getPgmdesc( )
   {
      return "Settings" ;
   }

   public void wb0P0( )
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
            com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.workwithplus.wwp_editconfformattingvalues");
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         com.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "Table", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "start", "top", "", "", "div");
         /*  Grid Control  */
         GridsContainer.SetWrapped(nGXWrapped);
         startgridcontrol15( ) ;
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_15 = (int)(nGXsfl_15_idx-1) ;
         if ( GridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridsContainer.AddObjectProperty("GRIDS_nEOF", GRIDS_nEOF);
            GridsContainer.AddObjectProperty("GRIDS_nFirstRecordOnPage", GRIDS_nFirstRecordOnPage);
            AV9GXV1 = nGXsfl_15_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grids", GridsContainer, subGrids_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridsContainerData", GridsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridsContainerData"+"V", GridsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridsContainerData"+"V"+"\" value='"+GridsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "start", "top", "", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "start", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction1_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Cancelar", bttBtnuseraction1_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e110p1_client"+"'", TempTags, "", 2, "HLP_WorkWithPlus/WWP_EditConfFormattingValues.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseractionreset_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Reset", bttBtnuseractionreset_Jsonclick, 5, "Reset", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOUSERACTIONRESET\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WorkWithPlus/WWP_EditConfFormattingValues.htm");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         /* Div Control */
         com.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "start", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Confirmar", bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WorkWithPlus/WWP_EditConfFormattingValues.htm");
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
         ucGrids_empowerer.render(context, "wwp.gridempowerer", Grids_empowerer_Internalname, sPrefix+"GRIDS_EMPOWERERContainer");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
         com.GxWebStd.gx_div_end( httpContext, "start", "top", "div");
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridsContainer.AddObjectProperty("GRIDS_nEOF", GRIDS_nEOF);
               GridsContainer.AddObjectProperty("GRIDS_nFirstRecordOnPage", GRIDS_nFirstRecordOnPage);
               AV9GXV1 = nGXsfl_15_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"GridsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grids", GridsContainer, subGrids_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridsContainerData", GridsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridsContainerData"+"V", GridsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridsContainerData"+"V"+"\" value='"+GridsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start0P2( )
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
         Form.getMeta().addItem("description", "Settings", (short)(0)) ;
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
            strup0P0( ) ;
         }
      }
   }

   public void ws0P2( )
   {
      start0P2( ) ;
      evt0P2( ) ;
   }

   public void evt0P2( )
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
                              strup0P0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTIONRESET'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoUserActionReset' */
                                 e120P2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0P0( ) ;
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
                                       e130P2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavConfformattingvariables__description_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0P0( ) ;
                           }
                           sEvt = httpContext.cgiGet( sPrefix+"GRIDSPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrids_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrids_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrids_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrids_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRIDS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0P0( ) ;
                           }
                           nGXsfl_15_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_152( ) ;
                           AV9GXV1 = (int)(nGXsfl_15_idx+GRIDS_nFirstRecordOnPage) ;
                           if ( ( AV6ConfFormattingVariables.size() >= AV9GXV1 ) && ( AV9GXV1 > 0 ) )
                           {
                              AV6ConfFormattingVariables.currentItem( ((com.workwithplus.SdtWWPConfFormattingVariable)AV6ConfFormattingVariables.elementAt(-1+AV9GXV1)) );
                              if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavDefaultvalue_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavDefaultvalue_Internalname), ",", ".") > 9999999999L ) ) )
                              {
                                 httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vDEFAULTVALUE");
                                 GX_FocusControl = edtavDefaultvalue_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                 wbErr = true ;
                                 AV8DefaultValue = 0 ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDefaultvalue_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8DefaultValue), 10, 0));
                              }
                              else
                              {
                                 AV8DefaultValue = localUtil.ctol( httpContext.cgiGet( edtavDefaultvalue_Internalname), ",", ".") ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDefaultvalue_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8DefaultValue), 10, 0));
                              }
                           }
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
                                       GX_FocusControl = edtavConfformattingvariables__description_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e140P2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDS.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavConfformattingvariables__description_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e150P2 ();
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup0P0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavConfformattingvariables__description_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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

   public void we0P2( )
   {
      if ( ! com.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0P2( ) ;
         }
      }
   }

   public void pa0P2( )
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

   public void gxnrgrids_newrow( )
   {
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_152( ) ;
      while ( nGXsfl_15_idx <= nRC_GXsfl_15 )
      {
         sendrow_152( ) ;
         nGXsfl_15_idx = ((subGrids_Islastpage==1)&&(nGXsfl_15_idx+1>subgrids_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsContainer)) ;
      /* End function gxnrGrids_newrow */
   }

   public void gxgrgrids_refresh( int subGrids_Rows ,
                                  GXBaseCollection<com.workwithplus.SdtWWPConfFormattingVariable> AV6ConfFormattingVariables ,
                                  String sPrefix )
   {
      initialize_formulas( ) ;
      com.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDS_nCurrentRecord = 0 ;
      rf0P2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrids_refresh */
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
      rf0P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      edtavConfformattingvariables__description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConfformattingvariables__description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConfformattingvariables__description_Enabled), 5, 0), !bGXsfl_15_Refreshing);
   }

   public void rf0P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsContainer.ClearRows();
      }
      wbStart = (short)(15) ;
      nGXsfl_15_idx = 1 ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      bGXsfl_15_Refreshing = true ;
      GridsContainer.AddObjectProperty("GridName", "Grids");
      GridsContainer.AddObjectProperty("CmpContext", sPrefix);
      GridsContainer.AddObjectProperty("InMasterPage", "false");
      GridsContainer.AddObjectProperty("Class", "WorkWith");
      GridsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrids_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsContainer.setPageSize( subgrids_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_152( ) ;
         e150P2 ();
         if ( ( subGrids_Islastpage == 0 ) && ( GRIDS_nCurrentRecord > 0 ) && ( GRIDS_nGridOutOfScope == 0 ) && ( nGXsfl_15_idx == 1 ) )
         {
            GRIDS_nCurrentRecord = 0 ;
            GRIDS_nGridOutOfScope = 1 ;
            subgrids_firstpage( ) ;
            e150P2 ();
         }
         wbEnd = (short)(15) ;
         wb0P0( ) ;
      }
      bGXsfl_15_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0P2( )
   {
   }

   public int subgrids_fnc_pagecount( )
   {
      GRIDS_nRecordCount = subgrids_fnc_recordcount( ) ;
      if ( ((int)((GRIDS_nRecordCount) % (subgrids_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRIDS_nRecordCount).divide(DecimalUtil.doubleToDec(subgrids_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))) ;
      }
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRIDS_nRecordCount).divide(DecimalUtil.doubleToDec(subgrids_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public int subgrids_fnc_recordcount( )
   {
      return AV6ConfFormattingVariables.size() ;
   }

   public int subgrids_fnc_recordsperpage( )
   {
      if ( subGrids_Rows > 0 )
      {
         return subGrids_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrids_fnc_currentpage( )
   {
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRIDS_nFirstRecordOnPage).divide(DecimalUtil.doubleToDec(subgrids_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public short subgrids_firstpage( )
   {
      GRIDS_nFirstRecordOnPage = 0 ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrids_refresh( subGrids_Rows, AV6ConfFormattingVariables, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrids_nextpage( )
   {
      GRIDS_nRecordCount = subgrids_fnc_recordcount( ) ;
      if ( ( GRIDS_nRecordCount >= subgrids_fnc_recordsperpage( ) ) && ( GRIDS_nEOF == 0 ) )
      {
         GRIDS_nFirstRecordOnPage = (long)(GRIDS_nFirstRecordOnPage+subgrids_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsContainer.AddObjectProperty("GRIDS_nFirstRecordOnPage", GRIDS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrids_refresh( subGrids_Rows, AV6ConfFormattingVariables, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrids_previouspage( )
   {
      if ( GRIDS_nFirstRecordOnPage >= subgrids_fnc_recordsperpage( ) )
      {
         GRIDS_nFirstRecordOnPage = (long)(GRIDS_nFirstRecordOnPage-subgrids_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrids_refresh( subGrids_Rows, AV6ConfFormattingVariables, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrids_lastpage( )
   {
      GRIDS_nRecordCount = subgrids_fnc_recordcount( ) ;
      if ( GRIDS_nRecordCount > subgrids_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDS_nRecordCount) % (subgrids_fnc_recordsperpage( )))) == 0 )
         {
            GRIDS_nFirstRecordOnPage = (long)(GRIDS_nRecordCount-subgrids_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDS_nFirstRecordOnPage = (long)(GRIDS_nRecordCount-((int)((GRIDS_nRecordCount) % (subgrids_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDS_nFirstRecordOnPage = 0 ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrids_refresh( subGrids_Rows, AV6ConfFormattingVariables, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrids_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDS_nFirstRecordOnPage = (long)(subgrids_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDS_nFirstRecordOnPage = 0 ;
      }
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrids_refresh( subGrids_Rows, AV6ConfFormattingVariables, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      edtavConfformattingvariables__description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConfformattingvariables__description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConfformattingvariables__description_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup0P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e140P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"Confformattingvariables"), AV6ConfFormattingVariables);
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"vCONFFORMATTINGVARIABLES"), AV6ConfFormattingVariables);
         /* Read saved values. */
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_15"), ",", ".")) ;
         wcpOAV7VarProgramName = httpContext.cgiGet( sPrefix+"wcpOAV7VarProgramName") ;
         GRIDS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDS_nFirstRecordOnPage"), ",", ".") ;
         GRIDS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDS_nEOF"), ",", ".")) ;
         subGrids_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDS_Rows"), ",", ".")) ;
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGrids_Rows, (byte)(6), (byte)(0), ".", "")));
         Grids_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRIDS_EMPOWERER_Gridinternalname") ;
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_15"), ",", ".")) ;
         nGXsfl_15_fel_idx = 0 ;
         while ( nGXsfl_15_fel_idx < nRC_GXsfl_15 )
         {
            nGXsfl_15_fel_idx = ((subGrids_Islastpage==1)&&(nGXsfl_15_fel_idx+1>subgrids_fnc_recordsperpage( )) ? 1 : nGXsfl_15_fel_idx+1) ;
            sGXsfl_15_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_152( ) ;
            AV9GXV1 = (int)(nGXsfl_15_fel_idx+GRIDS_nFirstRecordOnPage) ;
            if ( ( AV6ConfFormattingVariables.size() >= AV9GXV1 ) && ( AV9GXV1 > 0 ) )
            {
               AV6ConfFormattingVariables.currentItem( ((com.workwithplus.SdtWWPConfFormattingVariable)AV6ConfFormattingVariables.elementAt(-1+AV9GXV1)) );
               if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavDefaultvalue_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavDefaultvalue_Internalname), ",", ".") > 9999999999L ) ) )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vDEFAULTVALUE");
                  GX_FocusControl = edtavDefaultvalue_Internalname ;
                  wbErr = true ;
                  AV8DefaultValue = 0 ;
               }
               else
               {
                  AV8DefaultValue = localUtil.ctol( httpContext.cgiGet( edtavDefaultvalue_Internalname), ",", ".") ;
               }
            }
         }
         if ( nGXsfl_15_fel_idx == 0 )
         {
            nGXsfl_15_idx = 1 ;
            sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_152( ) ;
         }
         nGXsfl_15_fel_idx = 1 ;
         /* Read variables values. */
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
      e140P2 ();
      if (returnInSub) return;
   }

   public void e140P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Grids_empowerer_Gridinternalname = subGrids_Internalname ;
      ucGrids_empowerer.sendProperty(context, sPrefix, false, Grids_empowerer_Internalname, "GridInternalName", Grids_empowerer_Gridinternalname);
      subGrids_Rows = 0 ;
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGrids_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   private void e150P2( )
   {
      /* Grids_Load Routine */
      returnInSub = false ;
      AV9GXV1 = 1 ;
      while ( AV9GXV1 <= AV6ConfFormattingVariables.size() )
      {
         AV6ConfFormattingVariables.currentItem( ((com.workwithplus.SdtWWPConfFormattingVariable)AV6ConfFormattingVariables.elementAt(-1+AV9GXV1)) );
         AV8DefaultValue = GXutil.lval( ((com.workwithplus.SdtWWPConfFormattingVariable)(AV6ConfFormattingVariables.currentItem())).getgxTv_SdtWWPConfFormattingVariable_Defaultvalue()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDefaultvalue_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8DefaultValue), 10, 0));
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(15) ;
         }
         if ( ( subGrids_Islastpage == 1 ) || ( subGrids_Rows == 0 ) || ( ( GRIDS_nCurrentRecord >= GRIDS_nFirstRecordOnPage ) && ( GRIDS_nCurrentRecord < GRIDS_nFirstRecordOnPage + subgrids_fnc_recordsperpage( ) ) ) )
         {
            sendrow_152( ) ;
         }
         GRIDS_nEOF = (byte)(((GRIDS_nCurrentRecord<GRIDS_nFirstRecordOnPage+subgrids_fnc_recordsperpage( )) ? 1 : 0)) ;
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDS_nEOF, (byte)(1), (byte)(0), ".", "")));
         GRIDS_nCurrentRecord = (long)(GRIDS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_15_Refreshing )
         {
            httpContext.doAjaxLoad(15, GridsRow);
         }
         AV9GXV1 = (int)(AV9GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e120P2( )
   {
      AV9GXV1 = (int)(nGXsfl_15_idx+GRIDS_nFirstRecordOnPage) ;
      if ( ( AV9GXV1 > 0 ) && ( AV6ConfFormattingVariables.size() >= AV9GXV1 ) )
      {
         AV6ConfFormattingVariables.currentItem( ((com.workwithplus.SdtWWPConfFormattingVariable)AV6ConfFormattingVariables.elementAt(-1+AV9GXV1)) );
      }
      /* 'DoUserActionReset' Routine */
      returnInSub = false ;
      AV11GXV3 = 1 ;
      while ( AV11GXV3 <= AV6ConfFormattingVariables.size() )
      {
         AV5ConfFormattingVariable = (com.workwithplus.SdtWWPConfFormattingVariable)((com.workwithplus.SdtWWPConfFormattingVariable)AV6ConfFormattingVariables.elementAt(-1+AV11GXV3));
         new com.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( AV7VarProgramName+"."+AV5ConfFormattingVariable.getgxTv_SdtWWPConfFormattingVariable_Name(), "") ;
         AV11GXV3 = (int)(AV11GXV3+1) ;
      }
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "WCPopup_Close", new Object[] {""}, false);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e130P2 ();
      if (returnInSub) return;
   }

   public void e130P2( )
   {
      AV9GXV1 = (int)(nGXsfl_15_idx+GRIDS_nFirstRecordOnPage) ;
      if ( ( AV9GXV1 > 0 ) && ( AV6ConfFormattingVariables.size() >= AV9GXV1 ) )
      {
         AV6ConfFormattingVariables.currentItem( ((com.workwithplus.SdtWWPConfFormattingVariable)AV6ConfFormattingVariables.elementAt(-1+AV9GXV1)) );
      }
      /* Enter Routine */
      returnInSub = false ;
      /* Start For Each Line in Grids */
      nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_15"), ",", ".")) ;
      nGXsfl_15_fel_idx = 0 ;
      while ( nGXsfl_15_fel_idx < nRC_GXsfl_15 )
      {
         nGXsfl_15_fel_idx = ((subGrids_Islastpage==1)&&(nGXsfl_15_fel_idx+1>subgrids_fnc_recordsperpage( )) ? 1 : nGXsfl_15_fel_idx+1) ;
         sGXsfl_15_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_fel_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_fel_152( ) ;
         AV9GXV1 = (int)(nGXsfl_15_fel_idx+GRIDS_nFirstRecordOnPage) ;
         if ( ( AV6ConfFormattingVariables.size() >= AV9GXV1 ) && ( AV9GXV1 > 0 ) )
         {
            AV6ConfFormattingVariables.currentItem( ((com.workwithplus.SdtWWPConfFormattingVariable)AV6ConfFormattingVariables.elementAt(-1+AV9GXV1)) );
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavDefaultvalue_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavDefaultvalue_Internalname), ",", ".") > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vDEFAULTVALUE");
               GX_FocusControl = edtavDefaultvalue_Internalname ;
               wbErr = true ;
               AV8DefaultValue = 0 ;
            }
            else
            {
               AV8DefaultValue = localUtil.ctol( httpContext.cgiGet( edtavDefaultvalue_Internalname), ",", ".") ;
            }
         }
         new com.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( AV7VarProgramName+"."+((com.workwithplus.SdtWWPConfFormattingVariable)(AV6ConfFormattingVariables.currentItem())).getgxTv_SdtWWPConfFormattingVariable_Name(), GXutil.trim( GXutil.str( AV8DefaultValue, 10, 0))) ;
         /* End For Each Line */
      }
      if ( nGXsfl_15_fel_idx == 0 )
      {
         nGXsfl_15_idx = 1 ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      nGXsfl_15_fel_idx = 1 ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "WCPopup_Close", new Object[] {""}, false);
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV7VarProgramName = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7VarProgramName", AV7VarProgramName);
      AV6ConfFormattingVariables = (GXBaseCollection<com.workwithplus.SdtWWPConfFormattingVariable>)getParm(obj,1) ;
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
      pa0P2( ) ;
      ws0P2( ) ;
      we0P2( ) ;
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
      sCtrlAV7VarProgramName = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV6ConfFormattingVariables = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0P2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "workwithplus\\wwp_editconfformattingvalues", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0P2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV7VarProgramName = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7VarProgramName", AV7VarProgramName);
         AV6ConfFormattingVariables = (GXBaseCollection<com.workwithplus.SdtWWPConfFormattingVariable>)getParm(obj,3) ;
      }
      wcpOAV7VarProgramName = httpContext.cgiGet( sPrefix+"wcpOAV7VarProgramName") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV7VarProgramName, wcpOAV7VarProgramName) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV7VarProgramName = AV7VarProgramName ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV7VarProgramName = httpContext.cgiGet( sPrefix+"AV7VarProgramName_CTRL") ;
      if ( GXutil.len( sCtrlAV7VarProgramName) > 0 )
      {
         AV7VarProgramName = httpContext.cgiGet( sCtrlAV7VarProgramName) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7VarProgramName", AV7VarProgramName);
      }
      else
      {
         AV7VarProgramName = httpContext.cgiGet( sPrefix+"AV7VarProgramName_PARM") ;
      }
      sCtrlAV6ConfFormattingVariables = httpContext.cgiGet( sPrefix+"AV6ConfFormattingVariables_CTRL") ;
      if ( GXutil.len( sCtrlAV6ConfFormattingVariables) > 0 )
      {
         AV6ConfFormattingVariables = new GXBaseCollection<com.workwithplus.SdtWWPConfFormattingVariable>() ;
      }
      else
      {
         httpContext.readJsonSdtValue(httpContext.cgiGet( sPrefix+"AV6ConfFormattingVariables_PARM"), AV6ConfFormattingVariables);
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
      pa0P2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0P2( ) ;
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
      ws0P2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7VarProgramName_PARM", AV7VarProgramName);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7VarProgramName)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7VarProgramName_CTRL", GXutil.rtrim( sCtrlAV7VarProgramName));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"AV6ConfFormattingVariables_PARM", AV6ConfFormattingVariables);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"AV6ConfFormattingVariables_PARM", AV6ConfFormattingVariables);
      }
      if ( GXutil.len( GXutil.rtrim( sCtrlAV6ConfFormattingVariables)) > 0 )
      {
         com.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6ConfFormattingVariables_CTRL", GXutil.rtrim( sCtrlAV6ConfFormattingVariables));
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
      we0P2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202442617163313", true, true);
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
      httpContext.AddJavascriptSource("workwithplus/wwp_editconfformattingvalues.js", "?202442617163314", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_152( )
   {
      edtavConfformattingvariables__description_Internalname = sPrefix+"CONFFORMATTINGVARIABLES__DESCRIPTION_"+sGXsfl_15_idx ;
      edtavDefaultvalue_Internalname = sPrefix+"vDEFAULTVALUE_"+sGXsfl_15_idx ;
   }

   public void subsflControlProps_fel_152( )
   {
      edtavConfformattingvariables__description_Internalname = sPrefix+"CONFFORMATTINGVARIABLES__DESCRIPTION_"+sGXsfl_15_fel_idx ;
      edtavDefaultvalue_Internalname = sPrefix+"vDEFAULTVALUE_"+sGXsfl_15_fel_idx ;
   }

   public void sendrow_152( )
   {
      subsflControlProps_152( ) ;
      wb0P0( ) ;
      if ( ( subGrids_Rows * 1 == 0 ) || ( nGXsfl_15_idx <= subgrids_fnc_recordsperpage( ) * 1 ) )
      {
         GridsRow = GXWebRow.GetNew(context,GridsContainer) ;
         if ( subGrids_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrids_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrids_Class, "") != 0 )
            {
               subGrids_Linesclass = subGrids_Class+"Odd" ;
            }
         }
         else if ( subGrids_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrids_Backstyle = (byte)(0) ;
            subGrids_Backcolor = subGrids_Allbackcolor ;
            if ( GXutil.strcmp(subGrids_Class, "") != 0 )
            {
               subGrids_Linesclass = subGrids_Class+"Uniform" ;
            }
         }
         else if ( subGrids_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrids_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrids_Class, "") != 0 )
            {
               subGrids_Linesclass = subGrids_Class+"Odd" ;
            }
            subGrids_Backcolor = (int)(0x0) ;
         }
         else if ( subGrids_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrids_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_15_idx) % (2))) == 0 )
            {
               subGrids_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrids_Class, "") != 0 )
               {
                  subGrids_Linesclass = subGrids_Class+"Even" ;
               }
            }
            else
            {
               subGrids_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrids_Class, "") != 0 )
               {
                  subGrids_Linesclass = subGrids_Class+"Odd" ;
               }
            }
         }
         if ( GridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_15_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"start"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConfformattingvariables__description_Internalname,((com.workwithplus.SdtWWPConfFormattingVariable)AV6ConfFormattingVariables.elementAt(-1+AV9GXV1)).getgxTv_SdtWWPConfFormattingVariable_Description(),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavConfformattingvariables__description_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavConfformattingvariables__description_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(300),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","start",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"end"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDefaultvalue_Enabled!=0)&&(edtavDefaultvalue_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 17,'"+sPrefix+"',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDefaultvalue_Internalname,GXutil.ltrim( localUtil.ntoc( AV8DefaultValue, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV8DefaultValue), "ZZZZZZZZZ9"))," dir=\"ltr\" inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+((edtavDefaultvalue_Enabled!=0)&&(edtavDefaultvalue_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,17);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDefaultvalue_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","end",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes0P2( ) ;
         GridsContainer.AddRow(GridsRow);
         nGXsfl_15_idx = ((subGrids_Islastpage==1)&&(nGXsfl_15_idx+1>subgrids_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      /* End function sendrow_152 */
   }

   public void startgridcontrol15( )
   {
      if ( GridsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridsContainer"+"DivS\" data-gxgridid=\"15\">") ;
         sStyleString = "" ;
         com.GxWebStd.gx_table_start( httpContext, subGrids_Internalname, subGrids_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrids_Backcolorstyle == 0 )
         {
            subGrids_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrids_Class) > 0 )
            {
               subGrids_Linesclass = subGrids_Class+"Title" ;
            }
         }
         else
         {
            subGrids_Titlebackstyle = (byte)(1) ;
            if ( subGrids_Backcolorstyle == 1 )
            {
               subGrids_Titlebackcolor = subGrids_Allbackcolor ;
               if ( GXutil.len( subGrids_Class) > 0 )
               {
                  subGrids_Linesclass = subGrids_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrids_Class) > 0 )
               {
                  subGrids_Linesclass = subGrids_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"start"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(300), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Description") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"end"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridsContainer.AddObjectProperty("GridName", "Grids");
      }
      else
      {
         GridsContainer.AddObjectProperty("GridName", "Grids");
         GridsContainer.AddObjectProperty("Header", subGrids_Header);
         GridsContainer.AddObjectProperty("Class", "WorkWith");
         GridsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrids_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridsContainer.AddObjectProperty("CmpContext", sPrefix);
         GridsContainer.AddObjectProperty("InMasterPage", "false");
         GridsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConfformattingvariables__description_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsContainer.AddColumnProperties(GridsColumn);
         GridsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( AV8DefaultValue, (byte)(10), (byte)(0), ".", ""))));
         GridsContainer.AddColumnProperties(GridsColumn);
         GridsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrids_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrids_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrids_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrids_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrids_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrids_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrids_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavConfformattingvariables__description_Internalname = sPrefix+"CONFFORMATTINGVARIABLES__DESCRIPTION" ;
      edtavDefaultvalue_Internalname = sPrefix+"vDEFAULTVALUE" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtnuseraction1_Internalname = sPrefix+"BTNUSERACTION1" ;
      bttBtnuseractionreset_Internalname = sPrefix+"BTNUSERACTIONRESET" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Grids_empowerer_Internalname = sPrefix+"GRIDS_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGrids_Internalname = sPrefix+"GRIDS" ;
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
      subGrids_Allowcollapsing = (byte)(0) ;
      subGrids_Allowselection = (byte)(0) ;
      subGrids_Header = "" ;
      edtavDefaultvalue_Jsonclick = "" ;
      edtavDefaultvalue_Visible = -1 ;
      edtavDefaultvalue_Enabled = 1 ;
      edtavConfformattingvariables__description_Jsonclick = "" ;
      edtavConfformattingvariables__description_Enabled = 0 ;
      subGrids_Class = "WorkWith" ;
      subGrids_Backcolorstyle = (byte)(0) ;
      edtavConfformattingvariables__description_Enabled = -1 ;
      subGrids_Rows = 0 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDS_nFirstRecordOnPage'},{av:'GRIDS_nEOF'},{av:'subGrids_Rows',ctrl:'GRIDS',prop:'Rows'},{av:'AV6ConfFormattingVariables',fld:'vCONFFORMATTINGVARIABLES',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDS',prop:'GridRC',grid:15},{av:'sPrefix'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDS.LOAD","{handler:'e150P2',iparms:[{av:'AV6ConfFormattingVariables',fld:'vCONFFORMATTINGVARIABLES',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDS',prop:'GridRC',grid:15}]");
      setEventMetadata("GRIDS.LOAD",",oparms:[{av:'AV8DefaultValue',fld:'vDEFAULTVALUE',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("'DOUSERACTION1'","{handler:'e110P1',iparms:[]");
      setEventMetadata("'DOUSERACTION1'",",oparms:[]}");
      setEventMetadata("'DOUSERACTIONRESET'","{handler:'e120P2',iparms:[{av:'AV6ConfFormattingVariables',fld:'vCONFFORMATTINGVARIABLES',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDS',prop:'GridRC',grid:15},{av:'AV7VarProgramName',fld:'vVARPROGRAMNAME',pic:''}]");
      setEventMetadata("'DOUSERACTIONRESET'",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e130P2',iparms:[{av:'AV7VarProgramName',fld:'vVARPROGRAMNAME',pic:''},{av:'AV6ConfFormattingVariables',fld:'vCONFFORMATTINGVARIABLES',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'GRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDS',grid:15,prop:'GridRC',grid:15},{av:'AV8DefaultValue',fld:'vDEFAULTVALUE',grid:15,pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("GRIDS_FIRSTPAGE","{handler:'subgrids_firstpage',iparms:[{av:'GRIDS_nFirstRecordOnPage'},{av:'GRIDS_nEOF'},{av:'subGrids_Rows',ctrl:'GRIDS',prop:'Rows'},{av:'AV6ConfFormattingVariables',fld:'vCONFFORMATTINGVARIABLES',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDS',prop:'GridRC',grid:15},{av:'sPrefix'}]");
      setEventMetadata("GRIDS_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDS_PREVPAGE","{handler:'subgrids_previouspage',iparms:[{av:'GRIDS_nFirstRecordOnPage'},{av:'GRIDS_nEOF'},{av:'subGrids_Rows',ctrl:'GRIDS',prop:'Rows'},{av:'AV6ConfFormattingVariables',fld:'vCONFFORMATTINGVARIABLES',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDS',prop:'GridRC',grid:15},{av:'sPrefix'}]");
      setEventMetadata("GRIDS_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDS_NEXTPAGE","{handler:'subgrids_nextpage',iparms:[{av:'GRIDS_nFirstRecordOnPage'},{av:'GRIDS_nEOF'},{av:'subGrids_Rows',ctrl:'GRIDS',prop:'Rows'},{av:'AV6ConfFormattingVariables',fld:'vCONFFORMATTINGVARIABLES',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDS',prop:'GridRC',grid:15},{av:'sPrefix'}]");
      setEventMetadata("GRIDS_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDS_LASTPAGE","{handler:'subgrids_lastpage',iparms:[{av:'GRIDS_nFirstRecordOnPage'},{av:'GRIDS_nEOF'},{av:'subGrids_Rows',ctrl:'GRIDS',prop:'Rows'},{av:'AV6ConfFormattingVariables',fld:'vCONFFORMATTINGVARIABLES',grid:15,pic:''},{av:'nGXsfl_15_idx',ctrl:'GRID',prop:'GridCurrRow',grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDS',prop:'GridRC',grid:15},{av:'sPrefix'}]");
      setEventMetadata("GRIDS_LASTPAGE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Defaultvalue',iparms:[]");
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
      wcpOAV7VarProgramName = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV7VarProgramName = "" ;
      AV6ConfFormattingVariables = new GXBaseCollection<com.workwithplus.SdtWWPConfFormattingVariable>(com.workwithplus.SdtWWPConfFormattingVariable.class, "WWPConfFormattingVariable", "Gregory", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      Grids_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      TempTags = "" ;
      bttBtnuseraction1_Jsonclick = "" ;
      bttBtnuseractionreset_Jsonclick = "" ;
      bttBtnenter_Jsonclick = "" ;
      ucGrids_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GridsRow = new com.genexus.webpanels.GXWebRow();
      AV5ConfFormattingVariable = new com.workwithplus.SdtWWPConfFormattingVariable(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV7VarProgramName = "" ;
      sCtrlAV6ConfFormattingVariables = "" ;
      subGrids_Linesclass = "" ;
      ROClassString = "" ;
      GridsColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
      edtavConfformattingvariables__description_Enabled = 0 ;
   }

   private byte GRIDS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGrids_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGrids_Backstyle ;
   private byte subGrids_Titlebackstyle ;
   private byte subGrids_Allowselection ;
   private byte subGrids_Allowhovering ;
   private byte subGrids_Allowcollapsing ;
   private byte subGrids_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private int nRC_GXsfl_15 ;
   private int subGrids_Rows ;
   private int nGXsfl_15_idx=1 ;
   private int AV9GXV1 ;
   private int subGrids_Islastpage ;
   private int edtavConfformattingvariables__description_Enabled ;
   private int GRIDS_nGridOutOfScope ;
   private int nGXsfl_15_fel_idx=1 ;
   private int AV11GXV3 ;
   private int idxLst ;
   private int subGrids_Backcolor ;
   private int subGrids_Allbackcolor ;
   private int edtavDefaultvalue_Enabled ;
   private int edtavDefaultvalue_Visible ;
   private int subGrids_Titlebackcolor ;
   private int subGrids_Selectedindex ;
   private int subGrids_Selectioncolor ;
   private int subGrids_Hoveringcolor ;
   private long GRIDS_nFirstRecordOnPage ;
   private long AV8DefaultValue ;
   private long GRIDS_nCurrentRecord ;
   private long GRIDS_nRecordCount ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_15_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Grids_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String sStyleString ;
   private String subGrids_Internalname ;
   private String TempTags ;
   private String bttBtnuseraction1_Internalname ;
   private String bttBtnuseraction1_Jsonclick ;
   private String bttBtnuseractionreset_Internalname ;
   private String bttBtnuseractionreset_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Grids_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavConfformattingvariables__description_Internalname ;
   private String edtavDefaultvalue_Internalname ;
   private String sGXsfl_15_fel_idx="0001" ;
   private String sCtrlAV7VarProgramName ;
   private String sCtrlAV6ConfFormattingVariables ;
   private String subGrids_Class ;
   private String subGrids_Linesclass ;
   private String ROClassString ;
   private String edtavConfformattingvariables__description_Jsonclick ;
   private String edtavDefaultvalue_Jsonclick ;
   private String subGrids_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_15_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String wcpOAV7VarProgramName ;
   private String AV7VarProgramName ;
   private com.genexus.webpanels.GXWebGrid GridsContainer ;
   private com.genexus.webpanels.GXWebRow GridsRow ;
   private com.genexus.webpanels.GXWebColumn GridsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGrids_empowerer ;
   private GXBaseCollection<com.workwithplus.SdtWWPConfFormattingVariable> AV6ConfFormattingVariables ;
   private com.workwithplus.SdtWWPConfFormattingVariable AV5ConfFormattingVariable ;
}

