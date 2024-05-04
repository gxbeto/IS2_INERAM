package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loaduserkeyvalue extends GXProcedure
{
   public loaduserkeyvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loaduserkeyvalue.class ), "" );
   }

   public loaduserkeyvalue( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      loaduserkeyvalue.this.aP1 = new String[] {""};
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
      loaduserkeyvalue.this.AV29UserCustomizationsKey = aP0;
      loaduserkeyvalue.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      AV30UserCustomizationsValue = AV28Session.getValue(AV29UserCustomizationsKey) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = loaduserkeyvalue.this.AV30UserCustomizationsValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV30UserCustomizationsValue = "" ;
      AV28Session = httpContext.getWebSession();
      /* GeneXus formulas. */
   }

   private String AV30UserCustomizationsValue ;
   private String AV29UserCustomizationsKey ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP1 ;
}

