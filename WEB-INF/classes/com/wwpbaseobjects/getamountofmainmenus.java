package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getamountofmainmenus extends GXProcedure
{
   public getamountofmainmenus( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getamountofmainmenus.class ), "" );
   }

   public getamountofmainmenus( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 )
   {
      getamountofmainmenus.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             short[] aP1 )
   {
      getamountofmainmenus.this.AV8MainMenuItemCaption = aP0;
      getamountofmainmenus.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      /* Using cursor P00233 */
      pr_default.execute(0, new Object[] {AV8MainMenuItemCaption});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000GXC1 = P00233_A40000GXC1[0] ;
         n40000GXC1 = P00233_n40000GXC1[0] ;
      }
      else
      {
         A40000GXC1 = 0 ;
         n40000GXC1 = false ;
      }
      pr_default.close(0);
      AV9Count = (short)(A40000GXC1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getamountofmainmenus.this.AV9Count;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      P00233_A40000GXC1 = new int[1] ;
      P00233_n40000GXC1 = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.getamountofmainmenus__default(),
         new Object[] {
             new Object[] {
            P00233_A40000GXC1, P00233_n40000GXC1
            }
         }
      );
      /* GeneXus formulas. */
   }

   private short AV9Count ;
   private int A40000GXC1 ;
   private boolean n40000GXC1 ;
   private String AV8MainMenuItemCaption ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00233_A40000GXC1 ;
   private boolean[] P00233_n40000GXC1 ;
}

final  class getamountofmainmenus__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00233", "SELECT COALESCE( T1.GXC1, 0) AS GXC1 FROM (SELECT COUNT(*) AS GXC1 FROM MenuItem WHERE (MenuItemFatherId IS NULL) AND (MenuItemCaption = ( ?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
      }
   }

}

