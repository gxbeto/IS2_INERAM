package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loadmenutreeview extends GXProcedure
{
   public loadmenutreeview( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loadmenutreeview.class ), "" );
   }

   public loadmenutreeview( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.SdtTreeNodeCollection_TreeNode> executeUdp( short aP0 )
   {
      loadmenutreeview.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>[] aP1 )
   {
      loadmenutreeview.this.AV5MenuItemId = aP0;
      loadmenutreeview.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV5MenuItemId) ,
                                           Short.valueOf(A11MenuItemFatherId) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor P00082 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV5MenuItemId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11MenuItemFatherId = P00082_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = P00082_n11MenuItemFatherId[0] ;
         A10MenuItemId = P00082_A10MenuItemId[0] ;
         A12MenuItemCaption = P00082_A12MenuItemCaption[0] ;
         Gxm1treenodecollection = (com.SdtTreeNodeCollection_TreeNode)new com.SdtTreeNodeCollection_TreeNode(remoteHandle, context);
         Gxm2rootcol.add(Gxm1treenodecollection, 0);
         Gxm1treenodecollection.setgxTv_SdtTreeNodeCollection_TreeNode_Id( GXutil.str( A10MenuItemId, 4, 0) );
         Gxm1treenodecollection.setgxTv_SdtTreeNodeCollection_TreeNode_Name( A12MenuItemCaption );
         Gxm1treenodecollection.setgxTv_SdtTreeNodeCollection_TreeNode_Expanded( true );
         GXt_objcol_SdtTreeNodeCollection_TreeNode1 = new GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>() ;
         GXv_objcol_SdtTreeNodeCollection_TreeNode2[0] = GXt_objcol_SdtTreeNodeCollection_TreeNode1 ;
         new com.wwpbaseobjects.loadmenutreeview(remoteHandle, context).execute( A10MenuItemId, GXv_objcol_SdtTreeNodeCollection_TreeNode2) ;
         GXt_objcol_SdtTreeNodeCollection_TreeNode1 = GXv_objcol_SdtTreeNodeCollection_TreeNode2[0] ;
         Gxm1treenodecollection.setgxTv_SdtTreeNodeCollection_TreeNode_Nodes( GXt_objcol_SdtTreeNodeCollection_TreeNode1 );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = loadmenutreeview.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>(com.SdtTreeNodeCollection_TreeNode.class, "TreeNode", "Gregory", remoteHandle);
      P00082_A11MenuItemFatherId = new short[1] ;
      P00082_n11MenuItemFatherId = new boolean[] {false} ;
      P00082_A10MenuItemId = new short[1] ;
      P00082_A12MenuItemCaption = new String[] {""} ;
      A12MenuItemCaption = "" ;
      Gxm1treenodecollection = new com.SdtTreeNodeCollection_TreeNode(remoteHandle, context);
      GXt_objcol_SdtTreeNodeCollection_TreeNode1 = new GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>(com.SdtTreeNodeCollection_TreeNode.class, "TreeNode", "Gregory", remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.loadmenutreeview__default(),
         new Object[] {
             new Object[] {
            P00082_A11MenuItemFatherId, P00082_n11MenuItemFatherId, P00082_A10MenuItemId, P00082_A12MenuItemCaption
            }
         }
      );
      /* GeneXus formulas. */
      initializeGenerics();
   }

   @SuppressWarnings("unchecked")
   private void initializeGenerics( )
   {
      GXv_objcol_SdtTreeNodeCollection_TreeNode2 = new GXBaseCollection[1] ;
   }

   private short AV5MenuItemId ;
   private short A11MenuItemFatherId ;
   private short A10MenuItemId ;
   private boolean n11MenuItemFatherId ;
   private String A12MenuItemCaption ;
   private GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P00082_A11MenuItemFatherId ;
   private boolean[] P00082_n11MenuItemFatherId ;
   private short[] P00082_A10MenuItemId ;
   private String[] P00082_A12MenuItemCaption ;
   private GXBaseCollection<com.SdtTreeNodeCollection_TreeNode> Gxm2rootcol ;
   private GXBaseCollection<com.SdtTreeNodeCollection_TreeNode> GXt_objcol_SdtTreeNodeCollection_TreeNode1 ;
   private GXBaseCollection<com.SdtTreeNodeCollection_TreeNode> GXv_objcol_SdtTreeNodeCollection_TreeNode2[] ;
   private com.SdtTreeNodeCollection_TreeNode Gxm1treenodecollection ;
}

final  class loadmenutreeview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00082( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV5MenuItemId ,
                                          short A11MenuItemFatherId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[1];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT MenuItemFatherId, MenuItemId, MenuItemCaption FROM MenuItem" ;
      if ( AV5MenuItemId > 0 )
      {
         addWhere(sWhereString, "(MenuItemFatherId = ?)");
      }
      else
      {
         GXv_int3[0] = (byte)(1) ;
      }
      if ( AV5MenuItemId == 0 )
      {
         addWhere(sWhereString, "(MenuItemFatherId IS NULL or (MenuItemFatherId = 0))");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MenuItemId" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00082(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00082", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}

