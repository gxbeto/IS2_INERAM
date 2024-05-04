package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class movedownitem extends GXProcedure
{
   public movedownitem( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( movedownitem.class ), "" );
   }

   public movedownitem( int remoteHandle ,
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
      movedownitem.this.AV8MenuItemIdToMoveDown = aP0;
      movedownitem.this.AV13MenuItemOrderToMoveDown = aP1;
      movedownitem.this.AV11MenuItemFatherId = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      /* Using cursor P00292 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV13MenuItemOrderToMoveDown), Short.valueOf(AV11MenuItemFatherId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11MenuItemFatherId = P00292_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = P00292_n11MenuItemFatherId[0] ;
         A22MenuItemOrder = P00292_A22MenuItemOrder[0] ;
         A10MenuItemId = P00292_A10MenuItemId[0] ;
         AV12MenuItemIdPreviousValue = A10MenuItemId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV10MenuItemToMoveDown.Load(AV8MenuItemIdToMoveDown);
      AV9MenuItemToMoveUp.Load(AV12MenuItemIdPreviousValue);
      AV14MenuItemOrderAux = AV9MenuItemToMoveUp.getgxTv_SdtMenuItem_Menuitemorder() ;
      AV9MenuItemToMoveUp.setgxTv_SdtMenuItem_Menuitemorder( AV10MenuItemToMoveDown.getgxTv_SdtMenuItem_Menuitemorder() );
      AV10MenuItemToMoveDown.setgxTv_SdtMenuItem_Menuitemorder( AV14MenuItemOrderAux );
      AV9MenuItemToMoveUp.Save();
      AV10MenuItemToMoveDown.Save();
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.movedownitem");
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
      P00292_A11MenuItemFatherId = new short[1] ;
      P00292_n11MenuItemFatherId = new boolean[] {false} ;
      P00292_A22MenuItemOrder = new short[1] ;
      P00292_A10MenuItemId = new short[1] ;
      AV10MenuItemToMoveDown = new com.wwpbaseobjects.SdtMenuItem(remoteHandle);
      AV9MenuItemToMoveUp = new com.wwpbaseobjects.SdtMenuItem(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.movedownitem__default(),
         new Object[] {
             new Object[] {
            P00292_A11MenuItemFatherId, P00292_n11MenuItemFatherId, P00292_A22MenuItemOrder, P00292_A10MenuItemId
            }
         }
      );
      /* GeneXus formulas. */
   }

   private short AV8MenuItemIdToMoveDown ;
   private short AV13MenuItemOrderToMoveDown ;
   private short AV11MenuItemFatherId ;
   private short A11MenuItemFatherId ;
   private short A22MenuItemOrder ;
   private short A10MenuItemId ;
   private short AV12MenuItemIdPreviousValue ;
   private short AV14MenuItemOrderAux ;
   private boolean n11MenuItemFatherId ;
   private IDataStoreProvider pr_default ;
   private short[] P00292_A11MenuItemFatherId ;
   private boolean[] P00292_n11MenuItemFatherId ;
   private short[] P00292_A22MenuItemOrder ;
   private short[] P00292_A10MenuItemId ;
   private com.wwpbaseobjects.SdtMenuItem AV10MenuItemToMoveDown ;
   private com.wwpbaseobjects.SdtMenuItem AV9MenuItemToMoveUp ;
}

final  class movedownitem__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00292", "SELECT MenuItemFatherId, MenuItemOrder, MenuItemId FROM MenuItem WHERE (MenuItemOrder > ?) AND (MenuItemFatherId = ?) ORDER BY MenuItemOrder  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

