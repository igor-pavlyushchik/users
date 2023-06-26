{{/* Labels according to subtask 2 from module 4 */}}
{{- define "user-database-labels" }}
  labels:
    generator: helm
    date: {{ now | htmlDate }}
    version: {{ .Chart.Version }}
    app: user-database-configmap
{{- end }}