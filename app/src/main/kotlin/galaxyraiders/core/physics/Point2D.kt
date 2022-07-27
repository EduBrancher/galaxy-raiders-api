
package galaxyraiders.core.physics

import kotlin.math.sqrt

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    return Point2D(this.x + p.x, this.y + p.y)
  }

  operator fun plus(v: Vector2D): Point2D {
    return Point2D(this.x + v.dx, this.y + v.dy)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(this.x, this.y)
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D(p.x - this.x, p.y - this.y)
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
    val dx = this.x - p.x
    val dy = this.y - p.y
    return sqrt(dx * dx + dy * dy)
  }
}
