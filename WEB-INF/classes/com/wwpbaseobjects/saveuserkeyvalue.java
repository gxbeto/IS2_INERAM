package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class saveuserkeyvalue extends GXProcedure
{
   public saveuserkeyvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( saveuserkeyvalue.class ), "" );
   }

   public saveuserkeyvalue( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      saveuserkeyvalue.this.AV26UserCustomizationsKey = aP0;
      saveuserkeyvalue.this.AV27UserCustomizationsValue = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      if ( (GXutil.strcmp("", AV27UserCustomizationsValue)==0) )
      {
         AV25Session.remove(AV26UserCustomizationsKey);
      }
      else
      {
         AV25Session.setValue(AV26UserCustomizationsKey, AV27UserCustomizationsValue);
      }
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
      AV25Session = httpContext.getWebSession();
      /* GeneXus formulas. */
   }

   private String AV27UserCustomizationsValue ;
   private String AV26UserCustomizationsKey ;
   private com.genexus.webpanels.WebSession AV25Session ;
}

