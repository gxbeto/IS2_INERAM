package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.home", "/com.home"})
public final  class home extends GXWebPanelStub
{
   public home( )
   {
   }

   public home( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( home.class ));
   }

   public home( int remoteHandle ,
                ModelContext context )
   {
      super(remoteHandle, context);
   }

   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.GXcfg.class);
      com.home_impl pgm = new com.home_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new home_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new home_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Inicio";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

