package com ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class protocolins extends GXProcedure
{
   public protocolins( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( protocolins.class ), "" );
   }

   public protocolins( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 ,
                        long aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( long aP0 ,
                             long aP1 )
   {
      protocolins.this.AV8EnfID = aP0;
      protocolins.this.AV12num = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Protocolo

      */
      A1EnfID = AV8EnfID ;
      n1EnfID = false ;
      A23CntdID = AV12num ;
      n23CntdID = false ;
      /* Using cursor P002K2 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(n1EnfID), Long.valueOf(A1EnfID), Boolean.valueOf(n23CntdID), Long.valueOf(A23CntdID)});
      /* Retrieving last key number assigned */
      /* Using cursor P002K3 */
      pr_default.execute(1);
      A25ProtID = P002K3_A25ProtID[0] ;
      pr_default.close(1);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Protocolo");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      Application.commitDataStores(context, remoteHandle, pr_default, "protocolins");
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
      P002K3_A25ProtID = new long[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.protocolins__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P002K3_A25ProtID
            }
         }
      );
      /* GeneXus formulas. */
   }

   private short Gx_err ;
   private int GX_INS5 ;
   private long AV8EnfID ;
   private long AV12num ;
   private long A1EnfID ;
   private long A23CntdID ;
   private long A25ProtID ;
   private String Gx_emsg ;
   private boolean n1EnfID ;
   private boolean n23CntdID ;
   private IDataStoreProvider pr_default ;
   private long[] P002K3_A25ProtID ;
}

final  class protocolins__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P002K2", "SAVEPOINT gxupdate;INSERT INTO Protocolo(EnfID, CntdID, ProtOrd, ProtTxt) VALUES(?, ?, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P002K3", "SELECT currval('ProtID') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(2, ((Number) parms[3]).longValue());
               }
               return;
      }
   }

}

