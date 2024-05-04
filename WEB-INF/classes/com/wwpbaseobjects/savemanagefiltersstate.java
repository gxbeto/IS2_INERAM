package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class savemanagefiltersstate extends GXProcedure
{
   public savemanagefiltersstate( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( savemanagefiltersstate.class ), "" );
   }

   public savemanagefiltersstate( int remoteHandle ,
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
      savemanagefiltersstate.this.AV9UserCustomKey = aP0;
      savemanagefiltersstate.this.AV10UserCustomValue = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      new com.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( AV9UserCustomKey, AV10UserCustomValue) ;
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

   private String AV9UserCustomKey ;
   private String AV10UserCustomValue ;
}

