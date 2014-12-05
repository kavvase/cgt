package kavvase.cgt.benchmark

import com.google.caliper.runner.CaliperMain

object CGTRunner {

  def main(args: Array[String]) {
    CaliperMain.main(classOf[CGTBenchmark], args)
  }

}
