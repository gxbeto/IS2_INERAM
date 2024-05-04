package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class moveupitem extends GXProcedure
{
   public moveupitem( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( moveupitem.class ), "" );
   }

   public moveupitem( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        short aP1 ,
                        short aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             short aP1 ,
                             short aP2 )
   {
      moveupitem.this.AV9MenuItemIdToMoveUp = aP0;
      moveupitem.this.AV13MenuItemOrderToMoveUp = aP1;
      moveupitem.this.AV8MenuItemFatherId = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      /* Using cursor P002A2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV13MenuItemOrderToMoveUp), Short.valueOf(AV8MenuItemFatherId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11MenuItemFatherId = P002A2_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = P002A2_n11MenuItemFatherId[0] ;
         A22MenuItemOrder = P002A2_A22MenuItemOrder[0] ;
         A10MenuItemId = P002A2_A10MenuItemId[0] ;
         AV12MenuItemIdPreviousValue = A10MenuItemId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV11MenuItemToMoveUp.Load(AV9MenuItemIdToMoveUp);
      AV10MenuItemToMoveDown.Load(AV12MenuItemIdPreviousValue);
      AV14MenuItemOrderAux = AV11MenuItemToMoveUp.getgxTv_SdtMenuItem_Menuitemorder() ;
      AV11MenuItemToMoveUp.setgxTv_SdtMenuItem_Menuitemorder( AV10MenuItemToMoveDown.getgxTv_SdtMenuItem_Menuitemorder() );
      AV10MenuItemToMoveDown.setgxTv_SdtMenuItem_Menuitemorder( AV14MenuItemOrderAux );
      AV11MenuItemToMoveUp.Save();
      AV10MenuItemToMoveDown.Save();
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.moveupitem");
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      P002A2_A11MenuItemFatherId = new short[1] ;
      P002A2_n11MenuItemFatherId = new boolean[] {false} ;
      P002A2_A22MenuItemOrder = new short[1] ;
      P002A2_A10MenuItemId = new short[1] ;
      AV11MenuItemToMoveUp = new com.wwpbaseobjects.SdtMenuItem(remoteHandle);
      AV10MenuItemToMoveDown = new com.wwpbaseobjects.SdtMenuItem(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.moveupitem__default(),
         new Object[] {
             new Object[] {
            P002A2_A11MenuItemFatherId, P002A2_n11MenuItemFatherId, P002A2_A22MenuItemOrder, P002A2_A10MenuItemId
            }
         }
      );
      /* GeneXus formulas. */
   }

   private short AV9MenuItemIdToMoveUp ;
   private short AV13MenuItemOrderToMoveUp ;
   private short AV8MenuItemFatherId ;
   private short A11MenuItemFatherId ;
   private short A22MenuItemOrder ;
   private short A10MenuItemId ;
   private short AV12MenuItemIdPreviousValue ;
   private short AV14MenuItemOrderAux ;
   private boolean n11MenuItemFatherId ;
   private IDataStoreProvider pr_default ;
   private short[] P002A2_A11MenuItemFatherId ;
   private boolean[] P002A2_n11MenuItemFatherId ;
   private short[] P002A2_A22MenuItemOrder ;
   private short[] P002A2_A10MenuItemId ;
   private com.wwpbaseobjects.SdtMenuItem AV11MenuItemToMoveUp ;
   private com.wwpbaseobjects.SdtMenuItem AV10MenuItemToMoveDown ;
}

final  class moveupitem__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002A2", "SELECT MenuItemFatherId, MenuItemOrder, MenuItemId FROM MenuItem WHERE (MenuItemOrder < ?) AND (MenuItemFatherId = ?) ORDER BY MenuItemOrder DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

