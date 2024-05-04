package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class menuitem_bc extends GXWebProcedure implements IGxSilentTrn
{
   public menuitem_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public menuitem_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuitem_bc.class ));
   }

   public menuitem_bc( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow033( ) ;
      standaloneNotModal( ) ;
      initializeNonKey033( ) ;
      standaloneModal( ) ;
      addRow033( ) ;
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
         e11032 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z10MenuItemId = A10MenuItemId ;
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

   public void confirm_030( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls033( ) ;
         }
         else
         {
            checkExtendedTable033( ) ;
            if ( AnyError == 0 )
            {
               zm033( 7) ;
            }
            closeExtendedTableCursors033( ) ;
         }
      }
      if ( AnyError == 0 )
      {
      }
   }

   public void e12032( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0];
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV23Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV24GXV1 = 1 ;
         while ( AV24GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV12TrnContextAtt = (com.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV24GXV1));
            if ( GXutil.strcmp(AV12TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MenuItemFatherId") == 0 )
            {
               AV11Insert_MenuItemFatherId = (short)(GXutil.lval( AV12TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV24GXV1 = (int)(AV24GXV1+1) ;
         }
      }
   }

   public void e11032( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( AV13MenuItemFatherId == 0 )
      {
      }
   }

   public void zm033( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z12MenuItemCaption = A12MenuItemCaption ;
         Z22MenuItemOrder = A22MenuItemOrder ;
         Z16MenuItemType = A16MenuItemType ;
         Z13MenuItemLink = A13MenuItemLink ;
         Z18MenuItemLinkParameters = A18MenuItemLinkParameters ;
         Z14MenuItemLinkTarget = A14MenuItemLinkTarget ;
         Z15MenuItemIconClass = A15MenuItemIconClass ;
         Z20MenuItemShowDeveloperMenuOptio = A20MenuItemShowDeveloperMenuOptio ;
         Z21MenuItemShowEditMenuOptions = A21MenuItemShowEditMenuOptions ;
         Z11MenuItemFatherId = A11MenuItemFatherId ;
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z17MenuItemFatherCaption = A17MenuItemFatherCaption ;
         Z19MenuItemFatherType = A19MenuItemFatherType ;
      }
      if ( GX_JID == -6 )
      {
         Z10MenuItemId = A10MenuItemId ;
         Z12MenuItemCaption = A12MenuItemCaption ;
         Z22MenuItemOrder = A22MenuItemOrder ;
         Z16MenuItemType = A16MenuItemType ;
         Z13MenuItemLink = A13MenuItemLink ;
         Z18MenuItemLinkParameters = A18MenuItemLinkParameters ;
         Z14MenuItemLinkTarget = A14MenuItemLinkTarget ;
         Z15MenuItemIconClass = A15MenuItemIconClass ;
         Z20MenuItemShowDeveloperMenuOptio = A20MenuItemShowDeveloperMenuOptio ;
         Z21MenuItemShowEditMenuOptions = A21MenuItemShowEditMenuOptions ;
         Z11MenuItemFatherId = A11MenuItemFatherId ;
         Z17MenuItemFatherCaption = A17MenuItemFatherCaption ;
         Z19MenuItemFatherType = A19MenuItemFatherType ;
      }
   }

   public void standaloneNotModal( )
   {
      AV23Pgmname = "WWPBaseObjects.MenuItem_BC" ;
   }

   public void standaloneModal( )
   {
   }

   public void load033( )
   {
      /* Using cursor BC00035 */
      pr_default.execute(3, new Object[] {Short.valueOf(A10MenuItemId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A12MenuItemCaption = BC00035_A12MenuItemCaption[0] ;
         A22MenuItemOrder = BC00035_A22MenuItemOrder[0] ;
         A17MenuItemFatherCaption = BC00035_A17MenuItemFatherCaption[0] ;
         A19MenuItemFatherType = BC00035_A19MenuItemFatherType[0] ;
         A16MenuItemType = BC00035_A16MenuItemType[0] ;
         A13MenuItemLink = BC00035_A13MenuItemLink[0] ;
         A18MenuItemLinkParameters = BC00035_A18MenuItemLinkParameters[0] ;
         A14MenuItemLinkTarget = BC00035_A14MenuItemLinkTarget[0] ;
         A15MenuItemIconClass = BC00035_A15MenuItemIconClass[0] ;
         A20MenuItemShowDeveloperMenuOptio = BC00035_A20MenuItemShowDeveloperMenuOptio[0] ;
         A21MenuItemShowEditMenuOptions = BC00035_A21MenuItemShowEditMenuOptions[0] ;
         A11MenuItemFatherId = BC00035_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = BC00035_n11MenuItemFatherId[0] ;
         zm033( -6) ;
      }
      pr_default.close(3);
      onLoadActions033( ) ;
   }

   public void onLoadActions033( )
   {
   }

   public void checkExtendedTable033( )
   {
      standaloneModal( ) ;
      /* Using cursor BC00036 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A11MenuItemFatherId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Menu Item Father'.", "ForeignKeyNotFound", 1, "MENUITEMFATHERID");
            AnyError = (short)(1) ;
         }
      }
      A17MenuItemFatherCaption = BC00036_A17MenuItemFatherCaption[0] ;
      A19MenuItemFatherType = BC00036_A19MenuItemFatherType[0] ;
      pr_default.close(4);
      if ( ! ( ( A16MenuItemType == 1 ) || ( A16MenuItemType == 2 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Type fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors033( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey033( )
   {
      /* Using cursor BC00037 */
      pr_default.execute(5, new Object[] {Short.valueOf(A10MenuItemId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound3 = (short)(1) ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00038 */
      pr_default.execute(6, new Object[] {Short.valueOf(A10MenuItemId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm033( 6) ;
         RcdFound3 = (short)(1) ;
         A10MenuItemId = BC00038_A10MenuItemId[0] ;
         A12MenuItemCaption = BC00038_A12MenuItemCaption[0] ;
         A22MenuItemOrder = BC00038_A22MenuItemOrder[0] ;
         A16MenuItemType = BC00038_A16MenuItemType[0] ;
         A13MenuItemLink = BC00038_A13MenuItemLink[0] ;
         A18MenuItemLinkParameters = BC00038_A18MenuItemLinkParameters[0] ;
         A14MenuItemLinkTarget = BC00038_A14MenuItemLinkTarget[0] ;
         A15MenuItemIconClass = BC00038_A15MenuItemIconClass[0] ;
         A20MenuItemShowDeveloperMenuOptio = BC00038_A20MenuItemShowDeveloperMenuOptio[0] ;
         A21MenuItemShowEditMenuOptions = BC00038_A21MenuItemShowEditMenuOptions[0] ;
         A11MenuItemFatherId = BC00038_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = BC00038_n11MenuItemFatherId[0] ;
         Z10MenuItemId = A10MenuItemId ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load033( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey033( ) ;
         }
         Gx_mode = sMode3 ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey033( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey033( ) ;
      if ( RcdFound3 == 0 )
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
      confirm_030( ) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency033( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00039 */
         pr_default.execute(7, new Object[] {Short.valueOf(A10MenuItemId)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuItem"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z12MenuItemCaption, BC00039_A12MenuItemCaption[0]) != 0 ) || ( Z22MenuItemOrder != BC00039_A22MenuItemOrder[0] ) || ( Z16MenuItemType != BC00039_A16MenuItemType[0] ) || ( GXutil.strcmp(Z13MenuItemLink, BC00039_A13MenuItemLink[0]) != 0 ) || ( GXutil.strcmp(Z18MenuItemLinkParameters, BC00039_A18MenuItemLinkParameters[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z14MenuItemLinkTarget, BC00039_A14MenuItemLinkTarget[0]) != 0 ) || ( GXutil.strcmp(Z15MenuItemIconClass, BC00039_A15MenuItemIconClass[0]) != 0 ) || ( Z20MenuItemShowDeveloperMenuOptio != BC00039_A20MenuItemShowDeveloperMenuOptio[0] ) || ( Z21MenuItemShowEditMenuOptions != BC00039_A21MenuItemShowEditMenuOptions[0] ) || ( Z11MenuItemFatherId != BC00039_A11MenuItemFatherId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MenuItem"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         zm033( 0) ;
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert033( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000310 */
                  pr_default.execute(8, new Object[] {A12MenuItemCaption, Short.valueOf(A22MenuItemOrder), Byte.valueOf(A16MenuItemType), A13MenuItemLink, A18MenuItemLinkParameters, A14MenuItemLinkTarget, A15MenuItemIconClass, Boolean.valueOf(A20MenuItemShowDeveloperMenuOptio), Boolean.valueOf(A21MenuItemShowEditMenuOptions), Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId)});
                  /* Retrieving last key number assigned */
                  /* Using cursor BC000311 */
                  pr_default.execute(9);
                  A10MenuItemId = BC000311_A10MenuItemId[0] ;
                  pr_default.close(9);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     GXv_int2[0] = A10MenuItemId ;
                     new com.wwpbaseobjects.updatemenuitemorder(remoteHandle, context).execute( GXv_int2) ;
                     menuitem_bc.this.A10MenuItemId = GXv_int2[0] ;
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
            load033( ) ;
         }
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void update033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate033( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000312 */
                  pr_default.execute(10, new Object[] {A12MenuItemCaption, Short.valueOf(A22MenuItemOrder), Byte.valueOf(A16MenuItemType), A13MenuItemLink, A18MenuItemLinkParameters, A14MenuItemLinkTarget, A15MenuItemIconClass, Boolean.valueOf(A20MenuItemShowDeveloperMenuOptio), Boolean.valueOf(A21MenuItemShowEditMenuOptions), Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId), Short.valueOf(A10MenuItemId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuItem"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate033( ) ;
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
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void deferredUpdate033( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls033( ) ;
         afterConfirm033( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete033( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000313 */
               pr_default.execute(11, new Object[] {Short.valueOf(A10MenuItemId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
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
      sMode3 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel033( ) ;
      Gx_mode = sMode3 ;
   }

   public void onDeleteControls033( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000314 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n11MenuItemFatherId), Short.valueOf(A11MenuItemFatherId)});
         A17MenuItemFatherCaption = BC000314_A17MenuItemFatherCaption[0] ;
         A19MenuItemFatherType = BC000314_A19MenuItemFatherType[0] ;
         pr_default.close(12);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000315 */
         pr_default.execute(13, new Object[] {Short.valueOf(A10MenuItemId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Item de Menú"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel033( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete033( ) ;
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

   public void scanKeyStart033( )
   {
      /* Scan By routine */
      /* Using cursor BC000316 */
      pr_default.execute(14, new Object[] {Short.valueOf(A10MenuItemId)});
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A10MenuItemId = BC000316_A10MenuItemId[0] ;
         A12MenuItemCaption = BC000316_A12MenuItemCaption[0] ;
         A22MenuItemOrder = BC000316_A22MenuItemOrder[0] ;
         A17MenuItemFatherCaption = BC000316_A17MenuItemFatherCaption[0] ;
         A19MenuItemFatherType = BC000316_A19MenuItemFatherType[0] ;
         A16MenuItemType = BC000316_A16MenuItemType[0] ;
         A13MenuItemLink = BC000316_A13MenuItemLink[0] ;
         A18MenuItemLinkParameters = BC000316_A18MenuItemLinkParameters[0] ;
         A14MenuItemLinkTarget = BC000316_A14MenuItemLinkTarget[0] ;
         A15MenuItemIconClass = BC000316_A15MenuItemIconClass[0] ;
         A20MenuItemShowDeveloperMenuOptio = BC000316_A20MenuItemShowDeveloperMenuOptio[0] ;
         A21MenuItemShowEditMenuOptions = BC000316_A21MenuItemShowEditMenuOptions[0] ;
         A11MenuItemFatherId = BC000316_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = BC000316_n11MenuItemFatherId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext033( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound3 = (short)(0) ;
      scanKeyLoad033( ) ;
   }

   public void scanKeyLoad033( )
   {
      sMode3 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A10MenuItemId = BC000316_A10MenuItemId[0] ;
         A12MenuItemCaption = BC000316_A12MenuItemCaption[0] ;
         A22MenuItemOrder = BC000316_A22MenuItemOrder[0] ;
         A17MenuItemFatherCaption = BC000316_A17MenuItemFatherCaption[0] ;
         A19MenuItemFatherType = BC000316_A19MenuItemFatherType[0] ;
         A16MenuItemType = BC000316_A16MenuItemType[0] ;
         A13MenuItemLink = BC000316_A13MenuItemLink[0] ;
         A18MenuItemLinkParameters = BC000316_A18MenuItemLinkParameters[0] ;
         A14MenuItemLinkTarget = BC000316_A14MenuItemLinkTarget[0] ;
         A15MenuItemIconClass = BC000316_A15MenuItemIconClass[0] ;
         A20MenuItemShowDeveloperMenuOptio = BC000316_A20MenuItemShowDeveloperMenuOptio[0] ;
         A21MenuItemShowEditMenuOptions = BC000316_A21MenuItemShowEditMenuOptions[0] ;
         A11MenuItemFatherId = BC000316_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = BC000316_n11MenuItemFatherId[0] ;
      }
      Gx_mode = sMode3 ;
   }

   public void scanKeyEnd033( )
   {
      pr_default.close(14);
   }

   public void afterConfirm033( )
   {
      /* After Confirm Rules */
      if ( (0==A11MenuItemFatherId) )
      {
         A11MenuItemFatherId = (short)(0) ;
         n11MenuItemFatherId = false ;
         n11MenuItemFatherId = true ;
      }
   }

   public void beforeInsert033( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate033( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete033( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete033( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate033( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes033( )
   {
   }

   public void send_integrity_lvl_hashes033( )
   {
   }

   public void addRow033( )
   {
      VarsToRow3( bcwwpbaseobjects_MenuItem) ;
   }

   public void readRow033( )
   {
      RowToVars3( bcwwpbaseobjects_MenuItem, 1) ;
   }

   public void initializeNonKey033( )
   {
      A12MenuItemCaption = "" ;
      A22MenuItemOrder = (short)(0) ;
      A11MenuItemFatherId = (short)(0) ;
      n11MenuItemFatherId = false ;
      A17MenuItemFatherCaption = "" ;
      A19MenuItemFatherType = (byte)(0) ;
      A16MenuItemType = (byte)(0) ;
      A13MenuItemLink = "" ;
      A18MenuItemLinkParameters = "" ;
      A14MenuItemLinkTarget = "" ;
      A15MenuItemIconClass = "" ;
      A20MenuItemShowDeveloperMenuOptio = false ;
      A21MenuItemShowEditMenuOptions = false ;
      Z12MenuItemCaption = "" ;
      Z22MenuItemOrder = (short)(0) ;
      Z16MenuItemType = (byte)(0) ;
      Z13MenuItemLink = "" ;
      Z18MenuItemLinkParameters = "" ;
      Z14MenuItemLinkTarget = "" ;
      Z15MenuItemIconClass = "" ;
      Z20MenuItemShowDeveloperMenuOptio = false ;
      Z21MenuItemShowEditMenuOptions = false ;
      Z11MenuItemFatherId = (short)(0) ;
   }

   public void initAll033( )
   {
      A10MenuItemId = (short)(0) ;
      initializeNonKey033( ) ;
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

   public void VarsToRow3( com.wwpbaseobjects.SdtMenuItem obj3 )
   {
      obj3.setgxTv_SdtMenuItem_Mode( Gx_mode );
      obj3.setgxTv_SdtMenuItem_Menuitemcaption( A12MenuItemCaption );
      obj3.setgxTv_SdtMenuItem_Menuitemorder( A22MenuItemOrder );
      obj3.setgxTv_SdtMenuItem_Menuitemfatherid( A11MenuItemFatherId );
      obj3.setgxTv_SdtMenuItem_Menuitemfathercaption( A17MenuItemFatherCaption );
      obj3.setgxTv_SdtMenuItem_Menuitemfathertype( A19MenuItemFatherType );
      obj3.setgxTv_SdtMenuItem_Menuitemtype( A16MenuItemType );
      obj3.setgxTv_SdtMenuItem_Menuitemlink( A13MenuItemLink );
      obj3.setgxTv_SdtMenuItem_Menuitemlinkparameters( A18MenuItemLinkParameters );
      obj3.setgxTv_SdtMenuItem_Menuitemlinktarget( A14MenuItemLinkTarget );
      obj3.setgxTv_SdtMenuItem_Menuitemiconclass( A15MenuItemIconClass );
      obj3.setgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption( A20MenuItemShowDeveloperMenuOptio );
      obj3.setgxTv_SdtMenuItem_Menuitemshoweditmenuoptions( A21MenuItemShowEditMenuOptions );
      obj3.setgxTv_SdtMenuItem_Menuitemid( A10MenuItemId );
      obj3.setgxTv_SdtMenuItem_Menuitemid_Z( Z10MenuItemId );
      obj3.setgxTv_SdtMenuItem_Menuitemcaption_Z( Z12MenuItemCaption );
      obj3.setgxTv_SdtMenuItem_Menuitemorder_Z( Z22MenuItemOrder );
      obj3.setgxTv_SdtMenuItem_Menuitemfatherid_Z( Z11MenuItemFatherId );
      obj3.setgxTv_SdtMenuItem_Menuitemfathercaption_Z( Z17MenuItemFatherCaption );
      obj3.setgxTv_SdtMenuItem_Menuitemfathertype_Z( Z19MenuItemFatherType );
      obj3.setgxTv_SdtMenuItem_Menuitemtype_Z( Z16MenuItemType );
      obj3.setgxTv_SdtMenuItem_Menuitemlink_Z( Z13MenuItemLink );
      obj3.setgxTv_SdtMenuItem_Menuitemlinkparameters_Z( Z18MenuItemLinkParameters );
      obj3.setgxTv_SdtMenuItem_Menuitemlinktarget_Z( Z14MenuItemLinkTarget );
      obj3.setgxTv_SdtMenuItem_Menuitemiconclass_Z( Z15MenuItemIconClass );
      obj3.setgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z( Z20MenuItemShowDeveloperMenuOptio );
      obj3.setgxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z( Z21MenuItemShowEditMenuOptions );
      obj3.setgxTv_SdtMenuItem_Menuitemfatherid_N( (byte)((byte)((n11MenuItemFatherId)?1:0)) );
      obj3.setgxTv_SdtMenuItem_Mode( Gx_mode );
   }

   public void KeyVarsToRow3( com.wwpbaseobjects.SdtMenuItem obj3 )
   {
      obj3.setgxTv_SdtMenuItem_Menuitemid( A10MenuItemId );
   }

   public void RowToVars3( com.wwpbaseobjects.SdtMenuItem obj3 ,
                           int forceLoad )
   {
      Gx_mode = obj3.getgxTv_SdtMenuItem_Mode() ;
      A12MenuItemCaption = obj3.getgxTv_SdtMenuItem_Menuitemcaption() ;
      A22MenuItemOrder = obj3.getgxTv_SdtMenuItem_Menuitemorder() ;
      A11MenuItemFatherId = obj3.getgxTv_SdtMenuItem_Menuitemfatherid() ;
      n11MenuItemFatherId = false ;
      A17MenuItemFatherCaption = obj3.getgxTv_SdtMenuItem_Menuitemfathercaption() ;
      A19MenuItemFatherType = obj3.getgxTv_SdtMenuItem_Menuitemfathertype() ;
      A16MenuItemType = obj3.getgxTv_SdtMenuItem_Menuitemtype() ;
      A13MenuItemLink = obj3.getgxTv_SdtMenuItem_Menuitemlink() ;
      A18MenuItemLinkParameters = obj3.getgxTv_SdtMenuItem_Menuitemlinkparameters() ;
      A14MenuItemLinkTarget = obj3.getgxTv_SdtMenuItem_Menuitemlinktarget() ;
      A15MenuItemIconClass = obj3.getgxTv_SdtMenuItem_Menuitemiconclass() ;
      A20MenuItemShowDeveloperMenuOptio = obj3.getgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption() ;
      A21MenuItemShowEditMenuOptions = obj3.getgxTv_SdtMenuItem_Menuitemshoweditmenuoptions() ;
      A10MenuItemId = obj3.getgxTv_SdtMenuItem_Menuitemid() ;
      Z10MenuItemId = obj3.getgxTv_SdtMenuItem_Menuitemid_Z() ;
      Z12MenuItemCaption = obj3.getgxTv_SdtMenuItem_Menuitemcaption_Z() ;
      Z22MenuItemOrder = obj3.getgxTv_SdtMenuItem_Menuitemorder_Z() ;
      Z11MenuItemFatherId = obj3.getgxTv_SdtMenuItem_Menuitemfatherid_Z() ;
      Z17MenuItemFatherCaption = obj3.getgxTv_SdtMenuItem_Menuitemfathercaption_Z() ;
      Z19MenuItemFatherType = obj3.getgxTv_SdtMenuItem_Menuitemfathertype_Z() ;
      Z16MenuItemType = obj3.getgxTv_SdtMenuItem_Menuitemtype_Z() ;
      Z13MenuItemLink = obj3.getgxTv_SdtMenuItem_Menuitemlink_Z() ;
      Z18MenuItemLinkParameters = obj3.getgxTv_SdtMenuItem_Menuitemlinkparameters_Z() ;
      Z14MenuItemLinkTarget = obj3.getgxTv_SdtMenuItem_Menuitemlinktarget_Z() ;
      Z15MenuItemIconClass = obj3.getgxTv_SdtMenuItem_Menuitemiconclass_Z() ;
      Z20MenuItemShowDeveloperMenuOptio = obj3.getgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z() ;
      Z21MenuItemShowEditMenuOptions = obj3.getgxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z() ;
      n11MenuItemFatherId = (boolean)((obj3.getgxTv_SdtMenuItem_Menuitemfatherid_N()==0)?false:true) ;
      Gx_mode = obj3.getgxTv_SdtMenuItem_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A10MenuItemId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey033( ) ;
      scanKeyStart033( ) ;
      if ( RcdFound3 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z10MenuItemId = A10MenuItemId ;
      }
      zm033( -6) ;
      onLoadActions033( ) ;
      addRow033( ) ;
      scanKeyEnd033( ) ;
      if ( RcdFound3 == 0 )
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
      RowToVars3( bcwwpbaseobjects_MenuItem, 0) ;
      scanKeyStart033( ) ;
      if ( RcdFound3 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z10MenuItemId = A10MenuItemId ;
      }
      zm033( -6) ;
      onLoadActions033( ) ;
      addRow033( ) ;
      scanKeyEnd033( ) ;
      if ( RcdFound3 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      getKey033( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert033( ) ;
      }
      else
      {
         if ( RcdFound3 == 1 )
         {
            if ( A10MenuItemId != Z10MenuItemId )
            {
               A10MenuItemId = Z10MenuItemId ;
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
               update033( ) ;
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
               if ( A10MenuItemId != Z10MenuItemId )
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
                     insert033( ) ;
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
                     insert033( ) ;
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
      RowToVars3( bcwwpbaseobjects_MenuItem, 1) ;
      saveImpl( ) ;
      VarsToRow3( bcwwpbaseobjects_MenuItem) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars3( bcwwpbaseobjects_MenuItem, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert033( ) ;
      afterTrn( ) ;
      VarsToRow3( bcwwpbaseobjects_MenuItem) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
         VarsToRow3( bcwwpbaseobjects_MenuItem) ;
      }
      else
      {
         com.wwpbaseobjects.SdtMenuItem auxBC = new com.wwpbaseobjects.SdtMenuItem( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A10MenuItemId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_MenuItem);
            auxBC.Save();
            bcwwpbaseobjects_MenuItem.copy(auxBC);
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
      RowToVars3( bcwwpbaseobjects_MenuItem, 1) ;
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
      RowToVars3( bcwwpbaseobjects_MenuItem, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert033( ) ;
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
            VarsToRow3( bcwwpbaseobjects_MenuItem) ;
         }
      }
      else
      {
         afterTrn( ) ;
         VarsToRow3( bcwwpbaseobjects_MenuItem) ;
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
      RowToVars3( bcwwpbaseobjects_MenuItem, 0) ;
      getKey033( ) ;
      if ( RcdFound3 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A10MenuItemId != Z10MenuItemId )
         {
            A10MenuItemId = Z10MenuItemId ;
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
         if ( A10MenuItemId != Z10MenuItemId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.menuitem_bc");
      VarsToRow3( bcwwpbaseobjects_MenuItem) ;
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
      Gx_mode = bcwwpbaseobjects_MenuItem.getgxTv_SdtMenuItem_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_MenuItem.setgxTv_SdtMenuItem_Mode( Gx_mode );
   }

   public void SetSDT( com.wwpbaseobjects.SdtMenuItem sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_MenuItem )
      {
         bcwwpbaseobjects_MenuItem = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_MenuItem.getgxTv_SdtMenuItem_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_MenuItem.setgxTv_SdtMenuItem_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow3( bcwwpbaseobjects_MenuItem) ;
         }
         else
         {
            RowToVars3( bcwwpbaseobjects_MenuItem, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_MenuItem.getgxTv_SdtMenuItem_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_MenuItem.setgxTv_SdtMenuItem_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars3( bcwwpbaseobjects_MenuItem, 1) ;
   }

   public void ForceCommitOnExit( )
   {
   }

   public SdtMenuItem getMenuItem_BC( )
   {
      return bcwwpbaseobjects_MenuItem ;
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
      AV8WWPContext = new com.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.wwpbaseobjects.SdtWWPContext[1] ;
      AV9TrnContext = new com.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV23Pgmname = "" ;
      AV12TrnContextAtt = new com.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z12MenuItemCaption = "" ;
      A12MenuItemCaption = "" ;
      Z13MenuItemLink = "" ;
      A13MenuItemLink = "" ;
      Z18MenuItemLinkParameters = "" ;
      A18MenuItemLinkParameters = "" ;
      Z14MenuItemLinkTarget = "" ;
      A14MenuItemLinkTarget = "" ;
      Z15MenuItemIconClass = "" ;
      A15MenuItemIconClass = "" ;
      Z17MenuItemFatherCaption = "" ;
      A17MenuItemFatherCaption = "" ;
      BC00035_A10MenuItemId = new short[1] ;
      BC00035_A12MenuItemCaption = new String[] {""} ;
      BC00035_A22MenuItemOrder = new short[1] ;
      BC00035_A17MenuItemFatherCaption = new String[] {""} ;
      BC00035_A19MenuItemFatherType = new byte[1] ;
      BC00035_A16MenuItemType = new byte[1] ;
      BC00035_A13MenuItemLink = new String[] {""} ;
      BC00035_A18MenuItemLinkParameters = new String[] {""} ;
      BC00035_A14MenuItemLinkTarget = new String[] {""} ;
      BC00035_A15MenuItemIconClass = new String[] {""} ;
      BC00035_A20MenuItemShowDeveloperMenuOptio = new boolean[] {false} ;
      BC00035_A21MenuItemShowEditMenuOptions = new boolean[] {false} ;
      BC00035_A11MenuItemFatherId = new short[1] ;
      BC00035_n11MenuItemFatherId = new boolean[] {false} ;
      BC00036_A17MenuItemFatherCaption = new String[] {""} ;
      BC00036_A19MenuItemFatherType = new byte[1] ;
      BC00037_A10MenuItemId = new short[1] ;
      BC00038_A10MenuItemId = new short[1] ;
      BC00038_A12MenuItemCaption = new String[] {""} ;
      BC00038_A22MenuItemOrder = new short[1] ;
      BC00038_A16MenuItemType = new byte[1] ;
      BC00038_A13MenuItemLink = new String[] {""} ;
      BC00038_A18MenuItemLinkParameters = new String[] {""} ;
      BC00038_A14MenuItemLinkTarget = new String[] {""} ;
      BC00038_A15MenuItemIconClass = new String[] {""} ;
      BC00038_A20MenuItemShowDeveloperMenuOptio = new boolean[] {false} ;
      BC00038_A21MenuItemShowEditMenuOptions = new boolean[] {false} ;
      BC00038_A11MenuItemFatherId = new short[1] ;
      BC00038_n11MenuItemFatherId = new boolean[] {false} ;
      sMode3 = "" ;
      BC00039_A10MenuItemId = new short[1] ;
      BC00039_A12MenuItemCaption = new String[] {""} ;
      BC00039_A22MenuItemOrder = new short[1] ;
      BC00039_A16MenuItemType = new byte[1] ;
      BC00039_A13MenuItemLink = new String[] {""} ;
      BC00039_A18MenuItemLinkParameters = new String[] {""} ;
      BC00039_A14MenuItemLinkTarget = new String[] {""} ;
      BC00039_A15MenuItemIconClass = new String[] {""} ;
      BC00039_A20MenuItemShowDeveloperMenuOptio = new boolean[] {false} ;
      BC00039_A21MenuItemShowEditMenuOptions = new boolean[] {false} ;
      BC00039_A11MenuItemFatherId = new short[1] ;
      BC00039_n11MenuItemFatherId = new boolean[] {false} ;
      BC000311_A10MenuItemId = new short[1] ;
      GXv_int2 = new short[1] ;
      BC000314_A17MenuItemFatherCaption = new String[] {""} ;
      BC000314_A19MenuItemFatherType = new byte[1] ;
      BC000315_A11MenuItemFatherId = new short[1] ;
      BC000315_n11MenuItemFatherId = new boolean[] {false} ;
      BC000316_A10MenuItemId = new short[1] ;
      BC000316_A12MenuItemCaption = new String[] {""} ;
      BC000316_A22MenuItemOrder = new short[1] ;
      BC000316_A17MenuItemFatherCaption = new String[] {""} ;
      BC000316_A19MenuItemFatherType = new byte[1] ;
      BC000316_A16MenuItemType = new byte[1] ;
      BC000316_A13MenuItemLink = new String[] {""} ;
      BC000316_A18MenuItemLinkParameters = new String[] {""} ;
      BC000316_A14MenuItemLinkTarget = new String[] {""} ;
      BC000316_A15MenuItemIconClass = new String[] {""} ;
      BC000316_A20MenuItemShowDeveloperMenuOptio = new boolean[] {false} ;
      BC000316_A21MenuItemShowEditMenuOptions = new boolean[] {false} ;
      BC000316_A11MenuItemFatherId = new short[1] ;
      BC000316_n11MenuItemFatherId = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.menuitem_bc__default(),
         new Object[] {
             new Object[] {
            BC00032_A10MenuItemId, BC00032_A12MenuItemCaption, BC00032_A22MenuItemOrder, BC00032_A16MenuItemType, BC00032_A13MenuItemLink, BC00032_A18MenuItemLinkParameters, BC00032_A14MenuItemLinkTarget, BC00032_A15MenuItemIconClass, BC00032_A20MenuItemShowDeveloperMenuOptio, BC00032_A21MenuItemShowEditMenuOptions,
            BC00032_A11MenuItemFatherId, BC00032_n11MenuItemFatherId
            }
            , new Object[] {
            BC00033_A10MenuItemId, BC00033_A12MenuItemCaption, BC00033_A22MenuItemOrder, BC00033_A16MenuItemType, BC00033_A13MenuItemLink, BC00033_A18MenuItemLinkParameters, BC00033_A14MenuItemLinkTarget, BC00033_A15MenuItemIconClass, BC00033_A20MenuItemShowDeveloperMenuOptio, BC00033_A21MenuItemShowEditMenuOptions,
            BC00033_A11MenuItemFatherId, BC00033_n11MenuItemFatherId
            }
            , new Object[] {
            BC00034_A17MenuItemFatherCaption, BC00034_A19MenuItemFatherType
            }
            , new Object[] {
            BC00035_A10MenuItemId, BC00035_A12MenuItemCaption, BC00035_A22MenuItemOrder, BC00035_A17MenuItemFatherCaption, BC00035_A19MenuItemFatherType, BC00035_A16MenuItemType, BC00035_A13MenuItemLink, BC00035_A18MenuItemLinkParameters, BC00035_A14MenuItemLinkTarget, BC00035_A15MenuItemIconClass,
            BC00035_A20MenuItemShowDeveloperMenuOptio, BC00035_A21MenuItemShowEditMenuOptions, BC00035_A11MenuItemFatherId, BC00035_n11MenuItemFatherId
            }
            , new Object[] {
            BC00036_A17MenuItemFatherCaption, BC00036_A19MenuItemFatherType
            }
            , new Object[] {
            BC00037_A10MenuItemId
            }
            , new Object[] {
            BC00038_A10MenuItemId, BC00038_A12MenuItemCaption, BC00038_A22MenuItemOrder, BC00038_A16MenuItemType, BC00038_A13MenuItemLink, BC00038_A18MenuItemLinkParameters, BC00038_A14MenuItemLinkTarget, BC00038_A15MenuItemIconClass, BC00038_A20MenuItemShowDeveloperMenuOptio, BC00038_A21MenuItemShowEditMenuOptions,
            BC00038_A11MenuItemFatherId, BC00038_n11MenuItemFatherId
            }
            , new Object[] {
            BC00039_A10MenuItemId, BC00039_A12MenuItemCaption, BC00039_A22MenuItemOrder, BC00039_A16MenuItemType, BC00039_A13MenuItemLink, BC00039_A18MenuItemLinkParameters, BC00039_A14MenuItemLinkTarget, BC00039_A15MenuItemIconClass, BC00039_A20MenuItemShowDeveloperMenuOptio, BC00039_A21MenuItemShowEditMenuOptions,
            BC00039_A11MenuItemFatherId, BC00039_n11MenuItemFatherId
            }
            , new Object[] {
            }
            , new Object[] {
            BC000311_A10MenuItemId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000314_A17MenuItemFatherCaption, BC000314_A19MenuItemFatherType
            }
            , new Object[] {
            BC000315_A11MenuItemFatherId
            }
            , new Object[] {
            BC000316_A10MenuItemId, BC000316_A12MenuItemCaption, BC000316_A22MenuItemOrder, BC000316_A17MenuItemFatherCaption, BC000316_A19MenuItemFatherType, BC000316_A16MenuItemType, BC000316_A13MenuItemLink, BC000316_A18MenuItemLinkParameters, BC000316_A14MenuItemLinkTarget, BC000316_A15MenuItemIconClass,
            BC000316_A20MenuItemShowDeveloperMenuOptio, BC000316_A21MenuItemShowEditMenuOptions, BC000316_A11MenuItemFatherId, BC000316_n11MenuItemFatherId
            }
         }
      );
      AV23Pgmname = "WWPBaseObjects.MenuItem_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12032 ();
      standaloneNotModal( ) ;
   }

   private byte Z16MenuItemType ;
   private byte A16MenuItemType ;
   private byte Z19MenuItemFatherType ;
   private byte A19MenuItemFatherType ;
   private short AnyError ;
   private short Z10MenuItemId ;
   private short A10MenuItemId ;
   private short AV11Insert_MenuItemFatherId ;
   private short AV13MenuItemFatherId ;
   private short Z22MenuItemOrder ;
   private short A22MenuItemOrder ;
   private short Z11MenuItemFatherId ;
   private short A11MenuItemFatherId ;
   private short RcdFound3 ;
   private short GXv_int2[] ;
   private int trnEnded ;
   private int AV24GXV1 ;
   private int GX_JID ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV23Pgmname ;
   private String sMode3 ;
   private boolean returnInSub ;
   private boolean Z20MenuItemShowDeveloperMenuOptio ;
   private boolean A20MenuItemShowDeveloperMenuOptio ;
   private boolean Z21MenuItemShowEditMenuOptions ;
   private boolean A21MenuItemShowEditMenuOptions ;
   private boolean n11MenuItemFatherId ;
   private boolean Gx_longc ;
   private String Z12MenuItemCaption ;
   private String A12MenuItemCaption ;
   private String Z13MenuItemLink ;
   private String A13MenuItemLink ;
   private String Z18MenuItemLinkParameters ;
   private String A18MenuItemLinkParameters ;
   private String Z14MenuItemLinkTarget ;
   private String A14MenuItemLinkTarget ;
   private String Z15MenuItemIconClass ;
   private String A15MenuItemIconClass ;
   private String Z17MenuItemFatherCaption ;
   private String A17MenuItemFatherCaption ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.wwpbaseobjects.SdtMenuItem bcwwpbaseobjects_MenuItem ;
   private IDataStoreProvider pr_default ;
   private short[] BC00035_A10MenuItemId ;
   private String[] BC00035_A12MenuItemCaption ;
   private short[] BC00035_A22MenuItemOrder ;
   private String[] BC00035_A17MenuItemFatherCaption ;
   private byte[] BC00035_A19MenuItemFatherType ;
   private byte[] BC00035_A16MenuItemType ;
   private String[] BC00035_A13MenuItemLink ;
   private String[] BC00035_A18MenuItemLinkParameters ;
   private String[] BC00035_A14MenuItemLinkTarget ;
   private String[] BC00035_A15MenuItemIconClass ;
   private boolean[] BC00035_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] BC00035_A21MenuItemShowEditMenuOptions ;
   private short[] BC00035_A11MenuItemFatherId ;
   private boolean[] BC00035_n11MenuItemFatherId ;
   private String[] BC00036_A17MenuItemFatherCaption ;
   private byte[] BC00036_A19MenuItemFatherType ;
   private short[] BC00037_A10MenuItemId ;
   private short[] BC00038_A10MenuItemId ;
   private String[] BC00038_A12MenuItemCaption ;
   private short[] BC00038_A22MenuItemOrder ;
   private byte[] BC00038_A16MenuItemType ;
   private String[] BC00038_A13MenuItemLink ;
   private String[] BC00038_A18MenuItemLinkParameters ;
   private String[] BC00038_A14MenuItemLinkTarget ;
   private String[] BC00038_A15MenuItemIconClass ;
   private boolean[] BC00038_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] BC00038_A21MenuItemShowEditMenuOptions ;
   private short[] BC00038_A11MenuItemFatherId ;
   private boolean[] BC00038_n11MenuItemFatherId ;
   private short[] BC00039_A10MenuItemId ;
   private String[] BC00039_A12MenuItemCaption ;
   private short[] BC00039_A22MenuItemOrder ;
   private byte[] BC00039_A16MenuItemType ;
   private String[] BC00039_A13MenuItemLink ;
   private String[] BC00039_A18MenuItemLinkParameters ;
   private String[] BC00039_A14MenuItemLinkTarget ;
   private String[] BC00039_A15MenuItemIconClass ;
   private boolean[] BC00039_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] BC00039_A21MenuItemShowEditMenuOptions ;
   private short[] BC00039_A11MenuItemFatherId ;
   private boolean[] BC00039_n11MenuItemFatherId ;
   private short[] BC000311_A10MenuItemId ;
   private String[] BC000314_A17MenuItemFatherCaption ;
   private byte[] BC000314_A19MenuItemFatherType ;
   private short[] BC000315_A11MenuItemFatherId ;
   private boolean[] BC000315_n11MenuItemFatherId ;
   private short[] BC000316_A10MenuItemId ;
   private String[] BC000316_A12MenuItemCaption ;
   private short[] BC000316_A22MenuItemOrder ;
   private String[] BC000316_A17MenuItemFatherCaption ;
   private byte[] BC000316_A19MenuItemFatherType ;
   private byte[] BC000316_A16MenuItemType ;
   private String[] BC000316_A13MenuItemLink ;
   private String[] BC000316_A18MenuItemLinkParameters ;
   private String[] BC000316_A14MenuItemLinkTarget ;
   private String[] BC000316_A15MenuItemIconClass ;
   private boolean[] BC000316_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] BC000316_A21MenuItemShowEditMenuOptions ;
   private short[] BC000316_A11MenuItemFatherId ;
   private boolean[] BC000316_n11MenuItemFatherId ;
   private short[] BC00032_A10MenuItemId ;
   private String[] BC00032_A12MenuItemCaption ;
   private short[] BC00032_A22MenuItemOrder ;
   private byte[] BC00032_A16MenuItemType ;
   private String[] BC00032_A13MenuItemLink ;
   private String[] BC00032_A18MenuItemLinkParameters ;
   private String[] BC00032_A14MenuItemLinkTarget ;
   private String[] BC00032_A15MenuItemIconClass ;
   private boolean[] BC00032_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] BC00032_A21MenuItemShowEditMenuOptions ;
   private short[] BC00032_A11MenuItemFatherId ;
   private short[] BC00033_A10MenuItemId ;
   private String[] BC00033_A12MenuItemCaption ;
   private short[] BC00033_A22MenuItemOrder ;
   private byte[] BC00033_A16MenuItemType ;
   private String[] BC00033_A13MenuItemLink ;
   private String[] BC00033_A18MenuItemLinkParameters ;
   private String[] BC00033_A14MenuItemLinkTarget ;
   private String[] BC00033_A15MenuItemIconClass ;
   private boolean[] BC00033_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] BC00033_A21MenuItemShowEditMenuOptions ;
   private short[] BC00033_A11MenuItemFatherId ;
   private String[] BC00034_A17MenuItemFatherCaption ;
   private byte[] BC00034_A19MenuItemFatherType ;
   private boolean[] BC00032_n11MenuItemFatherId ;
   private boolean[] BC00033_n11MenuItemFatherId ;
   private com.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV12TrnContextAtt ;
}

final  class menuitem_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00032", "SELECT MenuItemId, MenuItemCaption, MenuItemOrder, MenuItemType, MenuItemLink, MenuItemLinkParameters, MenuItemLinkTarget, MenuItemIconClass, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions, MenuItemFatherId FROM MenuItem WHERE MenuItemId = ?  FOR UPDATE OF MenuItem",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00033", "SELECT MenuItemId, MenuItemCaption, MenuItemOrder, MenuItemType, MenuItemLink, MenuItemLinkParameters, MenuItemLinkTarget, MenuItemIconClass, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions, MenuItemFatherId FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00034", "SELECT MenuItemCaption AS MenuItemFatherCaption, MenuItemType AS MenuItemFatherType FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00035", "SELECT TM1.MenuItemId, TM1.MenuItemCaption, TM1.MenuItemOrder, T2.MenuItemCaption AS MenuItemFatherCaption, T2.MenuItemType AS MenuItemFatherType, TM1.MenuItemType, TM1.MenuItemLink, TM1.MenuItemLinkParameters, TM1.MenuItemLinkTarget, TM1.MenuItemIconClass, TM1.MenuItemShowDeveloperMenuOptio, TM1.MenuItemShowEditMenuOptions, TM1.MenuItemFatherId AS MenuItemFatherId FROM (MenuItem TM1 LEFT JOIN MenuItem T2 ON T2.MenuItemId = TM1.MenuItemFatherId) WHERE TM1.MenuItemId = ? ORDER BY TM1.MenuItemId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00036", "SELECT MenuItemCaption AS MenuItemFatherCaption, MenuItemType AS MenuItemFatherType FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00037", "SELECT MenuItemId FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00038", "SELECT MenuItemId, MenuItemCaption, MenuItemOrder, MenuItemType, MenuItemLink, MenuItemLinkParameters, MenuItemLinkTarget, MenuItemIconClass, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions, MenuItemFatherId FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00039", "SELECT MenuItemId, MenuItemCaption, MenuItemOrder, MenuItemType, MenuItemLink, MenuItemLinkParameters, MenuItemLinkTarget, MenuItemIconClass, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions, MenuItemFatherId FROM MenuItem WHERE MenuItemId = ?  FOR UPDATE OF MenuItem",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000310", "SAVEPOINT gxupdate;INSERT INTO MenuItem(MenuItemCaption, MenuItemOrder, MenuItemType, MenuItemLink, MenuItemLinkParameters, MenuItemLinkTarget, MenuItemIconClass, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions, MenuItemFatherId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000311", "SELECT currval('MenuItemId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000312", "SAVEPOINT gxupdate;UPDATE MenuItem SET MenuItemCaption=?, MenuItemOrder=?, MenuItemType=?, MenuItemLink=?, MenuItemLinkParameters=?, MenuItemLinkTarget=?, MenuItemIconClass=?, MenuItemShowDeveloperMenuOptio=?, MenuItemShowEditMenuOptions=?, MenuItemFatherId=?  WHERE MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000313", "SAVEPOINT gxupdate;DELETE FROM MenuItem  WHERE MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000314", "SELECT MenuItemCaption AS MenuItemFatherCaption, MenuItemType AS MenuItemFatherType FROM MenuItem WHERE MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000315", "SELECT MenuItemId AS MenuItemFatherId FROM MenuItem WHERE MenuItemFatherId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000316", "SELECT TM1.MenuItemId, TM1.MenuItemCaption, TM1.MenuItemOrder, T2.MenuItemCaption AS MenuItemFatherCaption, T2.MenuItemType AS MenuItemFatherType, TM1.MenuItemType, TM1.MenuItemLink, TM1.MenuItemLinkParameters, TM1.MenuItemLinkTarget, TM1.MenuItemIconClass, TM1.MenuItemShowDeveloperMenuOptio, TM1.MenuItemShowEditMenuOptions, TM1.MenuItemFatherId AS MenuItemFatherId FROM (MenuItem TM1 LEFT JOIN MenuItem T2 ON T2.MenuItemId = TM1.MenuItemFatherId) WHERE TM1.MenuItemId = ? ORDER BY TM1.MenuItemId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setVarchar(6, (String)parms[5], 10, false);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[10]).shortValue());
               }
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setVarchar(6, (String)parms[5], 10, false);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[10]).shortValue());
               }
               stmt.setShort(11, ((Number) parms[11]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

