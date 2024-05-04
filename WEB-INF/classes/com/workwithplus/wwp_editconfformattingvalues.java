package com.workwithplus ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.workwithplus.wwp_editconfformattingvalues", "/com.workwithplus.wwp_editconfformattingvalues"})
public final  class wwp_editconfformattingvalues extends GXWebPanelStub
{
   public wwp_editconfformattingvalues( )
   {
   }

   public wwp_editconfformattingvalues( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_editconfformattingvalues.class ));
   }

   public wwp_editconfformattingvalues( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_editconfformattingvalues_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_editconfformattingvalues_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Settings";
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

