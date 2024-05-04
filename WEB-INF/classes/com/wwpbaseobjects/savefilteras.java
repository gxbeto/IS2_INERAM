package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.savefilteras", "/com.wwpbaseobjects.savefilteras"})
public final  class savefilteras extends GXWebPanelStub
{
   public savefilteras( )
   {
   }

   public savefilteras( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( savefilteras.class ));
   }

   public savefilteras( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new savefilteras_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new savefilteras_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Guardar filtro como...";
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

