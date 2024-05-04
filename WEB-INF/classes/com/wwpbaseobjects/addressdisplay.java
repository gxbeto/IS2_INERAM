package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.addressdisplay", "/com.wwpbaseobjects.addressdisplay"})
public final  class addressdisplay extends GXWebPanelStub
{
   public addressdisplay( )
   {
   }

   public addressdisplay( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( addressdisplay.class ));
   }

   public addressdisplay( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new addressdisplay_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new addressdisplay_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Mapa";
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

