/*
 * Copyright (c) 2010 e.e d3si9n
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
 
package org.scalaxb.compiler.xsd

abstract class XsTypeSymbol(val name: String) extends scala.xml.TypeSymbol {
  override def toString(): String = {
    name 
  }  
}

object XsAny extends XsTypeSymbol("scala.xml.Node") {}
object XsInterNamespace extends XsTypeSymbol("XsInterNamespace") {}
object XsDataRecord extends XsTypeSymbol("XsDataRecord") {}
object XsAnyAttribute extends XsTypeSymbol("XsAnyAttribute") {}
object XsMixed extends XsTypeSymbol("XsMixed") {}

class ReferenceTypeSymbol(name: String) extends XsTypeSymbol(name) {
  var decl: TypeDecl = null
  override def toString(): String = {
    if (decl == null)
      "ReferenceTypeSymbol(" + name + ",null)"
    else
      "ReferenceTypeSymbol(" + name + "," + decl.toString + ")"
  }
}

object ReferenceTypeSymbol {
  def unapply(value: ReferenceTypeSymbol): Option[TypeDecl] = Some(value.decl)
}

class BuiltInSimpleTypeSymbol(name: String) extends XsTypeSymbol(name)

abstract class DerivSym
case class Extends(sym: XsTypeSymbol) extends DerivSym
case class Restricts(sym: XsTypeSymbol) extends DerivSym

object XsUnknown          extends BuiltInSimpleTypeSymbol("String") {}
object XsDuration         extends BuiltInSimpleTypeSymbol("javax.xml.datatype.Duration") {}
object XsDateTime         extends BuiltInSimpleTypeSymbol("java.util.GregorianCalendar") {}
object XsTime             extends BuiltInSimpleTypeSymbol("java.util.GregorianCalendar") {}
object XsDate             extends BuiltInSimpleTypeSymbol("java.util.GregorianCalendar") {}
object XsGYearMonth       extends BuiltInSimpleTypeSymbol("java.util.GregorianCalendar") {}
object XsGYear            extends BuiltInSimpleTypeSymbol("java.util.GregorianCalendar") {}
object XsGDay             extends BuiltInSimpleTypeSymbol("java.util.GregorianCalendar") {}
object XsGMonth           extends BuiltInSimpleTypeSymbol("java.util.GregorianCalendar") {}
object XsBoolean          extends BuiltInSimpleTypeSymbol("Boolean") {}
object XsFloat            extends BuiltInSimpleTypeSymbol("Float") {}
object XsBase64Binary     extends BuiltInSimpleTypeSymbol("Array[Byte]") {}
object XsHexBinary        extends BuiltInSimpleTypeSymbol("HexBinary") {}
object XsDouble           extends BuiltInSimpleTypeSymbol("Double") {}
object XsAnyURI           extends BuiltInSimpleTypeSymbol("java.net.URI") {}
object XsQName            extends BuiltInSimpleTypeSymbol("javax.xml.namespace.QName") {}
object XsNOTATION         extends BuiltInSimpleTypeSymbol("javax.xml.namespace.QName") {}
object XsString           extends BuiltInSimpleTypeSymbol("String") {}
object XsNormalizedString extends BuiltInSimpleTypeSymbol("String") {}
object XsToken            extends BuiltInSimpleTypeSymbol("String") {}
object XsLanguage         extends BuiltInSimpleTypeSymbol("String") {}
object XsName             extends BuiltInSimpleTypeSymbol("String") {}
object XsNMTOKEN          extends BuiltInSimpleTypeSymbol("String") {}
object XsNMTOKENS         extends BuiltInSimpleTypeSymbol("Array[String]") {}
object XsNCName           extends BuiltInSimpleTypeSymbol("String") {}
object XsID               extends BuiltInSimpleTypeSymbol("String") {}
object XsIDREF            extends BuiltInSimpleTypeSymbol("String") {}
object XsIDREFS           extends BuiltInSimpleTypeSymbol("Array[String]") {}
object XsENTITY           extends BuiltInSimpleTypeSymbol("String") {}
object XsENTITIES         extends BuiltInSimpleTypeSymbol("Array[String]") {}
object XsDecimal          extends BuiltInSimpleTypeSymbol("BigDecimal") {}
object XsInteger          extends BuiltInSimpleTypeSymbol("Int") {} // BigInt
object XsNonPositiveInteger extends BuiltInSimpleTypeSymbol("Int") {} // BigInt
object XsNegativeInteger    extends BuiltInSimpleTypeSymbol("Int") {} // BigInt
object XsNonNegativeInteger extends BuiltInSimpleTypeSymbol("Int") {} // BigInt
object XsPositiveInteger    extends BuiltInSimpleTypeSymbol("Int") {} // BigInt
object XsLong             extends BuiltInSimpleTypeSymbol("Long") {}
object XsUnsignedLong     extends BuiltInSimpleTypeSymbol("BigInt") {}
object XsInt              extends BuiltInSimpleTypeSymbol("Int") {}
object XsUnsignedInt      extends BuiltInSimpleTypeSymbol("Long") {}
object XsShort            extends BuiltInSimpleTypeSymbol("Short") {}
object XsUnsignedShort    extends BuiltInSimpleTypeSymbol("Int") {}
object XsByte             extends BuiltInSimpleTypeSymbol("Byte") {}
object XsUnsignedByte     extends BuiltInSimpleTypeSymbol("Int") {}

object XsTypeSymbol {
  def toTypeSymbol(value: String) = value match {
    case "anyType"        => XsAny
    case "duration"       => XsDuration
    case "dateTime"       => XsDateTime
    case "time"           => XsTime
    case "date"           => XsDate
    case "gYearMonth"     => XsGYearMonth
    case "gYear"          => XsGYear
    case "gDay"           => XsGDay
    case "gMonth"         => XsGMonth
    case "boolean"        => XsBoolean
    case "float"          => XsFloat
    case "base64Binary"   => XsBase64Binary
    case "hexBinary"      => XsHexBinary
    case "double"         => XsDouble
    case "anyURI"         => XsAnyURI
    case "QName"          => XsQName
    case "NOTATION"       => XsNOTATION
    case "string"         => XsString
    case "normalizedString" => XsNormalizedString
    case "token"          => XsToken
    case "language"       => XsLanguage
    case "name"           => XsName
    case "NMTOKEN"        => XsNMTOKEN
    case "NMTOKENS"       => XsNMTOKENS
    case "NCName"         => XsNCName
    case "ID"             => XsID
    case "IDREF"          => XsIDREF
    case "IDREFS"         => XsIDREFS
    case "ENTITY"         => XsENTITY
    case "ENTITIES"       => XsENTITIES
    case "decimal"        => XsDecimal
    case "integer"        => XsInteger
    case "nonPositiveInteger" => XsNonPositiveInteger
    case "negativeInteger" => XsNegativeInteger
    case "nonNegativeInteger" => XsNonNegativeInteger
    case "positiveInteger" => XsPositiveInteger
    case "long"           => XsLong
    case "unsignedLong"   => XsUnsignedLong
    case "int"            => XsInt
    case "unsignedInt"    => XsUnsignedInt
    case "short"          => XsShort
    case "unsignedShort"  => XsUnsignedShort
    case "byte"           => XsByte
    case "unsignedByte"   => XsUnsignedByte
    case _                => XsUnknown  
  }  
}
