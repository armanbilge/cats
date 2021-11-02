shopt -s globstar
scala3-compiler -J-verbose:gc -J-Xmx1G -J-XX:+HeapDumpOnOutOfMemoryError -J-XX:HeapDumpPath=dump.hprof -Ykind-projector:underscores kernel/src/main/scala/**/*.scala 