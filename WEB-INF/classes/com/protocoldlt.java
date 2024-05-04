package com ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class protocoldlt extends GXProcedure
{
   public protocoldlt( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( protocoldlt.class ), "" );
   }

   public protocoldlt( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long aP0 )
   {
      protocoldlt.this.AV8ProtID = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      /* Optimized DELETE. */
      /* Using cursor P002J2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV8ProtID)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Protocolo");
      /* End optimized DELETE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "protocoldlt");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new com.protocoldlt__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
   }

   private long AV8ProtID ;
   private IDataStoreProvider pr_default ;
}

final  class protocoldlt__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P002J2", "DELETE FROM Protocolo  WHERE ProtID = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

