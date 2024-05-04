package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class savegridstate extends GXProcedure
{
   public savegridstate( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( savegridstate.class ), "" );
   }

   public savegridstate( int remoteHandle ,
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
      savegridstate.this.AV8UserCustomKey = aP0;
      savegridstate.this.AV9UserCustomValue = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      new com.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( AV8UserCustomKey, AV9UserCustomValue) ;
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
      /* GeneXus formulas. */
   }

   private String AV8UserCustomKey ;
   private String AV9UserCustomValue ;
}

