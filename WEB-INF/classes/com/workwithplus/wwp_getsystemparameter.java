package com.workwithplus ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getsystemparameter extends GXProcedure
{
   public wwp_getsystemparameter( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getsystemparameter.class ), "" );
   }

   public wwp_getsystemparameter( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      wwp_getsystemparameter.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      wwp_getsystemparameter.this.AV8WWPParameterKey = aP0;
      wwp_getsystemparameter.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      /* Using cursor P00202 */
      pr_default.execute(0, new Object[] {AV8WWPParameterKey});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A4WWPParameterKey = P00202_A4WWPParameterKey[0] ;
         A5WWPParameterValue = P00202_A5WWPParameterValue[0] ;
         AV9WWPParameterValue = A5WWPParameterValue ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_getsystemparameter.this.AV9WWPParameterValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9WWPParameterValue = "" ;
      P00202_A4WWPParameterKey = new String[] {""} ;
      P00202_A5WWPParameterValue = new String[] {""} ;
      A4WWPParameterKey = "" ;
      A5WWPParameterValue = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.workwithplus.wwp_getsystemparameter__default(),
         new Object[] {
             new Object[] {
            P00202_A4WWPParameterKey, P00202_A5WWPParameterValue
            }
         }
      );
      /* GeneXus formulas. */
   }

   private String AV9WWPParameterValue ;
   private String A5WWPParameterValue ;
   private String AV8WWPParameterKey ;
   private String A4WWPParameterKey ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00202_A4WWPParameterKey ;
   private String[] P00202_A5WWPParameterValue ;
}

final  class wwp_getsystemparameter__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00202", "SELECT WWPParameterKey, WWPParameterValue FROM WWP_Parameter WHERE WWPParameterKey = ( ?) ORDER BY WWPParameterKey ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
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
               stmt.setVarchar(1, (String)parms[0], 300);
               return;
      }
   }

}

