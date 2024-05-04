package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updatemenuitemorder extends GXProcedure
{
   public updatemenuitemorder( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updatemenuitemorder.class ), "" );
   }

   public updatemenuitemorder( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( )
   {
      updatemenuitemorder.this.aP0 = new short[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( short[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short[] aP0 )
   {
      updatemenuitemorder.this.A10MenuItemId = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P00242 */
      pr_default.execute(0, new Object[] {Short.valueOf(A10MenuItemId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = updatemenuitemorder.this.A10MenuItemId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.updatemenuitemorder__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
   }

   private short A10MenuItemId ;
   private short[] aP0 ;
   private IDataStoreProvider pr_default ;
}

final  class updatemenuitemorder__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00242", "UPDATE MenuItem SET MenuItemOrder=MenuItemId  WHERE MenuItemId = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
      }
   }

}

