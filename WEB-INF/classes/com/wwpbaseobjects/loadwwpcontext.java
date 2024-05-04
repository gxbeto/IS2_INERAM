package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loadwwpcontext extends GXProcedure
{
   public loadwwpcontext( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loadwwpcontext.class ), "" );
   }

   public loadwwpcontext( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.SdtWWPContext executeUdp( )
   {
      loadwwpcontext.this.aP0 = new com.wwpbaseobjects.SdtWWPContext[] {new com.wwpbaseobjects.SdtWWPContext()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( com.wwpbaseobjects.SdtWWPContext[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( com.wwpbaseobjects.SdtWWPContext[] aP0 )
   {
      loadwwpcontext.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      AV8Context.fromxml(AV9Session.getValue("wwpcontext"), null, null);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = loadwwpcontext.this.AV8Context;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Context = new com.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      AV9Session = httpContext.getWebSession();
      /* GeneXus formulas. */
   }

   private com.genexus.webpanels.WebSession AV9Session ;
   private com.wwpbaseobjects.SdtWWPContext[] aP0 ;
   private com.wwpbaseobjects.SdtWWPContext AV8Context ;
}

