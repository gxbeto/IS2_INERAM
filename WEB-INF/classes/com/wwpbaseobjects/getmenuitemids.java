package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmenuitemids extends GXProcedure
{
   public getmenuitemids( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmenuitemids.class ), "" );
   }

   public getmenuitemids( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Short> executeUdp( short aP0 )
   {
      getmenuitemids.this.aP1 = new GXSimpleCollection[] {new GXSimpleCollection<Short>(Short.class, "internal", "")};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        GXSimpleCollection<Short>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             GXSimpleCollection<Short>[] aP1 )
   {
      getmenuitemids.this.AV8MenuItemId = aP0;
      getmenuitemids.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      /* Using cursor P00282 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8MenuItemId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11MenuItemFatherId = P00282_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = P00282_n11MenuItemFatherId[0] ;
         A10MenuItemId = P00282_A10MenuItemId[0] ;
         AV10MenuItemIdCollection.add((short)(A10MenuItemId), 0);
         GXt_objcol_int1 = AV11MenuItemIdCollectionAux ;
         GXv_objcol_int2[0] = GXt_objcol_int1 ;
         new com.wwpbaseobjects.getmenuitemids(remoteHandle, context).execute( A10MenuItemId, GXv_objcol_int2) ;
         GXt_objcol_int1 = GXv_objcol_int2[0] ;
         AV11MenuItemIdCollectionAux = GXt_objcol_int1 ;
         AV13GXV1 = 1 ;
         while ( AV13GXV1 <= AV11MenuItemIdCollectionAux.size() )
         {
            AV9MenuItemIdAux = ((Number) AV11MenuItemIdCollectionAux.elementAt(-1+AV13GXV1)).shortValue() ;
            AV10MenuItemIdCollection.add((short)(AV9MenuItemIdAux), 0);
            AV13GXV1 = (int)(AV13GXV1+1) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getmenuitemids.this.AV10MenuItemIdCollection;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10MenuItemIdCollection = new GXSimpleCollection<Short>(Short.class, "internal", "");
      P00282_A11MenuItemFatherId = new short[1] ;
      P00282_n11MenuItemFatherId = new boolean[] {false} ;
      P00282_A10MenuItemId = new short[1] ;
      AV11MenuItemIdCollectionAux = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXt_objcol_int1 = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int2 = new GXSimpleCollection[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.getmenuitemids__default(),
         new Object[] {
             new Object[] {
            P00282_A11MenuItemFatherId, P00282_n11MenuItemFatherId, P00282_A10MenuItemId
            }
         }
      );
      /* GeneXus formulas. */
   }

   private short AV8MenuItemId ;
   private short A11MenuItemFatherId ;
   private short A10MenuItemId ;
   private short AV9MenuItemIdAux ;
   private int AV13GXV1 ;
   private boolean n11MenuItemFatherId ;
   private GXSimpleCollection<Short> AV10MenuItemIdCollection ;
   private GXSimpleCollection<Short> AV11MenuItemIdCollectionAux ;
   private GXSimpleCollection<Short> GXt_objcol_int1 ;
   private GXSimpleCollection<Short> GXv_objcol_int2[] ;
   private GXSimpleCollection<Short>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P00282_A11MenuItemFatherId ;
   private boolean[] P00282_n11MenuItemFatherId ;
   private short[] P00282_A10MenuItemId ;
}

final  class getmenuitemids__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00282", "SELECT MenuItemFatherId, MenuItemId FROM MenuItem WHERE MenuItemFatherId = ? ORDER BY MenuItemFatherId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
      }
   }

}

