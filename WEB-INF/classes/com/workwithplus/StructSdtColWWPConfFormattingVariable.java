package com.workwithplus ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColWWPConfFormattingVariable", namespace ="Gregory")
public final  class StructSdtColWWPConfFormattingVariable implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPConfFormattingVariable( )
   {
      this( -1, new ModelContext( StructSdtColWWPConfFormattingVariable.class ));
   }

   public StructSdtColWWPConfFormattingVariable( int remoteHandle ,
                                                 ModelContext context )
   {
   }

   public  StructSdtColWWPConfFormattingVariable( java.util.Vector<StructSdtWWPConfFormattingVariable> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="WWPConfFormattingVariable",namespace="Gregory")
   public java.util.Vector<StructSdtWWPConfFormattingVariable> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPConfFormattingVariable> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPConfFormattingVariable> item = new java.util.Vector<>();
}

