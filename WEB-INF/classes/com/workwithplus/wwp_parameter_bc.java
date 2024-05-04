package com.workwithplus ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_parameter_bc extends GXWebProcedure implements IGxSilentTrn
{
   public wwp_parameter_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_parameter_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_parameter_bc.class ));
   }

   public wwp_parameter_bc( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow022( ) ;
      standaloneNotModal( ) ;
      initializeNonKey022( ) ;
      standaloneModal( ) ;
      addRow022( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e11022 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z4WWPParameterKey = A4WWPParameterKey ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_020( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls022( ) ;
         }
         else
         {
            checkExtendedTable022( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors022( ) ;
         }
      }
      if ( AnyError == 0 )
      {
      }
   }

   public void e12022( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0];
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
   }

   public void e11022( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm022( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z6WWPParameterCategory = A6WWPParameterCategory ;
         Z7WWPParameterDescription = A7WWPParameterDescription ;
         Z8WWPParameterDisableDelete = A8WWPParameterDisableDelete ;
         Z9WWPParameterValueTrimmed = A9WWPParameterValueTrimmed ;
      }
      if ( GX_JID == -3 )
      {
         Z4WWPParameterKey = A4WWPParameterKey ;
         Z6WWPParameterCategory = A6WWPParameterCategory ;
         Z7WWPParameterDescription = A7WWPParameterDescription ;
         Z5WWPParameterValue = A5WWPParameterValue ;
         Z8WWPParameterDisableDelete = A8WWPParameterDisableDelete ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load022( )
   {
      /* Using cursor BC00024 */
      pr_default.execute(2, new Object[] {A4WWPParameterKey});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound2 = (short)(1) ;
         A6WWPParameterCategory = BC00024_A6WWPParameterCategory[0] ;
         A7WWPParameterDescription = BC00024_A7WWPParameterDescription[0] ;
         A5WWPParameterValue = BC00024_A5WWPParameterValue[0] ;
         A8WWPParameterDisableDelete = BC00024_A8WWPParameterDisableDelete[0] ;
         zm022( -3) ;
      }
      pr_default.close(2);
      onLoadActions022( ) ;
   }

   public void onLoadActions022( )
   {
      if ( GXutil.len( A5WWPParameterValue) <= 30 )
      {
         A9WWPParameterValueTrimmed = A5WWPParameterValue ;
      }
      else
      {
         A9WWPParameterValueTrimmed = GXutil.trim( GXutil.substring( A5WWPParameterValue, 1, 27)) + "..." ;
      }
   }

   public void checkExtendedTable022( )
   {
      standaloneModal( ) ;
      if ( (GXutil.strcmp("", A4WWPParameterKey)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( "%1 es requerido.", "Clave del parámetro", "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( GXutil.len( A5WWPParameterValue) <= 30 )
      {
         A9WWPParameterValueTrimmed = A5WWPParameterValue ;
      }
      else
      {
         A9WWPParameterValueTrimmed = GXutil.trim( GXutil.substring( A5WWPParameterValue, 1, 27)) + "..." ;
      }
   }

   public void closeExtendedTableCursors022( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey022( )
   {
      /* Using cursor BC00025 */
      pr_default.execute(3, new Object[] {A4WWPParameterKey});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound2 = (short)(1) ;
      }
      else
      {
         RcdFound2 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00026 */
      pr_default.execute(4, new Object[] {A4WWPParameterKey});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm022( 3) ;
         RcdFound2 = (short)(1) ;
         A4WWPParameterKey = BC00026_A4WWPParameterKey[0] ;
         A6WWPParameterCategory = BC00026_A6WWPParameterCategory[0] ;
         A7WWPParameterDescription = BC00026_A7WWPParameterDescription[0] ;
         A5WWPParameterValue = BC00026_A5WWPParameterValue[0] ;
         A8WWPParameterDisableDelete = BC00026_A8WWPParameterDisableDelete[0] ;
         Z4WWPParameterKey = A4WWPParameterKey ;
         sMode2 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load022( ) ;
         if ( AnyError == 1 )
         {
            RcdFound2 = (short)(0) ;
            initializeNonKey022( ) ;
         }
         Gx_mode = sMode2 ;
      }
      else
      {
         RcdFound2 = (short)(0) ;
         initializeNonKey022( ) ;
         sMode2 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode2 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey022( ) ;
      if ( RcdFound2 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_020( ) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency022( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00027 */
         pr_default.execute(5, new Object[] {A4WWPParameterKey});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Parameter"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z6WWPParameterCategory, BC00027_A6WWPParameterCategory[0]) != 0 ) || ( GXutil.strcmp(Z7WWPParameterDescription, BC00027_A7WWPParameterDescription[0]) != 0 ) || ( Z8WWPParameterDisableDelete != BC00027_A8WWPParameterDisableDelete[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_Parameter"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert022( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable022( ) ;
      }
      if ( AnyError == 0 )
      {
         zm022( 0) ;
         checkOptimisticConcurrency022( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm022( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert022( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00028 */
                  pr_default.execute(6, new Object[] {A4WWPParameterKey, A6WWPParameterCategory, A7WWPParameterDescription, A5WWPParameterValue, Boolean.valueOf(A8WWPParameterDisableDelete)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Parameter");
                  if ( (pr_default.getStatus(6) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load022( ) ;
         }
         endLevel022( ) ;
      }
      closeExtendedTableCursors022( ) ;
   }

   public void update022( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable022( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency022( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm022( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate022( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00029 */
                  pr_default.execute(7, new Object[] {A6WWPParameterCategory, A7WWPParameterDescription, A5WWPParameterValue, Boolean.valueOf(A8WWPParameterDisableDelete), A4WWPParameterKey});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Parameter");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Parameter"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate022( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel022( ) ;
      }
      closeExtendedTableCursors022( ) ;
   }

   public void deferredUpdate022( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency022( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls022( ) ;
         afterConfirm022( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete022( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000210 */
               pr_default.execute(8, new Object[] {A4WWPParameterKey});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Parameter");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode2 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel022( ) ;
      Gx_mode = sMode2 ;
   }

   public void onDeleteControls022( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( GXutil.len( A5WWPParameterValue) <= 30 )
         {
            A9WWPParameterValueTrimmed = A5WWPParameterValue ;
         }
         else
         {
            A9WWPParameterValueTrimmed = GXutil.trim( GXutil.substring( A5WWPParameterValue, 1, 27)) + "..." ;
         }
      }
   }

   public void endLevel022( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete022( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart022( )
   {
      /* Scan By routine */
      /* Using cursor BC000211 */
      pr_default.execute(9, new Object[] {A4WWPParameterKey});
      RcdFound2 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound2 = (short)(1) ;
         A4WWPParameterKey = BC000211_A4WWPParameterKey[0] ;
         A6WWPParameterCategory = BC000211_A6WWPParameterCategory[0] ;
         A7WWPParameterDescription = BC000211_A7WWPParameterDescription[0] ;
         A5WWPParameterValue = BC000211_A5WWPParameterValue[0] ;
         A8WWPParameterDisableDelete = BC000211_A8WWPParameterDisableDelete[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext022( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound2 = (short)(0) ;
      scanKeyLoad022( ) ;
   }

   public void scanKeyLoad022( )
   {
      sMode2 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound2 = (short)(1) ;
         A4WWPParameterKey = BC000211_A4WWPParameterKey[0] ;
         A6WWPParameterCategory = BC000211_A6WWPParameterCategory[0] ;
         A7WWPParameterDescription = BC000211_A7WWPParameterDescription[0] ;
         A5WWPParameterValue = BC000211_A5WWPParameterValue[0] ;
         A8WWPParameterDisableDelete = BC000211_A8WWPParameterDisableDelete[0] ;
      }
      Gx_mode = sMode2 ;
   }

   public void scanKeyEnd022( )
   {
      pr_default.close(9);
   }

   public void afterConfirm022( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert022( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate022( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete022( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete022( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate022( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes022( )
   {
   }

   public void send_integrity_lvl_hashes022( )
   {
   }

   public void addRow022( )
   {
      VarsToRow2( bcworkwithplus_WWP_Parameter) ;
   }

   public void readRow022( )
   {
      RowToVars2( bcworkwithplus_WWP_Parameter, 1) ;
   }

   public void initializeNonKey022( )
   {
      A9WWPParameterValueTrimmed = "" ;
      A6WWPParameterCategory = "" ;
      A7WWPParameterDescription = "" ;
      A5WWPParameterValue = "" ;
      A8WWPParameterDisableDelete = false ;
      Z6WWPParameterCategory = "" ;
      Z7WWPParameterDescription = "" ;
      Z8WWPParameterDisableDelete = false ;
   }

   public void initAll022( )
   {
      A4WWPParameterKey = "" ;
      initializeNonKey022( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow2( com.workwithplus.SdtWWP_Parameter obj2 )
   {
      obj2.setgxTv_SdtWWP_Parameter_Mode( Gx_mode );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed( A9WWPParameterValueTrimmed );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparametercategory( A6WWPParameterCategory );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparameterdescription( A7WWPParameterDescription );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparametervalue( A5WWPParameterValue );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( A8WWPParameterDisableDelete );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparameterkey( A4WWPParameterKey );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparameterkey_Z( Z4WWPParameterKey );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparametercategory_Z( Z6WWPParameterCategory );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparameterdescription_Z( Z7WWPParameterDescription );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z( Z9WWPParameterValueTrimmed );
      obj2.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z( Z8WWPParameterDisableDelete );
      obj2.setgxTv_SdtWWP_Parameter_Mode( Gx_mode );
   }

   public void KeyVarsToRow2( com.workwithplus.SdtWWP_Parameter obj2 )
   {
      obj2.setgxTv_SdtWWP_Parameter_Wwpparameterkey( A4WWPParameterKey );
   }

   public void RowToVars2( com.workwithplus.SdtWWP_Parameter obj2 ,
                           int forceLoad )
   {
      Gx_mode = obj2.getgxTv_SdtWWP_Parameter_Mode() ;
      A9WWPParameterValueTrimmed = obj2.getgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed() ;
      A6WWPParameterCategory = obj2.getgxTv_SdtWWP_Parameter_Wwpparametercategory() ;
      A7WWPParameterDescription = obj2.getgxTv_SdtWWP_Parameter_Wwpparameterdescription() ;
      A5WWPParameterValue = obj2.getgxTv_SdtWWP_Parameter_Wwpparametervalue() ;
      A8WWPParameterDisableDelete = obj2.getgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete() ;
      A4WWPParameterKey = obj2.getgxTv_SdtWWP_Parameter_Wwpparameterkey() ;
      Z4WWPParameterKey = obj2.getgxTv_SdtWWP_Parameter_Wwpparameterkey_Z() ;
      Z6WWPParameterCategory = obj2.getgxTv_SdtWWP_Parameter_Wwpparametercategory_Z() ;
      Z7WWPParameterDescription = obj2.getgxTv_SdtWWP_Parameter_Wwpparameterdescription_Z() ;
      Z9WWPParameterValueTrimmed = obj2.getgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z() ;
      Z8WWPParameterDisableDelete = obj2.getgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z() ;
      Gx_mode = obj2.getgxTv_SdtWWP_Parameter_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A4WWPParameterKey = (String)getParm(obj,0) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey022( ) ;
      scanKeyStart022( ) ;
      if ( RcdFound2 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z4WWPParameterKey = A4WWPParameterKey ;
      }
      zm022( -3) ;
      onLoadActions022( ) ;
      addRow022( ) ;
      scanKeyEnd022( ) ;
      if ( RcdFound2 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars2( bcworkwithplus_WWP_Parameter, 0) ;
      scanKeyStart022( ) ;
      if ( RcdFound2 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z4WWPParameterKey = A4WWPParameterKey ;
      }
      zm022( -3) ;
      onLoadActions022( ) ;
      addRow022( ) ;
      scanKeyEnd022( ) ;
      if ( RcdFound2 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      getKey022( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert022( ) ;
      }
      else
      {
         if ( RcdFound2 == 1 )
         {
            if ( GXutil.strcmp(A4WWPParameterKey, Z4WWPParameterKey) != 0 )
            {
               A4WWPParameterKey = Z4WWPParameterKey ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update022( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( GXutil.strcmp(A4WWPParameterKey, Z4WWPParameterKey) != 0 )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert022( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert022( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars2( bcworkwithplus_WWP_Parameter, 1) ;
      saveImpl( ) ;
      VarsToRow2( bcworkwithplus_WWP_Parameter) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars2( bcworkwithplus_WWP_Parameter, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert022( ) ;
      afterTrn( ) ;
      VarsToRow2( bcworkwithplus_WWP_Parameter) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
         VarsToRow2( bcworkwithplus_WWP_Parameter) ;
      }
      else
      {
         com.workwithplus.SdtWWP_Parameter auxBC = new com.workwithplus.SdtWWP_Parameter( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A4WWPParameterKey);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcworkwithplus_WWP_Parameter);
            auxBC.Save();
            bcworkwithplus_WWP_Parameter.copy(auxBC);
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars2( bcworkwithplus_WWP_Parameter, 1) ;
      updateImpl( ) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars2( bcworkwithplus_WWP_Parameter, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert022( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
         else
         {
            VarsToRow2( bcworkwithplus_WWP_Parameter) ;
         }
      }
      else
      {
         afterTrn( ) ;
         VarsToRow2( bcworkwithplus_WWP_Parameter) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars2( bcworkwithplus_WWP_Parameter, 0) ;
      getKey022( ) ;
      if ( RcdFound2 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( GXutil.strcmp(A4WWPParameterKey, Z4WWPParameterKey) != 0 )
         {
            A4WWPParameterKey = Z4WWPParameterKey ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(A4WWPParameterKey, Z4WWPParameterKey) != 0 )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "workwithplus.wwp_parameter_bc");
      VarsToRow2( bcworkwithplus_WWP_Parameter) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcworkwithplus_WWP_Parameter.getgxTv_SdtWWP_Parameter_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcworkwithplus_WWP_Parameter.setgxTv_SdtWWP_Parameter_Mode( Gx_mode );
   }

   public void SetSDT( com.workwithplus.SdtWWP_Parameter sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcworkwithplus_WWP_Parameter )
      {
         bcworkwithplus_WWP_Parameter = sdt ;
         if ( GXutil.strcmp(bcworkwithplus_WWP_Parameter.getgxTv_SdtWWP_Parameter_Mode(), "") == 0 )
         {
            bcworkwithplus_WWP_Parameter.setgxTv_SdtWWP_Parameter_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow2( bcworkwithplus_WWP_Parameter) ;
         }
         else
         {
            RowToVars2( bcworkwithplus_WWP_Parameter, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcworkwithplus_WWP_Parameter.getgxTv_SdtWWP_Parameter_Mode(), "") == 0 )
         {
            bcworkwithplus_WWP_Parameter.setgxTv_SdtWWP_Parameter_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars2( bcworkwithplus_WWP_Parameter, 1) ;
   }

   public void ForceCommitOnExit( )
   {
   }

   public SdtWWP_Parameter getWWP_Parameter_BC( )
   {
      return bcworkwithplus_WWP_Parameter ;
   }


   public void webExecute( )
   {
   }

   public boolean isMasterPage( )
   {
      return false;
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
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
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z4WWPParameterKey = "" ;
      A4WWPParameterKey = "" ;
      AV8WWPContext = new com.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.wwpbaseobjects.SdtWWPContext[1] ;
      AV9TrnContext = new com.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      Z6WWPParameterCategory = "" ;
      A6WWPParameterCategory = "" ;
      Z7WWPParameterDescription = "" ;
      A7WWPParameterDescription = "" ;
      Z9WWPParameterValueTrimmed = "" ;
      A9WWPParameterValueTrimmed = "" ;
      Z5WWPParameterValue = "" ;
      A5WWPParameterValue = "" ;
      BC00024_A4WWPParameterKey = new String[] {""} ;
      BC00024_A6WWPParameterCategory = new String[] {""} ;
      BC00024_A7WWPParameterDescription = new String[] {""} ;
      BC00024_A5WWPParameterValue = new String[] {""} ;
      BC00024_A8WWPParameterDisableDelete = new boolean[] {false} ;
      BC00025_A4WWPParameterKey = new String[] {""} ;
      BC00026_A4WWPParameterKey = new String[] {""} ;
      BC00026_A6WWPParameterCategory = new String[] {""} ;
      BC00026_A7WWPParameterDescription = new String[] {""} ;
      BC00026_A5WWPParameterValue = new String[] {""} ;
      BC00026_A8WWPParameterDisableDelete = new boolean[] {false} ;
      sMode2 = "" ;
      BC00027_A4WWPParameterKey = new String[] {""} ;
      BC00027_A6WWPParameterCategory = new String[] {""} ;
      BC00027_A7WWPParameterDescription = new String[] {""} ;
      BC00027_A5WWPParameterValue = new String[] {""} ;
      BC00027_A8WWPParameterDisableDelete = new boolean[] {false} ;
      BC000211_A4WWPParameterKey = new String[] {""} ;
      BC000211_A6WWPParameterCategory = new String[] {""} ;
      BC000211_A7WWPParameterDescription = new String[] {""} ;
      BC000211_A5WWPParameterValue = new String[] {""} ;
      BC000211_A8WWPParameterDisableDelete = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.workwithplus.wwp_parameter_bc__default(),
         new Object[] {
             new Object[] {
            BC00022_A4WWPParameterKey, BC00022_A6WWPParameterCategory, BC00022_A7WWPParameterDescription, BC00022_A5WWPParameterValue, BC00022_A8WWPParameterDisableDelete
            }
            , new Object[] {
            BC00023_A4WWPParameterKey, BC00023_A6WWPParameterCategory, BC00023_A7WWPParameterDescription, BC00023_A5WWPParameterValue, BC00023_A8WWPParameterDisableDelete
            }
            , new Object[] {
            BC00024_A4WWPParameterKey, BC00024_A6WWPParameterCategory, BC00024_A7WWPParameterDescription, BC00024_A5WWPParameterValue, BC00024_A8WWPParameterDisableDelete
            }
            , new Object[] {
            BC00025_A4WWPParameterKey
            }
            , new Object[] {
            BC00026_A4WWPParameterKey, BC00026_A6WWPParameterCategory, BC00026_A7WWPParameterDescription, BC00026_A5WWPParameterValue, BC00026_A8WWPParameterDisableDelete
            }
            , new Object[] {
            BC00027_A4WWPParameterKey, BC00027_A6WWPParameterCategory, BC00027_A7WWPParameterDescription, BC00027_A5WWPParameterValue, BC00027_A8WWPParameterDisableDelete
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000211_A4WWPParameterKey, BC000211_A6WWPParameterCategory, BC000211_A7WWPParameterDescription, BC000211_A5WWPParameterValue, BC000211_A8WWPParameterDisableDelete
            }
         }
      );
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12022 ();
      standaloneNotModal( ) ;
   }

   private short AnyError ;
   private short RcdFound2 ;
   private int trnEnded ;
   private int GX_JID ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode2 ;
   private boolean returnInSub ;
   private boolean Z8WWPParameterDisableDelete ;
   private boolean A8WWPParameterDisableDelete ;
   private String Z5WWPParameterValue ;
   private String A5WWPParameterValue ;
   private String Z4WWPParameterKey ;
   private String A4WWPParameterKey ;
   private String Z6WWPParameterCategory ;
   private String A6WWPParameterCategory ;
   private String Z7WWPParameterDescription ;
   private String A7WWPParameterDescription ;
   private String Z9WWPParameterValueTrimmed ;
   private String A9WWPParameterValueTrimmed ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.workwithplus.SdtWWP_Parameter bcworkwithplus_WWP_Parameter ;
   private IDataStoreProvider pr_default ;
   private String[] BC00024_A4WWPParameterKey ;
   private String[] BC00024_A6WWPParameterCategory ;
   private String[] BC00024_A7WWPParameterDescription ;
   private String[] BC00024_A5WWPParameterValue ;
   private boolean[] BC00024_A8WWPParameterDisableDelete ;
   private String[] BC00025_A4WWPParameterKey ;
   private String[] BC00026_A4WWPParameterKey ;
   private String[] BC00026_A6WWPParameterCategory ;
   private String[] BC00026_A7WWPParameterDescription ;
   private String[] BC00026_A5WWPParameterValue ;
   private boolean[] BC00026_A8WWPParameterDisableDelete ;
   private String[] BC00027_A4WWPParameterKey ;
   private String[] BC00027_A6WWPParameterCategory ;
   private String[] BC00027_A7WWPParameterDescription ;
   private String[] BC00027_A5WWPParameterValue ;
   private boolean[] BC00027_A8WWPParameterDisableDelete ;
   private String[] BC000211_A4WWPParameterKey ;
   private String[] BC000211_A6WWPParameterCategory ;
   private String[] BC000211_A7WWPParameterDescription ;
   private String[] BC000211_A5WWPParameterValue ;
   private boolean[] BC000211_A8WWPParameterDisableDelete ;
   private String[] BC00022_A4WWPParameterKey ;
   private String[] BC00022_A6WWPParameterCategory ;
   private String[] BC00022_A7WWPParameterDescription ;
   private String[] BC00022_A5WWPParameterValue ;
   private boolean[] BC00022_A8WWPParameterDisableDelete ;
   private String[] BC00023_A4WWPParameterKey ;
   private String[] BC00023_A6WWPParameterCategory ;
   private String[] BC00023_A7WWPParameterDescription ;
   private String[] BC00023_A5WWPParameterValue ;
   private boolean[] BC00023_A8WWPParameterDisableDelete ;
   private com.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class wwp_parameter_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00022", "SELECT WWPParameterKey, WWPParameterCategory, WWPParameterDescription, WWPParameterValue, WWPParameterDisableDelete FROM WWP_Parameter WHERE WWPParameterKey = ?  FOR UPDATE OF WWP_Parameter",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00023", "SELECT WWPParameterKey, WWPParameterCategory, WWPParameterDescription, WWPParameterValue, WWPParameterDisableDelete FROM WWP_Parameter WHERE WWPParameterKey = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00024", "SELECT TM1.WWPParameterKey, TM1.WWPParameterCategory, TM1.WWPParameterDescription, TM1.WWPParameterValue, TM1.WWPParameterDisableDelete FROM WWP_Parameter TM1 WHERE TM1.WWPParameterKey = ( ?) ORDER BY TM1.WWPParameterKey ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00025", "SELECT WWPParameterKey FROM WWP_Parameter WHERE WWPParameterKey = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00026", "SELECT WWPParameterKey, WWPParameterCategory, WWPParameterDescription, WWPParameterValue, WWPParameterDisableDelete FROM WWP_Parameter WHERE WWPParameterKey = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00027", "SELECT WWPParameterKey, WWPParameterCategory, WWPParameterDescription, WWPParameterValue, WWPParameterDisableDelete FROM WWP_Parameter WHERE WWPParameterKey = ?  FOR UPDATE OF WWP_Parameter",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC00028", "SAVEPOINT gxupdate;INSERT INTO WWP_Parameter(WWPParameterKey, WWPParameterCategory, WWPParameterDescription, WWPParameterValue, WWPParameterDisableDelete) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC00029", "SAVEPOINT gxupdate;UPDATE WWP_Parameter SET WWPParameterCategory=?, WWPParameterDescription=?, WWPParameterValue=?, WWPParameterDisableDelete=?  WHERE WWPParameterKey = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000210", "SAVEPOINT gxupdate;DELETE FROM WWP_Parameter  WHERE WWPParameterKey = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000211", "SELECT TM1.WWPParameterKey, TM1.WWPParameterCategory, TM1.WWPParameterDescription, TM1.WWPParameterValue, TM1.WWPParameterDisableDelete FROM WWP_Parameter TM1 WHERE TM1.WWPParameterKey = ( ?) ORDER BY TM1.WWPParameterKey ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               return;
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               return;
            case 5 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setVarchar(3, (String)parms[2], 200, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 200, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 300, false);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               return;
      }
   }

}

