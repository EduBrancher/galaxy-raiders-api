package galaxyraiders.core.physics

import kotlin.math.*

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    return INVALID_POINT
  }

  operator fun plus(v: Vector2D): Point2D {
    return INVALID_POINT
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return INVALID_VECTOR
  }

  fun impactVector(p: Point2D): Vector2D {
    val x = this.x - p.x
    val y = this.y - p.y
    return Vector2D(x, y)
  }

  fun impactDirection(p: Point2D): Vector2D {
    val v = this.impactVector(p)
    return v.unit
  }

  fun contactVector(p: Point2D): Vector2D {
    val v = this.impactVector(p)
    return v.normal
  }

  fun contactDirection(p: Point2D): Vector2D {
    val v = this.impactDirection(p)
    return v.normal
  }

  fun distance(p: Point2D): Double {
    return (p.x.pow(2) + p.y.pow(2)).pow(0.5)
  }
}
